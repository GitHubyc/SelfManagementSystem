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
}) 
