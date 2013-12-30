<!-- 
Name: John Tan 
Assignment #3 - JSP + JDBC
Date: 10/27/2013


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
<TITLE>Semester Schedule - Update.jsp </TITLE>
<meta name="description" content="" />
<meta name="keywords" content="" />
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<link REL="icon" href="http://www.baruch.cuny.edu/favicon.ico">
<link rel="stylesheet" type="text/css" href="http://www.baruch.cuny.edu/css/baruch_interior.css" />
<link rel="stylesheet" type="text/css" href="http://www.baruch.cuny.edu/css/application.css" />
<link href="schedule.css" rel="stylesheet" type="text/css" />
<!--HEAD Include Ends -->

<script type="text/javaScript">
function disableBackButton()
{
window.history.forward();
}
setTimeout("disableBackButton()", 0);
</script>

<!--body.html include Goes Here -->
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

<BODY BGCOLOR="#FFFFFF">
<CENTER>
<H1>Welcome to Update Baruch Course Schedule</H1>
<BR><BR>

<FORM name = "frm" method = "post" ACTION="display.jsp" style="font-weight: bold;">
<%
  //Define the connection URL
   Connection conn = null;
  //define statement object 
   Statement stmt = null;
  //define result object 
   ResultSet rset = null;
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
      String Query1 = "SELECT * FROM SEMESTER_SCHEDULE_READER";
      rset = stmt.executeQuery(Query1); 
      
      //create label, select, and option tag for the drop down for selecting semester
      %>
      <label>Semester:
      <select name = "semesterName"> 
      <option selected="selected">Semester Select</option>
      <%
      
      //a while loop that goes through the entire list of semester name in the down drop 
      while(rset.next())
      {
    	  String semesterName = rset.getString("SEMESTER_NAME");
    	  
      //assigning the semester name to the option value	  
      %>
      <option value="<%=semesterName %>"><%=semesterName %></option>
      <% 
      }
      //create input tag for entering start date and end date.
      %>
      </select></label>
      &nbsp;&nbsp;
      Start Date:
  	  <INPUT TYPE="TEXT" NAME="startDate" VALUE="">&nbsp;&nbsp;&nbsp;
  	  End Date:
  	  <INPUT TYPE="TEXT" NAME="endDate" VALUE=""><br><br><br>
  	  <body onload="disableBackButton()">
  	  <INPUT TYPE="SUBMIT" name="SUBMIT" value="Update Schedule"> <!-- Press this button to submit form -->
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
         catch (Exception ignored) {}
      }
   }
%>
</FORM>

</CENTER>
</BODY>

<!--foot.html include Goes Here -->
<!--FOOT Include Begins -->
</div>
<!-- /main -->
</div>
<!-- /wrapper -->
</body>
</html>
<!--FOOT Include Ends -->