 //室外消防给水系统验证
    $('#OutdoorFireWaterSystem')
    .bootstrapValidator({
        message: 'This value is not valid',
        live: 'enabled',
        trigger:'blur keyup',   
        feedbackIcons: {//input状态样式图片
            valid: 'glyphicon',
            invalid: 'glyphicon ',
            validating: 'glyphicon'
        },
        container: 'popover',
        fields: {//验证：规则           	
        	systemName: {
                  message:'系统名称',             
                  validators: {
                      notEmpty: {
                          message: '系统名称不能为空'
                      }
                  }
              },
              systemState: {
                  message:'系统状态',                  
                  validators: {
                      notEmpty: {
                          message: '系统状态不能为空'
                      }
                  }
              },
              systemForm: {
                  message:'系统形式',                  
                  validators: {
                      notEmpty: {
                          message: '系统形式不能为空'
                      }
                  }
              },
              theirPositions: {
                message:'所在部位',             
                validators: {
                    notEmpty: {
                        message: '所在部位不能为空'
                    }
                }
            },
            responsibleDepartment: {
                message:'责任部门',                  
                validators: {
                    notEmpty: {
                        message: '责任部门不能为空'
                    }
                }
            },
            personCharge: {
                message:'责任人',             
                validators: {
                    notEmpty: {
                        message: '责任人不能为空'
                    }
                }
            },
            maintainingUnit: {
                message:'维修保养单位',             
                validators: {
                    notEmpty: {
                        message: '维修保养单位不能为空'
                    }
                }
            },
            designUnit: {
                message:'设计单位',             
                validators: {
                    notEmpty: {
                        message: '设计单位不能为空'
                    }
                }
            },
            constructionUnit: {
                message:'施工单位',             
                validators: {
                    notEmpty: {
                        message: '施工单位不能为空'
                    }
                }
            },
            supervisingUnit: {
                message:'监理单位',             
                validators: {
                    notEmpty: {
                        message: '监理单位不能为空'
                    }
                }
            },        
            doYouHaveFireSign: {
                message:'消防标识',             
                validators: {
                    notEmpty: {
                        message: '必须选择消防标识'
                    }
                }
            },
            operationMethod: {
                message:'操作使用方法',             
                validators: {
                    notEmpty: {
                        message: '操作使用方法不能为空'
                    }
                }
            },
            otherSituations: {
                message:'其它情况',             
                validators: {
                    notEmpty: {
                        message: '其它情况不能为空'
                    }
                }
            },
            municipalWaterPipeNumber: {
                message:'市政给水管数量',             
                validators: {
                    notEmpty: {
                        message: '市政给水管数量不能为空'
                    },regexp: {
                        regexp: /^[0-9]+$/,
                        message: '必须为数字'
                    }
                }
            },
            qutdoorPoolCapacity: {
                message:'室外水池容量',                  
                validators: {
                    notEmpty: {
                        message: '室外水池容量不能为空'
                    },regexp: {
                        regexp: /^\d+(\.\d+)?$/,
                        message: '必须为数字或小数'
                    }
                }
            },
            qutdoorRingDiameter: {
                message:'室外环网管径',                  
                validators: {
                    notEmpty: {
                        message: '室外环网管径不能为空'
                    },regexp: {
                        regexp: /^\d+(\.\d+)?$/,
                        message: '必须为数字或小数'
                    }
                }
            },
            waterSupplyState: {
              message:'管网供水状态',             
              validators: {
                  notEmpty: {
                      message: '管网供水状态不能为空'
                  }
              }
          },
          pressure: {
              message:'压力',                  
              validators: {
                  notEmpty: {
                      message: '压力不能为空'
                  },regexp: {
                      regexp: /^\d+(\.\d+)?$/,
                      message: '必须为数字或小数'
                  }
              }
          },
          municipalFeedPipeDiameter: {
              message:'市政给水管管径',             
              validators: {
                  notEmpty: {
                      message: '市政给水管管径不能为空'
                  },regexp: {
                      regexp: /^\d+(\.\d+)?$/,
                      message: '必须为数字或小数'
                  }
              }
          },
          qutdoorFireHydrantNumber: {
              message:'室外消火栓数量',             
              validators: {
                  notEmpty: {
                      message: '室外消火栓数量不能为空'
                  },regexp: {
                      regexp: /^[0-9]+$/,
                      message: '必须为数字'
                  }
              }
          },
          siameseConnectionNumber: {
              message:'水泵接合器数量',             
              validators: {
                  notEmpty: {
                      message: '水泵接合器数量不能为空'
                  },regexp: {
                      regexp: /^[0-9]+$/,
                      message: '必须为数字'
                  }
              }
          },
          networkForm: {
              message:'管网形式',             
              validators: {
                  notEmpty: {
                      message: '管网形式不能为空'
                  }
              }
          },
          feedTube: {
              message:'进水管径',             
              validators: {
                  notEmpty: {
                      message: '进水管径不能为空'
                  },regexp: {
                      regexp: /^\d+(\.\d+)?$/,
                      message: '必须为数字或小数'
                  }
              }
          },
          waterSituation: {
              message:'可供消防车取水的天然水源情况',                  
              validators: {
                  notEmpty: {
                      message: '可供消防车取水的天然水源情况不能为空'
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
            var t = $('#OutdoorFireWaterSystem').serializeArray();
            $.each(t, function() {
             data[this.name] = this.value;
          });
    		$.ajax({
     		    url: '/fireFacilitie/edit?facilitieCode='+getUrlParam("facilitieCode")+'&facilitieSystemCode='+getUrlParam("facilitieSystemCode"),
     		    type: 'put',	
     		    contentType: "application/json; charset=utf-8",
     	        data: JSON.stringify(data),
     	        dataType: "json",
     		    success: function(data) {
     		    	if (data.status == 200) {
						// 重新加载
						setTimeout(function() {
							layer.closeAll('loading');
							var index = parent.layer
									.getFrameIndex(window.name);
							parent.layer.close(index);
							var url = parent.$(".bg_blue").attr(
									"data-url");
							var title = parent.$(".bg_blue").find('font').text();
							title = $.trim(title);
							parent.$(".on").load(getTypeUrl(url,title));
						}, 500);
						toastr.success(data.msg)
					} else {
						toastr.error(data.msg)
					}   		    	
     		    },
     		    error:function(data){
     		    	toastr.error("服务器无响应")
     		}
     		});
        }

    }); 

  