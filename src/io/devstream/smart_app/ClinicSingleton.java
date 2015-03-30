package io.devstream.smart_app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ClinicSingleton {
	
	private static ClinicSingleton instance;
	private ArrayList<ClinicModel> clinics = new ArrayList<ClinicModel>();
	
	public static ClinicSingleton getInstance(){
		if (instance == null) {
			synchronized (ClinicSingleton.class) {
				if (instance == null) {
					instance = new ClinicSingleton();
				}
			}
		}
		return instance;
	}
	
	public ArrayList<ClinicModel> getClinics() {
		return clinics;
	}

	public void setClinics(ArrayList<ClinicModel> clinics) {
		clinics = sortByTime(clinics);
		this.clinics = clinics;
	}
	
	public ArrayList<String> getClinicNames(int [] clinicIds){
		ArrayList<String> clinicNames = new ArrayList<String>();
		
		for(int i = 0;i<clinicIds.length;i++){
			clinicNames.add(getClinicName(clinicIds[i]));
		}
		
		return clinicNames;
	}
	
	public String getClinicName(int clinicId){
		String clinicName = null;
		for(ClinicModel clinic: clinics){
			if(clinicId == clinic.getClinic_id()){
				clinicName = clinic.getClinicName();
			}
		}
		
		return clinicName;
	}
	
	private ArrayList<ClinicModel> sortByTime(ArrayList<ClinicModel>clins) {
		Collections.sort(clins, new Comparator<ClinicModel>() {

			@Override
			public int compare(ClinicModel a, ClinicModel b) {
				String valA = new String();
                String valB = new String();
                
                valA = String.valueOf(a.getClinic_id());
                valB = String.valueOf(b.getClinic_id());
                
                int comp = valA.compareTo(valB);
                
                if (comp > 0)
                    return 1;
                if (comp < 0)
                    return -1;
                return 0;
			}
			
		});
		
		return clins;
	}
	
	

}
