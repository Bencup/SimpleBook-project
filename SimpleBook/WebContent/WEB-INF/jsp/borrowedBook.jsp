<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- content -->
<div class="container">
	<table class="table table-tapdown">
		<thead>
			<tr bgcolor="skyblue">
				<td></td>
				<!-- <th scope="col">id</th> -->
				<th scope="col">Book</th>
				<th scope="col">Borrower</th>
				<th scope="col">Status</th>


				<th scope="col"></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="borrow" items="${borrowList}">
				<c:if test="${borrow.statusb.id==1 }">

					<tr class="success">
						<td></td>
						<td>${borrow.book.book_name}</td>
						<td>${borrow.user.firstname}</td>
						<td>${borrow.statusb.statusb_name }</td>
						<td><button class="btn btn-success ok" data-toggle="modal"
								data-target="#show-${borrow.id }">show</button>
							<div id="show-${borrow.id }" class="modal fade" tabindex="-1">
								<div class="modal-dialog">
									<div class="modal-content">
										<div class="modal-header">
											<button type="button" class="close" data-dismiss="modal"
												aria-hidden="true">×</button>
											<h4 class="modal-title">Detail of Borrow</h4>
										</div>
										<div class="modal-body">
											<p>
											<div class="form-group">
												<label>BORROWER : </label> ${borrow.user.firstname}
											</div>

											<div class="form-group">
												<label>BOOK : </label> ${borrow.book.book_name}
											</div>

											<div class="form-group">
												<label>DATE BORROW : </label> ${borrow.date_borrow}
											</div>

											<div class="form-group">
												<label>DATE LIMIT : </label> ${borrow.date_limit}
											</div>

											<div class="form-group">
												<label>DATE RETURN : </label> ${borrow.date_return}
											</div>
											</p>
										</div>
									</div>
								</div>
							</div></td>
					</tr>
				</c:if>
			</c:forEach>
		</tbody>
	</table>
</div>




