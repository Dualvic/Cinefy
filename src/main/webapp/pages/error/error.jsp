<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Home</title>
    <s:include value="/pages/include/header.jsp"/>

</head>

<script>

    $(document).ready(function () {
        $("#back-compra-entradas").on("click", function () {
            window.location = "${pageContext.request.contextPath}/pages/home.jsp"
        });
    })

</script>
<body id="home">

<video autoplay muted loop id="home-video">
    <source src="${pageContext.request.contextPath}/content/media/avengers.mp4" type="video/mp4">
    Your browser does not support HTML5 video.
</video>

<div id="login-home">

    <div id="title-home">
        <h1>Cinefy</h1>
        <br>
        <label id="slogan">Tu taquilla online</label>
    </div>

    <div id="popcorn-error">
        <img src="${pageContext.request.contextPath}/content/img/popcornSad.png" alt="popcornSad">
    </div>

    <div id="error-msg"><p>Parece que hemos tenido un problema</p></div>


    <div id="back-compra-entradas" class="circleBase type1" style="left: 35%;">
        <i class="fas fa-home"></i>
    </div>
</div>
</body>
</html>
