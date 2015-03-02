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
	String jaja;
	
	
	public QueryDB(String query) {
		this.query = query;
	}
	
	public void getResult(){
		try {
			dbLookup = new URL(url+query);
			Log.d(TAG,dbLookup.toString());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Log.d(TAG,"starting LongOperation with "+dbLookup);
		new LongOperation().execute(dbLookup);
	}
	
	public String getJaja(){
		Log.d(TAG,"in getJaja");
		return jaja;
	}
	
	
	private class LongOperation extends AsyncTask<URL, String, String> {
		
		@Override
		protected void onPreExecute() {
			response = new StringBuffer();
			Log.d(TAG,"in onPreExecute, StringBuffer created");
		}

		@Override
		protected String doInBackground(URL... params) {
			Log.d(TAG,"in doInBackground");
			try {
				con = (HttpURLConnection) params[0].openConnection();
				Log.d(TAG,params[0]+".openConnection");
				con.setRequestMethod("GET");

				// add request header
				con.setRequestProperty("Api-Key", apiKey);
				Log.d(TAG,"Api-Key: " + apiKey);
				
				con.setRequestProperty("Auth-Token", AuthToken);
				Log.d(TAG,"authtoken: " + AuthToken);
				
				int responseCode = con.getResponseCode();
				Log.d(TAG, "\nSending 'GET' request to URL : " + dbLookup);
				Log.d(TAG, "Response Code: " + responseCode);
				
				BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
				
				String inputLine;
				while ((inputLine = in.readLine()) != null) {
					Log.d(TAG,inputLine);
					publishProgress(inputLine);
				}
				Log.d(TAG,"finished for loop");
				
				
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
			Log.d(TAG,"in onPostExecute");
			jaja = result;
		}
		
		
		
		
		
	
	}
	
	

}
