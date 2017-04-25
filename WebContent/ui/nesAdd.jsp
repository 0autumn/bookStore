<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新闻增加</title>


</head>
<body>
   <form action="/easyBuy/news/addNews" method="post">
     新闻标题：<br/> <input name="title" type="text" value=""><br/>
     新闻内容：<br/> <textarea name="content" rows="10" cols="40"></textarea><br/>
    
    
    
    <input type="submit" value="提交">
    
    </form>
</body>
</html>