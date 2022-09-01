<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="BBS.BBS" %>
<%@ page import="BBS.BBSDAO" %>
<%@ page import="java.io.PrintWriter" %>

<%
    request.setCharacterEncoding("UTF-8");

    String Name=null;
    String Title=null;


    if(request.getParameter("Name") != null){
        Name=(String) request.getParameter("Name");
    }
    if(request.getParameter("Title") != null){
        Title=(String) request.getParameter("Title");
    }

    if(Name.equals("") || Title.equals("")){
        PrintWriter script=response.getWriter();
        script.println("<script>");
        script.println("alert('입력 안된 사항이 있습니다!')");
        script.println("location.href='index.jsp'");
        script.println("</script>");
        script.close();
        return;
    }

    BBS bbs=new BBS(Name,Title);
    BBSDAO bbsdao=new BBSDAO();
    int insertCount=bbsdao.adduser(bbs);

    if(insertCount==1){
        PrintWriter script=response.getWriter();
        script.println("<script>");
        script.println("alert('추가에 성공하였습니다.')");
        script.println("location.href='index.jsp'");
        script.println("</script>");
        script.close();
        return;
        //방명록 만들기 끝 이제 스프링으로 넘어갑니다!
    }
%>
