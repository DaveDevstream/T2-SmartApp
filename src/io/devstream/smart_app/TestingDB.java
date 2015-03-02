package io.devstream.smart_app;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;



public class TestingDB extends Activity{
	
	TextView tvResult;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.testing_db);
		
		tvResult = (TextView)findViewById(R.id.dbresult);
		Button qdb = (Button)findViewById(R.id.querydb);
		qdb.setOnClickListener(new ClickButtonListener());
		
		
	}
	
	private class ClickButtonListener implements View.OnClickListener {

		@Override
		public void onClick(View v) {
			switch(v.getId()){
			case R.id.querydb:
				QueryDB q = new QueryDB("appointments");
				String temp = q.getResult().toString();
				tvResult.setText(temp);
			;break;	
			}
			
		}
		
	}

}
