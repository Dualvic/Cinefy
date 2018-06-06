<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<body>
LISTADO DE PELICULAS

<table border="1">
<thead>
    <th>ID</th>
    <th>Titulo</th>
    <th>Sinopsis</th>
</thead>
<tbody>
<s:iterator value="lista" status="listaStatus" var="pelicula">
  <tr>
      <td>
          <s:url var="url_pelicula" action="pelicula">
            <s:param name="peliculaID"><s:property value="#pelicula.id"/></s:param>
          </s:url>
          <a href="${url_pelicula}"><s:property value="#pelicula.id"/></a>
      </td>
      <td><s:property value="#pelicula.titulo"/></td>
      <td><s:property value="#pelicula.sinopsis"/></td>
  </tr>
</s:iterator>
</tbody>
</table>

</body>
</html>