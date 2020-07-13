package com.project.erp.serviceImpl.gstian.examcell;

import java.util.List;

import com.project.erp.model.KtAppliedList;
import com.project.erp.model.StudentDetails;

public class AcknowledgementGeneration {

	 String style, ackHeader, details, subjects, ackFooter;
	// append after header
	 String studentCopy = "<br/><strong style=\"float:right;\">[Student Copy]</strong>";
	
	//append after header
	 String examCellCopy="<strong style=\"float:right;\">[Exam Cell Copy]</strong>";
	
	String delimiter="-----------------------------------------------------Cut Here-----------------------------------------------------------<br/>";

	String endTags="</body></html>";
	
	StringBuffer acknowledgement;
	

	public AcknowledgementGeneration(StudentDetails studentDetails,
			List<KtAppliedList> applications) {
		style();
		//System.out.println(style);
		acknowledgementHeader();
		//System.out.println(ackHeader);
		addStudentDetails(studentDetails);
		//System.out.println(details);		
		addSubjects(applications);
		//System.out.println(subjects);
		acknowledgementFooter();
		
		
		String student=style+ackHeader+studentCopy+details+subjects+ackFooter+delimiter;
		String examCell=ackHeader+examCellCopy+details+subjects+ackFooter+endTags;
		
		acknowledgement=new StringBuffer(student);
		acknowledgement.append(examCell);
	}

	private void style() {
		style = "<html><head><style>table,th,td{text-align:center;border-collapse: collapse;} th,td{border:1px solid;}</style></head><body>";

	}

	private void acknowledgementHeader() {
		ackHeader= "<div style=\" margin-right:auto; margin-left:auto; width: 550px;border:1px solid; padding:10px; \"><div style=\"text-align:center;\">University Of Mumbai<br/>SIES Graduate of Technology<br/><strong>Acknowledgement</strong></div>";
	}

	private void addStudentDetails(StudentDetails studentDetails) {
		details = "<div style=\"border-bottom:1px;border-top:1px\">";
		details += "Name : " + studentDetails.getStudentName() + "<br/>";
		details += "Roll No :" + studentDetails.getRollnumber() + "<br/>";
		details += "Student Type :KT<br/>";
		details += "Branch :" + studentDetails.getBranch() + "<br/>";
		//details += "Sem :" + studentDetails.getSemester() + "<br/>";
	}

	private void addSubjects(List<KtAppliedList> applications) {
		subjects="Applying for examination for the following subjects:<table style=\"width:550px; border:1px solid;\"  ><tr><th>Subject Code</th><th>Subject</th><th>Types</th><th>Sem</th></tr>";
		for (KtAppliedList application : applications) {
			subjects+="<tr>"+"<td>"+application.getSubjectCode()+"</td>"+"<td>"+application.getSubject()+"</td>"+"<td>"+application.getKtTypes()+"</td>"+"<td>"+application.getSemester()+"</td></tr>";
		}
		
		subjects+="</table>";
	}

	private void acknowledgementFooter() {
		ackFooter="<br/><br/><pre>Candidate Signature          College Seal and Sign of Authorized staff</pre><br/>Fee Received and Form Confirmed.</div></div>";
	}

	public StringBuffer getAcknowledgement() {
		return acknowledgement;
	}
	
	
	
}
