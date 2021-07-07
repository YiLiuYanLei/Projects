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
    <title>后台</title>
    <link rel="icon" href="../drawable/RacoonLogo.ico" type="image/x-icon" />
    <link rel="shortcut icon" href="../drawable/RacoonLogo.ico" type="image/x-icon" />
    <link rel="bookmark" href="../drawable/RacoonLogo.ico" type="image/x-icon" />
</head>

<body style="margin: 0px; padding: 0px; background-size: 100%; background-attachment: fixed; background-image: url('${basePath}/drawable/loginback.jpg')">
<div style="height: 80px"></div>
<div style="background-color: rgba(255,255,255,0.3)">
    <center>
        <div style="display: inline-block; margin: 0 auto; width: 350px; height: 550px; border: solid black; border-radius: 20px;background-color: rgba(255,255,255,0.3)">
            <div style="height: 130px;">
                <h1 style="text-align: center; font-size: 50px">用户信息增加</h1>
            </div>
            <center>
                <div style="height: 315px;font-size: 10px">
                    <div style="width: 100px;height: 100px;background-size: 100%;background-repeat: no-repeat;background-image: url('${basePath}/drawable/RacoonLogo.png')"></div>
                    <s:form action="AddAccountAction" method="POST">
                        <table style="border-collapse: separate; border-spacing: 15px;">
                            <tr>
                                <th>用户名</th>
                                <th><input id="input1" type="text" name="username"
                                           value="" style="width: 150px; height: 30px; border-radius: 5px"></th>
                            </tr>
                            <tr>
                                <th>密码</th>
                                <th><input id="input2" type="password"
                                           name="password" value=""
                                           style="width: 150px; height: 30px; border-radius: 5px"></th>
                            </tr>
                        </table>
                        <s:submit value="增加" cssStyle="height: 30px; width: 70px;  border-radius: 5px"></s:submit>
                    </s:form>
                    <s:form action="Page2Action" method="POST">
                        <s:hidden name="toURL" value="login"></s:hidden>
                        <s:submit value="返回" cssStyle="height: 30px; width: 70px;  border-radius: 5px"></s:submit>
                    </s:form>
                </div>
                <br />
            </center>
        </div>
        <div style="display: inline-block; margin: 0 auto; width: 350px; height: 550px; border: solid black; border-radius: 20px;background-color: rgba(255,255,255,0.3)">
            <div style="height: 130px">
                <h1 style="text-align: center; font-size: 50px">用户信息删除</h1>
            </div>
            <center>
                <div style="height: 315px;font-size: 10px">
                    <div style="width: 100px;height: 100px;background-size: 100%;background-repeat: no-repeat;background-image: url('${basePath}/drawable/RacoonLogo.png')"></div>
                    <s:form action="DelAccountAction" method="POST">
                        <table style="border-collapse: separate; border-spacing: 15px;">
                            <tr>
                                <th>用户名</th>
                                <th><input id="input3" type="text" name="username"
                                           value="" style="width: 150px; height: 30px; border-radius: 5px"></th>
                            </tr>
                            <tr>
                                <th>密码</th>
                                <th><input id="input4" type="password"
                                           name="password" value=""
                                           style="width: 150px; height: 30px; border-radius: 5px"></th>
                            </tr>
                        </table>
                        <s:submit value="删除" cssStyle="height: 30px; width: 70px;  border-radius: 5px"></s:submit>
                    </s:form>
                    <s:form action="Page2Action" method="POST">
                        <s:hidden name="toURL" value="login"></s:hidden>
                        <s:submit value="返回" cssStyle="height: 30px; width: 70px;  border-radius: 5px"></s:submit>
                    </s:form>
                </div>
                <br />
            </center>
        </div>
    </center>
</div>

</body>
</html>
