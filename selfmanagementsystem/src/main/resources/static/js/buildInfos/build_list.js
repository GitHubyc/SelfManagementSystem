//删除
function del(url) {
	getdel(url)
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

$('.list_table_row  .row_num2').bind({
	  mouseover:function(){$(this).find("h1").addClass("font_white");},  
	  mouseout:function(){$(this).find("h1").removeClass("font_white");}  
	
});