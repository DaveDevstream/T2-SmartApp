package io.devstream.smart_app;

public class ServiceOptionsModel {
	
	private int serviceOptionId;
	private String serviceOptionName;
	private int [] clinicIds;
	
	public ServiceOptionsModel(){
		
	}
	
	public ServiceOptionsModel(int serviceOptionId, String serviceOptionName, int[] clinicIds) {
		this.serviceOptionId = serviceOptionId;
		this.serviceOptionName = serviceOptionName;
		this.clinicIds = clinicIds;
	}

	public int getServiceOptionId() {
		return serviceOptionId;
	}

	public void setServiceOptionId(int serviceOptionId) {
		this.serviceOptionId = serviceOptionId;
	}

	public String getServiceOptionName() {
		return serviceOptionName;
	}

	public void setServiceOptionName(String serviceOptionName) {
		this.serviceOptionName = serviceOptionName;
	}

	public int[] getClinicIds() {
		return clinicIds;
	}

	public void setClinicIds(int[] clinicIds) {
		this.clinicIds = clinicIds;
	}
	
	

}
