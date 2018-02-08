//删除
function del(url) {
	getdelete(url)
}
$(function() {
	var house = $(".on #house").attr("data-url");
	$(".on #house").load(house);
	var keysite = $(".on #keysite").attr("data-url");
	$(".on #keysite").load(keysite);
});

var pathname = window.location.pathname;
if (pathname == "/build/details" || pathname == "/buildManagement/list") {
	$(".pic .text-right,.pic  .text-left").remove();
}

$('.Img').click(function(){
	var str = $(this).attr('src')
	var str1 = str.replace("_normal", "");
	if(str!="../img/noimage.png"){
	var div = '<div style="width: 516px;"><img width="100%" height="100%"  class="cloudzoom" src="' + str
			+ '" data-cloudzoom="' + "zoomSizeMode:'image',zoomImage: '" + str1
			+ "',autoInside: 30" + '" /></div>'
	layer.open({
		type : 1,
		title : false,
		closeBtn : 0,
		area : '516px',
		shadeClose : true,
		scrollbar : false,
		skin : 'layui-layer-nobg', // 没有背景色
		content : div,
		zIndex : '1',
		success : function(layero, index) {
			setTimeout(function() {
			CloudZoom.quickStart();
			}, 500);
		}
	});
	}
});
