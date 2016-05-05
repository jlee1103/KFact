package example.jaemo;

import java.sql.*;


public class ConnectionManager {

   static Connection con;
   static String url;
         
   public static Connection getConnection()
   {
     
      try
      {
         String url="jdbc:db2://23.246.235.85:50000/I6398977";
         String user="sdeltrle";
         String password="htltjs1egztg";

         Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
         
         try
         {            	
            con = DriverManager.getConnection(url, user, password); 
             								

              
         }
         
         catch (SQLException ex)
         {
            ex.printStackTrace();
         }
      }

      catch(ClassNotFoundException e)
      {
         System.out.println(e);
      }

   return con;
}
}