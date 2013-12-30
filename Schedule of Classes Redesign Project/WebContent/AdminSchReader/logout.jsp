<%
session.removeAttribute("loginok");
//session.removeAttribute("errormsg");

	//if username is empty, redirect it back to login page 
	if ((session.getAttribute("username")==null)) {
		response.sendRedirect("/Tan_John/AdminSchReader/Login.jsp");
	}
	else{
		//invalidate the session that makes the container as invlaid. 
		//setheader to close the session
		session.invalidate();
		response.setHeader("Pragma","no-cache"); 
		response.setHeader("Cache-Control","no-store"); 
		response.setHeader("Expires","0"); 
		response.setDateHeader("Expires",-1); 
	}
	response.sendRedirect("/Tan_John/AdminSchReader/Login.jsp");
	
//When User Logout, it redirect it back to the Login.jsp page.
%>


<h3>You're session has been terminated.</h3><p>  Make sure that you close the browser to ensure no personal data is kept on the computer.
