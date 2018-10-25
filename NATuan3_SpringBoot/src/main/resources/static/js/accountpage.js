$(document).ready(function(){
	$("body").on("click",".btn-delete",function(){
		var accountID = $(this).closest("tr").find("#p-accountid").text();
		var self = $(this);
		var choice = confirm("Are you want to delete this account ? ");
		if (choice == true){
			$.ajax({
				url : "/account/delete",
				type : "POST",
				data : {
					accountID : parseInt(accountID)
				},
				success : function(value) {
					if ("true" == value.toString()) {
						alert("Delete successfully !");
						self.closest("tr").remove();
					} else {
						alert("Delete error !");
					}

				}
			});
		}	
	});
	function validateEmail(email) {
		var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
		return re.test(String(email).toLowerCase());
	}
	
	$("body").on("click",".btn-update",function(){
		var self = $(this);
		var accountID = self.closest("tr").find("#p-accountid").text();
		var fullName = self.closest("tr").find("#p-fullname").text();
		var telephoneNumber = self.closest("tr").find("#p-telephone-number").text();
		var email = self.closest("tr").find("#p-email").text();
		//var pwd = self.closest("tr").find("#p-password").text();
		
		$("#modelFormUpdateAccount").modal("show");
		$("#modelFormUpdateAccount").find("#text-account-id").val(accountID);
		$("#modelFormUpdateAccount").find("#text-fullname").val(fullName);
		$("#modelFormUpdateAccount").find("#text-telephone-number").val(telephoneNumber);
		$("#modelFormUpdateAccount").find("#text-email").val(email);
		$("#modelFormUpdateAccount").find("#text-password").val("");
		$("#btn-save-update").click(function(){
			var fullName = $("#modelFormUpdateAccount").find("#text-fullname").val();
			var telephoneNumber = $("#modelFormUpdateAccount").find("#text-telephone-number").val();
			var email = $("#modelFormUpdateAccount").find("#text-email").val();
			var pwd = $("#modelFormUpdateAccount").find("#text-password").val();
			if (pwd.length > 6 && validateEmail(email)){
				$.ajax({
					url : "/account/update",
					type : "POST",
					data : {
						accountID: parseInt(accountID),
						fullName: fullName,
						telephoneNumber: telephoneNumber,
						email: email,
						pwd: pwd
					},
					success : function(value) {
						if ("true" == value.toString()) {
							$("#modelFormUpdateAccount").modal("hide");
							alert("Update successfully");
							self.closest("tr").find("#p-fullname").text(fullName);
							self.closest("tr").find("#p-telephone-number").text(telephoneNumber);
							
							var hashPwd = sha256.create();
							hashPwd.update(pwd);
							hashPwd.hex();
							
							self.closest("tr").find("#p-email").text(email);
							self.closest("tr").find("#p-password").text(hashPwd);
							
						} else {
							$("#modelFormUpdateAccount").modal("hide");
							alert("Update error");
						}
					}
				});
			} else {
				alert("Mật khẩu không đủ mạnh hoặc email sai định dạng !");
			}	
		});	
	});
	$("#btn-insert").click(function(){
		var self = $(this);
		$("#modelFormInsertAccount").modal("show");
		
		$("#btn-save-insert").click(function(){
			var fullName = $("#modelFormInsertAccount").find("#text-fullname").val();
			var telephoneNumber = $("#modelFormInsertAccount").find("#text-telephone-number").val();
			var email = $("#modelFormInsertAccount").find("#text-email").val();
			var pwd = $("#modelFormInsertAccount").find("#text-password").val();
			
			if (pwd.length > 6 && validateEmail(email)){
				$.ajax({
					url : "/account/insert",
					type : "POST",
					data : {
						fullName: fullName,
						telephoneNumber: telephoneNumber,
						email: email,
						pwd: pwd
					},
					success : function(value) {
						if (parseInt(value) > 0) {
							$("#modelFormInsertAccount").modal("hide");
							alert("Insert successfully");
							var hashPwd = sha256.create();
							hashPwd.update(pwd);
							hashPwd.hex();
							
							var htmlElement = "<tr>";
							htmlElement += "<td id='p-accountid'>"+parseInt(value)+"</td>";
							htmlElement += "<td id='p-fullname'>"+fullName+"</td>";
							htmlElement += "<td id='p-telephone-number'>"+telephoneNumber+"</td>";
							htmlElement += "<td id='p-email'>"+email+"</td>";
							htmlElement += "<td id='p-password'>"+hashPwd+"</td>";
							htmlElement += "<td><button class='btn btn-warning btn-update'>Update</button></td></td>";
							htmlElement += "<td><button class='btn btn-danger btn-delete'>Delete</button></td>";
							htmlElement += "</tr>";
							self.closest("body").find("#content-account").append(htmlElement);
							
						} else {
							$("#modelFormInsertAccount").modal("hide");
							alert("Insert error");
						}
					}
				});
			} else {
				alert("Mật khẩu không đủ mạnh hoặc email sai định dạng !");
			}
			
		});
	});
	
});