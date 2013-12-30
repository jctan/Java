<%@ page import="java.sql.*" %>
<%@ include file="username1.jsp" %>

<HTML>
<HEAD><TITLE>SEMESTER SCHEDULE READER </TITLE></HEAD>
<BODY BGCOLOR="#FFFFFF">
<CENTER>
<B>My Tables</B>
<BR><BR>

<BODY BGCOLOR="white">
<CENTER>
<H1>Welcome to Update Baruch Course Schedule</H1>
<br>


<%
   Connection conn = null;
   try
   {
      // 1. Load the driver
				Class.forName(driver);

      // myusername and mypassword are declared iun a file called username.jsp
      
       // 2. Define the connection URL
	   // 3. Establish the connection
      conn = DriverManager.getConnection(
                url ,
                myusername,
                mypassword);
                
             
      // 4. Create a statement object
      Statement stmt = conn.createStatement();

      // 5. Execute a query
      ResultSet rs = stmt.executeQuery("SELECT * FROM SEMESTER_SCHEDULE_READER"); 

      //Print start of table and column headers
      out.println("<TABLE CELLSPACING=\"0\" CELLPADDING=\"3\" BORDER=\"1\">");
      out.println("<TR><TH>SEMESTER ID</TH><TH>START DATE</TH><TH>END DATE</TH><TH>SEMESTER NAME</TH><TH>SEMESTER</TH></TR>");

      // 6. Process result
      //column names and Data types has to match Db columns
      while(rs.next())
      {
         out.println("<TR>");
         out.println("<TD>" + rs.getString("SEMESTER_ID") + "</TD>");
         out.println("<TD>" + rs.getString("START_DATE") + "</TD>");
         out.println("<TD>" + rs.getString("END_DATE") + "</TD>");
         out.println("<TD>" + rs.getInt("SEMESTER_NAME") + "</TD>");
         out.println("<TD>" + rs.getInt("SEMESTER") + "</TD>");

         out.println("</TR>");
      }

      out.println("</TABLE>");
   }
   catch(SQLException e)
   {
      // Do exception catch such as if connection is not made or 
      // query is not set up properly
      out.println("SQLException: " + e.getMessage() + "<BR>");
      while((e = e.getNextException()) != null)
         out.println(e.getMessage() + "<BR>");
   }
   catch(ClassNotFoundException e)
   {
      out.println("ClassNotFoundException: " + e.getMessage() + "<BR>");
   }
   finally
   {
// 7. Close connection; Clean up resources
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

</CENTER>
</BODY>
</HTML>