package com.project.erp.service.gstian.examcell;

import java.util.List;

import com.project.erp.model.SubjectAllotment;

public interface SubjectAllotmentService {

	public void add(SubjectAllotment subject);
	public void edit(SubjectAllotment subject);
	public void delete(int subjectId);
	public SubjectAllotment getSubjectAlloted(int subjectId);
	public List<SubjectAllotment> getAllSubjectAlloted();
	public List<SubjectAllotment> subjectFetch(String branch,String semester);
	public List<SubjectAllotment> subjectFetch(String branch,String semester,String year);

}
