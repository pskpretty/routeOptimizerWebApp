package com.qut.routeOptimizerWebApp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.graphhopper.GHRequest;
import com.graphhopper.GHResponse;
import com.graphhopper.GraphHopper;
import com.graphhopper.routing.util.EncodingManager;
import com.graphhopper.util.Instruction;
import com.graphhopper.util.shapes.GHPoint;
import com.qut.routeOptimizerWebApp.Bean.UploadInvoiceBean;

@Controller

public class MainClass {
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index() {
	    return "index";
	}
	
	@RequestMapping(value = "/distance",method = RequestMethod.GET)
	public ModelAndView getDistance(@ModelAttribute("UPLOAD_INVOICE_BEAN") UploadInvoiceBean uploadBean) {
		String s = "";
		GraphHopper graphHopper = new GraphHopper().setGraphHopperLocation(RouteOptimzerProperties.hopperDirectory)
				.setEncodingManager(new EncodingManager("car")).setOSMFile(RouteOptimzerProperties.osmFilePath);
		graphHopper.importOrLoad();
		GHRequest request = new GHRequest().addPoint(new GHPoint(Double.parseDouble(uploadBean.getSourcelat()), Double.parseDouble(uploadBean.getSourcelon())))
				.addPoint(new GHPoint(Double.parseDouble(uploadBean.getDestinationlat()), Double.parseDouble(uploadBean.getDestinationlon())));
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
