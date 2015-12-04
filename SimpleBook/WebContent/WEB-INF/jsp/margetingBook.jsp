<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!-- content -->
<div class="container">
	<%-- <table class="table table-tapdown">
		<thead>
			<tr bgcolor="skyblue">
				<th scope="col">
					<!-- id -->
				</th>
				<th scope="col"class="u-center" >Book name</th>
				<th scope="col">Book Year</th>
				<th scope="col">Book Type</th>
				<th scope="col"></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="book" items="${bookList}">
				<tr class="success">
					<c:if test="${book.type.id==3 }">
						<td class="u-center" ><c:if test="${userId==1 }">

								<li class="dropdown"><a href="bootstrap-elements.html"
									data-target="#" class="dropdown-toggle" data-toggle="dropdown">Action<b
										class="caret"></b></a>
									<ul class="dropdown-menu">
										<li><a
											href="${pageContext.request.contextPath}/edit_pagebook.html?id=${book.id}"
											class="btn-edit" data-id="${book.id}">edit</a></li>
										<li><a href="javascript:void(0);" class="btn-deletebook"
											data-id="${book.id}">delete</a></li>
									</ul></li>
							</c:if></td>

						<td class="u-center" >${book.book_name}</td>
						<td><textarea rows="1" cols="40" disabled=""
								class="form-control">${book.book_detail}</textarea></td>
						<td>${book.book_year}</td>
						<td>${book.type.name}</td>

						<td>
							<a
						href="${pageContext.request.contextPath}/showbook/${book.id}.html"
						class="btn btn-success ">show</a> <a
						href="${pageContext.request.contextPath}/edit_pagebook.html?id=${book.id}"
						class="btn btn-primary btn-edit" data-id="${book.id}">edit</a> <a
						href="javascript:void(0);" class="btn btn-danger btn-deletebook"
						data-id="${book.id}">delete</a>

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
												<img
													src="<c:url value="/img/ImgBook/Bimg-${book.id }.png"/>" />
											</div>
											<div class="form-group">
												<label>Book Name : </label> ${book.book_name}
											</div>
											<div class="form-group">
												<label>Book Year : </label> ${book.book_detail}
											</div>
											<div class="form-group">
												<label>Book Year : </label> ${book.book_year}
											</div>

											<div class="form-group">
												<label>Categories : </label> ${book.type.name}
											</div>
											</p>

										</div>
									</div>
								</div>
							</div>
							<c:if test="${book.statusb.id==2}">
								<a
									href="${pageContext.request.contextPath }/createBorrow.html?id=${book.id}"
									class="btn btn-primary book" data-id="${book.id}">Borrow</a>
							</c:if>

						</td>
					</c:if>
				</tr>
			</c:forEach>

		</tbody>
	</table> --%>
	
	<div class="adv-table">
	<table
		class="display table table-bordered table-striped nowrap taptap"	cellspacing="0" width="100%" id="example">
		<thead>
			<tr>
				
				<th>Book Name</th>
				<th>Year</th>
				<th>Author Name</th>
				<th>Categories</th>
				<th>Action</th>

			</tr>
		</thead>
		<tbody>

		</tbody>

	</table>

</div>


						<div id="show" class="modal fade" tabindex="-1">
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
												<img id="imgBook" />
											</div>
										<div class="form-group">
										<span> Book Name : </span> 											<label id="bookName">Book Name : </label>
										</div>
										<div class="form-group">
										<span> Book Detail : </span> 	
											<label id="bookDetail"></label> 
										</div>
										<div class="form-group">
										<span> Book Year : </span> 
											<label id="year"></label> 
										</div>
										
										<div class="form-group">
										<span> Author Name : </span> 
											<label id="author"></label> 
										</div>

										<div class="form-group">
										<span> Categories : </span> 
											<label id="categories"></label> 
										</div>
										</p>

									</div>
								</div>
							</div>
						</div>
	<a href="#" class="scrollToTop "></a>
</div>

<script type="text/javascript" charset="utf-8">
var action = {};

$(function(){
	 
	action.onDeleteMenu = function(data){
		bootbo.confirm('Do you wate to delete this ?',function(result){
			if(result){
				waitingDialog.show();
				
				$.ajax({
					url : contextPath + '/deletebook.html'+data.id,
					type : 'POST',
					success : function(data) {
						waitingDialog.hide();
						menu.menuTable.ajax.reload();
					}
				});
			}
		});
		
	};

var showbooks = $('#example').DataTable( {
	ajax: contextPath + '/showBusiness.html',
	
	columns:[
	         
	         {data: "book_name",width: "8%"},
	         {data: "book_year",width: "3%"},
	         {data: "author_name",width: "5%"},
	         {data: "type.name",width: "5%"},
	         {data: null,'width' : '5%', 'orderable': false,render:function(data,type,full){
	        	 var str='';
	        	 str +=  '<a class="btn btn-success a-action" data-id="3" data-toggle="modal" data-target="#show" href="#">Show</a>'
	        	if(data.statusb.id==2){
	        	 str +=  '<a class="btn btn-primary a-action" data-id="4" href="#">Borrow</a>'
	        	}
	        	 return str;
	         }}
	         
	         ]
} );  

$('#example tbody').on('click', 'ul.dropdown-menu li', function (e) {
    e.preventDefault();
    var data = showbooks.row($(this).parents('tr')).data();
    
    switch($(this).data('id')){
    case 1:
    	window.location.href = contextPath + "/edit_pagebook.html?id="+data.id;
    	break;
    case 2:
    	window.location.href = contextPath + "/edit_pagebook.html?id="+data.id;
    	break;
    }
});

$('#example tbody').on('click', 'a.a-action', function (e) {
    e.preventDefault();
    console.log(e);
    var data = showbooks.row($(this).parents('tr')).data();
    console.log(data);
    
    switch($(this).data('id')){
    case 3:
    	$('#show #bookName').text(data.book_name);
        $('#show #bookDetail').text(data.book_detail);
        $('#show #year').text(data.book_year);
        $('#show #author').text(data.author_name);
        $('#show #categories').text(data.type.name);
        $('#show #imgBook').attr('src', "img/ImgBook/Bimg-"+data.id+".png");
    	$("#show").dialog();
    	break;
    case 4:
    	window.location.href = contextPath + "/createBorrow.html?id="+data.id;
    	break;
    }
});

});
</script>


<script type="text/javascript">
	$(function() {
		$(".btn-deletebook").click(function() {
			if (confirm("***ARE YOU SURE TO DELETE***!!!")) {
			
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
			});}
		});
	});
</script>

<script>
	$(document).ready(function() {

		//Check to see if the window is top if not then display button
		$(window).scroll(function() {
			if ($(this).scrollTop() > 100) {
				$('.scrollToTop').fadeIn();
			} else {
				$('.scrollToTop').fadeOut();
			}
		});

		//Click event to scroll to top
		$('.scrollToTop').click(function() {
			$('html, body').animate({
				scrollTop : 0
			}, 800);
			return false;
		});

	});
</script>




