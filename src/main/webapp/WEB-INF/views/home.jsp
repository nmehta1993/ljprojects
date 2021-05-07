<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
<script type="text/javascript" src="<c:url value='/static/js/jquery.save.js' />"></script>
<script src="<c:url value='/static/js/jquery.min.js'/>"></script>

<%-- <script type="text/javascript" src="${path}/js/jquery.save.js"></script> --%>
<link rel="stylesheet" href="<c:url value='/static/css/toastr.min.css'/>">
<script type="text/javascript" src="<c:url value='/static/js/toastr.min.js'/>"></script>
<script type="text/javascript">
$(document).ready(function () {

	$("#submitUserForm").submit(function(e) {
		e.preventDefault();
		var frm = $("#submitUserForm");
		var data = {};
		$.each(this, function(i, v){
			var input = $(v);
			data[input.attr("name")] = input.val();
			delete data["undefined"];
		});
		saveRequestedData(frm, data, "user");
	});
	
	
	function saveRequestedData(frm, data, type) {
		alert("test");
		$.ajax({
			contentType:"application/json; charset=utf-8",
			type:frm.attr("method"),
			url:frm.attr("action"),
			dataType:'json',
			data:JSON.stringify(data),
			success:function(data) {
				alert("test");
				debugger;
				if(data.status == "success") {
					debugger;
					toastr.success(data.message, data.title, {
						closeButton:true
					});
					
				} else {
					toastr.error(data.message, data.title, {
						allowHtml:true,
						closeButton:true
					});
				}
			}
		});
	}
	
	
});


</script>
  <title>Home</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <!-- /<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script> -->
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <style>
    /* Remove the navbar's default margin-bottom and rounded borders */ 
    .navbar {
      margin-bottom: 0;
      border-radius: 0;
    }
    
    /* Add a gray background color and some padding to the footer */
    footer {
      background-color: #f2f2f2;
      padding: 25px;
    }
  </style>
</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="#">Portfolio</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href="#">Home</a></li>
        <li><a href="#">About</a></li>
        <li><a href="#">Gallery</a></li>
        <li><a href="#">Contact</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="/login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
        <li><a href="/registration"><span class="glyphicon glyphicon-log-in"></span>Registration</a></li>
      </ul>
    </div>
  </div>
</nav>
<img src="/static/imeges/abc.jpg">

<div class="jumbotron">
  <div class="container text-center">
    <h1>My Portfolio</h1>      
    <p>Some text that represents "Me"...</p>
  </div>
</div>
  
<div class="container-fluid bg-3 text-center">    
  <h3>Some of my Work</h3><br>
  <div class="row">
    <div class="col-sm-3">
      <p>Some text..</p>
      <img src="/static/assets/img/150x80.png" class="img-responsive" style="width:100%" alt="Image">
    </div>
    <div class="col-sm-3"> 
      <p>Some text..</p>
      <img src="/static/assets/img/150x80.png" class="img-responsive" style="width:100%" alt="Image">
    </div>
    <div class="col-sm-3"> 
      <p>Some text..</p>
      <img src="/static/assets/img/150x80.png" class="img-responsive" style="width:100%" alt="Image">
    </div>
    <div class="col-sm-3">
      <p>Some text..</p>
      <img src="/static/assets/img/150x80.png" class="img-responsive" style="width:100%" alt="Image">
    </div>
  </div>
</div><br>

<div class="container-fluid bg-3 text-center">    
  <div class="row">
    <div class="col-sm-3">
      <p>Some text..</p>
      <img src="/static/assets/img/150x80.png" class="img-responsive" style="width:100%" alt="Image">
    </div>
    <div class="col-sm-3"> 
      <p>Some text..</p>
      <img src="/static/assets/img/150x80.png" class="img-responsive" style="width:100%" alt="Image">
    </div>
    <div class="col-sm-3"> 
      <p>Some text..</p>
      <img src="/static/assets/img/150x80.png" class="img-responsive" style="width:100%" alt="Image">
    </div>
    <div class="col-sm-3">
      <p>Some text..</p>
      <img src="/static/assets/img/150x80.png" class="img-responsive" style="width:100%" alt="Image">
    </div>
  </div>
</div><br><br>

<footer class="container-fluid text-center">

<form name="employeeForm" id="submitUserForm"   commandName="subscribe"  action="/subscribe" method="post">

        <c:if test="${message != null}">
									<div class="alert alert-success">
										<strong>${message}</strong>
									</div>
								</c:if>
         <table cellpadding="0" cellspacing="0" border="1" class="GridOne">
            <tr>
               <td>Email</td>
               <td><input type="text" name="email" id="email" value=""></td>
            </tr>
            <tr>
               <td>Subscriber name</td>
               <td><input type="text" name="subscriberName" id="subscriberName" value=""></td>
            </tr>
            <tr>
               <td>Phone Number</td>
               <td><input type="text" name="phoneNumber" id="phoneNumber" value=""></td>
            </tr>
            <tr>
               <td colspan="2" align="center"><input type="submit" value="submit"  ></td>
            </tr>
         </table>
      </form>
  <p>Footer Text</p>
</footer>

</body>
</html>
