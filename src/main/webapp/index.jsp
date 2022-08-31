<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="BBS.BBS" %>
<%@ page import="BBS.BBSDAO" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>방명록</title>
    <style>
        textarea{
            width: 200px;
            height: 120px;
        }
    </style>
</head>
<body>
<%
    BBSDAO bbsdao=new BBSDAO();
    List<BBS> list =bbsdao.getUser();
    for (int i=0; i< list.size(); i++) {


%>
<%= list.get(i).getId()%>
<%= list.get(i).getName()%>
<%= list.get(i).getTitle()%>
<%= list.get(i).getDate()%>
<%
    }
%>
<form>
이름:<input type="text" name="name">
<br>
내용:<textarea name="text"></textarea>
<br>
<button type="submit">제출</button>
</form>
</body>
</html>