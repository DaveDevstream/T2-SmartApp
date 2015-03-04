package io.devstream.smart_app;

import com.android.volley.AuthFailureError;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AuthFailureError afe = new AuthFailureError();
        
        // I'm working on a new push!!
        //this working yet?.
        //make a change
    }
    
    public void callActivity(View v){
    	
    	int id = v.getId();
    	if (id == R.id.cal){
    		Intent calIntent = new Intent(MainActivity.this, CalendarsActivity.class);
    		startActivity(calIntent);
    		}
    	else if (id == R.id.profile){
    		Intent antIntent = new Intent(MainActivity.this, ServiceUser.class);
    		startActivity(antIntent);
    		}
    	else if (id == R.id.clinics){
    		Intent clinics = new Intent(MainActivity.this,ClinicsActivity.class);
    		startActivity(clinics);
    		}
    	else if (id == R.id.post){
    		Intent postnatal = new Intent(MainActivity.this,PostnatalActivity.class);
    		startActivity(postnatal);
    		}
    	else if (id == R.id.userAntenatal){
    		Intent anteNatal = new Intent(MainActivity.this,AntenatalActivity.class ); 
    		startActivity(anteNatal);
    		}
    	else if (id == R.id.clin){
    		Intent clinicDateIntent = new Intent(MainActivity.this,ClinicDateActivity.class);
    		startActivity(clinicDateIntent);
    		}
    	else if (id == R.id.apt){
    		Intent aptIntent = new Intent(MainActivity.this, AppointmentsActivity.class);
    		startActivity(aptIntent);
    		}
    	else if (id == R.id.serviceOption){
    		Intent options = new Intent(MainActivity.this, ServiceOptionsActivity.class);
    		startActivity(options);
    		}
    	else if (id == R.id.login){
    		Intent log = new Intent(MainActivity.this, LoginActivity.class);
    		startActivity(log);
    		}
    	else if (id == R.id.editUser){
    		Intent edit = new Intent(MainActivity.this, EditServiceUserActivity.class);
    		startActivity(edit);
    		}
    	else if (id == R.id.calendarAntenatal){
    		Intent calendarAnte = new Intent(MainActivity.this, CalendarAntenatalClinicViewActivity.class);
    		startActivity(calendarAnte);
    		}
    	else if (id == R.id.appAntenatal){
    		Intent appAnte = new Intent(MainActivity.this, AppoimtmentAntenatalViewActivity.class);
    		startActivity(appAnte);
    		}
    	
    	
    }
}
