$(function() {
	
	$("#userList").click(function() {
		fetchList("user");
	});
	
	$("#addressList").click(function() {
		fetchList("address");
	});
});
//add form ajax call for redirecting user form
function addForm(type) {
	$.ajax({
		type : "GET",
		url : "/form",
		success : function(data) {
			$(".inner-jsp").html(data);
		}
	});
}
//edit form ajax call for redirecting user form
function editForm(type, id) {
	alert("hi");
	$.ajax({
		type : "GET",
		url : "/edituser/"+id,
		success : function(data) {
			$(".inner-jsp").html(data);
		}
	});
	
}

function fetchList(type) {
	alert("1");
	modifyData(type+"/list");
}

function modifyData(suffix) {
	$.ajax({
		type : "GET",
		url : type+"/form",
		success : function(data) {
			$(".inner-jsp").html(data);
		}
	});
}

function modifyData(suffix) {
	$.ajax({
		type : "GET",
		url : "/list",
		success : function(data) {
			$(".inner-jsp").html(data);
		}
	});
}
function deleteData(type, id) {
	toastr.warning("<div>Are you sure you want to delete this?</div>" +
			"<div class='btn-group pull-right'>" +
			"<button type='button' id='confirmationYes' class='btn btn-xs btn-default'><i class='glyphicon glyphicon-ok'></i> Yes</button>" +
			"<button type='button' class='btn btn-xs btn-default clear'><i class='glyphicon glyphicon-remove'></i> No</button>" +
			"</div>", "Delete Confirmation", {
		allowHtml:true,
		closeButton:true,
		onShown: function() {
			$("#confirmationYes").click(function() {
				$.ajax({
					type : "GET",
					url : type+"/delete/"+id,
					success : function(data) {
						fetchList(type);
						toastr.success(data.message, "Delete Confirmation", {
							closeButton:true
						});
					}
				});
			});
		}
	});
}