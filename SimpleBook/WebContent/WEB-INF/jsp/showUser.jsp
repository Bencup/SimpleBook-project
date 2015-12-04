<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<form class="form-horizontal" action="../edit.html" method="post">
	<div class="container">
		<fieldset class="col-lg-4 col-lg-offset-4">

			<div class="form-group">
				<label><h2>Show Detail of User</h2></label>
			</div>
			<div class="form-group">
				<label>FIRST NAME : </label> ${user.firstname}
			</div>
			<div class="form-group">
				<label>LAST NAME : </label> ${user.lastname}
			</div>
			<div class="form-group">
				<label>USER NAME : </label> ${user.username}
			</div>

			<div class="form-group">
				<label>STATUS : </label> ${user.role.roleName}
			</div>



		</fieldset>
	</div>
</form>