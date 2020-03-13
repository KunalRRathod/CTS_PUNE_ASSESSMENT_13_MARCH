<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<!DOCTYPE html>
	<html>
	<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
	</head>
	<body>
			<%
				session.setMaxInactiveInterval(5);
			%>
			<!-- com.cognizant ref=new com.cts.bean.LoginBean() 
		creating object of LogicBean class -->
			<jsp:useBean id="ref" class="com.cognizant.LoginBean"
				scope="application" />
		
		
			<!-- ref.setUsername(request.getParameter("userName")); -->
			<%-- <jsp:setProperty property="userName" name="ref" />
		 --%>
		
			<!--  ref.setPassword(request.getParameter("password")); -->
			<%-- <jsp:setProperty property="password" name="ref" /> --%>
			<!--   -->
			<jsp:setProperty property="*" name="ref" />
			<jsp:forward page="view.jsp"></jsp:forward>

	</body>
	</html>