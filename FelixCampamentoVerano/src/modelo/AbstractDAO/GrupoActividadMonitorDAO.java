package modelo.AbstractDAO;

import java.util.Collection;

import modelo.Entity.GrupoActividadMonitor;

public interface GrupoActividadMonitorDAO extends BaseDAO<GrupoActividadMonitor> {
    public boolean deleteByKeys(Integer numeroGrupo, String codigoActividad, String dniMonitor);
    public Collection<GrupoActividadMonitor> findByMonitor(String dni);
}
