package io.devstream.smart_app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class DbTestDave extends Activity {

	private ListView mainList;
	private final String TAG = "DbTestDave";
	private ArrayList<Appointment> appointmentsArray;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.db_testing_universal_view_for_list);
		
		appointmentsArray = new ArrayList<Appointment>();
		
		mainList = (ListView) findViewById(R.id.db_testing_list_view);
		mainList.setAdapter(new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, new ArrayList<String>()));
		new LongOperation().execute("appointments");
	}

	private class LongOperation extends AsyncTask<String, String, String> {

		private String url = EnumCredentials.URL.getCredential();
		private String AuthToken = SingletonUser.getSingletonInstance()
				.getAuthToken();
		private String apiKey = EnumCredentials.API_KEY.getCredential();
		private URL dbLookup;
		private HttpURLConnection con;
		private StringBuffer response;
		private ArrayAdapter<String> adapter;

		@Override
		protected void onPreExecute() {
			Log.d(TAG, "in LongOperation onPreExecute()");
			response = new StringBuffer();
			adapter = (ArrayAdapter<String>) mainList.getAdapter();
		}

		@Override
		protected String doInBackground(String... params) {
			Log.d(TAG, "in LongOperation doInBackground");
			try {
				dbLookup = new URL(url + params[0]);
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
				/*
				 * JSONObject jo = new JSONObject(result); JSONArray ja =
				 * jo.getJSONArray("appointments");
				 */

				/*
				 * for(int i = 0;i<ja.length();i++){ String suid =
				 * String.valueOf(((JSONObject)
				 * ja.get(i)).get("service_user_id")); adapter.add(suid); }
				 */

				JSONObject jsonObject = new JSONObject(result);
				JSONArray allAppointments = jsonObject
						.getJSONArray("appointments");

				for (int i = 0; i < allAppointments.length(); i++) {
					
					Appointment appointment = new Appointment();
					JSONObject jsonAppointment = allAppointments.getJSONObject(i);
					
					//clinic_id
					int clinic_id = jsonAppointment.getInt("clinic_id");
					
					
					//date
					String date = (String) jsonAppointment.get("date");
					appointment.setDateString(date);
					
					//appointment id
					int appointmentId = (Integer) jsonAppointment.get("id");
					appointment.setappointmentId(appointmentId);
					
					//links
					//String service_options = ((JSONObject) jsonAppointment.get("links")).getString("service_options");
					JSONObject jsonLinks = jsonAppointment.getJSONObject("links");
					String service_options = jsonLinks.getString("service_options");
					String service_provider = jsonLinks.getString("service_provider");
					String service_user = jsonLinks.getString("service_user");
					
					//priority
					String priority = jsonAppointment.getString("priority");
					
					//service_option_ids
					
					JSONArray service_option_ids =  jsonAppointment.getJSONArray("service_option_ids");
					int [] service_option_ids_array = new int [service_option_ids.length()];
					for(int i1 = 0; i1<service_option_ids.length();i1++){
						service_option_ids_array[i1] = service_option_ids.getInt(i1);
					}
					//wrong
					//int [] service_option_ids =  (int[]) jsonAppointment.get("service_option_ids");
					
					//service_provider_id
					int service_provider_id = (Integer) jsonAppointment.get("service_provider_id");
					appointment.setService_provider_id(service_provider_id);
					
					
					//service_user
					JSONObject jsonServiceUserData = jsonAppointment.getJSONObject("service_user");
					String gestation = jsonServiceUserData.getString("gestation");
					int serviceUserId = jsonServiceUserData.getInt("id");
					String name = jsonServiceUserData.getString("name");
					
					
					//service_user_id note:this is a duplicate from the service user data
					int service_user_id = (Integer) jsonAppointment.get("service_user_id");
					appointment.setService_user_id(service_user_id);
					
					
					//time
					String time = jsonAppointment.getString("time");
					
					//visit logs
					//int [] visit_logs = (int[]) jsonAppointment.get("visit_logs");
					
					JSONArray visit_logs =  jsonAppointment.getJSONArray("visit_logs");
					int [] visit_logs_array = new int [visit_logs.length()];
					for(int i1 = 0; i1<visit_logs.length();i1++){
						visit_logs_array[i1] = visit_logs.getInt(i1);
					}
					
					
					//visit type
					String visit_type = jsonAppointment.getString("visit_type");
					
					String totalinfo =
							"clinic id: "+clinic_id+"\n"
							+"date: "+date+"\n"
							+"appointment id: "+appointmentId+"\n"
							+"......\nAPI CALLS\n......"+"\n"
							+"service options: "+service_options+"\n"
							+"service provider: "+service_provider+"\n"
							+"service user: "+service_user+"\n"
							+".......\n"
							+"priority: "+priority+"\n"
							+"service option ids: "+Arrays.toString(service_option_ids_array)+"\n"
							+"service provider id: "+service_provider_id+"\n"
							+"gestation: "+gestation+"\n"
							+"service user id: "+serviceUserId+"\n"
							+"name: "+name+"\n"
							+"service user id (dupe record): "+service_user_id+"\n"
							+"time: "+time+"\n"
							+"visit logs array: "+Arrays.toString(visit_logs_array)+"\n"
							+"visit type: "+visit_type;
							
					adapter.add(totalinfo); 
				}

			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
