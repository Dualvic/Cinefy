<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Home</title>
    <s:include value="/pages/include/header.jsp"/>

</head>

<script>

    $(document).ready(function () {

        $("#title-home").on("click", function () {
            window.location = "${pageContext.request.contextPath}/pages/home.jsp"
        })

    });

    function validate() {

        let pw = document.getElementById("pw");
        let rePw = document.getElementById("rePw");

        if (pw.value !== "") {
            if (pw.value === rePw.value) {
                return true;
            }
        } else {
            return false;
        }

    }

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

    <div id="popcorn-home">
        <img src="${pageContext.request.contextPath}/content/img/popcorn.png" alt="popcorn">
    </div>

    <form id="createU" action="createUser" method="post">
        <div class="form-group">
            <input type="text" class="form-control" id="user" name="usuario" placeholder="Nombre de usuario">
        </div>
        <div class="form-group">
            <input type="password" class="form-control" id="pw" name="password" placeholder="Contraseña">
        </div>
        <div class="form-group">
            <input type="password" class="form-control" id="repw" name="newPwConfirm"
                   placeholder="Repita su contraseña">
        </div>
        <button type="submit" class="btn btn-warning" id="pw-new-user" onclick="validate()">Aceptar</button>
    </form>>

</div>
</body>
</html>
