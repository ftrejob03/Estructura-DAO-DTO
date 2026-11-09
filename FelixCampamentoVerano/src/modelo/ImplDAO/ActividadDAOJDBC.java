package modelo.ImplDAO;

import java.util.Collection;
import java.util.Optional;

import handler.CollectionHandler;
import handler.OptionalHandler;
import mapper.ActividadMapper;
import modelo.AbstractDAO.ActividadDAO;
import modelo.Entity.Actividad;
import modelo.acceso.AccessJdbc;

public class ActividadDAOJDBC implements ActividadDAO {
    private final AccessJdbc accessJdbc;
    private final ActividadMapper mapper = new ActividadMapper();

    public ActividadDAOJDBC(AccessJdbc accessJdbc) {
        this.accessJdbc = accessJdbc;
    }

    @Override
    public boolean create(Actividad entidad) {
        String sql = "INSERT INTO actividad (codigo_actividad, nombre_actividad, descripcion) VALUES (?, ?, ?)";
        int filas = accessJdbc.executeUpdate(sql, mapper.toInsertParams(entidad));
        return filas > 0;
    }

    @Override
    public Collection<Actividad> findAll() {
        String sql = "SELECT codigo_actividad, nombre_actividad, descripcion FROM actividad";
        return accessJdbc.executeQuery(sql, new CollectionHandler<>(mapper));
    }

    @Override
    public Optional<Actividad> findById(String id) {
        String sql = "SELECT codigo_actividad, nombre_actividad, descripcion FROM actividad WHERE codigo_actividad = ?";
        return accessJdbc.executeQuery(sql, new OptionalHandler<>(mapper), id);
    }

    @Override
    public Optional<Actividad> deleteById(String id) {
        Optional<Actividad> actividad = findById(id);
        if (actividad.isPresent()) {
            String sql = "DELETE FROM actividad WHERE codigo_actividad = ?";
            accessJdbc.executeUpdate(sql, id);
        }
        return actividad;
    }
}
