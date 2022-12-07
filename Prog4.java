import java.io.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.time.*;
@WebServlet("/vote")
public class Proj5 extends HttpServlet{
public void doPost(HttpServletRequest req, HttpServletResponse res) throws
IOException {
String fname=req.getParameter("fname");
String lname=req.getParameter("lname");
String email=req.getParameter("email");
String date=req.getParameter("dob");
PrintWriter out=res.getWriter();
LocalDate dob=LocalDate.parse(date);
LocalDate cur=LocalDate.now();
int k=Period.between(dob,cur).getYears();
if(k<18) {
out.println("You are not eligible");
}
else {
out.println("you are eligible to vote");
}}
}
vote.html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method='post' action='vote'><br>
<input type='text' name='fname'><br>
<input type='text' name='lname'><br>
<input type='email' name='email'><br>
<input type='date' name='dob'><br>
<input type='submit' value='submit'><br>
</form>
</body>
</html>