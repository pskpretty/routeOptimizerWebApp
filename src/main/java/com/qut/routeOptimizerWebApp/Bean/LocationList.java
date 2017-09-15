package com.qut.routeOptimizerWebApp.Bean;

import java.util.Iterator;
import java.util.List;

public class LocationList implements Iterable<Location>{
	private List<Location> locationList;

	public List<Location> getLocationList() {
		return locationList;
	}

	public void setLocationList(List<Location> locationList) {
		this.locationList = locationList;
	}

	@Override
	public Iterator<Location> iterator() {        
        Iterator<Location> iprof = locationList.iterator();
        return iprof; 
    }
}
