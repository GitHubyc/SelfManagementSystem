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
    
    
    $('#Group')
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
        	  groupName: {
                  message:'组名',             
                  validators: {
                      notEmpty: {
                          message: '组名不能为空'
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
              groupDescribe: {
                  message:'组描述',             
                  validators: {
                      notEmpty: {
                          message: '组描述不能为空'
                      }
                  }
              },
        }
    }).on('success.form.bv', function(e) {//点击提交之后
        // Prevent form submission
        e.preventDefault();

        // Get the form instance
        var $form = $(e.target);

        // Get the BootstrapValidator instance
        var bv = $form.data('bootstrapValidator');
        if( bv.isValid()){
            var data = {};
            var t = $('#Group').serializeArray();
            $.each(t, function() {
             data[this.name] = this.value;
          });
          //  alert(JSON.stringify(data))
            // 使用Ajax提交form表单数据
            $.ajax({
     		    url: '/group/add',
     		    type: 'POST',	
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
