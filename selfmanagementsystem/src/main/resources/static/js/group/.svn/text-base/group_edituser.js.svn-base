$(function(){
	$(".User_details").click(function(){	
		getIframe('/user/details?groupId='+$(this).attr('id'));
	});
	// 点击图片变大图
	$('.list_icon').each(function(index) {
		$(this).on("click", function() {
			layer.open({
				type : 1,
				title : false,
				closeBtn : 0,
				area : '521px',
				skin : 'layui-layer-nobg', // 没有背景色
				shadeClose : true,
				content : $(".img_show").eq(index)
			});

		});
	});
})
//公用方法
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
