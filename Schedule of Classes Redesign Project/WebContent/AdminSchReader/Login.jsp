<!-- 
Name: John Tan 
Assignment #3 - JSP + JDBC
Date: 10/27/2013

--This is the Login.jsp page with the HTML from Login.html
--Disabling Back Button from sneaky user is incorporated in this page and other pages: update.jsp, display.jsp.

 -->


<%@ page contentType = "text/html" pageEncoding = "iso-8859-1" %>
<%@ page import="java.sql.*" %>
<%@ include file="username_TanJ.jsp" %>
<%@ page errorPage="errorpg.jsp" 
             import="java.sql.*, 
                     javax.sql.*, 
                     java.io.*,
                     java.lang.*,
                     javax.naming.InitialContext,
                     javax.naming.Context,
                     javax.servlet.*" %>

<!--head.html include Goes Here -->
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<title>Baruch College</title>
<meta name="description" content="" />
<meta name="keywords" content="" />
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<link REL="icon" href="http://www.baruch.cuny.edu/favicon.ico">
<link rel="stylesheet" type="text/css" href="http://www.baruch.cuny.edu/css/baruch_interior.css" />
<link rel="stylesheet" type="text/css" href="http://www.baruch.cuny.edu/css/application.css" />
<link href="schedule.css" rel="stylesheet" type="text/css" />

<script type="text/javaScript">
function disableBackButton()
{
window.history.forward();
}
setTimeout("disableBackButton()", 0);
</script>

<!--HEAD Include Ends -->

<!--BODY Include Begins -->
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


<BODY method = "post" BGCOLOR="white">


<center>
<H1><font color="red">Please Enter your User ID and Password</font></H1>
<br>
 
<FORM NAME = "frm" method = "post" ACTION="/Tan_John/Login">

<%
  //Define the connection URL
   Connection conn = null;
  //define statement object 
   Statement stmt = null;
  //define result object 
   ResultSet rset = null;
  
 	//get the parameter for username password and dept, and assign it to string.
   String username = request.getParameter("username");
   String password = request.getParameter("password");
   String dept = request.getParameter("dept");
   
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
      stmt = conn.createStatement();

      // Execute a query
      String Query1 = "SELECT * FROM admin_user_schedule_reader";
      rset = stmt.executeQuery(Query1); 
      
      //create label, select, and option tag for the drop down for selecting semester
      %>
       User  ID: 
       <INPUT TYPE="TEXT" NAME="username" VALUE=""><p>
       Password:
       <INPUT TYPE="password" NAME="password" VALUE=""><p>
       <label>Department ID:
       <select name="dept">
       <option selected="selected">Select Department </option>
      <%
      
      //a while loop that goes through the entire list of semester name in the down drop 
      while(rset.next())
      {
    	 
    	  String DEPT = rset.getString("DEPT");
    	  
      //assigning the semester name to the option value	  
      %>
      <option value="<%=DEPT %>"><%=DEPT %></option>
      <% 
      }
      //create input tag for entering start date and end date.
      //display error message from the session.
      %>
      </select></label>
      &nbsp;&nbsp;
      <P>
      <body onload="disableBackButton()">
      <INPUT TYPE="SUBMIT" value="Log In"> <!-- Press this button to submit form -->
      
      <p><font color="red">${errorMsg }</font></p>
      <c: remove var="message" scope="session"/>
      <% 
      
      
      //close resultset object and create statement that was connected to the database
      rset.close();
  	  stmt.close();
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
      if(conn != null)
      {
         try
         {
            conn.close();
         }
         catch (Exception ignored) {
        	 
         }
      }
   }
%>

</FORM>
</CENTER>


<!--FOOT Include Begins -->
</div>
<!-- /main -->
</div>
<!-- /wrapper -->
</body>
</html>
<!--FOOT Include Ends -->


