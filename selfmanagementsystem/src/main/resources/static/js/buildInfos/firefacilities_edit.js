//关闭iframe

$('#closeIframe').click(function() {
	var data = [];
	$('input[name="facilitieType"]:checked').each(function() {
		var arr = {
			buildCode : getUrlParam("buildCode"),
			facilitieType : $(this).val(),
			facilitieName : $(this).siblings('label').text()
		}
		data.push(arr)
	});

	if(data==''){
		var arr = {
				buildCode : getUrlParam("buildCode"),
				facilitieType :null,
				facilitieName : null
			}
		data.push(arr)
	}
	layer.confirm('是否确定提交？', {
		btn : [ '确定', '取消' ]
	// 按钮
	}, function(index) {
		layer.close(index);
		// 使用Ajax提交
		$.ajax({
			url : "/firefacilities/setfire",
			type : "post",
			contentType : "application/json; charset=utf-8",
			data : JSON.stringify(data),
			dataType : "json",		
			success : function(data) {
				//刷新父页面	
					if (data.status == 200) {
						toastr.success(data.msg)
						setTimeout(function() {
						var aa = parent.layer.getFrameIndex(window.name); //获取窗口索引
						parent.layer.close(aa);
						}, 500);
						var href = parent.$(".x_top1 .btn-color").attr("href");
						parent.$("#ok").load(href);
					} else {
						toastr.error(data.msg)
					}
			
			},
			error : function(data) {
				toastr.error("服务器无响应")
			}
		});
	});

});


function ischecked(name, arr) {
	$("[name='" + name + "']").each(
			function(index) {
				for (var i = 0; i <= arr.length; i++) {
					if (arr[i] == $(this).val()) {
						$("[name='" + name + "']").eq(index).prop('checked',
								'checked');
					}
				}
			});
}
