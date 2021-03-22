<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
	Connection conn=null;
	PreparedStatement pstmt = null;
	
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String uid = "green";
	String pass = "green1234";
	
	String sql = "insert into item values( ? , ? , ? )";

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
request.setCharacterEncoding("UTF-8");

String name = request.getParameter("name");
String price = request.getParameter("price");
String description = request.getParameter("description");

try{
	Class.forName("oracle.jdbc.driver.OracleDriver");
	conn = DriverManager.getConnection(url,uid,pass);
	pstmt = conn.prepareStatement(sql);
	pstmt.setString(1, name);
	pstmt.setString(2, price);
	pstmt.setString(3, description);
	pstmt.executeUpdate();
}catch(Exception e)
{
	e.printStackTrace();
}finally{
	try{
		if(pstmt!=null)
		{
			pstmt.close();
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
<a href="itemWrite.jsp"> 결과 보기 </a>
</body>
</html>