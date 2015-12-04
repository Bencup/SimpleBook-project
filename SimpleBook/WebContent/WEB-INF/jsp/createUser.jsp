<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!-- content -->
<form class="form-horizontal" onsubmit="return checkForm(this);"
	action="saveuser.html" method="post">
	<div class="container">
		<fieldset class="col-lg-4 col-lg-offset-4">
			<div class="form-group">
				<label><h2>Register New Account</h2></label>
			</div>
			<input type="hidden" id="Enabled" name="Enabled" value="1" /> <input
				type="hidden" id="role_id" name="role_id" value="2" />

			<div class="form-group">
				<label for="firstname">FirstName</label>
				<div class="controls">
					<input type="text" class="form-control" id="firstname"
						name="firstname" required placeholder="first name" /> <label
						class="help-block help-inline"></label>
				</div>
			</div>

			<div class="form-group">
				<label for="lastname">Last Name</label>
				<div>
					<input type="text" class="form-control" id="lastname"
						name="lastname" required placeholder="last name" /> <label
						class="help-block help-inline"></label>
				</div>
			</div>


			<div class="form-group">
				<label for="username">User name</label>
				<div>
					<input type="text" class="form-control" id="username"
						name="username" required placeholder="user name" required /> <label
						class="help-block help-inline"></label>

				</div>
			</div>


			<div class="form-group">
				<label for="pass">Password</label> (least 4 characters, 10
				characters max)
				<div>
					<input type="password" id="password" placeholder="password"
						maxlength=10 minlength=4 class="text form-control" name="password"
						required /><label class="help-block help-inline"></label> <label
						for="c_pass">Confirm Password</label>
					<div>
						<input type="password" id="c_pass" class="text form-control"
							maxlength=10 minlength=4 name="your_c_pass"
							placeholder="confirm password" onblur="confirmPass()" required /><label
							class="help-block help-inline"></label>
					</div>
				</div>
			</div>

			<%-- 			<div class="form-group">
				<label for="role_id">Status</label>
				<div>
					<span> <select id="role_id" name="role_id"
						class="form-control">
							<option>---select Status---</option>
							<c:forEach var="role" items="${roleList}">
								<option value="${role.id }">${role.roleName }</option>
							</c:forEach>
					</select></span><label class="help-block help-inline"></label>

				</div>
			</div> --%>



			<div class="form-actions">
				<button class="btn btn-success" type="submit">register</button>
				<button class="btn btn-danger" type="reset">reset</button>
			</div>
		</fieldset>
	</div>
</form>


<script type="text/javascript">

  function checkForm(form)
  {
    if(form.username.value == "") {
      alert("Error: Username cannot be blank!");
      form.username.focus();
      return false;
    }
    re = /^\w+$/;
    if(!re.test(form.username.value)) {
      alert("Error: Username must contain only letters, numbers and underscores!");
      form.username.focus();
      return false;
    }

    if(form.password.value != "" && form.password.value == form.c_pass.value) {
      if(form.password.value.length < 6) {
        alert("Error: Password must contain at least six characters!");
        form.password.focus();
        return false;
      }
      if(form.password.value == form.username.value) {
        alert("Error: Password must be different from Username!");
        form.password.focus();
        return false;
      }
      re = /[0-9]/;
      if(!re.test(form.password.value)) {
        alert("Error: password must contain at least one number (0-9)!");
        form.password.focus();
        return false;
      }
      re = /[a-z]/;
      if(!re.test(form.password.value)) {
        alert("Error: password must contain at least one lowercase letter (a-z)!");
        form.password.focus();
        return false;
      }
      re = /[A-Z]/;
      if(!re.test(form.password.value)) {
        alert("Error: password must contain at least one uppercase letter (A-Z)!");
        form.password.focus();
        return false;
      }
      re = /^\w+$/;
      if(!re.test(form.password.value)) {
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



