<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">

<title>Home Page</title>
</head>
<body>
<div class="container">
	<jsp:include page="Header.jsp"></jsp:include>
		<c:if test="${loginedUser == null }">
			<script>
				window.location.assign("Login.jsp");
			</script>
		</c:if>
		<table class="table">
		<thead>
			<tr>
				<!-- <th>Car ID</th> -->
				<th>Maker</th>
				<th>Model</th>
				<th>Manufacture Year</th>
				<th>Color</th>
				<th>Note</th>
				<th></th>
				<th></th>
			</tr>
		</thead>
		<tbody id="content-car">
			<c:forEach var="car" items="${listCar }">
				<tr>
					<%-- <td id="p-carid"}>${car.getCarID() }</td> --%>
					<td id="p-maker" data-id-car=${car.getCarID() }>${car.getMaker() }</td>
					<td id="p-model"}>${car.getModel() }</td>
					<td id="p-manufacture-year"}>${car.getManufactureYear() }</td>
					<td id="p-color"}>${car.getColor() }</td>
					<td id="p-note"}>${car.getNote() }</td>
					<td><button class="btn btn-warning btn-update">Update</button></td>
					<td><button class="btn btn-danger btn-delete">Delete</button></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>
	<div class="row text-center">
		<div class=col-md-3">
			<button id="btn-insert" class="btn btn-success">Insert</button>
			<button type="button" id="btn-go-to-account-page" class="btn btn-info">Go to account page</button>
		</div>
	</div>
	<!-- Modal Insert Car -->
	<div class="modal" id="modelFormInsertCar" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalCenterTitle"
		aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title" id="exampleModalLongTitle">Insert Car</h4>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<input type="text" id="text-maker" class="form-control" placeholder="Enter car's maker..."> <br />
					<input type="text" id="text-model" class="form-control" placeholder="Enter car's model..."> <br />
					<input type="text" id="text-manufacture-year" class="form-control" placeholder="Enter car's manufacture year...">
					<br /> <input type="text" id="text-color" class="form-control" placeholder="Enter car's color...">
					<br /> <input type="text" id="text-note" class="form-control" placeholder="Enter car's note...">
					<br />
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button>
					<button type="button" id="btn-save-insert" class="btn btn-primary">Submit</button>
				</div>
			</div>
		</div>
	</div>

	<!-- Modal Update Car -->
	<div class="modal" id="modelFormUpdateCar" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalCenterTitle"
		aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title" id="exampleModalLongTitle">Update Car</h4>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<input type="text" id="text-car-id" class="form-control" disabled="disabled">
					<br/>
					<input type="text" id="text-maker" class="form-control">
					<br/>
					<input type="text" id="text-model" class="form-control">
					<br/>
					<input type="text" id="text-manufacture-year" class="form-control">
					<br/>
					<input type="text" id="text-color" class="form-control">
					<br/>
					<input type="text" id="text-note" class="form-control">
					<br/>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button>
					<button id="btn-save-update" type="button" class="btn btn-primary">Save changes</button>
				</div>
			</div>
		</div>
	</div>
	
	<script src="js/jquery-3.3.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/homepage.js"></script>
</body>
</html>