$(document).ready(function(){
	$("#UnitEmployee_edit select[name='documentType']").change(function(){	
		var num=$(this).val();
		var $templateEle = $("#UnitEmployee_edit .form_content"),
		$el= $templateEle.find('input').attr('name');
	if(num==1){
	$(".documentNo").html(' <input  class="form-control "  name="documentNo1" placeholder="请输入18位身份证号"  type="text">');
	}else if(num==2){
		$(".documentNo").html(' <input  class="form-control "  name="documentNo2" placeholder="请输入护照"  type="text">');
	}else if(num==3){
		$(".documentNo").html(' <input  class="form-control "  name="documentNo3" placeholder="请输入港澳通行证"  type="text">');
	}
	$('#UnitEmployee_edit').bootstrapValidator('addField', $el);
	});
    //添加验证
    $('#UnitEmployee_edit')
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
        	  name: {
                  message:'员工名称',             
                  validators: {
                      notEmpty: {
                          message: '员工名称不能为空'
                      }
                  }
              },
              duty: {
                  message:'职务',             
                  validators: {
                      notEmpty: {
                          message: '职务不能为空'
                      }
                  }
              },
              certificateName: {
                  message:'证书名称',             
                  validators: {
                      notEmpty: {
                          message: '证书名称不能为空'
                      }
                  }
              },
              documentNo1: {
                  message:'身份证号',             
                  validators: {
                      notEmpty: {
                          message: '身份证号不能为空'
                      },stringLength: {
                          min: 11,
                          max: 11,
                          message: '请输入11位手机号码'
                      }
                  }
              },
              documentNo2: {
                  message:'护照',             
                  validators: {
                      notEmpty: {
                          message: '护照不能为空'
                      },regexp: {
                          regexp: /^[a-zA-Z0-9]{5,17}$/,
                          message: '请输入正确的手机号码'
                      }
                  }
              },
              documentNo3: {
                  message:'港澳通行证',             
                  validators: {
                      notEmpty: {
                          message: '建筑编号不能为空'
                      },regexp: {
                          regexp: /^[HMhm]{1}([0-9]{10}|[0-9]{8})$/,
                          message: '请输入正确的手机号码'
                      }
                  }
              },
              documentType: {
                  message:'证件类型',             
                  validators: {
                      notEmpty: {
                          message: '证件类型不能为空'
                      }
                  }
              },
              position: {
                  message:'职位',             
                  validators: {
                      notEmpty: {
                          message: '职位不能为空'
                      }
                  }
              },
              contactNumber: {
                  message:'联系电话',             
                  validators: {
                      notEmpty: {
                          message: '联系电话不能为空'
                      },stringLength: {
                          min: 11,
                          max: 11,
                          message: '请输入11位手机号码'
                      },regexp: {
                          regexp: /^1[3|5|8]{1}[0-9]{9}$/,
                          message: '请输入正确的手机号码'
                      }
                  }
              },
              isOpenAccount: {
                  message:'是否开通账号',             
                  validators: {
                      notEmpty: {
                          message: '选择是否开通账号'
                      }
                  }
              },
              status: {
                  message:'状态',             
                  validators: {
                      notEmpty: {
                          message: '状态不能为空'
                      }
                  }
              },
              type: {
                  message:'类型',             
                  validators: {
                      notEmpty: {
                          message: '类型不能为空'
                      }
                  }
              }
        }
    }).on('success.form.bv', function(e) {//点击提交之后
        e.preventDefault();
        var $form = $(e.target);
        var bv = $form.data('bootstrapValidator');
        var unitCode = $("#unitCode").attr('value');
        var departmentCode = $("#departmentCode").attr('value');
        if( bv.isValid()){
            var data = {};
            var t = $('#UnitEmployee_edit').serializeArray();
            $.each(t, function() {
             data[this.name] = this.value;
          });
    		$.ajax({
     		    url: '/unitEmployee/edit',
     		    type: 'PUT',	
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
    							parent.$("#ok").load('/unitEmployee/list?unitCode='+unitCode+'&departmentCode='+departmentCode);
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