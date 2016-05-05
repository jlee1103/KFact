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
public class ProductServlet2 extends HttpServlet {


/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public void doGet(HttpServletRequest request, HttpServletResponse response) 
			           throws ServletException, IOException {

try
{	    


	System.out.println(request.getParameter("search"));
    ArrayList<ProductBean> list = (ArrayList<ProductBean>) ProductDAO.check(request.getParameter("search"));
	Iterator<ProductBean> itr = list.iterator();
	
	 
     if (itr.hasNext())
     {	 
    	 request.setAttribute("list", list);
    	 RequestDispatcher rd= request.getRequestDispatcher("search.jsp");
    	 rd.forward(request, response);
     } else {
    	 request.setAttribute("list", list);
    	 RequestDispatcher rd= request.getRequestDispatcher("search.jsp");
    	 rd.forward(request, response);

} 
		
		
}catch (Throwable theException) 	    
{
     System.out.println(theException); 
}
       }
	}

				