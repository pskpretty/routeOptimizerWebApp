package com.qut.routeOptimizerWebApp.Bean;

import java.util.Iterator;
import java.util.List;

public class AddressList implements Iterable<Address>{
	private List<Address> addresses;

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	@Override
	public Iterator<Address> iterator() {        
        Iterator<Address> iprof = addresses.iterator();
        return iprof; 
    }
}
