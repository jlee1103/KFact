<%@ page language="java" contentType = "text/html; charset=UTF-8" 
pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import ="example.jaemo.UserBean" %>
<%@ page import="java.util.*" %>
<%@ page import ="example.jaemo.OrderServlet" %>
<%@ page import ="example.jaemo.MPServlet" %>


<html>
<% 

if (session.getAttribute("id")!=request.getAttribute("userID")) { 

	response.sendRedirect("index.jsp");

}

%>
<head>
<meta name="viewport"
	content="width=device-width,initial-scale=1,maximum-scale=1,minimum-scale=1,user-scalable=no" />
<title> J's Hair - Search Result </title>
<style>
img {display: block; max-height: 100%; width: auto;}
button {
	cursor:pointer;
	float:middle;
	padding:5px;
	-moz-border-radius:.3em;
	-webkit-border-radius:.3em;
	border-radius:.3em;
	margin:5px 10px 5px 0;
	border:none;
	color:#aaaaaa;
	border:2px solid #eeeeee;
	background:#ffffff;
	line-break: normal
}
</style>
<link href="css/style.css" rel="stylesheet" type="text/css"  />
<script src="http://ajax.googleapis.com/ajax/ligbs/jquery/1.6.4/jquery.min.js" type="text/javascript"></script>
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
	<p align="center"> <font color="white" size = "3">
	<% UserBean user = (UserBean) request.getAttribute("user"); %>
	<% out.print (user.getUserName()); %>님 안녕하세요~?
	<br /><br /><br />
	회원 이메일: <% out.print (user.getUserEmail()); %>
	<br /><br />
	회원 폰넘버: <% out.print (user.getPhone()); %>
	<br />	<br /></font></p>
	<form action="OrderServlet" method="post"> 
	
	<button type="submit"> 구매정보 조회 </button>
	<input type="hidden" name="userID" value="<%=session.getAttribute("id") %>"/> 
	</form>

<br />	<br />
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
