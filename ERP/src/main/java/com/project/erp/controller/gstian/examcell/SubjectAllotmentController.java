package com.project.erp.controller.gstian.examcell;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.erp.model.SubjectAllotment;
import com.project.erp.service.gstian.examcell.SubjectAllotmentService;


@Controller
@PreAuthorize("hasRole('EXAMCELLCOORD')")
@RequestMapping("/subjectallotment")
public class SubjectAllotmentController {

	@Autowired
	private SubjectAllotmentService subjectAllotmentService;

	
	@RequestMapping(value = {"/","/listSubjectAlloted"})
	public String listSubjectsAlloted(Map<String,Object> map){
		
		map.put("subjectAlloted", new SubjectAllotment());
		map.put("subjectAllotedList", subjectAllotmentService.getAllSubjectAlloted());
		return "/gstian/examcell/subjectallotment/listSubjectAlloted";
		
	}
	
	@RequestMapping("/get/{subjectAllotedId}")
	public String getAllotedSubject(@PathVariable int subjectAllotedId, Map<String, Object> map){
		
		SubjectAllotment subjectAlloted= subjectAllotmentService.getSubjectAlloted(subjectAllotedId);
		map.put("subjectAlloted", subjectAlloted);
		return "/gstian/examcell/subjectallotment/subjectAllotmentForm";
	}
	
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String add(@ModelAttribute("subjectAlloted") SubjectAllotment subjectAlloted, BindingResult result){
		
		subjectAllotmentService.add(subjectAlloted);
		return "redirect:gstian/examcell/listSubjectAlloted";
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String edit(@ModelAttribute("subjectAlloted") SubjectAllotment subjectAlloted, BindingResult result){
		
		subjectAllotmentService.edit(subjectAlloted);
		return "redirect:gstian/examcell/listSubjectAlloted";
	}
	
	@RequestMapping("/delete/{subjectAllotedId}")
	public String delete(@PathVariable("subjectAllotedId") int subjectId){
		subjectAllotmentService.delete(subjectId);
		return "redirect:/gstian/examcell/subjectallotment/listSubjectAlloted";
	}
	
	
	
}
