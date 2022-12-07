//Write a java servlet program to calculate the CGPA.
//Read the USN, Name, SGPA of previous 4 semesters from user in an HTML page.
//Calculate the CGPA and display the details using a Servlet class.
import java.io.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet("/cgpa")
public class Proj6 extends HttpServlet{
public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException{
String usn=req.getParameter("usn");
String name=req.getParameter("name");
double s1=Double.parseDouble(req.getParameter("s1"));
double s2=Double.parseDouble(req.getParameter("s2"));
double s3=Double.parseDouble(req.getParameter("s3"));
double s4=Double.parseDouble(req.getParameter("s4"));
double cgpa=(s1+s2+s3+s4)/4;
PrintWriter out=res.getWriter() ;
out.println(usn+"\t"+name+"\t"+"cgpa "+"\t"+cgpa);
}
}
cgpa.html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="get" action='cgpa'>
usn:<input type='text' name='usn'>
name:<input type='text' name='name'>
s1:<input type='text' name='s1'>
s2:<input type='text' name='s2'>
s3:<input type='text' name='s3'>
s4:<input type='text' name='s4'>
<input type='submit' name='submit'>
</form>
</body>
</html>