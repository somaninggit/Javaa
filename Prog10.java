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


import java.io.*;
import java.util.*;
import java.sql.*;
import javax.servlet.*;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class trial
 */
@WebServlet("/p10")
public class p10 extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		Connection conn = null;
		String dbName="Emp";
		String userName="root";
		String password = "";
		String url="jdbc:mysql://localhost:3306/";
		String driver = "com.mysql.jdbc.Driver";
		
		String query="INSERT INTO `emp`(`eid`, `name`) VALUES (?,?)";
		
		
		String eid=request.getParameter("eid");
		String name=request.getParameter("name");
		
		
		try {
			Class.forName(driver).getDeclaredConstructor().newInstance();
			conn=(Connection) DriverManager.getConnection(url+dbName,userName,password);
			
			PreparedStatement ps= conn.prepareStatement(query);
			
			ps.setString(1, eid);
			ps.setString(2, name);
			ps.execute();
			ps.close();
			Statement stmt=conn.createStatement();
			String q2="SELECT * FROM `emp`";
			ResultSet rs= stmt.executeQuery(q2);
			while(rs.next()) {
				String f1=rs.getString(1);
				String f2=rs.getString(2);
				out.println("<html><body>"
						+ f1+
						" "+
						f2+"</body></html>");
			}
					
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}
		
		
	}

	

}












<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="p10" method = "GET">
EId<input type = "text" name ="eid">
Name<input type = "text" name ="name">
<input type = "submit">
</form>
</body>
</html>
