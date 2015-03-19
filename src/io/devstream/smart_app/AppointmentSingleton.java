package io.devstream.smart_app;

import java.util.ArrayList;

public class AppointmentSingleton {
	
	private static AppointmentSingleton instance;
	private ArrayList<Appointment> appointments = new ArrayList<Appointment>();
	
	public static AppointmentSingleton getInstance() {
		if (instance == null) {
			synchronized (AppointmentSingleton.class) {
				if (instance == null) {
					instance = new AppointmentSingleton();
				}
			}
		}
		return instance;
	}

	public ArrayList<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(ArrayList<Appointment> appointments) {
		this.appointments = appointments;
	}
}
