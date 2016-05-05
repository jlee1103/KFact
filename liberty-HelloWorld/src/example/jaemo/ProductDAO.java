package example.jaemo;

import java.sql.*;
import java.util.*;

public class ProductDAO 	
{	
	
   public static List<ProductBean> check(String target) {
	   
	   String url="jdbc:db2://75.126.155.153:50000/SQLDB";
       String user="user06068";
       String password="F7XQpN7XAzay";
       
       Connection connection = null;
       PreparedStatement preparedStatement = null;
       ResultSet resultSet = null;
       
       String sql = "select * from PRODUCT where ITEMNAME like ? or ITEMENG like ?";
       List<ProductBean> list = new ArrayList<ProductBean>();

       try {
       	connection = DriverManager.getConnection(url, user, password);
       	preparedStatement = connection.prepareStatement(sql);
       	if (connection != null) {
       		System.out.println ("Connected to database");
       	}
       	//DB 에서 값 조회
       	
       	preparedStatement.setString(1, "%" + target + "%");
       	preparedStatement.setString(2, "%" + target + "%");
       	resultSet = preparedStatement.executeQuery();
       	while (resultSet.next()) {
       		ProductBean product = new ProductBean();
       		product.setItemID(resultSet.getString("ITEMID"));
       		product.setItemName(resultSet.getString("ITEMNAME"));
       		product.setItemEng(resultSet.getString("ITEMENG"));
       		product.setItemPrice(resultSet.getInt("ITEMPRICE"));
       		product.setItemDes(resultSet.getString("ITEMDES"));
       		product.setItemNumber(resultSet.getInt("ITEMNUMBER"));
       		product.setItemStat(resultSet.getString("ITEMSTAT"));
       		product.setItemCat(resultSet.getString("ITEMCAT"));
       		list.add(product);
       	}
        
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
		return list;
	}
   
   
   
public static List<ProductBean> check(Integer target) {
	   
	   String url="jdbc:db2://75.126.155.153:50000/SQLDB";
       String user="user06068";
       String password="F7XQpN7XAzay";
       
       Connection connection = null;
       PreparedStatement preparedStatement = null;
       ResultSet resultSet = null;
       
       String sql = "select * from PRODUCT where ITEMID=?";
       List<ProductBean> list = new ArrayList<ProductBean>();

       try {
       	connection = DriverManager.getConnection(url, user, password);
       	preparedStatement = connection.prepareStatement(sql);
       	if (connection != null) {
       		System.out.println ("Connected to database");
       	}
       	//DB 에서 값 조회
       	
       	preparedStatement.setInt(1, target);
       	resultSet = preparedStatement.executeQuery();
       	while (resultSet.next()) {
       		ProductBean product = new ProductBean();
       		product.setItemID(resultSet.getString("ITEMID"));
       		product.setItemName(resultSet.getString("ITEMNAME"));
       		product.setItemEng(resultSet.getString("ITEMENG"));
       		product.setItemPrice(resultSet.getInt("ITEMPRICE"));
       		product.setItemDes(resultSet.getString("ITEMDES"));
       		product.setItemNumber(resultSet.getInt("ITEMNUMBER"));
       		product.setItemStat(resultSet.getString("ITEMSTAT"));
       		product.setItemCat(resultSet.getString("ITEMCAT"));
       		list.add(product);
       	}
        
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
		return list;
	}




public static List<ProductBean> check2(String target) {
	   
	   String url="jdbc:db2://75.126.155.153:50000/SQLDB";
       String user="user06068";
       String password="F7XQpN7XAzay";
       
       Connection connection = null;
       PreparedStatement preparedStatement = null;
       ResultSet resultSet = null;
       
       String sql = "select * from PRODUCT where ITEMCAT=?";
       List<ProductBean> list = new ArrayList<ProductBean>();

       try {
       	connection = DriverManager.getConnection(url, user, password);
       	preparedStatement = connection.prepareStatement(sql);
       	if (connection != null) {
       		System.out.println ("Connected to database");
       	}
       	//DB 에서 값 조회
       	
       	preparedStatement.setString(1, target);
       	resultSet = preparedStatement.executeQuery();
       	while (resultSet.next()) {
       		ProductBean product = new ProductBean();
       		product.setItemID(resultSet.getString("ITEMID"));
       		product.setItemName(resultSet.getString("ITEMNAME"));
       		product.setItemEng(resultSet.getString("ITEMENG"));
       		product.setItemPrice(resultSet.getInt("ITEMPRICE"));
       		product.setItemDes(resultSet.getString("ITEMDES"));
       		product.setItemNumber(resultSet.getInt("ITEMNUMBER"));
       		product.setItemStat(resultSet.getString("ITEMSTAT"));
       		product.setItemCat(resultSet.getString("ITEMCAT"));
       		list.add(product);
       	}
        
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
		return list;
	}






public static List<OrderBean> order(int target) {
	   
	   String url="jdbc:db2://75.126.155.153:50000/SQLDB";
       String user="user06068";
       String password="F7XQpN7XAzay";
       
       Connection connection = null;
       PreparedStatement preparedStatement = null;
       ResultSet resultSet = null;
       
       String sql = "select * from ITEMORDER where USERID=?";
       
       String sql2 = "select * from PRODUCT where ITEMID=?";
       
       String sql3 = "select * from ITEMORDERDES where ORDERID=?";
       List<OrderBean> list = new ArrayList<OrderBean>();

       try {
       	connection = DriverManager.getConnection(url, user, password);
       	preparedStatement = connection.prepareStatement(sql);
       	PreparedStatement preparedStatement2 = connection.prepareStatement(sql2);
       	PreparedStatement preparedStatement3 = connection.prepareStatement(sql3);
       	
       	if (connection != null) {
       		System.out.println ("Connected to database");
       	}
       	//DB 에서 값 조회
       	
       	preparedStatement.setInt(1, target);
       	resultSet = preparedStatement.executeQuery();
       	
       	
       	
       	while (resultSet.next()) {
       		
       		OrderBean product = new OrderBean();
       		
       		System.out.println(resultSet.getInt("ORDERID"));
       		preparedStatement3.setInt(1, resultSet.getInt("ORDERID"));
       		
           	ResultSet resultSet3 = preparedStatement3.executeQuery();
           	resultSet3.next();
           	System.out.println(resultSet3.getInt("ITEMID"));
           	
           	
           	
       		preparedStatement2.setInt(1, resultSet3.getInt("ITEMID"));
       		
           	ResultSet resultSet2 = preparedStatement2.executeQuery();
           	resultSet2.next();
       		product.setItemID(resultSet3.getInt("ITEMID"));
       		product.setDate(resultSet.getString("PURCHDATE"));

       		product.setShipping(resultSet.getString("SHIPPING"));
       		product.setItemNum(resultSet3.getInt("ITEMNUMBER"));
       		product.setOrderID(resultSet.getInt("ORDERID"));
       		product.setItemEng(resultSet2.getString("ITEMENG"));
       		product.setCardNum(resultSet.getLong("CARD"));
       		
       		product.setTotalPrice(resultSet3.getInt("ITEMPRICETOT"));
       		product.setItemName(resultSet2.getString("ITEMNAME"));

       		list.add(product);
       		
       		
       	}
   		preparedStatement2.close();
   		preparedStatement3.close();
   		resultSet.close();
       	} catch (SQLException e) {
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
		return list;
	}

public static List<OrderBean> order2(int target) {
	   
	   String url="jdbc:db2://75.126.155.153:50000/SQLDB";
       String user="user06068";
       String password="F7XQpN7XAzay";
    
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    
    String sql = "select * from ITEMORDER where ORDERID=?";
    
    String sql2 = "select * from PRODUCT where ITEMID=?";
    
    String sql3 = "select * from ITEMORDERDES where ORDERID=?";
    List<OrderBean> list = new ArrayList<OrderBean>();

    try {
    	connection = DriverManager.getConnection(url, user, password);
    	preparedStatement = connection.prepareStatement(sql);
    	PreparedStatement preparedStatement2 = connection.prepareStatement(sql2);
    	PreparedStatement preparedStatement3 = connection.prepareStatement(sql3);
    	
    	if (connection != null) {
    		System.out.println ("Connected to database");
    	}
    	//DB 에서 값 조회
    	
    	preparedStatement.setInt(1, target);
    	resultSet = preparedStatement.executeQuery();
    	
    	
    	
    	while (resultSet.next()) {
    		
    		OrderBean product = new OrderBean();
    		
    		System.out.println(resultSet.getInt("ORDERID"));
    		preparedStatement3.setInt(1, resultSet.getInt("ORDERID"));
    		
        	ResultSet resultSet3 = preparedStatement3.executeQuery();
        	resultSet3.next();
        	System.out.println(resultSet3.getInt("ITEMID"));
        	
        	
        	
    		preparedStatement2.setInt(1, resultSet3.getInt("ITEMID"));
    		
        	ResultSet resultSet2 = preparedStatement2.executeQuery();
        	resultSet2.next();
    		product.setItemID(resultSet3.getInt("ITEMID"));
    		product.setDate(resultSet.getString("PURCHDATE"));

    		product.setShipping(resultSet.getString("SHIPPING"));
    		product.setItemNum(resultSet3.getInt("ITEMNUMBER"));
    		product.setOrderID(resultSet.getInt("ORDERID"));
    		product.setItemEng(resultSet2.getString("ITEMENG"));
    		long x = resultSet.getLong("CARD");
    		x = x % 100000000 % 10000;
    		product.setCardNum(x);
    		
    		product.setTotalPrice(resultSet3.getInt("ITEMPRICETOT"));
    		product.setItemName(resultSet2.getString("ITEMNAME"));

    		list.add(product);
    		
    		
    	}
		preparedStatement2.close();
		preparedStatement3.close();
		resultSet.close();
    	} catch (SQLException e) {
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
		return list;
	}

public static UserBean user(int target) {
	   
	   String url="jdbc:db2://75.126.155.153:50000/SQLDB";
       String user="user06068";
       String password="F7XQpN7XAzay";
    
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    
    String sql = "select * from USER where USERID=?";
    UserBean result = new UserBean();

    try {
    	connection = DriverManager.getConnection(url, user, password);
    	preparedStatement = connection.prepareStatement(sql);
    	if (connection != null) {
    		System.out.println ("Connected to database");
    	}
    	//DB 에서 값 조회
    	
    	preparedStatement.setInt(1, target);
    	resultSet = preparedStatement.executeQuery();
    	
    	if(resultSet.next()){
    	result.setUserEmail(resultSet.getString("USEREMAIL"));
    	result.setPhone(resultSet.getString("PHONE"));
    	result.setUserName(resultSet.getString("USERNAME"));
    	}
    	return result; 
     
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
		return result;
	}
}