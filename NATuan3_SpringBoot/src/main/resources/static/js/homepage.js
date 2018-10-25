$(document).ready(function(){
	$("body").on("click",".btn-delete",function(){
		var carID = $(this).closest("tr").find("td:first").attr("data-id-car");
		var self = $(this);
		var choice = confirm("Are you want to delete this car ?");
		if (choice == true) {
			$.ajax({
				url : "HomeServlet?method=deleteCar",
				type : "POST",
				data : {
					carID : parseInt(carID)
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
	$("body").on("click",".btn-update",function(){
		var carID = $(this).closest("tr").find("td:first").attr("data-id-car");
		var maker = $(this).closest("tr").find("#p-maker").text();
		var model = $(this).closest("tr").find("#p-model").text();
		var manufactureYear = $(this).closest("tr").find("#p-manufacture-year").text();
		var color = $(this).closest("tr").find("#p-color").text();
		var note = $(this).closest("tr").find("#p-note").text();
		
		$("#modelFormUpdateCar").modal("show");
		
		$("#modelFormUpdateCar").find("#text-car-id").val(carID);
		$("#modelFormUpdateCar").find("#text-maker").val(maker);
		$("#modelFormUpdateCar").find("#text-model").val(model);
		$("#modelFormUpdateCar").find("#text-manufacture-year").val(manufactureYear);
		$("#modelFormUpdateCar").find("#text-color").val(color);
		$("#modelFormUpdateCar").find("#text-note").val(note);
		
		var self = $(this);
		
		$("#btn-save-update").click(function(){
			//var carID = $("#modelFormUpdateCar").find("#text-car-id").val();
			var maker = $("#modelFormUpdateCar").find("#text-maker").val();
			var model = $("#modelFormUpdateCar").find("#text-model").val();
			var manufactureYear = $("#modelFormUpdateCar").find("#text-manufacture-year").val();
			var color = $("#modelFormUpdateCar").find("#text-color").val();
			var note = $("#modelFormUpdateCar").find("#text-note").val();
			$.ajax({
				url : "HomeServlet?method=updateCar",
				type : "POST",
				data : {
					carID: parseInt(carID),
					maker: maker,
					model: model,
					manufactureYear: manufactureYear,
					color: color,
					note: note
				},
				success : function(value) {
					if ("true" == value.toString()) {
						$("#modelFormUpdateCar").modal("hide");
						alert("Update successfully");
						self.closest("tr").find("#p-maker").text(maker);
						self.closest("tr").find("#p-model").text(model);
						self.closest("tr").find("#p-manufacture-year").text(manufactureYear);
						self.closest("tr").find("#p-color").text(color);
						self.closest("tr").find("#p-note").text(note);
						
					} else {
						$("#modelFormUpdateCar").modal("hide");
						alert("Update error");
					}
				}
			});		
		});
	});
	
	$("#btn-insert").click(function(){
		$("#modelFormInsertCar").modal("show");
		var self = $(this);
		
		$("#btn-save-insert").click(function(){
			var maker = $("#modelFormInsertCar").find("#text-maker").val();
			var model = $("#modelFormInsertCar").find("#text-model").val();
			var manufactureYear = $("#modelFormInsertCar").find("#text-manufacture-year").val();
			var color = $("#modelFormInsertCar").find("#text-color").val();
			var note = $("#modelFormInsertCar").find("#text-note").val();
			
			
			$.ajax({
				url : "HomeServlet?method=insertCar",
				type : "POST",
				data : {
					maker: maker,
					model: model,
					manufactureYear: manufactureYear,
					color: color,
					note: note
				},
				success : function(value) {
					if (parseInt(value) > 0) {
						$("#modelFormInsertCar").modal("hide");
						alert("Insert successfully");
						var htmlElement = "<tr>";
						htmlElement += "<td id='p-maker' data-id-car='"+parseInt(value)+"'>"+maker+"</td>";
						htmlElement += "<td id='p-model'>"+model+"</td>";
						htmlElement += "<td id='p-manufacture-year'>"+manufactureYear+"</td>";
						htmlElement += "<td id='p-color'>"+color+"</td>";
						htmlElement += "<td id='p-note'>"+note+"</td>";
						htmlElement += "<td><button class='btn btn-warning btn-update'>Update</button></td></td>";
						htmlElement += "<td><button class='btn btn-danger btn-delete'>Delete</button></td>";
						htmlElement += "</tr>";
						self.closest("body").find("#content-car").append(htmlElement);
						
					} else {
						$("#modelFormInsertCar").modal("hide");
						alert("Insert error");
					}
				}
			});
			
		});
	});
	
	$("#btn-go-to-account-page").click(function(){
		window.location.assign("AccountServlet");
	});
});