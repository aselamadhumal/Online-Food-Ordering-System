<%@page import="com.foms.db.DBConnection"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.foms.entity.Menu"%>
<%@page import="java.util.List"%>
<%@page import="com.foms.dao.MenuDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0 ">

<title>Online Foor Ordering System</title>
<%@include file="component/allcss.jsp"%>


<style type="text/css">
.my-card {
	box-shadow: 0px 0px 10px 1px maroon;
	
}
</style>


</head>
<body>
	<%@include file="component/navbar.jsp"%>


	<div id="carouselExampleIndicators" class="carousel slide"
		data-bs-ride="carousel">
		<div class="carousel-indicators">
			<button type="button" data-bs-target="#carouselExampleIndicators"
				data-bs-slide-to="0" class="active" aria-current="true"
				aria-label="Slide 1"></button>
			<button type="button" data-bs-target="#carouselExampleIndicators"
				data-bs-slide-to="1" aria-label="Slide 2"></button>
			<button type="button" data-bs-target="#carouselExampleIndicators"
				data-bs-slide-to="2" aria-label="Slide 3"></button>

		</div>
		<div class="carousel-inner">
			<div class="carousel-item active">
				<img src="img/img1.jpg" class="d-block w-100" alt="..."
					height="500px">
			</div>
			<div class="carousel-item">
				<img src="img/img2.jpg" class="d-block w-100" alt="..."
					height="500px">
			</div>
			<div class="carousel-item">
				<img src="img/img3.jpg" class="d-block w-100" alt="..."
					height="500px">
			</div>
	

		</div>
		<button class="carousel-control-prev" type="button"
			data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
			<span class="carousel-control-prev-icon" aria-hidden="true"></span> <span
				class="visually-hidden">Previous</span>
		</button>
		<button class="carousel-control-next" type="button"
			data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
			<span class="carousel-control-next-icon" aria-hidden="true"></span> <span
				class="visually-hidden">Next</span>
		</button>
	</div>

	<div class="container p-3">
		<p class="text-center mt-2 mb-5 fs-2 myP-color">Menu</p>
		<div class="row">
			
			<div class="col-md-12 p-5">

				<div class="row">
						<%
								MenuDAO menuDAO2 = new MenuDAO(DBConnection.getConn());
																				List<Menu> listOfMenu = menuDAO2.getAllMenus();
																				for (Menu menuList : listOfMenu) {
								%>

					<div class="col-md-4">
							
						<div class="card my-card">
							<div class="card-body">
								<h4 class="fs-5 myP-color"><%=menuList.getFoodName()%></h4>
								<h5><%=menuList.getPrice()%></h5>
								<p><%=menuList.getDescription()%></p>
							</div>
						</div>
					
					</div>
	<%
								}
								%>
			
				</div>


			</div>
		

		</div>
	</div>

	<%@include file="component/footer.jsp"%>
	
</body>
</html>