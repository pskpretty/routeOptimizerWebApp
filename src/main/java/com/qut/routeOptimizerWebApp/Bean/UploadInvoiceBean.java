package com.qut.routeOptimizerWebApp.Bean;

import java.util.Iterator;
import java.util.List;

public class UploadInvoiceBean implements Iterable<Location>{
	private List<Location> addresses;
	private String status;
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Location> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Location> addresses) {
		this.addresses = addresses;
	}

	@Override
	public Iterator<Location> iterator() {        
        Iterator<Location> iprof = addresses.iterator();
        return iprof; 
    }
}
