package example.jaemo;

				
import java.io.IOException;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
public class MypageServlet extends HttpServlet {


/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public void doPost(HttpServletRequest request, HttpServletResponse response) 
			           throws ServletException, IOException {

try

{
	System.out.println("SERVLET!");
	HttpSession session = request.getSession(true);
	int userID = (Integer) session.getAttribute("id");
	System.out.println(userID);
	int search = Integer.parseInt(request.getParameter("search"));
	System.out.println(search);
    ArrayList<OrderBean> list = (ArrayList<OrderBean>) ProductDAO.order2(search);
	Iterator<OrderBean> itr = list.iterator();
	
    if (itr.hasNext())
    {
    	request.setAttribute("list", list);
    	request.setAttribute("userID", userID);
    	RequestDispatcher rd= request.getRequestDispatcher("MypageOrderDes.jsp");
    	rd.forward(request, response);
    	 
    } else {
    	request.setAttribute("list", list);
    	RequestDispatcher rd= request.getRequestDispatcher("MypageOrderDes.jsp");
    	rd.forward(request, response);

} 
		
		
}catch (Throwable theException) 	    
{
     System.out.println(theException); 
}
       }
	}

				