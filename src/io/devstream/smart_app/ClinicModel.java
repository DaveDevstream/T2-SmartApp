package io.devstream.smart_app;

import java.util.HashMap;
import java.util.Map;

/*{
    "address": "Greystones Health Centre, Victoria Road, Greystones",
    "announcement_ids": [],
    "appointment_interval": 15,
    "closing_time": "09:00:00",
    "days": {
        "friday": false,
        "monday": true,
        "saturday": false,
        "sunday": false,
        "thursday": false,
        "tuesday": true,
        "wednesday": false
    },
    "id": 6,
    "links": {
        "announcements": "announcements",
        "service_options": "/service_options"
    },
    "name": "Greystones",
    "opening_time": "09:00:00",
    "recurrence": "weekly",
    "service_option_ids": [
        2
    ],
    "type": "booking"
}*/

public class ClinicModel {
	
	private String address;
	private int []announcement_ids;
	private int appointment_interval;
	private String closing_time;
	private Map<String, Boolean> days = new HashMap<String, Boolean>();
	private int clinic_id;
	private String linkAnnouncements;
	private String linkService_options;
	private String clinicName;
	private String opening_time;
	private String recurrence;
	private int [] service_option_ids;
	private String type;
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int[] getAnnouncement_ids() {
		return announcement_ids;
	}
	public void setAnnouncement_ids(int[] announcement_ids) {
		this.announcement_ids = announcement_ids;
	}
	public int getAppointment_interval() {
		return appointment_interval;
	}
	public void setAppointment_interval(int appointment_interval) {
		this.appointment_interval = appointment_interval;
	}
	public String getClosing_time() {
		return closing_time;
	}
	public void setClosing_time(String closing_time) {
		this.closing_time = closing_time;
	}
	public Map<String, Boolean> getDays() {
		return days;
	}
	public void setDays(Map<String, Boolean> days) {
		this.days = days;
	}
	public int getClinic_id() {
		return clinic_id;
	}
	public void setClinic_id(int clinic_id) {
		this.clinic_id = clinic_id;
	}
	public String getLinkAnnouncements() {
		return linkAnnouncements;
	}
	public void setLinkAnnouncements(String linkAnnouncements) {
		this.linkAnnouncements = linkAnnouncements;
	}
	public String getLinkService_options() {
		return linkService_options;
	}
	public void setLinkService_options(String linkService_options) {
		this.linkService_options = linkService_options;
	}
	public String getClinicName() {
		return clinicName;
	}
	public void setClinicName(String clinicName) {
		this.clinicName = clinicName;
	}
	public String getOpening_time() {
		return opening_time;
	}
	public void setOpening_time(String opening_time) {
		this.opening_time = opening_time;
	}
	public String getRecurrence() {
		return recurrence;
	}
	public void setRecurrence(String recurrence) {
		this.recurrence = recurrence;
	}
	public int[] getService_option_ids() {
		return service_option_ids;
	}
	public void setService_option_ids(int[] service_option_ids) {
		this.service_option_ids = service_option_ids;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

}
