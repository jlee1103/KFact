package example.jaemo;

				
import java.io.IOException;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
public class MPServlet extends HttpServlet {


/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public void doGet(HttpServletRequest request, HttpServletResponse response) 
			           throws ServletException, IOException {

try

{
	System.out.println("SERVLET!");
	System.out.println(request.getParameter("search"));
	
	int search = Integer.parseInt(request.getParameter("search"));
	System.out.println(search);
    UserBean user = ProductDAO.user(search);

    	request.setAttribute("user", user);
    	request.setAttribute("userID", search);
    	RequestDispatcher rd= request.getRequestDispatcher("Mypage.jsp");
    	rd.forward(request, response);
    	 
		
		
}catch (Throwable theException) 	    
{
     System.out.println(theException); 
}
       }
	}

				