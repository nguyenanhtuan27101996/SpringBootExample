<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Account Page</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
</head>
<body>
	
	<div class="container-fluid">
		<jsp:include page="Header.jsp"></jsp:include>
		
		<table class="table">
			<thead>
				<tr>
					<th>AccountID</th>
					<th>FullName</th>
					<th>Telephone Number</th>
					<th>Email</th>
					<th>Password</th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			<tbody id="content-account">
				<c:forEach var="account" items="${listAccount }">
					<tr>
						<td id="p-accountid">${account.getAccountID() }</td>
						<td id="p-fullname"}>${account.getFullName() }</td>
						<td id="p-telephone-number"}>${account.getTelephoneNumber() }</td>
						<td id="p-email"}>${account.getEmail() }</td>
						<td id="p-password"}>${account.getPwd() }</td>
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
		</div>
	</div>
	
	<!-- Modal Insert Account -->
	<div class="modal" id="modelFormInsertAccount" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalCenterTitle"
		aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title" id="exampleModalLongTitle">Insert Account</h4>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<input type="text" id="text-fullname" class="form-control" placeholder="Enter account's name">
					<br/>
					<input type="text" id="text-telephone-number" class="form-control"  placeholder="Enter account's tel number">
					<br/>
					<input type="text" id="text-email" class="form-control" placeholder="Enter account's email">
					<br/>
					<input type="password" id="text-password" class="form-control" placeholder="Enter account's password">
					<br/>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button>
					<button id="btn-save-insert" type="button" class="btn btn-primary">Submit</button>
				</div>
			</div>
		</div>
	</div>
	
	
	<!-- Modal Update Account -->
	<div class="modal" id="modelFormUpdateAccount" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalCenterTitle"
		aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title" id="exampleModalLongTitle">Update Account</h4>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<input type="text" id="text-account-id" class="form-control" disabled="disabled">
					<br/>
					<input type="text" id="text-fullname" class="form-control">
					<br/>
					<input type="text" id="text-telephone-number" class="form-control">
					<br/>
					<input type="text" id="text-email" class="form-control">
					<br/>
					<input type="password" id="text-password" class="form-control">
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
	<script src="js/sha256.min.js"></script>
	<script src="js/accountpage.js"></script>
</body>
</html>