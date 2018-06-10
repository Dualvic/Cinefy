<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>


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


        // Redirecciones
        $("#logout").on("click", function () {
            window.location = "${pageContext.request.contextPath}/pages/home.jsp"
        });

        $("#profileIcon").on("click", function () {
            window.location = "${pageContext.request.contextPath}/pages/profile.jsp"
        });

        $("#salas").on("click", function () {
            $.ajax({
                url: "${pageContext.request.contextPath}/pages/cines",
                type: "POST"
            });
        });

        $("#films").on("click", function () {
            window.location = "${pageContext.request.contextPath}/pages/peliculas.jsp"
        });

        $("#back-compra-entradas").on("click", function () {
            window.location = "${pageContext.request.contextPath}/pages/menu.jsp"
        });
    });
</script>
<body style="background-color: #333333">
<div class="container">
  <div class="row header" id="header">
    <div id="profileIcon" class="col">
      <i class="fas fa-user-circle"></i>
    </div>
    <div id="title-cines" class="col">
      <h1>Cinefy</h1>
    </div>
    <div id="logout" class="col">
      <i class="fas fa-sign-out-alt"></i>
    </div>
  </div>
  <div class="row" id="pan">

  </div>

  <div id="confir-bub">
    <img src="${pageContext.request.contextPath}/content/img/bocadillo.png">
  </div>
  <div id="pop-confir">
    <img src="${pageContext.request.contextPath}/content/img/popcorn3D.png">
  </div>
  <div id="info-compra">
    <s:iterator value="pasesComprados" status="pasesCompradosStatus" var="pases">

          <ul>
            <li>
            <s:property value="#pases.horario"/>
            </li>
            <li>
            <s:property value="#pases.cine.nombre"/>
            </li>
            <li>
            <s:property value="#pases.pelicula.titulo"/>
            </li>
            <li>
            <s:property value="#pases.usuario.usuario"/>
          </ul>

    </s:iterator>

  </div>

  <div id="back-compra-entradas" class="circleBase type1">
    <i class="fas fa-home"></i>
  </div>
</div>

</body>
</html>