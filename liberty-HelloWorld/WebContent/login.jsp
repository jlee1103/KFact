<%@ page language="java" contentType = "text/html; charset=UTF-8"
pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import ="example.jaemo.LoginServlet" %>

<html>

<% 

if (session.getAttribute("id")!=null) { 

	response.sendRedirect("index.jsp");

}

%>

<head>
    	<% if (request.getParameter("pointer") != null) { %>
    	<script> alert ("회원가이빙 완료되었습니다^^")</script>
    	<% } %>
<meta name="viewport"
	content="width=device-width,initial-scale=1,maximum-scale=1,minimum-scale=1,user-scalable=no" />
<title> J's Hair - Log In </title>
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
            <li><a href="login.jsp">Log In</a></li>
            <li><a href="contactus.jsp">Contact Us</a></li>
        </ul>
    </div>
    <div class="content">
   		<br />
   		<br />
   		<br />
    	<br />
    	<% if (request.getParameter("check") != null) { %>
    	<script> alert ("아이디 또는 패스워드가 틀립니다.")</script>
    	<% } %>
    	<font color="white">
        <form method="post" name="Form" action="LoginServlet">
        <p align="center"><font size = "4" color = "white"> Username: </font><input type="text" name="useremail" class = "pass" id="username"  /></p>
        <br />
        <p align="center"><font size = "4" color = "white"> Password: </font><input type="password" name="passwords" class = "pass" id="password" /></p>
        <br />
        <br />
        <p align="center"><input type="submit" onClick="return second()" name="submit" value="Log In" class="search" /> &nbsp; &nbsp; &nbsp; 
        <input type="button" value="Register" class="search" onclick="return first()" />
        </p>
        </form>
        </font>
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
	
	function first() {
		window.location="register.jsp";
	}
	
	function second() {
		var email = document.Form.useremail.value;
		var len= email.length;
		var password = document.Form.passwords.value;
		var len1 = password.length;
		var re = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;
		 if(len==0 || email==null){
		 alert("Enter Your ID Please!");
		 return false;
		 } else if (len1 == 0 || password == null) {
			 alert("Enter Your Password Please!");
			 return false;
		 } else if (!re.test(email)){
			 alert("Enter Your ID Correctly Please!")
			 return false;
		 } else {
			 var r = confirm("로그인 하시겠습니까?");
			 if (r == true) {
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

