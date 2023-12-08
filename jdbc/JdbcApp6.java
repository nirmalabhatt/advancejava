import java.sql.*;
import java.util.Scanner;
class JdbcApp6
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
               
                 PreparedStatement ps=conn.prepareStatement("Insert into allbooks values(?,?,?,?)");
 
                
                 Scanner kb=new Scanner(System.in);
                 String choice;
                 int count=0;
                 do
                {
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

	                ps.setInt( 1,bid);
             	                ps.setString(2,bname);
             	                ps.setDouble(3,amt);
                                ps.setString(4,subject);

                                int ans=ps.executeUpdate();
                                if(ans==1)
                                        count++;
                               System.out.println("Do you want to continue (yes/no) ?");
                               choice=kb.next();
                       }while(choice.equalsIgnoreCase("yes"));
                System.out.println("Total rec inserted:"+count);
                
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
             