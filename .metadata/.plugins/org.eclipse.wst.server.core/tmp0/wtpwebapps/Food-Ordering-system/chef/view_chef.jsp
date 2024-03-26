<%@page import="com.foms.entity.Chef"%>
<%@page import="com.foms.dao.ChefDAO"%>
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
<title>Chef List</title>
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
			
			<div class="col-md-12">
				<div class="card ">
					<div class="card-body">
					
					
					<div class="row">
  <div class="col-md-12">
    <a href="chef.jsp" class="btn btn-primary" >Create Chef</a>
  </div>
</div>
					
					
					
						<p class="fs-3 text-center text-black">List of Chefs</p>

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
					

						<table class="table table-striped">
							<thead>
								<tr class="table-info">
								
									<th scope="col">Name</th>
									<th scope="col">Mobile</th>
									<th scope="col">Email</th>
									<th scope="col">Category</th>
									<th colspan="2" class="text-center" scope="col">Action</th>
								</tr>
							</thead>
							<tbody>

								<%
								ChefDAO chefDAO2 = new ChefDAO(DBConnection.getConn());
																				List<Chef> listOfChef = chefDAO2.getAllChefs();
																				for (Chef chefLst : listOfChef) {
								%>
								<tr>
									<%-- <th scope="row"><%= doctorLst.getId()%></th> --%>
									<th><%=chefLst.getFullName()%></th>
									<td><%=chefLst.getEmail()%></td>
									<td><%=chefLst.getPhone()%></td>
									<td><%=chefLst.getCategory()%></td>


									<td><a class="btn btn-sm btn-primary"
										href="edit_chef.jsp?id=<%=chefLst.getId()%>">Edit</a></td>
									<td><a class="btn btn-sm btn-danger" href="../deleteChef?id=<%= chefLst.getId() %>">Delete</a></td>



								</tr>
								<%
								}
								%>


							</tbody>
						</table>

						<!-- end table for doctor list -->


					</div>

				</div>
			</div>
		</div>
	</div>









</body>
</html>