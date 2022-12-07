// Write a java program that connects to a Department (Dept_ID, Name, Year_Established,
// Head_Name, No_of_Employees) database using JDBC and perform the following.
// i. Display details of all the Departments using Statement Object.
// ii. Display details of all the Departments which are established in the year 2000 using
// PreparedStatement object. Read the value from the user and display appropriate messages.
// iii. Display details of all the Departments by reading Dept_ID and Department Name from
// the user using PreparedStatement object.
// iv. Insert a new row using PreparedStatement object. Display the details.
import java.sql.*;
import java.util.Scanner;
public class proj2 {
public static void main(String[] args) {
Connection con=null;
Statement st=null;
ResultSet rs=null;
PreparedStatement ps=null;
String query;
Scanner sc=new Scanner(System.in);
try{
Class.forName("com.mysql.jdbc.Driver").newInstance();
con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","");
st=con.createStatement();
// i. Display details of all the Departments using Statement Object.
query="select * from Department";
System.out.println(query);
rs=st.executeQuery(query);
while(rs.next()){
System.out.print(rs.getInt("Dept_ID")+"\t");
System.out.print(rs.getString(2)+"\t");
System.out.print(rs.getInt(3)+"\t");
System.out.print(rs.getString(4)+"\t");
System.out.println(rs.getInt(5)+"\t");
}
System.out.println();
rs.close();
// ii. Display details of all the Departments which are established in the year 2000 using
PreparedStatement object.
// Read the value from the user and display appropriate messages.
query="select * from Department where Year_Established=2000";
System.out.println(query);
ps=con.prepareStatement(query);
rs=ps.executeQuery();
while(rs.next()){
System.out.print(rs.getInt("Dept_ID")+"\t");
System.out.print(rs.getString(2)+"\t");
System.out.print(rs.getInt(3)+"\t");
System.out.print(rs.getString(4)+"\t");
System.out.println(rs.getInt(5)+"\t");
}
System.out.println();
ps.close();
// iii. Display details of all the Departments by reading Dept_ID and Department Name
from the user using PreparedStatement object.
int dept_id=sc.nextInt();
sc.nextLine();
String dept_name=sc.nextLine();
query="select * from Department where Dept_ID=? and Name=?";
System.out.println(query);
ps=con.prepareStatement(query);
ps.setInt(1,dept_id);
ps.setString(2,dept_name);
rs=ps.executeQuery();
while(rs.next()){
System.out.print(rs.getInt("Dept_ID")+"\t");
System.out.print(rs.getString(2)+"\t");
System.out.print(rs.getInt(3)+"\t");
System.out.print(rs.getString(4)+"\t");
System.out.println(rs.getInt(5)+"\t");
}
System.out.println();
ps.close();
// iv. Insert a new row using PreparedStatement object. Display the details.
query="insert into Department values(003,'ISE', 2011,'DEF',30)";
ps=con.prepareStatement(query);
int count=ps.executeUpdate();
System.out.println("Updated "+count+" records");
}catch(ClassNotFoundException ce){
System.out.println(ce);
}
catch(SQLException se){
System.out.println(se);
}
catch(Exception e){
System.out.println(e);
} finally{
try{
if(con!=null) con.close();
if(rs!=null) rs.close();
if(st!=null) st.close();
if(ps!=null) ps.close();
}
catch(SQLException see){
System.out.println(see);
}}}
}