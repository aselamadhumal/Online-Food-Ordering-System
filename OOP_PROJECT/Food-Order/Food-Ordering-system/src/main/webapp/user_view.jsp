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
<title>User Profile</title>
<%@include file="component/allcss.jsp"%>
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
	<%@include file="component/navbar.jsp"%>
	
	
	<!-- if not login then log in first -->
	<c:if test="${empty userObj }">

		<c:redirect url="/user_login.jsp"></c:redirect>

	</c:if>

	<div class="container p-4">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card my-card">

					<div class="card-body">
						<p class="fs-3 text-center myP-color">User Profile</p>

						<!-- for message -->
						<!-- success message -->
						<c:if test="${not empty successMsg }">
							<p class="text-center text-success fs-5">${successMsg}</p>
							<c:remove var="successMsg" scope="session" />
						</c:if>

						<!-- error message -->
						<c:if test="${not empty errorMsg }">
							<p class="text-center text-danger fs-5">${errorMsg}</p>
							<c:remove var="errorMsg" scope="session" />
						</c:if>
						<!-- end of message -->

	<%
					
														int id = Integer.parseInt(request.getParameter("id"));
														UserDAO userDAO = new UserDAO(DBConnection.getConn());
														User user = userDAO.getUserById(id);
						%>
						
						

						<div >
						
						
								<p>Full Name: <%= user.getFullName() %></p>
							
							    <p>Email: <%= user.getEmail() %></p>
							    
							    <a class="btn btn-sm btn-primary"
										href="user_edit.jsp?id=<%=user.getId()%>">Edit</a>
							
						
						</div>
						
					</div>
				</div>

			</div>
		</div>
	</div>


</body>
</html>