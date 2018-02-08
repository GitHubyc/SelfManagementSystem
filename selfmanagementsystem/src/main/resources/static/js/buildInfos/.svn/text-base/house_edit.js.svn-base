$(function() { // 文档加载，执行一个函数
	$('#HouseInfo').bootstrapValidator({
		message : 'This value is not valid',
		live : 'enabled',
		trigger : 'blur keyup',
		feedbackIcons : {// input状态样式图片
			valid : 'glyphicon ',
			invalid : 'glyphicon',
			validating : 'glyphicon'
		},
		container : 'popover',
		fields : {// 验证：规则
			houseNo : {
				message : '房屋号无效',
				validators : {
					notEmpty : {
						message : '房屋号不能为空'
					},
					regexp : {
						regexp : /^[0-9]+$/,
						message : '必须为数字'
					}
				}
			},
			houseUseStatus : {
				message : '房屋使用现状无效',
				validators : {
					notEmpty : {
						message : '房屋使用现状不能为空'
					}
				}
			},

			houseUseOtherStatus : {
				message : '房屋使用其它现状无效',
				validators : {
					notEmpty : {
						message : '房屋使用其它现状不能为空'
					},
					regexp : {
						regexp : /^[F,B]+$/,
						message : '请输入F和B'
					}
				}
			},
			remark : {
				message : '备注无效',
				validators : {
					notEmpty : {
						message : '备注不能为空'
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
					var t = $('#HouseInfo').serializeArray();
					$.each(t, function() {
						data[this.name] = this.value;
					});
					
					$.ajax({
						url : '/house/edit?buildCode=' + getUrlParam("buildCode") + '&floorCode='+ getUrlParam("floorCode") + '&houseCode='+ getUrlParam("houseCode"),
						type : 'put',
						contentType : "application/json; charset=utf-8",
						data : JSON.stringify(data),
						dataType : "json",
						timeout : 500, // 超时时间
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
									var url = parent.$(".on #house").attr(
											"data-url");
									parent.$(".on #house").load(url);
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
