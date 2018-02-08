$("input,textarea,select").prop("disabled","disabled")
//多选框判断
function ischecked(name, str) {
	var arr = new Array();
	arr = str.split(',');
	$("[name='" + name + "']").each(
			function(index) {
				for (var i = 0; i < arr.length; i++) {
					if (arr[i] == $(this).val()) {
						$("[name='" + name + "']").eq(index).prop('checked',
								'checked');
					}
				}
			});
}
