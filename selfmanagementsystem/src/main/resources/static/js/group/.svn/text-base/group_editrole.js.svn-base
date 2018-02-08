$(function() {
	$('table tr').click(function() {
		$('table tr').each(function() {
			$(this).removeClass("success");
		});
		$(this).addClass("success");
		$('.Role_right').attr("id", $(this).find(' > td > a').attr('id'));
	});
	$(".Group_addrole").click(function(){
		getIframe('/group/addrole?groupId='+$(this).attr('id'));
	});
	$(".Role_details").click(function(){	
		getIframe('/role/details?groupId='+$(this).attr('id'));
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
		 	    		    		parent.layer.closeAll('iframe');
		 	    		    		window.parent.location.reload();
		 	    		    	},500);
		 	    		} else {
		 	    			toastr.error(data.msg);
		 	    		}
		 	    	},
		 	    	error : function(data) {
		 	    		toastr.error('服务无响应')
		 	    	}
		 		});	
			});	 
	}
})

