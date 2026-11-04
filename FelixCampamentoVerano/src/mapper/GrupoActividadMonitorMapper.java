package mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.Entity.Actividad;
import modelo.Entity.Grupo;
import modelo.Entity.GrupoActividadMonitor;
import modelo.Entity.Monitor;

public class GrupoActividadMonitorMapper implements Mapper<ResultSet, GrupoActividadMonitor> {

	@Override
	public GrupoActividadMonitor map(ResultSet s) {
		try {
            Grupo grupo = new Grupo();
            grupo.setNumeroGrupo(s.getInt("numero_grupo"));

            Actividad actividad = new Actividad();
            actividad.setCodigoActividad(s.getString("codigo_actividad"));

            Monitor monitor = new Monitor();
            monitor.setDni(s.getString("dni_monitor"));

            return new GrupoActividadMonitor(grupo, actividad, monitor);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
	}

	@Override
	public Object[] toInsertParams(GrupoActividadMonitor t) {
		 return new Object[] {
		            t.getGrupo().getNumeroGrupo(),
		            t.getActividad().getCodigoActividad(),
		            t.getMonitor().getDni()
		        };
	}

}
