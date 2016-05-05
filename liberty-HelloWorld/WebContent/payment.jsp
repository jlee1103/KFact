<%@ page language="java" contentType = "text/html; charset=UTF-8"
pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import ="example.jaemo.PaymentServlet" %>
<html>
<head>
<meta name="viewport"
	content="width=device-width,initial-scale=1,maximum-scale=1,minimum-scale=1,user-scalable=no" />
<meta charset="utf-8">
<title> J's Hair - Payment </title>
<style>
img {display: block;max-width: 100%; height: auto;}
</style>
<link href="css/style.css" rel="stylesheet" type="text/css"  />
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.4/jquery.min.js" type="text/javascript"></script>
</head>
<body bgcolor="#5F5454">
    <div class="header">
        <div class="logo">
            <a href="index.jsp"><img src="images/loggo.jpg" width="100" height="70" alt="Stickers mobile template" /></a>
        </div>
        <button id="show">Menu <span>+</span> <span style="display:none;">-</span></button>
        <% if (session.getAttribute("id")!=null) {%>
        <button onclick="logout()">로그아웃</button>
        <% } %>
        <form name="Hola" action="ProductServlet">
        <button onclick="return hola()">검색</button>
        <input type="text" name="search" />
        </form>

        <div class="clear"></div>
    </div>
    <div class="nav">
        <ul>
            <li><a href="index.jsp">Home</a></li>
            <li><a href="aboutus.jsp">About Us</a></li>
            <li><a href="shopping.jsp">Shopping</a></li>
            <% if (session.getAttribute("id")==null) { %>
            <li><a href="login.jsp">Log In</a></li>
            <%}else { %>
            <li><a href="MPServlet?search=<%=session.getAttribute("id") %>">My Page</a></li>
            <% } %>
            <li><a href="contactus.jsp">Contact Us</a></li>
        </ul>
    </div>
    <div class="content">
   		<br />
   		<br />
   		<br />
    	<br />
    	<p align="center"><font size = "4" color = "white"> 총 금액: <%=request.getAttribute("totalPrice") %> </font></p> 
    	<br />
    	
    	
        <form name="Form" method="post" action="PaymentServlet">
        <p align="center"><font size = "4" color = "white"> Card Number<br/> </font><input type="text" name="cardNum" class = "pass" id="username" maxlength="16"/></p>
        <br />
        <p align="center"><font size = "4" color = "white"> Name on the Card<br/> </font><input type="text" name="cardName" class = "pass" id="password"  /></p>
        <br />
        <p align="center"><font size = "4" color = "white"> Expiration Date &nbsp;&nbsp; Security Code<br/> </font>
        <select class ="sel" name="expMonth">
        <option value="1" selected>1</option>
        <option value="2">2</option>
        <option value="3">3</option>
        <option value="4">4</option>
        <option value="5">5</option>
        <option value="6">6</option>
        <option value="7">7</option>
        <option value="8">8</option>
        <option value="9">9</option>
        <option value="10">10</option>
        <option value="11">11</option>
        <option value="12">12</option>
        </select> &nbsp;
        
        
        
        <select class ="sel" name="expYear">
        <option value="15" selected>15</option>
        <option value="16">16</option>
        <option value="17">17</option>
        <option value="18">18</option>
        <option value="19">19</option>
        <option value="20">20</option>
        <option value="21">21</option>
        <option value="22">22</option>
        <option value="23">23</option>
        <option value="24">24</option>
        <option value="25">25</option>
        <option value="26">26</option>
        <option value="27">27</option>
        <option value="28">28</option>
        <option value="29">29</option>
        <option value="30">30</option>
        </select>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <input type="text" class = "sec" id="sec-code" name="security" maxlength="3">
        
        <input type="hidden" name="itemID" value="<%=request.getParameter("itemID") %>">
        <input type="hidden" name="itemNum" value="<%=request.getParameter("itemNum") %>">
  		<input type="hidden" name="itemPrice" value="<%=request.getParameter("itemPrice") %>"> 
  		<input type="hidden" name="userID" value="<%=session.getAttribute("id") %>">   
        </p>
        <br />
        <p align="center"><font size = "4" color = "white"> Email Address <br/> </font><input type="text"  class = "pass" id="emailadd" name="email" /></p>
        <br />
        <p align="center"><font size = "4" color = "white"> Phone Number <br/> </font><input type="text"  class = "pass" id="phonenum" name="phone" /></p>
        <br />
        <p align="center"><font size = "4" color = "white"> Billing Address   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;   Zipcode <br/> 
        </font><input type="text" class = "pass" name="billing" />&nbsp;&nbsp;&nbsp;<input type="text" class = "passzip" name="bzip" maxlength="6"/></p>
 		<br />
        <p align="center"><font size = "4" color = "white"> Shipping Address   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;   Zipcode <br/> 
        </font><input type="text" class = "pass" name="shipping" />&nbsp;&nbsp;&nbsp;<input type="text" class = "passzip" name="szip" maxlength="6" /></p>
        <br />
        <br />
        <br />
        <p align="center">
        	<input type="submit" onclick="return second()" name="submit" value="결제" class="search" id="pay" /> &nbsp; &nbsp; &nbsp; &nbsp;
        	<input type="submit" name="cancel" value="취소" class="search" id="cancel" onclick="return redirect()"/>
        </p>
        </form>
        <br />
        <br />
        <br />
    </div>
<div class="footer">
    <p>&copy; 2015 <a href="KFact.mybluemix.net">KFact.mybluemix.net</a></p>
</div>
<script type="text/javascript">
	$('.nav').hide();
	$('#show').click(function (){
		$(".nav").toggle();
		$("span").toggle();
	});
	
	function logout() {
		var r = confirm("로그아웃 하시겠습니까?");
		if (r==true) {
			window.location="logout.jsp";
		} else {
			return false;
		}
	}
	
	function redirect() {
		var r = confirm("취소 하시겠습니까?");
		if (r==true) {
			window.history.back(-1);
		} else {
			return false;
		}
	}
	
	function second() {
		var cardNum = document.Form.cardNum.value;
		var cardName = document.Form.cardName.value;
		var security = document.Form.security.value;
		var email = document.Form.email.value;
		var phone = document.Form.phone.value;
		var billing = document.Form.billing.value;
		var bzip = document.Form.bzip.value;
		var shipping = document.Form.shipping.value;
		var szip = document.Form.szip.value;
		if (cardNum.length == 0 || cardName.length == 0 || security.length == 0 || email.length == 0
			|| phone.length == 0 || billing.length == 0 || bzip == 0 || shipping == 0 || szip == 0) {
			alert ("Please Fill out the Form!");
			return false;
		} else if (cardNum.indexOf("<") > -1 || email.indexOf("<") > -1 || billing.indexOf("<") > -1
				|| shipping.indexOf("<") > -1 || phone.indexOf("<") > -1 || cardName.indexOf("<") > -1) {
			alert ("Don't include special characters!");
			return false;
		} else {
			var r = confirm ("결제하시겠습니까?");
			if (r == true) {
				return true
			} else {
				return false;
			}
		}
	}
	
	
	function hola() {
		var search = document.Hola.search.value;
		if (search.length == 0 || search == null) {
			alert ("검색어를 입력하세요");
			return false;
		} else {
			
		}
	}
</script>

</body>
</html>
