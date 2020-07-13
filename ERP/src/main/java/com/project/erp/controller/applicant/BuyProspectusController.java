package com.project.erp.controller.applicant;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.project.erp.common.util.logging.InjectableLogger;
import com.project.erp.service.applicant.AbstractService;

@Controller
@RequestMapping(value = "/")


public class BuyProspectusController {

	
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
	
	@RequestMapping(value = "/buy_prospectus" ,method = RequestMethod.GET)
	public ModelAndView buy_prospectus(Model model, HttpSession session) {
		
		ModelAndView mv=new ModelAndView();
		mv.setViewName("applicant/Admission/buy_prospectus");
		return  mv;
		
	}

}
