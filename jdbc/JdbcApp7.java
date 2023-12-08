import java.sql.*;
import java.util.Scanner;
class JdbcApp7
{
    public static void main(String [] args)
    {
      Connection conn=null;  
      try
        {
                Class.forName("oracle.jdbc.OracleDriver");
                System.out.println("Driver loaded successfully!");
                
                conn=DriverManager.getConnection("jdbc:oracle:thin:@//@//computername:1521/XE","dbusername","password");
                System.out.println("Connection opened successfully!");
               
                 PreparedStatement ps=conn.prepareStatement("Update allbooks set bookprice=bookprice+? where subject=?");
 
                
                 Scanner kb=new Scanner(System.in);
                 System.out.println("Enter bookprice:");
               	 double amt=kb.nextDouble();
	 System.out.println("Enter subject:");
             	 kb.nextLine();
	 String subject=kb.nextLine();
                 ps.setDouble(1,amt);
                 ps.setString(2,subject);
                 int ans=ps.executeUpdate();
                 if(ans>0)
                       System.out.println(ans+" records updated!");
                else
                      System.out.println("No books of subject "+subject+" found in the DB!");

                
     }
    catch(ClassNotFoundException cnfe)
    {
        System.out.println("Cannot load the driver class");
        
    }
    catch(SQLException ex)
   {
     System.out.println("Error in DB");
     ex.printStackTrace();       
   }
   finally
   {
	try
               {
                      if(conn!=null)
                   {
                      conn.close();
                      System.out.println("Connection closed successfully!");
                 }
              }
              catch(SQLException ex)
              {
                 System.out.println("Problem in closing the connection");
              }
   }
  }
}
             