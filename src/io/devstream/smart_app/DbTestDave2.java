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
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class DbTestDave2 extends Activity{
	
	ListView list;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.base_adapter_layout_for_midvives);
		list = (ListView)findViewById(R.id.listViewAppointments);
		
		list.setAdapter(new AppointmentBaseAdapter(this));
	}
	
	

}

class AppointmentBaseAdapter extends BaseAdapter{
	
	private final String TAG = "AppointmentBaseAdapter";
	Context context;
	ArrayList<Appointment> appointmentList;
	
	AppointmentBaseAdapter(Context c){
		context = c;
		appointmentList = AppointmentSingleton.getInstance().getAppointments();
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return appointmentList.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return appointmentList.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return appointmentList.get(position).getAppointmentId();
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View row = inflater.inflate(R.layout.single_appointment_row, parent,false);
		TextView time = (TextView) row.findViewById(R.id.appointment_time);
		TextView service_user_name = (TextView) row.findViewById(R.id.appointment_service_user_name);
		TextView service_user_gestation = (TextView) row.findViewById(R.id.appointment_service_user_gestation);
		
		Appointment singleAppointment = appointmentList.get(position);
		
		time.setText(singleAppointment.getTimeString());
		service_user_name.setText(singleAppointment.getName());
		service_user_gestation.setText(singleAppointment.getGestation());
		
		return row;
	}
	
	
	
}
