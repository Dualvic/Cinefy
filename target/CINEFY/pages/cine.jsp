<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
<body>
    <h3>
    DETALLES DEL CINE:
    </h3>

    <div>
        <s:property value="cine.nombre"/>
    </div>


    <h4>
    PELICULAS QUE OFRECE ESTE CINE:
    </h4>
    <ul>
        <s:iterator value="cine.peliculas" status="peliculasStatus" var="pelicula">
            <s:url var="url_entradas" action="venta_entradas">
                <s:param name="cineID"><s:property value="cine.id"/></s:param>
                <s:param name="peliculaID"><s:property value="#pelicula.id"/></s:param>
            </s:url>
            <li>
                ID: <s:property value="#pelicula.id"/>
                <br>
                Titulo: <s:property value="#pelicula.titulo"/>
                <br>
                Sinopsis: <s:property value="#pelicula.sinopsis"/>
                <br>
            </li>
            <br>
            <ul>
                <s:iterator value="#pelicula.valoraciones" status="peliculaValoracionesStatus" var="valoracion">
                    <li>
                        Rating: <s:property value="#valoracion.rating" />
                    </li>
                </s:iterator>
            </ul>
            <br>
            <a href="${url_entradas}">Comprar Entradas</a>
            <br>
            <br>
        </s:iterator>
    </ul>
</body>
</html>