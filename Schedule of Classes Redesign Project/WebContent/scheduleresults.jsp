<!-- 
Name: John Tan 
Project: Schedule of Classes Redesign
Date: 12/2/2013

 -->


<%@ page import="java.sql.*" %>
<%@ include file = "username_John.jsp" %>
<%@ page errorPage="errorpg.jsp" 
			 import="java.sql.*, 
             		 java.util.*,
             		 java.util.Date,
             		 java.text.*,
                     javax.sql.*, 
                     java.io.*,
                     javax.naming.InitialContext,
                     javax.naming.Context" %>



<!--head.html include Goes Here -->
<%@ include file="HTML/head.html" %>


<script type="text/javascript" src="JS/jquery-1.4.2.min.js"></script>
<script src="JS/jquery.autocomplete.js"></script>
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js"></script>

 <!--an external include for JQuery-->
<script src="http://code.jquery.com/jquery-1.7.1.min.js"></script>
<script type="text/javascript"  src="JS/JQueryToggle.js"></script>

<link rel="stylesheet" type="text/css" href="CSS/jqueryStyle.css" />
<link href="CSS/schedule.css" rel="stylesheet" type="text/css" />



<!--HEAD Include Ends -->


<!--BODY Include Begins -->
<%@ include file="HTML/body.html" %>
<!--BODY Include ENDS -->



  <p>Search results are based on the following keywords:</p>
  
  
  <table id="criteria" summary="This table contains the search criteria. Results are listed in next table.">
  
  <%
	//Define connection, preparedstatement, create statement, resultset objects

	Connection conn = null; 

	//define statement object
	Statement stmt1 = null;

	//define result object 
	ResultSet rset1 = null;

	
   //get the variable to pass and check against the database 
   String semesterName = request.getParameter("semesterName");
   String DEPT = request.getParameter("dept");
   String DISCIPLINE = request.getParameter("discipline");
   String U = request.getParameter("u_div");
   String G = request.getParameter("g_div");
   String [] Undergraduate = request.getParameterValues("u_div");
   String [] Graduate = request.getParameterValues("g_div");
   String CRS_NUM = request.getParameter("number");
   String DAYS = request.getParameter("days");
   String INSTRUCTOR = request.getParameter("instructor");
   
   //request time and convert to inter 
   String time = request.getParameter("time");
   int time_t = 0;
   if(time != null && !time.isEmpty()){
	   time_t = Integer.parseInt(time);
   }
   
   //request time condition of 1=BEFORE, 2=AFTER, 3=AROUND
   String time_condition = request.getParameter("time_condition");
   int time_c = 0;
   
   if(time_condition != null && !time_condition.isEmpty()){
	   time_c = Integer.parseInt(time_condition);
   }


   try
   {
		// Load the driver
				Class.forName(driver);

	   // Establish the connection
	  // myusername and mypassword are declared in a file called username_TanJ.jsp
      conn = DriverManager.getConnection(
                url ,
                myusername,
                mypassword);
	   
        	

   		// assign connection object to 
   		stmt1 = conn.createStatement();
 
   		
		//Selecting Query for ScheduleResult
   		
   		String Query1 = "SELECT DISTINCT disc|| crs_num as course, d.DEPT_NAME, a.D_E_G, a.DISC, a.CRS_NUM, a.crs_cd, a.crs_sec, a.meeting_days, TO_NUMBER(TO_CHAR(TO_DATE(START_TIME||AM_PM,'hh:,miAM'),'hh24')) AS MILITARY_TIME, START_TIME, a.start_time||am_pm||' - '||stop_time||am_pm as days_time, a.START_DATE, a.END_DATE, TO_CHAR(start_date,'MON DD,YYYY')|| ' - ' ||TO_CHAR(end_date,'MON DD,YYYY') as dates, a.building||rm AS loc, a.instructor_lname, a.seats_avail, a.semester, (CASE WHEN a.START_DATE = TO_DATE('AUG 27,2012','MON DD,YYYY') AND a.END_DATE = TO_DATE('DEC 12,2012','MON DD,YYYY') THEN 'Fall 2012' WHEN a.START_DATE = TO_DATE('JAN 27,2012','MON DD,YYYY') AND a.END_DATE = TO_DATE('MAY 15,2012','MON DD,YYYY') THEN 'Spring 2012' WHEN a.START_DATE = TO_DATE('AUG 27,2012','MON DD,YYYY') AND a.END_DATE = TO_DATE('DEC 12,2012','MON DD,YYYY') THEN 'January Intersession 2012' WHEN a.START_DATE = TO_DATE('MAY 31,2012','MON DD,YYYY') AND a.END_DATE = TO_DATE('AUG 16,2012','MON DD,YYYY') THEN 'Summer ALL 2012' WHEN a.START_DATE = TO_DATE('MAY 31,2012','MON DD,YYYY') AND a.END_DATE = TO_DATE('AUG 16,2012','MON DD,YYYY') THEN 'Summer00 2012' WHEN a.START_DATE = TO_DATE('MAY 31,2012','MON DD,YYYY') AND a.END_DATE = TO_DATE('JUL 12,2012','MON DD,YYYY') THEN 'Summer01 2012' WHEN a.START_DATE = TO_DATE('JUL 16,2012','MON DD,YYYY') AND a.END_DATE = TO_DATE('AUG 16,2012','MON DD,YYYY') THEN 'Summer02 2012' ELSE a.semester END) AS SemesterName, e.UPDATE_TIME, (CASE" +
   			    " WHEN b.CRS_COMMENTS1 IS NULL THEN 'NO COMMENT'"+
   			    " ELSE b.CRS_COMMENTS1"+
   			    " END) AS CRS_COMMENTS1"+
   			    " FROM CRS_SEC_SCHEDULE_READER a, crs_comments_Schedule_reader b, discipline_schedule_reader c, DEPT_SCHEDULE_READER d, UPDATE_TIME_SCHEDULE_READER e"+
   				" WHERE a.crs_cd = b.crs_cd"+
   				" AND a.semester = b.semester"+
   				" AND b.semester = e.semester"+
   				" AND a.DISC = c.disc_abbreviation"+
   				" AND c.dept_id = d.dept_id"+
   				" AND a.SEATS_AVAIL != 0"+
   				" AND a.START_TIME != '00:00'"+
   				" AND a.START_TIME != 'ON:LI'";
   
		//If condition is met, append additional statement to the query to get the desired results.
   		if(!(semesterName.length() ==0 || semesterName == null)){
   			if(semesterName.equals("Fall 2012")){
   			Query1 += " AND START_DATE = TO_DATE('AUG 27,2012','MON DD,YYYY') AND END_DATE = TO_DATE('DEC 12,2012','MON DD,YYYY')";
   			}
   			else if (semesterName.equals("Spring 2012")){
   				Query1 += " AND START_DATE = TO_DATE('JAN 27,2012','MON DD,YYYY') AND END_DATE = TO_DATE('MAY 15,2012','MON DD,YYYY')";
   			}
   			else if (semesterName.equals("Summer ALL 2012")){
   				Query1 += " AND START_DATE = TO_DATE('MAY 31,2012','MON DD,YYYY') AND END_DATE = TO_DATE('AUG 16,2012','MON DD,YYYY')";
   			}
   			else if (semesterName.equals("Summer00 2012")){
   				Query1 += " AND START_DATE = TO_DATE('MAY 31,2012','MON DD,YYYY') AND END_DATE = TO_DATE('AUG 16,2012','MON DD,YYYY')";
   			}
   			else if (semesterName.equals("Summer01 2012")){
   				Query1 += " AND START_DATE = TO_DATE('MAY 31,2012','MON DD,YYYY') AND END_DATE = TO_DATE('JUL 12,2012','MON DD,YYYY')";
   			}
   			else if (semesterName.equals("Summer02 2012")){
   				Query1 += " AND START_DATE = TO_DATE('JUL 16,2012','MON DD,YYYY') AND END_DATE = TO_DATE('AUG 16,2012','MON DD,YYYY')";
   			}
   			else{
   				Query1 += " AND a.semester = '"+semesterName+"'";
   			}
   		}
   		
   		if(!(CRS_NUM.length() ==0 || CRS_NUM == null )){
   			Query1 += " AND a.crs_num = '"+CRS_NUM+"'";
   		}
   		
   		if(!(DEPT.length() ==0 || DEPT == null )){
   			Query1 += " AND d.DEPT_NAME = '"+DEPT+"'";
   		}
   		
   		if(!(DISCIPLINE.length() ==0 || DISCIPLINE == null )){
   			Query1 += " AND a.DISC= '"+DISCIPLINE+"'";
   		}
   		
   		if(!(DAYS.length() ==0 || DAYS == null )){
   			Query1 += " AND a.meeting_days= '"+DAYS+"'";
   		}
   		
   		if(!(INSTRUCTOR.length() ==0 || INSTRUCTOR == null )){
   			Query1 += " AND a.instructor_lname = '"+INSTRUCTOR+"'";
   		}
			
   		
   		 //U = D and E for Undergraduate
   		if(!(U == null)){
      			Query1 += " AND (a.D_E_G = 'D' OR a.D_E_G = 'E')";
      		}
      		
   		//G = G for Graduate
      		if(!(G == null)){
      			Query1 += " AND (a.D_E_G = 'G')";
      		}
   			
			
   	 if((time != null && !time.isEmpty()) && (time_condition != null && !time_condition.isEmpty())){
   		  

   			// time_t < 12 is AM and time_t >= 12 is PM
   			// BEFORE & AM 
   			//BEFORE = 1 
   	   		if ((time_c == 1) && (time_t < 12)){
   	   			Query1 += " AND TO_NUMBER(TO_CHAR(TO_DATE(START_TIME||AM_PM,'hh:,miAM'),'hh24')) < '"+time_t+"' AND AM_PM = 'AM'";
   	   		}

   			//BEFORE & PM
   			//BEFORE = 1 
   			else if ((time_c == 1) && (time_t >= 12)){
   	   			Query1 += " AND TO_NUMBER(TO_CHAR(TO_DATE(START_TIME||AM_PM,'hh:,miAM'),'hh24')) < '"+time_t+"' AND AM_PM = 'PM'";
   	   		}
   	   		
   			//AFTER & AM
   			//AFTER = 2 
   			else if((time_c == 2) && (time_t < 12)) {
   	   			Query1 += " AND TO_NUMBER(TO_CHAR(TO_DATE(START_TIME||AM_PM,'hh:,miAM'),'hh24')) > '"+time_t+"' AND AM_PM = 'AM'";
   	   		}
   			
   			//AFTER & PM 
   			//AFTER = 2
   			else if ((time_c == 2) && (time_t >= 12)){
   	   			Query1 += " AND TO_NUMBER(TO_CHAR(TO_DATE(START_TIME||AM_PM,'hh:,miAM'),'hh24')) > '"+time_t+"' AND AM_PM = 'PM'";
   	   		}
   			
   			//AROUND & AM 
   			//AROUND = 3 
   			else if((time_c == 3) && (time_t < 12)) {
   	   			Query1 += " AND TO_NUMBER(TO_CHAR(TO_DATE(START_TIME||AM_PM,'hh:,miAM'),'hh24')) = '"+time_t+"' AND AM_PM = 'AM'";
   	   		}
   			
   			
   			//AROUND & PM 
   			//AROUND = 3 
   			else if ((time_c == 3) && (time_t >= 12)){
   	   			Query1 += " AND TO_NUMBER(TO_CHAR(TO_DATE(START_TIME||AM_PM,'hh:,miAM'),'hh24')) = '"+time_t+"' AND AM_PM = 'PM'";
   	   		}
   			else{
   				Query1 += " AND TO_NUMBER(TO_CHAR(TO_DATE(START_TIME||AM_PM,'hh:,miAM'),'hh24'))";
   			}
   			
   		}	
   		
		//Execute the query.
   		rset1 = stmt1.executeQuery(Query1);
  
  %>

    <tr>
 			<td><strong>Semester: </strong>
 		<%
 		//Print semester at the top of the page 
    	if(!(semesterName.length() == 0 || semesterName == null)){
    			
    		 out.print("&nbsp;"+semesterName+"&nbsp;");
    		}
 		else{
 			out.println ("<b>None Entered<b>");

 		}
    %>	
    </td>
 			
     <td><strong>Days: </strong>
    <%
    	//Print Days at the top of the page
    	if(!(DAYS.length() ==0 || DAYS == null)){
    		out.println("&nbsp;"+DAYS+"&nbsp;");
    	}
    	else{
    		out.println ("<b>None Entered<b>");
    	}
    %>	
    </td>
    </tr>

    <tr>
      <td><strong>Department: </strong>
      <%
      //Displaying Department at the top of the page
    	if(!(DEPT.length() ==0 || DEPT == null )){
    		out.println("&nbsp;"+DEPT+"&nbsp;");
    	}
    	else{
    		out.println ("<b>None Entered<b>");
    	}
    %>
      <td><strong>Time: </strong>
      <%
      //Print time as Before = 1, After = 2, Around = 3
    	if(!(time.length() ==0 || time == null)){
    		
    		 if(time_condition != null){
    		
    		//print the conditions
    		if(time_c == 1){
    			out.println("BEFORE");
    		}
    		else if(time_c == 2){
    			out.println("AFTER");
    		}
    		else if(time_c == 3){
    			out.println("AROUND");
    		}
    		else{
    	    	out.println ("<b>None Entered<b>");
    		}
         }

    		 
       if(time != null){

    	   	  	 
    		//Print the time in standardize time as it was in military time.
    		if(time_t == 7){
    			out.println("7:00AM");
    		}
    		else if(time_t == 8){
    			out.println("8:00AM");
    		}
    		else if(time_t == 9){
    			out.println("9:00AM");
    		}
    		else if(time_t == 10){
    			out.println("10:00AM");
    		}
    		else if(time_t == 11){
    			out.println("11:00AM");
    		}
    		else if(time_t == 12){
    			out.println("12:00PM");
    		}
    		else if(time_t == 13){
    			out.println("1:00PM");
    		}
    		else if(time_t == 14){
    			out.println("2:00PM");
    		}
    		else if(time_t == 15){
    			out.println("3:00PM");
    		}
    		else if(time_t == 16){
    			out.println("4:00PM");
    		}
    		else if(time_t == 17){
    			out.println("5:00PM");
    		}
    		else if(time_t == 18){
    			out.println("6:00PM");
    		}
    		else if(time_t == 19){
    			out.println("7:00PM");
    		}
    		else if(time_t == 20){
    			out.println("8:00PM");
    		}
    		else if(time_t == 21){
    			out.println("9:00PM");
    		}
    	}
    	else{
    		out.println ("<b>None Entered<b>");
    	}
    }
   	 %>
    </td>
    </tr>
    
    
    <tr>
      <td><strong>Discipline: </strong>
        <%
        //Print Discipline at the top of the page
    	if(!(DISCIPLINE.length() ==0 || DISCIPLINE == null )){
    		out.println("&nbsp;"+DISCIPLINE+"&nbsp;");
    	}
    	else{
    		out.println ("<b>None Entered<b>");
    	}
   	 %>
      </td>
      <td><strong>Course number: </strong>
      <%
       //Print course number at the top of the page
    	if(!(CRS_NUM.length() ==0 || CRS_NUM == null )){
    		out.println("&nbsp;"+CRS_NUM+"&nbsp;");
    	}
    	else{
    		out.println ("<b>None Entered<b>");
    	}
   	 %>
      </td>
    </tr>
    
    <tr>
    <td><strong>Division</strong>:
    <%
     // Print the division if selected, if its not selected, display both Undergraduate and Graduate
    	if(Undergraduate != null){
    		for (int i = 0; i < Undergraduate.length; i++){
    			out.println("&nbsp;"+Undergraduate[i]+"&nbsp;");
    	}
    	}
    	else if(Graduate != null){
			for (int i = 0; i < Graduate.length; i++){
			out.println("&nbsp;"+Graduate[i]+"&nbsp;");
			}
		}
    	else{
    		out.println("Undergraduate &nbsp; Graduate");
    	}
  	  


    %>
    </td>
    
      <td><strong>Instructor</strong>: 
      <%
    	if(!(INSTRUCTOR.length() ==0 || INSTRUCTOR == null )){
    		out.println("&nbsp;"+INSTRUCTOR+"&nbsp;");
    	}
    	else{
    		out.println ("<b>None Entered<b>");
    	}
   	 %>
    </td>
    </tr>
    </table>
    <%
    //Display Date and Time
    DateFormat dateFormat = new SimpleDateFormat("MMMM dd, yyyy");
    java.util.Date date = new java.util.Date();
    
    Calendar cal = Calendar.getInstance();
	cal.getTime();
	SimpleDateFormat sdf = new SimpleDateFormat("K:mm:ss aa");
	
	//ResultSet rset1 for UPDATE_TIME
	rset1.next();
		
    %>
  <font color="red">
  <p><b>The schedule was LAST&nbsp; UDPATED at <font size = "3" color = "Blue"> <%= rset1.getString("UPDATE_TIME") %> </font></b></p>
    <p><b>The schedule was LAST&nbsp; SEARCHED at <font size = "3" color = "Green"><%=sdf.format(cal.getTime()) %></font> on <font size = "3" color = "Green"><%=dateFormat.format(date) %></font></b></p>
  <p>Due to the dynamic nature of the registration process, not all courses listed as open will have space for new registrants.</p>
  </font></div>
<table id="results" summary="This table contains the search results for schedule of classes.">
  <caption>
  <!--Added color, size and bold to the caption-->
  <p style="color: #006699; font-size: 16pt">
  <b>Schedule of Classes Search Results</b>
  </p>
  </caption>
  <thead>
    <tr>
    
      <th scope="col">Course</th>
      <th scope="col">Code</th>
      <th scope="col">Section</th>
      <th scope="col">Day</th>
      <th scope="col">Time </th>
      <th scope="col">Start Date - End Date</th>
      <th scope="col">BLDG &amp; RM </th>
      <th scope="col">Instructor</th>
      <th scope="col">Seats Avail </th>
      <th scope="col">Semester </th>
      <th scope="col">Comments </th>
    </tr>
  </thead>
  
  <tbody>

    <% 
    while(rset1.next()){

    		%>
    	<tr>
		<td> 
		<a href= <%= "coursedetails.jsp?course=" + rset1.getString("course") + "&semester=" + rset1.getString("semester") + "&crs_cd=" + rset1.getString("crs_cd") %>><%=rset1.getString("course") %></a>
		</td>
      <td bgcolor=#6699CC><%=rset1.getString("crs_cd") %></td>
      <td bgcolor=#6699CC><%=rset1.getString("crs_sec") %></td>
      <td bgcolor=#6699CC><%=rset1.getString("meeting_days") %></td>
      <td bgcolor=#6699CC><%=rset1.getString("days_time") %><br/></td>
      <td bgcolor=#6699CC><%=rset1.getString("dates") %></td>
      <td bgcolor=#6699CC><%=rset1.getString("loc") %></td>
      <td bgcolor=#6699CC><%=rset1.getString("instructor_lname") %><br/></td>
      <td bgcolor=#6699CC><%=rset1.getString("seats_avail") %></td>
      <td bgcolor=#6699CC><%=rset1.getString("SemesterName") %></td>
      <td bgcolor=#6699CC><%=rset1.getString("CRS_COMMENTS1") %></td>
      </tr>
    <% 
    }	
      %>

    </tbody>
</table>
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
      if(rset1 != null)
      {
         try
         {
            rset1.close();
            
         }
         catch (Exception ignored) {}
      }
      if(stmt1 != null)
      {
         try
         {
         	 stmt1.close();
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

<!--FOOT Include Begins -->
<%@ include file="HTML/foot.html" %>
<!--FOOT Include Ends -->

