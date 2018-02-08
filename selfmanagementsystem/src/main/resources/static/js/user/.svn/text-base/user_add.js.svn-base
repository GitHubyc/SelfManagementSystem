$(document).ready(function(){
	$('#user_add_select').change(function(){
		var selectValue = $(this).children('option:selected').val();
		if(selectValue==1){
			$('#user_add_unit1').hide();
			$('#user_add_unit2').show();
			$('#user_add_build').hide();
		}else if(selectValue==3){
			$('#user_add_unit1').hide();
			$('#user_add_unit2').hide();
			$('#user_add_build').show();
		}else if(selectValue==2){
			$('#user_add_unit1').show();
			$('#user_add_unit2').show();
			$('#user_add_build').hide();
		}else if(selectValue==4){
			$('#user_add_unit1').hide();
			$('#user_add_unit2').hide();
			$('#user_add_build').hide();
		}
	}); 
    //单位、员工联动（获得员工的json数组，在点击单位下拉框时员工下拉框放入对应数据）
//    $("#continer1").toggle();
//	    var json = $("#continer1").attr('value');
//	    var obj = eval('(' + json + ')');
//	    if(obj == null){
//	    	obj = [];
//    }
//    $("#continer1").attr('value',null);
//    $("#unitCode").blur(function(){
//    	$("#unitCode").attr("value", "1");
//    })
//    $("#employee").focus(function(){
//    	var employee = document.getElementById("employee");
//    	employee.options.length = 0;
//    	var unit = document.getElementById("unitCode");
//        var unitvalue = unit.value;
//        var option = new Option("请选择员工", null);
//        option.disabled = true;
//        option.selected = true;
//        employee.add(option);
//        $.each(obj, function (n, value) {
//        	if(unitvalue == value.unitCode){
//        		employee.add(new Option(value.name, value.employeeCode));
//        	}
//        });
//        if(employee.options.length == 1){
//        	employee.options.length = 0;
//        	option.text = "该单位下没有员工 ！";
//        	employee.add(option);
//        }
//    })
	$("#employeeCode").focus(function(){
		getIframe('/user/employee?unitCode=' + $("#unitCode").attr("value"));
	});
	$("#employeeCode").blur(function(){
    	$("#employeeCode").attr("value", "1");
    })
	$("#unitCode").blur(function(){
    	$("#unitCode").attr("value", "1");
    })
    $("#plcBuildCode").blur(function(){
    	$("#plcBuildCode").attr("value", "1");
    })
    //添加验证
    $('#User')
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
        	userType: {
                  message:'用户类型',             
                  validators: {
                      notEmpty: {
                          message: '用户类型不能为空'
                      }
                  }
              },
              unitCode: {
                  message:'单位编号',             
                  validators: {
                      notEmpty: {
                          message: '单位编号不能为空'
                      }
                  }
              },
              plcBuildCode: {
                  message:'建筑编号',             
                  validators: {
                      notEmpty: {
                          message: '建筑编号不能为空'
                      }
                  }
              },
              employeeCode: {
                  message:'员工编号',             
                  validators: {
                      notEmpty: {
                          message: '员工编号不能为空'
                      }
                  }
              },
              username: {
                  message:'用户名',             
                  validators: {
                      notEmpty: {
                          message: '用户名不能为空'
                      }
                  }
              },
              nickname: {
                  message:'昵称',             
                  validators: {
                      notEmpty: {
                          message: '昵称不能为空'
                      }
                  }
              },
              mobileTelephone: {
                  message:'移动电话',             
                  validators: {
                      notEmpty: {
                          message: '移动电话不能为空'
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
              birthDate: {
                  message:'出生日期',             
                  validators: {
                      notEmpty: {
                          message: '出生日期不能为空'
                      },date: {
                          format: 'YYYY-MM-DD',
                          message: '编辑格式-YYYY-MM-DD'
                      }
                  }
              },
              password: {
                  message:'密码',             
                  validators: {
                      notEmpty: {
                          message: '密码不能为空'
                      }
                  }
              },
              sex: {
                  message:'性别',             
                  validators: {
                      notEmpty: {
                          message: '性别不能为空'
                      }
                  }
              },
              email: {
                  message:'电子邮箱',             
                  validators: {
                      notEmpty: {
                          message: '电子邮箱不能为空'
                      },regexp: {
                          regexp: /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/,
                          message: '邮箱格式不对'
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
            var t = $('#User').serializeArray();
            $.each(t, function() {
             data[this.name] = this.value;
          });
            data['icon']=$("#pic").attr("src");
//            data["icon"] = $('#updateimg').attr("value");
            // 使用Ajax提交form表单数据
//            alert(JSON.stringify(data));
    		$.ajax({
     		    url: '/user/add',
     		    type: 'post',	
     		    contentType: "application/json; charset=utf-8",
     	        data: JSON.stringify(data),
     	        dataType: "json",
     	       success : function(data) {
					if (data.status == 200) {
						toastr.success(data.msg);
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
        }
    });
}) 
