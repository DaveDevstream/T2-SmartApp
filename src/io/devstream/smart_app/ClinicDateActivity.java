package io.devstream.smart_app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ClinicDateActivity  extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.clinic_dates_view);
	}
	
	public void dateClick(View v){
		switch (v.getId()) {
		case R.id.week1:
			Intent week1 = new Intent(ClinicDateActivity.this, ApointmentsCalendar.class);
			startActivity(week1);
			break;
		}
		
	}
	
//	@Override
//	public void onBackPressed() {
		
//	}



	

}
	
