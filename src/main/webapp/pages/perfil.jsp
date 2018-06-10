<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Home</title>
    <s:include value="/pages/include/header.jsp"/>

</head>

<script>

    $(document).ready(function () {

        $("#userPwDrop").click(function(){
            $("#changePw").slideToggle();
        });

        // Redirecciones
        $("#logout").on("click", function () {
            window.location = "${pageContext.request.contextPath}/pages/home.jsp"
        });

        $("#profileIcon").on("click", function () {
            window.location = "${pageContext.request.contextPath}/pages/profile.jsp"
        });

        $("#title-cines").on("click", function () {
            window.location.replace("${pageContext.request.contextPath}/pages/menu.jsp");
        });

    });

    function validate() {

        let olderPass = document.getElementById("olderPw");
        let newPw = document.getElementById("newPw");
        let newPwConfirm = document.getElementById("newPwConfirm");

        if (olderPass.value !== "") {
            if (newPw.value === newPwConfirm.value) {
                return true;
            }
        } else {
            return false;
        }
    }

</script>
<body id="profile">
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
    <div id="profileTitlePases"><p>Pases</p></div>
    <div id="profileAvatarPases"><img src="${pageContext.request.contextPath}/content/img/popcorn.png"></div>
    <div id="pases">
        <s:iterator value="usuario.pases" status="pasesStatus" var="pase">
            <div class="pases-pase">
                Horario: <s:property value="#pase.horario"/>
                <br>
                Cine: <s:property value="#pase.cine.nombre"/>
                <br>
                Pelicula: <s:property value="#pase.pelicula.titulo"/>
                <br>
            </div>
            <br>
        </s:iterator>
    </div>

</div>

</body>
</html>
