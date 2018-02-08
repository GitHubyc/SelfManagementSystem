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

$("table tbody").find("tr").each(function(){
    var tdArr = $(this).children();
    var arr1=[];
    var actionMethod = tdArr.eq(5).text();//动作方式   
	var arr = new Array();
	arr = actionMethod.split(',');
	for (var i = 0; i < arr.length; i++) {
		if(arr[i]==1){
			arr1.push('联动控制');
		}else if(arr[i]==2){
			arr1.push('手动控制');
		}else if(arr[i]==3){
			arr1.push('消防控制室控制');	
		}
	}
	tdArr.eq(5).text(arr1.toString());
});

var pathname = window.location.pathname;
if(pathname=="/build/details"){
	$(".pull-right").remove();
	$(".table .btn-red,.table .btn-blue").remove();
}else{
	$(".table .btn-yellow").remove();
}