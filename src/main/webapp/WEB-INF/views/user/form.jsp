<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<script type="text/javascript" src="${path}/js/jquery.save.js"></script>
<div class="panel panel-default">
	<div class="panel-heading">
		<strong>
			<c:choose>
				<c:when test="${isNew}"><span class="glyphicon glyphicon-plus-sign"></span></c:when>
				<c:otherwise><span class="glyphicon glyphicon-edit"></span></c:otherwise>
			</c:choose> User
		</strong>
	</div>
	<form:form method="post" class="form-horizontal" action="/admin/add" commandName="userForm" id="submitUserForm">
		<form:hidden path="id"/>
		<div class="panel-body">
			<div class="form-group">
				<label class="col-md-2 control-label">First Name : </label>
				<div class="col-md-4">
					<form:input class="form-control" path="firstName" placeholder="Enter First Name" required="true"/>
				</div>
			</div>
			<div class="form-group">
				<label class="col-md-2 control-label">Last Name : </label>
				<div class="col-md-4">
					<form:input class="form-control" path="lastName" placeholder="Enter Last Name" required="true"/>
				</div>
				</div>
				<div class="form-group">
				<label class="col-md-2 control-label">Username : </label>
				<div class="col-md-4">
					<form:input class="form-control" path="username" placeholder="Enter User Name" required="true"/>
				</div>
			</div>
			<div class="form-group">
				<label class="col-md-2 control-label">Email : </label>
				<div class="col-md-4">
					<form:input class="form-control" path="email" placeholder="Enter Email" required="true"/>
				</div>
							
			</div>
			<div class="form-group">
				<label class="col-md-2 control-label">Role :</label>
				<div class="col-md-4">
					<form:select class="form-control" path="role">
						<c:forEach items="${roles}" var="role">
							<form:option value="${role.id}">${role.name}</form:option>
						</c:forEach>
					</form:select>
				</div>
			</div>
			
		</div>
		<div class="panel-footer">
			<form:button value="Save" class="btn btn-xs btn-default">
				<span class="glyphicon glyphicon-floppy-disk"></span>
				<c:choose>
					<c:when test="${isNew}"> Save</c:when>
					<c:otherwise> Update</c:otherwise>
				</c:choose>
			</form:button>
		</div>
	</form:form>
</div>