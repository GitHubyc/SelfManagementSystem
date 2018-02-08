$(function() {
	$('table tr').click(function(){
		$('table tr').each(function(){
			$(this).removeClass("success");
		});
	 	$(this).addClass("success");
	});
	
	
	$("#Role_add").click(function(){
		getIframe('/role/add');
	});
	$(".Role_del").each(function(index){
	    $(this).on("click",function(){
	    	if($(this).attr('id')){
	        	var data = $(this).attr('id');
	        	getdel("/role/del?roleId="+data,"DELETE",data);
	        }
	    });
	});
	$(".Role_edit").click(function(){	
		getIframe('/role/edit?roleId='+$(this).attr('id'));	
	});
	$(".Role_details").click(function(){	
		getIframe('/role/details?roleId='+$(this).attr('id'));
	});
	$(".Role_right").click(function(){	
		getIframe('/role/right?roleId=' + $(this).attr('id'));
	});
})
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
function getdel(url,type,data){
	layer.confirm('是否确定删除？', {
		  btn: ['确定','取消'] //按钮
		}, function(index){
			layer.close(index);
			$.ajax({
	 		    url: url,
	 		    type: type,	
	 		    contentType: "application/json; charset=utf-8",
	 	        data: JSON.stringify(data),
	 	        dataType: "json",
	 	       success : function(data) {
					if (data.status == 200) {
						toastr.success(data.msg);
						// 刷新父页面
						setTimeout(function(){
	     		    		window.parent.location.reload();
	     		    	},500);
					} else {
						toastr.error(data.msg);
						setTimeout(function(){
	     		    		window.parent.location.reload();
	     		    	},500);
					}
				},
				error : function(data) {
					toastr.error('服务无响应')
				}
	 		});	
		});	 
}
