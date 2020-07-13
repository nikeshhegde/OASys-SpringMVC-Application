$(document).ready(function() {
  	var $validator = $("#commentForm").validate({
		  rules: {
		    email: {
		      required: true,
		      email: true,
		      minlength: 3
		    },
		    username: {
		      required: true,
		      minlength: 3
		    },
		    urlfield: {
		      required: true,
		      minlength: 3,
		      url: true
		    }
		  },
		errorClass: "text-danger",
		});
 
	  	$('#rootwizard').bootstrapWizard({
	  		'tabClass': 'nav nav-pills',
	  		'onNext': function(tab, navigation, index) {
				//alert("function call to rootwizard");
				//alert("tab "+tab.value+" navigation "+navigation.value+" index "+index.value);
	  			var $valid = $("#commentForm").valid();
				index=index+3;
	  			if(!$valid) {
	  				$validator.focusInvalid();
	  			}
				return true;
	  		}
	  	});
	
	

});