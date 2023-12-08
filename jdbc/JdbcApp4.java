import java.sql.*;
import java.util.Scanner;
class JdbcApp4
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
                Statement st=conn.createStatement();
                
                 Scanner kb=new Scanner(System.in);
                 System.out.println("Enter bookid:");
                 int bid=kb.nextInt();
                 
                 System.out.println("Enter book name:");
                 kb.nextLine();
                 String bname=kb.nextLine();

               System.out.println("Enter bookprice:");
               double amt=kb.nextDouble();
	
              System.out.println("Enter subject:");
              kb.nextLine();
              String subject=kb.nextLine();

             String qry="Insert into allbooks values ("+bid+",'"+bname+"',"+amt+",'"+subject+"')";
             System.out.println(qry);
             int ans=st.executeUpdate(qry);
             if(ans>0)
                    System.out.println("Rec inserted:"+ans);
             else
                    System.out.println("Cannot insert the record");
                
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
             