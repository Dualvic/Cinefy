<%--
  Created by IntelliJ IDEA.
  User: viC
  Date: 29/04/2018
  Time: 21:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Cinefy</title>
    <s:include value="/pages/include/header.jsp"/>

</head>
<body style="background-color: indianred">
<div class="row">
<div class="header" id="header">
        <nav class=" navbar-fixed-top">
            <div class="container-fluid">
                <div class="navbar-header" id="header-pop">
                    <img src="${pageContext.request.contextPath}/content/img/popcorn.png" alt="popcorn">
                </div>
                <div></div>
            </div>
        </nav>
</div>
    <div id="films">

    </div>

    <div id="cines">

    </div>
</div>
</body>
</html>
