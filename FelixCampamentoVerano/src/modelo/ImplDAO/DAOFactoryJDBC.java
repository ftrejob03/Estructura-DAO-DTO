package modelo.ImplDAO;

import java.sql.SQLException;

import modelo.AbstractDAO.ActividadDAO;
import modelo.AbstractDAO.DaoFactory;
import modelo.AbstractDAO.GrupoActividadMonitorDAO;
import modelo.AbstractDAO.GrupoDAO;
import modelo.AbstractDAO.MonitorDAO;
import modelo.acceso.AccessJdbc;

public class DAOFactoryJDBC extends DaoFactory {
	private AccessJdbc accessJdbc;
	private final MonitorDAO monitorDAO;
	private final GrupoDAO grupoDAO;
	private final ActividadDAO actividadDAO;
	private final GrupoActividadMonitorDAO grupoActividadMonitorDAO;
	
	public DAOFactoryJDBC() throws ClassNotFoundException, SQLException {
		super();
		// EStos parametros pueden ser pasado por parametros o configurados en otro
		// sitio
		accessJdbc = new AccessJdbc("campamento_verano_27", "harnina", "zzzz");
		this.monitorDAO = new MonitorDAOJDBC(accessJdbc);
		this.grupoDAO=new GrupoDAOJDBC(accessJdbc);
		this.actividadDAO=new ActividadDAOJDBC(accessJdbc);
		this.grupoActividadMonitorDAO=new GrupoActividadMonitorDAOJDBC(accessJdbc);
	}

	//Los singleton son los daos
	@Override
	public MonitorDAO getMonitorDAO() {
		return this.monitorDAO;
	}

	@Override
	public GrupoDAO getGrupoDAO() {
		return this.grupoDAO;
	}

	@Override
	public ActividadDAO getActividadDAO() {
		return this.actividadDAO;
	}

	@Override
	public GrupoActividadMonitorDAO getGrupoActividadMonitorDAO() {
		return this.grupoActividadMonitorDAO;
	}
	
	
	
	

}
