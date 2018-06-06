<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@ taglib prefix="s" uri="/struts-tags" %><!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>cacheStatisticsList</title>
    <link href="${pageContext.request.contextPath}/content/css/bootstrap.min.css" rel="stylesheet" media="screen">
    <link href="${pageContext.request.contextPath}/content/css/bootstrap-theme.min.css" rel="stylesheet" media="screen">
    <link href="${pageContext.request.contextPath}/content/js/font-awesome/css/font-awesome.min.css" rel="stylesheet"
          media="screen">
    <link href="${pageContext.request.contextPath}/content/css/jquery-ui-1.10.3.custom.min.css" rel="stylesheet"
          media="screen">


    <script type="text/javascript" src="${pageContext.request.contextPath}/content/js/jquery/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/content/js/bootstrap/bootstrap.min.js"></script>
</head>
<body>

<s:iterator value="mapCache" status="stat">
    <s:iterator>
        <div>
            <div style="width:400px;float:left"> <s:property value="key"/></div>
            <div style="float:left">      <s:property value="value"/></div>
            <div style="clear:both"></div>
        </div>
    </s:iterator>
</s:iterator>





</body>
</html>