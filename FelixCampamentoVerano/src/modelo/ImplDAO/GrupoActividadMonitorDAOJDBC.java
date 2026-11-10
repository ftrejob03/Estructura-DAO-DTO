package modelo.ImplDAO;

import java.util.Collection;

import handler.CollectionHandler;
import mapper.GrupoActividadMonitorMapper;
import modelo.AbstractDAO.GrupoActividadMonitorDAO;
import modelo.Entity.GrupoActividadMonitor;
import modelo.acceso.AccessJdbc;

public class GrupoActividadMonitorDAOJDBC implements GrupoActividadMonitorDAO {
    private final AccessJdbc accessJdbc;
    private final GrupoActividadMonitorMapper mapper = new GrupoActividadMonitorMapper();

    public GrupoActividadMonitorDAOJDBC(AccessJdbc accessJdbc) {
        this.accessJdbc = accessJdbc;
    }

    @Override
    public boolean create(GrupoActividadMonitor entidad) {
        String sql = "INSERT INTO grupo_actividad_monitor (numero_grupo, codigo_actividad, dni_monitor) VALUES (?, ?, ?)";
        int filas = accessJdbc.executeUpdate(sql, mapper.toInsertParams(entidad));
        return filas > 0;
    }

    @Override
    public Collection<GrupoActividadMonitor> findAll() {
        String sql = "SELECT numero_grupo, codigo_actividad, dni_monitor FROM grupo_actividad_monitor";
        return accessJdbc.executeQuery(sql, new CollectionHandler<>(mapper));
    }

    @Override
    public boolean deleteByKeys(Integer numeroGrupo, String codigoActividad, String dniMonitor) {
        String sql = "DELETE FROM grupo_actividad_monitor WHERE numero_grupo = ? AND codigo_actividad = ? AND dni_monitor = ?";
        int filas = accessJdbc.executeUpdate(sql, numeroGrupo, codigoActividad, dniMonitor);
        return filas > 0;
    }

	@Override
	public Collection<GrupoActividadMonitor> findByMonitor(String dni) {
		String sql="Select * from grupo_actividad_monitor  WHERE dni_monitor = ?";
		return accessJdbc.executeQuery(sql, new CollectionHandler<>(mapper),dni);
	}
}
