$(function(){
	//初始化页面
	$("#continer1").toggle();
    var json = $("#continer1").attr('value');
    var obj = eval('(' + json + ')');
    var jsonData = obj;
    var ul = '<ul class="right_list_ul">' ;
    for(var i=0;i<jsonData.length;i++){
		 if(jsonData[i].rightId == $(".change")[0].id){
			 ul = ul + '<li class="treeli menu" id='+jsonData[i].rightId+'><i class="fa fa-folder-open"></i><span>' + jsonData[i].menuName + '</span><hr style="margin-top:5px;margin-bottom:5px;"></hr></li>';	 
		 }
	}
	ul = ul + createTree(jsonData,$(".change")[0].id) + '</ul>' ;
    $("#continer").append(ul) ;
    loads();
	
    //按钮事件
	$("#Right_add").click(function(){
		if($(this).attr('value')){
			getIframe('/right/add?rightId=' + $(this).attr('value'));
		}else{
			layer.alert('请选择权限');
		}
	});
	$(".Right_details").click(function(){	
		if($(this).attr('id')){
			getIframe('/right/details?rightId='+$(this).attr('id'));
		}else{
			layer.alert('请选择权限');
		}
	});
	$(".Right_edit").click(function(){	
		if($(this).attr('id')){
			getIframe('/right/edit?rightId='+$(this).attr('id'));
		}else{
			layer.alert('请选择权限');
		}
	});
	$(".Right_del").each(function(index){
	    $(this).on("click",function(){
	    	if($(this).attr('id')){
	    		var data = $(this).attr('id');
		    	getdel("/right/del?rightId="+data,"DELETE",data);
	    	}else{
	    		layer.alert('请选择权限');
	    	}
	    });
	});
     //点击时清空原先数据，添加当前数据
     $(".change").each(function(){ 
         $(this).click(function(){
        	 var ul = '<ul class="right_list_ul">' ;
        	 var json = $("#continer1").attr('value');
        	 var obj = eval('(' + json + ')');
        	 var jsonData = obj;
        	 for(var i=0;i<jsonData.length;i++){
        		 if(jsonData[i].rightId == this.id){
        			 ul = ul + '<li class="treeli menu" id='+jsonData[i].rightId+'><i class="fa fa-folder-open"></i><span>' + jsonData[i].menuName + '</span><hr style="margin-top:5px;margin-bottom:5px;"></hr></li>';	 
        		 }
        	 }
        	 ul = ul + createTree(jsonData,this.id) + '</ul>' ;
        	 $("#continer").html('');
             $("#continer").append(ul) ; 
             $('#Right_add').attr("value","0");
             loads();
         });
     });
})
//主方法，运用递归实现  
     function createTree(jsons,parentId){  
         if(jsons != null){  
             var ul = '<ul class="right_list_ul">' ;  
             for(var i=0;i<jsons.length;i++){ 
             	 //添加菜单 
                 if(jsons[i].parentId == parentId&&jsons[i].rightType == "1"){ 
                 	 //如果无子菜单则图标为叶子
                 	 var isleaf = 1;
                 	 for(var j=0;j<jsons.length;j++){
                 	 	 if(jsons[i].rightId==jsons[j].parentId&&jsons[j].rightType == "1"){
                 	 	 	 isleaf = 2;
                 	 	 }
                 	 }
                 	 if(isleaf == 2){
                 	 	ul += '<li class="treeli menu" id='+jsons[i].rightId+'><i class="fa fa-folder-open"></i><span>' + jsons[i].menuName + '</span>' ;
                 	 }
                 	 if(isleaf == 1){
                 	 	ul += '<li class="treeli menu" id='+jsons[i].rightId+'><i class="fa fa-leaf"></i><span>' + jsons[i].menuName + '</span>' ;
                 	 } 
                     ul +='<div class="inline" style="position:absolute; left:55%;">';
                     //添加操作
			      	  for(var k=0;k<jsons.length;k++){
			      	  	  if((jsons[k].parentId==jsons[i].rightId)&&(jsons[k].rightType=="2")){
			      	  	  	  ul += '<span class="checkbox checkbox-inline">\n<input type="checkbox" name=""><label></label></span>\n';
			      	  	  	  ul += '<span class="operate" id='+jsons[k].rightId+'>'+jsons[k].operateName+'</span>\n';
			      	  	  }
			      	  }
                     ul += '</div>';  
                     ul += '<hr style="margin-top:5px;margin-bottom:5px;"></hr></li>';  
                     ul += createTree(jsons,jsons[i].rightId);  
                 }  
             }  
             ul += '</ul>';  
        }  
        return ul ;  
     }  
function loads(){
	$("#continer1").toggle();
    var json = $("#continer1").attr('value');
    var obj = eval('(' + json + ')');
    var jsonData = obj;
    //控制菜单的隐藏显示  
    $("ul[class] li span,i").each(function(){  
        $(this).click(function(){  
        	 //改变元素可见状态
            $(this).parent('li').next().toggle();
            //如果有子isfirst为2
            var isfirst=1;
            for(var i=0;i<jsonData.length;i++){ 
            	 if(jsonData[i].parentId==$(this).parent('li').attr('id')){
            	 	if(jsonData[i].or=="1"){
            	 		isfirst=2;
            	 	}
            	 }
            }
            if(isfirst==2){
                //如果隐藏 
                if($(this).parent('li').next().is(':hidden')){
                	$(this).parent('li').find(' > i').removeClass('fa fa-minus-square');
                	$(this).parent('li').find(' > i').addClass('fa fa-plus-square');
                }
                //如果显示
                else{
                	$(this).parent('li').find(' > i').removeClass('fa fa-plus-square');
                	$(this).parent('li').find(' > i').addClass('fa fa-minus-square');
                } 
            }
        }) ;  
    }) ;
    //控制菜单颜色
    $(".menu").each(function(){ 
        $(this).click(function(){ 
        	 $(".operate").each(function(){  
	             $(this).css("color", "black");
	         }); 
            $(".menu").each(function(){  
	             $(this).find(' > span').css("color", "black");
	         });
	         $('.Right_details').attr("id",$(this).attr('id'));
	         $('.Right_edit').attr("id",$(this).attr('id'));
	         $('.Right_del').attr("id",$(this).attr('id'));
	         $('#Right_add').attr("value",$(this).attr('id'));
	         $(this).find(' > span').css("color", "#3385ff");  
        }) ;  
    }) ;  
    //控制操作颜色
    $(".operate").each(function(){ 
        $(this).click(function(){ 
            $(".operate").each(function(){  
	             $(this).css("color", "black");
	         });
	         $(".menu").each(function(){  
	             $(this).find(' > span').css("color", "black");
	         });
	         $('.Right_details').attr("id",$(this).attr('id'));
	         $('.Right_edit').attr("id",$(this).attr('id'));
	         $('.Right_del').attr("id",$(this).attr('id'));
	         $('#Right_add').attr("value","");
	         $(this).css("color", "#3385ff");
	         return false;
        }) ;  
    }) ;
	$(":checkbox").attr({"disabled":"disabled"}); 
}

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
