package io.devstream.smart_app;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ServiceUser extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.service_user_profile_view);
	}

	// button clicks
	public void profileClick(View v) {
		switch (v.getId()) {
		case R.id.editUser:
			Intent editIntent = new Intent(ServiceUser.this,
					EditServiceUserActivity.class);
			startActivity(editIntent);
			break;
		case R.id.bookAppointment:
			Intent bookApp = new Intent(ServiceUser.this,
					AppointmentsActivity.class);
			startActivity(bookApp);
			break;
		case R.id.serviceUserPostnatal:
			// setImageResource=(R.drawable.ic_antenatal_selected);
			Intent postnatalService = new Intent(ServiceUser.this,
					PostnatalActivity.class);
			startActivity(postnatalService);
			break;
		case R.id.serviceUserAntenatalButton:
			Intent antenatal = new Intent(ServiceUser.this,
					AntenatalActivity.class);
			startActivity(antenatal);
			break;
		}
	}
	/**
	 * //Clinical Fields private String blood_type; private String
	 * estimated_delivery_date;
	 * 
	 * private int id; private String hospital_number;
	 * 
	 * //Personal Fields private String home_address; private String home_type;
	 * private String home_county; private String home_post_code; private String
	 * directions;
	 * 
	 * //Created integers for better usage private String dob; private int
	 * birth_year; private int birth_month; private int birth_day;
	 * 
	 * private String email; private int home_phone; private int mobile_phone;
	 * private String name; private int next_of_kin_phone; private String
	 * next_of_kin_name;
	 * 
	 * private ArrayList<Pregnancy> pregnancies; private ArrayList<Baby> babies;
	 * private boolean hasPregnancy; private boolean hasBaby;
	 * 
	 * //Full set of info public ServiceUser(String blood_type, String
	 * estimated_delivery_date, int id, String hospital_number, String
	 * home_address, String home_type, String home_county, String
	 * home_post_code, String directions, String dob, String email, int
	 * home_phone, int mobile_phone, String name, int next_of_kin_phone, String
	 * next_of_kin_name, ArrayList<Pregnancy> pregnancies, ArrayList<Baby>
	 * babies) { super(); this.blood_type = blood_type;
	 * this.estimated_delivery_date = estimated_delivery_date; this.id = id;
	 * this.hospital_number = hospital_number; this.home_address = home_address;
	 * this.home_type = home_type; this.home_county = home_county;
	 * this.home_post_code = home_post_code; this.directions = directions;
	 * this.dob = dob; generateDOBInts(); this.email = email; this.home_phone =
	 * home_phone; this.mobile_phone = mobile_phone; this.name = name;
	 * this.next_of_kin_phone = next_of_kin_phone; this.next_of_kin_name =
	 * next_of_kin_name;
	 * 
	 * //Set these arrays then check if the arrays are empty, to set the
	 * booleans this.pregnancies = pregnancies; this.babies = babies;
	 * hasPregnancy = pregnancies.size() > 0; hasBaby = babies.size() > 0;
	 * //These expressions evaluate to true if there's any elements in these
	 * arrays and false if there's none } //Determine if other constructors are
	 * needed (ie. if some attributes aren't necessary)
	 * 
	 * //Method to turn DOB string into ints, better for public void
	 * generateDOBInts(){ birth_year = Integer.parseInt(dob.substring(0, 4));
	 * birth_month = Integer.parseInt(dob.substring(5, 7)); birth_day =
	 * Integer.parseInt(dob.substring(8, 10)); }
	 * 
	 * //Getters public String getBlood_type() { return blood_type; }
	 * 
	 * public String getEstimated_delivery_date() { return
	 * estimated_delivery_date; }
	 * 
	 * public int getId() { return id; }
	 * 
	 * public String getHospital_number() { return hospital_number; }
	 * 
	 * public String getHome_address() { return home_address; }
	 * 
	 * public String getHome_type() { return home_type; }
	 * 
	 * public String getHome_county() { return home_county; }
	 * 
	 * public String getHome_post_code() { return home_post_code; }
	 * 
	 * public String getDirections() { return directions; }
	 * 
	 * public String getDob() { return dob; }
	 * 
	 * public int getBirth_year() { return birth_year; }
	 * 
	 * public int getBirth_month() { return birth_month; }
	 * 
	 * public int getBirth_day() { return birth_day; }
	 * 
	 * public int[] getDobInt(){ int[] dobInt = new int[]{birth_year,
	 * birth_month, birth_day}; return dobInt; }
	 * 
	 * public String getEmail() { return email; }
	 * 
	 * public int getHome_phone() { return home_phone; }
	 * 
	 * public int getMobile_phone() { return mobile_phone; }
	 * 
	 * public String getName() { return name; }
	 * 
	 * public int getNext_of_kin_phone() { return next_of_kin_phone; }
	 * 
	 * public String getNext_of_kin_name() { return next_of_kin_name; }
	 * 
	 * public ArrayList<Pregnancy> getPregnancies() { return pregnancies; }
	 * 
	 * public ArrayList<Baby> getBabies() { return babies; }
	 * 
	 * public boolean hasPregnancy() { return hasPregnancy; }
	 * 
	 * public boolean hasBaby() { return hasBaby; }
	 */
}
