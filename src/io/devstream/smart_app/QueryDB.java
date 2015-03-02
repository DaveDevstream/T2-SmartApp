package io.devstream.smart_app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import android.os.AsyncTask;
import android.util.Log;

public class QueryDB {
	
	private String query;	
	private final static String url = EnumCredentials.URL.getCredential();
	private final static String AuthToken = SingletonUser.getSingletonInstance().getAuthToken();
	private final static String apiKey = EnumCredentials.API_KEY.getCredential();
	private URL dbLookup;
	private HttpURLConnection con;
	private final static String TAG = "QueryDB";
	StringBuffer response;
	
	public QueryDB(String query) {
		this.query = query;
	}
	
	public StringBuffer getResult(){
		try {
			dbLookup = new URL(url+query);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new LongOperation().equals(dbLookup);
		Log.i(TAG,response.toString());
		return response;
	}
	
	private class LongOperation extends AsyncTask<URL, String, Void> {
		
		@Override
		protected void onPreExecute() {
			response = new StringBuffer();
		}

		@Override
		protected Void doInBackground(URL... params) {
			try {
				con = (HttpURLConnection) params[0].openConnection();
				con.setRequestMethod("GET");

				// add request header
				con.setRequestProperty("Api-Key", apiKey);
				con.setRequestProperty("Auth-Token", AuthToken);
				
				int responseCode = con.getResponseCode();
				Log.d(TAG, "\nSending 'GET' request to URL : " + dbLookup);
				Log.d(TAG, "Response Code: " + responseCode);
				
				BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
				
				String inputLine;
				while ((inputLine = in.readLine()) != null) {
					publishProgress(inputLine);
				}
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
			
			
		}
		
		@Override
		protected void onProgressUpdate(String... values) {
			response.append(values[0]);
		}
		
		
		
		
		
	
	}
	
	

}
