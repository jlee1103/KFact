package example.jaemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 
public class ConnectionExample {
	
	private static ConnectionExample instance =new ConnectionExample();
	
	public static ConnectionExample getInstance(){
		return instance;
		}
	
    public int initDB(){
    	
    	
        String url="jdbc:db2://23.246.235.85:50000/I6398977";
        String user="sdeltrle";
        String password="htltjs1egztg";
        int x = 1;

        Connection connection = null;
        try {

            //Establish connection
            connection = DriverManager.getConnection(url, user, password);


        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            if(connection!=null){
            	x = 2;
                System.out.println("Connected successfully.");
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } else {
            	System.out.println("FAILED TO CONNECT");
            }
        }
        
        return x;
 
    }
 
}