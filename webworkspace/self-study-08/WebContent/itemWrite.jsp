<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
	Connection conn=null;
	Statement stmt = null;
	ResultSet rs = null;
	
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String uid = "green";
	String pass = "green1234";
	String sql = "select * from item";

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1> 입력 완료된 정보 </h1>
<table border='1'>

<%
try{
	Class.forName("oracle.jdbc.driver.OracleDriver");
	conn = DriverManager.getConnection(url,uid,pass);
	stmt = conn.createStatement();
	rs = stmt.executeQuery(sql);
	while(rs.next())
	{
		out.println("<tr>");
		out.println("<td>"+rs.getString("name")+"</td>");
		out.println("<td>"+rs.getString("price")+"</td>");
		out.println("<td>"+rs.getString("description")+"</td>");
		out.println("</tr>");
	}
	
}catch(Exception e)
{
	e.printStackTrace();
}finally{
	try{
		if(rs!=null)
		{
			rs.close();
		}
		if(stmt!=null)
		{
			stmt.close();
		}
		if(conn!=null)
		{
			conn.close();
		}
	}catch(Exception e){
		e.printStackTrace();
	}
}
%>


</table>

</body>
</html>