<%
/*
Name: John Tan 
Project: Schedule of Classes Redesign
Date: 12/2/2013

*/
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@ include file = "username_John.jsp" %>

<%
   try{
	   
	 
	     Class.forName(driver);
	     Connection conn = DriverManager.getConnection(url, myusername, mypassword);
	     Statement st1 = conn.createStatement();
	     //Select Query on Course Number
	     String Query1 = "SELECT DISTINCT crs_num FROM crs_sec_schedule_reader";
	     ResultSet rs1 = st1.executeQuery(Query1);
	     
	   	  //Declare an Array List object
	       List li = new ArrayList();
	 
	       while(rs1.next())
	       {
	           li.add(rs1.getString("CRS_NUM"));
	       }
	       
	     //Declare String array object to place an Array List into it
	       String[] str = new String[li.size()];
	     
	     //declare iterator option 
	       Iterator it = li.iterator();
	 
	       int i = 0;
	       // hasNext() returns true until it reaches to the end of the list and has another instructor in the data source that scanner looks for
	       while(it.hasNext()) //loop the iterator and go through the list of instructors and place it into a list of strings
	       {
	    	 //iterate through the String of array
	           String p = (String)it.next();
	           str[i] = p;
	           i++;
	       }
	 
	    ///request the jQuery variable for drop down list 
	       String query = (String)request.getParameter("q");
	 
	       int count=1;
	       for(int j=0;j<str.length;j++)
	       {
	           if(str[j].toUpperCase().startsWith(query.toUpperCase())) //Display the first letter as UpperCase
	           {
	              out.print(str[j]+"\n");
	              if(count>=10)// a length of 10 results that shows while typing (autosuggestion).
	              break;
	              count++;
	            }
	       }
	  
	 
	rs1.close();
	st1.close();
	conn.close();
	 
   }
   catch(Exception e){
   e.printStackTrace();
   }

   
%>