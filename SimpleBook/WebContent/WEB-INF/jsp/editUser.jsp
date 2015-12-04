<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!-- content -->
<div class="container table-tapdown2">
	<form class="" onsubmit="return checkForm(this);"
		action="${pageContext.request.contextPath}/editUser.html"
		method="post">
		<input type="hidden" value="${user.id}" name="id" /> <input
			type="hidden" value="${user.role.id}" name="role_id" /> <input
			type="hidden" id="Enabled" name="Enabled" value="1" /> <input
			type="hidden" value="${user.username}" name="username" />
		<%-- <input type="hidden" value="${user.password}" name="password" /> --%>

		<fieldset class="col-lg-4 col-lg-offset-4">
			<legend>Edit User </legend>
			<div class="form-group">
				<label for="firstname">Firstname</label>
				<div>
					<input type="text" class="form-control" value="${user.firstname}"
						id="firstname" name="firstname" class="span5" required /> <label
						class="help-block help-inline"></label>
				</div>
			</div>

			<div class="form-group">
				<label for="lastname">Lastname</label>
				<div>
					<input type="text" class="form-control" id="lastname"
						value="${user.lastname}" name="lastname" class="span5" required />
					<label class="help-block help-inline"></label>
				</div>
			</div>
			<div class="form-group">
				<label for="username">Username</label>
				<div>
					<input type="text" class="form-control" disabled=""
						value="${user.username}" required /> <label
						class="help-block help-inline"></label>
				</div>
			</div>

			<div class="form-group">
				<label>New Password</label> (least 6 char, 10 char max, contain lest 1 lowwer and contain 1 upper letters)
				<div>
					<input type="password" id="password" placeholder="password"
						maxlength=10 minlength=4 class="text form-control" name="password"
						required /><label class="help-block help-inline"></label> <label>Confirm
						Password</label>
					<div>
						<input type="password" id="c_pass" class="text form-control"
							maxlength=10 minlength=4 name="your_c_pass"
							placeholder="confirm password" onblur="confirmPass()" required /><label
							class="help-block help-inline"></label>
					</div>
				</div>
			</div>


			<div class="form-actions">
				<button class="btn btn-success" type="submit">Submit</button>
			</div>
		</fieldset>
	</form>
</div>

<script type="text/javascript">
	function checkForm(form) {
		if (form.username.value == "") {
			alert("Error: Username cannot be blank!");
			form.username.focus();
			return false;
		}
		re = /^\w+$/;
		if (!re.test(form.username.value)) {
			alert("Error: Username must contain only letters, numbers and underscores!");
			form.username.focus();
			return false;
		}

		if (form.password.value != ""
				&& form.password.value == form.c_pass.value) {
			if (form.password.value.length < 6) {
				alert("Error: Password must contain at least six characters!");
				form.password.focus();
				return false;
			}
			if (form.password.value == form.username.value) {
				alert("Error: Password must be different from Username!");
				form.password.focus();
				return false;
			}
			re = /[0-9]/;
			if (!re.test(form.password.value)) {
				alert("Error: password must contain at least one number (0-9)!");
				form.password.focus();
				return false;
			}
			re = /[a-z]/;
			if (!re.test(form.password.value)) {
				alert("Error: password must contain at least one lowercase letter (a-z)!");
				form.password.focus();
				return false;
			}
			re = /[A-Z]/;
			if (!re.test(form.password.value)) {
				alert("Error: password must contain at least one uppercase letter (A-Z)!");
				form.password.focus();
				return false;
			}
			re = /^\w+$/;
			if (!re.test(form.password.value)) {
				alert("Error: password must contain only letters, numbers and underscores!");
				form.username.focus();
				return false;
			}
		} else {
			alert("Error: Please check that you've entered and confirmed your password!");
			form.password.focus();
			return false;
		}

		alert("You entered a valid password: " + form.password.value);
		return true;
	}
</script>