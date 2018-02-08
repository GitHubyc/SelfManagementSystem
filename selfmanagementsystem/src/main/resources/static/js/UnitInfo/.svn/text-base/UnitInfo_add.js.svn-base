$(document).ready(function() {
	$("#Administrative_add").hide();
	$("#EnterpriseUnit_add").hide();
	$("#PropertyManagementOffice_add").hide();
	
	$('#city').citys({
		required : false,
	});
	
	$('.date').datepicker({
		format : "yyyy-mm-dd",
		language : "zh-CN",
		todayBtn : "linked",
		clearBtn : true,
	});

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
	$("#submit").click(
			function(e) {
				e.preventDefault();
				layer.confirm('是否确定提交？', {
					btn : [ '确定', '取消' ]
				}, function(index) {
					layer.close(index);
					var unitInfoDto = $('#form').serializeObject();// 单位基本信息
					var administrativeUnitDto = $('#admin_form')
					.serializeObject();// 行政单位
					var causeUnitDto = {};// 事业单位
					var enterpriseUnitDto = $('#enterpriseUnitDto_form')
					.serializeObject();// 企业单位--基本信息
					var enterpriseSubjectDutyDto = $('#enterpriseSubjectDutyDto_form')
					.serializeObject();// 企业单位--主体责任
					var propertyManagementOfficeDto = $('#propertyManagementOfficeDto_form')
					.serializeObject();// 物业管理处
					var propertyServeDto = $('#propertyServeDto_form')
					.serializeObject();// 物业服务

					var data = {
							"unitInfoDto" : unitInfoDto,
							"administrativeUnitDto" : administrativeUnitDto,
							"causeUnitDto" : causeUnitDto,
							"enterpriseUnitDto":enterpriseUnitDto,
							"enterpriseSubjectDutyDto" : enterpriseSubjectDutyDto,
							"propertyManagementOfficeDto" : propertyManagementOfficeDto,
							"propertyServeDto" : propertyServeDto
					};
					$.ajax({
						contentType : "application/json; charset=utf-8",
						dataType : "JSON",
						url : "/unit/add",
						type : "POST",
						data : JSON.stringify(data),
						success : function(data) {							
							if (data.status == 200) {
								toastr.success(data.msg);
								// 返回父页面
								//history.go(-1);
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
});


//input单位性质
$("#form :radio[name='unitNature']")
.click(
		function() {
			var num = $(this).val();
			var $templateEle = $("#form .form_content"), $el = $templateEle
			.find('input').attr('name');
			if (num == 1) {
				$("#Administrative_add").show();
				$("#EnterpriseUnit_add").hide();
				$("#PropertyManagementOffice_add").hide();
				$("[name='buildCode']").removeAttr("disabled");
//				var text = $('<div class="form_content"></div>').load(
//				'/administrative/add')
//
//				$templateEle.last().after(text);
//				$templateEle.eq(1).remove();
				return true;
			} else if (num == 2) {
				$("#Administrative_add").hide();
				$("#EnterpriseUnit_add").hide();
				$("#PropertyManagementOffice_add").hide();
				$("[name='buildCode']").removeAttr("disabled");
//				$templateEle.eq(1).remove();
			} else if (num == 3) {
				$("#Administrative_add").hide();
				$("#EnterpriseUnit_add").show();
				$("#PropertyManagementOffice_add").hide();
				$("[name='buildCode']").removeAttr("disabled");
//				var text = $('<div class="form_content"></div>')
//				.load(
//						'/enterpriseunit/add',
//						function() {
//							// 日期插件
//							$('.date').datepicker({
//								format : "yyyy-mm-dd",
//								language : "zh-CN",
//								todayBtn : "linked",
//								clearBtn : true,
//							});
//
//							$('.input-daterange')
//							.datepicker(
//									{
//										format : "yyyy-mm-dd",
//										todayBtn : "linked",
//										language : "zh-CN",
//										keyboardNavigation : false
//									})
//									.on(
//											'changeDate',
//											function(e) {
//												if ($(
//												'.input-daterange input[name="businessToDate"]')
//												.val() == $(
//												'.input-daterange input[name="businessFromDate"]')
//												.val()) {
//													$(
//													'.input-daterange input[name="businessToDate"]')
//													.val(
//													"");
//												}
//
//											});
							getdocumentType();
//						})
//						$templateEle.last().after(text);
//				$templateEle.eq(1).remove();

			} else if (num == 4) {
				$("#Administrative_add").hide();
				$("#EnterpriseUnit_add").hide();
				$("[name='buildCode']").prop("disabled","disabled")	
				$("#PropertyManagementOffice_add").show();
//				var text = $('<div class="form_content"></div>').load(
//				'/propertymanagementoffice/add',function(){
//				
//				});
//				$templateEle.last().after(text);
//				$templateEle.eq(1).remove();
			}
		
		});

function getdocumentType() {
	$(
			"#form select[name='documentType'],#EnterpriseUnit select[name='documentType'],#UnitEmployee select[name='documentType']")
			.change(
					function() {
						var num = $(this).val();
						var $templateEle = $("#form .form_content"), $el = $templateEle
								.find('input').attr('name');
						if (num == 1) {
							$(".documentNo")
									.html(
											' <input  class="form-control "  name="documentNo" placeholder="请输入18位身份证号"  type="text">');
						} else if (num == 2) {
							$(".documentNo")
									.html(
											' <input  class="form-control "  name="documentNo" placeholder="请输入护照"  type="text">');
						} else if (num == 3) {
							$(".documentNo")
									.html(
											' <input  class="form-control "  name="documentNo" placeholder="请输入港澳通行证"  type="text">');
						}
						$('#BuildInfo').bootstrapValidator('addField', $el);
					});
}