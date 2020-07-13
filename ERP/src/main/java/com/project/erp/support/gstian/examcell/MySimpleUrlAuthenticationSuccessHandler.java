package com.project.erp.support.gstian.examcell;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

public class MySimpleUrlAuthenticationSuccessHandler implements AuthenticationSuccessHandler{

	@Override
	public void onAuthenticationSuccess(HttpServletRequest arg0,
			HttpServletResponse arg1, Authentication arg2) throws IOException,
			ServletException {
		// TODO Auto-generated method stub
         ModelAndView mv = meow();
	}

	
	public ModelAndView meow() {
		
		
		ModelAndView mv=new ModelAndView();
		//model.addAttribute("userModel", session.getAttribute("userModel"));
		mv.setViewName("index");
		return  mv;
		
	}	


}
