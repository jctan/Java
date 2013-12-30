<!-- 
Name: John Tan 
Project: Schedule of Classes Redesign
Date: 12/2/2013


 -->
<%@ page import="java.sql.*" %>
<%@ include file = "username_John.jsp" %>
<%@ page errorPage="errorpg.jsp"
			 	 import="java.sql.*, 
                     javax.sql.*, 
                     java.io.*,
                     javax.naming.InitialContext,
                     javax.naming.Context" %>



<!--head.html include Goes Here -->
<%@ include file="HTML/head.html" %>


<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js"></script>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js"></script>
<script type="text/javascript" src="JS/jquery-1.4.2.min.js"></script>
<script src="JS/jquery.autocomplete.js"></script>
<link rel="stylesheet" type="text/css" href="CSS/jqueryStyle.css" />
<link href="CSS/schedule.css" rel="stylesheet" type="text/css" />
<script type="text/javascript"  src="JS/validation.js"></script>


<!--HEAD Include Ends -->

<!-- AUTOCOMPLETE jQuery AJAX -->
<script>
jQuery (function (){
$("#instructor").autocomplete("searchinstructors.jsp");
$("#number").autocomplete("searchCourseNum.jsp");
})
</script>

<!-- Disabled Button if U and G is checked and Alert Message Box to have 1 checked ONLY -->
<script type="text/javascript">
    function validateUG() {
    	var undergrad = document.getElementById('u_div');
    	var grad = document.getElementById('g_div');
    	
        if (undergrad.checked && grad.checked) {
        	alert("Only ONE Box can be Checked!");
        } 
        
        //Disable back button 
        if(undergrad.checked == true && grad.checked == true){
        	document.getElementById("submit").disabled = true; 
        }
        else{
        	document.getElementById("submit").disabled = false; 
        }
    }
</script>



<!-- Validate the form for Semester and Discipline, and "oncick" handler for reset to clear the display -->
<script type = "text/javascript">

window.onload = init;
 
// The "onload" handler. Run after the page is fully loaded.
function init() {
   // Attach "onsubmit" handler
   document.getElementById("theForm").onsubmit = validateForm;
  // Attach "onclick" handler to "reset" button
   document.getElementById("reset").onclick = clearDisplay;
   // Set initial focus
   document.getElementById("name").focus();
}

function validateForm(){
	return (isSelected("semesterName", "You must select a semester!")
			&& isSelected("discipline", "You must select a discipline!")
			&& num());
}
	

/* If "isValid" is false, print the errorMsg; else, reset to normal display.
 * The errorMsg will displayed on errorElement if it exists;
 *   otherwise it will display on an alert().
 */
function showMessage(isValid, inputElement, errorMsg, errorElement) {
   if (!isValid) {
      // Put up error message on errorElement or via alert()
      if (errorElement !== null) {
         errorElement.innerHTML = errorMsg;
      } else {
         alert(errorMsg);
      }
      // Change "class" of inputElement, so that CSS displays differently
      if (inputElement !== null) {
         inputElement.className = "error";
         inputElement.focus();
      }
   } else {
      // Reset to normal display
      if (errorElement !== null) {
         errorElement.innerHTML = "";
      }
      if (inputElement !== null) {
         inputElement.className = "";
      }
   }
}
 
//Return true if selection is made (not default of "") in <select> input
 function isSelected(inputId, errorMsg) {
	   var inputElement = document.getElementById(inputId);
	   var errorElement = document.getElementById(inputId + "Error");
	   var inputValue = inputElement.value;
	   // set the default value of <select>'s <option> to "".
	   var isValid = inputValue !== "";
	   showMessage(isValid, inputElement, errorMsg, errorElement);
	   return isValid;
	}
	
	
	
	
//The "onclick" handler for the "reset" button to clear the display
 function clearDisplay() {
    var elms = document.getElementsByTagName("*");  // clear all tags * 
    for (var i = 0; i < elms.length; i++) {
       if ((elms[i].id).match(/Error$/)) {  // clear error messages displayed
          elms[i].innerHTML = "";
       }
       if (elms[i].className === "error") {  // clear Class Name
          elms[i].className = "";
       }
    }
    // Set initial focus
    document.getElementById("name").focus();
 }
</script>


<!-- Validate for Alphabets ONLY on "Instructor" & 4 digit number with a "H" for "Course Number" -->
<script type = "text/javascript">
//Prohibit user from typing numbers or special Characters (only allow user to type Alphabets)
function onlyAlphabets(e, t) {
            try {
                if (window.event) {
                    var charCode = window.event.keyCode;
                }
                else if (e) {
                    var charCode = e.which;
                }
                else { return true; }
                if ((charCode > 64 && charCode < 91) || (charCode > 96 && charCode < 123))
                    return true;
                else
                    return false;
            }
            catch (err) {
                alert(err.Description);
            }
  }

//Validate for 4 digit number or 4 digit number with a "H" for "Course Number"
function num(){ 
var x = document.theForm.number.value;
	
	if(x != ""){
	if(/^\d{4}$/.test(x)) //test for a match in a string to see if there are 4 digit number
	{
	return true; //returns true if there are 4 digit number 
		}
		else if(/^\d{4}[H]{1}$/.test(x)){
		return true;
		}
		else{
		alert("You Need To Enter a 4 Digit Course Number OR a 4 Digit Course Number with a H (For Honors Courses)");   //else output the alert
		return false;
		}
	}
}
</script>



<!--BODY Include Begins -->
<%@ include file="HTML/body.html" %>
<!--BODY Include ENDS -->

<form name = "theForm" method="post" action="scheduleresults.jsp">
<%
	//Define the Connection URL
	Connection conn = null; 

	//define statement object
	Statement stmt = null;
	Statement stmt1 = null;
	Statement stmt2 = null;
	Statement stmt3 = null;
	
	//define result object 
	ResultSet rset = null;
	ResultSet rset1 = null;
	ResultSet rset2 = null; 
	ResultSet rset3 = null; 


	try
	{	

		// Load the driver
		Class.forName(driver);

		// Establish the connection
		// myusername and mypassword are declared in a file called username_TanJ.jsp
		conn = DriverManager.getConnection(url, myusername, mypassword);
        
     	// Create a statement object
		stmt = conn.createStatement();
		stmt1 = conn.createStatement();
		stmt2 = conn.createStatement();
		stmt3 = conn.createStatement();


		
		// SELECTING ALL SEMESTER
		String Query = "SELECT DISTINCT SEMESTER_NAME ||' '|| EXTRACT(YEAR FROM start_date) AS semesterName, semester FROM semester_schedule_reader ORDER BY semesterName";
		rset = stmt.executeQuery(Query); 
		
		//SELECTING DEPARTMENT
		String Query1 = "SELECT DISTINCT DEPT_NAME FROM DEPT_SCHEDULE_READER ORDER BY DEPT_NAME";
		rset1 = stmt1.executeQuery(Query1);
		
		//SELECTING ALL DISCIPLINE NAMES
		String Query2 = "SELECT DISTINCT DISC_ABBREVIATION FROM discipline_schedule_reader ORDER BY DISC_ABBREVIATION";
		rset2 = stmt2.executeQuery(Query2);
		
		//SELECTING ALL MEETING DAYS 
		String Query3 = "SELECT DISTINCT meeting_days FROM crs_sec_schedule_reader WHERE MEETING_DAYS != 'null' ORDER BY meeting_days DESC";
		rset3 = stmt3.executeQuery(Query3);



		%>

    <div align="center">
      <p class="errormsg"><b><font color="#FF0000">You must select a semester and either a discipine, course number, day, time, and/or instructor.
		</font></b> </p>
      <table id="search" summary="This table contains search options for the schedule of classes.">
       <caption> Schedule of Classes Search&nbsp; - <a href="schedulesearcherror.jsp">ERROR</a></caption>
	  <tbody>
        <tr>
          <th><label for="semesterName"><span Class = "red">*</span>Semester:</label></th>
          <td><select id="semesterName" name="semesterName" size = "1">
          <option value="">Select All</option>
          <%
           //Displaying the semester name dynamically 
          	while(rset.next()){
          		
          		String semesterName = rset.getString("semesterName");
          		String semester = rset.getString("semester");
          		
          		 //assigning the semester name to the option value	  
                %>
               <option value="<%=semesterName %>"><%=semesterName %> </option>
                <% 
          	}
          %>
        </select></td><br>
        <td id="semesterNameError" class="red" style="border: solid 0 #999; border-left-width:1px; padding-left:0.5ex">&nbsp;</td>
        </tr>
        
        <tr>
          <th>Department:</th>
          <td><select name="dept" size="1">
          <option value="">Select All</option>
          <%
          //Displaying the department name dynamically 
          while(rset1.next()){
        	  
        	  String dept = rset1.getString("DEPT_NAME");
        	  
        	  //assigning the semester name to the option value	  
              %>
              <option value="<%=dept %>"><%=dept %></option>
                <% 
          	}
          %>
        </select></td>
        </tr>
        
        
        <tr>
          <th><span Class = "red">*</span>Discipline:</th>
          <td><select name="discipline" size="1">
          <option value="">Select All</option>
          <%
          //Displaying the discipline dynamically 
          while(rset2.next()){
        	  
        	  String discipline = rset2.getString("DISC_ABBREVIATION");
        	  
        	  //assigning the semester name to the option value	  
              %>
               <option value="<%=discipline %>"><%=discipline %></option>
               <% 
          	}
          
          %>
        </select></td>
        <td id="disciplineError" class="red" style="border: solid 0 #999; border-left-width:1px; padding-left:0.5ex">&nbsp;</td>
        </tr>
        

		<%
		// use onclick for validating user for checking ONLY one of the boxes (undergraduate or graduate). If user want both, uncheck both boxes.
	   // If user check both boxes, it will disable search button.
		%>
        <tr>
          <th>Division: </th>
          <td>
            <label for="Undergraduate">Undergraduate: </label>
            <input type="checkbox" id="Undergraduate" value="Undergraduate" name="u_div" onclick="validateUG()"/>
            <br>
            <label for="Graduate">Graduate: </label>
            <input type="checkbox" id="Graduate" value="Graduate" name="g_div" onclick="validateUG()"/>
          </td>
        </tr>
        <tr>
          <th><label for="number">Course number:</label></th>
          <td><input id="number" size="10" name="number" maxlength="5" type="text"/></td>
        </tr>
        
        
        <tr>
          <th><label for="days">Days:</label></th>
          <td><select id="days" name="days">
              <option value="">Select All </option>
              <%
              //Display meeting days dynamically
              while(rset3.next()){
            	  
            	  String days = rset3.getString("meeting_days");
            	  
            	//assigning the semester name to the option value	  
                  %>
                  <option value="<%=days %>"><%=days %></option>
                  <% 
            	 }
          	%> 
           </select></td>
          	</tr>
           <%
           //use option value to check against the database in military time and converted into integers. 
           // BEFORE = 1, AFTER = 2, AROUND = 3
           %>
        <tr>
          <th><label for="time">Time:</label></th>
          <td><select id = "time_condition" name="time_condition" size="1">
              <option value=""> Select All</option>
              <option value = "1"> BEFORE </option>
              <option value = "2"> AFTER </option>
              <option value = "3"> AROUND </option>
            </select>
            
            <select name="time">
               <option value="">Select All </option>
              <option value="7">7:00AM </option>
              <option value="8">8:00AM </option>
              <option value="9">9:00AM </option>
              <option value="10">10:00AM </option>
              <option value="11">11:00AM </option>
              <option value="12">12:00PM </option>
              <option value="13">1:00PM </option>
              <option value="14">2:00PM </option>
              <option value="15">3:00PM </option>
              <option value="16">4:00PM </option>
              <option value="17">5:00PM </option>
              <option value="18">6:00PM </option>
              <option value="19">7:00PM </option>
              <option value="20">8:00PM </option>
              <option value="21">9:00PM </option>
              </select>
              </td>
				</tr>
             
        <tr>
          <th><label for="instructor">Instructor:</label></th>
          <td><input type="text" id="instructor" size="30" name="instructor" onkeypress="return onlyAlphabets(event,this);"></td>
        </tr>        
      </tbody>
      </table>
    </div>
    <p align="center"> 											
      <input value="SEARCH FOR CLASSES" type="submit" id = "submit" name = "submit">
      <input type="reset" value="CLEAR" id="reset"/></td>
   </p>
    <% 
      
   }
   //create SQL exception 
   catch(SQLException e)
   {
      // Do exception catch such as if connection is not made or query is not set up properly
      out.println("SQLException: " + e.getMessage() + "<BR>");
      while((e = e.getNextException()) != null)
         out.println(e.getMessage() + "<BR>");
   }
   //if class exception is not found, display message 
   catch(ClassNotFoundException e)
   {
      out.println("ClassNotFoundException: " + e.getMessage() + "<BR>");
   }
   finally
   {
	 //Clean up resources, close the connection
      if(rset != null && rset1 != null && rset2 != null && rset3 != null)
      {
         try
         {
            rset.close();
            rset1.close();
            rset2.close();
            rset3.close();
         
         }
         catch (Exception ignored) {}
      }
      if(stmt != null && stmt1 != null && stmt2 != null && stmt3 != null)
      {
         try
         {
        	 stmt.close();
         	 stmt1.close();
         	 stmt2.close();
         	 stmt3.close();
         	 
         }
         catch (Exception ignored) {}
      }
      if(conn != null)
      {
         try
         {
            conn.close();
         }
         catch (Exception ignored) {}
      }
	 
   }
%>
   
 
</form>



<!--FOOT Include Begins -->
<%@ include file="HTML/foot.html" %>
<!--FOOT Include Ends -->
