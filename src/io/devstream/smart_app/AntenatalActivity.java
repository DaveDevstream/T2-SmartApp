package io.devstream.smart_app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AntenatalActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.service_user_antenatal_view);
	}
	
	public void antenatalClick(View v){
		switch(v.getId()){
		case R.id.antenatalProfile:
			Intent anteProfile = new Intent(AntenatalActivity.this,ServiceUser.class);
			startActivity(anteProfile);
			break;
		case R.id.postnatalActivity:
			Intent postnatal = new Intent(AntenatalActivity.this, PostnatalActivity.class);
			startActivity(postnatal);
			break;
			default:
				break;
		}
	}

	
	

}
