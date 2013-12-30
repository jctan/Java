<%
// 
//--CHECK_OracleSID
//select * from all_services

String driver = "oracle.jdbc.OracleDriver";
String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE"; //Change OracleSID to XE
String myusername = "user"; //YOur oracle ID
String mypassword = "pass"; //YOur oracle Pass
%>

