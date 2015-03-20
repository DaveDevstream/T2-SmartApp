package io.devstream.smart_app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;









import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.text.format.DateFormat;
import android.text.format.Time;
import android.util.Log;


public class AppointmentsGrabber{
	
	
	private final String TAG = "AppointmentsGrabber";
	private ArrayList<Appointment> appointmentsArray;
	private String date;
	private int clinicId;
	private String urlSlug;
	private Context context;
	
	AppointmentsGrabber(String date, int clinicId, Context context){
		this.context = context;
		this.date = date;
		this.clinicId = clinicId;
		urlSlug = "appointments?date="+this.date+"&clinic_id="+this.clinicId;
		//urlSlug = "appointments?date=2015-03-24&clinic_id=2";
		//urlSlug = "appointments";
		Log.d(TAG,"attempting Long Operation with url: "+ urlSlug);
		new LongOperation().execute(urlSlug);
	}

	
	private class LongOperation extends AsyncTask<String, String, String> {

		private String url = EnumCredentials.URL.getCredential();
		private String AuthToken = SingletonUser.getSingletonInstance().getAuthToken();
		private String apiKey = EnumCredentials.API_KEY.getCredential();
		private URL dbLookup;
		private HttpURLConnection con;
		private StringBuffer response;
		

		@Override
		protected void onPreExecute() {
			Log.d(TAG, "in LongOperation onPreExecute()");
			response = new StringBuffer();
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
				Log.d(TAG, "Attempting: "+ dbLookup + ".openConnection");
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
			//Log.d(TAG,"oiiiii"+response.toString());
			Log.d(TAG, "eeeee"+result);
			ArrayList<Appointment> appointmentsList = new ArrayList<Appointment>();
			try {

				JSONObject jsonObject = new JSONObject(result);
				JSONArray allAppointments = jsonObject.getJSONArray("appointments");

				for (int i = 0; i < allAppointments.length(); i++) {
					
					Appointment appointment = new Appointment();
					JSONObject jsonAppointment = allAppointments.getJSONObject(i);
					
					//clinic_id
					int clinic_id = jsonAppointment.getInt("clinic_id");
					appointment.setClinic_id(clinic_id);
					
					//date
					String date = (String) jsonAppointment.get("date");
					appointment.setDateString(date);
					
					//appointment id
					int appointmentId = (Integer) jsonAppointment.get("id");
					appointment.setAppointmentId(appointmentId);
					
					//links
					//String service_options = ((JSONObject) jsonAppointment.get("links")).getString("service_options");
					JSONObject jsonLinks = jsonAppointment.getJSONObject("links");
					String service_options = jsonLinks.getString("service_options");
					appointment.setService_options(service_options);
					
					String service_provider = jsonLinks.getString("service_provider");
					appointment.setService_provider(service_provider);
					
					String service_user = jsonLinks.getString("service_user");
					appointment.setService_user(service_user);
					
					//priority
					String priority = jsonAppointment.getString("priority");
					appointment.setPriority(priority);
					
					//service_option_ids
					
					JSONArray service_option_ids =  jsonAppointment.getJSONArray("service_option_ids");
					int [] service_option_ids_array = new int [service_option_ids.length()];
					for(int i1 = 0; i1<service_option_ids.length();i1++){
						service_option_ids_array[i1] = service_option_ids.getInt(i1);
					}
					appointment.setService_option_ids(service_option_ids_array);
					
					//service_provider_id
					int service_provider_id = (Integer) jsonAppointment.get("service_provider_id");
					appointment.setService_provider_id(service_provider_id);
					
					
					//service_user data
					JSONObject jsonServiceUserData = jsonAppointment.getJSONObject("service_user");
					String gestation = jsonServiceUserData.getString("gestation");
					appointment.setGestation(gestation);
					
					int service_user_id = jsonServiceUserData.getInt("id");
					appointment.setService_user_id(service_user_id);
					
					String name = jsonServiceUserData.getString("name");
					appointment.setName(name);
					
					
					//time
					String time = jsonAppointment.getString("time");
					Log.d(TAG, "Time as String"+time);
			
							
					
					appointment.setTimeString(time);
					
					//visit logs
					JSONArray visit_logs =  jsonAppointment.getJSONArray("visit_logs");
					int [] visit_logs_array = new int [visit_logs.length()];
					for(int i1 = 0; i1<visit_logs.length();i1++){
						visit_logs_array[i1] = visit_logs.getInt(i1);
					}
					appointment.setVisit_logs(visit_logs_array);
					
					//visit type
					String visit_type = jsonAppointment.getString("visit_type");
					appointment.setVisit_type(visit_type);
					
					appointmentsList.add(appointment);
				}
				
				AppointmentSingleton.getInstance().setAppointments(appointmentsList);
				Intent davesAct2 = new Intent(context, DbTestDave2.class);
				context.startActivity(davesAct2);

			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
