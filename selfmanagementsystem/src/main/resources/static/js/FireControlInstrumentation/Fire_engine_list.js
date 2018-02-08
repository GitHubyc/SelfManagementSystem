// 删除
function deleteById(id) {
	layer.confirm('是否确定删除？', {
		btn : [ '确定', '取消' ]
	}, function(index) {
		layer.close(index);
		$.ajax({
			contentType : "application/json; charset=utf-8",
			dataType : "JSON",
			url : "/fire_engine?id=" + id,
			type : "DELETE",
			success : function(data) {
				if (data.status == 200) {
					toastr.success(data.msg);
					// 刷新父页面
					setTimeout(function() {
						index = parent.layer.getFrameIndex(window.name);
						parent.layer.close(index);
					}, 500);
					$("#fire_engine", window.parent.document).load(
							"/fire_engine/list");
				} else {
					toastr.error(data.msg);
				}
			},
			error : function(data) {
				toastr.error('服务无响应')
			}
		});
	});
}
