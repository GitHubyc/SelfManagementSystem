//切换楼层信息tab
$('.list_col_c').eq(1).find("li").first().addClass("bg_blue");
$(".tab-content-lcxx").eq(0).show().addClass("on");  
var url =  $(".bg_blue").attr("data-url"); 
$(".on").load(url);

    $('.list_col_c li').on("click",function(){
    	var index = $(this).index();
    	var str=$(this).text();
    	str=str.substring(str.length-1);
    	if (str == "B") {
    		var length = $(".ds").find("li").length;
    		index+=length;
    	}

    	$(".list_col_c").find('li').removeClass("bg_blue")
    	$(this).addClass("bg_blue")
    	  $(".tab-content-lcxx").eq(index).show().addClass("on").siblings(".tab-content-lcxx").hide().removeClass("on").empty();
    });


$('.list_col_c li').on('click', function() {
	var index = $(this).index();
	var url = $(this).attr("data-url");
	if (url) {
		$(".on").load(url);
	}
});

function del(url) {
	getdelete(url)
}

//获取链接参数
function getUrlParam(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); // 构造一个含有目标参数的正则表达式对象
	var r = window.location.search.substr(1).match(reg); // 匹配目标参数
	if (r != null)
		return encodeURI(r[2]);
	return null; // 返回参数值
}

function ischecked(str) {
	var arr = new Array();
	arr = str.split(',');
	for (var i = 0; i < arr.length; i++) {
	$(".ds li").each(
			function(index) {	
					if (arr[i] == parseInt($(this).text())) {
						$(this).html($(this).text()+"<span class='icon-dian fa-plus-dian'></span></li>");	
						$(this).attr("data-toggle","tooltip");
						$(this).attr("data-placement","top");
						$(this).prop("title","此层为避难层");
						$('[data-toggle="tooltip"]').tooltip();
				}});}}
$('[data-toggle="tooltip"]').tooltip();


