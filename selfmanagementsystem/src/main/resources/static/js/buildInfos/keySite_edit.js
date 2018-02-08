$(function() { //文档加载，执行一个函数
	$('#KeySite').bootstrapValidator({
		message : 'This value is not valid',
		live : 'enabled',
		trigger : 'blur keyup',
		feedbackIcons : {//input状态样式图片
			valid : 'glyphicon',
			invalid : 'glyphicon',
			validating : 'glyphicon'
		},
		container : 'popover',
		fields : {//验证：规则           	
			keySiteName : {
				message : '重点部位名称无效',
				validators : {
					notEmpty : {
						message : '重点部位名称不能为空'
					}
				}
			},
			currentHeight : {
				message : '所在高度无效',
				validators : {
					notEmpty : {
						message : '所在高度不能为空'
					},
					regexp : {
						regexp : /^[0-9]+$/,
						message : '必须为数字'
					}
				}
			},

			useFunction : {
				message : '使用功能',
				validators : {
					notEmpty : {
						message : '使用功能不能为空'
					}
				}
			},

			buildStructure : {
				message : '建筑结构',
				validators : {
					notEmpty : {
						message : '建筑结构不能为空'
					}
				}
			},
			buildArea : {
				message : '建筑面积',
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
			securityExit : {
				message : '安全出口',
				validators : {
					notEmpty : {
						message : '安全出口不能为空'
					},
					regexp : {
						regexp : /^[0-9]+$/,
						message : '必须为数字'
					}
				}
			},
			fireElevator : {
				message : '消防电梯部数',
				validators : {
					notEmpty : {
						message : '消防电梯部数不能为空'
					},
					regexp : {
						regexp : /^[0-9]+$/,
						message : '必须为数字'
					}
				}
			},
			fireFacilitie : {
				message : '消防设施',
				validators : {
					notEmpty : {
						message : '消防设施不能为空'
					}
				}
			},
			manageMeasure : {
				message : '消防安全管理措施',
				validators : {
					notEmpty : {
						message : '消防安全管理措施不能为空'
					}
				}
			},
			personCharge : {
				message : '责任人',
				validators : {
					notEmpty : {
						message : '责任人不能为空'
					}
				}
			},
			fireMarkSetupSituation : {
				message : '防火标志设立情况',
				validators : {
					notEmpty : {
						message : '防火标志设立情况不能为空'
					},
					regexp : {
						regexp : /^[0-9]+$/,
						message : '必须为数字'
					}
				}
			},
			promptFireSigns : {
				message : '提示类消防标识',
				validators : {
					notEmpty : {
						message : '提示类消防标识不能为空'
					},
					regexp : {
						regexp : /^[0-9]+$/,
						message : '必须为数字'
					}
				}
			},
			banFireSigns : {
				message : '禁止类消防标识',
				validators : {
					notEmpty : {
						message : '禁止类消防标识不能为空'
					},
					regexp : {
						regexp : /^[0-9]+$/,
						message : '必须为数字'
					}
				}
			},
			fireResistanceRating : {
				message : '耐火等级',
				validators : {
					notEmpty : {
						message : '耐火等级不能为空'
					},
					regexp : {
						regexp : /^[0-9]+$/,
						message : '必须为数字'
					}
				}
			},
			fireSituation : {
				message : '火种情况',
				validators : {
					notEmpty : {
						message : '火种情况不能为空'
					}
				}
			},
			fireRisk : {
				message : '火灾危险性',
				validators : {
					notEmpty : {
						message : '火灾危险性不能为空'
					},
					regexp : {
						regexp : /^[0-9]+$/,
						message : '必须为数字'
					}
				}
			},
			'establishCause' : {
				message : '确立原因',
				validators : {
					notEmpty : {
						message : '确立原因不能为空'
					},
					regexp : {
						regexp : /^[0-9]+$/,
						message : '必须为数字'
					}
				}
			},
			'hazardSituation' : {
				message : '危险源情况',
				validators : {
					notEmpty : {
						message : '危险源情况不能为空'
					},
					regexp : {
						regexp : /^[0-9]+$/,
						message : '必须为数字'
					}
				}
			},
			cadX : {
				message : '三维X坐标',
				validators : {
					notEmpty : {
						message : '三维X坐标不能为空'
					},
					regexp : {
						regexp : /^[0-9]+$/,
						message : '必须为数字'
					}
				}
			},
			cadY : {
				message : '三维Y坐标',
				validators : {
					notEmpty : {
						message : '三维Y坐标不能为空'
					},
					regexp : {
						regexp : /^[0-9]+$/,
						message : '必须为数字'
					}
				}
			},
			cadZ : {
				message : '三维Z坐标',
				validators : {
					notEmpty : {
						message : '三维Z坐标不能为空'
					},
					regexp : {
						regexp : /^[0-9]+$/,
						message : '必须为数字'
					}
				}
			}
		}
	}).on(
			'success.form.bv',
			function(e) {//点击提交之后
				// Prevent form submission
				e.preventDefault();

				// Get the form instance
				var $form = $(e.target);

				// Get the BootstrapValidator instance
				var bv = $form.data('bootstrapValidator');
				if (bv.isValid()) {
					var data = {};
					var t = $('#KeySite').serializeArray();
					var establishCause = new Array();
					var hazardSituation = new Array();
					$.each(t, function() {
						if (this.name == "establishCause") {
							establishCause.push(this.value);
							data[this.name] = establishCause.toString();
						} else if (this.name == "hazardSituation") {
							hazardSituation.push(this.value);
							data[this.name] = hazardSituation.toString();
						} else {
							data[this.name] = this.value;
						}

					});
				
					
					// 使用Ajax提交form表单数据
					$.ajax({
						url : '/keysite/edit?buildCode=' + getUrlParam("buildCode") + '&floorCode='
								+ getUrlParam("floorCode") + '&keySiteCode='
								+ getUrlParam("keySiteCode"),
						type : "PUT",
						contentType : "application/json; charset=utf-8",
						data : JSON.stringify(data),
						dataType : "json",
						timeout : 1500, //超时时间
						beforeSend : function(XMLHttpRequest) {
							layer.load(1);
						},
						success : function(data) {
							if (data.status == 200) {
								// 重新加载
								setTimeout(function() {
									layer.closeAll('loading');
									index = parent.layer
											.getFrameIndex(window.name);
									parent.layer.close(index);
									var url = parent.$(".on #keysite").attr(
											"data-url");
									parent.$(".on #keysite").load(url);
								}, 500);
								toastr.success(data.msg)
							} else {
								toastr.error(data.msg)
							}
						},
						error : function(data) {
							toastr.error("服务器无响应")
						}

					});

				}

			});
});

//多选框判断
function ischecked(name, str) {
	var arr = new Array();
	arr = str.split(',');
	$("[name='" + name + "']").each(
			function(index) {
				for (var i = 0; i <= arr.length; i++) {
					if (arr[i] == $(this).val()) {
						$("[name='" + name + "']").eq(index).prop('checked',
								'checked');
					}
				}
			});
}