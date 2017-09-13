package com.qut.routeOptimizerWebApp;

import org.springframework.stereotype.Controller;


public class MainClass {
/*public String getReponse(NavigationPosition source,NavigationPosition destination,String vehicle) {
	 String s = "";
	 GraphHopper graphHopper = new GraphHopper().setGraphHopperLocation(RouteOptimzerProperties.hopperDirectory)
				.setEncodingManager(new EncodingManager("car")).setOSMFile(RouteOptimzerProperties.osmFilePath);
	 graphHopper.importOrLoad();
	 GHRequest request = new GHRequest().addPoint(new GHPoint(source., orig[1]))
				.addPoint(new GHPoint(dest[0], dest[1])).addPoint(new GHPoint(-27.544866, 153.092784));
		request.putHint("calcPoints", false);
		request.putHint("instructions", true);
		// request.setWeighting("fastest");
		request.setVehicle("car"); // "car"
		
	return s;
}
	public static void main(String[] args) throws IOException {
		GraphHopper graphHopper = new GraphHopper().setGraphHopperLocation(RouteOptimzerProperties.hopperDirectory)
				.setEncodingManager(new EncodingManager("car")).setOSMFile(RouteOptimzerProperties.osmFilePath);

		graphHopper.importOrLoad();
		double[] orig = new double[] { -27.477356, 153.028423 };
		double[] dest = new double[] { -27.575710, 153.092426 };
		GHRequest request = new GHRequest().addPoint(new GHPoint(orig[0], orig[1]))
				.addPoint(new GHPoint(dest[0], dest[1])).addPoint(new GHPoint(-27.544866, 153.092784));
		request.putHint("calcPoints", false);
		request.putHint("instructions", true);
		// request.setWeighting("fastest");
		request.setVehicle("car"); // "car"
		
		GHResponse ghResponse = graphHopper.route(request);
		 String s = "";
		 if (ghResponse.getInstructions() != null) {
		        for (Instruction i : ghResponse.getInstructions()) {
		            s += "------>\ntime <long>: " + i.getTime() + "\n" + "name: street name" + i.getName() + "\n" +
		                    "annotation <InstructionAnnotation>" +
		                    i.getAnnotation() + "\n" + "distance" + i.getDistance() + "\n" + "sign <int>:" + i.getSign() +
		                    "\n" + "Points <PointsList>: " + i.getPoints() + "\n";
		        }
		    }
		//PointList pl=res.getPoints();
		//double distance = res.getDistance();
		// time of the full path, in milliseconds
		//long millis = res.getMillis();
		// get information per turn instruction
		//InstructionList il = res.getInstructions();
		//System.out.println(request.toString());
		System.out.println( "\ninstructions\n" + s);
	}*/
}
