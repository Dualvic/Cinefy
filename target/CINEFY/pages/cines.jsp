<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<body>
LISTADO DE CINES

<table border="1">
<thead>
    <th>ID</th>
    <th>Nombre</th>
    <th>Direccion</th>
</thead>
<tbody>
<s:iterator value="lista" status="listaStatus" var="cine">
  <tr>
      <td>
        <s:url var="url_cine" action="cine">
          <s:param name="cineID"><s:property value="#cine.id"/></s:param>
        </s:url>
        <a href="${url_cine}"><s:property value="#cine.id"/></a>
      </td>
      <td><s:property value="#cine.nombre"/></td>
      <td><s:property value="#cine.direccion"/></td>
  </tr>
</s:iterator>
</tbody>
</table>

</body>
</html>