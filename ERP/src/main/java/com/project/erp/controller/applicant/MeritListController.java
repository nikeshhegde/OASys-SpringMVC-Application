package com.project.erp.controller.applicant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.project.erp.common.constant.ViewConstant;
import com.project.erp.common.util.logging.InjectableLogger;
import com.project.erp.forms.applicant.NewAdmissionForm1;
import com.project.erp.model.AcademicDetailsDse;
import com.project.erp.model.AdmissionUser1;
import com.project.erp.model.AdmissionUserBranchSelection;
import com.project.erp.model.AdmissionUserFeAcademics;
import com.project.erp.model.Branch;
import com.project.erp.model.MeritListFe;
import com.project.erp.model.PaymentLog;
import com.project.erp.model.Users;
import com.project.erp.service.applicant.AbstractService;
import com.project.erp.controller.applicant.TransactionIdController;

@Controller
@RequestMapping(value = "/")
public class MeritListController {

	@InjectableLogger
	public Logger logger;

	@Autowired
	private AbstractService abstractService;
	
	@Autowired
	private SessionFactory sessionFactory;


	@RequestMapping(value = "/generate-merit-list-dse" , method = RequestMethod.GET)
	public ModelAndView generateMeritListDse (Model model,@RequestParam(value="applied_under",required=false)String a)
	{
		ModelAndView mv=new ModelAndView();
		List students =abstractService.listRecord("AdmissionUser1");
		int i=0,j;
		Integer meritListNumber;
		
		List candidates=abstractService.listRecord("AdmissionUser1");
		
		List merit=abstractService.listRecord("MeritListDse");
		
		String type="Diploma";

		Session session=sessionFactory.openSession();
		
		Criteria cr=session.createCriteria(AdmissionUser1.class);
		
		if(a.equalsIgnoreCase("Linguistic Minority"))
		{
			cr.add(Restrictions.eq("admissionUserType", type)).add(Restrictions.eq("admissionUserAppliedUnder","Linguistic Minority")).add(Restrictions.eq("admissionUserStatus","Applied"));
			candidates=cr.list();
			session.close();
			meritListNumber=1;
		}
		if(a.equalsIgnoreCase("Institute"))
		{
			cr.add(Restrictions.eq("admissionUserType", type)).add(Restrictions.eq("admissionUserAppliedUnder","Institute")).add(Restrictions.eq("admissionUserStatus","Applied"));
			candidates=cr.list();
			session.close();
			meritListNumber=1;
		}
		List branch=abstractService.listRecord("Branch");
		Branch branchtemp=null;
		
		
		
		return mv;
	}
	@RequestMapping(value = "/generate-merit-list" , method = RequestMethod.GET)
	public ModelAndView generateMeritList(Model model)
	{
		ModelAndView mv=new ModelAndView();
		
		
		
		List students=abstractService.listRecord("AdmissionUser1");
		
		AdmissionUser1 student;
		
		int i=0;
		int j;
		/*
		while(i<students.size())
		{
			student=(AdmissionUser1)students.get(i++);
			student.setAdmissionUserType("FirstYearEngineering");
			abstractService.updateRecord(student);
		}
		*/
		
		Integer meritListNumber=1;
		
		List candidates=abstractService.listRecord("AdmissionUser1");
		
		List merit=abstractService.listRecord("MeritListFe");
		
		String type="FirstYearEngineering";
		
		
		Session session=sessionFactory.openSession();
		
		Criteria cr=session.createCriteria(AdmissionUser1.class);
		
		
			cr.add(Restrictions.eq("admissionUserType", type)).add(Restrictions.eq("admissionUserAppliedUnder","Linguistic Minority")).add(Restrictions.eq("admissionUserStatus","Applied"));
			candidates=cr.list();
			session.close();
			meritListNumber=1;
		/*
		if(a.equalsIgnoreCase("Institute"))
		{
			cr.add(Restrictions.eq("admissionUserType", type)).add(Restrictions.eq("admissionUserAppliedUnder","Institute")).add(Restrictions.eq("admissionUserStatus","Applied"));
			candidates=cr.list();
			session.close();
			meritListNumber=1;
		}
		*/
		List branch=abstractService.listRecord("Branch");
		Branch branchtemp=null;
		
		if(merit.size()!=0)
		{
			
			AdmissionUser1 temp;
			AdmissionUserBranchSelection tempBranch;
			String priority[]=new String[6];
			i=0;
			j=0;
			
			TransactionIdController br= new TransactionIdController();
			String branches[]=br.convertStrings(ViewConstant.ALL_BRANCHES_SHORT);
			while(j<merit.size())
			{
				temp=(AdmissionUser1)(((MeritListFe)merit.get(j)).getAdmissionUser1());

				tempBranch=temp.getAdmUserBranchSelection();
				
				priority[tempBranch.getAdmissionUserBranchSelectionBTPriority()-1]=branches[0];

				priority[tempBranch.getAdmissionUserBranchSelectionCEPriority()-1]=branches[1];

				priority[tempBranch.getAdmissionUserBranchSelectionEXTCPriority()-1]=branches[2];

				priority[tempBranch.getAdmissionUserBranchSelectionITPriority()-1]=branches[3];

				priority[tempBranch.getAdmissionUserBranchSelectionMECHPriority()-1]=branches[4];

				priority[tempBranch.getAdmissionUserBranchSelectionPPTPriority()-1]=branches[5];
				
				
				if(((MeritListFe)merit.get(j)).getBranchAssigned().equals(priority[0]) && (temp.getAdmissionUserStatus().equals("Shortlisted")))
					{	
							temp.setAdmissionUserStatus("Not elliglible");
							abstractService.updateRecord(temp);
							i=0;
							while(i<branch.size())
								{	
								if(((Branch)branch.get(i)).getBranchAbbreviation().equals(priority[0]))
									{
									((Branch)branch.get(i)).setSeatsAvailable(((Branch)branch.get(i)).getSeatsAvailable()+1);
									abstractService.updateRecord((Branch)branch.get(i));
									break;
									}
								i++;
								}
							
					}
				

				
					
				
				if(!((MeritListFe)merit.get(j)).getBranchAssigned().equals(priority[0]))
				{
					candidates.add(temp);
				}
				j++;
			}
			meritListNumber=((MeritListFe)merit.get(merit.size()-1)).getMeritListNumber()+1;
		}
		
		logger.debug("Size of candidates iz"+candidates.size());
		generateMeritList(candidates, meritListNumber);
		
		//double marks1,marks2,marksjt1,marksjt2,marksjm1,marksjm2,marksjp1,marksjp2;
		
				
		/* SORTED MERIT LIST  IN ADMISSIONUSER1*/
		
		List meritListStudents=abstractService.listRecord("MeritListFe");
		
		//logger.debug("Size of candidate is"+sortedCandidates.size());
		//List admUserList=Arrays.asList(admUserFe);
		
		model.addAttribute("students",meritListStudents);
		
		mv.setViewName("applicant/Admission/Merit");
		
		
		
		return mv;
	}

	
	
	@RequestMapping(value = "/view-merit-list" , method = RequestMethod.GET)
	public ModelAndView viewMeritList(Model model,HttpSession session,/*@RequestParam(value="listnumber")String listnumber,*/Authentication auth){
		
		ModelAndView mv  = new ModelAndView();
		
		List shortListed=abstractService.listRecord("MeritListFe");
		
		
		model.addAttribute("students", shortListed);
		//model.addAttribute("type","meritlist");
		mv.setViewName("applicant/Admission/Merit");
		return mv;
		
	}
	
	public void generateMeritList(List candidates, Integer meritListNumber)
	{
		AdmissionUserFeAcademics admUserFe[]=new AdmissionUserFeAcademics[candidates.size()]; 
		
		AdmissionUserFeAcademics temp;
		
		double marks1,marks2,marksjt1,marksjt2,marksjp1,marksjm1,marksjm2,marksjp2,marksjc1,marksjc2,marksxiipercent1,marksxiipercent2;
		
		double marksxiim1,marksxiim2,marksxiip1,marksxiip2,marksxiic1,marksxiic2;
		
		int i,j;
		j=0;
		List sortedCandidates=candidates;
		AdmissionUser1 tempCandidate;
		while(j<candidates.size())
		{
			admUserFe[j]=((AdmissionUser1)(candidates.get(j))).getAdmissionUserFeAcademics();
			j++;
		}
		i=0;
		j=0;
		for(i=0;i<candidates.size();i++){
			   for( j=0; j<(candidates.size()-i-1); j++){	
			//marks1 and marks2 are meritscore..
			
			
			marks1=admUserFe[j].getAdmissionUserFeAcademicsMeritScore().doubleValue();
			marks2=admUserFe[j+1].getAdmissionUserFeAcademicsMeritScore().doubleValue();
			
			//logger.debug(marks1+" and "+marks2);
			if(marks1<marks2)
			{
				//logger.debug("Swapping");
				temp=admUserFe[j];
				admUserFe[j]=admUserFe[j+1];
				admUserFe[j+1]=temp;
				
				
				tempCandidate=(AdmissionUser1)sortedCandidates.get(j);
				sortedCandidates.set(j, (AdmissionUser1)sortedCandidates.get(j+1));
				sortedCandidates.set((j+1), tempCandidate);
			}
			
			else if(marks1==marks2)
			{
			
				marksjt1=admUserFe[j].getAdmissionUserFeAcademicsJeeTotalObtained().doubleValue();
				marksjt2=admUserFe[j+1].getAdmissionUserFeAcademicsJeeTotalObtained().doubleValue();
				
				if(marksjt1<marksjt2)
				{
					temp=admUserFe[j];
					admUserFe[j]=admUserFe[j+1];
					admUserFe[j+1]=temp;
					tempCandidate=(AdmissionUser1)sortedCandidates.get(j);
					sortedCandidates.set(j, (AdmissionUser1)sortedCandidates.get(j+1));
					sortedCandidates.set((j+1), tempCandidate);
				}
				else if(marksjt1==marksjt2)
				{

					marksjm1=admUserFe[j].getAdmissionUserFeAcademicsJeeMathsObtained().doubleValue();
					marksjm2=admUserFe[j+1].getAdmissionUserFeAcademicsJeeMathsObtained().doubleValue();
					if(marksjm1<marksjm2)
					{
						temp=admUserFe[j];
						admUserFe[j]=admUserFe[j+1];
						admUserFe[j+1]=temp;
						tempCandidate=(AdmissionUser1)sortedCandidates.get(j);
						sortedCandidates.set(j, (AdmissionUser1)sortedCandidates.get(j+1));
						sortedCandidates.set((j+1), tempCandidate);
					}
					else if(marksjm1==marksjm2)
					{
					marksjp1=admUserFe[j].getAdmissionUserFeAcademicsJeePhysicsObtained().doubleValue();
						marksjp2=admUserFe[j+1].getAdmissionUserFeAcademicsJeePhysicsObtained().doubleValue();
						if(marksjp1<marksjp2)
						{
							temp=admUserFe[j];
							admUserFe[j]=admUserFe[j+1];
							admUserFe[j+1]=temp;
							tempCandidate=(AdmissionUser1)sortedCandidates.get(j);
							sortedCandidates.set(j, (AdmissionUser1)sortedCandidates.get(j+1));
							sortedCandidates.set((j+1), tempCandidate);
						}
						else if(marksjp1==marksjp2)
						{
						marksjc1=admUserFe[j].getAdmissionUserFeAcademicsJeeChemistryObtained().doubleValue();
						marksjc2=admUserFe[j+1].getAdmissionUserFeAcademicsJeeChemistryObtained().doubleValue();
							if(marksjc1<marksjc2)
							{
								temp=admUserFe[j];
								admUserFe[j]=admUserFe[j+1];
								admUserFe[j+1]=temp;
								tempCandidate=(AdmissionUser1)sortedCandidates.get(j);
								sortedCandidates.set(j, (AdmissionUser1)sortedCandidates.get(j+1));
								sortedCandidates.set((j+1), tempCandidate);
							}
							else if(marksjc1==marksjc2)
							{
							marksxiipercent1=admUserFe[j].getAdmissionUserFeAcademicsBoardPercentileObtained().doubleValue();
							marksxiipercent2=admUserFe[j+1].getAdmissionUserFeAcademicsBoardPercentileObtained().doubleValue();
								if(marksxiipercent1<marksxiipercent2)
								{
									temp=admUserFe[j];
									admUserFe[j]=admUserFe[j+1];
									admUserFe[j+1]=temp;
									tempCandidate=(AdmissionUser1)sortedCandidates.get(j);
									sortedCandidates.set(j, (AdmissionUser1)sortedCandidates.get(j+1));
									sortedCandidates.set((j+1), tempCandidate);
								}
								else if(marksxiipercent1==marksxiipercent2)
								{
									marksxiim1=admUserFe[j].getAdmissionUserFeAcademicsXiiMathsMarksObtained().doubleValue();
									marksxiim2=admUserFe[j+1].getAdmissionUserFeAcademicsXiiMathsMarksObtained().doubleValue();
									if(marksxiipercent1<marksxiipercent2)
									{
										temp=admUserFe[j];
										admUserFe[j]=admUserFe[j+1];
										admUserFe[j+1]=temp;
										tempCandidate=(AdmissionUser1)sortedCandidates.get(j);
										sortedCandidates.set(j, (AdmissionUser1)sortedCandidates.get(j+1));
										sortedCandidates.set((j+1), tempCandidate);
									}
									else if(marksxiim1==marksxiim2)
									{
										marksxiip1=admUserFe[j].getAdmissionUserFeAcademicsXiiPhysicsMarksObtained().doubleValue();
										marksxiip2=admUserFe[j+1].getAdmissionUserFeAcademicsXiiPhysicsMarksObtained().doubleValue();
										if(marksxiip1<marksxiip2)
										{
											temp=admUserFe[j];
											admUserFe[j]=admUserFe[j+1];
											admUserFe[j+1]=temp;
											tempCandidate=(AdmissionUser1)sortedCandidates.get(j);
											sortedCandidates.set(j, (AdmissionUser1)sortedCandidates.get(j+1));
											sortedCandidates.set((j+1), tempCandidate);
										}
										else if(marksxiip1==marksxiip2)
										{
											marksxiic1=admUserFe[j].getAdmissionUserFeAcademicsXiiChemistryMarksObtained().doubleValue();
											marksxiic2=admUserFe[j+1].getAdmissionUserFeAcademicsXiiChemistryMarksObtained().doubleValue();
										
											if(marksxiic1<marksxiic2)
											{
												temp=admUserFe[j];
												admUserFe[j]=admUserFe[j+1];
												admUserFe[j+1]=temp;
												tempCandidate=(AdmissionUser1)sortedCandidates.get(j);
												sortedCandidates.set(j, (AdmissionUser1)sortedCandidates.get(j+1));
												sortedCandidates.set((j+1), tempCandidate);
											}
											else if(marksxiic1==marksxiic2)
											{
												//logger.info("x percent "+admUserFe[j].getId()+" "+admUserFe[j+1]);
												/*
												double marksxpercent1=admUserFe[j].getAdmissionUserFeAcademicsSscPercentageObtained().doubleValue();
												double marksxpercent2=admUserFe[j+1].getAdmissionUserFeAcademicsSscPercentageObtained().doubleValue();
											
												if(marksxpercent1<marksxpercent2)
												{
													temp=admUserFe[j];
													admUserFe[j]=admUserFe[j+1];
													admUserFe[j+1]=temp;
													tempCandidate=(AdmissionUser1)sortedCandidates.get(j);
													sortedCandidates.set(j, (AdmissionUser1)sortedCandidates.get(j+1));
													sortedCandidates.set((j+1), tempCandidate);
												}
												else if(marksxpercent1==marksxpercent2)
												{
													double marksxm1=admUserFe[j].getAdmissionUserFeAcademicsSscMathsMarksObtained().doubleValue();
													double marksxm2=admUserFe[j+1].getAdmissionUserFeAcademicsSscMathsMarksObtained().doubleValue();
												
													if(marksxm1<marksxm2)
													{
														temp=admUserFe[j];
														admUserFe[j]=admUserFe[j+1];
														admUserFe[j+1]=temp;
														tempCandidate=(AdmissionUser1)sortedCandidates.get(j);
														sortedCandidates.set(j, (AdmissionUser1)sortedCandidates.get(j+1));
														sortedCandidates.set((j+1), tempCandidate);
													}
													else if(marksxm1==marksxm2)
													{
														java.sql.Date date1=((AdmissionUser1)candidates.get(j)).getAdmissionUserDateOfBirth();
														java.sql.Date date2=((AdmissionUser1)candidates.get(j+1)).getAdmissionUserDateOfBirth();
																						
													}
													else{
														
													}
												}
												else{
													
												}
												*/
											}
											else{}
										}
										else{}
									
									}
									else{}
								
								}
								else{}
								
							}else{}
							
						}else{}
						
					}else{}
				}
				else{}
			}
			else
			{}

		
			   
			   }

		}
		
		i=0;
		
		AdmissionUserBranchSelection tempBranch;
		String priority[]=new String[6];
		List studentBranchPriorityList;
		Branch branchRecord=null;
		int k=0;
		MeritListFe meritListRecord;
		AdmissionUser1 sortedCandidate;
		studentBranchPriorityList=abstractService.listRecord("Branch");
		while(i<sortedCandidates.size())
		{
			
			
			sortedCandidate=(AdmissionUser1)sortedCandidates.get(i);
			tempBranch=sortedCandidate.getAdmUserBranchSelection();
			
			
			priority[tempBranch.getAdmissionUserBranchSelectionBTPriority()-1]="BT";

			priority[tempBranch.getAdmissionUserBranchSelectionCEPriority()-1]="CE";

			priority[tempBranch.getAdmissionUserBranchSelectionEXTCPriority()-1]="EXTC";

			priority[tempBranch.getAdmissionUserBranchSelectionITPriority()-1]="IT";

			priority[tempBranch.getAdmissionUserBranchSelectionMECHPriority()-1]="MECH";

			priority[tempBranch.getAdmissionUserBranchSelectionPPTPriority()-1]="PPT";
			
			
			
			for(j=0;j<priority.length;j++)
			{
				
				
				
				for(k=0;k<studentBranchPriorityList.size();k++)
					{
					branchRecord=(Branch)studentBranchPriorityList.get(k);
					if((branchRecord).getBranchAbbreviation().equals(priority[j]))
						{
						if(branchRecord.getSeatsAvailable()>0)
							{
							break;
							}
						}
					}
				
				if(k!=studentBranchPriorityList.size())
					{
					Session session=sessionFactory.openSession();
					Criteria cr=session.createCriteria(MeritListFe.class);
					cr.add(Restrictions.eq("branchAssigned", priority[j])).add(Restrictions.eq("admissionUser1", sortedCandidate));
					List check=cr.list();
					session.close();
					if(check.size()==0)
						{
						meritListRecord=new MeritListFe();
						meritListRecord.setBranchAssigned(priority[j]);
						meritListRecord.setMeritListNumber(meritListNumber);
						meritListRecord.setAdmissionUser1(sortedCandidate);
						meritListRecord.setMeritListFeCompositeRank(i+1);
						abstractService.addRecord(meritListRecord);
						sortedCandidate.setAdmissionUserStatus("Shortlisted");
						sortedCandidate.setAdmissionUserBranch(priority[j]);
						abstractService.updateRecord(sortedCandidate);
						branchRecord.setSeatsAvailable(branchRecord.getSeatsAvailable()-1);
						abstractService.updateRecord(branchRecord);
						break;
						}
					}
				
			}
			
			i++;
		}
		
	}
	
}
