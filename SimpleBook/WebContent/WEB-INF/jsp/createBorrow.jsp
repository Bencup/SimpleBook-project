<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!-- content -->
<form class="form-horizontal table-tapdown2" action="saveborrow.html"
	method="post">
	<div class="container">
		<fieldset class="col-lg-4 col-lg-offset-4">
			<div class="form-group">
				<label><h3>Doing Borrow</h3></label>
			</div>

			<input type="hidden" id="statusb_id" name="statusb_id" value="1" />
			<input type="hidden" value="${book.id}" name="book_id" /> <input
				type="hidden" value="${userId}" name="user_id" />
			<%-- <input type="text" value="${bookname.book_name}" name="book_name" /> --%>

			<div class="form-group">

				<div class="thumbnail">
					<img src="<c:url value="/img/ImgBook/Bimg-${book.id}.png"/>" />
				</div>
				<label for="book_name"><u>BOOK NAME</u></label>
				<div class="controls">${bookname.book_name}</div>
			</div>

			<div class="form-group">
				<label for="name"><u>BORROWER</u></label>
				<div class="controls">${username}</div>
			</div>

			<div class="form-actions">
				<button class="btn btn-success" type="submit">Borrow</button>
			</div>
		</fieldset>
	</div>
</form>



