$(function() {
	// 传感器类型
	$("#sel").change(function() {
		page("type=" + this.options[this.options.selectedIndex].value);
	});
	// 切换消防物联
	$('.list_box_tab .btn').click(function() {
		var index = $(this).index();
		$(this).addClass("btn-color").siblings().removeClass("btn-color");
		$(".list_box_row").eq(index).show(200).siblings().hide();
	});
})
/*
 * 项目根路径
 */
function getRootPath() {
	var curWwwPath = window.document.location.href;
	var pathName = window.document.location.pathname;
	var pos = curWwwPath.indexOf(pathName);
	var localhostPath = curWwwPath.substring(0, pos);
	var projectName = pathName
			.substring(0, pathName.substr(1).indexOf('/') + 1);
	return (localhostPath);
}
/*
 * currentPage 页码 *data 检索的数据 param 参数 拼接在url后面的参数
 */
function page(param) {
	var data1 = serializeNotNull($("#form1").serialize());
	var url = getRootPath() + $("#form1").attr("action") + "?currentPage=1";
	if (data1 != null && data1 != '') {
		url += "&" + data1;
	}

	url += "&" + param;
	// 重新加载页面
	window.location.href = url;
}

/*
 * *去掉为空的参数
 */
function serializeNotNull(serStr) {
	return serStr.replace(/\s/g, "").replace(/\+/g, "").split("&").filter(
			function(str) {
				return !str.endsWith("=")
			}).join("&");
}