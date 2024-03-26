<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	<%@page import="com.foms.entity.User"%>
<%@page import="com.foms.dao.UserDAO"%>
<%@page import="java.util.List"%>
<%@page import="com.foms.db.DBConnection"%>

<!-- for jstl tag -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- end of jstl tag -->

<%@page isELIgnored="false"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit User</title>
<!-- boostrap css -->
<%@include file="component/allcss.jsp"%>
<!-- end of boostrap css -->

<!-- customs css for this page -->
<style type="text/css">
.my-card {
	box-shadow: 0px 0px 10px 1px maroon;
	/*box-shadow: 0px 0px 10px 0px rgba(0,0,0,0.3);*/
}
</style>
<!-- end of customs css for this page -->

</head>
<body>
	<!-- navbar -->
	<%@include file="component/navbar.jsp"%>
	<!-- end navbar -->

	<!-- User Register -->
	<div class="container p-5">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card my-card">
					<div class="card-header text-center text-white my-bg-color">
						<!-- <p class="fs-4 text-center mt-1"><i class="fa-solid fa-users"></i> <br>User Login</p> -->
						<p class="fs-4 text-center text-white mt-2">
							<i class="fa fa-user-plus"></i> Edit User
						</p>
					</div>
					<div class="card-body">
						<!-- <p class="fs-4 text-center">User Register</p> -->

						<!-- message print -->
						<!-- for success msg -->
						<c:if test="${not empty successMsg }">
							<p class="text-center text-success fs-3">${successMsg}</p>
							<c:remove var="successMsg" scope="session" />
						</c:if>

						<!-- for error msg -->
						<c:if test="${not empty errorMsg }">
							<p class="text-center text-danger fs-3">${errorMsg}</p>
							<c:remove var="errorMsg" scope="session" />
						</c:if>
						<!-- End of message print -->
						
						<%
					
														int id = Integer.parseInt(request.getParameter("id"));
														UserDAO userDAO = new UserDAO(DBConnection.getConn());
														User user = userDAO.getUserById(id);
						%>

						<!-- boostrap form -->
						<form action="updateUser" method="post">
							<div class="mb-3">
								<label class="form-label">Full Name</label> <input
									name="fullName" type="text" placeholder="Enter full name"
									class="form-control" value="<%=user.getFullName()%>">

							</div>
							<div class="mb-3">
								<label class="form-label">Email address</label> <input
									name="email" type="email" placeholder="Enter Email"
									class="form-control" value="<%=user.getEmail()%>">
							</div>
							<div class="mb-3">
								<label class="form-label">Password</label> <input
									name="password" type="password" placeholder="Enter password"
									class="form-control" value="<%=user.getPassword()%>">
							</div>
							
							<div class="mb-3">
								<input name="id" type="hidden" class="form-control"
									value="<%=user.getId()%>">
							</div>

							<button type="submit" class="btn my-bg-color text-white col-md-12">Submit</button>
						</form>
						
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- End of User Register -->

</body>
</html>