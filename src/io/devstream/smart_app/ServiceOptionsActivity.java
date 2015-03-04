package io.devstream.smart_app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

//service_options_view
public class ServiceOptionsActivity extends Activity {

	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.service_options_view);
	}

	public void optionsClick(View v){
		int id = v.getId();
		if (id == R.id.dublin) {
			Intent dublin = new Intent(ServiceOptionsActivity.this,  ClinicsActivity.class);
			startActivity(dublin);
		} else if (id == R.id.wicklow) {
			Intent wicklow = new Intent(ServiceOptionsActivity.this, CalendarAntenatalClinicViewActivity.class);
			startActivity(wicklow);
		} else if (id == R.id.ethDublin) {
			Intent ethDublin = new Intent(ServiceOptionsActivity.this, AppoimtmentAntenatalViewActivity.class);
			startActivity(ethDublin);
		} else if (id == R.id.satellite) {
			Intent satellite = new Intent(ServiceOptionsActivity.this, SatelliteClinicViewActivity.class);
			startActivity(satellite);
		} else {
		}
	}

}
