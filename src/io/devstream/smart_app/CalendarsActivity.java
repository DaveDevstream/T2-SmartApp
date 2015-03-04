package io.devstream.smart_app;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

//calendar_view
public class CalendarsActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.calendars_view);
	}
	public void clicked(View v){
		int id = v.getId();
		if (id == R.id.calBack) {
			Intent back = new Intent(CalendarsActivity.this, MainActivity.class);
			startActivity(back);
		} else if (id == R.id.clinicsBtn) {
			Intent clinics = new Intent(CalendarsActivity.this, ServiceOptionsActivity.class);
			startActivity(clinics);
		} else if (id == R.id.visitBtn) {
		} else {
		}
	}

	
}
