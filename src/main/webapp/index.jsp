<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Practicando JPA - JSP</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <h1>CRUD LIBROS</h1>

    <h2>Crear Libros</h2>
    <form action="SvLibros" method="POST">
        <div class="form-group">
            <label for="isbn">ISBN:</label>
            <input type="text" name="isbn" id="isbn">
        </div>
        <div class="form-group">
            <label for="titulo">TITULO:</label>
            <input type="text" name="titulo" id="titulo">
        </div>
        <div class="form-group">
            <label for="anio">ANIO:</label>
            <input type="text" name="anio" id="anio">
        </div>
        <div class="form-group">
            <label for="ejemplares">EJEMPLARES:</label>
            <input type="text" name="ejemplares" id="ejemplares">
        </div>
        <div class="form-group">
            <label for="alta">ALTA:</label>
            <input type="checkbox" name="alta" id="alta">
        </div>
        <button type="submit">Guardar</button>
    </form>

    <h2>
        <form action="SvLibros" method="GET">
            <button type="submit">Consultar libros</button>
        </form>
    </h2>
</body>
</html>