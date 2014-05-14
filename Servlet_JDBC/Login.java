/* 
Name: John Tan 
Assignment #3 - JSP + JDBC
Date: 10/27/2013

--This is the Login.java servlet to check against username and password for the Login 
--This includes session for displaying error message when user login is invalid 
 */


import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.sql.*;
import javax.sql.*;
import javax.naming.*;
import java.util.List;

@WebServlet("/LoginServlet")
public class Login extends HttpServlet {
	
	//declare the vairables for connection 
	private static final long serialVersionUID = 1L;
	private static Connection conn = null;
	private static final String driver = "oracle.jdbc.OracleDriver";
	private static final String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
	private static final String user = "user";
	private static final String pass = "pass";
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Declare PrintWriter for the output 
		PrintWriter out = response.getWriter();

		//Declare object for Resultset and Statement. Assigned it to NULL.
		ResultSet rset = null;
		Statement stmt = null;
		
		//create new strings for USER_NAME,PASSWORD,DEPT
		String USER_NAME = new String("");
		String PASSWORD = new String("");
		String DEPT = new String("");
		
		//get the parameter for username password and dept, and assign it to string.
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String dept = request.getParameter("dept");
		
		//create session object 
		HttpSession session = request.getSession(true);
		 
		try{
			
			//load database driver
			Class.forName(driver);
			
			//get a connection to the database
			conn = DriverManager.getConnection(url,user,pass);
			
			//if username and password is not empty, assign it to a string to match with the string variable from the DB
			if(username!=null && username!="" && password!=null && password!=""){
				username = username.toString();
				password = password.toString();
				
				//create statement object 
				stmt = conn.createStatement();
				
				//create query and execute query to get data from the database
				String Query = "SELECT * FROM admin_user_schedule_reader";
				stmt.executeQuery(Query);
				rset = stmt.getResultSet();
		    
			//loop the resultset for the attributes in the DB (USER_NAME, PASSWORD, DEPT)
		    while(rset.next())
		    {
		    	USER_NAME = rset.getString("USER_NAME");
		    	PASSWORD = rset.getString("PASSWORD");
		    	DEPT = rset.getString("DEPT");
		    }
		    
		    //if username is not empty and is equal to the attribute USER_NAME in db, if password is not empty and is equal to the attribute PASSWORD in DB 
		    //if dept is equal to DEPT in DB, then request the username, and redirect to the home page
		    if((!(username.equals(null) && username.equals(USER_NAME))
						 && (!(password.equals(null) && password.equals(PASSWORD)))
						 && (dept.equals(DEPT)))){
		    		 //send request to udpate.jsp page
		    		 request.getSession().setAttribute("username",username); //Login user
		    		 response.sendRedirect("/Tan_John/AdminSchReader/update.jsp"); //redirect to update page if the condition have met.
					 
		    }
		    else{
		    	//set the errorMsg to "invalid username or password"
		    	//redirect it back to Login page
		    	String errorMsg = "invalid username or password";
		    	request.getSession().setAttribute("errorMsg", errorMsg);
		    	response.sendRedirect("/Tan_John/AdminSchReader/Login.jsp");
		    	 }
		    }
			//else, other than the condition, just redirect it to Login.jsp
			else{
				response.sendRedirect("/Tan_John/AdminSchReader/Login.jsp");
			}
			
			//close statement, resuletset, and connection 
		    stmt.close();
		    rset.close();
		    conn.close();
		      }
				//print the stack trace of the Exception to System error. when it executes it invokes into the execute stack.
				catch(Exception e){
		    	  e.printStackTrace();
		      }

	}	

}


