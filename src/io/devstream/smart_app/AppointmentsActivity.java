package io.devstream.smart_app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AppointmentsActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.appointments_view);
	}
	
	public void appointClick(View v){
		switch(v.getId()) {
		case R.id.patient:
			Intent patientProfile = new Intent(AppointmentsActivity.this, ServiceUser.class);
			startActivity(patientProfile);
			break;
		}
	
	}

	

}
