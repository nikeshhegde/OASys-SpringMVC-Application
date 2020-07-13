package com.project.erp.daoImpl.gstian.examcell;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.project.erp.dao.gstian.examcell.MasterTableAnalysisDao;
import com.project.erp.model.KtStudents;
import com.project.erp.model.MasterTable;
import com.project.erp.model.StudentDetails;
import com.project.erp.model.Users;

@Repository
public class MasterTableAnalysisDaoImpl implements MasterTableAnalysisDao {

	Session session;
	
	
	
	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public void populateMasterTable(String[] record,Session session) {

		System.out.println(record.length);
		Query query = session
				.createQuery("from MasterTable where rollNumber=? and subjectCode=?");
		query.setString(0, record[0]);
		query.setString(1, record[7]);
		List<MasterTable> list = query.list();

		if (list.isEmpty()) {
			MasterTable table = new MasterTable();
			table.setRollNumber(record[0]);
			table.setName(record[1]);
			table.setBranch(record[2]);
			table.setBranchCode(record[3]);
			table.setYear(Integer.parseInt(record[4]));
			table.setSemester(record[5]);
			table.setSubject(record[6]);
			table.setSubjectCode(record[7]);
			table.setSubjectMarks(record[8]);
			table.setTheoryGrade(record[9]);
			table.setPracticalMarks(record[10]);
			table.setPracticalGrade(record[11]);
			if(record.length==17) //practical and oral are separate
			{
				table.setOralMarks(record[12]);
				table.setOralGrade(record[13]);
				table.setInternalMarks(record[14]);
				table.setInternalGrade(record[15]);
				table.setGender(record[16]);
				System.out.println("breaking..");
				
			}
			else{    //practical-oral is same
				table.setOralMarks("");
				table.setOralGrade("");
				table.setInternalMarks(record[12]);
				table.setInternalGrade(record[13]);
				table.setGender(record[14]);
			}
			session.beginTransaction();
			session.save(table);
			session.getTransaction().commit();
		}
	}

	public void studentDetailsManage(String[] record,Session session) {
		StudentDetails student = (StudentDetails) session.get(
				StudentDetails.class, record[0]);

		if (student == null) {
			student = new StudentDetails();
			student.setRollnumber(record[0]);
			student.setStudentName(record[1]);
			student.setBranch(record[2]);
			student.setBranchCode(record[3]);
			student.setSemester(record[5]);
			if(record.length==17)
			student.setGender(record[16]);
			else
				student.setGender(record[14]);

			session.beginTransaction();
			session.save(student);
			session.getTransaction().commit();
		}
	}

	public void usersManage(String[] record,Session session) {
		Users user = (Users) session.get(Users.class, record[0]);

		if (user == null) {
			user = new Users();
			user.setUsername(record[0]);
			user.setPassword("Student01");
			user.setAuthority("USER");

			session.beginTransaction();
			session.save(user);
			session.getTransaction().commit();
		}
	}

	@SuppressWarnings("unchecked")
	public void ktclassify(String[] record,Session session) {
				
			session.beginTransaction();
			KtStudents student;
			
			student=new KtStudents();
			student.setRollNumber(record[0]);
			student.setBranchCode(record[3]);
			student.setSubject(record[6]);
			student.setSubjectCode(record[7]);
			student.setSemester(record[5]);
			student.setTheoryKt(false);
			student.setPracticalKt(false);
			student.setOralKt(false);
			student.setInternalKt(false);
			
			if(record[9].equalsIgnoreCase("f")) //check theory kt
			{
				student.setTheoryKt(true);
			}
		
			if(record[11].equalsIgnoreCase("f"))//check for practical kt 
			{
				student.setPracticalKt(true);
			}
		
			
			if(record.length==17)  //practical and oral are different
			{
				if(record[13].equalsIgnoreCase("f"))//check for oral kt 
				{
					student.setOralKt(true);
				}
				
				if(record[15].equalsIgnoreCase("f"))//check for internal kt 
				{
					student.setInternalKt(true);
				}
			}
			
			else{
				
				if(record[13].equalsIgnoreCase("f"))//check for internal kt 
				{
					student.setInternalKt(true);
				}
			}
			
			if(student.isTheoryKt()||student.isPracticalKt()||student.isOralKt()||student.isInternalKt())
			session.save(student);
			
			session.getTransaction().commit();
			
		
	}
}
