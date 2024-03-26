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
<title>Create Menu</title>
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
			<div class="col-md-5 offset-4">
				<div class="card ">
					<div class="card-body">
						<p class="fs-3 text-center text-black">Add Menu</p>

						<c:if test="${not empty successMsg }">
							<p class="text-center text-success fs-3">${successMsg}</p>
							<c:remove var="successMsg" scope="session" />
						</c:if>

						
						<c:if test="${not empty errorMsg }">
							<p class="text-center text-danger fs-3">${errorMsg}</p>
							<c:remove var="errorMsg" scope="session" />
						</c:if>
					
						<form action="../addMenu" method="post">
							<div class="mb-3">
								<label class="form-label">Food Name</label> <input
									name="foodName" type="text" placeholder="Enter food name"
									class="form-control">

							</div>
						

							<div class="mb-3">
								<label class="form-label">Price</label> <input
									name="price" type="text" placeholder="Enter price"
									class="form-control">

							</div>
							
							
							
							<div class="mb-3">
								<label class="form-label">Description</label> <textarea name="description"
									type="text" 
									class="form-control"></textarea>

							</div>
													

							<button type="submit" class="btn my-bg-color text-white col-md-12">Submit</button>
						</form>
					

					</div>

				</div>
			</div>
			
		</div>
	</div>









</body>
</html>