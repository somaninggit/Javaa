<%-- Write a JSP program that takes the user’s name and age from a form. Echo back the
name and
age along with a message stating the price of movie tickets. The price is determined by the age
passed to the JSP.
If the age is greater than 62, the movie ticket price is Rs. 50.
If the user is less than 10 years old, the price is Rs. 30.
For everyone else, the price is Rs. 80 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
out.println(request.getParameter("name"));
out.println(request.getParameter("age"));
int age=Integer.parseInt(request.getParameter("age"));
if(age>62) out.println("Rs:50");
else if(age<10) out.println("Rs : 30");
else out.println("Rs: 80");
%>
</body>
</html>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="Proj12.jsp">
name:<input name="name" type="text">
age:<input type="number" name="age">
<input type="submit" value="submit">
</form>
</body>
</html>