<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <script language="JavaScript" src="../js/jquery-1.4.2.js"></script>
    <title>首页</title>
    <style type="text/css">
    <!--
        .e{text-shadow:black 50px 10px 10px;}
        .abc{text-decoration:none}
        .a{display:inline-black;height:30px;line-height:30px;}
        .p {background-color: green;height:100px}
        .b {background-color: green;height:100px}
        .c {text-align:center}
        #root {width 2000px;}
        #head {float:left; width:2000px;height:200px}
        #leftinformation {float:left;width:65%;}
        #root.rightlogin{float:right;width:35%;}
    -->
    </style>
    <script language="javascript">
       window.onload = function(){
           Test();
       };
       function Test(){
           var sourcenum = "0123456789";
           var singlenum = "";
           var checknumtest = "";
           var index = 0;
           for(i=0;i<8;i++){
               index = (Math.random()*100)%20;
               singlenum = sourcenum.substring(index,index+1);
               checknumtest+=singlenum;
               i++;
           }
           document.form1.checknum2.value = checknumtest;
       }
       function Check(){
           var id = document.getElementById("id").value;
           var pwd = document.getElementById("pwd").value;
           var checknum = document.getElementById("checknum").value;
           var checknum2 = document.getElementById("checknum2").value;
           var kind = document.getElementById("kind").value;
           var idlength = id.length;
           var pwdlength = pwd.length;
           var checknumlength = checknum.length;
           
           if(!idlength){
               idspan.innerHTML = "用户名不能为空";
               document.getElementById("id").focus;
               return false;
           }
           if(!pwdlength){
               pwdspan.innerHTML = "密码不能为空";
               document.getElementById("pwd").focus;
               return false;
           }
           if(!checknumlength){
               checknumspan.innerHTML = "请输入验证码";
               document.getElementById("checknum").focus;
               return false;
           }
           if(checknum!=checknum2){
               checknumspan.innerHTML = "验证码输入错误";
               document.getElementById("checknum").focus;
               return false;
           }
           window.location.href="/innovationExperiment/other_login.action?id="+id+"&pwd="+pwd+"&kind="+kind;
       }
    </script>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head> 
  <body>
    <div id="root" >
        <div id="head">
          <pre>                     <b><font size=7 color="yellow" class="b">南昌航空大学军训交流平台 </font></b><br><br><br>
                     <a href="#" class="abc"><font size=6 color="red" class="p"><b>军训回顾  军训介绍  教官介绍  军训交流   军训联谊  军训表白  </b></font></a>
          </pre>
        </div>        
        <div id="leftinformation">    
         <pre>                      <img src="images/2.jpg" class="c" width=350px height=200px /> 
         <br>
                                    <font size=5 color="red">军训公告</font>
         <br>                            <a href="../TrainChat/basic/notice1.jsp" class="abc" target="_blank"><font size=5 >10月1号军训开始声明</font></a>
         <br>                            <a href="../TrainChat/basic/notice2.jsp" class="abc" target="_blank"><font size=5 >10月7号军训检阅声明</font></a>
         </pre> 
        </div>
        <div id="rightlogin">
           <font size=5 color="blue" align="center"> 统一身份认证</font><br><br>
           <form id="form1" name="form1" action="" method=post>
           <table  style="height:100px">  
               <tr><td>学号</td><td><input type="text" id="id" name="id" /></td></tr>                          
               <tr><td></td><td><font color="red"><span id="idspan"></span></font></td>
               <tr><td>密码</td><td><input type="password" id="pwd" name="pwd" /></td></tr>                      
               <tr><td></td><td><font color="red"><span id="pwdspan"></span></font></td>
               <tr><td>类别</td><td>
                   <select name="kind" id="kind">
                      <option selected="selected" ="新生">新生</option>
                      <option value="教官">教官</option>
                      <option value="系统管理员">系统管理员</option>
                   </select> 
			   </td></tr>
			   <tr><td>验证码</td><td><input id="checknum" name="checknum" type="text" size="6" maxlength="4"/> <input type="text" name="checknum2" id="checknum2" size="4" readonly="true"/> <input type="button" value="换一个" onClick="Test()"/></td>
			   <tr><td></td><td><font color="red"><span id="checknumspan"></span></font>
			   <tr><td></td><td><input type="button" value="登录" onClick="Check()"/> <input type="reset" value="重置"/></td></tr>
               </table> 
           </form><br><br><br><pre>
        <font size=5 color="purple">快速通道</font><br>
  <font size=4><a href="http://www.nchu.edu.cn" class="abc" target="_blank">学校官网</a> <a href="http://jwc-publish.jwc.nchu.edu.cn/" class="abc" target="_blank">教务系统</a> <a href="http://210.35.35.5/" class="abc" target="_blank">图书馆</a></font>
         </pre>
         </div>
    </div>
  </body>
</html>
