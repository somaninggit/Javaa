// Write a java program that connects to the Employee (ID, FName. LName, Project, Salary)
// database using JDBC and perform the following operations.
// i. Display details of all the Employees.
// ii. Display details of all the employees who work for project “Web Development”.
// iii. Display the IDs of all those employee who have salary above 75,000/- and are in “Web
// Development”.
// iv. Display the total Number of employees who have salary less than 50,000/-.
import java.sql.*;
public class proj1 {
public static void main(String args[]){
Connection con=null;
Statement st=null;
ResultSet rs=null;
String query;
try{
Class.forName("com.mysql.jdbc.Driver").newInstance();
con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","");
st=con.createStatement();
// i. Display details of all the Employees.
query="select * from Employee";
System.out.println(query);
rs=st.executeQuery(query);
while(rs.next()){
System.out.print(rs.getString(1)+"\t");
System.out.print(rs.getString(2)+"\t");
System.out.print(rs.getString(3)+"\t");
System.out.print(rs.getString(4)+"\t");
System.out.println(rs.getInt(5)+"\t");
} rs.close();
System.out.println();
// ii. Display details of all the employees who work for project “Web Development”.
query="select * from Employee where project='Web Development'";
System.out.println(query);
rs=st.executeQuery(query);
while(rs.next()){
System.out.print(rs.getString(1)+"\t");
System.out.print(rs.getString(2)+"\t");
System.out.print(rs.getString(3)+"\t");
System.out.print(rs.getString(4)+"\t");
System.out.println(rs.getInt(5)+"\t");
} rs.close();
System.out.println();
// iii. Display the IDs of all those employee who have salary above 75,000/- and are in
“Web Development”.
query="select * from Employee where salary>75000 and project='Web Development'";
System.out.println(query);
rs=st.executeQuery(query);
while(rs.next()){
System.out.print(rs.getString(1)+"\t");
System.out.print(rs.getString(2)+"\t");
System.out.print(rs.getString(3)+"\t");
System.out.print(rs.getString(4)+"\t");
System.out.println(rs.getInt(5)+"\t");
}
System.out.println();
// iv. Display the total Number of employees who have salary less than 50,000/-.
query="select count(ID) from Employee where salary<50000";
System.out.println(query);
rs=st.executeQuery(query);
rs.next();
System.out.println("Total number of employees who have salary < 50000 are :
"+rs.getInt(1));
// int count=Integer.parseInt(rs);
}
catch(SQLException se){
System.out.println(se);
}
catch(Exception e){
System.out.println(e.getMessage());
} finally{
try{
if(con!=null) con.close();
if(rs!=null) rs.close();
if(st!=null) st.close();
}catch(SQLException se){
System.out.println(se);
}}
}
}