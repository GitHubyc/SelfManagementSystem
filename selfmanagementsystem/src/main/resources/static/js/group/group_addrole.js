$(function(){
	
	$('#callbacks').multiSelect({
		afterSelect : function(values) {
			//         alert("Select value: "+values);
		},
		afterDeselect : function(values) {
			//         alert("Deselect value: "+values);
		}
	});
	
	
         $('#Group_addrole')
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
             fields: {
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
             e.preventDefault();
             var $form = $(e.target);
             var bv = $form.data('bootstrapValidator');
             if( bv.isValid()){
                 var data = {};
                 var select = document.getElementById("callbacks");
                 var url = $('#groupId').attr('value');
                 for(i=0;i<select.length;i++){
                     if(select.options[i].selected){
                     	data[i] = select[i].value;
                     }
                 }
               //  alert(JSON.stringify(data))
                 // 使用Ajax提交form表单数据
                 $.ajax({
          		    url: "/group/addrole?groupId=" + url,
          		    type: 'POST',	
          		    contentType: "application/json; charset=utf-8",
          	        data: JSON.stringify(data),
          	        dataType: "json",
          	      success : function(data) {
          	    	if (data.status == 200) {
          	    		toastr.success(data.msg);
          	    		// 刷新父页面
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
