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
public class ProductServlet extends HttpServlet {


/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public void doGet(HttpServletRequest request, HttpServletResponse response) 
			           throws ServletException, IOException {

try

{
	request.setCharacterEncoding("UTF-8"); 
	System.out.println(request.getParameter("search"));

    ArrayList<ProductBean> list = (ArrayList<ProductBean>) ProductDAO.check(request.getParameter("search"));
	Iterator<ProductBean> itr = list.iterator();
	
	int x = list.size() / 5;
	if (x * 5 < list.size()){
		x = x + 1;
	}
	
	
    if (itr.hasNext())
    {
    	request.setAttribute("list", list);
    	request.setAttribute("page", x);
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

				