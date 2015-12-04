<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!-- content -->
<div class="container">
	<table class="table table-tapdown">
		<thead>
			<tr bgcolor="lightgreen">
				<td></td>
				<!-- <th scope="col">id</th> -->
				<th scope="col">First Name</th>
				<th scope="col">Last Name</th>
				<th scope="col">Username</th>
				<th scope="col">Status</th>
				<th scope="col"></th>
			</tr>
		</thead>
		<tbody>

			<c:forEach var="user" items="${userList}">
				<tr class="success">
					<td></td>
					<%-- <td>${user.id}</td> --%>
					<td>${user.firstname}</td>
					<td>${user.lastname}</td>
					<td>${user.username}</td>
					<td>${user.role.roleName}</td>


					<td class="u-center">
						<button class="btn btn-success ok "	data-toggle="modal" data-target="#show-${user.id }">show</button>
						
						<div id="show-${user.id }" class="modal fade" tabindex="-1">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal"
											aria-hidden="true">×</button>
										<h4 class="modal-title">Detail of User</h4>
									</div>
									<div class="modal-body">
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
									</div>
								</div>
							</div>
						</div> 
						
						<a	href="${pageContext.request.contextPath}/edit_pageuser.html?id=${user.id}"
							class="btn btn-primary btn-edit ok" data-id="${user.id}">edit	</a>
						<a href="javascript:void(0);" class="btn btn-danger btn-deleteuser ok" data-id="${user.id}">delete	</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
<!-- end of container -->
</div>

<!-- delete Button -->
<script type="text/javascript">
	$(function() {
		$(".btn-deleteuser").click(function() {
			if (confirm("***ARE YOU SURE TO DELETE***!!!")) {
				//alert($(this).data("id"));
				var userId = $(this).data("id");
				$(this).parent().parent().fadeOut('slow');

				$.ajax({
					url : "deleteuser.html",
					data : {
						id : userId
					},
					type : "POST",
					success : function(data) {
						if (data == "success") {
							//add effect
						} else {
							//add effect
						}

					}
				});
			}
		});
	});
</script>





