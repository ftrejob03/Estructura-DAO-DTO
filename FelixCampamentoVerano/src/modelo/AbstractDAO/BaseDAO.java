package modelo.AbstractDAO;

import java.util.Collection;

public interface BaseDAO<T> {
    boolean create(T entidad);
    Collection<T> findAll();
}
