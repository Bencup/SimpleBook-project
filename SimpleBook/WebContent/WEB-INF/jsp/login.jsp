<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="container table-tapdown2">

	<div class="row">
		<div>
			<form class="form-horizontal"
				action='<c:url value='j_spring_security_check' />' method="POST">
				<fieldset class="col-lg-4 col-lg-offset-4">
					<div id="legend">
						<legend>Login</legend>
					</div>

					<div class="form-group">
						<label for="username">Username</label>
						<div>
							<input type="text" class="form-control" id="username"
								name="j_username" placeholder="username" class="input-xlarge">
						</div>
					</div>

					<div class="form-group">
						<label for="password">Password</label>
						<div>
							<input type="password" class="form-control" id="password"
								name="j_password" placeholder="password" class="input-xlarge">
						</div>
					</div>

					<div class="form-group">
						<label class="form-control"><a href="createUser.html">Sign
								Up</a></label>

					</div>

					<div class="form-group">
						<div>
							<button class="btn btn-success">Login</button>
						</div>
					</div>
				</fieldset>
			</form>
		</div>

	</div>
</div>

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





