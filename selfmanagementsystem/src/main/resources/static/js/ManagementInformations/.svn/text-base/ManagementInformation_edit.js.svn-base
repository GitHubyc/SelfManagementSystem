setTimeout(function() {
var str = $("[name='unitAddress']").text();
var str1 = str.replace($("[name='address']").val(), '');
$("[name='unitAddress']").text(str1)
}, 200);
$(function(){
$(".img_box img").attr("src","../../img/logo.png")
});
$("#send").click(
		function(e) {
			e.preventDefault();
			layer.confirm('是否确定提交？', {
				btn : [ '确定', '取消' ]
			}, function(index) {
				layer.close(index);
				var unitInfoDto = $('#UnitInfo').serializeObject();// 单位基本信息
				var propertyManagementOfficeDto = $('#propertyManagementOfficeDto_form')
				.serializeObject();// 物业管理处
				var propertyServeDto = $('#propertyServeDto_form')
				.serializeObject();// 物业服务
				unitInfoDto.unitAddress=unitInfoDto.address+unitInfoDto.unitAddress
				var data = {
						"unitInfoDto" : unitInfoDto,
						"propertyManagementOfficeDto" : propertyManagementOfficeDto,
						"propertyServeDto" : propertyServeDto
				};
				var unitCode = $("#unitCode").attr("value");
				$.ajax({
					contentType : "application/json; charset=utf-8",
					dataType : "JSON",
					url : "/managementinformation/edit/"+unitCode,
					type : "PUT",
					data : JSON.stringify(data),
					success : function(data) {
						if (data.status == 200) {
							toastr.success(data.msg);
							// 返回父页面
							window.location.replace("/managementinformation/list");
						} else {
							toastr.error(data.msg);
						}
					},
					error : function(data) {
						toastr.error('服务无响应')
					}
				});
			});
		});
