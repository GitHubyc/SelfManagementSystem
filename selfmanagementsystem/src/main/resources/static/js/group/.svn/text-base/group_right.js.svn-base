$(function() {
	$("#continer1").toggle();
	var json = $("#continer1").attr('value');
	var obj = eval('(' + json + ')');
	var jsonData = obj;
	var ul = '<ul class="right_list_ul">' ;
    for(var i=0;i<jsonData.length;i++){
		 if(jsonData[i].rightId == $(".change")[0].id){
			 ul = ul + '<li class="treeli" id='
				+ jsonData[i].rightId
				+ '><i class="fa fa-folder-open"></i><div class="inline"><span class="checkbox checkbox-inline">\n<input type="checkbox" name='
				+ jsonData[i].biaosi + ' id=' + jsonData[i].rightId
				+ '><label for='+jsonData[i].rightId+'>'+jsonData[i].menuName+'</label></span></div></span><hr style="margin-top:5px;margin-bottom:5px;"></hr></li>';	 
		 }
	}
	ul = ul + createTree(jsonData,$(".change")[0].id) + '</ul>' ;
    $("#continer").append(ul) ;
    loads();
    //点击时清空原先数据，添加当前数据
    $(".change").each(function(){ 
        $(this).click(function(){
       	 var ul = '<ul class="right_list_ul">' ;
       	 var json = $("#continer1").attr('value');
       	 var obj = eval('(' + json + ')');
       	 var jsonData = obj;
       	 for(var i=0;i<jsonData.length;i++){
       		 if(jsonData[i].rightId == this.id){
       			ul = ul + '<li class="treeli" id='
				+ jsonData[i].rightId
				+ '><i class="fa fa-folder-open"></i><div class="inline"><span class="checkbox checkbox-inline">\n<input type="checkbox" name='
				+ jsonData[i].biaosi + ' id=' + jsonData[i].rightId
				+ '><label for='+jsonData[i].rightId+'>'+jsonData[i].menuName+'</label></span></div></span><hr style="margin-top:0px;margin-bottom:0px;"></hr></li>';		 
       		 }
       	 }
       	 ul = ul + createTree(jsonData,this.id) + '</ul>' ;
       	 $("#continer").html('');
         $("#continer").append(ul) ; 
         $('#Right_add').attr("value","0");
         loads();
       });
    });
    //验证
	$('#Group_addright').bootstrapValidator({
		message : 'This value is not valid',
		live : 'enabled',
		trigger : 'blur keyup',
		feedbackIcons : {// input状态样式图片
			valid : 'glyphicon ',
			invalid : 'glyphicon ',
			validating : 'glyphicon '
		},
		container : 'popover',
		fields : {
			groupDescribe : {
				message : '组描述',
				validators : {
					notEmpty : {
						message : '组描述不能为空'
					}
				}
			},
		}
	}).on('success.form.bv', function(e) {// 点击提交之后
		e.preventDefault();
		var $form = $(e.target);
		var bv = $form.data('bootstrapValidator');
		if (bv.isValid()) {
			var data = {};
			var url = $('#groupId').attr('value');
			var a = $(":checkbox");
			for ( var i = 0; i < a.length; i++) {
				if (a[i].checked) {
					data[i] = a[i].id;
				}
			}
			$.ajax({
				url : "/group/right?groupId=" + url,
				type : 'POST',
				contentType : "application/json; charset=utf-8",
				data : JSON.stringify(data),
				dataType : "json",
				success : function(data) {
					if (data.status == 200) {
						toastr.success(data.msg);
						// 刷新父页面
						setTimeout(function() {
							parent.layer.closeAll('iframe');
							window.parent.location.reload();
						}, 500);
					} else {
						toastr.error(data.msg);
					}
				},
				error : function(data) {
					toastr.error('服务无响应')
				}
			});
		}
	});

	// 菜单的隐藏显示
	// $('.tree li:has(ul)').addClass('parent_li').find(' > span').attr('title',
	// 'Collapse this branch');
	// $('.tree li.parent_li > span').on('click', function (e) {
	// var children = $(this).parent('li.parent_li').find(' > ul > li');
	// if (children.is(":visible")) {
	// children.hide('fast');
	// $(this).attr('title', 'Expand this branch').find(' >
	// i').addClass('icon-plus-sign').removeClass('icon-minus-sign');
	// } else {
	// children.show('fast');
	// $(this).attr('title', 'Collapse this branch').find(' >
	// i').addClass('icon-minus-sign').removeClass('icon-plus-sign');
	// }
	// e.stopPropagation();
	// });
})
function loads(){
	var ischeck = $(":checkbox");
	for ( var i = 0; i < ischeck.length; i++) {
		if (ischeck[i].name != "0") {
			ischeck[i].checked = true;
		}
	}
	for ( var j = 0; j < ischeck.length; j++) {
		if (ischeck[j].name == "2") {
			ischeck[j].disabled = true;
		}
	}
	//控制菜单的隐藏显示  
    $("ul[class] li i").each(function(){  
        $(this).click(function(){  
        	$(this).parent('li').next().toggle();
        }) ;  
    }) ;
}
function createTree(jsons, parentId) {
	if (jsons != null) {
		var ul = '<ul class="">';
		for ( var i = 0; i < jsons.length; i++) {
			// 添加菜单
			if (jsons[i].parentId == parentId && jsons[i].rightType == "1") {
				// 如果无子菜单则图标为叶子
				var isleaf = 1;
				for ( var j = 0; j < jsons.length; j++) {
					if (jsons[i].rightId == jsons[j].parentId
							&& jsons[j].rightType == "1") {
						isleaf = 2;
					}
				}
				if (isleaf == 2) {
					ul += '<li class="treeli" id='
							+ jsons[i].rightId
							+ '><i class="fa fa-folder-open"></i><div class="inline"><span class="checkbox checkbox-inline">\n<input type="checkbox" name='
							+ jsons[i].biaosi + ' id=' + jsons[i].rightId
							+ '><label></label></span></div><span>'
							+ jsons[i].menuName + '</span>';
				}
				if (isleaf == 1) {
					ul += '<li class="treeli" id='
							+ jsons[i].rightId
							+ '><i class="fa fa-leaf"></i><div class="inline"><span class="checkbox checkbox-inline">\n<input type="checkbox" name='
							+ jsons[i].biaosi + ' id=' + jsons[i].rightId
							+ '><label></label></span></div><span>'
							+ jsons[i].menuName + '</span>';
				}
				ul += '<div class="inline" style="position:absolute; left:60%;">';
				// 添加操作
				for ( var k = 0; k < jsons.length; k++) {
					if ((jsons[k].parentId == jsons[i].rightId)
							&& (jsons[k].rightType == "2")) {
						ul += '<span class="checkbox checkbox-inline">\n<input type="checkbox" name='
								+ jsons[k].biaosi
								+ ' id='
								+ jsons[k].rightId
								+ '><label>'
								+ jsons[k].operateName
								+ '</label></span>\n';
					}
				}
				ul += '</div>';
				ul += '<hr style="margin-top:0px;margin-bottom:0px;"></hr></li>';
				ul += createTree(jsons, jsons[i].rightId);
			}
		}
		ul += '</ul>';
	}
	return ul;
}
