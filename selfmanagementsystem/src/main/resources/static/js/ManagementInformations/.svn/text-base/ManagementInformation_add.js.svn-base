
$(document).ready(function() {
	//添加验证(单位基本信息)
	var $from=$('#form')
	.bootstrapValidator({
		message: 'This value is not valid',
		live: 'enabled',
		trigger:'blur keyup',   
		feedbackIcons: {//input状态样式图片
			valid: 'glyphicon ',
			invalid: 'glyphicon ',
			validating: 'glyphicon'
		},
		container: 'popover',
		fields: {//验证：规则           	
			subordinateUnit: {
				message:'隶属单位',             
				validators: {
					notEmpty: {
						message: '隶属单位不能为空'
					}
				}
			},
			unitName: {
				message:'单位名称',             
				validators: {
					notEmpty: {
						message: '单位名称不能为空'
					}
				}
			},
			unitShort: {
				message:'单位简称',             
				validators: {
					notEmpty: {
						message: '单位简称不能为空'
					}
				}
			},
			xzqhCode: {
				message:'行政区划',             
				validators: {
					notEmpty: {
						message: '行政区划不能为空'
					}
				}
			},
			province : {
				message : '省无效',

				validators : {
					notEmpty : {
						message : '省不能为空'
					}
				}
			},
			city : {
				message : '市无效',

				validators : {
					notEmpty : {
						message : '市不能为空'
					}
				}
			},
			county : {
				message : '区无效',

				validators : {
					notEmpty : {
						message : '区不能为空'
					}
				}
			},
			street : {
				message : '街无效',
				validators : {
					notEmpty : {
						message : '街不能为空'
					}
				}

			},
			community : {
				message : '社区无效',
				validators : {
					notEmpty : {
						message : '社区不能为空'
					}
				}

			},
			grid : {
				message : '网格无效',
				validators : {
					notEmpty : {
						message : '网格不能为空'
					}
				}

			},
			unitType: {
				message:'单位类型',             
				validators: {
					notEmpty: {
						message: '单位类型不能为空'
					} 
				}
			},
			unitAddress: {
				message:'单位地址',             
				validators: {
					notEmpty: {
						message: '单位地址不能为空'
					}
				}
			}
		}
	})

	//添加验证(物业管理处)
	var $from1=$('#propertyManagementOfficeDto_form')
	.bootstrapValidator({
		message: 'This value is not valid',
		live: 'enabled',
		trigger:'blur keyup',   
		feedbackIcons: {//input状态样式图片
			valid: 'glyphicon ',
			invalid: 'glyphicon ',
			validating: 'glyphicon '
		},
		container: 'popover',
		fields: {//验证：规则     
			certificateNo: {
				message:'资质证书编号',             
				validators: {
					notEmpty: {
						message: '资质证书编号不能为空'
					}
				}
			},
			buildArea: {
				message:'建筑面积',             
				validators: {
					notEmpty: {
						message: '建筑面积不能为空'
					}
				}
			},
			floorArea: {
				message:'占地面积',             
				validators: {
					notEmpty: {
						message: '占地面积不能为空'
					}
				}
			},
			tenantNumber: {
				message:'租户数',             
				validators: {
					notEmpty: {
						message: '租户数不能为空'
					}
				}
			},
			ownerNumber: {
				message:'业主数',             
				validators: {
					notEmpty: {
						message: '业主数不能为空'
					}
				}
			},
			numberEmployedPeople: {
				message:'从业人数',             
				validators: {
					notEmpty: {
						message: '从业人数不能为空'
					}
				}
			},
			pedestrianEntranceNumber: {
				message:'人行出入口数',             
				validators: {
					notEmpty: {
						message: '人行出入口数不能为空'
					}
				}
			},
			propertyFee: {
				message:'物业费',             
				validators: {
					notEmpty: {
						message: '物业费不能为空'
					}
				}
			},
			undergroundParkingCharge: {
				message:'地下停车场收费',             
				validators: {
					notEmpty: {
						message: '地下停车场收费不能为空'
					}
				}
			},
			undergroundParkingArea: {
				message:'地下停车场总面积',             
				validators: {
					notEmpty: {
						message: '地下停车场总面积不能为空'
					}
				}
			},
			outdoorParkingArea: {
				message:'露天停车场总面积',             
				validators: {
					notEmpty: {
						message: '地下停车场总面积不能为空'
					}
				}
			},
			carEntranceNumber: {
				message:'车行出入口数',             
				validators: {
					notEmpty: {
						message: '车行出入口数不能为空'
					}
				}
			},
			parkingSpaceNumber: {
				message:'车位数',             
				validators: {
					notEmpty: {
						message: '车位数不能为空'
					}
				}
			},
			outdoorParkingSpaces: {
				message:'露天停车场车位数',             
				validators: {
					notEmpty: {
						message: '露天停车场车位数不能为空'
					}
				}
			},
			undergroundParkingSpaces: {
				message:'地下停车场车位数',             
				validators: {
					notEmpty: {
						message: '地下停车场车位数不能为空'
					}
				}
			},
			greeningRate: {
				message:'绿化率',             
				validators: {
					notEmpty: {
						message: '绿化率不能为空'
					}
				}
			},
			plotRatio: {
				message:'容积率',             
				validators: {
					notEmpty: {
						message: '容积率不能为空'
					}
				}
			},
			outdoorParkingCharge: {
				message:'露天停车场收费',             
				validators: {
					notEmpty: {
						message: '露天停车场收费不能为空'
					}
				}
			},
			aptitudesLevel: {
				message:'物业资质等级',             
				validators: {
					notEmpty: {
						message: '物业资质等级不能为空'
					}
				}
			}

		}
	})

	//添加验证(物业服务)
	var $from2=$('#propertyServeDto_form')
	.bootstrapValidator({
		message: 'This value is not valid',
		live: 'enabled',
		trigger:'blur keyup',   
		feedbackIcons: {//input状态样式图片
			valid: 'glyphicon ',
			invalid: 'glyphicon ',
			validating: 'glyphicon'
		},
		container: 'popover',
		fields: {//验证：规则           	
			serveUnitName: {
				message:'服务单位名称',             
				validators: {
					notEmpty: {
						message: '服务单位名称不能为空'
					}
				}
			},
			serveUnitCode: {
				message:'服务单位编号',             
				validators: {
					notEmpty: {
						message: '服务单位编号不能为空'
					}
				}
			},
			serveType: {
				message:'服务类型',             
				validators: {
					notEmpty: {
						message: '服务类型不能为空'
					}
				}
			},
			contactNumber: {
				message:'联系电话',             
				validators: {
					notEmpty: {
						message: '联系电话不能为空'
					}
				}
			},
			personCharge: {
				message:'责任人',             
				validators: {
					notEmpty: {
						message: '责任人不能为空'
					}
				}
			}
		}
	})

	$("#submit").on("click", function(e){
		e.preventDefault();
		//获取表单对象
		var bootstrapValidator = $from.data('bootstrapValidator');
		var bootstrapValidator1 = $from1.data('bootstrapValidator');
		var bootstrapValidator2 = $from2.data('bootstrapValidator');
		//手动触发验证
		bootstrapValidator.validate();
		bootstrapValidator1.validate();
		bootstrapValidator2.validate();
	
		if(bootstrapValidator.isValid()&&bootstrapValidator1.isValid()&& bootstrapValidator2.isValid()){			
			layer.confirm('是否确定提交？', {
				btn : [ '确定', '取消' ]
			}, function(index) {
				layer.close(index);
				var unitInfoDto = $('#form').serializeObject();// 单位基本信息
				unitInfoDto["unitNature"] = "4";
				var propertyManagementOfficeDto = $('#propertyManagementOfficeDto_form').serializeObject();// 物业管理处
				var propertyServeDto = $('#propertyServeDto_form')
				.serializeObject();// 物业服务
				unitInfoDto.unitAddress=unitInfoDto.unitAddress+unitInfoDto.address
				var data = {
						"unitInfoDto" : unitInfoDto,
						"propertyManagementOfficeDto" : propertyManagementOfficeDto,
						"propertyServeDto" : propertyServeDto
				};
				$.ajax({
					contentType : "application/json; charset=utf-8",
					dataType : "JSON",
					url : "/managementinformation/add",
					type : "POST",
					data : JSON.stringify(data),
					success : function(data) {
						if (data.status == 200) {
							toastr.success(data.msg);
							// 返回父页面
							//history.go(-1);
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
		}else{
			$("#submit").prop("disabled","disabled")
		}
	});
	$("input,textarea,select").on("blur", function(){
		var flag;
		$(".item").each(function() {
			var str=$(this).attr("class")
			var lastIndex = str.lastIndexOf(' ');
			var lastStr = str.substring(lastIndex + 1);		
			if(lastStr=='has-success'){
				flag=true;
				}else{					
				return flag=false;
				} 
		});
	if(flag){
		$("#submit").removeAttr("disabled");
	}
	});
});
