<%@ page import="modelos.Libro" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Libros obtenidos</title>
    <link rel="stylesheet" href="libros.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
</head>
<body>
<h1>Tenemos estos libros</h1>

<table class="styled-table">
    <thead>
    <tr>
        <th>ISBN</th>
        <th>TITULO</th>
        <th>AÑO</th>
        <th>EJEMPLARES</th>
        <th>ALTA</th>
        <th>ACCIONES</th>
    </tr>
    </thead>

    <tbody>
    <%
        List<Libro> libros = (List) request.getSession().getAttribute("lstLibros");

        for (Libro libro : libros)
        {
            if (!libro.getAlta())
                continue;
    %>
    <tr>
        <td><%= libro.getISBN() %></td>
        <td><%= libro.getTitulo() %></td>
        <td><%= libro.getAnio() %></td>
        <td><%= libro.getEjemplares() %></td>
        <%-- Borrar, este solo se usaba para "<eliminar" el libro. No hace falta mostrarlo --%>
        <td><%= libro.getAlta() %></td>

        <%-- Boton para eliminar libro con icono --%>
        <td>
            <form action="SvLibros" method="POST">
                <input type="hidden" name="accion" value="eliminar">
                <input type="hidden" name="libroID" value="<%= libro.getId() %>">
                <button type="submit" class="delete-button"><i class="fas fa-trash-alt"></i></button>
            </form>

            <%-- Actualizar --%>
            <form action="SvLibros" method="GET">
                <input type="hidden" name="accion" value="actualizar">
                <input type="hidden" name="libroID" value="<%= libro.getId() %>">
                <button type="submit" class="action-button update-button"><i class="fas fa-edit"></i></button>
            </form>
        </td>
    </tr>
    <%
        }
    %>
    </tbody>
</table>

</body>
</html>