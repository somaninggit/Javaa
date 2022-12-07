// Write a java program that connects to the Movies (ID, Movie_Name, Genre, IMDB_Rating,
// Year) database using JDBC. Create an Updatable ResultSet and perform the following
// operations.
// i. Display details of all the Movies from the table.
// ii. Display details of 5th Movie from the table.
// iii. Insert a new row into the table using PreparedStatement and display all the details.
// iv. Delete a row from the table where the IMDB_Rating is less than 5.
// v. Update the Genre of a movie with ID as 10 to “Sci-fi”.
import java.sql.*;
public class proj3 {
public static void main(String[] args) {
Connection con=null;
PreparedStatement ps=null;
ResultSet rs=null;
String query;
int count;
try{
Class.forName("com.mysql.jdbc.Driver").newInstance();
con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","");
// i. Display details of all the Movies from the table.
query="select * from Movies";
System.out.println(query);
ps=con.prepareStatement(query);
rs=ps.executeQuery();
while(rs.next()){
System.out.print(rs.getInt(1));
System.out.print(rs.getString(2));
System.out.print(rs.getString(3));
System.out.print(rs.getInt(4));
System.out.println(rs.getString(5));
}
System.out.println();
ps.close();
rs.close();
// ii. Display details of 5th Movie from the table.
query="select * from Movies limit 1 offset 4";
System.out.println(query);
ps=con.prepareStatement(query);
rs=ps.executeQuery();
while(rs.next()){
System.out.print(rs.getInt(1));
System.out.print(rs.getString(2));
System.out.print(rs.getString(3));
System.out.print(rs.getInt(4));
System.out.println(rs.getString(5));
}
System.out.println();
// iii. Insert a new row into the table using PreparedStatement and display all the details.
query="insert into Movies values(11,'fgh','drama',8,2019)";
System.out.println(query);
ps=con.prepareStatement(query);
count=ps.executeUpdate();
System.out.println("Inserted "+count+" rows");
// iv. Delete a row from the table where the IMDB_Rating is less than 5.
query="delete from Movies where IMDB_Rating<5 limit 1";
System.out.println(query);
ps=con.prepareStatement(query);
count=ps.executeUpdate();
System.out.println("Deleted "+count+" rows");
// v. Update the Genre of a movie with ID as 10 to “Sci-fi”.
query="update Movies set Genre='Sci-fi' where ID=10";
System.out.println(query);
ps=con.prepareStatement(query);
count=ps.executeUpdate();
System.out.println("Updated "+count+" rows");
}catch(Exception e){
System.out.println(e);
} finally{
try{
if(con!=null) con.close();
if(ps!=null) ps.close();
if(rs!=null) rs.close();
}catch(SQLException se){
System.out.println(se);
}
}
}
}
