<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<div class="panel panel-default">
	<div class="panel-heading">
		<strong>
			<span class="glyphicon glyphicon-list"></span> User List
		</strong>
		<div class="pull-right">
			<a href="javascript:void(0);" onclick="addForm('user')">
				<span class="glyphicon glyphicon-plus-sign"></span> New User
			</a>
		</div>
	</div>
	<div class="panel-body">
		<table class="table table-bordered table-condensed table-hover table-striped">
			<thead>
				<tr>
					<th>Action</th>         
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					
				</tr>
			</thead>
			<tbody>
				 <c:forEach items="${users}" var="user">
   								<tr>
   								 <td align="center">
                              <a class="btn btn-default" ><em class="fa fa-pencil"></em></a>
                           
                              <a  class="btn btn-default" href="<c:url value='/admin/delete/${user.id}' />" class="btn btn-danger custom-width"><em class="fa fa-trash"></em></a> 	
                            </td>
   								 <td><c:out value="${user.firstName}"/></td>
   								 <td><c:out value="${user.lastName}"/></td>
   								 <td><c:out value="${user.email}"/></td>
   
 								  </tr>
  				</c:forEach>
			</tbody>
		</table>
	</div>
</div>