package servlets;

import modelos.Libro;
import servicios.LibrosSvc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;


public class SvLibros extends HttpServlet {

    private LibrosSvc librosSvc = new LibrosSvc();
    private final String VISTA_ACTUALIZAR = "actualizar.jsp";
    private final String VISTA_LIBROS = "libros.jsp";
    private final String VISTA_PRINCIPAL = "index.jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String accion = req.getParameter("accion");

        if ("actualizar".equalsIgnoreCase(accion)) {
            String libroID = req.getParameter("libroID");

            try {
                // Agregamos un attr. a la session para poder usarlo en la nueva vista
                req.getSession().setAttribute("libroEditar", librosSvc.buscarLibro(libroID));
                resp.sendRedirect(VISTA_ACTUALIZAR);
            } catch (ParseException e) {
                resp.sendRedirect(VISTA_LIBROS);
            }
        }
        else {
            // Agregamos un attr. a la session para poder usarlo en la nueva vista
            HttpSession session = req.getSession();
            session.setAttribute("lstLibros", librosSvc.traerLibros());

            // Lo mandamos a la nueva vista
            resp.sendRedirect(VISTA_LIBROS);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String accion = req.getParameter("accion");

        if ("eliminar".equalsIgnoreCase(accion)) {
            String libroID = req.getParameter("libroID");

            try {
                librosSvc.eliminarLibro(libroID);
            } catch (ParseException e) {
                // No hacemos nada ya lo mandamos a la vista de los libros
            }

            resp.sendRedirect(VISTA_LIBROS);
        }
        else if ("actualizar".equalsIgnoreCase(accion)) {
            String id = req.getParameter("id");
            String isbn =  req.getParameter("isbn");
            String titulo = req.getParameter("titulo");
            String anio = req.getParameter("anio");
            String ejemplares = req.getParameter("ejemplares");

            librosSvc.actualizarLibro(id, isbn, titulo, anio, ejemplares);

            resp.sendRedirect(VISTA_LIBROS);
        }
        else {
            String isbn =  req.getParameter("isbn");
            String titulo = req.getParameter("titulo");
            String anio = req.getParameter("anio");
            String ejemplares = req.getParameter("ejemplares");
            String alta = req.getParameter("alta");

            librosSvc.guardarLibro(isbn, titulo, anio, ejemplares, alta);

            resp.sendRedirect(VISTA_PRINCIPAL);
        }
    }

}
