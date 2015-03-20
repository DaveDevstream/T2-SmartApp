package io.devstream.smart_app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import android.text.format.Time;

public class Appointment {

	private int clinic_id;
	private Date date;
	private String dateString;
	private int appointmentId;
	
	private Calendar calDateTime;

	// links
	private String service_options;
	private String service_provider;
	private String service_user;

	private String priority;
	private int[] service_option_ids;
	private int service_provider_id;

	// user's credentials
	private String gestation;
	private int service_user_id;
	private String name;

	private Time time;
	private String timeString;

	private int[] visit_logs;
	private String visit_type;

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
		// delete Locale.UK to see other suggestions to fix this.
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd", Locale.UK);
		try {
			this.date = df.parse(dateString);
			// if you want to turn the simpleDateFormat back into a String.
			// System.out.println(df.format(date));

		} catch (ParseException e) {
			e.printStackTrace();
		}

		// if you wanted to turn the date into some other kind of format.
		// SimpleDateFormat df2 = new SimpleDateFormat("dd-MM-yyyy");
		// System.out.println(df2.format(date));
	}

	public int getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}

	public String getService_options() {
		return service_options;
	}

	public void setService_options(String service_options) {
		this.service_options = service_options;
	}

	public String getService_provider() {
		return service_provider;
	}

	public void setService_provider(String service_provider) {
		this.service_provider = service_provider;
	}

	public String getService_user() {
		return service_user;
	}

	public void setService_user(String service_user) {
		this.service_user = service_user;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public int[] getService_option_ids() {
		return service_option_ids;
	}

	public void setService_option_ids(int[] service_option_ids) {
		this.service_option_ids = service_option_ids;
	}

	public int getService_provider_id() {
		return service_provider_id;
	}

	public void setService_provider_id(int service_provider_id) {
		this.service_provider_id = service_provider_id;
	}

	public String getGestation() {
		return gestation;
	}

	public void setGestation(String gestation) {
		this.gestation = gestation;
	}

	public int getService_user_id() {
		return service_user_id;
	}

	public void setService_user_id(int service_user_id) {
		this.service_user_id = service_user_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public String getTimeString() {
		return timeString;
	}

	public void setTimeString(String timeString) {
		this.timeString = timeString;
	}

	public int[] getVisit_logs() {
		return visit_logs;
	}

	public void setVisit_logs(int[] visit_logs) {
		this.visit_logs = visit_logs;
	}

	public String getVisit_type() {
		return visit_type;
	}

	public void setVisit_type(String visit_type) {
		this.visit_type = visit_type;
	}
	
	public String toString(){
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
				+"service option ids: "+Arrays.toString(service_option_ids)+"\n"
				+"service provider id: "+service_provider_id+"\n"
				+"gestation: "+gestation+"\n"
				+"service user id: "+service_user_id+"\n"
				+"name: "+name+"\n"
				+"service user id (dupe record): "+service_user_id+"\n"
				+"time: "+time+"\n"
				+"visit logs array: "+Arrays.toString(visit_logs)+"\n"
				+"visit type: "+visit_type;
		
		return totalinfo;
	}
	
	public void setCalDateTime(){
		String dateTime = getDateString()+" "+getTimeString();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = null;
		try {
			date = df.parse(dateTime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calDateTime = calendar;		
	}
	
	public Calendar getCalDateTime(){
		setCalDateTime();
		return calDateTime;
	}

}
