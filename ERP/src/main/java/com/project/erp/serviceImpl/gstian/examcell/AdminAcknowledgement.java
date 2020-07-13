package com.project.erp.serviceImpl.gstian.examcell;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.project.erp.model.StudentDetails;

public class AdminAcknowledgement {

	 String style, ackHeader, details, subjects, ackFooter;
	// append after header
	 String studentCopy = "<br/><strong style=\"float:right;\">[Student Copy]</strong>";
	
	//append after header
	 //String examCellCopy="<strong style=\"float:right;\">[Exam Cell Copy]</strong>";
	
	//String delimiter="-----------------------------------------------------Cut Here-----------------------------------------------------------<br/>";

	//String endTags="</body></html>";
	
	StringBuffer acknowledgement;
	

	public AdminAcknowledgement(List<String> students,Session session,String branch,String sem) {
		style();
		//System.out.println(style);
		
		Criteria criteria=session.createCriteria(StudentDetails.class);
		
	    criteria.add(Restrictions.in("rollnumber", students));
	    
	    List<StudentDetails> studentDetails=criteria.list();
		
		addContent(studentDetails, branch, sem);
		//System.out.println(subjects);
		acknowledgementFooter();
		
		
		String student=style+details+ackFooter;
		
		
		acknowledgement=new StringBuffer(student);
		
	}

	private void style() {
		style = "<html><title>Report</title><head><style>table,th,tr,td{ border:1px solid;border-collapse: collapse;text-align:center;}.center1{margin-left:15%;}</style></head>";

	}

	
	private void addContent(List<StudentDetails> applications, String branch,String sem) {
		details = "<body><div class=\"center1\">SEM: "+sem+"<br/>Branch: "+applications.get(0).getBranch()+"<table><tr><th>SrNo</th><th>Roll NO</th><th>Name</th></tr>";
		int i=0;
		for (StudentDetails application : applications) {
			details+="<tr>"+"<td>"+Integer.toString(++i)+"</td>"+"<td>"+application.getRollnumber()+"</td>"+"<td>"+application.getStudentName()+"</td></tr>";
		}
	}

	
	private void acknowledgementFooter() {
		ackFooter="</table></div></body></html>";
	}

	public StringBuffer getAcknowledgement() {
		return acknowledgement;
	}
	
	
	
}
