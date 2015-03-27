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

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

public class ServiceOptionsAndClinicsGrabber {

	private final String TAG = "ServiceOptionsGrabber";
	private String[] urlSlugs;
	private Context context;	

	ServiceOptionsAndClinicsGrabber(Context context) {
		this.context = context;
		urlSlugs = new String[] { "service_options", "clinics" };
		new LongOperation().execute(urlSlugs);
	}

	private class LongOperation extends AsyncTask<String, String, String[]> {

		private String url = EnumCredentials.URL.getCredential();
		private String AuthToken = SingletonUser.getSingletonInstance()
				.getAuthToken();
		private String apiKey = EnumCredentials.API_KEY.getCredential();
		private URL dbLookup;
		private HttpURLConnection con;
		private StringBuffer response;
		private String [] arrayOfResponses = new String[2];

		@Override
		protected void onPreExecute() {
			Log.d(TAG, "in LongOperation onPreExecute()");
			response = new StringBuffer();
		}

		@Override
		protected String[] doInBackground(String... params) {
			Log.d(TAG, "in LongOperation doInBackground");

			for (int i = 0; i < urlSlugs.length; i++) {

				try {
					dbLookup = new URL(url + params[i]);
				} catch (MalformedURLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					con = (HttpURLConnection) dbLookup.openConnection();
					Log.d(TAG, "Attempting: " + dbLookup + ".openConnection");
					con.setRequestMethod("GET");

					// add request header
					con.setRequestProperty("Api-Key", apiKey);
					Log.d(TAG, "Api-Key: " + apiKey);

					con.setRequestProperty("Auth-Token", AuthToken);
					Log.d(TAG, "authtoken: " + AuthToken);

					int responseCode = con.getResponseCode();
					Log.d(TAG, "Response Code: " + responseCode);

					Log.d(TAG, "Sending 'GET' request to URL : " + dbLookup);
					BufferedReader in = new BufferedReader(
							new InputStreamReader(con.getInputStream()));

					String inputLine;
					while ((inputLine = in.readLine()) != null) {
						publishProgress(inputLine);
					}
					Log.d(TAG, "finished for loop");
					arrayOfResponses[i] = response.toString();
					response.setLength(0);
					//response.delete(0, response.length());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return arrayOfResponses;
		}

		@Override
		protected void onProgressUpdate(String... values) {
			response.append(values[0]);

		}

		@Override
		protected void onPostExecute(String[] result) {
			Log.d(TAG,"in onPostExecute");
			Log.d(TAG, "result1" + result[0]);
			Log.d(TAG,"result2"+result[1]);
			ArrayList<ServiceOptionsModel> serviceOptionList = new  ArrayList<ServiceOptionsModel>();
			try {

				JSONObject jsonObject = new JSONObject(result[0]);
				JSONArray allServiceOptions = jsonObject.getJSONArray("service_options");
				
				for (int i = 0; i < allServiceOptions.length(); i++) {
					JSONObject jsonServiceOption = allServiceOptions.getJSONObject(i);
					ServiceOptionsModel serviceOption = new ServiceOptionsModel();
					
					//service option id
					int serviceOptionId = jsonServiceOption.getInt("id");
					serviceOption.setServiceOptionId(serviceOptionId);
					
					//service option name
					String serviceOptionName = (String) jsonServiceOption.get("name");
					serviceOption.setServiceOptionName(serviceOptionName);
					
					//service option clinics array
					JSONArray jClinicIds = jsonServiceOption.getJSONArray("clinic_ids");
					int [] clinicIds = new int [jClinicIds.length()];
					for(int j = 0;j<jClinicIds.length();j++){
						clinicIds[j] = jClinicIds.getInt(j);
					}
					serviceOption.setClinicIds(clinicIds);
					
					serviceOptionList.add(serviceOption);
				}
				
			}
			catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ServiceOptionSingleton.getInstance().setServiceOptions(serviceOptionList);
			
			//for the clinic now
			ArrayList<ClinicModel>clinicList = new ArrayList<ClinicModel>();
			try{
				JSONObject jsonObject = new JSONObject(result[1]);
				JSONArray allClinics = jsonObject.getJSONArray("clinics");
				
				for(int k = 0;k<allClinics.length();k++){
					JSONObject jsonClinic = allClinics.getJSONObject(k);
					ClinicModel clinic = new ClinicModel();
					
					//clinic name
					String clinicName = jsonClinic.getString("name");
					clinic.setClinicName(clinicName);
					
					int clinic_id = jsonClinic.getInt("id");
					clinic.setClinic_id(clinic_id);
					
					clinicList.add(clinic);
				}
			}
			catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ClinicSingleton.getInstance().setClinics(clinicList);
			
			Intent davesAct3 = new Intent(context, ServiceOptionPickerActivity.class);
			context.startActivity(davesAct3);
		}

	}

}
