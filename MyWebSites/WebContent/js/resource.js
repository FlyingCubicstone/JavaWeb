$(function(){
	
	setInterval(function(){
		var a=new Date();
		$("#header_s3_span2").html(a.toLocaleTimeString());
		$("#header_s3_span1").html(a.toLocaleDateString());
		
	},1000);
	
})
