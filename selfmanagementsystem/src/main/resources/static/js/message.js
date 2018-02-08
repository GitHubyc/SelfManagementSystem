

function getIframe(url) {
	var index = layer.open({
		type : 2,
		content : url,
		area : [ '1024px', '768px' ],
		maxmin : true,
		scrollbar : false
	});
	//layer.full(index);
}
function getdel(url) {
	layer.confirm('是否确定删除？', {
		btn : [ '确定', '取消' ]
	//按钮
	}, function(index) {
		layer.close(index);
		$.ajax({
			url : url,
			type : "DELETE",
			contentType : "application/json; charset=utf-8",
			dataType : "json",
			success : function(data) {
				//刷新父页面
				setTimeout(function() {
					if (data.status == 200) {
						toastr.success(data.msg)
						window.parent.location.reload();
					} else {
						toastr.error(data.msg)
					}
				}, 500);

			},
			error : function() {
				toastr.error('服务无响应')
			}
		});
	});
}

function getdelete(url){
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
	 		    	if(data.status==200){
         		    	toastr.success(data.msg)
         		   	var href=$(".x_top1 .btn-color").attr("href");	 		    		
	 		    		$("#ok").load(href);
	 		    		$(window).unbind('beforeunload');
         		    	}else{
         		    	toastr.error(data.msg)
         		    	}		    	 		    	
	 		    },
	 		    error:function(){
	 		    	toastr.error('服务无响应')
	 		}
	 		});	
		});	 
}
