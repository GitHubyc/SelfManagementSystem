$(function(){
	var unitCode = $("#continer2").attr("value");
	var type = $("#continer3").attr("value");
	var departmentobject = $("#continer4").val();
	// 切换员工列表tab
	$('.x_top_yg a').click(function() {
		var index = $(this).index();
		var value=$(this).attr('id');
		$("[name='type']").val(value);	
		page(1);

	});
//按钮事件
$("#Employee_add").click(function(){
	if(departmentobject=="null"){
		layer.alert('对不起，您还没添加部门！')
	}else{
	getIframe("/employee/add?unitCode="+unitCode+"&type="+type);}
});
$(".UnitEmployee_del").each(function(index){
    $(this).on("click",function(){
    	var json = $(this).attr('id');
        var obj = eval('(' + json + ')');
        var departmentCode = obj.departmentCode;
        var employeeCode = obj.employeeCode;
        getdel('/unit/'+unitCode+'/unitDepartment/'+departmentCode+'/unitEmployee/'+employeeCode, unitCode, type);
    });
});
$(".UnitEmployee_edit").each(function(num){
	 $(this).on("click",function(){
	    	var json = $(this).attr('id');
	        var obj = eval('(' + json + ')');
	        var departmentCode = obj.departmentCode;
	        var employeeCode = obj.employeeCode;
	    	getIframe('/edit/'+unitCode+'/unitDepartment/'+departmentCode+'/unitEmployee/'+employeeCode+'?type='+type);
	    });
});
$(".UnitEmployee_detail").each(function(num){
    $(this).on("click",function(){
    	var json = $(this).attr('id');
        var obj = eval('(' + json + ')');
        var departmentCode = obj.departmentCode;
        var employeeCode = obj.employeeCode;
    	getIframe('/unit/'+unitCode+'/unitDepartment/'+departmentCode+'/Employee/'+employeeCode);
    });
});
//公用方法
function getIframe(url){
	var index = layer.open({
		  type: 2,
		  content: url,
		  area: ['1024px', '768px'],
		  maxmin: true ,
		  scrollbar: false
		});
}
function getdel(url, unitCode, type){
	layer.confirm('是否确定删除？', {
		  btn: ['确定','取消'] //按钮
		}, function(index){
			layer.close(index);
			$.ajax({
	 		    url:url,
	 		    type: "DELETE",	
	 		    contentType: "application/json; charset=utf-8",
	 	        dataType: "json",
	 	       success: function(data) {
   		    	if (data.status == 200) {
   						setTimeout(function() {
   							index = parent.layer
   									.getFrameIndex(window.name);
   							parent.layer.close(index);
   							$("#ok").load("/employee/list?unitCode="+unitCode+"&type="+type);
   						}, 500);
   	     		    	toastr.success(data.msg)
   	     		    	} else {
   							toastr.error(data.msg);
   						}
   		    },
   		    error:function(data){
   			toastr.error("服务器无响应")
   		}
	 		});	
		});	 
}
})
