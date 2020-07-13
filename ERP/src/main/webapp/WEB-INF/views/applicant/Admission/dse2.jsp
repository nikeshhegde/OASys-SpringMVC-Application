<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml"><head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>DSE - Step II</title>
<link href="resources/applicant/Dashboard/form-wizard/css/demo_style.css" rel="stylesheet" type="text/css">

<link href="resources/applicant/Dashboard/form-wizard/css/smart_wizard.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="resources/applicant/Dashboard/form-wizard/js/jquery-2.0.0.min.js"></script>
<script type="text/javascript" src="resources/applicant/Dashboard/form-wizard/js/jquery.smartWizard.js"></script>


<link href="resources/applicant/Dashboard/css/bootstrap.css" rel="stylesheet">
<link href="resources/applicant/Dashboard/css/archon.css" rel="stylesheet">
<link href="resources/applicant/Dashboard/css/responsive.css" rel="stylesheet">
<link href="resources/applicant/Dashboard/login/css/style.css" rel="stylesheet">
<link href="resources/applicant/Dashboard/css/style.css" rel="stylesheet">
<link href="resources/applicant/Dashboard/css/custom.css" rel="stylesheet">

</head>
<body>
					
  			<div id="step-2"  class="swMain">
  			<form id="form" action="dse3" method="get">
            <h2 class="StepTitle">Step 2-Academic details</h2>	
			<div class="form-group">
			<label for="inputEmail1" class="col-lg-2 control-label"></label>
					<div class="col-lg-11">
						<h3>SSC</h3>
					</div>
			</div>	
            <div class="form-group">
				<label for="inputEmail1" class="col-lg-2 control-label">Maths</label>
			<div class="col-lg-11">
					<input type="text" class="form-control" name="academicDetailsDseSscMarksMathsObtained" id="marks_maths_obtained" value='<c:catch var="exception">${userModelAcademics.getAcademicDetailsDseSscMarksMathsObtained()}</c:catch><c:if test="${not empty exception}"></c:if>' placeholder="Marks obtained" required>
					<label id="marks_maths_obtained-error" class="text-danger"></label>
					<input type="text" class="form-control" name="academicDetailsDseSscMarksTotalMaths" id="marks_total_maths" value='<c:catch var="exception">${userModelAcademics.getAcademicDetailsDseSscMarksTotalMaths()}</c:catch><c:if test="${not empty exception}"></c:if>' placeholder="Maximum marks" required >
					<label id="marks_total_maths-error" class="text-danger"></label>
				</div>
			</div>
			<br>
			<br>
			<br>
			<div class="form-group">
				<label for="inputEmail1" class="col-lg-2 control-label">Grand Total</label>
			<div class="col-lg-11">
					<input type="text" class="form-control" name="academicDetailsDseSscMarksGrandObtained" id="marks_grand_obtained" value='<c:catch var="exception">${userModelAcademics.getAcademicDetailsDseSscMarksGrandObtained()}</c:catch><c:if test="${not empty exception}"></c:if>' placeholder="Marks obtained" required>
						<label id="marks_grand_obtained-error" class="text-danger"></label>
					<input type="text" class="form-control" name="academicDetailsDseSscMarksTotalGrand" id="marks_total_grand" value='<c:catch var="exception">${userModelAcademics.getAcademicDetailsDseSscMarksTotalGrand()}</c:catch><c:if test="${not empty exception}"></c:if>' placeholder="Maximum marks" required>
				<label id="marks_total_grand-error" class="text-danger"></label>
				</div>
			</div>	
			
			<div class="form-group">
					<label for="inputEmail1" class="col-lg-2 control-label">Percentage obtained</label>
				<div class="col-lg-11">
						<input type="text" class="form-control" name="academicDetailsDseSscPercentageObtained" id="percentage_obtained" value='<c:catch var="exception">${userModelAcademics.getAcademicDetailsDseSscPercentageObtained()}</c:catch><c:if test="${not empty exception}"></c:if>' placeholder="Do not use % sign" required>
						<label id="percentage_obtained-error" class="text-danger"></label>
				</div>
			</div>
			
			<div class="form-group">
					<label for="inputEmail1" class="col-lg-2 control-label">Year of passing</label>
				<div class="col-lg-11">
						<input type="year" class="form-control" name="academicDetailsDseSscYearOfPassing" id="year_of_passing" value='<c:catch var="exception">${userModelAcademics.getAcademicDetailsDseSscYearOfPassing()}</c:catch><c:if test="${not empty exception}"></c:if>' placeholder="Year of passing" required>
						<label id="year_of_passing-error" class="text-danger"></label>
				</div>
			</div>	
			
			<div class="form-group">
			<label for="inputEmail1" class="col-lg-2 control-label"></label>
					<div class="col-lg-11">
						<h3>Diploma</h3>
					</div>
			</div>	
			
			<div class="form-group">
				<label for="inputEmail1" class="col-lg-2 control-label">1st Year (Diploma)</label>
			<div class="col-lg-11">
					<input type="text" class="form-control" name="academicDetailsDseDiplomaMarksFirstYearObtained" id="dse_admission_registration_first_yr_obtained" value='<c:catch var="exception">${userModelAcademics.getAcademicDetailsDseDiplomaMarksFirstYearObtained()}</c:catch><c:if test="${not empty exception}"></c:if>' placeholder="Marks obtained" required>
					<label id="dse_admission_registration_first_yr_obtained-error" class="text-danger"></label>
					<input type="text" class="form-control" name="academicDetailsDseDiplomaMarksTotalFirstYear" id="dse_admission_registration_first_yr_max" value='<c:catch var="exception">${userModelAcademics.getacademicDetailsDseDiplomaMarksTotalFirstYear()}</c:catch><c:if test="${not empty exception}"></c:if>' placeholder="Maximum marks" required>
					<label id="dse_admission_registration_first_yr_max-error" class="text-danger"></label>
					<label class="text-danger"></label>
				</div>
			</div>


			<div class="form-group">
				<label for="inputEmail1" class="col-lg-2 control-label">2nd Year(Diploma)</label>
				<div class="col-lg-11">
						<input type="text" class="form-control-hsc" name="academicDetailsDseDiplomaMarksSecondYearObtained" id="dse_admission_registration_second_yr_obtained" value='<c:catch var="exception">${userModelAcademics.getAcademicDetailsDseDiplomaMarksSecondYearObtained()}</c:catch><c:if test="${not empty exception}"></c:if>' placeholder="Marks obtained" required>
						<label id="dse_admission_registration_second_yr_obtained-error" class="text-danger"></label>
						<input type="text" class="form-control-hsc" name="academicDetailsDseDiplomaMarksTotalSecondYear" id="dse_admission_registration_second_yr_max" value='<c:catch var="exception">${userModelAcademics.getacademicDetailsDseDiplomaMarksTotalSecondYear()}</c:catch><c:if test="${not empty exception}"></c:if>' placeholder="Maximum marks" required>
						<label id="dse_admission_registration_second_yr_max-error" class="text-danger"></label>
				</div>
			</div>
			
			<div class="form-group">
				<label for="inputEmail1" class="col-lg-2 control-label">3rd Year(Diploma)</label>
			<div class="col-lg-11">
					<input type="text" class="form-control-hsc" name="academicDetailsDseDiplomaMarksThirdYearObtained" id="dse_admission_registration_third_yr_obtained" value='<c:catch var="exception">${userModelAcademics.getAcademicDetailsDseDiplomaMarksThirdYearObtained()}</c:catch><c:if test="${not empty exception}"></c:if>' placeholder="Marks obtained" required>
					<label id="dse_admission_registration_third_yr_obtained-error" class="text-danger"></label>
					<input type="text" class="form-control-hsc" name="academicDetailsDseDiplomaMarksTotalThirdYear" id="dse_admission_registration_third_yr_max" value='<c:catch var="exception">${userModelAcademics.getacademicDetailsDseDiplomaMarksTotalThirdYear()}</c:catch><c:if test="${not empty exception}"></c:if>' placeholder="Maximum marks" required>
					<label id="dse_admission_registration_third_yr_max-error" class="text-danger"></label>
				</div>
			</div>
			 
			
			<div class="form-group">
					<label for="inputEmail1" class="col-lg-2 control-label">Year of passing</label>
				<div class="col-lg-11">
						<input type="year" class="form-control" name="academicDetailsDseDiplomaYearOfPassing" id="diploma_year_of_passing" value='<c:catch var="exception">${userModelAcademics.getAcademicDetailsDseDiplomaYearOfPassing()}</c:catch><c:if test="${not empty exception}"></c:if>' placeholder="Year of passing of 3rd year diploma" required>
						<label id="diploma_year_of_passing-error" class="text-danger"></label>
				</div>
			</div>	
			
			
			<div class="form-group">
					<label for="inputEmail1" class="col-lg-2 control-label">State Level Rank</label>
				<div class="col-lg-11">
						<input type="text" class="form-control" name="academicDetailsDseDiplomaStateRank" id="State_Level_rank" value='<c:catch var="exception">${userModelAcademics.getAcademicDetailsDseDiplomaStateRank()}</c:catch><c:if test="${not empty exception}"></c:if>' placeholder="State Level Rank" required>
						<label id="State_Level_rank-error" class="text-danger"></label>
				</div>
			</div>
			
			
			<div class="form-group">
					<label for="inputEmail1" class="col-lg-2 control-label">University Rank</label>
				<div class="col-lg-11">
						<input type="text" class="form-control" name="academicDetailsDseDiplomaUniversityRank" id="University_rank" value='<c:catch var="exception">${userModelAcademics.getAcademicDetailsDseDiplomaUniversityRank()}</c:catch><c:if test="${not empty exception}"></c:if>' placeholder="University Rank" required>
						<label id="University_rank-error" class="text-danger"></label>
				</div>
			</div>
			
			
			<div class="form-group">
					<label for="inputEmail1" class="col-lg-2 control-label">Category Rank</label>
				<div class="col-lg-11">
						<input type="text" class="form-control" name="academicDetailsDseDiplomaCategoryRank" id="Category_rank" value='<c:catch var="exception">${userModelAcademics.getAcademicDetailsDseDiplomaCategoryRank()}</c:catch><c:if test="${not empty exception}"></c:if>' placeholder="Category Rank" required>
						<label id="Category_rank-error" class="text-danger"></label>
				</div>
			</div>
			<div class="form-group">	
				<input type="submit" value="Next" class="buttonNext"/>
				<a href="fe1"><input type="button" value="Previous" class="buttonPrevious" /></a>	
			</div>
			</form>
        </div>          
</body>	
</html>		