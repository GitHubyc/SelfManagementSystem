

function getdel(url) {
	layer.confirm('是否确定删除？', {
		btn : [ '确定', '取消' ]
	//按钮
	}, function(index) {
		layer.close(index);
		$.ajax({
			url : url,
			type : "DELETE",
			contentType : "application/json; charset=utf-8",
			dataType : "json",
			success : function(data) {
				//刷新父页面
				setTimeout(function() {
					if (data.status == 200) {
						toastr.success(data.msg)
						window.parent.location.reload();
					} else {
						toastr.error(data.msg)
					}
				}, 500);

			},
			error : function() {
				toastr.error('服务无响应')
			}
		});
	});
}
