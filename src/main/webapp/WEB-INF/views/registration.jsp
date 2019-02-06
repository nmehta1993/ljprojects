<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
						<form method="POST" action="${regUrl}"
							class="form-signin form-horizontal">
							<div class="form-group">
								<div class="col-md-12">
									<div class="input-group input-group-md">
										<span class="input-group-addon"> <span
											class="glyphicon glyphicon-user"></span>
										</span> <input type="text" class="form-control" name="firstName" placeholder="Enter First Name" />
									</div>
								</div>
							</div>
							<div class="form-group">
								<div class="col-md-12">
									<div class="input-group input-group-md">
										<span class="input-group-addon"> <span
											class="glyphicon glyphicon-user"></span>
										</span> <input type="text" class="form-control" name="lastName" placeholder="Enter Last Name" />
									</div>
								</div>
							</div>
							<div class="form-group">
								<div class="col-md-12">
									<div class="input-group input-group-md">
										<span class="input-group-addon"> <span
											class="glyphicon glyphicon-user"></span>
										</span> <input type="text" class="form-control" name="username" placeholder="Enter User Name" />
									</div>
								</div>
							</div>

							<div class="form-group">
								<div class="col-md-12">
									<div class="input-group input-group-md">
										<span class="input-group-addon"> <span
											class="glyphicon glyphicon-lock"></span>
										</span> <input type="password" class="form-control" name="password" placeholder="Enter Password" />
									</div>
								</div>
							</div>


							<div class="form-group">
								<div class="col-md-12">
									<div class="input-group input-group-md">
										<span class="input-group-addon"> <span
											class="glyphicon glyphicon-user"></span>
										</span> <input type="text" class="form-control" name="email" 		placeholder="Enter Email" />
									</div>
								</div>
							</div>
							<div class="form-group">
								<div class="col-md-12">
									<label class="radio-inline"> <input type="radio" name="sex" value="M" checked="checked">Male
									</label> <label class="radio-inline"> <input type="radio" name="sex" value="F" checked="checked">Female
									</label>
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
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>