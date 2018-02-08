$(function() {
	$('table tr').click(function() {
		$('table tr').each(function() {
			$(this).removeClass("success");
		});
		$(this).addClass("success");
	});
	$("#User_add").click(function(){
		getIframe('/user/add');
	});
	$(".User_del").each(function(index){
	    $(this).on("click",function(){
	    	var data = $(this).attr('id');
	    	getdel("/user/del?userId="+data,"DELETE",data);
	    });
	});
	$(".User_edit").click(function(){	
		getIframe('/user/edit?userId='+$(this).attr('id'));	
	});
	$(".User_details").click(function(){	
		getIframe('/user/details?userId='+$(this).attr('id'));
	});
	$(".User_right").click(function(){
		getIframe('/user/right?userId='+$(this).attr('id'));
	});
	$(".User_group").click(function(){
		getIframe('/user/group?userId='+$(this).attr('id'));
	});
	$(".User_role").click(function(){
		getIframe('/user/role?userId='+$(this).attr('id'));
	});
	// 点击图片变大图
	$('.list_icon').each(function(index) {
		$(this).on("click", function() {
			layer.open({
				type : 1,
				title : false,
				closeBtn : 0,
				area : '521px',
				skin : 'layui-layer-nobg', // 没有背景色
				shadeClose : true,
				content : $(".img_show").eq(index)
			});
		});
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
						setTimeout(function(){
	     		    		window.parent.location.reload();
	     		    	},500);
					} else {
						toastr.error(data.msg);
						setTimeout(function(){
	     		    	},500);
					}
				},
				error : function(data) {
					toastr.error('服务无响应')
				}
	 		});	
		});	 
}
function judgeAuthority(){  
    $.ajax({  
        type: "post",  
        url: "/session",  
        contentType: 'application/json;charset=utf-8',  
        success: function (data) {  
            for(var i=0;i<data.length;i++){  
                if(data[i]=="超级管理员"){  
                    $(".admin").css("display","block");  
                } 
                if(data[i]=="管理处"){  
                    $(".management").css("display","block");  
                } 
            }  
        }  
    })  
} 