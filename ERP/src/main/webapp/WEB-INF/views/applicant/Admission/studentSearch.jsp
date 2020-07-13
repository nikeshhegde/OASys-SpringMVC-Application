<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<html>
    <head>
        <!-- <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> -->
        <title>Student Search</title>
        <link rel="stylesheet" href="css/displaytag.css" type="text/css">
        <link rel="stylesheet" href="css/screen.css" type="text/css">
        <link rel="stylesheet" href="css/site.css" type="text/css">

        <style>
             {padding:0; margin:0;}

            html {
                padding:15px 15px 0;
                font-family:sans-serif;
                font-size:14px;
            }

            p, h3 {
                margin-bottom:15px;
            }

            div {
                padding:10px;
                width:600px;
                background:#fff;
            }

            .tabss li {
                list-style:none;
                display:inline;
            }

            .tabss a {
                padding:5px 10px;
                display:inline-block;
                background:#666;
                color:#fff;
                text-decoration:none;
            }

            .tabss li.active a{
                background:#f0f;
                color:#00;
            }
           
            .tab_content {
                display: none;
            }
        </style>

        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js">
         </script>
       
        <script>

         // Wait until the DOM has loaded before querying the document
         $(document).ready(function(){
			//alert("hhhhh");
            //Active tab selection after page load       
            $('#tabs').each(function(){
           
            // For each set of tabs, we want to keep track of
            // which tab is active and it's associated content
            var $active, $content, $links = $(this).find('a');
           
            // If the location.hash matches one of the links, use that as the active tab.
            // If no match is found, use the first link as the initial active tab.
            $active = $($links.filter('[href="'+location.hash+'"]')[0]
                      || $links[0]);
            
            $active.parent().addClass('active');
           
            $content = $($active.attr('href'));
            $content.show();
        });
       
       
          $("#tabs li").click(function() {
        	 // alert("GGGGG");
             // First remove class "active" from currently active tab
             $("#tabs li").removeClass('active');
        
             // Now add class "active" to the selected/clicked tab
             $(this).addClass("active");
                
             // Hide all tab content
             $(".tab_content").hide();

             // Here we get the href value of the selected tab
             var selected_tab = $(this).find("a").attr("href");      

             var starting = selected_tab.indexOf("#");
             var sub = selected_tab.substring(starting);
               
             //write active tab into cookie
                
             //$(sub).show();
                 $(sub).fadeIn();
             // At the end, we add return false so that the click on the
            // link is not executed
             return false;
          }); 
        });

       </script>

    </head>
    <body>

            <ul id='tabs' class="tabss">
            <li><a href='#tab1'>Home</a></li>
            <li><a href='#tab2'>About Us</a></li>
        </ul>
        <div id='tab1' class="tab_content" >
            <h3>Section 1</h3>
            <p>This is First TAB 
            	This one has been slow-cooking since February and it’s good. For the first time in a while, 
            	this release focuses on adding some significant new features to Knockout.
            	 Almost any developer using KO should seriously consider making use of these, 
            	 as they can greatly streamline your code.
            </p>
            
        </div>
       
        <div id='tab2' class="tab_content">
            <h3>Section 2</h3>
            <p>This is SECOND TAB
              ko.pureComputed is a new specialisation of ko.computed with better
               performance and memory management in many cases. 
               It automatically pauses/resumes evalution, and automatically releases/reclaims 
               references to dependencies, according to whether any other part of your app is watching it at the time. This can be extremely valuable for large single-page applications, where you may be tearing down and rebuilding different parts of your UI over long periods of time, and need to ensure your memory/CPU use is as streamlined as possible.
            
            </p>
        </div>
    </body>
</html>
