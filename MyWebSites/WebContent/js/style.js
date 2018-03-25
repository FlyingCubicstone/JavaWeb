//获取时间，将时、分、秒分别放到不同的div元素中，每个元素放一位数
function showtime(){
	setInterval(function(){
		var a=new Date();
		document.getElementById("main_body_d3").innerText=Math.floor(a.getHours()/10);
		document.getElementById("main_body_d4").innerText=(a.getHours()%10);
		document.getElementById("main_body_d7").innerText=":";
		document.getElementById("main_body_d8").innerText=Math.floor(a.getMinutes()/10);
		document.getElementById("main_body_d9").innerText=Math.floor(a.getMinutes()%10);
		//将秒分成两位放在d12元素的子元素span1、span2中
		document.getElementById("span1").innerText=Math.floor(a.getSeconds()/10);
		document.getElementById("span2").innerText=Math.floor(a.getSeconds()%10);
	},1000);
}
//将访问者写入count_user数据库
function countuser(){
	
	if(document.cookie==""){
		var name="anonymity";
		$.ajax({
			type:"post",
			url:"http://localhost:8080/MyWebSites/m/LoginState.do",
		
			data:{"name":name}
		})
	
}
}	
//统计所有访问者数量（未登录及登录的）
function countvisitor(){
	$.ajax({
		type:"post",
		url:"http://localhost:8080/MyWebSites/count/count.do",
		datatype:"json",
		success:function(result){
			
			$("#countvisitor").html(result.msg);
		}
		
	})
}
function setcolor(){
	//获取id为main_body_d3 d4 d7 d8 d9的div元素
	var d3=document.getElementById("main_body_d3");
	var d4=document.getElementById("main_body_d4");
	var d7=document.getElementById("main_body_d7");
	var d8=document.getElementById("main_body_d8");
	var d9=document.getElementById("main_body_d9");
	//随机获取rgb颜色值，分别对应a，b，c
	var a=Math.round(Math.random()*255);
	var b=Math.round(Math.random()*255);
	var c=Math.round(Math.random()*255);
	//i，j，k分别控制a，b，c在0-255之间加减
	var i=1;
	var j=1;
	var k=1;
	//计时器实现每50ms变换一次RGB值
	setInterval(function(){
		//R值实现在0-255内变换
	  if(a<=0){
		i=1;}
	  if(a>=255){
		i=-1;}
	  //G值实现在0-255内变换
	  if(b<=0){
		j=1;}
	  if(b>=255){
		j=-1;}
	  //B值实现在0-255内变换
	  if(c<=0){
		k=1;}
	  if(c>=255){
		k=-1;}
	  	//id为 d4，d8的div设置背景颜色，
	  d4.style.backgroundColor="rgba("+(a+=i)+","+(b+=j)+","+(c+=k)+","+"0.8)";
	  d8.style.backgroundColor="rgba("+(a+=i)+","+(b+=j)+","+(c+=k)+","+"0.8)";
	},100);
	//获取当前星期，星期日为0，星期一为1，一次类推；
	var date=new Date();
	var weekday=date.getDay();
	
	//d3，d7，d9每天变换一种颜色，七天一循环
	switch(weekday){
		case(0):
		d3.setAttribute("class","sunday");
		d7.setAttribute("class","sunday");
		d9.setAttribute("class","sunday");
		break;
		case(1):
		d3.setAttribute("class","monday");
		d7.setAttribute("class","monday");
		d9.setAttribute("class","monday");
		break;
		case(2):
		d3.setAttribute("class","tuesday");
		d7.setAttribute("class","tuesday");
		d9.setAttribute("class","tuesday");
		break;
		case(3):
		d3.setAttribute("class","wednesday");
		d7.setAttribute("class","wednesday");
		d9.setAttribute("class","wednesday");
		break;
		case(4):
		d3.setAttribute("class","thursday");
		d7.setAttribute("class","thursday");
		d9.setAttribute("class","thursday");
		break;
		case(5):
		d3.setAttribute("class","friday");
		d7.setAttribute("class","friday");
		d9.setAttribute("class","friday");
		break;
		case(6):
		d3.setAttribute("class","saturday");
		d7.setAttribute("class","saturday");
		d9.setAttribute("class","saturday");
		break;
	}
}
//导航栏的日期
function setdate(){
	var date=new Date();
	document.getElementById("header_s3_span1").innerText=date.toDateString();
	
}


//将登陆的用户名显示出来

function setusername(){
			
		$.ajax({
			type:"post",
			url:"http://localhost:8080/MyWebSites/m/askforname.do",
			dataType:"json",
			success:function(dp){
				if(dp.msg=="anonymity"){
					document.getElementById("b1").href="login.html";
					document.getElementById("b1").innerText="登录";
					document.getElementById("b2").href="signup.html";
					document.getElementById("b2").innerText="注册";
				}
				//可能有bug，待定。。。。。
				else
					{
					document.getElementById("b1").href="";
					
						document.getElementById("b1").innerText="欢迎您:"+dp.msg;
					
					
					document.getElementById("b2").href="";
					document.getElementById("b2").innerText="注销";
					}
			}
			});
		}
//点击注销后的操作
$(function(){
	$("#b2").click(function(){
		var temp=$("#b2").text();
		var context=$("#b1").text();
		var username=context.split(":");
		
		if(temp!="注册"){
		$.ajax({
			type:"post",
			data:{"name":username[1]},
			url:"http://localhost:8080/MyWebSites/Logout/Logout.do",
			dataType:"json",
			
		    success:function(dp1){
		    	
			if(dp1.msg=="注销成功"){
				
				document.getElementById("b1").href="login.html";
				document.getElementById("b1").innerText="登录";
				document.getElementById("b2").href="signup.html";
				document.getElementById("b2").innerText="注册";
				//向LoginState发送请求，将c_name设置为匿名用户
				//防止注销后，依然显示已登录的用户；
				$.ajax({
					type:"post",
					data:{"i":0},
					url:"http://localhost:8080/MyWebSites/m/unbindname.do"});
				window.location.href="index.html";
			
		}}
		});}
	});
	
})
//点击资源和关于我后，向controller发送请求，若是已登录用户则可跳转至
//“资源”网页，若是某个特定的用户则可跳转至“关于我”网页
$(function(){
	//a2为“关于我”
	$("#a2").click(function(){
		//获取已登录用户名
		
		var context=$("#b1").text();
		var username=context.split(":");
		
		$.ajax({
			type:"post",
			url:"http://localhost:8080/MyWebSites/Src/getSrc.do",
			data:{"name":username[1]},
			dataType:"json",
		    success:function(result){
		    	if(result.status==1){
		    		
		    		window.location.href="aboutme.html";
		    		}
		    	if(result.status==0){
		    		alert(result.msg);
		    		}
		    	if(result.status==2){
		    		alert("对不起，无权限查看！");
		    		}
		    }
			
	    
		});
		
		
		
	})
	//a4为“资源”
	$("#a4").click(function(){
		//获取已登录用户名 
	
		var context=$("#b1").text();
		var username=context.split(":");
		
		$.ajax({
			type:"post",
			url:"http://localhost:8080/MyWebSites/Src/getSrc.do",
			data:{"name":username[1]},
			dataType:"json",
		    success:function(result){
		    	if(result.status==2||result.status==1){
		    		
		    		window.location.href="resource.html";
		    	}
		    	if(result.status==0){
		    		alert(result.msg);
		    		
		    	}
		    }
		});
		
		
	})
	
})
