<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<form class="form-horizontal" action="../edit.html" method="post">
	<div class="container">
		<fieldset class="col-lg-4 col-lg-offset-4">

			<div class="form-group">
				<label><h2>Show Detail of Borrow</h2></label>
			</div>
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


		</fieldset>
	</div>
</form>