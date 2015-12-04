<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- content -->
<div class="container">
	 	<p></p>	
	<div class="adv-table">
	<table
		class="display table table-bordered table-striped nowrap taptap"	cellspacing="0" width="100%" id="example">
		<thead>
			<tr>
				<th>Action</th>
				<th>name</th>
				<th>Year</th>
				<th>Type</th>
				<th>action</th>

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
										<span> Categories : </span> 
											<label id="categories"></label> 
										</div>
										</p>

									</div>
								</div>
							</div>
						</div>

	<a href="#" class="scrollToTop "></a>
</div><p></p><p></p><p></p><p></p><p></p><p></p><p></p><p></p>

<script type="text/javascript">
	
</script>

<script type="text/javascript">
var menu = {};

$(function(){
	 
	$(function() {
		$(".btn-deleteuser").click(function() {
			if (confirm("***ARE YOU SURE TO DELETE***!!!")) {
				//alert($(this).data("id"));
				var userId = $(this).data("id");
				$(this).parent().parent().fadeOut('slow');

				$.ajax({
					url : "deleteuser.html",
					data : {
						id : userId
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
			}
		});
	});

var showbooks = $('#example').DataTable( {
	ajax: contextPath + '/testshow.html',
	
	columns:[
	         {data: null,'width': '2%', 'orderable': false, render: function( data, type, full ) {
      	   		var str='';
  	    	   		str += '<div class="btn-group">'
  	    	   		str +=  '<button type="button" class="btn btn-success dropdown-toggle btn-sm" data-toggle="dropdown" aria-expanded="false" >Action <span class="caret"></span></button>'
  	    	   		str +=  '<ul class="dropdown-menu" role="menu">'
  	    	   		str +=  '<li data-id="1"><a href="#">Edit</a></li>'
  	    	   		str +=  '<li data-id="2"><a href="javascript:void(0)" class="btn-deletebook" data-id="${book.id}">delete</a></li>'							
  	    	   		str +=  '</ul>'
  	    	   		str +=  '</div>';
  	    	   		return str;
            }},
	         {data: "book_name",width: "5%"},
	         {data: "book_year",width: "5%"},
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

	$(function deleteBook() {	
			if (confirm("***ARE YOU SURE TO DELETE***!!!")) {
				//alert($(this).data("id"));
				var userId = $(this).data("id");
				$(this).parent().parent().fadeOut('slow');

				$.ajax({
					url : "deleteuser.html",
					data : {
						id : userId
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
			}
		
	})
	
	
	
	
    e.preventDefault();
    var data = showbooks.row($(this).parents('tr')).data();
    
    switch($(this).data('id')){
    case 1:
    	window.location.href = contextPath + "/edit_pagebook.html?id="+data.id;
    	break;
    case 2:
    	
    
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

<!-- back to the top -->
<script>
	$(document).ready(function() {

		//Check to see if the window is top if not then display button
		$(window).scroll(function() {
			if ($(this).scrollTop() > 1000) {
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



