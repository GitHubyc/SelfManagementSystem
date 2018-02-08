//删除
function del(url) {
	layer.confirm('是否确定删除？', {
		btn : [ '确定', '取消' ]
	// 按钮
	}, function(index) {
		layer.close(index);
		$.ajax({
			url : url,
			type : "DELETE",
			contentType : "application/json; charset=utf-8",
			dataType : "json",
			success : function(data) {
				if (data.status == 200) {
					toastr.success(data.msg)
					setTimeout(function() {
						var url = $(".bg_blue").attr("data-url");
						var title = $(".bg_blue").find('font').text();
						title = $.trim(title);
						parent.$(".on").load(getTypeUrl(url, title));
					}, 500);
				} else {
					toastr.error(data.msg)
				}
			},
			error : function() {
				toastr.error('服务无响应')
			}
		});
	});
}

var pathname = window.location.pathname;
if(pathname=="/build/details"){
	$(".pull-right").remove();
	$(".table .btn-red,.table .btn-blue").remove();
}else{
	$(".table .btn-yellow").remove();
}