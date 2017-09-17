package com.qut.routeOptimizerWebApp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
import com.qut.routeOptimizerWebApp.Bean.UploadInvoiceBean;

@Controller
public class MainClass {
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index() {
	    return "index";
	}
	
	@RequestMapping(value = "/save",method = RequestMethod.GET)
	public ModelAndView getDistance(@ModelAttribute("locations") UploadInvoiceBean uploadInvoiceBean,Model model) {
		String s = "";
		RouteOptimzerProperties routeOptimzerProperties=new RouteOptimzerProperties();
		System.out.println(routeOptimzerProperties.hopperDirectory);
		System.out.println(routeOptimzerProperties.osmFilePath);
		GraphHopper graphHopper = new GraphHopper().setGraphHopperLocation(routeOptimzerProperties.hopperDirectory)
				.setEncodingManager(new EncodingManager("car")).setOSMFile(routeOptimzerProperties.osmFilePath);
		graphHopper.importOrLoad();
		List<GHPoint> ghList=new ArrayList<GHPoint>();
		GHPoint ghPoint=new GHPoint();
		
		for(Location address:uploadInvoiceBean.getLocationList())
		{
			System.out.println(address.getLatitude());
			ghPoint.lat=Double.parseDouble(address.getLatitude());
			ghPoint.lon=Double.parseDouble(address.getLongitude());
			ghList.add(ghPoint);
		}
		GHRequest request = new GHRequest(ghList);
		request.putHint("calcPoints", false);
		request.putHint("instructions", true);
		request.setVehicle("car"); 
		GHResponse ghResponse = graphHopper.route(request);
		System.out.println("hello"+request.toString());
		if (ghResponse.getInstructions() != null) {
			for (Instruction i : ghResponse.getInstructions()) {
				s += "------>\ntime <long>: " + i.getTime() + "\n" + "name: street name" + i.getName() + "\n"
						+ "annotation <InstructionAnnotation>" + i.getAnnotation() + "\n" + "distance" + i.getDistance()
						+ "\n" + "sign <int>:" + i.getSign() + "\n" + "Points <PointsList>: " + i.getPoints() + "\n";
			}
		}
		System.out.println("hello"+s);
		uploadInvoiceBean.setStatus("SUCCESS");
		System.out.println("hello"+s);
		model.addAttribute("msg", s);
		model.addAttribute("locationList", uploadInvoiceBean);
		return new ModelAndView("index","model", model);
	}
}
