package com.qut.routeOptimizerWebApp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.graphhopper.GHRequest;
import com.graphhopper.GHResponse;
import com.graphhopper.GraphHopper;
import com.graphhopper.routing.util.EncodingManager;
import com.graphhopper.util.Instruction;
import com.graphhopper.util.shapes.GHPoint;

@Controller

public class MainClass {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
	    return "index";
	}
	
	@RequestMapping(value = "distance",method = RequestMethod.GET)
	public String getDistance(@RequestParam(value="sourceArray[]") String[] sourceArray, @RequestParam(value="destinationArray[]") String[] destinationArray) {
		String s = "";
		GraphHopper graphHopper = new GraphHopper().setGraphHopperLocation(RouteOptimzerProperties.hopperDirectory)
				.setEncodingManager(new EncodingManager("car")).setOSMFile(RouteOptimzerProperties.osmFilePath);
		graphHopper.importOrLoad();
		GHRequest request = new GHRequest().addPoint(new GHPoint(Double.parseDouble(sourceArray[0]), Double.parseDouble(sourceArray[1])))
				.addPoint(new GHPoint(Double.parseDouble(destinationArray[0]), Double.parseDouble(destinationArray[1])));
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
		return s;
	}
}
