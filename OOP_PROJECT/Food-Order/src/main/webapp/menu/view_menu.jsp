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
<title>Menu List</title>
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
    <a href="add_menu.jsp" class="btn btn-primary" >Create Menu</a>
  </div>
</div>
					
					
					
						<p class="fs-3 text-center text-black">List of Menu</p>

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

						<!-- table for doctor list -->

						<table class="table table-striped">
							<thead>
								<tr class="table-info">
									<!-- <th scope="col">ID</th> -->
									<th scope="col">Food Name</th>
									<th scope="col">Price</th>
									<th scope="col">Description</th>
									<th colspan="2" class="text-center" scope="col">Action</th>
								</tr>
							</thead>
							<tbody>

								<%
								MenuDAO menuDAO2 = new MenuDAO(DBConnection.getConn());
																				List<Menu> listOfMenu = menuDAO2.getAllMenus();
																				for (Menu menuList : listOfMenu) {
								%>
								<tr>
									<%-- <th scope="row"><%= doctorLst.getId()%></th> --%>
									<th><%=menuList.getFoodName()%></th>
									<td><%=menuList.getPrice()%></td>
									<td><%=menuList.getDescription()%></td>
								


									<td><a class="btn btn-sm btn-primary"
										href="edit_menu.jsp?id=<%=menuList.getId()%>">Edit</a></td>
									<td><a class="btn btn-sm btn-danger" href="../deleteMenu?id=<%= menuList.getId() %>">Delete</a></td>



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