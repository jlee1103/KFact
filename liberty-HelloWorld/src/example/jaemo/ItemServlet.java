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
public class ItemServlet extends HttpServlet {


/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public void doGet(HttpServletRequest request, HttpServletResponse response) 
			           throws ServletException, IOException {

try
{	    

	System.out.println(request.getParameter("search"));
	String s = "ItemServlet?search=" + request.getParameter("search");
	
    ArrayList<ProductBean> list = (ArrayList<ProductBean>) ProductDAO.check(Integer.parseInt(request.getParameter("search")));
	Iterator<ProductBean> itr = list.iterator();
	
    if (itr.hasNext())
    {
    	 request.setAttribute("list", list);
         HttpSession session = request.getSession(true);
         session.setAttribute("history", s);
    	 RequestDispatcher rd= request.getRequestDispatcher("item.jsp");
    	 rd.forward(request, response);
    	 
    } else {
    	 request.setAttribute("list", list);
    	 RequestDispatcher rd= request.getRequestDispatcher("item.jsp");
    	 rd.forward(request, response);

} 
		
		
}catch (Throwable theException) 	    
{
     System.out.println(theException); 
}
       }
	}

				