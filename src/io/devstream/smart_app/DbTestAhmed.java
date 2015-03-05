package io.devstream.smart_app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class DbTestAhmed extends Activity {
	ListView mainList;
	private final String TAG = "DbTestAhmed";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.db_testing_universal_view_for_list);
		mainList = (ListView) findViewById(R.id.db_testing_list_view);
		mainList.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,new ArrayList<String>()));
		new LongOperation().execute("appointments");
	}
	
	private class LongOperation extends AsyncTask<String, String, String> {
		
		private String url = EnumCredentials.URL.getCredential();
		private String AuthToken = SingletonUser.getSingletonInstance().getAuthToken();
		private  String apiKey = EnumCredentials.API_KEY.getCredential();
		private URL dbLookup;
		private HttpURLConnection con;
		private StringBuffer response;
		private ArrayAdapter<String> adapter;
		
		
		@Override
		protected void onPreExecute() {
			Log.d(TAG, "in LongOperation onPreExecute()");
			response = new StringBuffer();
			adapter = (ArrayAdapter<String>)mainList.getAdapter();
		}

		@Override
		protected String doInBackground(String... params) {
			Log.d(TAG, "in LongOperation doInBackground");
			try {
				dbLookup = new URL(url+params[0]);
			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				con = (HttpURLConnection) dbLookup.openConnection();
				Log.d(TAG, params[0] + ".openConnection");
				con.setRequestMethod("GET");

				// add request header
				con.setRequestProperty("Api-Key", apiKey);
				Log.d(TAG, "Api-Key: " + apiKey);

				con.setRequestProperty("Auth-Token", AuthToken);
				Log.d(TAG, "authtoken: " + AuthToken);

				int responseCode = con.getResponseCode();
				Log.d(TAG, "Response Code: " + responseCode);
				
				Log.d(TAG, "Sending 'GET' request to URL : " + dbLookup);
				BufferedReader in = new BufferedReader(new InputStreamReader(
						con.getInputStream()));

				String inputLine;
				while ((inputLine = in.readLine()) != null) {
					publishProgress(inputLine);
				}
				Log.d(TAG, "finished for loop");

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return response.toString();

		}

		@Override
		protected void onProgressUpdate(String... values) {
			response.append(values[0]);
		}
		
		@Override
		protected void onPostExecute(String result) {
			try {
				JSONObject jo = new JSONObject(result);
				JSONArray ja = jo.getJSONArray("appointments");
				
				for(int i = 0;i<ja.length();i++){
					String suid = String.valueOf(((JSONObject) ja.get(i)).get("service_user_id"));
					adapter.add(suid);
				}
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}


	}

}
