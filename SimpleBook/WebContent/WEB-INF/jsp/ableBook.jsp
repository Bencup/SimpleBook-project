<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!-- content -->
<div class="container">
	<table class="table table-tapdown">
		<thead>
			<tr bgcolor="skyblue">
				<th scope="col"></th>
				<th scope="col">Book name</th>
				
				<th scope="col">Book Year</th>
				<th scope="col">Book Type</th>
				<th scope="col"></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="book" items="${bookList}">
				<c:if test="${book.statusb.id==2 }">
					<tr class="success">
						<td>
							<%-- ${book.id} --%>
						</td>
						<td>${book.book_name}</td>
						<%-- <td> <textarea rows="1" cols="40" disabled=""
								class="form-control">${book.book_detail}</textarea></td> --%>
						<td>${book.book_year}</td>
						<td>${book.type.name}</td>
						<td class="u-center">
							<button class="btn btn-success ok" data-toggle="modal"
								data-target="#show-${book.id }">show</button>
							<div id="show-${book.id }" class="modal fade" tabindex="-1">
								<div class="modal-dialog">
									<div class="modal-content">
										<div class="modal-header">
											<button type="button" class="close" data-dismiss="modal"
												aria-hidden="true">×</button>
											<h4 class="modal-title">Detail</h4>
										</div>
										<div class="modal-body">
											<p>
											<div class="thumbnail">
												<img src="<c:url value="/img/ImgBook/Bimg-${book.id}.png"/>" />
											</div>
											<div class="form-group">
												<label>Book Name : </label> ${book.book_name}
											</div>
											<div class="form-group">
												<label>Book Detail : </label> ${book.book_detail}
											</div>
											<div class="form-group">
												<label>Book Year : </label> ${book.book_year}
											</div>

											<div class="form-group">
												<label>Book Type : </label> ${book.type.name}
											</div>
											</p>

										</div>
										<!-- <div class="modal-footer">
        <button class="btn btn-primary" data-dismiss="modal">Dismiss</button>
      </div> -->
									</div>
								</div>
							</div> <%-- <a
					href="${pageContext.request.contextPath}/showbook/${book.id}.html"
					class="btn btn-success ">show</a>  <a
					href="${pageContext.request.contextPath}/edit_pagebook.html?id=${book.id}"
					class="btn btn-primary btn-edit" data-id="${book.id}">edit</a> <a
					href="javascript:void(0);" class="btn btn-danger btn-deletebook"
					data-id="${book.id}">delete</a> --%> <c:if
								test="${book.statusb.id==2}">
								<a	href="${pageContext.request.contextPath }/createBorrow.html?id=${book.id}"
									class="btn btn-primary ok" data-id="${book.id}">Borrow</a>
							</c:if>
						</td>
					</tr>
				</c:if>
			</c:forEach>

		</tbody>
	</table>
</div>


<script type="text/javascript">
	$(function() {
		$(".btn-deletebook").click(function() {
			//alert($(this).data("id"));
			var bookId = $(this).data("id");
			$(this).parent().parent().fadeOut('slow');

			$.ajax({
				url : "deletebook.html",
				data : {
					id : bookId
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
		});
	});
</script>




