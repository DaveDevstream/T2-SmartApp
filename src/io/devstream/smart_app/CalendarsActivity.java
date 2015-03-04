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

	public void clicked(View v) {
		switch (v.getId()) {
		case R.id.calBack:
			Intent back = new Intent(CalendarsActivity.this, MainActivity.class);
			startActivity(back);
			break;
		}
	}

}
