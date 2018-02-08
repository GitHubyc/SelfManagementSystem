$(function() {
	$('table tr').click(function(){
		$('table tr').each(function(){
			$(this).removeClass("success");
		});
	 	$(this).addClass("success");
	 	$('.Group_right').attr("id",$(this).find(' > td > a').attr('id'));
	});
	
	$("#Group_add").click(function(){
		getIframe('/group/add');
	});
	$(".Group_del").each(function(index){
		$(this).on("click",function(){
	    	if($(this).attr('id')){
	        	var data = $(this).attr('id');
	        	getdel("/group/del?groupId="+data,"DELETE",data);
	        }else{
	    		layer.alert('请点击组');
	    	}
	    });
	});
	$(".Group_edit").click(function(){	
		getIframe('/group/edit?groupId=' + $(this).attr('id'));
	});
	$(".Group_details").click(function(){	
		getIframe('/group/details?groupId=' + $(this).attr('id'));
	});
	$(".Group_edit_role").click(function(){	
		if($(this).attr('id')){
			getIframe('/group/role?groupId=' + $(this).attr('id'));	
		}else{
			layer.alert('请点击组');
		}
	});
	$(".Group_right").click(function(){	
		getIframe('/group/right?groupId=' + $(this).attr('id'));	
	});
	$(".Group_edit_user").click(function(){	
		getIframe('/group/edit/user');	
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
	 	    		toastr.error(data.msg)
	 	    	}
	 		});	
		});	 
}
//$('.fa-users').click(function(){
//	var type = $(this).attr("href");
//	if(type=="javascript:(0)"){
//		layer.alert('请点击组');
//	}
//});
//$('.fa-user').click(function(){
//	var type = $(this).attr("href");
//	if(type=="javascript:(0)"){
//		layer.alert('请点击组');
//	}
//});