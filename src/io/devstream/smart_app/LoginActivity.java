package io.devstream.smart_app;

//import android.support.v7.app.ActionBarActivity;


import java.util.Locale;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.Menu;
//import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends Activity {

	private TextView byline;
	private EditText etPassword;
	private EditText etUsername;
	String username;
	String password;
	private Button loginButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login_view);

		// how to pull in a string from the resources
		// and make it uppercase
		byline = (TextView) findViewById(R.id.smart_byline);
		String bl = getResources().getString(R.string.textsmart);
		byline.setText(bl.toUpperCase(Locale.getDefault()));

		loginButton = (Button)findViewById(R.id.loginButton);
		loginButton.setOnClickListener(new ClickButtonListener());

		
		etUsername = (EditText) findViewById(R.id.username);
		etPassword = (EditText) findViewById(R.id.password);

	}

	private class ClickButtonListener implements View.OnClickListener {

		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.loginButton:
				
				setUserNameAndPassword();
				new LongOperation().execute((String[]) null);

				
			}

		}
		
		private class LongOperation extends AsyncTask<String, Void, String> {
			@Override
			protected void onPreExecute() {
			}

			protected String doInBackground(String... params) {
				String authkey = HttpAuthClazz.getInstance().getAuthKey(username,password);
				SingletonUser.getSingletonInstance().setAuthToken(authkey);
				
				return HttpAuthClazz.getInstance().getResponseCode();
			}

			@Override
			protected void onProgressUpdate(Void... values) {

			}

			@Override
			protected void onPostExecute(String result) {
				if(!result.equals("201")){
					Toast.makeText(LoginActivity.this, "Login Failed, please try again", Toast.LENGTH_LONG).show();
				}
				else{
					SingletonUser.getSingletonInstance().setUsername(etUsername.getText().toString());
					SingletonUser.getSingletonInstance().setPassword(etUsername.getText().toString());
					Toast.makeText(LoginActivity.this, "Login Success!" + SingletonUser.getSingletonInstance().getAuthToken(), Toast.LENGTH_LONG).show();
					
					Intent login = new Intent(LoginActivity.this, CalendarsActivity.class);
					startActivity(login);
				}
			}
		}

		

		private void setUserNameAndPassword() {
			
			username = etUsername.getText().toString();
			password = etPassword.getText().toString();

		}

	}

}

/*
 * private void authenticateLogin(View v){
 * if(userName.getText().toString().equals("admin")&&
 * password.getText().toString().equals("admin")){
 * Toast.makeText(getApplicationContext(), "Hello Neo",
 * Toast.LENGTH_LONG).show(); Intent login = new Intent(LoginActivity.this,
 * CalendarsActivity.class); startActivity(login); }else{ attemps--;
 * Toast.makeText(getApplicationContext(), "You Have 3 attaempts remaining",
 * Toast.LENGTH_LONG) .show(); } if(attemps == 0){
 * loginButton.setEnabled(false); }
 * 
 * }
 */

/*
 * public class MainActivity extends ActionBarActivity {
 * 
 * private EditText username; private EditText password; private Button login;
 * private TextView loginLockedTV; private TextView attemptsLeftTV; private
 * TextView numberOfRemainingLoginAttemptsTV; int numberOfRemainingLoginAttempts
 * = 3;
 * 
 * @Override protected void onCreate(Bundle savedInstanceState) {
 * super.onCreate(savedInstanceState); setContentView(R.layout.activity_main);
 * setupVariables(); }
 * 
 * public void authenticateLogin(View view) { if
 * (username.getText().toString().equals("admin") &&
 * password.getText().toString().equals("admin")) {
 * Toast.makeText(getApplicationContext(), "Hello admin!",
 * Toast.LENGTH_SHORT).show(); } else { Toast.makeText(getApplicationContext(),
 * "Seems like you 're not admin!", Toast.LENGTH_SHORT).show();
 * numberOfRemainingLoginAttempts--; attemptsLeftTV.setVisibility(View.VISIBLE);
 * numberOfRemainingLoginAttemptsTV.setVisibility(View.VISIBLE);
 * numberOfRemainingLoginAttemptsTV
 * .setText(Integer.toString(numberOfRemainingLoginAttempts));
 * 
 * if (numberOfRemainingLoginAttempts == 0) { login.setEnabled(false);
 * loginLockedTV.setVisibility(View.VISIBLE);
 * loginLockedTV.setBackgroundColor(Color.RED);
 * loginLockedTV.setText("LOGIN LOCKED!!!"); } } }
 * 
 * private void setupVariables() { username = (EditText)
 * findViewById(R.id.usernameET); password = (EditText)
 * findViewById(R.id.passwordET); login = (Button) findViewById(R.id.loginBtn);
 * loginLockedTV = (TextView) findViewById(R.id.loginLockedTV); attemptsLeftTV =
 * (TextView) findViewById(R.id.attemptsLeftTV);
 * numberOfRemainingLoginAttemptsTV = (TextView)
 * findViewById(R.id.numberOfRemainingLoginAttemptsTV);
 * numberOfRemainingLoginAttemptsTV
 * .setText(Integer.toString(numberOfRemainingLoginAttempts)); }
 * 
 * }
 */