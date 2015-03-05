package io.devstream.smart_app;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ApointmentsCalendar extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_apointments_calendar);
	}
	
	public void appointmentClick(View v){
		switch(v.getId()) {
		case R.id.next:
			Intent next = new Intent(ApointmentsCalendar.this, AppointmentsActivity.class);
			startActivity(next);
			break;
		}
	}
/*
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.apointments_calendar, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}*/
}
