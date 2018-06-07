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

<script>
    $(document).ready(function () {

        $("#logout").on("click", function () {
            window.location = "${pageContext.request.contextPath}/pages/home.jsp"
        });

        $('#myCarousel').carousel({
            pause: 'none',
            interval: 1200
        });
    });

</script>
<body style="background-color: #333333">
<div class="container">
<div class="row">
    <div class="header" id="header">

                <div id="logout">
                    <i class="fas fa-sign-out-alt"></i>
                </div>
                <div id="profileIcon">
                    <i class="fas fa-user-circle"></i>
                </div>
    </div>
</div>
<div class="row" id="pan">

    <div id="background-carousel">
        <div id="myCarousel" class="carousel slide" data-ride="carousel">
            <div class="carousel-inner">
                <div class="item active" style="background-image:url(${pageContext.request.contextPath}/content/img/infinity-war.jpeg)"></div>
                <div class="item" style="background-image:url(${pageContext.request.contextPath}/content/img/12val.jpg)"></div>
                <div class="item" style="background-image:url(${pageContext.request.contextPath}/content/img/readyone.jpg)"></div>
            </div>
        </div>
    </div>

</div>
    <div class="row">
        <div id="films">
            <img src="${pageContext.request.contextPath}/content/img/verPeliculas.png" alt="films">
        </div>

        <div id="salas">
            <img src="${pageContext.request.contextPath}/content/img/verSalas.png" alt="salas">
        </div>




    </div>
    <%--<form action = "cines">--%>
        <%--<input class="btn btn-success" type="submit" value="Cines" />--%>
    <%--</form>--%>
    <%--<form cl action = "peliculas">--%>
        <%--<input class="btn btn-success" type="submit" value="Peliculas" />--%>
    <%--</form>--%>
    <%--<form action = "perfil">--%>
        <%--<input class="btn btn-success" type="submit" value="Perfil" />--%>
    <%--</form>--%>
</div>

</body>
</html>
