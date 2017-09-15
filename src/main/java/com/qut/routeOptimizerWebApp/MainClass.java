package com.qut.routeOptimizerWebApp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.graphhopper.GHRequest;
import com.graphhopper.GHResponse;
import com.graphhopper.GraphHopper;
import com.graphhopper.routing.util.EncodingManager;
import com.graphhopper.util.Instruction;
import com.graphhopper.util.shapes.GHPoint;
import com.qut.routeOptimizerWebApp.Bean.Location;
import com.qut.routeOptimizerWebApp.Bean.LocationList;

@Controller

public class MainClass {
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index() {
	    return "index";
	}
	
	public List<GHPoint> locationToGraphHopper(LocationList locationList){
		List<GHPoint> ghList=new ArrayList<GHPoint>();
		GHPoint ghPoint=new GHPoint();
		Iterator<Location> iterator = locationList.iterator();
		while(iterator.hasNext()){
			ghPoint.lat=Double.parseDouble(iterator.next().getLatitude());
			ghPoint.lon=Double.parseDouble(iterator.next().getLongitude());
			ghList.add(ghPoint);
		}
		return ghList;
	}
	@RequestMapping(value = "/distance",method = RequestMethod.GET)
	public ModelAndView getDistance(@ModelAttribute("UPLOAD_INVOICE_BEAN") LocationList locationList) {
		String s = "";
		GraphHopper graphHopper = new GraphHopper().setGraphHopperLocation(RouteOptimzerProperties.hopperDirectory)
				.setEncodingManager(new EncodingManager("car")).setOSMFile(RouteOptimzerProperties.osmFilePath);
		graphHopper.importOrLoad();
		List<GHPoint> ghList=new ArrayList<GHPoint>();
		MainClass main=new MainClass();
		ghList=main.locationToGraphHopper(locationList);
		GHRequest request = new GHRequest(ghList);
		request.putHint("calcPoints", false);
		request.putHint("instructions", true);
		request.setVehicle("car"); 
		GHResponse ghResponse = graphHopper.route(request);
		if (ghResponse.getInstructions() != null) {
			for (Instruction i : ghResponse.getInstructions()) {
				s += "------>\ntime <long>: " + i.getTime() + "\n" + "name: street name" + i.getName() + "\n"
						+ "annotation <InstructionAnnotation>" + i.getAnnotation() + "\n" + "distance" + i.getDistance()
						+ "\n" + "sign <int>:" + i.getSign() + "\n" + "Points <PointsList>: " + i.getPoints() + "\n";
			}
		}
		ModelAndView model=new ModelAndView("index");
		model.addObject("msg", s);
		return model;
	}
}
