package io.devstream.smart_app;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import android.text.format.Time;

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
		appointments = sortByTime(appointments);
		this.appointments = appointments;
	}
	

	private ArrayList<Appointment> sortByTime(ArrayList<Appointment>appts) {
		Collections.sort(appts, new Comparator<Appointment>() {

			@Override
			public int compare(Appointment a, Appointment b) {
                String valA = new String();
                String valB = new String();
               
                valA = a.getTimeString();
                valB = b.getTimeString();
				
                int comp = valA.compareTo(valB);

                if (comp > 0)
                    return 1;
                if (comp < 0)
                    return -1;
                return 0;
				
			}
	});
		return appts;
	}
}
	
	