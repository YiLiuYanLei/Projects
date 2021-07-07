<%@ page import="com.opensymphony.xwork2.ActionContext" %>
<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: 25238
  Date: 6/14/2021
  Time: 4:44 PM
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
    <title>RacoonBlog</title>
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

<div class="panel-body" style="height: 100%; overflow-y:scroll;">
    <div style="border: 1px solid #000000; width: 90%; margin: 0 auto; background-color: rgba(255,255,255,0.5)">
        <div style="border:1px solid #900;width:100%;height:60px; font-size: 0px;">
            <div class="btn" style="overflow: hidden; width:11%;">
                <s:form action="Page2Action" method="POST" cssClass="but">
                    <s:hidden name="toURL" value="index"></s:hidden>
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
            <div class="btn" style="overflow: hidden; width:11.5%; font-size: 15px">
                账号信息:
            </div>
            <div class="btn" style="overflow: hidden; width:11%;">
                <s:form action="Page2Action" method="POST" cssClass="but">
                    <s:hidden name="toURL" value="mainBlog"></s:hidden>
                    <s:submit value="博客空间" cssClass="but"></s:submit>
                </s:form>
            </div>
            <div class="btn" style="overflow: hidden; width:10.3%;">
                <s:form action="Page2Action" method="POST" cssClass="but">
                    <s:hidden name="toURL" value="admin"></s:hidden>
                    <s:submit value="账号管理" cssClass="but"></s:submit>
                </s:form>
            </div>
        </div>
        <span>
      <s:form id="form1" action="EditorAction" method="post">
          <s:textarea name="contents" cols="40" rows="10" placeholder="请输入文本........." cssStyle="font-size: 20px; outline: none; width: 295%"/>
          <table style="border-collapse: separate; border-spacing: 15px; font-size: 20px">
            <tr>
                <th>
                    <s:textfield label="是否为私密博客" name="isPrivate" placeholder="请输入true/false" cssStyle="font-size: 20px; border-radius: 5px; outline: none; width: 175px;"></s:textfield>
                </th>
            </tr>
        </table>
          <s:submit value="上传" cssStyle="height: 30px; width: 70px;  border-radius: 5px"></s:submit>
      </s:form>
    </span>
    </div>
</div>

</body>

</html>
