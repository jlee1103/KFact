package example.jaemo;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;


public class login2 {
	
	private static login2 instance =new login2();
	
	public static login2 getInstance(){
		return instance;
		}
	
	
	public int checkUser(String emailID, String passwords) {
		
		//초기 파라미터 갑 가져와서 데이타베이스 연결 
        String url="jdbc:db2://23.246.235.85:50000/I6398977";
        String user="sdeltrle";
        String password="htltjs1egztg";
        
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        
        String sql = "select * from USER where USEREMAIL = ?";
        
        try {
        	connection = DriverManager.getConnection(url, user, password);
        	preparedStatement = connection.prepareStatement(sql);
        	//DB 에서 값 조회
        	preparedStatement.setString(1, emailID);
        	resultSet = preparedStatement.executeQuery();
        	if (resultSet.next()) {
        		System.out.println(resultSet.getString("PASSWORDS"));
        		System.out.println(passwords);
        		if(passwords.equals(resultSet.getString("PASSWORDS"))){
        			return 1; //성공
        		} else { 
        			return 2; //패스워드 다름
        		}
        	} else {
        		return 3; //아이디 없음
        	}
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
		return 3;
	}
}

























