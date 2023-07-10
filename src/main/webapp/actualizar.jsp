<%@ page import="modelos.Libro" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Libros obtenidos</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>

    <%
        Libro libro = (Libro) request.getSession().getAttribute("libroEditar");
    %>
    <form action="SvLibros" method="POST">
        <input type="hidden" name="accion" value="actualizar">
        <%-- El id para poder buscar el libro --%>
        <input type="hidden" name="id" value="<%= libro.getId() %>">

        <div class="form-group">
            <label for="isbn">ISBN:</label>
            <input type="text" name="isbn" id="isbn" value="<%= libro.getISBN() %>">
        </div>
        <div class="form-group">
            <label for="titulo">TITULO:</label>
            <input type="text" name="titulo" id="titulo" value="<%= libro.getTitulo() %>">
        </div>
        <div class="form-group">
            <label for="anio">ANIO:</label>
            <input type="text" name="anio" id="anio" value="<%= libro.getAnio() %>">
        </div>
        <div class="form-group">
            <label for="ejemplares">EJEMPLARES:</label>
            <input type="text" name="ejemplares" id="ejemplares" value="<%= libro.getEjemplares() %>">
        </div>
        <button type="submit">Actualizar</button>
    </form>
</table>

</body>
</html>