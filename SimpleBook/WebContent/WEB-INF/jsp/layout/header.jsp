<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="navbar navbar-default  ">

	<div class="navbar-header ">
		<button type="button" class="navbar-toggle" data-toggle="collapse"
			data-target=".navbar-responsive-collapse ">
			<span class="icon-bar"></span> <span class="icon-bar"></span> <span
				class="icon-bar"></span>
		</button>
		<!-- <a class="navbar-brand " href="#" >Book Library</a> -->

		<a href="${pageContext.request.contextPath}/book.html" class="navbar-brand logo" >
			<!-- <img src="http://nextzy.me/wp-content/uploads/2015/04/nextzy_logo_large_white_transparent1.png" alt="Nextzy Technologies"> --> <img
			src="<c:url value="/img/ImgBook/Nextzy.png"/>" />
		</a>

	</div>

	<div
		class="navbar-collapse collapse navbar-responsive-collapse shadow-z-1 ">
		<ul class="nav navbar-nav">

			<sec:authorize access="isAuthenticated()">
				<!-- ***"authenticate" menu for user login// Anonymous() menu for everyone can see *** -->


				<sec:authorize access="hasAnyRole('ROLE_USER')">
					<li><a href="${pageContext.request.contextPath}/book.html">All
							Book</a></li>

					<li class="dropdown"><a href="bootstrap-elements.html"
						data-target="#" class="dropdown-toggle" data-toggle="dropdown">Categories
							Book <b class="caret"></b>
					</a>
						<ul class="dropdown-menu nav">
							<li><a
								href="${pageContext.request.contextPath}/programmingBook.html">Programming</a></li>
							<li><a
								href="${pageContext.request.contextPath}/technologyBook.html">Inspiration</a></li>
							<li><a
								href="${pageContext.request.contextPath}/margetingBook.html">Business</a></li>
							<li><a
								href="${pageContext.request.contextPath}/languageBook.html">Languages</a></li>
						</ul></li>

					<li><a href="${pageContext.request.contextPath}/ableBook.html">Borrow </a></li>
				</sec:authorize>


				<sec:authorize access="hasAnyRole('ROLE_ADMIN')">
					
					<li><a href="${pageContext.request.contextPath}/bookadmin.html">Book Management</a></li>
					
					<li><a href="${pageContext.request.contextPath}/user.html">User Management</a></li>
					<li><a
						href="${pageContext.request.contextPath}/createBook.html">Add
							Book to Library</a></li>

					<li class="dropdown"><a href="bootstrap-elements.html"
						data-target="#" class="dropdown-toggle active"
						data-toggle="dropdown">Borrow <b class="caret"></b>
					</a>
						<ul class="dropdown-menu ">
							<li><a href="${pageContext.request.contextPath}/borrow.html">All
									Borrow </a></li>
							<li><a
								href="${pageContext.request.contextPath}/ableBook.html">Book for can Borrow </a></li>
							<li><a
								href="${pageContext.request.contextPath}/borrowedBook.html">Borrowed
									Books</a></li>
						</ul></li>
				</sec:authorize>

				<li class="dropdown"><a href="bootstrap-elements.html"
					data-target="#" class="dropdown-toggle active"
					data-toggle="dropdown">Borrow of <sec:authentication
							property="principal.username" /> <b class="caret"></b>
				</a>
					<ul class="dropdown-menu ">
						<li><a
							href="${pageContext.request.contextPath}/borrowOfUser.html">
								history borrow of <sec:authentication
									property="principal.username" />
						</a></li>
						<li><a
							href="${pageContext.request.contextPath}/borrowOfUserReturn.html">
								Return book </a></li>
					</ul></li>

				<%-- <li><a
					href="${pageContext.request.contextPath}/borrowOfUser.html">Borrow
						of <sec:authentication property="principal.username" />
				</a></li> --%>

			</sec:authorize>

		</ul>


		<ul class="nav navbar-nav navbar-right">
			<sec:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_USER')">
				<a class="btn glyphicon glyphicon-user "
					href="${pageContext.request.contextPath}/DetailUserLog.html"> <sec:authentication
						property="principal.username" /></a>
				<a class="btn btn-success btnLogout"
					href="<c:url value="/j_spring_security_logout"/>">Logout</a>
				<a class="btn disabled" href="#"></a>
			</sec:authorize>

		</ul>
	</div>
</div>

<script>
	$(function() {
		function stripTrailingSlash(str) {
			if (str.substr(-1) == '/') {
				return str.substr(0, str.length - 1);
			}
			return str;
		}

		var url = window.location.pathname;
		var activePage = stripTrailingSlash(url);

		$('.nav li a').each(function() {
			var currentPage = stripTrailingSlash($(this).attr('href'));

			if (activePage == currentPage) {
				$(this).parent().addClass('active');
			}
		});
	});
</script>


