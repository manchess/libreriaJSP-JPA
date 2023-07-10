package servicios;

import modelos.Libro;
import repositorios.LibroDAO;

import java.text.ParseException;
import java.util.List;
import java.util.NoSuchElementException;

public class LibrosSvc {

    private LibroDAO libroDAO;

    public LibrosSvc() {
        libroDAO = new LibroDAO();
        System.out.println("Se creo libroDAO");
    }

    public void guardarLibro(String isbn, String titulo, String anio, String ejemplares, String alta) {
        Long isbn2 = Long.parseLong(isbn);
        Integer anio2 = Integer.parseInt(anio);
        Integer  ejemplares2 = Integer.parseInt(ejemplares);
        Boolean alta2 = "on".equalsIgnoreCase(alta);

        Libro libro = new Libro(isbn2, titulo, anio2, ejemplares2, alta2);
        libroDAO.guardar(libro);
    }

    public List<Libro> traerLibros() {
        return libroDAO.consultar();
    }

    public void eliminarLibro(String libroID) throws ParseException {
        Libro libro = buscar(libroID);

        libroDAO.eliminar(libro);
    }

    private Libro buscar(String libroID) throws ParseException {
        if (!esNumerico(libroID)) {
            throw new ParseException("No se paso un ID numerico", 0);
        }

        Integer id = Integer.valueOf(libroID);

        Libro libro = libroDAO.buscar(id);

        if (libro == null) {
            throw new NoSuchElementException("No se encontro un libro con id: " + libroID);
        }

        return libro;
    }

    private Boolean esNumerico(String str) {
        try {
            Integer.valueOf(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public Libro buscarLibro(String libroID) throws ParseException {
        return buscar(libroID);
    }

    public void actualizarLibro(String id, String isbn, String titulo, String anio, String ejemplares) {
        Integer id2 = Integer.valueOf(id);
        Long isbn2 = Long.parseLong(isbn);
        Integer anio2 = Integer.parseInt(anio);
        Integer  ejemplares2 = Integer.parseInt(ejemplares);

        Libro libro = libroDAO.buscar(id2);
        libro.setISBN(isbn2);
        libro.setTitulo(titulo);
        libro.setAnio(anio2);
        libro.setEjemplares(ejemplares2);

        libroDAO.actualizar(libro);
    }
}
