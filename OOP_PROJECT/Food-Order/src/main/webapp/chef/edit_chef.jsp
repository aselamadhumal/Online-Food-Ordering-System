<%@page import="com.foms.entity.Chef"%>
<%@page import="com.foms.dao.ChefDAO"%>
<%@page import="java.util.List"%>
<%@page import="com.foms.db.DBConnection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%@page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Chef</title>
<%@include file="../component/allcss.jsp"%>

<style type="text/css">
.my-card {
	box-shadow: 0px 0px 10px 1px maroon;

}
</style>


</head>
<body>
	<%@include file="navbar.jsp"%>


	<div class="container-fluid p-3">
		<div class="row">
			<div class="col-md-4 offset-4">
				<div class="card ">
					<div class="card-body">
						<p class="fs-3 text-center text-black">Edit Chef Details</p>

						<c:if test="${not empty successMsg }">
							<p class="text-center text-success fs-3">${successMsg}</p>
							<c:remove var="successMsg" scope="session" />
						</c:if>

						<c:if test="${not empty errorMsg }">
							<p class="text-center text-danger fs-3">${errorMsg}</p>
							<c:remove var="errorMsg" scope="session" />
						</c:if>
				



						<%
						
														int id = Integer.parseInt(request.getParameter("id"));
														ChefDAO chefDAO = new ChefDAO(DBConnection.getConn());
														Chef chef = chefDAO.getChefById(id);
						%>

			
						
						<form action="../updateChef" method="post">
							<div class="mb-3">
								<label class="form-label">Full Name</label> <input
									name="fullName" type="text" placeholder="Enter full name"
									class="form-control" value="<%=chef.getFullName()%>">

							</div>
					


							<div class="mb-3">
								<label class="form-label">Email address</label> <input
									name="email" type="email" placeholder="Enter Email"
									class="form-control" value="<%=chef.getEmail()%>">

							</div>
								<div class="mb-3">
								<label class="form-label">Password</label> <input
									name="password" type="password" placeholder="Enter password"
									class="form-control" value="<%=chef.getPassword()%>">

							</div>
							<div class="mb-3">
								<label class="form-label">Phone</label> <input name="phone"
									type="text" placeholder="Enter mobile number"
									class="form-control" value="<%=chef.getPhone()%>">

							</div>
							<div class="mb-3">
								<label class="form-label">Category</label> 
								<select
									class="form-control" name="category" >
									<option disabled="disabled" selected="selected">---Select---</option>
									<option  value="Indian"  >Indian</option>
									<option  value="Italian"  >Italian</option>
									
								</select>
							</div>
							
							
							<div class="mb-3">
								<input name="id" type="hidden" class="form-control"
									value="<%=chef.getId()%>">
							</div>

							<button type="submit" class="btn my-bg-color text-white col-md-12">Update</button>
						</form>
					

					</div>

				</div>
			</div>

		</div>
	</div>









</body>
</html>
