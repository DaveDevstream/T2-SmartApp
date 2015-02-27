package io.devstream.smart_app;

public class SingletonUser {
	
	private String username;
	private String password;
	private String authToken;
	private int userId;
	private static SingletonUser user;
	private boolean loggedIn;
	
	public static SingletonUser getSingletonInstance(){
		if(user == null){
			user = new SingletonUser();
		}
		return user;
	}
	
	public boolean isLoggedin(){
		return loggedIn;
	}
	
	public void logsIn(boolean loggedIn){
		this.loggedIn = loggedIn;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAuthToken() {
		return authToken;
	}

	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	
	
}
