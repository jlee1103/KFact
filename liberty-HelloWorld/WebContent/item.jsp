<%@ page language="java" contentType = "text/html; charset=UTF-8" 
pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import ="example.jaemo.ProductBean" %>
<%@ page import="java.util.*" %>
<%@ page import ="example.jaemo.ProductServlet" %>
<%@ page import ="example.jaemo.PurchaseServlet" %>
<html>
<head>

<meta name="viewport"
	content="width=device-width,initial-scale=1,maximum-scale=1,minimum-scale=1,user-scalable=no" />
<title> J's Hair - Payment </title>
<style>
input{ 
 text-align:center; 
}
img {display: block; max-height: 100%; width: auto;}


</style>
<link href="css/style.css" rel="stylesheet" type="text/css"  />
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.4/jquery.min.js" type="text/javascript"></script>
</head>
<body bgcolor="#5F5454" >
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
    <div class="content" align="center">
   		<br/>
   		<br/>
   		<% 
   		ArrayList<ProductBean> list =(ArrayList<ProductBean>) request.getAttribute("list");
   		ProductBean product = null;
   		if (!list.isEmpty()) {
   			Iterator itr = list.iterator();
   			product = (ProductBean) itr.next();
   		}
		%>
		<font color="white" size="3">
   		<table  border="1"><tr><td height="350" width="350"><p align="center"><img src="productimg/<%=product.getItemID() %>.jpg" height="340">  </p></td></tr>
   		<tr><td height="75" width="350"><p align="center"> <%=product.getItemName() %> </p></td></tr>
   		<tr><td height="75" width="350"><p align="center"> <%=product.getItemEng() %> </p></td></tr>
   		<tr><td height="250" width="350"><p align="center"> <%=product.getItemDes() %> </p></td></tr>
   		</table>
   		<br/>
   		<table class="alignt" style="font-size:14"><tr><td width = "120">개당판매가격:</td>
   		<td width = "150"><%=product.getItemPrice() %></td>
   		<td width = "50">원</td></tr>
   		<tr><td width = "120"> 수량:</td>
   		<td width = "150"> 
		

		<form name="Form" action="PurchaseServlet">
		<input type="number" value="1" width="50%" name="itemNum" /></td>
   		<td width = "50">개</td>
   		</tr></table>
   		<br/>
   		<br/>
   		<br/>

		<input type="hidden" name="userID" value="<%=session.getAttribute("id")%>">
		<input type="hidden" name="itemID" value="<%=product.getItemID() %>">
  		<input type="hidden" name="itemPrice" value="<%=product.getItemPrice() %>">  
        <input type="submit" name="submit" onClick="return second()" value="구매" class="search" id="buy" /> &nbsp; &nbsp; &nbsp;
        <input type="button" onclick="return first()" name="cancel" value="장바구니" class="search" id="cart"/>
		</form>
		</font>
		   		<br/>
   		<br/>
   		<br/>
    </div>

<script type="text/javascript">
	$('.nav').hide();
	$('#show').click(function (){
		$(".nav").toggle();
		$("span").toggle();
	});
	function first() {
		alert ("준비중입니다");
	}
	
	function second() {
		<% 

		if (session.getAttribute("id")==null) {
		%>
			var r = confirm("로그인이 필요합니다. 로그인 페이지로 이동하시겠습니까?");
			if (r == true) {
				window.location="login.jsp";
				return false;
			} else {
				return false;
			}
		<% }  %>
		var r = confirm("구매 하시겠습니까?");
		if (r==true) {
			document.forms["Form"].submit();
		} else {
			return false;
		}
		
	}
	
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
