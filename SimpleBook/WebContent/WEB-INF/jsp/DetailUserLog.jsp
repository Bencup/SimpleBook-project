<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!-- content -->
<div class="container table-tapdown2">
	<fieldset class="col-lg-4 col-lg-offset-4">
		<div class="form-group">
			<label><h2>Detail of User Login</h2></label>
		</div>
		<div class="form-group">
			<label> FIRSTNAME : </label> ${userFirstName }
		</div>
		<div class="form-group">
			<label> LASTNAME : </label> ${userLastName}
		</div>
		<div class="form-group">
			<label> USERNAME : </label> ${username }
		</div>

		<a
			href="${pageContext.request.contextPath}/edit_pageuser.html?id=${userId}"
			class="btn btn-primary btn-edit" data-id="${userId}">edit</a>


	</fieldset>
</div>





