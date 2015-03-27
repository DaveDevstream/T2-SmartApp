package io.devstream.smart_app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class DbTestingActivity extends Activity {

	Button ahmedsButton;
	Button garysButton;
	Button davesButton;
	Button davesButton2;
	Button davesButton3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.database_testing_view);

		ahmedsButton = (Button) findViewById(R.id.bt_testdb_ahmed);
		garysButton = (Button) findViewById(R.id.bt_testdb_gary);
		davesButton = (Button) findViewById(R.id.bt_testdb_dave);
		davesButton2 = (Button) findViewById(R.id.bt_testdb_dave2);
		davesButton3 = (Button) findViewById(R.id.bt_testdb_dave3);
		
		ahmedsButton.setOnClickListener(new ClickButtonListener());
		garysButton.setOnClickListener(new ClickButtonListener());
		davesButton.setOnClickListener(new ClickButtonListener());
		davesButton2.setOnClickListener(new ClickButtonListener());
		davesButton3.setOnClickListener(new ClickButtonListener());
	}

	public class ClickButtonListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.bt_testdb_ahmed:
				Intent ahmedsAct = new Intent(DbTestingActivity.this, DbTestAhmed.class);
				startActivity(ahmedsAct);
				break;
			case R.id.bt_testdb_gary:
				Intent garysAct = new Intent(DbTestingActivity.this, DbTestGary.class);
				startActivity(garysAct);
				break;
			case R.id.bt_testdb_dave:
				Intent davesAct = new Intent(DbTestingActivity.this, DbTestDave.class);
				startActivity(davesAct);
				break;
			case R.id.bt_testdb_dave2:
				AppointmentsGrabber ag = new AppointmentsGrabber("2015-03-24",2, DbTestingActivity.this);
				
				/*Intent davesAct2 = new Intent(DbTestingActivity.this, DbTestDave2.class);
				startActivity(davesAct2);*/
				break;
			case R.id.bt_testdb_dave3:
				ServiceOptionsAndClinicsGrabber soacg = new ServiceOptionsAndClinicsGrabber(DbTestingActivity.this);
				break;
			}

		}

	}

}
