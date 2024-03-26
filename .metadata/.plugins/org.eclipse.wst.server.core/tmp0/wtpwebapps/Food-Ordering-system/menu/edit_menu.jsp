<%@page import="com.foms.entity.Menu"%>
<%@page import="com.foms.dao.MenuDAO"%>
<%@page import="java.util.List"%>
<%@page import="com.foms.db.DBConnection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- for jstl tag -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- end of jstl tag -->

<%@page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Menu</title>
<%@include file="../component/allcss.jsp"%>

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
	<%@include file="navbar.jsp"%>


	<div class="container-fluid p-3">
		<div class="row">
			<div class="col-md-4 offset-4">
				<div class="card ">
					<div class="card-body">
						<p class="fs-3 text-center text-black">Edit Menu Details</p>

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
														MenuDAO menuDAO = new MenuDAO(DBConnection.getConn());
														Menu menu = menuDAO.getMenuById(id);
						%>

				
						
						<form action="../updateMenu" method="post">
						
						<div class="mb-3">
								<label class="form-label">Food Name</label> <input
									name="foodName" type="text" placeholder="Enter food name"
									class="form-control" value="<%=menu.getFoodName()%>">

							</div>
						

							<div class="mb-3">
								<label class="form-label">Price</label> <input
									name="price" type="text" placeholder="Enter price"
									class="form-control" value="<%=menu.getPrice()%>">

							</div>
							
							<div class="mb-3">
								<label class="form-label">Description</label> <textarea name="description"
								
									class="form-control"><%=menu.getDescription()%></textarea>

							</div>
							
			
							<div class="mb-3">
								<input name="id" type="hidden" class="form-control"
									value="<%=menu.getId()%>">
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
