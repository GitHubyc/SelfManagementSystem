//切换tab
$('.x_top1 .btn-blue').click(
		function() {
			var index = $(this).index();
			$(this).addClass("btn-color").siblings().removeClass("btn-color");
			$(".x_panel .c_content").each(
					function() {
						$(".x_panel .c_content").eq(index).show().attr("id",
								"ok").siblings(".c_content").hide().removeAttr(
								"id");
					});
		});

var url = $('.x_top1 .btn-color').attr("href");
$("#ok").load(url);
$('.x_top1 a').on('click', function(e) {
	var index = $(this).index();
	e.preventDefault(); // 阻止链接跳转
	var url = this.href; // 保存点击的地址
	if (url) {
		$("#ok").load(url);
	}
});

