package io.devstream.smart_app;



import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class ServiceOptionPickerActivity extends Activity {

	Spinner spinnerServiceOptions;
	Spinner spinnerClinics;
	ArrayList<String> serviceOptionNames;
	ArrayList<String> clinicNames;
	int [] clinicIds;
	int selectedClinicId;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.service_option_picker);
		spinnerServiceOptions = (Spinner) findViewById(R.id.spinner1);
		spinnerClinics = (Spinner) findViewById(R.id.spinner2);
		Button btnShowAppointments = (Button)findViewById(R.id.btn_show_appointments);
		btnShowAppointments.setOnClickListener(new ClickButtonListener());
		
		populateServiceOptions();

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_dropdown_item,
				serviceOptionNames);

		spinnerServiceOptions.setAdapter(adapter);
		spinnerServiceOptions
				.setOnItemSelectedListener(new MySpinnerOnItemSelectedListener());

	}

	public void populateServiceOptions() {
		ArrayList<ServiceOptionsModel> serviceOptions = ServiceOptionSingleton
				.getInstance().getServiceOptions();
		serviceOptionNames = new ArrayList<String>();
		int size = serviceOptions.size();

		for (int i = 0; i < size; i++) {
			serviceOptionNames
					.add(serviceOptions.get(i).getServiceOptionName());
		}
	}

	public void populateClinics(int position) {
		clinicIds = ServiceOptionSingleton
				.getInstance().getClinicIds(position);
		clinicNames = ClinicSingleton.getInstance().getClinicNames(clinicIds);
		
		ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_dropdown_item,
				clinicNames);
		
		spinnerClinics.setAdapter(adapter2);
		spinnerClinics
				.setOnItemSelectedListener(new MySpinnerOnItemSelectedListener());
		
		
	}

	private class MySpinnerOnItemSelectedListener implements
			AdapterView.OnItemSelectedListener {

		@Override
		public void onItemSelected(AdapterView<?> parent, View view,
				int position, long id) {

			switch (parent.getId()) {
			case R.id.spinner1:
				populateClinics(position);
				
				break;
			case R.id.spinner2:
				selectedClinicId = clinicIds[position];
				break;	
			}
			

		}

		@Override
		public void onNothingSelected(AdapterView<?> parent) {
			// TODO Auto-generated method stub

		}

	}
	
	private class ClickButtonListener implements View.OnClickListener {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
		}
		
	}

}
