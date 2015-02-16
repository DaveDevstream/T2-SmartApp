package io.devstream.smart_app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // I'm working on a new push!!
        //this working yet?.
        //make a change
    }
    
    public void callActivity(View v){
    	switch(v.getId()){
    	case R.id.cal:
    		Intent calIntent = new Intent(MainActivity.this, CalendarsActivity.class);
    		startActivity(calIntent);
    		break;
    	case R.id.profile:
    		Intent antIntent = new Intent(MainActivity.this, ServiceUser.class);
    		startActivity(antIntent);
    		break;
    	case R.id.clinics:
    		Intent clinics = new Intent(MainActivity.this,ClinicsActivity.class);
    		startActivity(clinics);
    		break;
    	case R.id.post:
    		Intent postnatal = new Intent(MainActivity.this,PostnatalActivity.class);
    		startActivity(postnatal);
    		break;
    	case R.id.userAntenatal:
    		Intent anteNatal = new Intent(MainActivity.this,AntenatalActivity.class ); 
    		startActivity(anteNatal);
    		break;
    	case R.id.clin:
    		Intent clinicDateIntent = new Intent(MainActivity.this,ClinicDateActivity.class);
    		startActivity(clinicDateIntent);
    		break;
    	case R.id.apt:
    		Intent aptIntent = new Intent(MainActivity.this, AppointmentsActivity.class);
    		startActivity(aptIntent);
    		break;
    	case R.id.serviceOption:
    		Intent options = new Intent(MainActivity.this, ServiceOptionsActivity.class);
    		startActivity(options);
    		break;
    	case R.id.login:
    		Intent log = new Intent(MainActivity.this, LoginActivity.class);
    		startActivity(log);
    		break;
    	case R.id.editUser:
    		Intent edit = new Intent(MainActivity.this, EditServiceUserActivity.class);
    		startActivity(edit);
    		break;
    	case R.id.calendarAntenatal:
    		Intent calendarAnte = new Intent(MainActivity.this, CalendarAntenatalClinicViewActivity.class);
    		startActivity(calendarAnte);
    		break;
    	case R.id.appAntenatal:
    		Intent appAnte = new Intent(MainActivity.this, AppoimtmentAntenatalViewActivity.class);
    		startActivity(appAnte);
    			default:
    		break;
    		
    	}
    	
    	
    }
}
