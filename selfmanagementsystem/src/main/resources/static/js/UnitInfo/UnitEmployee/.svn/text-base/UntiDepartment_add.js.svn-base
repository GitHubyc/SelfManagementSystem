$(document).ready(function(){
    //添加验证
    $('#UnitDepartment_add')
    .bootstrapValidator({
        message: 'This value is not valid',
        live: 'enabled',
        trigger:'blur keyup',   
        feedbackIcons: {//input状态样式图片
            valid: 'glyphicon',
            invalid: 'glyphicon',
            validating: 'glyphicon'
        },
        container: 'popover',
        fields: {//验证：规则           	
        	departmentName: {
                  message:'员工名称',             
                  validators: {
                      notEmpty: {
                          message: '员工名称不能为空'
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
            var t = $('#UnitDepartment_add').serializeArray();
            $.each(t, function() {
             data[this.name] = this.value;
          });
    		$.ajax({
     		    url: '/unitDepartment/add',
     		    type: 'post',	
     		    contentType: "application/json; charset=utf-8",
     	        data: JSON.stringify(data),
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
        }
    });
}) 