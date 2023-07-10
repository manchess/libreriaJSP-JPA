package root;

import modelos.Libro;
import repositorios.LibroDAO;

public class Main {

    public static void main(String[] args) {
        LibroDAO libroDAO = new LibroDAO();

        Libro libro = libroDAO.buscar(2);

        System.out.println("Libro null?");
        System.out.println(libro==null);

    }
}
