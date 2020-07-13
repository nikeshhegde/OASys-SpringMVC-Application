<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml"><head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Smart Wizard 3 - Basic Example  - a javascript jQuery wizard control plugin</title>
<link href="/start/resources/mytheme/dashboard/form-wizard/css/demo_style.css" rel="stylesheet" type="text/css">

<link href="/start/resources/mytheme/dashboard/form-wizard/css/smart_wizard.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="/start/resources/mytheme/dashboard/form-wizard/js/jquery-2.0.0.min.js"></script>
<script type="text/javascript" src="/start/resources/mytheme/dashboard/form-wizard/js/jquery.smartWizard.js"></script>


<link href="/start/resources/mytheme/dashboard/css/bootstrap.css" rel="stylesheet">
<link href="/start/resources/mytheme/dashboard/css/archon.css" rel="stylesheet">
<link href="/start/resources/mytheme/dashboard/css/responsive.css" rel="stylesheet">
<link href="/start/resources/mytheme/dashboard/login/css/style.css" rel="stylesheet">
<link href="/start/resources/mytheme/dashboard/css/style.css" rel="stylesheet">
<link href="/start/resources/mytheme/dashboard/css/custom.css" rel="stylesheet">

<style>		
			.button_example{
			width:auto;
border:3px solid #25729a; -webkit-border-radius: 3px; -moz-border-radius: 3px;border-radius: 3px;font-size:12px;font-family:arial, helvetica, sans-serif; padding: 10px 10px 10px 10px; text-decoration:none; display:inline-block;text-shadow: -1px -1px 0 rgba(0,0,0,0.3);font-weight:bold; color: #FFFFFF;
 background-color: #3093c7; background-image: -webkit-gradient(linear, left top, left bottom, from(#3093c7), to(#1c5a85));
 background-image: -webkit-linear-gradient(top, #3093c7, #1c5a85);
 background-image: -moz-linear-gradient(top, #3093c7, #1c5a85);
 background-image: -ms-linear-gradient(top, #3093c7, #1c5a85);
 background-image: -o-linear-gradient(top, #3093c7, #1c5a85);
 background-image: linear-gradient(to bottom, #3093c7, #1c5a85);filter:progid:DXImageTransform.Microsoft.gradient(GradientType=0,startColorstr=#3093c7, endColorstr=#1c5a85);
}

.button_example:hover{
width:auto;
 border:3px solid #1c5675;
 background-color: #26759e; background-image: -webkit-gradient(linear, left top, left bottom, from(#26759e), to(#133d5b));
 background-image: -webkit-linear-gradient(top, #26759e, #133d5b);
 background-image: -moz-linear-gradient(top, #26759e, #133d5b);
 background-image: -ms-linear-gradient(top, #26759e, #133d5b);
 background-image: -o-linear-gradient(top, #26759e, #133d5b);
 background-image: linear-gradient(to bottom, #26759e, #133d5b);filter:progid:DXImageTransform.Microsoft.gradient(GradientType=0,startColorstr=#26759e, endColorstr=#133d5b);
}
.button-container {
 margin-top: 15px;
}

.bold
{
border-color:#000;
}
</style>
<script>
$(document).ready(function(){
	//alert("abeee");
	var s="${inputList}";	
	var el=obtainStringArray(s);
	var i=0;
	var entities="${entities}";
	var entity=obtainStringArray(entities);
	for(i=0;i<el.length;i++)
		{
		el[i]=el[i].trim();
		}
	
	var parentEntity="${parentEntity}";
	var entityButtons="<input type='button' name="+parentEntity+" class='navbar bold button_example' id='"+parentEntity+"-id' value="+parentEntity+" />";
	for(i=0;i<entity.length;i++)
	{
	entity[i]=entity[i].trim();
	entityButtons+="<input type='button' name="+entity[i]+" class='navbar bold button_example' id='"+entity[i]+"-id' value="+entity[i]+" />";
	}
	
	$("#entities").append(entityButtons);
	//alert("But here");
	
	
	for(i=0;i<el.length;i++)
		{
		alert(el[i]+" is the element");
		}
	
	
	
	var j=(entity.length)-1;
	var arr=[];
	i=(el.length)-2;
	var k=0;
	//alert(el[i]);
	//alert(entity[j]);
	var op1,op2;
	alert("outside while");
	while(j>=0)
		{
		alert("j inside");
		arr[j+1]=[];
		k=0;
		alert(el[i].toLowerCase()+"   "+entity[j].toLowerCase());
		//alert("Outside while"+el[i].toLowerCase()+" "+entity[j].toLowerCase());
		while((el[i].toLowerCase()).search(entity[j].toLowerCase())==0)
			{
			alert("going");
			//alert(j+" inside while");
			//alert(el[i]+" "+entity[j]);
			arr[j+1][k++]=el[i];
			alert(arr[j+1][k-1]);
			i--;
			}
		//alert("decrement");
		
		j--;
		}

	
	
	//alert(entityButtons);
	
	/*
	$("#All").change(function(){
		var checked=$("input[name=All]").is(":checked");
		
			for(i=0;i<el.length;i++)
				{	
				$("#"+el[i]+"-id").prop('checked',checked);
				}	
				
	});
	*/
	/*
	$("#conditionadd").click(function(){
		
		var condition="<div><select name='attribute' class='form-control'>";
		var i=0;
		for(i=0;i<el.length;i++)
			{
			condition+="<option value= ' "+el[i]+"'>"+el[i]+"</option>";
			}
		condition+="</select>";
		
		condition+="<select name='equality' class='form-control'><option value='='>Equals</option>";
		
		condition+="<option value='>'>Greater than</option>";

		condition+="<option value='<'>Less than</option>";
		
		condition+="</select></div>"

		$("#step2").append(condition);
	});
	*/
	$("#entities input").click(function(){
		
		var id=$(this).attr("id");
		
		var tableid="#"+id+"s";
		 
		var remaining=$("#entities").children();
		var i=0;
		for(i=0;i<remaining.length;i++)
			{
			if("#"+remaining[i].id+"s"!=tableid)
				{
				$("#"+remaining[i].id+"s").hide();
				}
			}
		$(tableid).show();
		
	});
	
	
var parentEntityAttributes="${parentEntityAttributes}";
	
	//alert(parentEntityAttributes);
	
	parentEntityAttributes=obtainStringArray(parentEntityAttributes);
	
	//alert(parentEntityAttributes[0]);
	
	arr[0]=parentEntityAttributes;
	var content="";
	var i=0;
	var j=0;
	var rowseperator=4;
	
	for(j=0;j<arr.length;j++)
		{
		rowseperator=4;
		if(j==0)
			{
			content+="<table id='"+parentEntity+"-ids' class='table' >";
			}
		else
			{
			content+="<table id='"+entity[j-1]+"-ids' class='table' >";	
			}
		
		if(j==1 || j==2)
			{
			rowseperator=3;
			}
		for(i=0;i<arr[j].length;i++)
			{
			if(i%rowseperator==0)
				{
				content+="<tr>";
				}
			arr[j][i]=arr[j][i].trim();
			content+="<td><input type='checkbox' name="+arr[j][i]+" id='"+arr[j][i]+"-id' />";
			content+="<label for="+arr[j][i]+">"+arr[j][i]+"</label></td>";
			if(i%rowseperator==(rowseperator-1))
				{
				content+="</tr>";
				}
			}
		content+="</table>";
		}
	$("#entity-attributes").append(content);
	
	$("#"+parentEntity+"-ids").show();
	for(i=0;i<entity.length;i++)
		{
		$("#"+entity[i]+"-ids").hide();
		}
	
	$("#"+parentEntity+"-id").click(function(){
		
		$("#"+parentEntity+"-ids").show();
		for(j=0;j<entity.length;j++)
		{
		$("#"+entity[j]+"-ids").hide();
		}
	});
	

	for(i=0;i<entity.length;i++)
	{
	$("#"+entity[i]+"-id").click(function(){
		$("#"+parentEntity+"-ids").hide();
		for(j=0;j<entity.length;j++)
			{
			if(j==i)
				{
				$("#"+entity[j]+"-ids").show();
				}
			else
				{
				$("#"+entity[i]+"-ids").hide();
				}
			}
		
		
	});
	}
	var alias;
	var Query="";
	var checked;

			$("input[type=checkbox]").change(function(){
				checked=$(this).is(":checked");
				alias=($(this).parent().parent().parent().parent().get(0).id+".").replace("-ids","");
				if(checked)
					{
					if(Query.length!=0)
					{
					Query+=",";	
					}
					
					Query+=alias+$(this).attr("name");
					}
				else
					{
					//Start  of Tuere Edit -1 23rdMarch
					
					if(Query.indexOf(",", 0)<0){
					Query=Query.replace((alias+$(this).attr("name")),"");
					}
					else{
						var SearchString = ","+(alias+$(this).attr("name"));
						Query=Query.replace(SearchString,"");
						}
					//alert(Query);
					
					//End of Tuere Edit -1 23rdMarch
					}
				//alert(Query);
				
				//nikesh to extract table names for from
				
				
				
				
				
				
			});	

	

$("#step-99").click(function(){
	

	var finalQuery=Query;
	var content="<form action='store-query' method='POST'><input type='hidden' name='query' value='"+finalQuery+"'  />";
	content+="<input type='hidden' name='where' value='"+where+"'  />";
	content+="<input type='submit' value='Save Query' class='btn btn-primary'/></form>";
	$("#finish").append(content);
	
});

var conditionNumber=1;
var where="";

//alert(arr[3][0]);
$("#step-2").click(function(){

	
	
	var i=0;
	var j=0;
	//var operators = ["Select Condition "," Less Than(<) "," Greater Than (>)","Equal To(=)","Less Than or Equal To (<=) "," Greater Than or Equal To (>=)"," Not (!) "," Not Equal To (!=) "];
	var content="";
	//content+="<p>hello</p>";
		content+="<h3>Condition "+conditionNumber+"</h3>";
		content+="<select name='' id='condition-"+conditionNumber+"' class='form-control'>";
		for(j=0;j<arr.length;j++)
		{
		/*
		if(j==0)
			{
			content+="<select name='"+parentEntity+"' id='"+parentEntity+"-ids' class='form-control'>";
			//content+="<select name="" id='' class='form-control'>";
			
			}
		else
			{
			content+="<select name='"+entity[j-1]+"' id='"+entity[j-1]+"-ids' class='form-control'>";
			//content+="<select name="" id='' class='form-control'>";
			//content+="<input type='text' name='' id='' class='form-control'/>";
			}
		*/
			if(j==0)
				{
				content+="<optgroup label="+parentEntity+">";
				}
			else
				{
				content+="<optgroup label="+entity[j-1]+">";
				}
			

			//content+="<select name='' id='' class='form-control'>";
			
			//for(j=0;j<operators.length;j++)
				//{
				//content+="<option value="+operators[j]+">"+operators[j]+"</option>";
				//alert("operator "+j+" "+operators[j]);
				//}
			
			//content+="</select>";

		for(i=0;i<arr[j].length;i++)
			{
			arr[j][i]=arr[j][i].trim();
			content+="<option value="+arr[j][i]+">"+arr[j][i]+"</option>";
			}
			
		
			content+="</optgroup>";
			/*content+="</select>";*/
			//content+="</select>";
			//content+="<input type='text' name='text1' id='text1'/>";
		}
		//content+="</select>";
		
		content+="</select>";
		
	
		
		content+="<select name='operation' id='operation-"+conditionNumber+"' class='form-control'>";
		
		content+="<option value='&gt;'> Greater than</option>";
		
		content+="<option value='&gt;='> Greater than or equals</option>";
		
		content+="<option value='&lt;'> Less than</option>";
		
		content+="<option value='&lt;='> Less than or equals </option>";
		
		content+="<option value='='> Equals </option>";
		
		content+="<option value='!='> Not equals </option>";
		
		content+="<option value='LIKE'> LIKE </option>";
		
		content+="</select>";
		
		$("#step2").append(content);
		
		//var testing=$("#"+entity[j-2]+"-ids").value;
		//alert(testing+" "+entity[j-2]);
		conditionNumber++;
		$("#saveQuery").focus();
		
});

var i=0;

$("#saveCondition").click(function(){
	where="";
	//alert($("#condition-1").val());
	var condition="";
	var operation="";
for(i=1;i<conditionNumber;i++)
	{
	condition=$("#condition-"+(i.toString())).val();
	where+=condition+".";
	operation=$("#operation-"+i.toString()).val();
	where+=operation+",";
	}
var finalQuery=Query;
var content="<form action='store-query' method='POST'><input type='text' name= 'queryName' placeholder='Query name...' class='form-control'/><input type='hidden' name='queryAttributes' value='"+finalQuery+"'  />";
content+="<input type='hidden' name='queryWhere' value='"+where+"'  />";
content+="<input type='submit' value='Save Query' class='btn btn-primary'/></form>";
$("#finish").append(content);



});

			
});
/*
var i=0;
var string="";
for(i=0;i<checkboxes.length;i++)
	{
	string+=checkboxes.charAt(i);
	}
alert(string);
*/

function obtainStringArray(s)
{
	var el=s.split(",");	
	el[0]=el[0].replace("[","");
	el[0]=el[0].trim();
	el[el.length-1]=el[el.length-1].replace("]","");
	el[el.length-1]=el[el.length-1].trim();
	var i=0;
	
	return el;
}

</script>


</head>
<body>
	<h3>
	Query Manager
	</h3>
	<div id="step1">
		<h4>Select the columns/attributes to form your report</h4>
		<h5>Admission User details</h5>
		
		<div id="entities">
		</div>
		
		<div id="entity-attributes">
		</div>
		<input type="button" class="btn btn-primary" value="Add condition" id="step-2"/>
	</div>
	<div id ="step2">
	
	</div>	
	<!--nikesh  -->
	<!--div>
	<form action="whereClause" method="POST">
	<input type="hidden" value="${Query}" name="queryValue"/>
	<input type="submit" class="form-control" value="Apply Filter"/>
	</form>
	</div>
	
	<!--h2>Step 2</h2>
	<h1>Select the constrains and conditions</h1>
	<div id="step2">
	<h4>No conditions yet</h4>
	<input type="button" class="btn btn-primary" value="Add condition" id="conditionadd"/>
	</div-->
	<div id="step3">
		<input type="button" id="saveCondition" class="btn btn-primary" value="Save Conditions"/>
	</div>
	<div id="finish">
	
	</div>
</body>	
</html>