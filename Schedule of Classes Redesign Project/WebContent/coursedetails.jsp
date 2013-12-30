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
<link rel="stylesheet" type="text/css" href="CSS/jqueryStyle.css" />
<link href="CSS/schedule.css" rel="stylesheet" type="text/css" />

<!--BODY Include Begins -->
<%@ include file="HTML/body.html" %>
<!--BODY Include ENDS -->


<table id="details" summary="This table contains details about each course.">
 <%
	//Define connection, preparedstatement, create statement, resultset objects

	Connection conn = null; 

	//define statement object
	Statement stmt1 = null;

	
	//define result object 
	ResultSet rset1 = null;

   //get the variable
   String courseName = request.getParameter("course");
   String semester = request.getParameter("semester");
   String crs_cd = request.getParameter("crs_cd");
   
   
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
	   
	   
   // Create a statement object
   		stmt1 = conn.createStatement();


   		// Selecting the query for displaying Course Details and pass the parameters to match against the query such as coursename, Semester, and Course Code. 
		String Query1 = "SELECT DISTINCT disc||crs_num ||'-'||course_schedule_reader.title as couse_title, DEPT_SCHEDULE_READER.DEPT_NAME" + 
				" , crs_sec_schedule_reader.DISC || crs_sec_schedule_reader.CRS_NUM AS course, crs_sec_schedule_reader.semester, crs_sec_schedule_reader.semester ||' '|| EXTRACT(YEAR FROM start_date)as semester_year" +
				" , crs_sec_schedule_reader.crs_cd, crs_sec,(CASE WHEN d_e_g = 'E' OR d_e_g = 'D' THEN 'Undergraduate' WHEN d_e_g = 'G' THEN 'Graduate' ELSE d_e_g END) AS D_E_G,seats_avail" +
				" ,TO_CHAR(start_date,'MON DD,YYYY')||' - '|| TO_CHAR(end_date,'MON DD,YYYY') AS DATES" +
				" , meeting_days||', '||start_time||am_pm ||'-'|| stop_time||am_pm||', '||building||rm||', '||instructor_lname as meetingday" +
				" , (CASE WHEN CRS_COMMENTS1 IS NULL THEN 'No Comment' ELSE CRS_COMMENTS1 END) AS CRS_COMMENTS1 ,course_schedule_reader.credithour" +
				" , course_schedule_reader.description, (CASE WHEN prereq IS NULL THEN 'Prerequisite: None' ELSE prereq END) AS prereq " +
				" FROM crs_sec_schedule_reader, crs_comments_schedule_reader,course_schedule_reader, discipline_schedule_reader, DEPT_SCHEDULE_READER" +
				" WHERE crs_sec_schedule_reader.semester= crs_comments_schedule_reader.semester" +
				" AND crs_sec_schedule_reader.crs_cd= crs_comments_schedule_reader.crs_cd" +
				" AND course_schedule_reader.discipline=crs_sec_schedule_reader.disc" +
				" AND course_schedule_reader.coursenumber=crs_sec_schedule_reader.crs_num" + 
				" AND CRS_SEC_SCHEDULE_READER.DISC = discipline_schedule_reader.disc_abbreviation" + 
				" AND discipline_schedule_reader.dept_id=DEPT_SCHEDULE_READER.dept_id" + 
				" AND CRS_SEC_SCHEDULE_READER.SEATS_AVAIL != 0" + 
				" AND crs_sec_schedule_reader.DISC || crs_sec_schedule_reader.CRS_NUM = '"+ courseName +"'" + 				
				" AND crs_sec_schedule_reader.semester = '"+ semester +"'" + 
				" AND crs_sec_schedule_reader.crs_cd = '"+ crs_cd +"'";
   		
   		//execute the query 
   		rset1 = stmt1.executeQuery(Query1);
		
  %>
<caption>
Schedule of Classes Course Details 
</caption>  
 
 <%
 	while(rset1.next()){
 	
 	//Assign the strings to a string variable so it can be reused
 	String SEMESTERYEAR = rset1.getString("semester_year");
	String COURSETITLE = rset1.getString("couse_title");
	String COURSE_CODE = rset1.getString("crs_cd");
	String COURSE_SEC = rset1.getString("crs_sec");
	String DEPTNAME = rset1.getString("DEPT_NAME");
	String DEG = rset1.getString("d_e_g");
	String DATES1 = rset1.getString("DATES");
	String SEATS = rset1.getString("seats_avail");
	String MEETING_DAYS = rset1.getString("meetingday");
	String CREDIT_HOUR = rset1.getString("credithour");
	String DESC = rset1.getString("description");
	String COMMENTS = rset1.getString("crs_comments1");
	String PREREQS = rset1.getString("prereq");

%>
  <tr>
    <th scope="row">Semester:</th>
    <td><%=SEMESTERYEAR %> </td>
    

  </tr>
  <tr>
    <th scope="row">Course - Title:</th>

    <td><%=COURSETITLE %></td>

  </tr>
  <tr>
    <th scope="row">Code:</th>

    <td><%=COURSE_CODE %></td>

  </tr>
  <tr>
    <th scope="row">Section:</th>
 
    <td><%=COURSE_SEC %></td>

  </tr>
  <tr>
    <th scope="row">Department:</th>
    <td><%=DEPTNAME %></td>
  </tr>
  <tr>
    <th scope="row">Division:</th>

    <td><%=DEG %></td>

  </tr>
  <tr>
    <th scope="row">Dates:</th>

    <td><%=DATES1 %></td>

  </tr>
  <tr>
    <th scope="row">Seats Available:</th>

    <td><%=SEATS %></td>

  </tr>
  
  <tr>
    <th scope="row">Meeting 1 - Day &amp; Time, Building &amp; Room, Instructor: </th>

    <td><%=MEETING_DAYS %></td>
  </tr>
 
     <%
     //Have a counter that iterate meeting days if there are more than 1 Meeting days
     //Start from 2 and goes up to 5, if its more than 5, break.
     int count = 2; 
     
     while(rset1.next()){
	  
	  if(count <= 5){
	  
 	%>
 	 <tr>
    <th scope="row">Meeting <%= count += 0 %> - Day &amp; Time, Building &amp; Room, Instructor: </th>
    <td> <%=rset1.getString("meetingday")  %></td>
    </tr>
	<% 
	count++;
	  }
	  else{
		  break;
	  }
	}

	%>

  <tr>
    <th scope="row">Credit Hours: </th>

    <td><%=CREDIT_HOUR %></td>
  </tr>
  <tr>
    <th scope="row">Description:</th>

    <td><%=DESC %></td>

  </tr>
  <tr>
    <th scope="row">Course Comments: </th>

    <td><%=COMMENTS %></td>

  </tr>
  <tr>
    <th scope="row">Pre-requisite:</th>

    <td><%=PREREQS %></td>    
  </tr>
  <tr><th></th></tr>
	<%
 	}
	%>
  
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
  
</table>

<!--FOOT Include Begins -->
<%@ include file="HTML/foot.html" %>
<!--FOOT Include Ends -->
