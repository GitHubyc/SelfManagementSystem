var text1 = $("[name='buildAddress']").attr("placeholder");
$(function() { // 文档加载，执行一个函数
	$('#BuildInfo').bootstrapValidator({
		message : 'This value is not valid',
		live : 'enabled',
		trigger : 'blur',
		excluded : [ ':disabled', ':hidden', ':not(:visible)' ],
		feedbackIcons : {// input状态样式图片
			valid : 'glyphicon ',
			invalid : 'glyphicon',
			validating : 'glyphicon'
		},
		container : 'popover',
		fields : {// 验证：规则
			plcBuildCode : {// 验证input项：验证规则
				message : '编码号无效',
				validators : {
					notEmpty : {// 非空验证：提示消息
						message : '规土委建筑编号不能为空'
					},
					stringLength : {
						min : 19,
						max : 19,
						container : 'popover',
						message : '编码号长度必须19位'
					},
					regexp : {
						regexp : /^[0-9]+$/,
						message : '编码号必须为数字'
					}
				}
			},
			buildName : {
				message : '建筑名称无效',

				validators : {
					notEmpty : {
						message : '建筑名称不能为空'
					},
					stringLength : {
						min : 4,
						message : '建筑名称长度必须在4字符以上'
					}
				}

			},
			buildAddress : {
				message : '建筑地址无效',

				validators : {
					notEmpty : {
						message : '建筑地址不能为空'
					},
					callback : {
						message : '建筑地址不能为空',
						callback : function(value, validator) {

							if (text1 == value) {
								return false;
							} else {
								return true;
							}

						}
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
			buildStatus : {
				validators : {
					notEmpty : {
						message : '建筑情况不能为空'
					}
				}
			},
			completedDate : {
				validators : {
					notEmpty : {
						message : '竣工日期不能为空'
					},
					date : {
						format : 'YYYY-MM-DD',
						message : '编辑格式-YYYY-MM-DD'
					}
				}
			},
			propertyRightAndUse : {
				validators : {
					notEmpty : {
						message : '建筑产权及使用情况不能为空'
					}
				}
			},
			maximumCapacity : {
				message : '最大容纳人数无效',

				validators : {
					notEmpty : {
						message : '最大容纳人数不能为空'
					},
					regexp : {
						regexp : /^[0-9]+$/,
						message : '必须为数字'
					}
				}
			},
			controlRoomLocation : {
				message : '消防控制室位置无效',

				validators : {
					notEmpty : {
						message : '消防控制室位置不能为空'
					}
				}
			},
			floorSpace : {
				message : '占地面积无效',

				validators : {
					notEmpty : {
						message : '占地面积不能为空'
					},
					regexp : {
						regexp : /^\d+(\.\d+)?$/,
						message : '必须为数字'
					}
				}
			},

			standardFloorSize : {
				message : '标准层面积无效',

				validators : {
					notEmpty : {
						message : '标准层面积不能为空'
					},
					regexp : {
						regexp : /^\d+(\.\d+)?$/,
						message : '必须为数字'
					}
				}
			},

			buildingArea : {
				message : '建筑面积无效',

				validators : {
					notEmpty : {
						message : '建筑面积不能为空'
					},
					regexp : {
						regexp : /^\d+(\.\d+)?$/,
						message : '必须为数字'
					}
				}
			},
			groundArea : {
				message : '地上面积无效',

				validators : {
					notEmpty : {
						message : '地上面积不能为空'
					},
					regexp : {
						regexp : /^\d+(\.\d+)?$/,
						message : '必须为数字'
					}
				}
			},

			undergroundArea : {
				message : '地下面积无效',

				validators : {
					notEmpty : {
						message : '地下面积不能为空'
					},
					regexp : {
						regexp : /^\d+(\.\d+)?$/,
						message : '必须为数字'
					}
				}
			},

			buildingHeight : {
				message : '建筑高度无效',

				validators : {
					notEmpty : {
						message : '建筑高度不能为空'
					},
					regexp : {
						regexp : /^\d+(\.\d+)?$/,
						message : '必须为数字'
					}
				}
			},

			groundLayerNumber : {
				message : '地上层数无效',

				validators : {
					notEmpty : {
						message : '地上层数不能为空'
					},
					regexp : {
						regexp : /^\d+(\.\d+)?$/,
						message : '必须为数字'
					},
					lessThan : {
						inclusive : true,
						value : 300,
						message : '请输入小于300的数字'
					}
				}
			},

			undergroundLayerNumber : {
				message : '地下层数无效',

				validators : {
					notEmpty : {
						message : '地下层数不能为空'
					},
					lessThan : {
						inclusive : true,
						value : 10,
						message : '请输入小于10的数字'
					},
					regexp : {
						regexp : /^[0-9]+$/,
						message : '必须为数字'
					}
				}
			},

			refugeFloorArea : {
				message : '避难层面积无效',

				validators : {
					notEmpty : {
						message : '避难层面积不能为空'
					},
					regexp : {
						regexp : /^\d+(\.\d+)?$/,
						message : '必须为数字'
					}
				}
			},
			refugeFloorNumber : {
				message : '避难层数量无效',

				validators : {
					notEmpty : {
						message : '避难层数量不能为空'
					},
					regexp : {
						regexp : /^\d+(\.\d+)?$/,
						message : '必须为数字'
					}
				}
			},

			'refugeFloorLocation' : {
				message : '避难层位置无效',
				validators : {
					notEmpty : {
						message : '避难层位置不能为空'
					}
				}
			},

			fireElevatorNumber : {
				message : '消防电梯数量无效',

				validators : {
					notEmpty : {
						message : '消防电梯数量不能为空'
					},
					regexp : {
						regexp : /^[0-9]+$/,
						message : '必须为数字'
					}
				}
			},

			fireElevatorLocation : {
				message : '消防电梯位置无效',
				validators : {
					notEmpty : {
						message : '消防电梯位置不能为空'
					}
				}
			},

			buildClassify : {
				message : '建筑分类无效',
				validators : {
					notEmpty : {
						message : '建筑分类不能为空'
					}
				}
			},

			'buildUse' : {
				message : '建筑用途无效',
				validators : {
					notEmpty : {
						message : '建筑用途不能为空'
					}
				}
			},

			buildStructure : {
				message : '建筑结构无效',
				validators : {
					notEmpty : {
						message : '建筑结构不能为空'
					}
				}
			},

			fireResistanceRating : {
				message : '耐火等级无效',
				validators : {
					notEmpty : {
						message : '耐火等级不能为空'
					}
				}
			},

			adjacentBuildings : {
				message : '毗邻建筑情况无效',
				validators : {
					notEmpty : {
						message : '毗邻建筑情况不能为空'
					}
				}
			},

			xzqhCode : {
				message : '区划编号无效',
				validators : {
					notEmpty : {
						message : '区划编号不能为空'
					},
					regexp : {
						regexp : /^[0-9]+$/,
						message : '必须为数字'
					},
					stringLength : {
						min : 2,
						message : '编码长度必须大于1位'
					}
				}
			},

			isControlRoom : {
				message : '消防控制室情况无效',
				validators : {
					notEmpty : {
						message : '消防控制室情况不能为空'
					},
					regexp : {
						regexp : /^[0-9]+$/,
						message : '必须为数字'
					}
				}
			},

			gtwLon : {
				message : '入规土委经度无效',
				validators : {
					notEmpty : {
						message : '入规土委经度不能为空'
					},
					regexp : {
						regexp : /^[0-9]+$/,
						message : '必须为数字'
					}
				}
			},

			gtwLat : {
				message : '规土委纬度无效',
				validators : {
					notEmpty : {
						message : '规土委纬度不能为空'
					},
					regexp : {
						regexp : /^[0-9]+$/,
						message : '必须为数字'
					}
				}
			},

			bdLon : {
				message : '百度经度无效',
				validators : {
					notEmpty : {
						message : '百度经度不能为空'
					},
					regexp : {
						regexp : /^[0-9]+$/,
						message : '必须为数字'
					}
				}
			},

			buildImage : {
				validators : {
					notEmpty : {
						message : '文件不能为空'
					}
				}
			},

			bdLat : {
				message : '百度纬度无效',
				validators : {
					notEmpty : {
						message : '百度纬度不能为空'
					},
					regexp : {
						regexp : /^[0-9]+$/,
						message : '必须为数字'
					}
				}
			},

		}
	}).on(
			'success.form.bv',
			function(e) {// 点击提交之后
				// Prevent form submission
				e.preventDefault();

				// Get the form instance
				var $form = $(e.target);

				// Get the BootstrapValidator instance
				var bv = $form.data('bootstrapValidator');

				if (bv.isValid()) {
					var data = {};
					var buildUse = new Array();
					var refugeFloorLocation = new Array();
					var t = $('#BuildInfo').serializeArray();
					$.each(t, function() {
						if (this.name == "buildUse") {
							buildUse.push(this.value);
							data[this.name] = buildUse.toString();
						} else if (this.name == "refugeFloorLocation") {
							refugeFloorLocation.push(this.value);
							data[this.name] = refugeFloorLocation.toString();
						} else if (this.name == "buildAddress") {
							data['buildAddress'] = $(
									"#BuildInfo [name='address']").val()
									+ this.value;

						} else {
							data[this.name] = this.value;
						}
					});
					data['buildImage'] = $("#BuildInfo [name='buildImage']").val();
					layer.confirm('是否确定提交？', {
						btn : [ '确定', '取消' ]
					// 按钮
					}, function(index) {
						layer.close(index);
						// 使用Ajax提交form表单数据
						$.ajax({
							url : "/build/add",
							type : "post",
							contentType : "application/json; charset=utf-8",
							data : JSON.stringify(data),
							dataType : "json",
							success : function(data) {
								if (data.status == 200) {
									$(window).unbind('beforeunload');
									toastr.success(data.msg)
									window.location.replace("/build/list");
								} else {
									toastr.error(data.msg)
								}
							},
							error : function(data) {
								toastr.error("服务器无响应")
							}
						});
					});

				}

			});
});
$("#BuildInfo :input[name='groundLayerNumber']").focus(function() {
	$("#BuildInfo :input[name='refugeFloorShow']").removeAttr("disabled");
});

// input显示避难层数
$("#BuildInfo :input[name='refugeFloorShow']")
		.focus(
				function() {

					$(this).attr("disabled", "disabled");
					var a = $("#BuildInfo :input[name='groundLayerNumber']")
							.val();

					if (a > 300) {
						layer.alert('你地上层数输入的值太大')
						a = 300;
						return;
					} else if (a == 0) {
						layer.alert('你地上层数输入的值不能空')
						return;
					}
					var $div;
					$div = '<div class="x_content form-horizontal"><div class="item form-group"><label class="text-left  col-lg-3 col-md-3 col-sm-3 col-xs-12 control-label" > 请选择避难层所在位置:</label>'
							+ '<div class="col-lg-9 col-md-9 col-sm-9 col-xs-12" style="padding-right: 40px;">';

					for (var i = 1; i <= a; i++) {
						var txt = '<div class="checkbox checkbox-inline"><input type="checkbox" name="refugeFloor" id="refugeFloorLocation'
								+ i
								+ '" value="'
								+ i
								+ '"><label for="refugeFloorLocation'
								+ i
								+ '">' + i + '层</label></div>';
						$div += txt;
					}
					$div += '</div></div></div>'

					layer
							.open({
								type : 1,
								area : [ '1024px', '720px' ],
								scrollbar : false,
								shadeClose : true, // 开启遮罩关闭
								content : $div,
								title : "信息(填写完关闭即可)",
								success : function(layero, index) {
									var str = $(
											"input[name='refugeFloorLocation']")
											.val();
									var arr = new Array();
									arr = str.split(',');
									for (key in arr) {
										if (arr[key] != "") {
											$("input[name='refugeFloor']").eq(
													arr[key] - 1).attr(
													"checked", "checked");
										}
									}
									$('[name="refugeFloor"]')
											.click(
													function() {
														text = $(
																'[name="refugeFloor"]:checkbox:checked')
																.map(
																		function(
																				index,
																				elem) {
																			return $(
																					elem)
																					.val();
																		})
																.get()
																.join(',');
														text1 = $(
																'[name="refugeFloor"]:checkbox:checked')
																.map(
																		function(
																				index,
																				elem) {
																			return $(
																					elem)
																					.val()
																					+ "层";
																		})
																.get()
																.join('、');
														// alert("选中的checkbox的值为："+text1);
														var arr = new Array();
														arr = text.split(',');
														parent
																.$(
																		"input[name='refugeFloorShow']")
																.val(text1);
														parent
																.$(
																		"input[name='refugeFloorLocation']")
																.val(text);
														parent
																.$(
																		"input[name='refugeFloorNumber']")
																.val(arr.length);
														parent
																.$(
																		"input[name='refugeFloorNumberShow']")
																.val(arr.length);
													});
								}
							});

				});


window.onbeforeunload = function() { 
	var value=$("input,select").val();
	if(value!=''){
   return '确认离开当前页面吗？未保存的数据将会丢失';
	}
}