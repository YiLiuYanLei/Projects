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
                用户名：<s:property value="#session.Userbean.username"></s:property>
            </div>
            <div class="btn" style="overflow: hidden; width:11%;">
                <s:form action="Page2Action" method="POST" cssClass="but">
                    <s:hidden name="toURL" value="mainBlog"></s:hidden>
                    <s:submit value="博客空间" cssClass="but"></s:submit>
                </s:form>
            </div>
            <div class="btn" style="overflow: hidden; width:10.3%;">
                <s:form action="Page2Action" method="POST" cssClass="but">
                    <s:hidden name="toURL" value="editor"></s:hidden>
                    <s:submit value="写博客" cssClass="but"></s:submit>
                </s:form>
            </div>
        </div>
        <span>
            <table>
                <tr>
                    <th>Writter</th>
                    <th>BlogID</th>
                    <th>Enter</th>
                    <th>WrittenTime</th>
                    <th>Last Modified Time</th>

                </tr>
                <s:iterator value="#session.Blogbeans" var="list" status="st">
                  <tr>
                      <td><s:property value="#list.Writter" /></td>
                      <td><s:property value="#list.blogID" /></td>
                      <td>
                        <s:form action="Page2Action" method="POST">
                            <s:hidden name="toURL" value="blogPage"></s:hidden>
                            <s:hidden name="blogID" value="%{#list.blogID}"></s:hidden>
                            <s:submit value="Enter"></s:submit>
                        </s:form>
                      </td>
                      <td><s:property value="#list.writtenTime" /></td>
                      <td><s:property value="#list.lastTime" /></td>
                  </tr>
                </s:iterator>
              </table>
        </span>
    </div>
</div>

</body>

</html>