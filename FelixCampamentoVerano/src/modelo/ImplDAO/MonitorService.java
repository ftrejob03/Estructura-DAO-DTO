package modelo.ImplDAO;

import modelo.AbstractDAO.MonitorDAO;

public class MonitorService {
	private final MonitorDAO monitorDAO ;

	public MonitorService(MonitorDAO monitorDAO) {
		super();
		this.monitorDAO = monitorDAO;
	}

	public MonitorDAO getMonitorDAO() {
		return monitorDAO;
	}
	
	
}
