package example.jaemo;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;

public class UserDAO 	
{	
	
   public static UserBean login(UserBean bean) throws NoSuchAlgorithmException {
	   
	   String url="jdbc:db2://75.126.155.153:50000/SQLDB";
       String user="user06068";
       String password="F7XQpN7XAzay";
       
       Connection connection = null;
       PreparedStatement preparedStatement = null;
       ResultSet resultSet = null;
       
       String sql = "select * from USER where USEREMAIL = ?";
       String emailID = bean.getUserEmail();
       String passwords = hash(bean.getPassword());
       
       try {
       	connection = DriverManager.getConnection(url, user, password);
       	preparedStatement = connection.prepareStatement(sql);
       	//DB 에서 값 조회
       	preparedStatement.setString(1, emailID);
       	resultSet = preparedStatement.executeQuery();
       	if (resultSet.next()) {
       		if(passwords.equals(resultSet.getString("PASSWORDS"))){
       			System.out.println ("성송"); //성공
       			bean.setValid(true);
       			bean.setUserID(resultSet.getInt("USERID"));
       			bean.setUserName(resultSet.getString("USERNAME"));
       		} else { 
       			System.out.println ("패스 실패"); //패스워드 다름
       			bean.setValid(false);
       		}
       	} else {
       		System.out.println ("아이디 실패"); //아이디 없음
       		bean.setValid(false);
       	}        } catch (SQLException e) {
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
		return bean;
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


       } catch (NoSuchAlgorithmException e) {
           System.out.println("ERROR: " + e.getMessage());
       }
       return out;
   }
}