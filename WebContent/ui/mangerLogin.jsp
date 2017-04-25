<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
    <link href="/easyBuy/css/alogin.css" rel="stylesheet" type="text/css" />
 <script type="text/javascript">
  function isNull(){
	
	  var t1=document.getElementById("Text1");
	  var t2=document.getElementById("Text2");
	 if(t1.value==null||t1.value==""){
		  t1.style.color="red";
		  t1.value="此处为空";
	  }else if(t2.value==null||t2.value==""){	
		  t2.style.color="red";
		  t2.value="此处为空";
	  }
  }
  function add1(){
	  var t1=document.getElementById("Text1");
	  if(t1.value=="此处为空"){
	           t1.value="";
	  }
	  t1.style.color="#999999";
	 
  }
  function add2(){
	  var t2=document.getElementById("Text2");
	  if(t2.value=="此处为空"){
          t2.value="";
 }
	 
	  t2.style.color="#999999";
	  
  }
 </script>
</head>
<body>
  
    <div class="Main">
  
        <ul>
          <form id="form"  method="post" name="form1">
            <li class="top"></li>
            <li class="top2"></li>
            <li class="topA"></li>
            <li class="topB"><span>
                <img src="/easyBuy/images/login/logo.gif" alt="" style="" />
            </span></li>
            <li class="topC"></li>
            <li class="topD">
         
                <ul class="login">
                
                    <li><span class="left">用户名：   </span> <span style="left">
                        <input name="userName" id="Text1" type="text" class="txt" onblur="isNull()" onfocus="add1()"/>  
                     
                    </span></li>
                    <li><span class="left">密码：</span> <span style="left">
                       <input name="passWord" id="Text2" type="password" class="txt" onblur="isNull()" onfocus="add2()"/>  
                    </span>
                    </li>
                    
                </ul>
       
            </li>
            <li class="topE"></li>
            <li class="middle_A"></li>
            <li class="middle_B"></li>
            <li class="middle_C">
            <span class="btn">
          
           
             
         <input  type="image" src="/easyBuy/images/login/btnlogin.gif"  onClick="this.form.action='/easyBuy/manger/user/successLogin';this.form.submit()">
           
           </span>
            </li>
            <li class="middle_D"></li>
            <li class="bottom_A"></li>
            <li class="bottom_B">
          
            </li>
        </ul>
         </form>
    </div>
    
</body>
</html>
