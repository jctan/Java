<!-- 
Name: John Tan 
Assignment #3 - JSP + JDBC
Date: 10/27/2013

--This is the display.jsp page with the HTML from display.html

 -->

<%@ page import="java.sql.*" %>
<%@ include file="username_TanJ.jsp" %>
<%@ page errorPage="errorpg.jsp" 
             import="java.sql.*, 
                     javax.sql.*, 
                     java.io.*,
                     javax.naming.InitialContext,
                     javax.naming.Context" %>

<!--head.html include Goes Here -->
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<TITLE>Semester Schedule - Display.jsp </TITLE>
<meta name="description" content="" />
<meta name="keywords" content="" />
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<link REL="icon" href="http://www.baruch.cuny.edu/favicon.ico">
<link rel="stylesheet" type="text/css" href="http://www.baruch.cuny.edu/css/baruch_interior.css" />
<link rel="stylesheet" type="text/css" href="http://www.baruch.cuny.edu/css/application.css" />
<link href="schedule.css" rel="stylesheet" type="text/css" />
<!--HEAD Include Ends -->

<!--body.html include Goes Here -->
<!--BODY Include Begins -->

<!--create a css style for the "update record" box -->
<style>
.header
{
	background-color:#CBE0E7;
	font-weight: bold; 
	text-align: left;
	align: left;
	border: 1;
}

</style>


</head>

<body>
<!-- wrapper -->
<div id="wrapper">

<!-- banner -->
<div id="banner"><a href="http://www.baruch.cuny.edu"><img src="http://www.baruch.cuny.edu/images/logo_baruch.gif" alt="Baruch College" name="logo" width="201" height="68" border="0" id="logo" /></a></div>
<!-- /banner -->
<!-- main -->
<div id="main">
<!--BODY Include ENDS -->

<BODY BGCOLOR="#FFFFFF">
<CENTER>
<B>You have successfully updated the semester schedule</B>
<BR><BR>

<p align="left">
	 <b>
	 <a href="logout.html"><font size="5">Log out</font></a> </b>&nbsp;<br>
<br>
</p>

<p align="left">
	 <b>
	 <a href="update.jsp"><font size="5">Update Again</font></a> </b>&nbsp;<br>
<br>
</p>

<%
	//Define connection, preparedstatement, create statement, resultset objects
   Connection conn = null;
   PreparedStatement ps = null;
   Statement stmt = null, stmt1 = null;
   ResultSet rset = null, rset1 = null;
   
   //get the variable semesterName, startDate, endDate from udpate.jsp and assign it to the string variable.
   String SEMESTER_NAME = request.getParameter("semesterName");
   String START_DATE = request.getParameter("startDate");
   String END_DATE = request.getParameter("endDate");
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
      
       
      //Create Statement for update statement
      	/*
       stmt1 = conn.createStatement();
       String Query2 = "update SEMESTER_SCHEDULE_READER set START_DATE = TO_DATE('"+START_DATE+"','MON DD,YYYY'),END_DATE = TO_DATE('"+END_DATE+"','MON DD,YYYY') where SEMESTER_NAME ='"+SEMESTER_NAME+"'";
       stmt1.executeUpdate(Query2);
       */
       
       //PreparedStatement for update statement
       String Query2 = "update SEMESTER_SCHEDULE_READER set START_DATE = TO_DATE(?,'MON DD,YYYY'), END_DATE = TO_DATE(?,'MON DD,YYYY') where SEMESTER_NAME = ?";
       ps = conn.prepareStatement(Query2); 
       ps.setString(3, SEMESTER_NAME);
       ps.setString(1, START_DATE); 
       ps.setString(2, END_DATE);
       ps.executeUpdate();
       
       //execute the create statement query (it executes the entire table)
       stmt = conn.createStatement();
       String Query1 = "SELECT * FROM SEMESTER_SCHEDULE_READER";
       rset = stmt.executeQuery(Query1);
       

      //create table for "update record" which catches only the updated record 
      %>
      <b><center><% out.println("Updated Record: "); %></center></b>
      <table width=‘600’ border=‘1’> 
        <tr>
           <th align=‘left’>Semester Name</th>
          <th align=‘left’>Start Date</th>
          <th align=‘left’>End Date</th>
        </tr>
      
      <%
      // Process result
	   		%>
	   		<tr>
	   		<td class="header"><%= SEMESTER_NAME%></td>
	   		<td class="header"><%= START_DATE%></td>
	   		<td class="header"><%= END_DATE%></td>
	   		</tr>
	   		</table>
	   	 	<%
	   	 
       //This create table for "Full Semester Schedule" and only catch the fields of Semester Name, Start Date, and End Date
       %>
       <p>&nbsp;&nbsp;</p>
       <b><center><% out.println("Full Semester Schedule: "); %></center></b>
       <table width=‘600’ border=‘1’> 
         <tr>
            <th align=‘left’>Semester Name</th>
           <th align=‘left’>Start Date</th>
           <th align=‘left’>End Date</th>
         </tr>
          <%
          
          ////a while loop that goes through the entire list of semester name in the down drop       
    	  while(rset.next())
    	    {
    		  //if the updated semester name matches with the semester name in the database, bold and bgcolor that updated record
    		  if((SEMESTER_NAME).equals(rset.getString("SEMESTER_NAME"))){
    	  	  		%>
    	  	  		<tr>
    	  	  		<td bgcolor="CBE0E7"><b> <%= rset.getString("SEMESTER_NAME")%></b></td>
    	  	  	   	<td bgcolor="CBE0E7"><b> <%= rset.getDate("START_DATE")%></b></td>
    	  	  	   	<td bgcolor="CBE0E7"><b> <%= rset.getDate("END_DATE")%></b></td>
    	  	  	   	 </tr>
    	  	  	   	 <%
    	          }
    		  else{
    			  //else just get all the semester name, start date, and end date from the database
           	 %>
          	 <tr>
          	 <td> <%= rset.getString("SEMESTER_NAME")%></td>
          	 <td> <%= rset.getDate("START_DATE")%></td>
          	 <td> <%= rset.getDate("END_DATE")%></td>
          	 </tr>
          	  <%
    		  }
    	     }

   		//stmt1.close();
   		
   		//close preparedstatement, resultset object, and create statement that was connected to the database
   		ps.close();
   		stmt.close();
   		rset.close();
   		}
    //create SQL exception 
    catch(SQLException e)
	{
    //Do exception catch such as if connection is not made or query is not set up properly
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
  </CENTER>
</body>
</html>