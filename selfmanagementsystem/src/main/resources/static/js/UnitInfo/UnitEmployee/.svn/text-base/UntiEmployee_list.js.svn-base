var pathname = window.location.pathname;

	if(pathname=="/unit/details"){
		$("#UnitEmployee_add").remove();
		$(".table .btn-red,.table .btn-blue").remove();
		function setFontCss(treeId, treeNode) {
			return treeNode.id==departmentCode ? { color: "red"} : {};
		}
		var setting = {
	            view: {
	            	fontCss: setFontCss,
	                dblClickExpand: false,
	                selectedMulti: false
	            },
	            data: {
	                simpleData: {
	                    enable: true
	                }
	            },
	            edit: {
	                enable: true,
	                showRemoveBtn : false,
	                showRenameBtn : false
	               
	            },
				callback: {
			
					beforeClick: beforeClick,
					beforeCollapse: beforeCollapse
				
				}
	        };
		
	  
			var unitCode = $("#continer2").attr('value');
			var departmentCode = $("#continer3").attr('value');
		    var json = $("#continer1").attr('value');
		    var obj = eval('(' + json + ')');
		    obj[0].collapse=false;
		    var zNodes = obj;	  
		    
		    function beforeCollapse(treeId, treeNode) {
		    	  alert(treeNode.collapse)
		    	    	return (treeNode.collapse !== false);
		    	    }
		    
	        $(document).ready(function(){
	            $.fn.zTree.init($("#tree"), setting, zNodes);
	        });

	        $(".UnitEmployee_detail").each(function(num){
	            $(this).on("click",function(){
	            	var json = $(this).attr('id');
	                var obj = eval('(' + json + ')');
	                var unitCode = obj.unitCode;
	                var departmentCode = obj.departmentCode;
	                var employeeCode = obj.employeeCode;
	            	getIframe('/unitEmployee/details?unitCode='+unitCode+'&departmentCode='+departmentCode+'&employeeCode='+employeeCode);
	            });
	        });
	    
	        //鼠标点击时
	        function beforeClick(treeId, treeNode) {
	        	var id = treeNode.id;
				if (treeNode.isParent) {
					parent.$("#ok").load("/unitEmployee/list?unitCode=" + unitCode + "&departmentCode=0");
					return true;
				} else {
					parent.$("#ok").load("/unitEmployee/list?unitCode=" + unitCode + "&departmentCode=" + id);
					return false;
				}
			}

	}else{
		$(".table .btn-yellow").remove();
		//树的生成
		function setFontCss(treeId, treeNode) {
			return treeNode.id==departmentCode ? { color: "red"} : {};
		}
		var setting = {
	            view: {
	            	fontCss: setFontCss,
	                addHoverDom: addHoverDom,
	                removeHoverDom: removeHoverDom,
	                dblClickExpand: false,
	                selectedMulti: false
	            },
	            data: {
	                simpleData: {
	                    enable: true
	                }
	            },
	            edit: {
	                enable: true,
	                removeTitle: "删除",
	                renameTitle: "编辑"
	            },
				callback: {				
					beforeClick: beforeClick,
					beforeEditName: beforeEditName,
					beforeCollapse: beforeCollapse,
					beforeRemove: beforeRemove
				}
	        };
			var unitCode = $("#continer2").attr('value');
			var departmentCode = $("#continer3").attr('value');
		    var json = $("#continer1").attr('value');
		    var obj = eval('(' + json + ')');
		    obj[0].collapse=false;
		    var zNodes = obj;
	        $(document).ready(function(){
	            $.fn.zTree.init($("#tree"), setting, zNodes);
	        });
	      //按钮事件
	        $("#UnitEmployee_add").click(function(){
	        	if(departmentCode == "0"){
	        		layer.alert('只有部门下可以添加人员 ！');
	        	}else{
	        		getIframe('/unitEmployee/add?unitCode=' + unitCode + '&departmentCode=' + departmentCode);
	        	}
	        });
	        $(".UnitEmployee_edit").each(function(num){
	        	 $(this).on("click",function(){
	        	    	var json = $(this).attr('id');
	        	        var obj = eval('(' + json + ')');
	        	        var unitCode = obj.unitCode;
	        	        var departmentCode = obj.departmentCode;
	        	        var employeeCode = obj.employeeCode;
	        	    	getIframe('/unitEmployee/edit?unitCode='+unitCode+'&departmentCode='+departmentCode+'&employeeCode='+employeeCode);
	        	    });
	        });
	        $(".UnitEmployee_detail").each(function(num){
	            $(this).on("click",function(){
	            	var json = $(this).attr('id');
	                var obj = eval('(' + json + ')');
	                var unitCode = obj.unitCode;
	                var departmentCode = obj.departmentCode;
	                var employeeCode = obj.employeeCode;
	            	getIframe('/unitEmployee/details?unitCode='+unitCode+'&departmentCode='+departmentCode+'&employeeCode='+employeeCode);
	            });
	        });

	        $(".UnitEmployee_del").each(function(index){
	            $(this).on("click",function(){
	            	var json = $(this).attr('id');
	                var obj = eval('(' + json + ')');
	                var unitCode = obj.unitCode;
	                var employeeCode = obj.employeeCode;
	                var departmentCode = $(this).attr('name');
	                getdel('/unitEmployee/del?unitCode='+unitCode+'&departmentCode='+departmentCode+'&employeeCode='+employeeCode, unitCode, departmentCode);
	            });
	        });

	        //修改
	        function beforeEditName(treeId, treeNode) {
	        	if (treeNode.isParent) {
	        		layer.alert('请返回单位信息修改 ！');
	        		return false;
	        	}else{
					var zTree = $.fn.zTree.getZTreeObj("tree");
					zTree.selectNode(treeNode);
					$.get('/unitDepartment/edit?unitCode='+treeNode.pId+'&departmentCode='+treeNode.id, function(result){
						var result=JSON.parse(result);
				    var data={};
	            	data.unitCode=treeNode.pId;
	            	data.departmentCode=treeNode.id;
				getPrompt("请修改部门","/unitDepartment/edit","departmentName","put",data,result.data.departmentName);
					  });

					return true;
	        	}
			}
	        //删除
	        function beforeRemove(treeId, treeNode) {
				var zTree = $.fn.zTree.getZTreeObj("tree");
				zTree.selectNode(treeNode);
				var id = treeNode.id;
				if (treeNode.isParent) {
					layer.alert('请返回单位信息删除 ！');
					return false;
				}else{
					$.ajax({
		 		    url: '/unitDepartment/del?unitCode='+unitCode+'&departmentCode='+id,
		 		    type: 'DELETE',	
		 		    contentType: "application/json; charset=utf-8",
		 	        data: JSON.stringify(id),
		 	        dataType: "json",
		 	       success: function(data) {
	   		    	if (data.status == 200) {
	   	     		    // 重新加载
	   						setTimeout(function() {
	   							parent.$("#ok").load("/unitEmployee/list?unitCode=" + unitCode + "&departmentCode=0");
	   						}, 500);
	   	     		    		toastr.success(data.msg);
	   	     		    	} else {
	   	     		    		parent.$("#ok").load("/unitEmployee/list?unitCode=" + unitCode + "&departmentCode=0");
	   							toastr.error(data.msg);
	   						}
	   		    },
	   		    error:function(data){
	   		    	toastr.error("服务器无响应");
	   		    	return false;
	   		}
		 		});
			}
				
			}
	        //鼠标点击时
	        function beforeClick(treeId, treeNode) {
	        	var id = treeNode.id;
				if (treeNode.isParent) {
					parent.$("#ok").load("/unitEmployee/list?unitCode=" + unitCode + "&departmentCode=0");	
					return true;
				} else {
					parent.$("#ok").load("/unitEmployee/list?unitCode=" + unitCode + "&departmentCode=" + id);
					return false;
				}
			}
	        //鼠标移上时
	        var newCount = 1;
	        function addHoverDom(treeId, treeNode) {
	            var sObj = $("#" + treeNode.tId + "_span");
	            if (treeNode.editNameFlag || $("#addBtn_"+treeNode.tId).length > 0) return;
	            var addStr = "<span class='button add' id='addBtn_" + treeNode.tId
	                + "' title='添加部门' onfocus='this.blur();'></span>";
				if(treeNode.isParent){
					 sObj.after(addStr);	
				} 	
	            var btn = $("#addBtn_"+treeNode.tId);
	            //点击添加时
	            if (btn) btn.bind("click", function(){
	            	var zTree = $.fn.zTree.getZTreeObj("tree");
	            	var url='/unitDepartment/add';
	            	var title="请新增部门";
	            	var data={};
	            	data.unitCode=getUrlParam("unitCode");
	            	getPrompt(title,url,"departmentName","post",data);
//	            		zTree.addNodes(treeNode, {id:(treeNode.id+ "0"), pId:treeNode.id++, name:"请编辑名称" + (newCount++)});       
	            		return false;   
	            });
	        };
	        //鼠标移开时
	        function removeHoverDom(treeId, treeNode) {
	            $("#addBtn_"+treeNode.tId).unbind().remove();
	        };

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

	function getPrompt(title,url,name,type,data,value){
		layer.prompt({title: title, formType:0,value:value}, function(content, index){
			  layer.close(index);		  
			  data[name]=content;
			  $.ajax({
		 		    url:url,
		 		    type: type,	
		 		    contentType: "application/json; charset=utf-8",
		 	        dataType: "json",
		 	       data:JSON.stringify(data),
		 	       success: function(data) {
	 		    	if (data.status == 200) {
	 	     		    // 重新加载
	 						setTimeout(function() {
	 							index = parent.layer
	 									.getFrameIndex(window.name);
	 							parent.layer.close(index);
	 							var href=parent.$(".x_top1 .btn-color").attr("href");	 		    		
	 		     		    	parent.$("#ok").load(href);
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
		
	function getdel(url){
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
	   							var href=parent.$(".x_top1 .btn-color").attr("href");	 		    		
	   		     		    	parent.$("#ok").load(href);
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
	function getdel(url, unitCode, departmentCode){
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
	   							parent.$("#ok").load("/unitEmployee/list?unitCode=" + unitCode + "&departmentCode=" + departmentCode);
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
	function beforeCollapse(treeId, treeNode) {
		return (treeNode.collapse !== false);
	}
		
	}
