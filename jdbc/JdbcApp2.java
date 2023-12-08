import java.sql.*;
class JdbcApp2
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
                ResultSet rs=st.executeQuery("Select ename,sal from emp");
                int total=0;
                int n=0;
                while(rs.next())
               {
                     String name=rs.getString(1);
                     int sal=rs.getInt(2);
                     System.out.println(name+"\t"+sal);
                    total=total+sal;
                    n++;
              }
             System.out.println("Avg sal is "+(float)total/n);
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
             