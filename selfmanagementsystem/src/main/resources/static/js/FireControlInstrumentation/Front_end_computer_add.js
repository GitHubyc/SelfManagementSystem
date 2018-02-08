$(function() {
	// 提交按钮
	$("#submit").click(
			function(e) {
				e.preventDefault();
				layer.confirm('是否确定提交？', {
					btn : [ '确定', '取消' ]
				}, function(index) {
					layer.close(index);
					var form = $('#form').serializeObject();
					$.ajax({
						contentType : "application/json; charset=utf-8",
						dataType : "JSON",
						url : "/front_end_computer",
						type : "POST",
						data : JSON.stringify(form),
						success : function(data) {
							if (data.status == 200) {
								toastr.success(data.msg);
								// 刷新父页面
								setTimeout(function() {
									index = parent.layer
											.getFrameIndex(window.name);
									parent.layer.close(index);
								}, 500);
								$("#front_end_computer", window.parent.document)
										.load("/front_end_computer/list");
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