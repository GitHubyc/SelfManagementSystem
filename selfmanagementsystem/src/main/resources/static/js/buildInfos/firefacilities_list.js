// 切换建筑防火设施的类型tab
$('.box_tab_jz li').bind(
		{
			click : function() {
				var index = $(this).index();
				$(this).addClass("bg_blue").siblings().removeClass("bg_blue");
				$(this).siblings().find('span').removeClass("bg_y1").addClass(
						"bg_y");
				$(".col_right_tb .content_row").each(
						function() {
							$(".col_right_tb .content_row").eq(index).show(200)
									.addClass("on").siblings(".content_row")
									.hide().removeClass("on");
						});
			},
			mouseover : function() {
				var flag = $(this).attr("class");
				if (flag != "bg_blue") {
					$(this).find("span").addClass("bg_y1")
					$(this).find("span").removeClass("bg_y");
				}
			},
			mouseout : function() {
				var flag = $(this).attr("class");
				if (flag != "bg_blue") {
					$(this).find("span").addClass("bg_y")
					$(this).find("span").removeClass("bg_y1");
				}

			}
		});

var url = $(".box_tab_jz .bg_blue").attr("data-url"); 
var title =$(".bg_blue").find('font').text(); 
title = $.trim(title); 
$(".on").load(getTypeUrl(url, title));

$('.box_tab_jz li').on('click', function() {
	var url = $(this).attr("data-url");
	var title = $(this).find('font').text();
	title = $.trim(title);
	$(".on").load(getTypeUrl(url, title));
});


var pathname = window.location.pathname;
if(pathname=="/build/details"||pathname=="/buildManagement/list"){
	$(".col_left_menu a").remove();
}

 


