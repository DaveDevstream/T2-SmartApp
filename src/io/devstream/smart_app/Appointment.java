package io.devstream.smart_app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import android.text.format.Time;

public class Appointment {
	
	int clinic_id;
	int appointmentId;
	Date date;
	String dateString;
	Time time;
	int service_provider_id;
	int service_user_id;
	String priority;
	String visit_type;
	ArrayList<Integer> service_option_ids;
	
	public int getClinic_id() {
		return clinic_id;
	}
	public void setClinic_id(int clinic_id) {
		this.clinic_id = clinic_id;
	}
	
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public String getDateString() {
		return dateString;
	}
	public void setDateString(String dateString) {
		this.dateString = dateString;
		//delete Locale.UK to see other suggestions to fix this.
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd", Locale.UK);
		try {
			this.date = df.parse(dateString);
			//if you want to turn the simpleDateFormat back into a String.
			//System.out.println(df.format(date));
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		//if you wanted to turn the date into some other kind of format.
		//SimpleDateFormat df2 = new SimpleDateFormat("dd-MM-yyyy");
		//System.out.println(df2.format(date));
	}
	
	
	public int getappointmentId() {
		return appointmentId;
	}
	public void setappointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}
	
	
	
	
	
	public Time getTime() {
		return time;
	}
	public void setTime(Time time) {
		this.time = time;
	}
	
	public int getService_provider_id() {
		return service_provider_id;
	}
	public void setService_provider_id(int service_provider_id) {
		this.service_provider_id = service_provider_id;
	}
	
	public int getService_user_id() {
		return service_user_id;
	}
	public void setService_user_id(int service_user_id) {
		this.service_user_id = service_user_id;
	}
	
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	
	public String getVisit_type() {
		return visit_type;
	}
	public void setVisit_type(String visit_type) {
		this.visit_type = visit_type;
	}
	
	
	

}
