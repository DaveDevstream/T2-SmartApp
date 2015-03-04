package io.devstream.smart_app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class EditServiceUserActivity extends Activity {
	
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.edit_service_user_view);
	}
	
	public void editUserClick(View v){
		switch (v.getId()) {
		case R.id.done:
			Intent doneIntent = new Intent(EditServiceUserActivity.this, ServiceUser.class);
			startActivity(doneIntent);
			break;
		}
	}

}
