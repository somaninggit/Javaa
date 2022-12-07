<%-- Write a JSP program to accept the 5 subject marks entered and display his/her grade to
the
browser. Department has set the grade for the subject Java as follows: Above 90=S, 80-89=A,
70-
79=B, 60-69=C, 50-59=D, Below 50=FAIL. --%>
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
double s1=Double.parseDouble(request.getParameter("s1"));
double s2=Double.parseDouble(request.getParameter("s2"));
double s3=Double.parseDouble(request.getParameter("s3"));
double s4=Double.parseDouble(request.getParameter("s4"));
double s5=Double.parseDouble(request.getParameter("s5"));
double s=(s1+s2+s3+s4+s5)/5;
out.println(s);
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
<form action="Proj11.jsp" method="post">
s1:<input type="text" name="s1">
s2:<input type="text" name="s2">
s3:<input type="text" name="s3">
s4:<input type="text" name="s4">
s5:<input type="text" name="s5">
<input type="submit" value="calculate">
</form>
</body>
</html>