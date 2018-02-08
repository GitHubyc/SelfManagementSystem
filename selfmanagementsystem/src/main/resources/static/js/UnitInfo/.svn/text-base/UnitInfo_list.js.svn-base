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
						window.location.reload();
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

//行政单位查看
$(".Administrative_detail").click(function(){	
	getIframe('/administrativeUnit/edit/'+$(this).attr('id'));	
});

//事业单位查看
$(".Institution_detail").click(function(){	
	getIframe('/cause/edit/'+$(this).attr('id'));	
});

//查看企业单位
$(".EnterpriseUnit_detail").click(function(){	
	getIframe('/enter/edit/'+$(this).attr('id'));	
});

//查看物业管理处
$(".PropertyManagementOffice_detail").click(function(){	
	getIframe('/Property/edit/'+$(this).attr('id'));	
});

function getIframe(url){
	var index = layer.open({
		  type: 2,
		  content: url,
		  area: ['1024px', '768px'],
		  maxmin: true ,
		  scrollbar: false
		});
	//layer.full(index);
}

//点击图片变大图
$('.list_img').each(function(index) {
	$(this).on("click", function() {
		layer.open({
			type : 1,
			title : false,
			closeBtn : 0,
			area : '1000px',
			skin : 'layui-layer-nobg', // 没有背景色
			shadeClose : true,
			content : $(".img_show").eq(index)
		});

	});
});

