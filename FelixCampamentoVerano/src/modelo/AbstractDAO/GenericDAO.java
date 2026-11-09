package modelo.AbstractDAO;

import java.util.Optional;

public interface GenericDAO<T,ID> extends BaseDAO<T>{
	public Optional<T> findById(ID id);
	public Optional<T> deleteById(ID id);
}
