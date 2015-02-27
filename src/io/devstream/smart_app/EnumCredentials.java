package io.devstream.smart_app;
//use CredEnum.API_KEY to return the api key for example.

public enum EnumCredentials {
	API_KEY("f3e36c27-59ed-4c36-a2d2-a51c5021b7a7"),
	ENCODETYPE("ISO-8859-1"),
	URL("http://54.72.7.91:8888/");
	
	private String credential;

	private EnumCredentials(String credential){
		this.credential = credential;
	}

	public String toString(){
		return credential;
	}

	public String getCredential() {
		return credential;
	}

}
