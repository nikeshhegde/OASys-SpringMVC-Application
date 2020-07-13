package com.project.erp.controller.applicant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.project.erp.common.constant.ViewConstant;
import com.project.erp.common.util.logging.InjectableLogger;
import com.project.erp.forms.applicant.GateWayForm;
import com.project.erp.service.applicant.AbstractService;

/**
 * This is login controller and comes in action when user click on login button.
 * 
 * @author ERP Developer
 *
 */
@Controller
@RequestMapping(value = "/")

public class GateWayController {

	@InjectableLogger
	public Logger logger;

	@Autowired
	private AbstractService abstractService;
	
	/**
	 * This method will call when user click on submit button
	 * 
	 * @param String
	 *            name
	 * @return {@link ModelAndView} model
	 */
	
	@RequestMapping(value = "/gateWay" , method = RequestMethod.POST)
	public ModelAndView handleButtonAction(
			@ModelAttribute("gateWay") GateWayForm gateWayForm,Model m, HttpSession session) {
		      
			logger.debug("yyy");
		ModelAndView model = new ModelAndView();
		if(gateWayForm.getNewUser().equalsIgnoreCase("admissionSeeker") ) {
			model.setViewName(ViewConstant.NEW_STUDENT_PAGE); 
			model.addObject("userID", session.getAttribute("userID"));
			
			String allBranchesShort=ViewConstant.ALL_BRANCHES_SHORT.replaceAll("'","");
			String allBranchesLong=ViewConstant.ALL_BRANCHES_LONG.replaceAll("'","");
			
			String splitShort[]=allBranchesShort.split(",");
			String splitLong[]=allBranchesLong.split(",");
			
			List<String> splitShortlist=new ArrayList<String>(Arrays.asList(splitShort));
			List splitLonglist=new ArrayList<String>(Arrays.asList(splitLong));
			logger.debug("Shutter");
			logger.debug("list is "+splitLonglist.size()+" "+splitLonglist.get(0));
			m.addAttribute("branch_dse",splitLonglist);
			m.addAttribute("short",splitShortlist);
			
			
		}
		else if (gateWayForm.getNewUser().equalsIgnoreCase("staff")){
			model.setViewName(ViewConstant.STAFF_PAGE); 
		}
		else if (gateWayForm.getNewUser().equalsIgnoreCase("existingStudent")){
			model.setViewName(ViewConstant.EXISTING_STUDENT_PAGE); 
		}
		
		
		
		return model;
	}
		
	
}
