<%@ page import="com.opensymphony.xwork2.ActionContext" %>
<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: 25238
  Date: 6/30/2021
  Time: 4:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
    String path = request.getContextPath();
    String basePath=null;
    basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    int port=request.getServerPort();
    if(port==80){
        basePath=request.getScheme()+"://"+request.getServerName()+path;
    }else{
        basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;

    }
    request.setAttribute("basePath", basePath);
%>
<html>
<head>
  <title>GuestPage</title>
    <style>
        .btn{
            height:100%;
            display:inline-block;
            margin:auto;
            text-align: center;
            line-height: 60px;
        }
        .but{
            width: 100%;
            height: 60px;
        }
    </style>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="icon" href="../drawable/RacoonLogo.ico" type="image/x-icon" />
    <link rel="shortcut icon" href="../drawable/RacoonLogo.ico" type="image/x-icon" />
    <link rel="bookmark" href="../drawable/RacoonLogo.ico" type="image/x-icon" />
</head>
<body style="margin: 0px; padding: 0px; background-size: 100%; background-attachment: fixed; background-image: url('${basePath}/drawable/loginback.jpg')">
<div style="border: 1px solid #000000; width: 90%; margin: 0 auto; background-color: rgba(255,255,255,0.5)">
    <div style="border:1px solid #900;width:100%;height:60px; font-size: 0px; background-color: rgba(255,255,255,0.5)">
        <div class="btn" style="overflow: hidden; width:11%;">
            <s:form action="Page2Action" method="POST" cssClass="but">
                <s:hidden name="toURL" value="index2"></s:hidden>
                <s:submit value="主页" cssClass="but"></s:submit>
            </s:form>
        </div>
        <div class="btn" style="overflow: hidden; width:11%;">
            <s:form action="Page2Action" method="POST" cssClass="but">
                <s:hidden name="toURL" value="login"></s:hidden>
                <s:submit value="登陆" cssClass="but"></s:submit>
            </s:form>
        </div>
        <div class="btn" style="overflow: hidden; width:11%;">
            <s:form action="Page2Action" method="POST" cssClass="but">
                <s:hidden name="toURL" value="register"></s:hidden>
                <s:submit value="注册" cssClass="but"></s:submit>
            </s:form>
        </div>
        <div class="btn" style="overflow: hidden; font-size:15px; width:34%">
            搜索框
        </div>
    </div>
</div>
<div class="panel-body" style="height: 100%; overflow-y:scroll">
  <div style="border: 1px  #000000; width: 100%; margin: 0 auto; background-color: rgba(255,255,255,0.5)">
            <span>
                <div style="border: 1px solid #900; width: 90%; margin: 0 auto;text-align: center;font-size: 50pt;">
                    Writer:<s:property value="#session.Blogbean.writter"></s:property><br>
                    BlogID:<s:property value="#session.Blogbean.blogID"></s:property>
                </div>
                <div style="border: 1px solid #700; width: 90%; margin: 0 auto;text-align: center;font-size: 30pt;">
                    Written Time :  <s:property value="#session.Blogbean.writtenTime"></s:property> LastTime  : <s:property value="#session.Blogbean.lastTime"></s:property> Privacy:(<s:property value="#session.Blogbean.isPrivate"></s:property>)
                </div>
                <div style="border: 1px solid #500; width: 90%; margin: 0 auto;font-size: 30pt;">
                    <s:property value="#session.Blogbean.contents"></s:property>
                </div>
            </span>
  </div>
</div>

</body>
</html>
