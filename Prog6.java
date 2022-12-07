import java.io.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.lang.Math;
@WebServlet("/calc")
6.
public class Proj7 extends HttpServlet{
public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException{
PrintWriter out=res.getWriter() ;
double n1=Double.parseDouble(req.getParameter("n1"));
double n2=Double.parseDouble(req.getParameter("n2"));
String op=req.getParameter("op");
switch(op) {
case "add":
out.println(n1+n2);
break;
case "sub":
out.println(n1-n2);
break;
case "mul":
out.println(n1*n2);
break;
case "div":
if(n2==0)
out.println("second number cannot be zero");
else {
out.println(n1/n2);
}
break;
case "expo":
out.println(Math.exp(n1));
break;
default:
out.println("invalid");
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
<form method='get' action='calc'>
first number:<input type='text' name='n1'><br>
second number <input type='text' name='n2'><br>
Addition<input type='radio' value='add' name='op'><br>
Subtraction<input type='radio' value='sub' name='op'><br>
Multiplication<input type='radio' value='mul' name='op'><br>
Division<input type='radio' value='div' name='op'><br>
e^x<input type='radio' value='expo' name='op'><br>
<input type='submit' value ="submit">
</form>
</body>
</html>