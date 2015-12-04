<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<form class="form-horizontal" action="../edit.html" method="post">
	<div class="container">
		<fieldset class="col-lg-4 col-lg-offset-4">

			<div class="form-group">
				<label><h3>Show Detail of Book</h3></label>
			</div>
			<div class="thumbnail">
				<img src="<c:url value="/img/android.png"/>" />
			</div>

			<div class="form-group">
				<label>BOOK NAME : </label> ${book.book_name}
			</div>
			<div class="form-group">
				<label>BOOK DETAIL : </label> ${book.book_detail}
			</div>
			<div class="form-group">
				<label>BOOK YEAR : </label> ${book.book_year}
			</div>

			<div class="form-group">
				<label>BOOK TYPE : </label> ${book.type.name}
			</div>


		</fieldset>
	</div>
</form>