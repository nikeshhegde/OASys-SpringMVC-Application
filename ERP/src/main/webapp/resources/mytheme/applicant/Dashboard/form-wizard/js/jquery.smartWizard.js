/*
 * SmartWizard 3.3.1 plugin
 * jQuery Wizard control Plugin
 * by Dipu
 *
 * Refactored and extended:
 * https://github.com/mstratman/jQuery-Smart-Wizard
 *
 * Original URLs:
 * http://www.techlaboratory.net
 * http://tech-laboratory.blogspot.com
 */

function SmartWizard(target, options) {
    this.target       = target;
    this.options      = options;
    this.curStepIdx   = options.selected;
    this.steps        = $(target).children("ul").children("li").children("a"); // Get all anchors
    this.contentWidth = 0;
    this.msgBox = $('<div class="msgBox"><div class="content"></div><a href="#" class="close">X</a></div>');
    this.elmStepContainer = $('<div></div>').addClass("stepContainer");
    this.loader = $('<div>Loading</div>').addClass("loader");
    this.buttons = {
        next : $('<a>'+options.labelNext+'</a>').attr("href","#").addClass("buttonNext"),
        previous : $('<a>'+options.labelPrevious+'</a>').attr("href","#").addClass("buttonPrevious"),
        //finish  : $('<a>'+options.labelFinish+'</a>').prop("href","http://www.cognisenz.com/").addClass("buttonFinish")
    };

    /*
     * Private functions
     */

    var _init = function($this) {
        var elmActionBar = $('<div></div>').addClass("actionBar");
        elmActionBar.append($this.msgBox);
        $('.close',$this.msgBox).click(function() {
            $this.msgBox.fadeOut("normal");
            return false;
        });

        var allDivs = $this.target.children('div');
        // CHeck if ul with steps has been added by user, if not add them
        if($this.target.children('ul').length == 0 ){
            var ul = $("<ul/>");
            target.prepend(ul)

            // for each div create a li
            allDivs.each(function(i,e){
                var title = $(e).first().children(".StepTitle").text();				
                var s = $(e).attr("id")
                // if referenced div has no id, add one.
                if (s==undefined){
                    s = "step-"+(i+1)
                    $(e).attr("id",s);
                }
                var span = $("<span/>").addClass("stepDesc").text(title);
                var li = $("<li></li>").append($("<a></a>").attr("href", "#" + s).append($("<label></label>").addClass("stepNumber").text(i + 1)).append(span));
                ul.append(li);
            });
            // (re)initialise the steps property
            $this.steps = $(target).children("ul").children("li").children("a"); // Get all anchors
        }
        $this.target.children('ul').addClass("anchor");
        allDivs.addClass("content");

        // highlight steps with errors
        if($this.options.errorSteps && $this.options.errorSteps.length>0){
            $.each($this.options.errorSteps, function(i, n){
                $this.setError({ stepnum: n, iserror:true });
            });
        }

        $this.elmStepContainer.append(allDivs);
        elmActionBar.append($this.loader);
        $this.target.append($this.elmStepContainer);
/*
        if ($this.options.includeFinishButton){
            elmActionBar.append($this.buttons.finish)
        }
*/
        elmActionBar.append($this.buttons.next)
            .append($this.buttons.previous);
        $this.target.append(elmActionBar);
        this.contentWidth = $this.elmStepContainer.width();

        $($this.buttons.next).click(function() {
	
				$this.goForward();	
			
			
        });
        $($this.buttons.previous).click(function() {
            $this.goBackward();
            return false;
        });
		/*
        $($this.buttons.finish).click(function() {
            if(!$(this).hasClass('buttonDisabled')){
                if($.isFunction($this.options.onFinish)) {
                    var context = { fromStep: $this.curStepIdx + 1 };
                    if(!$this.options.onFinish.call(this,$($this.steps), context)){
                        return false;
                    }
                }else{
                    var frm = $this.target.parents('form');
                    if(frm && frm.length){
                        frm.submit();
                    }
                }
            }
            return false;
        });
		*/
        $($this.steps).bind("click", function(e){
            if($this.steps.index(this) == $this.curStepIdx){
                return false;
            }
            var nextStepIdx = $this.steps.index(this);
            var isDone = $this.steps.eq(nextStepIdx).attr("isDone") - 0;
            if(isDone == 1){
                _loadContent($this, nextStepIdx);
            }
            return false;
        });

        // Enable keyboard navigation
        if($this.options.keyNavigation){
            $(document).keyup(function(e){
                if(e.which==39){ // Right Arrow
                    $this.goForward();
                }else if(e.which==37){ // Left Arrow
                    $this.goBackward();
                }
            });
        }
        //  Prepare the steps
        _prepareSteps($this);
        // Show the first slected step
        _loadContent($this, $this.curStepIdx);
    };

    var _prepareSteps = function($this) {
        if(! $this.options.enableAllSteps){
            $($this.steps, $this.target).removeClass("selected").removeClass("done").addClass("disabled");
            $($this.steps, $this.target).attr("isDone",0);
        }else{
            $($this.steps, $this.target).removeClass("selected").removeClass("disabled").addClass("done");
            $($this.steps, $this.target).attr("isDone",1);
        }

        $($this.steps, $this.target).each(function(i){
            $($(this).attr("href").replace(/^.+#/, '#'), $this.target).hide();
            $(this).attr("rel",i+1);
        });
    };

    var _step = function ($this, selStep) {
        return $(
            $(selStep, $this.target).attr("href").replace(/^.+#/, '#'),
            $this.target
        );
    };

    var _loadContent = function($this, stepIdx) {
        var selStep = $this.steps.eq(stepIdx);
        var ajaxurl = $this.options.contentURL;
        var ajaxurl_data = $this.options.contentURLData;
        var hasContent = selStep.data('hasContent');
        var stepNum = stepIdx+1;
        if (ajaxurl && ajaxurl.length>0) {
            if ($this.options.contentCache && hasContent) {
                _showStep($this, stepIdx);
            } else {
                var ajax_args = {
                    url: ajaxurl,
                    type: $this.options.ajaxType,
                    data: ({step_number : stepNum}),
                    dataType: "text",
                    beforeSend: function(){
                        $this.loader.show();
                    },
                    error: function(){
                        $this.loader.hide();
                    },
                    success: function(res){
                        $this.loader.hide();
                        if(res && res.length>0){
                            selStep.data('hasContent',true);
                            _step($this, selStep).html(res);
                            _showStep($this, stepIdx);
                        }
                    }
                };
                if (ajaxurl_data) {
                    ajax_args = $.extend(ajax_args, ajaxurl_data(stepNum));
                }
                $.ajax(ajax_args);
            }
        }else{
            _showStep($this,stepIdx);
        }
    };

    var _showStep = function($this, stepIdx) {
        var selStep = $this.steps.eq(stepIdx);
        var curStep = $this.steps.eq($this.curStepIdx);
        if(stepIdx != $this.curStepIdx){
            if($.isFunction($this.options.onLeaveStep)) {
                var context = { fromStep: $this.curStepIdx+1, toStep: stepIdx+1 };
                if (! $this.options.onLeaveStep.call($this,$(curStep), context)){
                    return false;
                }
            }
        }
        $this.elmStepContainer.height(_step($this, selStep).outerHeight());
        var prevCurStepIdx = $this.curStepIdx;
        $this.curStepIdx =  stepIdx;
        if ($this.options.transitionEffect == 'slide'){
            _step($this, curStep).slideUp("fast",function(e){
                _step($this, selStep).slideDown("fast");
                _setupStep($this,curStep,selStep);
            });
        } else if ($this.options.transitionEffect == 'fade'){
            _step($this, curStep).fadeOut("fast",function(e){
                _step($this, selStep).fadeIn("fast");
                _setupStep($this,curStep,selStep);
            });
        } else if ($this.options.transitionEffect == 'slideleft'){
            var nextElmLeft = 0;
            var nextElmLeft1 = null;
            var nextElmLeft = null;
            var curElementLeft = 0;
            if(stepIdx > prevCurStepIdx){
                nextElmLeft1 = $this.elmStepContainer.width() + 10;
                nextElmLeft2 = 0;
                curElementLeft = 0 - _step($this, curStep).outerWidth();
            } else {
                nextElmLeft1 = 0 - _step($this, selStep).outerWidth() + 20;
                nextElmLeft2 = 0;
                curElementLeft = 10 + _step($this, curStep).outerWidth();
            }
            if (stepIdx == prevCurStepIdx) {
                nextElmLeft1 = $($(selStep, $this.target).attr("href"), $this.target).outerWidth() + 20;
                nextElmLeft2 = 0;
                curElementLeft = 0 - $($(curStep, $this.target).attr("href"), $this.target).outerWidth();
            } else {
                $($(curStep, $this.target).attr("href"), $this.target).animate({left:curElementLeft},"fast",function(e){
                    $($(curStep, $this.target).attr("href"), $this.target).hide();
                });
            }

            _step($this, selStep).css("left",nextElmLeft1).show().animate({left:nextElmLeft2},"fast",function(e){
                _setupStep($this,curStep,selStep);
            });
        } else {
            _step($this, curStep).hide();
            _step($this, selStep).show();
            _setupStep($this,curStep,selStep);
        }
        return true;
    };

    var _setupStep = function($this, curStep, selStep) {
        $(curStep, $this.target).removeClass("selected");
        $(curStep, $this.target).addClass("done");

        $(selStep, $this.target).removeClass("disabled");
        $(selStep, $this.target).removeClass("done");
        $(selStep, $this.target).addClass("selected");

        $(selStep, $this.target).attr("isDone",1);

        _adjustButton($this);

        if($.isFunction($this.options.onShowStep)) {
            var context = { fromStep: parseInt($(curStep).attr('rel')), toStep: parseInt($(selStep).attr('rel')) };
            if(! $this.options.onShowStep.call(this,$(selStep),context)){
                return false;
            }
        }
        if ($this.options.noForwardJumping) {
            // +2 == +1 (for index to step num) +1 (for next step)
            for (var i = $this.curStepIdx + 2; i <= $this.steps.length; i++) {
                $this.disableStep(i);
            }
        }
    };

    var _adjustButton = function($this) {
        if (! $this.options.cycleSteps){
            if (0 >= $this.curStepIdx) {
                $($this.buttons.previous).addClass("buttonDisabled");
                if ($this.options.hideButtonsOnDisabled) {
                    $($this.buttons.previous).hide();
                }
            }else{
                $($this.buttons.previous).removeClass("buttonDisabled");
                if ($this.options.hideButtonsOnDisabled) {
                    $($this.buttons.previous).show();
                }
            }
            if (($this.steps.length-1) <= $this.curStepIdx){
                $($this.buttons.next).addClass("buttonDisabled");
                if ($this.options.hideButtonsOnDisabled) {
                    $($this.buttons.next).hide();
                }
            }else{
                $($this.buttons.next).removeClass("buttonDisabled");
                if ($this.options.hideButtonsOnDisabled) {
                    $($this.buttons.next).show();
                }
            }
        }
        // Finish Button
        $this.enableFinish($this.options.enableFinishButton);
    };

    /*
     * Public methods
     */

    SmartWizard.prototype.goForward = function(){
		 
	  
	   
	   
	   var flag=0;
	   var i=0;
	   
       if(this.curStepIdx==0)
		{
			
			temp=[];
			i=0;
			
			temp[i++]=$("#admission_user_name").val();
			temp[i++]=$("#admission_user_father_name").val();
			temp[i++]=$("#admission_user_mother_name").val();
			temp[i++]=$("#admission_user_p_address").val();
			temp[i++]=$("#admission_user_c_address").val();
			temp[i++]=$("#admission_user_landline").val();
			temp[i++]=$("#admission_user_mobile").val();
			temp[i++]=$("#email").val();
			temp[i++]=$("#date").val();
			temp[i++]=$("#place_of_birth").val();
			temp[i++]=$("#state").val();
			temp[i++]=$("#nationality").val();
			temp[i++]=$("#religion").val();			
			i=0;
			temp_name=[];
			
			temp_name[i++]=$("#admission_user_name").attr("id");
			temp_name[i++]=$("#admission_user_father_name").attr("id");
			temp_name[i++]=$("#admission_user_mother_name").attr("id");
			temp_name[i++]=$("#admission_user_p_address").attr("id");
			temp_name[i++]=$("#admission_user_c_address").attr("id");
			temp_name[i++]=$("#admission_user_landline").attr("id");
			temp_name[i++]=$("#admission_user_mobile").attr("id");
			temp_name[i++]=$("#email").attr("id");
			temp_name[i++]=$("#date").attr("id");
			temp_name[i++]=$("#place_of_birth").attr("id");
			temp_name[i++]=$("#state").attr("id");
			temp_name[i++]=$("#nationality").attr("id");
			temp_name[i++]=$("#religion").attr("id");
			var j=0;
			
			for(i=0;i<13;i++)
				{
				$('#'+temp_name[j]+'-error').text("");
				}
			
			for(i=0;i<13;i++)
				{
				if(temp[i]=="" || temp[i]==null)
					{
					flag=1;
					$('#'+temp_name[i]+'-error').text("This field is required");
					}
				}	
			var domicile=$("#domicile").val();
			if(domicile=="Yes")
				{
				var val = $("#dc").val().toLowerCase();
				var regex = new RegExp("(.*?)\.(pdf)$");
				 //alert("Yess");
				 //alert(val);
				if(!(regex.test(val))) 
					{
					$(this).val('');
					//alert('Unsupported file');
					$("#dc-error").text("PDF has to be uploaded");
					} 
				 
				}
			//alert("Next clicked Lahuuuuu");	
			
			//alert("made changes in setget add record 1:26 it isss");
			//alert(typeof(postData));
			//alert("data: "+postData[0].value);
			
			if(flag==1)
				{
				return false;
				}
				
			var postData = $("#form").serializeArray();
			var method=$("#form").attr("method");
			//postdata+=$(":input,:hidden").serialize();
			alert("static display removed ID something inline explicit id");
			alert("Length of array"+postData.length);
			//var tem=(postData.length)-1;
			alert("Hi");
			var i=0;
			for(i=0;i<postData.length;i++)
				{
				alert(postData[i].name+" : "+postData[i].value);
				}
				//alert(postData[tem]);
			//alert("This is lifEe"+postdata[postData.length-1]);
			/*
			$.ajax(
					{	
					url: "http://localhost:8080/start/autostore",
					type: "GET",
					crossDomain: 'TRUE',
					async: true,
				    data: postData, // Note it is important
				     success :function(result)
				     	{
				       	// do what ever you want with data
				    	 //alert("Lahuuu success");
				     	},
					error: function(jqXHR, textStatus, errorThrown) 
				        {
				         alert("Error "+errorThrown);   //if fails      
				        }
					
					});	
			*/
		}
		if(this.curStepIdx==1)
			{
			
			temp=[];
			
			temp[i++]=$("#marks_maths_obtained").val();
			temp[i++]=$("#marks_total_maths").val();
			temp[i++]=$("#marks_grand_obtained").val();
			temp[i++]=$("#marks_total_grand").val();
			temp[i++]=$("#percentage_obtained").val();
			temp[i++]=$("#year_of_passing").val();
			temp[i++]=$("#marks_english_obtained").val();
			temp[i++]=$("#marks_total_english").val();
			temp[i++]=$("#marks_physics_hsc_obtained").val();
			temp[i++]=$("#marks_total_hsc_physics").val();
			temp[i++]=$("#marks_chem_hsc_obtained").val();
			temp[i++]=$("#marks_total_hsc_chem").val();
			temp[i++]=$("#marks_maths_hsc_obtained").val();
			temp[i++]=$("#marks_total_hsc_maths").val();
			temp[i++]=$("#marks_voc_hsc_obtained").val();
			temp[i++]=$("#marks_total_hsc_voc").val();
			temp[i++]=$("#marks_pcm_obtained").val();
			temp[i++]=$("#marks_total_pcm").val();
			temp[i++]=$("#marks_pmv_obtained").val();
			temp[i++]=$("#marks_total_pmv").val();
			temp[i++]=$("#hsc_year_of_passing").val();
			temp[i++]=$("#marks_jee_phy_obtained").val();
			temp[i++]=$("#marks_total_phy_jee").val();
			temp[i++]=$("#marks_jee_chem_obtained").val();
			temp[i++]=$("#marks_total_chem_jee").val();
			temp[i++]=$("#marks_jee_maths_obtained").val();
			temp[i++]=$("#marks_total_maths_jee").val();
			temp[i++]=$("#marks_jee_total_obtained").val();
			temp[i++]=$("#marks_total_jee").val();
			temp[i++]=$("#jee_percentile_obtained").val();
			temp[i++]=$("#board_percentile_obtained").val();
			
			i=0;
			temp_name=[];
			
			temp_name[i++]= $("#marks_maths_obtained").attr("id");
			temp_name[i++]= $("#marks_total_maths").attr("id");
			temp_name[i++]= $("#marks_grand_obtained").attr("id");
			temp_name[i++]= $("#marks_total_grand").attr("id");
			temp_name[i++]= $("#percentage_obtained").attr("id");
			temp_name[i++]= $("#year_of_passing").attr("id");
			temp_name[i++]= $("#marks_english_obtained").attr("id");
			temp_name[i++]= $("#marks_total_english").attr("id");
			temp_name[i++]= $("#marks_physics_hsc_obtained").attr("id");
			temp_name[i++]= $("#marks_total_hsc_physics").attr("id");
			temp_name[i++]= $("#marks_chem_hsc_obtained").attr("id");
			temp_name[i++]= $("#marks_total_hsc_chem").attr("id");
			temp_name[i++]= $("#marks_maths_hsc_obtained").attr("id");
			temp_name[i++]= $("#marks_total_hsc_maths").attr("id");
			temp_name[i++]= $("#marks_voc_hsc_obtained").attr("id");
			temp_name[i++]= $("#marks_total_hsc_voc").attr("id");
			temp_name[i++]= $("#marks_pcm_obtained").attr("id");
			temp_name[i++]= $("#marks_total_pcm").attr("id");
			temp_name[i++]= $("#marks_pmv_obtained").attr("id");
			temp_name[i++]= $("#marks_total_pmv").attr("id");
			temp_name[i++]= $("#hsc_year_of_passing").attr("id");
			temp_name[i++]= $("#marks_jee_phy_obtained").attr("id");
			temp_name[i++]= $("#marks_total_phy_jee").attr("id");
			temp_name[i++]= $("#marks_jee_chem_obtained").attr("id");
			temp_name[i++]= $("#marks_total_chem_jee").attr("id");
			temp_name[i++]= $("#marks_jee_maths_obtained").attr("id");
			temp_name[i++]= $("#marks_total_maths_jee").attr("id");
			temp_name[i++]= $("#marks_jee_total_obtained").attr("id");
			temp_name[i++]= $("#marks_total_jee").attr("id");
			temp_name[i++]= $("#jee_percentile_obtained").attr("id");
			temp_name[i++]= $("#board_percentile_obtained").attr("id");
			
			
				
			for(i=0;i<31;i++)
				{
				$("#"+temp_name[i]+"-error").text("");
				}
			
			for(i=0;i<31;i++)
				{				
				if(temp[i]=="" || temp[i]==null || isNaN(temp[i]))
					{
					flag=1;
					j=i;
					break;
					}
				
				}	
			if(flag==1)
				{
				
				$('#'+temp_name[j]+'-error').text("This field is required. Please enter marks in numeric format");
				$('#'+temp_name[j]).focus();
				return false;
				}
				
				
			}
			
		if(this.curStepIdx==2)
		{	
		var priority=""+$("#extc").val()+$("#ce").val()+$("#it").val()+$("#ppt").val()+$("#bt").val()+$("#mech").val();
		var i=1;
		var j=0;
		var count=0;
		var temp;
		while(i<7)
			{
			//alert("outerwhile");
			j=0;
			count=0;
			temp=''+i;
				while(j<priority.length)
					{
					if(priority.charAt(j)==temp)
						{
						count++;
						}	
					j++;
					}	
				if(count>1)
					{
					flag=1;
					$("#invalid_priority").text("Priority assigned to each branch should be unique");
					//alert("Priority assigned to each branch should be unique");
					}
			i++;
			}		
			
		}		
		if(flag==0)
			{
			var nextStepIdx = this.curStepIdx + 1;
			}
		
		
		

		
		
		
		
		if (this.steps.length <= nextStepIdx){
            if (! this.options.cycleSteps){
                return false;
            }
            nextStepIdx = 0;
        }
        _loadContent(this, nextStepIdx);
    };

    SmartWizard.prototype.goBackward = function(){
        var nextStepIdx = this.curStepIdx-1;
        if (0 > nextStepIdx){
            if (! this.options.cycleSteps){
                return false;
            }
            nextStepIdx = this.steps.length - 1;
        }
        _loadContent(this, nextStepIdx);
    };

    SmartWizard.prototype.goToStep = function(stepNum){
        var stepIdx = stepNum - 1;
        if (stepIdx >= 0 && stepIdx < this.steps.length) {
            _loadContent(this, stepIdx);
        }
    };
    SmartWizard.prototype.enableStep = function(stepNum) {
        var stepIdx = stepNum - 1;
        if (stepIdx == this.curStepIdx || stepIdx < 0 || stepIdx >= this.steps.length) {
            return false;
        }
        var step = this.steps.eq(stepIdx);
        $(step, this.target).attr("isDone",1);
        $(step, this.target).removeClass("disabled").removeClass("selected").addClass("done");
    }
    SmartWizard.prototype.disableStep = function(stepNum) {
        var stepIdx = stepNum - 1;
        if (stepIdx == this.curStepIdx || stepIdx < 0 || stepIdx >= this.steps.length) {
            return false;
        }
        var step = this.steps.eq(stepIdx);
        $(step, this.target).attr("isDone",0);
        $(step, this.target).removeClass("done").removeClass("selected").addClass("disabled");
    }
    SmartWizard.prototype.currentStep = function() {
		return this.curStepIdx + 1;
    }

    SmartWizard.prototype.showMessage = function (msg) {
        $('.content', this.msgBox).html(msg);
        this.msgBox.show();
    }

    SmartWizard.prototype.enableFinish = function (enable) {
        // Controll status of finish button dynamically
        // just call this with status you want
        this.options.enableFinishButton = enable;
        if (this.options.includeFinishButton){
            if (!this.steps.hasClass('disabled') || this.options.enableFinishButton){
                $(this.buttons.finish).removeClass("buttonDisabled");
                if (this.options.hideButtonsOnDisabled) {
                    $(this.buttons.finish).show();
                }
            }else{
                $(this.buttons.finish).addClass("buttonDisabled");
                if (this.options.hideButtonsOnDisabled) {
                    $(this.buttons.finish).hide();
                }
            }
        }
        return this.options.enableFinishButton;
    }

    SmartWizard.prototype.hideMessage = function () {
        this.msgBox.fadeOut("normal");
    }
    SmartWizard.prototype.showError = function(stepnum) {
        this.setError(stepnum, true);
    }
    SmartWizard.prototype.hideError = function(stepnum) {
        this.setError(stepnum, false);
    }
    SmartWizard.prototype.setError = function(stepnum,iserror) {
        if (typeof stepnum == "object") {
            iserror = stepnum.iserror;
            stepnum = stepnum.stepnum;
        }

        if (iserror){
            $(this.steps.eq(stepnum-1), this.target).addClass('error')
        }else{
            $(this.steps.eq(stepnum-1), this.target).removeClass("error");
        }
    }

    SmartWizard.prototype.fixHeight = function(){
	
        var height = 100;
        var selStep = this.steps.eq(this.curStepIdx);
        var stepContainer = _step(this, selStep);
        stepContainer.children().each(function() {
	
            if($(this).is(':visible')) {
                 height += $(this).outerHeight(true);
            }
        
		});

        // These values (5 and 20) are experimentally chosen.
        
		stepContainer.height(height + 5);
        this.elmStepContainer.height(height + 20);
	
	}

    _init(this);
};



(function($){

    $.fn.smartWizard = function(method) {
        var args = arguments;
        var rv = undefined;
        var allObjs = this.each(function() {
            var wiz = $(this).data('smartWizard');
            if (typeof method == 'object' || ! method || ! wiz) {
                var options = $.extend({}, $.fn.smartWizard.defaults, method || {});
                if (! wiz) {
                    wiz = new SmartWizard($(this), options);
                    $(this).data('smartWizard', wiz);
                }
            } else {
                if (typeof SmartWizard.prototype[method] == "function") {
                    rv = SmartWizard.prototype[method].apply(wiz, Array.prototype.slice.call(args, 1));
                    return rv;
                } else {
                    $.error('Method ' + method + ' does not exist on jQuery.smartWizard');
                }
            }
        });
        if (rv === undefined) {
            return allObjs;
        } else {
            return rv;
        }
    };

// Default Properties and Events
    $.fn.smartWizard.defaults = {
        selected: 0,  // Selected Step, 0 = first step
        keyNavigation: true, // Enable/Disable key navigation(left and right keys are used if enabled)
        enableAllSteps: false,
        transitionEffect: 'fade', // Effect on navigation, none/fade/slide/slideleft
        contentURL:null, // content url, Enables Ajax content loading
        contentCache:true, // cache step contents, if false content is fetched always from ajax url
        cycleSteps: false, // cycle step navigation
        enableFinishButton: false, // make finish button enabled always
        hideButtonsOnDisabled: false, // when the previous/next/finish buttons are disabled, hide them instead?
        errorSteps:[],    // Array Steps with errors
        labelNext:'Next',
        labelPrevious:'Previous',
        //labelFinish:'Finish',
        noForwardJumping: false,
        ajaxType: "POST",
        onLeaveStep: null, // triggers when leaving a step
        onShowStep: null,  // triggers when showing a step
        //onFinish: null,  // triggers when Finish button is clicked
       // includeFinishButton : true   // Add the finish button
    };

})(jQuery);
