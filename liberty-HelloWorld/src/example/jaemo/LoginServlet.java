package example.jaemo;

				
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {


/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public void doPost(HttpServletRequest request, HttpServletResponse response) 
			           throws ServletException, IOException {

try
{	    

     UserBean user = new UserBean();
     user.setUserEmail(request.getParameter("useremail"));
     user.setPassword(request.getParameter("passwords"));

     user = UserDAO.login(user);
	 
     if (user.isValid())
     {
          HttpSession session = request.getSession(true);
          session.setAttribute("id", user.getUserID());
          session.setAttribute("user", user.getUserName());
          if (session.getAttribute("history") != null) {
        	  response.sendRedirect((String) session.getAttribute("history"));
          } else {
        	  
          
          response.sendRedirect("login.jsp"); //logged-in page      		
          }
     }
	      
     else {
    	  response.sendRedirect("login.jsp?check=2");
    } 

		
		
}catch (Throwable theException) 	    
{
     System.out.println(theException); 
}
       }
	}

				