package com.project.erp.support.gstian.examcell;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import com.project.erp.model.Users;

public class CustomUserDetailsService implements
		UserDetailsService {

	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	public UserDetails loadUserByUsername(String username) {
		
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Users user = (Users) session.get(Users.class, username);
		session.getTransaction().commit();
		session.close();
		if(user==null)
			throw new UsernameNotFoundException("Incorrect username");
		return(new CustomUserDetails(user.getUsername(),user.getPassword(),user.getAuthority()));		
	}
   
}
