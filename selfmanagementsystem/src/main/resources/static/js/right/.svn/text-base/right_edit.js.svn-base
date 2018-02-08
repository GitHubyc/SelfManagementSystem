$(document).ready(function(){
		var selectValue =$('#user_add_select').children('option:selected').val();
		if(selectValue==1){
			$('#user_add_unit1').show();
			$('#user_add_unit2').show();
			$('#user_add_build').hide();
		}else if(selectValue==2){
			$('#user_add_unit1').hide();
			$('#user_add_unit2').hide();
			$('#user_add_build').show();
		}else{
			$('#user_add_unit1').hide();
			$('#user_add_unit2').hide();
			$('#user_add_build').hide();
		}
		
		

	    $('#Right_edit')
	    .bootstrapValidator({
	        message: 'This value is not valid',
	        live: 'enabled',
	        trigger:'blur keyup',   
	        feedbackIcons: {//input状态样式图片
	            valid: 'glyphicon ',
	            invalid: 'glyphicon ',
	            validating: 'glyphicon '
	        },
	        container: 'popover',
	        fields: {//验证：规则           	
	        	  rightType: {
	                  message:'权限类型',             
	                  validators: {
	                      notEmpty: {
	                          message: '权限类型不能为空'
	                      }
	                  }
	              },
	              parentId: {
	                  message:'父ID',             
	                  validators: {
	                      notEmpty: {
	                          message: '父ID不能为空'
	                      }
	                  }
	              },
	              applyId: {
	                  message:'应用ID',             
	                  validators: {
	                      notEmpty: {
	                          message: '应用ID不能为空'
	                      }
	                  }
	              },
	              menuName: {
	                  message:'菜单名称',             
	                  validators: {
	                      notEmpty: {
	                          message: '菜单名称不能为空'
	                      }
	                  }
	              },
	              menuIcon: {
	                  message:'菜单图标',             
	                  validators: {
	                      notEmpty: {
	                          message: '菜单图标不能为空'
	                      }
	                  }
	              },
	              menuUrl: {
	                  message:'菜单URL',             
	                  validators: {
	                      notEmpty: {
	                          message: '菜单URL不能为空'
	                      }
	                  }
	              },
	              menuSort: {
	                  message:'菜单排序',             
	                  validators: {
	                      notEmpty: {
	                          message: '菜单排序不能为空'
	                      }
	                  }
	              },
	              menuDescribe: {
	                  message:'菜单描述',             
	                  validators: {
	                      notEmpty: {
	                          message: '菜单描述不能为空'
	                      }
	                  }
	              },
	              operateType: {
	                  message:'操作类型',             
	                  validators: {
	                      notEmpty: {
	                          message: '操作类型不能为空'
	                      }
	                  }
	              },
	              operateName: {
	                  message:'操作名称',             
	                  validators: {
	                      notEmpty: {
	                          message: '操作名称不能为空'
	                      }
	                  }
	              },
	              operateUrl: {
	                  message:'操作URL',             
	                  validators: {
	                      notEmpty: {
	                          message: '操作URL不能为空'
	                      }
	                  }
	              },
	              operateDescribe: {
	                  message:'操作描述',             
	                  validators: {
	                      notEmpty: {
	                          message: '操作描述不能为空'
	                      }
	                  }
	              },
	        }
	    }).on('success.form.bv', function(e) {//点击提交之后
	        e.preventDefault();
	        var $form = $(e.target);
	        var bv = $form.data('bootstrapValidator');
	        if( bv.isValid()){
	            var data = {};
	            var t = $('#Right_edit').serializeArray();
	            $.each(t, function() {
	             data[this.name] = this.value;
	          });
	          //  alert(JSON.stringify(data))
	            // 使用Ajax提交form表单数据
	            $.ajax({
	     		    url: '/right/edit',
	     		    type: 'PUT',	
	     		    contentType: "application/json; charset=utf-8",
	     	        data: JSON.stringify(data),
	     	        dataType: "json",
	     	       success : function(data) {
	     	    		if (data.status == 200) {
	     	    			toastr.success(data.msg);
	     	    			// 刷新父页面
	     	    			setTimeout(function(){
	     	    				var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
								parent.layer.close(index);
		     		    		parent.window.location.replace();
	     	    		    	},500);
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
}) 