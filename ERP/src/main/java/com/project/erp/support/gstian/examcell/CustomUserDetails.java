package com.project.erp.support.gstian.examcell;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUserDetails extends User implements UserDetails {
	
	private String toast="the glass of awesome";
public CustomUserDetails(String uname,String pword,String auth) {
	super(uname,pword,AuthorityUtils.createAuthorityList(auth));
}
public String getToast() {
	return toast;
}
public void setToast(String toast) {
	this.toast = toast;
}

}
