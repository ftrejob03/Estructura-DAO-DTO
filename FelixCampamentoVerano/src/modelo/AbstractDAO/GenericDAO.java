package modelo.AbstractDAO;

import java.util.Collection;
import java.util.Optional;

public interface GenericDAO<T,ID> {
	public boolean create(T entidad);
	public Collection<T> findAll();
	public Optional<T> findById(ID id);
	public Optional<T> deleteById(ID id);
}
