var chart = $('#fireControlInstrumen').highcharts(
		{
			chart : {
				type : 'spline'
			},
			title : {
				text : '历史记录',
				x : -420,
				style : {
					'fontSize' : '14px'
				}
			},
			scrollbar : {
				enabled : true
			},
			legend : {
				enabled : false
			},
			xAxis : {
				categories : [ '00:01~01:00', '01:01~02:00', '02:01~03:00',
						'03:01~04:00', '04:01~05:00', '05:01~06:00',
						'06:01~07:00', '07:01~08:00', '08:01~09:00',
						'09:01~10:00', '10:01~11:00', '11:01~12:00',
						'12:01~13:00', '13:01~14:00', '14:01~15:00',
						'15:01~16:00', '16:01~17:00', '17:01~18:00',
						'18:01~19:00', '19:01~20:00', '20:01~21:00',
						'21:01~22:00', '22:01~23:00', '23:01~24:00' ],
				min : 0,
				max : 10
			},
			yAxis : {
				title : {
					text : '巡查数 (次)'
				},
				plotLines : [ {
					value : 0,
					width : 1,
					color : '#808080'
				} ]
			},
			tooltip : {
				valueSuffix : '次'
			},
			exporting : {
				enabled : false
			},
			credits : {
				enabled : false
			// 不显示LOGO
			},
			series : [ {
				data : [ 1, 2, 3, 4, 5, 6, 6, 6, 7, 12, 13, 9, 7, 6, 4, 9, 13,
						9, 13, 9, 12, 14, 2, 9 ],
				showInLegend : false
			} ]
		});