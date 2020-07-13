package com.project.erp.controller;
import java.io.IOException;
import java.io.InputStream;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamSource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;
 
@Controller
@RequestMapping(value = "/email")
public class SendEmailAttachController {
    @Autowired
    private JavaMailSender mailSender;
    
    @RequestMapping(value="/email-form",method = RequestMethod.GET)

	public ModelAndView emailForm(Model model, HttpSession session) {


		ModelAndView mv=new ModelAndView();
		mv.setViewName("EmailForm");
		return  mv;

	}

    @RequestMapping(value="/sendMail", method=RequestMethod.POST)
    public String sendEmailwithoutAttachment(HttpServletRequest request){
    	
    	final String emailTo = request.getParameter("mailTo");
        final String subject = request.getParameter("subject");
        final String message = request.getParameter("message");
 
        SimpleMailMessage message1 = createSimpleEmail(emailTo,subject,message);
        mailSender.send(message1);
    	return "Result";
    }
    
    public SimpleMailMessage createSimpleEmail(String to,String sub,String msg){
    	SimpleMailMessage temp = new SimpleMailMessage();
    	temp.setTo(to);
    	temp.setSubject(sub);
    	temp.setText(msg);
    	
    	return temp;
    }
    
    public void mimeMessagewithEmail(final String emailTo,final String subject,final String message,final CommonsMultipartFile attachFile){

        mailSender.send(new MimeMessagePreparator() {
 
            @Override
            public void prepare(MimeMessage mimeMessage) throws Exception {
                MimeMessageHelper messageHelper = new MimeMessageHelper(
                        mimeMessage, true, "UTF-8");
                messageHelper.setTo(emailTo);
                messageHelper.setSubject(subject);
                messageHelper.setText(message);
                 
                // determines if there is an upload file, attach it to the e-mail
                String attachName = attachFile.getOriginalFilename();
                if (!attachFile.equals("")) {
 
                    messageHelper.addAttachment(attachName, new InputStreamSource() {
                         
                        @Override
                        public InputStream getInputStream() throws IOException {
                            return attachFile.getInputStream();
                        }
                    });
                }
                 
            }
 
        });
 
 
    }
    
    @RequestMapping(value="/sendMailAttached", method = RequestMethod.POST)
    public String sendEmail(HttpServletRequest request,
            final @RequestParam CommonsMultipartFile attachFile) {
 
        // reads form input
        final String emailTo = request.getParameter("mailTo");
        final String subject = request.getParameter("subject");
        final String message = request.getParameter("message");
 
        mimeMessagewithEmail(emailTo,subject,message,attachFile);
        
         return "Result";
    }
}