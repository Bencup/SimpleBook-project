<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!-- content -->
<div class="container table-tapdown2">
	<form class="form-horizontal"
		action="${pageContext.request.contextPath}/editbook.html"
		method="post">
		<input type="hidden" value="${book.id}" name="id" /> <input
			type="hidden" value="${book.statusb.id}" name="statusb_id" />
		<fieldset class="col-lg-4 col-lg-offset-4">
			<legend>Edit Book</legend>

			<div class="form-group">
				<label for="book_name">book name</label>
				<div class="controls">
					<input type="text" class="form-control" value="${book.book_name}"
						id="book_name" name="book_name" required /> <label
						class="help-block help-inline"></label>
				</div>
			</div>

			<div class="form-group">
				<label for="name">book detail</label>
				<div class="controls">
					<input type="text" class="form-control" id="book_detail"
						value="${book.book_detail}" name="book_detail" required /> <label
						class="help-block help-inline"></label>
				</div>
			</div>
			<%-- <div class="form-group">
				<label for="book_year">book year</label>
				<div class="controls">
					<input type="text"  class="form-control" id="book_year" value="${book.book_year}" name="book_year" 
						 /> <label class="help-block help-inline"></label>
				</div>
			</div> --%>

			<div class="form-group">
				<label for="book_year">Book Year</label>
				<div>
					<span> <select class="form-control" id="book_year"
						name="book_year">
							<option value="${book.book_year}">${book.book_year}</option>
							<option value="2550">2550</option>
							<option value="2551">2551</option>
							<option value="2552">2552</option>
							<option value="2553">2553</option>
							<option value="2554">2554</option>
							<option value="2555">2555</option>
							<option value="2556">2556</option>
							<option value="2557">2557</option>
							<option value="2558">2558</option>
					</select>
					</span> <label class="help-block help-inline"></label>

				</div>
			</div>
			
			<div class="form-group">
				<label for="book_name">Author Name</label>
				<div class="controls">
					<input type="text" class="form-control" value="${book.author_name}"
						id="author_name" name="author_name" required /> <label
						class="help-block help-inline"></label>
				</div>
			</div>

			<%--  <div class="control-group">
				<label class="control-label" for="type_id">book Type</label>
				<div class="controls">
					<input type="text" id="type_id" value="${book.type.id}" name="type_id" class="span5"
						required /> <label class="help-block help-inline"></label>
				</div>
			</div>   --%>

			<div class="form-group">
				<label for="type_id">Book Type</label>
				<div>
					<select id="type_id" name="type_id" class="form-control">

						<c:forEach var="type" items="${typeList}">
							<option value="${type.id}">${type.name}</option>
						</c:forEach>
					</select><label class="help-block help-inline"></label>

				</div>
			</div>


			<div class="form-actions">
				<button class="btn btn-success" type="submit">Submit</button>
			</div>
		</fieldset>
	</form>
</div>
