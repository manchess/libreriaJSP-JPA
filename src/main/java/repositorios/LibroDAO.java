package repositorios;

import com.sun.istack.NotNull;
import connections.Conexion;
import modelos.Libro;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class LibroDAO {

    EntityManager em = Conexion.getEntityManager();

    public LibroDAO() {
    }

    public void guardar(Libro libro) {
        em.getTransaction().begin();
        em.persist(libro);
        em.getTransaction().commit();
        System.out.println("Libro guardado");
    }

    public Libro buscar(@NotNull Integer id) {
        return em.find(Libro.class, id);
    }

    public List<Libro> consultar() {
        String jpql = "SELECT l FROM Libro l";

        Query consulta = em.createQuery(jpql);

        return consulta.getResultList();
    }

    public void eliminar(Libro libro) {
        // "Eliminamos" cambiando el atributo alta -> false
        libro.setAlta(false);

        em.getTransaction().begin();
        em.merge(libro);
        em.getTransaction().commit();

        System.out.println("Libro eliminado");
    }

    public void actualizar(Libro libro) {
        em.getTransaction().begin();
        em.merge(libro);
        em.getTransaction().commit();
        System.out.println("Libro actualizado");
    }

    public void cerrarConexion() {
        Conexion.closeEntityManagerFactory();
    }


}
