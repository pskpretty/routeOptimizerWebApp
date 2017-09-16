package com.qut.routeOptimizerWebApp.Bean;

import java.util.Iterator;
import java.util.List;

public class UploadInvoiceBean implements Iterable<Location>{
	private List<Location> locationList;
	public List<Location> getLocationList() {
		return locationList;
	}

	public void setLocationList(List<Location> locationList) {
		this.locationList = locationList;
	}

	private String status;
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


	@Override
	public Iterator<Location> iterator() {        
        Iterator<Location> iprof = locationList.iterator();
        return iprof; 
    }
}
