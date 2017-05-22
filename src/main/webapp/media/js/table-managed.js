var TableManaged = function() {

	return {

		// main function to initiate the module
		init : function() {

			if (!jQuery().dataTable) {
				return;
			}

			// begin first table
			$('#sample_1')
					.dataTable(
							{
								"aoColumns" : [ {
									"bSortable" : false
								}, null, {
									"bSortable" : false
								}, null, {
									"bSortable" : false
								}, {
									"bSortable" : false
								} ],
								"aLengthMenu" : [ [ 5, 10, 15, 20 ],
										[ 5, 10, 15, 20 ] // change per
								],
								// set the initial value
								"iDisplayLength" : 10,
								"sDom" : "<'row-fluid'<'span6'l><'span6'f>r>t<'row-fluid'<'span6'i><'span6'p>>",
								"sPaginationType" : "bootstrap",
								"oLanguage" : {
									"sLengthMenu" : "每页显示 _MENU_ 条记录",
									"sZeroRecords" : "抱歉， 没有找到",
									"sInfo" : "从 _START_ 到 _END_ /共 _TOTAL_ 条数据",
									"sInfoEmpty" : "没有数据",
									"sInfoFiltered" : "(从 _MAX_ 条数据中检索)",
									"sZeroRecords" : "没有检索到数据",
									"sSearch" : "名称:",
									"oPaginate" : {
										"sFirst" : "首页",
										"sPrevious" : "前一页",
										"sNext" : "后一页",
										"sLast" : "尾页"
									},
									"aoColumnDefs" : [ {
										'bSortable' : false,
										'aTargets' : [ 0 ]
									} ]
								}
							});

		}

	};

}();