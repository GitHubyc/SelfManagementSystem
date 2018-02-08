$(function(){
//离开检测表单是否
$("a[name='a']").on('click', function(e) {   
	 var index = $(this).index();
	 e.preventDefault(); // 阻止链接跳转
	 var type = $(this).attr("id");
	 var unitCode = $("#continer2").attr("value");
	 // 保存点击的地址
	 $("#ok").load("/keyPersonnel/list?unitCode="+unitCode+"&type="+type);
});
//按钮事件
$("#Employee_add").click(function(){
	var unitCode = $("#continer2").attr("value");
	var type = $("#continer3").attr("value");
	getIframe("/employee/add?unitCode="+unitCode+"&type="+type);
});
$(".UnitEmployee_del").each(function(index){
    $(this).on("click",function(){
    	var json = $(this).attr('id');
        var obj = eval('(' + json + ')');
        var unitCode = obj.unitCode;
        var departmentCode = obj.departmentCode;
        var employeeCode = obj.employeeCode;
        var type = $("#continer3").attr("value");
        getdel('/unit/'+unitCode+'/unitDepartment/'+departmentCode+'/unitEmployee/'+employeeCode, unitCode, type);
    });
});
$(".UnitEmployee_edit").each(function(num){
	 $(this).on("click",function(){
	    	var json = $(this).attr('id');
	        var obj = eval('(' + json + ')');
	        var unitCode = obj.unitCode;
	        var departmentCode = obj.departmentCode;
	        var employeeCode = obj.employeeCode;
	        var type = $("#continer3").attr("value");
	    	getIframe('/edit/'+unitCode+'/unitDepartment/'+departmentCode+'/unitEmployee/'+employeeCode+'?type='+type);
	    });
});
$(".UnitEmployee_detail").each(function(num){
    $(this).on("click",function(){
    	var json = $(this).attr('id');
        var obj = eval('(' + json + ')');
        var unitCode = obj.unitCode;
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
	//layer.full(index);
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
   	     		    // 重新加载
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
