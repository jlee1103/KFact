<%@ page language="java" contentType = "text/html; charset=UTF-8"
pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import ="example.jaemo.RegisterServlet" %>
<html>
<% 

if (session.getAttribute("id")!=null) { 

	response.sendRedirect("index.jsp");

}

%>
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
            <li><a href="login.jsp">LogIn</a></li>
            <li><a href="contactus.jsp">Contact Us</a></li>
        </ul>
    </div>
    <div class="content">
   		<br />
   		<br />
   		<br />
    	<br />
		
		<font color="white">
        <form name="Form" action="RegisterServlet">
        <p align="center"><font size = "4"> User Email (LogIn ID)<br/> </font><input type="text" name="email" class = "pass" /></p>
        <br />
        <p align="center"><font size = "4"> Password<br/> </font><input type="password" name="password" class = "pass"  /></p>
        <br />
        <p align="center"><font size = "4"> Username <br/> </font><input type="text" name="username" class = "pass"  /></p>
        <br />
        <p align="center"><font size = "4"> Phone Number <br/> </font><input type="text" name="phone" class = "pass"  /></p>
        <br />
        <br />
        <p align="center">
        	<input type="submit" name="submit" value="회원가입" onClick="return second()" class="search" id="pay" /> &nbsp; &nbsp; &nbsp; &nbsp;
        	<input type="button" value="취소" class="search" onclick="return redirect()"/>
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
	
	function redirect() {
		window.history.back(-1);
	}
	
	function second() {
		var email = document.Form.email.value;
		var password = document.Form.password.value;
		var username = document.Form.username.value;
		var phone = document.Form.phone.value;
		var re = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;
		
		 if( email.length==0 || email==null){
		 alert("Enter Email Address (Login ID) Please!");
		 return false;
		 } else if (password.length == 0 || password == null) {
			 alert("Enter Password Please!");
			 return false;
		 } else if (username.length == 0 || username == null){
			 alert("Enter Username Please!")
			 return false;
		 } else if (phone.length == 0 || phone == null) {
			 alert("Enter Phone Number Please!")
			 return false;
		 } else { 
			 if (!re.test(email)) { 
				 alert("Enter Your Email Address Correctly Please!");
				 return false;
			 } else {
				 var r = confirm("회원가입 하시겠습니까?");
				 if (r == true) {
				    } else {
					 return false;
				 }
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