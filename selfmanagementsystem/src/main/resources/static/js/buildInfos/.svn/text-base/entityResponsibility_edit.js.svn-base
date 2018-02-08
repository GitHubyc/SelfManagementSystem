$(function() { //文档加载，执行一个函数
	$('#EntityResponsibility').bootstrapValidator({
		message : 'This value is not valid',
		live : 'enabled',
		trigger : 'blur keyup',
		feedbackIcons : {//input状态样式图片
			valid : 'glyphicon ',
			invalid : 'glyphicon ',
			validating : 'glyphicon'
		},
		container : 'popover',
		fields : {//验证：规则           	
			responsibilityType : {
				message : '责任类型无效',
				validators : {
					notEmpty : {
						message : '责任类型不能为空'
					}
				}
			},
			responsibilityPerson : {
				message : '责任人无效',
				validators : {
					notEmpty : {
						message : '责任人不能为空'
					}
				}
			},

			responsibilityUnit : {
				message : '责任单位无效',
				validators : {
					notEmpty : {
						message : '责任单位不能为空'
					}
				}
			},
			contactNumber : {
				message : '手机号码无效',
				trigger : 'blur',
				validators : {
					notEmpty : {
						message : '手机号码不能为空'
					},
					stringLength : {
						min : 11,
						max : 11,
						message : '请输入11位手机号码'
					},
					regexp : {
						regexp : /^1[3|5|8]{1}[0-9]{9}$/,
						message : '请输入正确的手机号码'
					}
				}
			},
			responsibilityRepresent : {
				message : '责任代表无效',
				validators : {
					notEmpty : {
						message : '责任代表不能为空'
					}
				}
			},
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
					var t = $('#EntityResponsibility').serializeArray();
					$.each(t, function() {
						data[this.name] = this.value;
					});

					// 使用Ajax提交form表单数据

					$.ajax({
						url : "/entityresponsibility/edit?buildCode="+getUrlParam("buildCode")+"&responsibilityCode="+getUrlParam("responsibilityCode"),
						type : 'put',
						contentType : "application/json; charset=utf-8",
						data : JSON.stringify(data),
						dataType : "json",
						timeout : 3000, //超时时间
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
									var href = parent.$(".x_top1 .btn-color")
											.attr("href");
									parent.$("#ok").load(href);
								}, 500);
								toastr.success(data.msg)
							} else {
								toastr.error(data.msg);
							}

						},
						error : function(data) {
							toastr.error("服务器无响应")
						}
					});
				}

			});

});

//获取链接参数
function getUrlParam(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
	var r = window.location.search.substr(1).match(reg); //匹配目标参数
	if (r != null)
		return encodeURI(r[2]);
	return null; //返回参数值
}
