package example.jaemo;

				
import java.io.IOException;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * Servlet implementation class LoginServlet
 */
public class OrderServlet extends HttpServlet {


/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public void doPost(HttpServletRequest request, HttpServletResponse response) 
			           throws ServletException, IOException {

try

{
	
	int userID = Integer.parseInt(request.getParameter("userID"));
	System.out.println(userID);

    ArrayList<OrderBean> list = (ArrayList<OrderBean>) ProductDAO.order(userID);
	Iterator<OrderBean> itr = list.iterator();

     if (itr.hasNext())
     {
    	 request.setAttribute("list", list);
    	 RequestDispatcher rd= request.getRequestDispatcher("MypageOrder.jsp");
    	 rd.forward(request, response);
    	 
     } else {
    	 request.setAttribute("list", list);
    	 RequestDispatcher rd= request.getRequestDispatcher("MypageOrder.jsp");
    	 rd.forward(request, response);

}
		
		
}catch (Throwable theException) 	    
{
     System.out.println(theException); 
}
       }
	}

				