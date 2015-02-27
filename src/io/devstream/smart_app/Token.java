package io.devstream.smart_app;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

public class Token {
	private String username, password, strToken,st;
	private String loginUrl, encodeType;
	private String responseCode = null;
	private int id, ch;
	private HttpURLConnection httpcon;
	//private ModelLogin login = new ModelLogin();
	private JSONObject credentials = new JSONObject();
	private JSONObject jsonLogin = new JSONObject();
	private JSONObject json = new JSONObject();
	private InputStream is;
	private OutputStream os;
	private StringBuffer sb;
	private final String URL = EnumCredentials.URL.getCredential()+"login";
	private final String ENCODEDTYPE = EnumCredentials.ENCODETYPE.getCredential();
	private final String TAG = "Token";
	private String tempString;
	
	public Token(String username, String password){
		this.username = username;
		this.password = password;
	}
	//changed private getToken method to Public. Is this ok?
	public String getToken(){
		try {
			
			try {
				
				credentials.put("username", username);
				credentials.put("password", password);
				//Log.d(TAG,credentials.toString());
				
				// "{\"login\":{\"password\":\"smartappiscoming\",\"username\":\"team_belize\"}}"
				tempString = "'{\"login\":{\"username\":\"team_belize\",\"password\":\"smartappiscoming\"}}'";
				Log.d(TAG,tempString);
				//jsonLogin.put();
				
				
				//Log.d(TAG,"inserted credentials"+jsonLogin.toString());
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			httpcon = (HttpURLConnection) ((new URL(loginUrl).openConnection()));
			URLEncoder.encode(loginUrl, encodeType);
			httpcon.setDoOutput(true);
			httpcon.setRequestMethod("POST");
			httpcon.setRequestProperty("Content-Type", "application/json");
			httpcon.setRequestProperty("Accept", "application/json");
			httpcon.connect();
			Log.d(TAG,"response code: "+httpcon.getResponseCode());
			// form request
			byte[] inputBytes = tempString.getBytes(encodeType);

			os = httpcon.getOutputStream();
			os.write(inputBytes);
			os.flush();
			os.close();
			
			// grab the response
			is = httpcon.getInputStream();
			sb = new StringBuffer();
			while ((ch = is.read()) != -1) {
				sb.append((char) ch);
			}
			st = sb.toString();
		}
		catch(IOException e){
			e.printStackTrace();
		}
			try{
			// create JSON Object to get Token using token key
			json = new JSONObject(st);
			strToken = (String) ((JSONObject) json.get("login")).get("token");
			id = (Integer) ((JSONObject) json.get("login")).get("id");
			SingletonUser.getSingletonInstance().setUserId(id);
			SingletonUser.getSingletonInstance().setAuthToken(strToken);
			httpcon.disconnect();
			
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return null;
	}	
	public String getResponseCode(){		
		try {
			responseCode = String.valueOf(httpcon.getResponseCode());
			Log.d("MYLOG", "Response Code: " + httpcon.getResponseCode());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return responseCode;
	}
}