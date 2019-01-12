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