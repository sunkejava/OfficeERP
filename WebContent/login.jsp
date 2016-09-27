<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录页</title>
<title>Login Page | Amaze UI Example</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="format-detection" content="telephone=no">
<meta name="renderer" content="webkit">
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="alternate icon" type="image/png" href="i/favicon.png">
<link rel="stylesheet" href="css/amazeui.min.css"/>
<link rel="stylesheet" href="css/app.css">
<link type="text/css" rel="stylesheet" href="css/showBo.css" />
<script type="text/javascript" src="js/showBo.js"></script>
  <style>
	.am-btn{
		margin:10px;
	}
	.am-panel{
		text-align:center;
		margin:0 auto;
	}
  </style>
</head>
<body>
<section class="am-panel am-panel-primary">
  <header class="am-panel-hd">
    <h3 class="am-panel-title">登陆界面</h3>
  </header>
<div class="am-panel-bd">
<form action="" class="am-form" data-am-validator>
  <fieldset>
    <div id = "pwdas" class="am-form-group">
      <label for="doc-vld-name-2">服务器：
      <input type="text" id="serverName" name = "serverName" minlength="3" placeholder="输入服务器地址" required/>
	  </label>
    </div>
	
	<div class="am-form-group">
      <label for="doc-vld-name-2">账  号：
      <input type="text" id="accountName" name = "accountName" minlength="3" placeholder="输入您的账号（至少 3 个字符）" onblur="getAccountcode()" required/>
	  </label>
    </div>
	<div id="pwdbox">
		<div id= "psd" class="am-form-group">
		  <label id="pwds" for="doc-vld-password-2">密  码：
		  <input type="password" id="password" placeholder="输入密码" required/>
		  </label>
		</div>
	</div>
	
	<div class="am-form-group">
      <label for="doc-vld-name-2">账  套：
  <select id= "accountbox" data-am-selected="{btnWidth: '80%', btnSize: 'sm', btnStyle: 'default'}">
	  <option id= "account1" value="a">手动选择需要登陆的账套</option>
	  <option id= "account2" value="b">账套二</option>
	  <option id= "account3" value="o">账套三</option>
  </select>
	</label>
    </div>
	
    <button id="commita" class="am-btn am-btn-primary am-round" type="submit" onclick="Login()">确认</button>
	<button class="am-btn am-btn-primary am-round" type="submit">取消</button>
	<label class="am-checkbox-inline">
        <input type="checkbox" value="修改密码" name="docVlCb" onclick="checkboxOnclick(this)" minchecked="2" maxchecked="4" required> 修改密码
     </label>
  </fieldset>
</form>
</div>
 <footer class="am-panel-footer">
 <p>
	地址：北京市海淀区天秀路10号中国农大国际创业园1号楼B418-423室&nbsp;&nbsp;&nbsp;电话：010-82350369/7997 &nbsp;传真：010-82350369/7997-816 E-Mail：<a href="mailto:keditong@163.com">keditong@163.com</a><br />
	版权所有 &copy; 2005-2016 北京科迪通信息技术有限公司 京ICP备14041841号-1<br /></p>
 </footer>
</section>
</body>
<script type="text/javascript">
function checkboxOnclick(checkbox){

	if ( checkbox.checked == true){
		document.getElementById("password").setAttribute("placeholder","输入旧密码");
		var tbody = $("#pwdbox");
		tbody.append("<div id= 'psd1' class='am-form-group'><label for='doc-vld-password-2'>新密码 ：<input type='password' id='newpassword' placeholder='输入新密码' required/></label></div><div id= 'psd2' class='am-form-group'><label for='doc-vld-password-2'>确认密码 ：<input type='password' id='newpassword2' placeholder='再次输入密码' required/></label></div>");
	}else{
		var tbodys = document.getElementById("pwdbox");
		var tbody1 = document.getElementById("psd1");
		var tbody2 = document.getElementById("psd2");
		tbodys.removeChild(tbody1);
		tbodys.removeChild(tbody2);
		document.getElementById("password").setAttribute("placeholder","输入密码");
	}

}
function Login(){
	var serverName = $("#serverName").val();
	var accountName = $("#accountName").val();
	var password = $("#password").val();
	var newpassword = $("#newpassword").val();
	var newpassword2 = $("#newpassword2").val();
	if(serverName == "" || accountName == "" || password == "" || newpassword =="" || newpassword2 ==""){
		Showbo.Msg.alert("查看信息是否正确！")
	}
}
function getAccountcode(){
	var serverName = $("#serverName").val();
	var accountName = $("#accountName").val();
	if(serverName == "" ){
		Showbo.Msg.alert("请输入服务器地址！");
	}else if (accountName == ""){
		Showbo.Msg.alert("请输入用户名！");
	}else{
		
	}
}
loadData("${param.accountName}","${param.serverName}");
function loadData(serverName,accountName){
	$.getJSON("http://localhost:8080/OfficeERP/indexn?jsoncallback=?",{serverName:serverName,accountName:accountName},function(result){
		if(result.length==0){
			Showbo.Msg.alert("请确认服务器地址或用户名是否正确");
		}else{
			var tbody = $("#accountbox");
			var tbody1 = document.getElementById("account1");
			var tbody2 = document.getElementById("account2");
			var tbody3 = document.getElementById("account3");
			tbody.removeChild(tbody1);
			tbody.removeChild(tbody2);
			tbody.removeChild(tbody3);
			$.each(result,function(i,val){
				sumpage = val.maxpage;
					tbody.append("<option id= 'account'+toString(i) value="+val.accountName+">"+val.accountName+"</option>");
			});
		}
	},"json");
}
</script>
<!--[if (gte IE 9)|!(IE)]><!-->
<script src="js/jquery.min.js"></script>
<!--<![endif]-->
<!--[if lte IE 8 ]>
<script src="http://libs.baidu.com/jquery/1.11.3/jquery.min.js"></script>
<script src="http://cdn.staticfile.org/modernizr/2.8.3/modernizr.js"></script>
<script src="js/amazeui.ie8polyfill.min.js"></script>
<![endif]-->
<script src="js/amazeui.min.js"></script>
</html>