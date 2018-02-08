function Uploader(id, name) {
	var Uploader = Q.Uploader, formatSize = Q.formatSize, boxView = document
			.getElementById("upload-info");

	new Uploader(
			{
				url : "/upload",
				target : document.getElementById(id),
				multiple : false,
				// clickTrigger: false,
				allows : ".jpg,.png,.gif,.bmp",
				on : {
					// 添加之前触发
					add : function(task) {
						if (task.disabled)
							return layer.alert("允许上传的文件格式为：" + this.ops.allows);
					}, // 上传完成后触发
					complete : function(task) {
						var data = task.json;
						if (!data)
							return toastr.error("服务器无响应");
						if (data.status == 200) {
							toastr.success(data.msg)
							$('#pic').attr('src', data.data.fileurl);
							$("[name='" + name + "']").val(data.data.fileurl);
							$("#" + id)
									.html(
											'修改图片 <i class="fa fa-refresh" style="margin-left: 5px;"></i>');

						} else {
							toastr.error(data.msg)
						}
					}
				},
				// 自定义UI实现,无需导入 Q.Uploader.UI.js 和 uploader.css
				UI : {
					// init: function () { },
					draw : function(task) {
						this.update(task);
					},
					update : function(task) {
						var total = task.total || task.size, loaded = task.loaded, state = task.state;
						var html = '';
						if (total > 0) {

							// if (loaded != undefined) html += '<span
							// class="u-loaded">' + formatSize(loaded) +
							// '</span> / ';
							// html += '<span class="u-total">' +
							// formatSize(total) + '</span>';

							if (loaded != undefined) {
								var percentText = "0";

								if (state == Uploader.PROCESSING) {
									var percent = Math.min(
											loaded * 100 / total, 100);

									percentText = percent.toFixed(1);
									if (percentText == "100.0")
										percentText = "99.9";

								} else if (state == Uploader.COMPLETE) {
									percentText = "100";
								}

								html += '<div class="u-detail">'
										+ Uploader.getStatusText(state)
										+ '&nbsp;&nbsp;' + percentText
										+ "%</div>";
								html += '<div class="u-progress-bar" style="opacity: 0.3;"><div class="u-progress" style="opacity: 0.5; width: 0%;"></div></div>';

							}
						}

						boxView.innerHTML = html;
					}// ,
				// over: function (task) { }
				}
			});
}

function Uploaderimg(id, imgId, infoId, drawingType) {
	var Uploader = Q.Uploader, formatSize = Q.formatSize, boxView = document
			.getElementById(infoId);

	new Uploader(
			{
				url : "/upload",
				target : document.getElementById(id),
				multiple : false,
				// clickTrigger: false,
				allows : ".jpg,.png,.gif,.bmp",
				on : {
					// 添加之前触发
					add : function(task) {
						if (task.disabled)
							return layer.alert("允许上传的文件格式为：" + this.ops.allows);
					}, // 上传完成后触发
					complete : function(task) {
						var data = task.json;
						if (!data)
							return toastr.error("服务器无响应");
						if (data.status == 200) {
							data.data.fileurl
							var src = data.data.fileurl.replace(task.ext, "");
							src=src+"_normal"+task.ext
							$('#' + imgId).attr('src', src);
							var name = task.name.replace(task.ext, "");
							var data = {
								"buildCode" : getUrlParam("buildCode"),
								"drawingName" : name,
								"drawingType" : drawingType,
								"floorCode" : $("[name='floorCode']").val(),
								"drawingUrl" : data.data.fileurl
							};
						
							$
									.ajax({
										url : "/twodimensionaldrawing/edit",
										type : "post",
										contentType : "application/json; charset=utf-8",
										data : JSON.stringify(data),
										dataType : "json",
										success : function(data) {
											if (data.status == 200) {										
												toastr.success(data.msg)
											} else {
												toastr.error(data.msg)
											}
										},
										error : function(data) {
											toastr.error("服务器无响应")
										}
									});

						} else {
							toastr.error(data.msg)
						}
					}
				},
				// 自定义UI实现,无需导入 Q.Uploader.UI.js 和 uploader.css
				UI : {
					// init: function () { },
					draw : function(task) {
						this.update(task);
					},
					update : function(task) {
						var total = task.total || task.size, loaded = task.loaded, state = task.state;
						var html = '';
						if (total > 0) {

							// if (loaded != undefined) html += '<span
							// class="u-loaded">' + formatSize(loaded) +
							// '</span> / ';
							// html += '<span class="u-total">' +
							// formatSize(total) + '</span>';

							if (loaded != undefined) {
								var percentText = "0";

								if (state == Uploader.PROCESSING) {
									var percent = Math.min(
											loaded * 100 / total, 100);

									percentText = percent.toFixed(1);
									if (percentText == "100.0")
										percentText = "99.9";

								} else if (state == Uploader.COMPLETE) {
									percentText = "100";
								}

								html += '<div class="u-detail">'
										+ Uploader.getStatusText(state)
										+ '&nbsp;&nbsp;' + percentText
										+ "%</div>";
								html += '<div class="u-progress-bar" style="opacity: 0.3;"><div class="u-progress" style="opacity: 0.5; width: 0%;"></div></div>';

							}
						}

						boxView.innerHTML = html;
					}// ,
				// over: function (task) { }
				}
			});
}