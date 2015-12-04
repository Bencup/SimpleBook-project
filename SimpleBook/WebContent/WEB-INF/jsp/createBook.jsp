<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<form class="form-horizontal table-tapdown2" action="savebook.html" enctype="multipart/form-data"
	method="post">
	<div class="inputs">
		<div class="container">
			<fieldset class="col-lg-4 col-lg-offset-4">
				<!-- ********** -->
				<div class="form-group">
					<label><h2>Add Book To Library</h2></label>
				</div>
				
				<label class="control-label">Upload Images</label>
					<input id="imgBook" name="imgBook" type="file" class="file" data-show-preview="false">

				<input type="hidden" id="statusb_id" name="statusb_id" value="2" />

				<div class="form-group">
					<label for="book_name">Book Name</label>
					<div>

						<input type="text" class="form-control" id="book_name"
							name="book_name" placeholder="Book Name"> <label
							class="help-block help-inline"></label>
					</div>
				</div>

				<div class="form-group">
					<label for="book_detail">Detail Book</label>
					<div>
						<!-- <input type="text" class="form-control" id="book_detail" name="book_detail" placeholder="Detail Book" /> -->
						<!-- <textarea class="form-control" id = "book_detail" name= "book_detail" placeholder="Detail Book"></textarea><label class="help-block help-inline"></label> -->
					</div>
				</div>

				<textarea class="form-control" rows="3" id="book_detail"
					name="book_detail" placeholder="Detail Book" required="required"></textarea>

				<div class="form-group">
					<label for="book_year">Book Year</label>
					<div>
						<span> <select class="form-control" id="book_year"
							name="book_year">
								<option>---Select YearBook---</option>
								<option value="2545">2545</option>
								<option value="2546">2546</option>
								<option value="2547">2547</option>
								<option value="2548">2548</option>
								<option value="2549">2549</option>
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
					<label for="type_id">Book Type</label>
					<div>
						<select id="type_id" name="type_id" class="form-control">
							<option>---Select TypeBook---</option>
							<c:forEach var="type" items="${typeList}">
								<option value="${type.id}">${type.name }</option>
							</c:forEach>
						</select><label class="help-block help-inline"></label>
					</div>
				</div>

				<div class="form-actions">
					<button class="btn btn-success" type="submit">Submit</button>
					<button class="btn btn-danger" type="reset">reset</button>
				</div>
			</fieldset>
		</div>
	</div>
</form>



