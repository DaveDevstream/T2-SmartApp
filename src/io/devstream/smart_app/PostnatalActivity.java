package io.devstream.smart_app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class PostnatalActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.service_user_postnatal_view);
	}

	public void postnatalClick(View v) {
		switch (v.getId()) {
		case R.id.antenatalBtn:
			Intent anteBtn = new Intent(PostnatalActivity.this,
					AntenatalActivity.class);
			startActivity(anteBtn);
			break;
		case R.id.postProfile:
			Intent profile = new Intent(PostnatalActivity.this,
					ServiceUser.class);
			startActivity(profile);
			break;
		}
	}

}
