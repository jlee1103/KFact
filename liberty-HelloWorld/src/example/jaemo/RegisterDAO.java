package example.jaemo;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;

public class RegisterDAO 	
{	
	
   public static void insert(String email, String password, String username, String phone) throws NoSuchAlgorithmException {
	   
	   String url="jdbc:db2://75.126.155.153:50000/SQLDB";
       String user="user06068";
       String passwords="F7XQpN7XAzay";
       
       Connection connection = null;
       PreparedStatement preparedStatement = null;
       ResultSet resultSet = null;
       


       
       String sql = "Insert into USER (USERID, USEREMAIL, PASSWORDS, PHONE, USERNAME) values (NEXT VALUE FOR register_seq, ?, ?, ?, ?)";

       try {
       	connection = DriverManager.getConnection(url, user, passwords);
       	if (connection != null) {
       		System.out.println ("Connected to database");
       	}
       	preparedStatement = connection.prepareStatement(sql);

       	//DB 에서 값 조회
       	
       	preparedStatement.setString(1, email);
       	String pass = hash(password);
       	preparedStatement.setString(2, pass);
       	preparedStatement.setString(3, phone);
       	preparedStatement.setString(4, username);
       	System.out.println ("before");
       	preparedStatement.executeUpdate(); //요기 에러남 
        System.out.println ("after");
       	}catch (SQLException e) {
        	e.printStackTrace();
        } finally {
        	if (resultSet!=null){
        		try {
        			resultSet.close();
        		} catch (SQLException e) {
        			e.printStackTrace();
        		}
        	}
        	if (preparedStatement!=null) {
        		try {
        			preparedStatement.close();
        		} catch (SQLException e) {
        			e.printStackTrace();
        		}
        	}
        	if (connection!=null){
        		try {
        			connection.close();
        		} catch (SQLException e){
        			e.printStackTrace();
        		}
        	}
        }
	}
   
   
   public static String hash(String password) throws NoSuchAlgorithmException {
       MessageDigest md;
       String pass = password;
       String out = "";
       try {
           md= MessageDigest.getInstance("SHA-512");

           md.update(pass.getBytes());
           byte[] mb = md.digest();
           for (int i = 0; i < mb.length; i++) {
               byte temp = mb[i];
               String s = Integer.toHexString(new Byte(temp));
               while (s.length() < 2) {
                   s = "0" + s;
               }
               s = s.substring(s.length() - 2);
               out += s;
           }
           System.out.println(out.length());
           System.out.println("CRYPTO: " + out);

       } catch (NoSuchAlgorithmException e) {
           System.out.println("ERROR: " + e.getMessage());
       }
       return out;
   }
}