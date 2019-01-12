 <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Login page</title>
        <link href="<c:url value='/static/css/bootstrap.css' />"  rel="stylesheet"></link>
        <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
        <link rel="stylesheet" type="text/css" href="//cdnjs.cloudflare.com/ajax/libs/font-awesome/4.2.0/css/font-awesome.css" />
    </head>
 
    <body>
     <div id="mainWrapper">
            <div class="login-container">
                      <div class="login-form">
    
        <div class="well lead">User Registration Form</div>
        <form:form method="POST" modelAttribute="user" class="form-horizontal">
            <form:input type="hidden" path="id" id="id"/>
             
            <div class="row">
                <div class="form-group col-md-12">
                    <label class="col-md-3 control-lable" for="firstName">First Name</label>
                    <div class="col-md-7">
                        <form:input type="text" path="firstName" id="firstName" class="form-control input-sm"/>
                        <div class="has-error">
                            <form:errors path="firstName" class="help-inline"/>
                        </div>
                    </div>
                </div>
            </div>
     
            <div class="row">
                <div class="form-group col-md-12">
                    <label class="col-md-3 control-lable" for="lastName">Last Name</label>
                    <div class="col-md-7">
                        <form:input type="text" path="lastName" id="lastName" class="form-control input-sm" />
                        <div class="has-error">
                            <form:errors path="lastName" class="help-inline"/>
                        </div>
                    </div>
                </div>
            </div>
            
            <div class="row">
                <div class="form-group col-md-12">
                    <label class="col-md-3 control-lable" for="username">User Name</label>
                    <div class="col-md-7">
                        <form:input type="text" path="username" id="username" class="form-control input-sm" />
                        <div class="has-error">
                            <form:errors path="username" class="help-inline"/>
                        </div>
                    </div>
                </div>
            </div>
            
          
            <div class="row">
                <div class="form-group col-md-12">
                    <label class="col-md-3 control-lable" for="password">Password</label>
                    <div class="col-md-7">
                        <form:input type="password" path="password" id="password" class="form-control input-sm" />
                        <div class="has-error">
                            <form:errors path="password" class="help-inline"/>
                        </div>
                    </div>
                </div>
            </div>
     
            <div class="row">
                <div class="form-group col-md-12">
                    <label class="col-md-3 control-lable" for="email">Email</label>
                    <div class="col-md-7">
                        <form:input type="text" path="email" id="email" class="form-control input-sm" />
                        <div class="has-error">
                            <form:errors path="email" class="help-inline"/>
                        </div>
                    </div>
                </div>
            </div>

					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-3 control-lable" for="sex">sex</label>
							<div class="col-sm-7">
								<label class="radio-inline">
								 <form:radiobutton	path="sex" value="M" checked="checked" /> Male
								</label>
								 <label class="radio-inline"> <form:radiobutton	path="sex" value="F" /> Female
								</label> <br />
								<form:errors path="sex" class="control-label" />
							</div>

						</div>
					</div>



					<div class="row">
                <div class="form-actions floatRight">
                    <c:choose>
                        <c:when test="${edit}">
                            <input type="submit" value="Update" class="btn btn-primary btn-sm"/> or <a href="<c:url value='/login' />">Cancel</a>
                        </c:when>
                        <c:otherwise>
                            <input type="submit" value="Register" class="btn btn-primary btn-sm"/> or <a href="<c:url value='/login' />">Cancel</a>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
        </form:form>
    </div>
    </div>
    </div>
    
    
</body>
</html> 








<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Login</title>
		<link rel="stylesheet" href="${path}/webjars/bootstrap/3.3.5/css/bootstrap.min.css">
		<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
		<style type="text/css">
			body {
				background: url("http://quatangquangcao.net/wp-content/uploads/2016/02/AF-Client-Login-background-1024x682.png") no-repeat center center fixed;
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
							<strong>Register Your Account</strong>
						</div>
						<div class="panel-body">
						
							<form method="POST" modelAttribute="user"  class="form-signin form-horizontal">
							  <form:input type="hidden" path="id" id="id"/>
							<c:if test="${param.error != null}">
								<div class="alert alert-danger">
									<p>Invalid username and password.</p>
								</div>
							</c:if>
							<c:if test="${param.logout != null}">
                                <div class="alert alert-success">
                                    <p>You have been logged out successfully.</p>
                                </div>
                            </c:if>
								<div class="form-group">
									<div class="col-md-12">
										<div class="input-group input-group-md">
											<span class="input-group-addon">
												<span class="glyphicon glyphicon-user"></span>
											</span>
											<input type="text" class="form-control" name="firstName" placeholder="Enter First Name"/>
										</div>
									</div>
								</div>
								<div class="form-group">
									<div class="col-md-12">
										<div class="input-group input-group-md">
											<span class="input-group-addon">
												<span class="glyphicon glyphicon-user"></span>
											</span>
											<input type="text" class="form-control" name="lastName" placeholder="Enter Last Name"/>
										</div>
									</div>
								</div>
								<div class="form-group">
									<div class="col-md-12">
										<div class="input-group input-group-md">
											<span class="input-group-addon">
												<span class="glyphicon glyphicon-user"></span>
											</span>
											<input type="text" class="form-control" name="username" placeholder="Enter User Name"/>
										</div>
									</div>
								</div>
															
								<div class="form-group">
									<div class="col-md-12">
										<div class="input-group input-group-md">
											<span class="input-group-addon">
												<span class="glyphicon glyphicon-lock"></span>
											</span>
											<input type="password" class="form-control" name="password" placeholder="Enter Password" />
										</div>
									</div>
								</div>
								
								<div class="form-group">
									
									 <label class="radio-inline">
     										 <input type="radio" class="form-control" name="sex" value="M" checked="checked">Male
   								    </label>
   								    <label class="radio-inline">
     										 <input type="radio" class="form-control" name="sex" value="F" checked="checked">Female
   								    </label>
												
								</div>
								
								
								<div class="form-group">
									<div class="col-md-12">
										<button type="submit" value="Register" class="btn btn-default btn-block">
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
</html> --%>