package example.jaemo;

public class UserBean {
	
	private int userID;
    private String userEmail;
    private String password;
    private String phone;
    private String username;
    public boolean valid;
	
	
    public int getUserID() {
       return userID;
	}
    
    public void setUserID(int newUserID) {
        userID = newUserID;
 			}
	
    public String getUserEmail() {
       return userEmail;
			}

    public void setUserEmail(String newUserEmail) {
       userEmail = newUserEmail;
			}
			

    public String getPassword() {
       return password;
	}

    public void setPassword(String newPassword) {
       password = newPassword;
	}
	
			
    public String getUserName() {
       return username;
			}

    public void setUserName(String newUserName) {
       username = newUserName;
			}
    
    public String getPhone() {
        return phone;
 			}

     public void setPhone(String newPhone) {
       phone = newPhone;
 			}


				
    public boolean isValid() {
       return valid;
	}

    public void setValid(boolean newValid) {
       valid = newValid;
	}	
}
