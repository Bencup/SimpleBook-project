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
				<th scope="col">Date Borrow</th>
				<th scope="col">Date Limit</th>
				<th scope="col">Return</th>
				<th scope="col">Status</th>
				<th scope="col">Fine</th>
				<th scope="col"></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="borrow" items="${borrowList}">
				<c:if test="${userId==borrow.user.id&&borrow.statusb.id==2}">
					<tr class="success">
						<td></td>
						<%-- <td>${borrow.id}</td> --%>
						<td>${borrow.book.book_name}</td>
						<td>${borrow.user.firstname}</td>
						<td>${borrow.date_borrow}</td>
						<td>${borrow.date_limit}</td>
						<td>${borrow.date_return}</td>
						<td>${borrow.statusb.statusb_name}</td>
						<td>${borrow.fine}</td>
						<td>

							<button class="btn btn-success ok" data-toggle="modal"
								data-target="#show-${borrow.id }">show</button>
							<div id="show-${borrow.id }" class="modal fade" tabindex="-1">
								<div class="modal-dialog">
									<div class="modal-content">
										<div class="modal-header">
											<button type="button" class="close" data-dismiss="modal"
												aria-hidden="true">×</button>
											<h4 class="modal-title">Detail of own borrowed</h4>
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
							</div> <%-- <a
					href="${pageContext.request.contextPath}/showBorrow/${borrow.id}.html"
					class="btn btn-primary ">show</a> --%> <c:if
								test="${userId==borrow.user.id && borrow.statusb.id==1}">
								<a
									href="${pageContext.request.contextPath}/returnB.html?id=${borrow.id}"
									class="btn btn-primary btn-edit ok" data-id="${borrow.id}">Return</a>
							</c:if>
						</td>
					</tr>
				</c:if>
			</c:forEach>
		</tbody>
	</table>
</div>





