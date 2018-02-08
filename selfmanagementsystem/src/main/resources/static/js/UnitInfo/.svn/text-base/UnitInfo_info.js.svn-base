setTimeout(function() {
var str = $("[name='unitAddress']").text();
var str1 = str.replace($("[name='address']").val(), '');
$("[name='unitAddress']").text(str1)
}, 200);


$("#UnitInfo :radio[name='unitNature']")
.click(
		function() {
			var num = $(this).val();
			var $templateEle = $("#UnitInfo .form_content"), $el = $templateEle
			.find('input').attr('name');
			if (num == 1) {
				var text = $('<div class="form_content"></div>').load('/administrative/edit?unitCode='+getUrlParam('unitCode'))				
				$templateEle.last().after(text);
				$templateEle.eq(1).remove();
				return true;
			} else if (num == 2) {
				$templateEle.eq(1).remove();
			} else if (num == 3) {
				var text = $('<div class="form_content"></div>')
				.load('/enterpriseunit/edit?unitCode='+getUrlParam('unitCode'),
						function() {


					$('.input-daterange')
					.datepicker(
							{
								format : "yyyy-mm-dd",
								todayBtn : "linked",
								language : "zh-CN",
								keyboardNavigation : false
							})
							.on(
									'changeDate',
									function(e) {
										if ($(
										'.input-daterange input[name="businessToDate"]')
										.val() == $(
										'.input-daterange input[name="businessFromDate"]')
										.val()) {
											$(
											'.input-daterange input[name="businessToDate"]')
											.val(
											"");
										}

									});

				})
				$templateEle.last().after(text);
				$templateEle.eq(1).remove();

			} else if (num == 4) {

				var text = $('<div class="form_content"></div>').load(
						'/propertymanagementoffice/edit?unitCode='+getUrlParam('unitCode'))
						$templateEle.last().after(text);
				
				
				$templateEle.eq(1).remove();
			}
			$('#form').bootstrapValidator('addField', $el);
		});




$("#send").click(
		function(e) {
			e.preventDefault();
			layer.confirm('是否确定提交？', {
				btn : [ '确定', '取消' ]
			}, function(index) {
				layer.close(index);
				var unitInfoDto = $('#UnitInfo').serializeObject();// 单位基本信息
				unitInfoDto["unitNature"] = $("#unitNature").val();
				var administrativeUnitDto = $('#admin_form')
				.serializeObject();// 行政单位
				var enterpriseUnitDto = $('#enterpriseUnitDto_form')
				.serializeObject();// 企业单位--基本信息
				var enterpriseSubjectDutyDto = $('#enterpriseSubjectDutyDto_form')
				.serializeObject();// 企业单位--主体责任
				var propertyManagementOfficeDto = $('#propertyManagementOfficeDto_form')
				.serializeObject();// 物业管理处
				var propertyServeDto = $('#propertyServeDto_form')
				.serializeObject();// 物业服务
				unitInfoDto.unitAddress=unitInfoDto.address+unitInfoDto.unitAddress
				var data = {
						"unitInfoDto" : unitInfoDto,
						"administrativeUnitDto" : administrativeUnitDto,
						"enterpriseUnitDto":enterpriseUnitDto,
						"enterpriseSubjectDutyDto" : enterpriseSubjectDutyDto,
						"propertyManagementOfficeDto" : propertyManagementOfficeDto,
						"propertyServeDto" : propertyServeDto
				};
				var unitCode = $("#unitCode").attr("value");
				$.ajax({
					contentType : "application/json; charset=utf-8",
					dataType : "JSON",
					url : "/unit/edit?unitCode="+unitCode,
					type : "PUT",
					data : JSON.stringify(data),
					success : function(data) {
						if (data.status == 200) {
							toastr.success(data.msg);
							// 返回父页面
							window.location.replace("/unit/list");
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

$("#UnitInfo :radio[name='unitNature']").prop("disabled","disabled")
//获取链接参数
function getUrlParam(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); // 构造一个含有目标参数的正则表达式对象
	var r = window.location.search.substr(1).match(reg); // 匹配目标参数
	if (r != null)
		return encodeURI(r[2]);
	return null; // 返回参数值
}
var pathname = window.location.pathname;
if(pathname=="/unit/details"){
	$("input,textarea,select").prop("disabled","disabled")	
	$(".btn-success").remove();
	$(".btn-primary").remove();
	$(".btn-file").remove();

}
