package io.devstream.smart_app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ServiceOptionSingleton {
	
	private static ServiceOptionSingleton instance;
	private ArrayList<ServiceOptionsModel> serviceOptions= new ArrayList<ServiceOptionsModel>();
	
	public static ServiceOptionSingleton getInstance() {
		if (instance == null) {
			synchronized (ServiceOptionSingleton.class) {
				if (instance == null) {
					instance = new ServiceOptionSingleton();
				}
			}
		}
		return instance;
	}

	public ArrayList<ServiceOptionsModel> getServiceOptions() {
		return serviceOptions;
	}

	public void setServiceOptions(ArrayList<ServiceOptionsModel> serviceOptions) {
		serviceOptions = sortById(serviceOptions);
		this.serviceOptions = serviceOptions;
	}
	
	public int[] getClinicIds(int position){
		int[] clinicIds = serviceOptions.get(position).getClinicIds();
		return clinicIds;
	}
	
	private ArrayList<ServiceOptionsModel> sortById(ArrayList<ServiceOptionsModel>servOpts) {
		Collections.sort(servOpts, new Comparator<ServiceOptionsModel>() {

			@Override
			public int compare(ServiceOptionsModel a, ServiceOptionsModel b) {
                String valA = new String();
                String valB = new String();
               
                valA = String.valueOf(a.getServiceOptionId());
                valB = String.valueOf(b.getServiceOptionId());
				
                int comp = valA.compareTo(valB);

                if (comp > 0)
                    return 1;
                if (comp < 0)
                    return -1;
                return 0;
				
			}
	});
		return servOpts;
	}

	
}
