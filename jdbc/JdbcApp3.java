import java.sql.*;
class JdbcApp3
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
                String qry="Insert into allbooks values(101,'Mastering Java',650,'JSE')";
                int count=st.executeUpdate(qry);
                if(count>0)
                 System.out.println("Rec inserted successfully:"+count);
               else
                 System.out.println("Cannot insert the rec");
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
             