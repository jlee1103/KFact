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
public class PurchaseServlet extends HttpServlet {


/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public void doGet(HttpServletRequest request, HttpServletResponse response) 
			           throws ServletException, IOException {

try
{	    

	System.out.println(request.getParameter("itemID"));
	

	
	System.out.println(request.getParameter("itemPrice"));
	System.out.println(request.getParameter("itemNum"));
	int itemNumber = Integer.parseInt(request.getParameter("itemNum"));
	int itemPrice = Integer.parseInt(request.getParameter("itemPrice"));
	int totalPrice = itemNumber * itemPrice;
	System.out.println(totalPrice);

	request.setAttribute("itemID", request.getParameter("product.itemID"));
	request.setAttribute("totalPrice", totalPrice);
	RequestDispatcher rd= request.getRequestDispatcher("payment.jsp");
	rd.forward(request, response);

		
		
}catch (Throwable theException) 	    
{
     System.out.println(theException); 
}
       }
	}

				