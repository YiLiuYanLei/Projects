<%@ page import="com.opensymphony.xwork2.ActionContext" %>
<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: 25238
  Date: 6/21/2021
  Time: 12:42 PM
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
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>登录</title>
    <link rel="icon" href="../drawable/RacoonLogo.ico" type="image/x-icon" />
    <link rel="shortcut icon" href="../drawable/RacoonLogo.ico" type="image/x-icon" />
    <link rel="bookmark" href="../drawable/RacoonLogo.ico" type="image/x-icon" />
    <style>
        .red{
            color:red;
        }
    </style>
</head>
<body style="margin: 0px; padding: 0px; background-size: 100%; background-attachment: fixed; background-image: url('${basePath}/drawable/loginback.jpg')">
<div style="height: 80px"></div>

<div style="margin: 0 auto; width: 350px; height: 650px; border: solid black; border-radius: 20px;background-color: rgba(255,255,255,0.3)">
    <div style="height: 130px">
        <h1 style="text-align: center; font-size: 50px">欢迎登录</h1>
    </div>
    <center>
        <div style="height: 315px;">
            <div style="width: 100px;height: 100px;background-size: 100%;background-repeat: no-repeat;background-image: url('${basePath}/drawable/RacoonLogo.png')"></div>
            <s:form id="form1" action="LoginAction" method="post">
                <div class="red">
                    <s:property value="#session.ERROR"></s:property>
                </div>

                <table style="border-collapse: separate; border-spacing: 15px; font-size: 20px">
                    <tr>
                        <th>
                            <s:textfield label="用户名" name="username" placeholder="请输入用户名" cssStyle="font-size: 20px; border-radius: 5px; outline: none; width: 175px;"></s:textfield>
                        </th>
                    </tr>
                    <tr>
                        <th>
                            <s:password label="密码" name="password" placeholder="请输入密码" cssStyle="font-size: 20px; border-radius: 5px; outline: none; width: 175px;"></s:password>
                        </th>
                    </tr>
                    <tr>
                        <th>
                            <s:textfield label="管理员登陆" name="isAdmin" placeholder="请输入true/false" cssStyle="font-size: 20px; border-radius: 5px; outline: none; width: 175px;"></s:textfield>
                        </th>
                    </tr>
                </table>
                <s:submit value="登陆" cssStyle="height: 30px; width: 70px;  border-radius: 5px"></s:submit>
            </s:form>

            <s:form action="Page2Action" method="POST">
                <s:hidden name="toURL" value="index2"></s:hidden>
                <s:submit value="游客登陆" cssStyle="height: 30px; width: 70px;  border-radius: 5px"></s:submit>
            </s:form>

            <s:form action="Page2Action" method="POST">
                <s:hidden name="toURL" value="register"></s:hidden>
                <s:submit value="点此注册" cssStyle="height: 30px; width: 70px;  border-radius: 5px"></s:submit>
            </s:form>
        </div>
    </center>
</div>
</body>
</html>
