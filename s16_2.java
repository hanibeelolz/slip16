import java.sql.*;
import java.io.*;
class slip16
{
public static void main(String args[])
{
Connection con;
ResultSet rs1;
PreparedStatement pst1;
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

try
{
Class.forName("org.postgresql.Driver");
con=DriverManager.getConnection("jdbc:postgresql://localhost/stud","postgres","");
if(con==null)
{
System.out.println("Connection Failed....");
System.exit(1);
}
else
{
System.out.println("Connection Established...");

Statement stmt=con.createStatement();

String query="create table Teacher"+"(TNo int ,"+" TName varchar(20),"+" sal int,"+" desg varchar(20))";
stmt.executeUpdate(query);
System.out.println("given table created in database");

stmt.executeUpdate("insert into Teacher "+"values(1,'NRC',50000,'MCS')");
stmt.executeUpdate("insert into Teacher "+"values(2,'ABC',10000,'MCA')");
stmt.executeUpdate("insert into Teacher "+"values(3,'XYZ',40000,'MCA')");
stmt.executeUpdate("insert into Teacher "+"values(4,'PQR',20000,'MCS')");
System.out.println("Succesfully inserted in table....");

ResultSet rs=stmt.executeQuery("select * From Teacher");
System.out.println("TNo\t"+"TName\t"+"sal\t"+"desg");
while(rs.next())
{
System.out.println("\n"+rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3)+"\t"+rs.getString(4));
}

pst1=con.prepareStatement("select * from Teacher where TNo=?");
System.out.println("Enter Teacher Number of teacher to search the details:");
int t=Integer.parseInt(br.readLine());
 pst1.setInt(1,t);
 rs1=pst1.executeQuery();
  while(rs1.next())
   {
   System.out.println("\n");
   System.out.println(rs1.getInt(1));
   System.out.println(rs1.getString(2));
   System.out.println(rs1.getInt(3)+"\n");
   System.out.println(rs1.getString(4)+"\n");
   
   }

}
}
catch(Exception e)
{
System.out.println(e);
}
}
}

