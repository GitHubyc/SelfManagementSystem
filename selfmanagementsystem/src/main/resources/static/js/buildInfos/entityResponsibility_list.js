//删除
function del(url) {
	getdelete(url)
}

var pathname = window.location.pathname;
if(pathname=="/build/details"){
	$(".pull-right").remove();
	$(".table .btn-red,.table .btn-blue").remove();
}else{
	$(".table .btn-yellow").remove();
}

