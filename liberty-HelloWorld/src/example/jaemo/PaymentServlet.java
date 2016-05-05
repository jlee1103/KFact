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
public class PaymentServlet extends HttpServlet {


/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public void doPost(HttpServletRequest request, HttpServletResponse response) 
			           throws ServletException, IOException {

try
{	    
	int pointer;
	if (	request.getParameter("itemID").equals("") ||
			request.getParameter("itemPrice").equals("") ||
			request.getParameter("cardNum").equals("") ||
			request.getParameter("cardName").equals("") ||
			request.getParameter("expMonth").equals("") ||
			request.getParameter("expYear").equals("") ||
			request.getParameter("security").equals("") ||
			request.getParameter("email").equals("") ||
			request.getParameter("phone").equals("") ||
			request.getParameter("billing").equals("") ||
			request.getParameter("bzip").equals("") ||
			request.getParameter("shipping").equals("") ||
			request.getParameter("szip").equals("") 	)
			{ 
		
				System.out.println ("wrong");
				pointer = 1;
			} else { 
	
	
	int userID = Integer.parseInt(request.getParameter("userID"));
	System.out.println(userID);
	int itemID = Integer.parseInt(request.getParameter("itemID"));
	System.out.println(itemID);
	int itemNum = Integer.parseInt(request.getParameter("itemNum"));
	System.out.println(itemNum);
	int itemPrice = Integer.parseInt(request.getParameter("itemPrice"));
	System.out.println(itemPrice);
	long card = Long.parseLong(request.getParameter("cardNum"));
	System.out.println(card);
	String cardName = request.getParameter("cardName");
	System.out.println(cardName);
	int expMonth = Integer.parseInt(request.getParameter("expMonth"));
	System.out.println(expMonth);
	int expYear = Integer.parseInt(request.getParameter("expYear"));
	System.out.println(expYear);
	int security = Integer.parseInt(request.getParameter("security"));
	System.out.println(security);
	String email = request.getParameter("email");
	System.out.println(email);
	String phone = request.getParameter("phone");
	System.out.println(phone);
	String billing = request.getParameter("billing");
	System.out.println(billing);
	int bzip = Integer.parseInt(request.getParameter("bzip"));
	System.out.println(bzip);
	String shipping = request.getParameter("shipping");
	System.out.println(shipping);
	int szip = Integer.parseInt(request.getParameter("szip"));
	System.out.println(szip);
	int totalPrice = itemPrice * itemNum;
	System.out.println(totalPrice);

	
	
	
	
	
	pointer = PaymentDAO.pay(itemID, totalPrice, card, cardName, expMonth, expYear, security, billing, bzip, shipping, szip, email, phone, userID, itemNum);
	
	request.setAttribute("pointer", pointer);
	RequestDispatcher rd= request.getRequestDispatcher("index.jsp");
	rd.forward(request, response);
	
			}
	
	

	
	

	

		
		
}catch (Throwable theException) 	    
{
     System.out.println(theException); 
}
       }
	}

				