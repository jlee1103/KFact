<%@ page language="java" contentType = "text/html; charset=UTF-8"
pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import ="example.jaemo.CategoryServlet" %>
<html>
<head>
<meta name="viewport"
	content="width=device-width,initial-scale=1,maximum-scale=1,minimum-scale=1,user-scalable=no" />
<meta charset="utf-8">
<title> J's Hair - About Us </title>
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
    <div class="content" align="center">
    <br />
		<table class="category" class="alignt" border="1" >
		
		<tr><td style="border-style:dotted" width="130" height="70"><a href="CategoryServlet?categoryID=ES"><font size="4">Electronic Shaver</font></a></td>
		
		<td style="border-style:dotted" width="130" height="70"><a href="CategoryServlet?categoryID=HS"><font size="4">Hand Shaver</font></a></td></tr>
		
		
		<tr><td style="border-style:dotted" width="130" height="70"><a href="CategoryServlet?categoryID=DO"><font size="4">Deodorant</font></a></td>
		
		<td style="border-style:dotted" width="130" height="70"><a href="CategoryServlet?categoryID=SC"><font size="4">Shaving Cream</font></a></td></tr>
		
		
		</table>
		<br/><br/>
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
