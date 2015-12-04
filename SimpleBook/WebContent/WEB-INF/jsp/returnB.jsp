<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- content -->
<div class="container">
	<form class="form-horizontal" id="borrowform" name="borrowform"
		action="${pageContext.request.contextPath}/editBorrow.html"
		method="POST">
		<input type="hidden" value="${borrow.id}" name="id" />
		<fieldset class="col-lg-4 col-lg-offset-4">
			<div class="form-group">
				<label><h3>Confirm to Return Book</h3></label>
			</div>

			<input type="hidden" id="book_id" value="${borrow.book.id}"
				name="book_id" /> <input type="hidden"
				value="${borrow.date_borrow}" name="dateBorrow" /> <input
				type="hidden" value="${borrow.date_limit}" name="dateLimit" /> <input
				type="hidden" id="user_id" value="${borrow.user.id}" name="user_id" />
			<input type="hidden" id="statusb_id" name="statusb_id" value="2" />

			<!-- ***show detail of borrow*** -->
			<div class="form-group">
				<label class="control-label">BORROWER : </label>
				${borrow.user.firstname}

			</div>

			<div class="form-group">
				<label class="control-label">BOOK : </label>
				${borrow.book.book_name}

			</div>

			<div class="form-group">
				<label class="control-label">DATE BORROW : </label>
				${borrow.date_borrow}

			</div>

			<div class="form-group">
				<label class="control-label">DATE LIMIT : </label>
				${borrow.date_limit}

			</div>

			<div class="form-actions">
				<button class="btn btn-success" type="submit">CONFIRM</button>
			</div>

		</fieldset>
	</form>
</div>
