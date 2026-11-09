package services;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import modelo.AbstractDAO.ActividadDAO;
import modelo.AbstractDAO.DaoFactory;
import modelo.AbstractDAO.GrupoActividadMonitorDAO;
import modelo.DTO.ActividadesMonitorDTO;
import modelo.Entity.Actividad;
import modelo.Entity.GrupoActividadMonitor;

public class ActividadesServiceImpl implements ActividadesService {
	private final GrupoActividadMonitorDAO grupoActividadMonitorDAO;
	private final ActividadDAO actividadDAO;
	public ActividadesServiceImpl() {
		super();
		grupoActividadMonitorDAO = DaoFactory.getFactory().getGrupoActividadMonitorDAO();
		this.actividadDAO = DaoFactory.getFactory().getActividadDAO();
	}

	@Override
	public ActividadesMonitorDTO getActividadesByMonitor(String dni) {
		Collection<GrupoActividadMonitor> actividades=grupoActividadMonitorDAO.findByMonitor(dni);
		GrupoActividadMonitor grupoActividadMonitor = actividades.stream().collect(Collectors.toList()).get(0);
		Actividad actividad = grupoActividadMonitor.getActividad();
		String descripcion = actividad.getDescripcion();
		//Pero es lazy
		return null;
	}

	

}
