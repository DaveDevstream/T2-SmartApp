package io.devstream.smart_app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ClinicsActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.clinics_view);
	}
	
	public void clinicClick(View v){
		switch(v.getId()){
		case R.id.nmh:
			Intent mnh = new Intent(ClinicsActivity.this, ClinicDateActivity.class);
			startActivity(mnh);
			break;
	//	case R.id.clinicsBack:
	//		Intent clinicBack = new Intent(ClinicsActivity.this, ServiceOptionsActivity.class);
	//		startActivity(clinicBack);
	//		break;
			default:
				break;
		}
	}

	

}
