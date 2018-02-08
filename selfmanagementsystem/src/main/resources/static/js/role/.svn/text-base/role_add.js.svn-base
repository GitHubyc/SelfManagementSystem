$(document).ready(function(){
	$('#user_add_select').change(function(){
// 		$(this).attr({"disabled":"disabled"});
		var selectValue = $(this).children('option:selected').val();
		if(selectValue==1){
			$('#user_add_unit1').hide();
			$('#user_add_unit2').show();
			$('#user_add_build').hide();
		}else if(selectValue==3){
			$('#user_add_unit1').hide();
			$('#user_add_unit2').hide();
			$('#user_add_build').show();
		}else{
			$('#user_add_unit1').show();
			$('#user_add_unit2').show();
			$('#user_add_build').hide();
		}
	}); 
	//日期控件
    $('.input-group.date').datepicker({
    	language: "zh-CN"
    });
    
    $('#Role')
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
        	  createdDate: {
                  message:'创建日期',             
                  validators: {
                      notEmpty: {
                          message: '创建日期不能为空'
                      }
                  }
              },
              updateDate: {
                  message:'更新日期',             
                  validators: {
                      notEmpty: {
                          message: '更新日期不能为空'
                      }
                  }
              },
              roleDescribe: {
                  message:'角色描述',             
                  validators: {
                      notEmpty: {
                          message: '角色描述不能为空'
                      }
                  }
              },
              roleName: {
                  message:'角色名称',             
                  validators: {
                      notEmpty: {
                          message: '角色名称不能为空'
                      }
                  }
              },
              roleId: {
                  message:'角色ID',             
                  validators: {
                      notEmpty: {
                          message: '角色ID不能为空'
                      }
                  }
              }
        }
    }).on('success.form.bv', function(e) {//点击提交之后
        e.preventDefault();
        var $form = $(e.target);
        var bv = $form.data('bootstrapValidator');
        if( bv.isValid()){
            var data = {};
            var t = $('#Role').serializeArray();
            $.each(t, function() {
             data[this.name] = this.value;
          });
    		$.ajax({
     		    url: 'http://localhost:9090/role/add',
     		    type: 'post',	
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
