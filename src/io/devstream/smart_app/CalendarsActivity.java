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
		switch(v.getId()){
		case R.id.calBack:
			Intent back = new Intent(CalendarsActivity.this, MainActivity.class);
			startActivity(back);
			break;
		case R.id.clinicsBtn:
			Intent clinics = new Intent(CalendarsActivity.this, ServiceOptionsActivity.class);
			startActivity(clinics);
			break;
		case R.id.visitBtn:
			//Intent visits = new Intent(CalendarsActivity.this, )
			//startActivity(visits);
			break;
			default:
			break;
		}
	}

	
}
