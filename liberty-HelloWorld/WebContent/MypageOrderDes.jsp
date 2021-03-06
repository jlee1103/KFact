<%@ page language="java" contentType = "text/html; charset=UTF-8" 
pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import ="example.jaemo.OrderBean" %>
<%@ page import="java.util.*" %>
<%@ page import ="example.jaemo.MypageServlet" %>


<html>
<% 
if (session.getAttribute("id")!=request.getAttribute("userID")) { 

	response.sendRedirect("error.jsp");

}
%>
<head>
<meta name="viewport"
	content="width=device-width,initial-scale=1,maximum-scale=1,minimum-scale=1,user-scalable=no" />
<title> J's Hair - Search Result </title>
<style>

img {display: block; max-height: 100%; width: auto;}

table {
    border-width:3px;	
    border-style:double;
}
p.spacing {

	line-height: 200%;

}
</style>
<link href="css/style.css" rel="stylesheet" type="text/css"  />
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.4/jquery.min.js" type="text/javascript"></script>
</head>
<body bgcolor="#5F5454">
    <div class="header">
        <div class="logo">
            <a href="index.jsp"><img src="images/loggo.jpg" height="74" alt="Stickers mobile template" /></a>
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
    <div class="content" align="center">
    <br />
	<br />
	<%
	ArrayList<OrderBean> list =(ArrayList<OrderBean>) request.getAttribute("list");
	if (list.isEmpty()) {
		out.println ("No Result Found");
	} else { 
		Iterator itr = list.iterator();
		if (itr.hasNext()) {
			OrderBean product = (OrderBean) itr.next();
			%>
	
	
	<P align="left"><font color="#ffffff" size = "4"> View Order Details </font></P>
	<br/>
	

	<table  border="1"><tr>
	<td height="180" width="150"><p align="center"><p align="center"><font color="#ffffff">
	Order Date<br/><br/>
	Order Number<br/><br/>
	Order Total
	</font></p></td><td width="200"><p align="center"><font color="#ffffff">
	<%=product.getDate()%>
	<br/>
	<br/>
	<%=product.getItemNum()%>
	<br/>
	<br/>
	<%=product.getTotalPrice()%>원
	</font></p></td></tr></table>
	
	
	
	<br/><br/><br/>
	<P align="left"><font color="#ffffff" size = "4"> Item Information </font> </P>
	<br/>
	<table  border="1"><tr>
	<td height="167" width="150"><p align="center"><p align="center">
	<img src="productimg/<%=product.getItemID() %>.jpg" height="150">
	</p></td><td width="200"><p align="center"><font color="#ffffff">
	<%=product.getItemName()%>
	<br/><br/>
	<%=product.getItemEng()%>
	<br/><br/>
	<%=product.getItemNum()%>개 
	</font></p></td></tr></table>
	
	
	
	<br/><br/><br/>
	<P align="left"><font color="#ffffff" size = "4"> Payment and Shipping Information </font> </P>
	<br/>
	
	<table border="1"><tr><td height = "50" width = "350"><p class="spacing">
	<font color="#ffffff" size="3">Payment Method: </font>
	<br/>
	<font color="#ffffff">Card Number Ending in <% out.print(product.getCardNum()); %></font></p>
	</td></tr></table>
	
	<table border="1"><tr><td height = "50" width = "350"><p class="spacing">
	<font color="#ffffff" size = "3">Shipping Address:  </font>
	<br/>
	<font color="#ffffff"><%=product.getShipping()%></font></p>
	</td></tr></table>
	
			<%
		}
	}
	%>


<br/><br/><br/>
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
