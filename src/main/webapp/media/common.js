$.extend({
	hr_show_msg : function(title, text,callback,callbackParam) {
		$.extend($.gritter.options, {
			position : 'bottom-right'
		});
		var unique_id = $.gritter.add({
			title : title,
			text : text,
			sticky : true,
			time : '2000',
			class_name : 'my-sticky-class'
		});
		setTimeout(function() {
			$.gritter.remove(unique_id, {
				fade : true,
				speed : 1000
			});
			if('function'=== typeof callback){
				setTimeout(function() {
					callback(callbackParam);
				}, 1000)
			}
		}, 1500);
	},
	hr_contextUrl:function(){
		//获取当前网址，如： http://localhost:8083/uimcardprj/share/meun.jsp
	    var curWwwPath=window.document.location.href;
	    //获取主机地址之后的目录，如： uimcardprj/share/meun.jsp
	    var pathName=window.document.location.pathname;
	    var pos=curWwwPath.indexOf(pathName);
	    //获取主机地址，如： http://localhost:8083
	    var localhostPaht=curWwwPath.substring(0,pos);
	    //获取带"/"的项目名，如：/uimcardprj
	    var projectName=pathName.substring(0,pathName.indexOf('/')+1);
	    return localhostPaht+projectName;
	},
	hr_confirm:function(id,msg,okCallback,cancleCallback){
		if($(id).length===0){
			var html = '<div id="'+id+'" title="系统提示" >'+
			'<p><span class="icon icon-warning-sign"></span>'+msg+'</p></div>';
			$(".portlet-body").append(html);
		}
		$("#"+id).dialog({
	      dialogClass: 'ui-dialog-grey',
	      autoOpen: true,
	      resizable: false,
	      height: 110,
	      modal: true,
	      buttons: [
	      	{
	      		'class' : 'btn red',	
	      		"text" : "确定",
	      		click: function() {
	      			if(okCallback){
	      				okCallback.fn(okCallback.params);
	      			}
        			$(this).dialog( "close" );
      			}
	      	},
	      	{
	      		'class' : 'btn',
	      		"text" : "取消",
	      		click: function() {
	      			if(cancleCallback){
	      				cancleCallback.fn(cancleCallback.params);
	      			}
        			$(this).dialog( "close" );
      			}
	      	}
	      ]
	    });
	}
});

jQuery.fn.extend({
	  loader: function(json) {
	    return this.each(function() {
	    	var _this = $(this);
	    	if(_this.is("form")&&json){
	    		$.each(json,function(name,value){
	    			$("input[name="+name+"],textarea[name="+name+"],select[name="+name+"]",_this).each(function(){
	    				if($(this).is("[type='checkbox']")){
	    					var val = $(this).val();
	    					if(val===value){
	    						$(this).attr('checked', true);
	    				        $(this).parents('.checker').find('span').addClass('checked');
	    					}
		    			}else if($(this).is("[type='radio']")){
		    				$(this).attr('checked', true);
    				        $(this).parents('.radio').find('span').addClass('checked');
    				        var uncheckElement = $("input[name="+name+"][type='radio'][value!="+value+"]");
    				        uncheckElement.attr('checked', false);
    				        uncheckElement.parents('.radio').find('span').removeClass('checked');
		    			}else{
		    				$(this).val(value);
		    			}
	    			});
	    		});
	    	}
	    });
	  },
	  disableForm:function(){
		  return this.each(function(){
			  if($(this).is('form')){
				  $("input,textarea,select,button").attr('disabled',true);
			  }
		  });
	  },
	  enableForm:function(){
		  return this.each(function(){
			  if($(this).is('form')){
				  $("input,textarea,select,button").removeAttr('disabled');
			  }
		  });
	  },
	  resetForm:function(){
		  this.each(function(){
			  if($(this).is('form')){
				  $("input,textarea,select,button").val('').removeAttr("checked").removeAttr("selected");
			  }
		  });
	  }
})


