package example.jaemo;

				
import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
public class RegisterServlet extends HttpServlet {


/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public void doGet(HttpServletRequest request, HttpServletResponse response) 
			           throws ServletException, IOException {

try
{	    

	String email = request.getParameter("email");
	String password = request.getParameter("password");
	String username = request.getParameter("username");
	String phone = request.getParameter("phone");
	System.out.println(email);
	System.out.println(password);
	System.out.println(username);
	System.out.println(phone);


	if (email.equals("")) {

		System.out.println("Please enter email address");
	} else if (password.equals("")) {

		System.out.println("Please enter password");
	} else if (username.equals("")) {

		System.out.println("Please enter username");
	} else if (phone.equals("")) {

		System.out.println("Please enter phone number");
	} else { 

		RegisterDAO.insert(email, password, username, phone);
		System.out.println("Registration Success!");
		String pointer = "hola";
		request.setAttribute ("pointer", pointer);
		RequestDispatcher rd= request.getRequestDispatcher("login.jsp");
		rd.forward(request, response);
	}
	
}catch (Throwable theException) 	    
{
     System.out.println(theException); 
}
       }
	}

				