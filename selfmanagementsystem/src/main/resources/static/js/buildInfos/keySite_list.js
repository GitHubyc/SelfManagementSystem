var pathname = window.location.pathname;
if(pathname=="/build/details"||pathname=="/buildManagement/list"){
	$(".title_top a,.table .btn-red,.table .btn-blue").remove();
}else{
	$(".table .btn-yellow").remove();
}