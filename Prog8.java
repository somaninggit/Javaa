//Write a java servlet program that reads either area name or phone no.
//of police station of and displays details of the police station.
//Use a HTML file to read the input and display the output using a Servlet class.
//Create police_station table with appropriate fields like Station_ID, Area_Name,
//Phone_Number and Address.
import java.io.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.sql.*;
@WebServlet("/police")
public class Proj9 extends HttpServlet{
public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException{
String area=req.getParameter("area");
String phno=req.getParameter("phno");
String query;
Connection con=null;
Statement st=null;
ResultSet rs=null;
PrintWriter out=res.getWriter() ;
try {
Class.forName("com.mysql.jdbc.Driver").newInstance();
con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","");
query="select * from Police where Area_Name = '"+area+"' and
Phone_Number= '"+phno+"'";
st=con.createStatement();
rs=st.executeQuery(query);
while(rs.next()) {
out.println(rs.getString(1));
out.println(rs.getString(2));
out.println(rs.getString(3));
out.println(rs.getString(4));
}
}catch(Exception e) {
System.out.println(e);
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
<form method='get' action='police'>
area:<input type='text' name='area'>
phno:<input type='text' name='phno'>
<input type='submit' name='submit'>
</form>
</body>
</html>
