<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="path" value="${pageContext.request.contextPath}" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<link rel="stylesheet"
	href="${path}/webjars/bootstrap/3.3.5/css/bootstrap.min.css">
<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
<style type="text/css">
body {
	background: url("/static/assets/img/bg.png") no-repeat center center
		fixed;
	background-size: cover;
	display: flex;
	align-items: center;
	height: 100vh;
}
</style>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<div class="panel panel-default">
					<div class="panel-heading">
						<strong> User Registration Form</strong>
					</div>
					<div class="panel-body">
						<c:url var="regUrl" value="/registration" />
						<form:form method="POST" modelAttribute="user" action="${regUrl}" class="form-signin form-horizontal">
						<form:input type="hidden" path="id" id="id"/>
						
							<div class="form-group">
								<div class="col-md-12">
									<div class="input-group input-group-md">
										<span class="input-group-addon"> <span
											class="glyphicon glyphicon-user"></span>
											</span> <form:input type="text" path="firstName" class="form-control" placeholder="Enter First Name"/>
									</div>
									<div class="has-error">
                           				 <form:errors path="firstName" class="help-inline"/>
                        			</div>
									
								</div>
							</div>
							<div class="form-group">
								<div class="col-md-12">
									<div class="input-group input-group-md">
										<span class="input-group-addon"> <span
											class="glyphicon glyphicon-user"></span>
										</span> <form:input type="text" path="lastName" class="form-control" placeholder="Enter Last Name"/>
									</div>
									<div class="has-error">
										<form:errors path="lastName" class="help-inline" />
									</div>
								</div>
							</div>
							<div class="form-group">
								<div class="col-md-12">
									<div class="input-group input-group-md">
										<span class="input-group-addon"> <span
											class="glyphicon glyphicon-user"></span>
										</span><form:input type="text" path="username" class="form-control" placeholder="Enter Username"/> 
									</div>
									<div class="has-error">
										<form:errors path="username" class="help-inline" />
									</div>
								</div>
							</div>

							<div class="form-group">
								<div class="col-md-12">
									<div class="input-group input-group-md">
										<span class="input-group-addon"> <span
											class="glyphicon glyphicon-lock"></span>
										</span><form:input type="password" path="password" class="form-control" placeholder="Enter password"/> 
									</div>
									<div class="has-error">
										<form:errors path="password" class="help-inline" />
									</div>
								</div>
							</div>


							<div class="form-group">
								<div class="col-md-12">
									<div class="input-group input-group-md">
										<span class="input-group-addon"> <span
											class="glyphicon glyphicon-user"></span>
										</span><form:input type="text" path="email" class="form-control" placeholder="Enter email"/> 
									</div>
									<div class="has-error">
										<form:errors path="email" class="help-inline" />
									</div>
								</div>
							</div>
							<div class="form-group">
								<div class="col-md-12">
									<label class="radio-inline"><form:radiobutton path="sex"  value="M"  checked="checked" />  Male
									</label> <label class="radio-inline"> <form:radiobutton  path="sex"  value="F"  checked="checked" />Female
									</label>
									<form:errors path="sex" class="control-label" />
								</div>
							</div>

						<input type="hidden" name="${_csrf.parameterName}" 	value="${_csrf.token}" />
							<div class="form-group">
								<div class="col-md-12">
									<button type="submit" value="Register"
										class="btn btn-default btn-block">
										<span class="glyphicon glyphicon-log-in"></span> Register
									</button>
								</div>
							</div>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>