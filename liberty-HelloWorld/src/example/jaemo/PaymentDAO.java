package example.jaemo;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

import javax.servlet.http.HttpSession;

public class PaymentDAO 	
{	
	
   public static int pay(int itemID, int totalPrice, long card, String cardName, int expMonth, int expYear, int security, String billing, int bzip, String shipping, int szip, String email, String phone, int userID, int itemNum) {
	   
	   String url="jdbc:db2://75.126.155.153:50000/SQLDB";
       String user="user06068";
       String password="F7XQpN7XAzay";
       
       Connection connection = null;
       
       String checkNum = "Select ITEMNUMBER from PRODUCT where ITEMID=?";
       String sql = "Insert into ITEMORDER (ORDERID, USERID, TOTALPRICE, PURCHDATE, CARD, CARDNAME, EXPMONTH, EXPYEAR, SECURITY, BILLING, BZIP, SHIPPING, SZIP, EMAIL, PHONE) values (NEXT VALUE FOR payment_seq, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
       String sql2 = "Insert into ITEMORDERDES (ORDERID, ITEMID, ITEMPRICETOT, ITEMNUMBER) values (payment_seq.CURRVAL, ?, ?, ?)";
       String sql3 = "Update Product set ITEMNUMBER=? where ITEMID=?";
       
       try {
       connection = DriverManager.getConnection(url, user, password);
       
       if (connection != null) {
       		System.out.println ("Connected to database");
       }
       
       PreparedStatement preparedStatement = connection.prepareStatement(checkNum);
       preparedStatement.setInt(1, itemID);
       ResultSet resultSet = preparedStatement.executeQuery();
       if (resultSet.next()) {
    	   int num = resultSet.getInt(1);
    	   preparedStatement.close();
    	   resultSet.close();
    	   System.out.println(num); //üũ
           if (num < itemNum) {
        	   return 1;
           } else {
        	   
        	    PreparedStatement preparedStatement4 = connection.prepareStatement(sql3);
	            preparedStatement4.setInt(1, num - itemNum);
	            preparedStatement4.setInt(2, itemID);
	    	    //put it in first and then put id as a curr value 
	    	    
	    	    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	            Date date = new Date();
              	
	            PreparedStatement preparedStatement2 = connection.prepareStatement(sql);
	            preparedStatement2.setInt(1, userID);
	            preparedStatement2.setInt(2, totalPrice);
	            preparedStatement2.setString(3, dateFormat.format(date));
	            preparedStatement2.setLong(4, card);
            	preparedStatement2.setString(5, cardName);
              	preparedStatement2.setInt(6, expMonth);
              	preparedStatement2.setInt(7, expYear);
              	preparedStatement2.setInt(8, security);
              	preparedStatement2.setString(9, billing);
              	preparedStatement2.setInt(10, bzip);
              	preparedStatement2.setString(11, shipping);
              	preparedStatement2.setInt(12, szip);
              	preparedStatement2.setString(13, email);
              	preparedStatement2.setString(14, phone);
        	   
              	PreparedStatement preparedStatement3 = connection.prepareStatement(sql2);
              	preparedStatement3.setInt(1, itemID);
              	preparedStatement3.setInt(2, totalPrice);
              	preparedStatement3.setInt(3, itemNum);
              	
              	
              	preparedStatement2.executeUpdate();
              	preparedStatement3.executeUpdate();
              	preparedStatement4.executeUpdate();
              	preparedStatement2.close();
              	preparedStatement3.close();
              	preparedStatement4.close();
              	
              	
              	System.out.println("Success");
              	
              	if (num - itemNum == 0) {
              		String update = "Update Product set ITEMSTAT=? where ITEMID=?";
              		PreparedStatement preparedStatement5 = connection.prepareStatement(update);
              		preparedStatement5.setString(1, "OUT");
              		preparedStatement5.setInt(2, itemID);
              		preparedStatement5.executeUpdate();
              		preparedStatement5.close();
              		
              	}
              	
              	
              	
              	
              	
              	
              	
              	
              	return 2;
              	
              	
    	   
    	    
       }}
        
       	}catch (SQLException e) {
        	e.printStackTrace();
        } finally {
        	if (connection!=null){
        		try {
        			connection.close();
        		} catch (SQLException e){
        			e.printStackTrace();
        		}
        	}
        }
	return 1;
	}
   
}