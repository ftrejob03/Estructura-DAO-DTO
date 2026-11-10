package services;

import java.util.Optional;

import modelo.AbstractDAO.DaoFactory;
import modelo.AbstractDAO.MonitorDAO;
import modelo.Entity.Monitor;

public class MonitorService {
	private final MonitorDAO monitorDAO ;

	public MonitorService() {
		super();
		this.monitorDAO = DaoFactory.getFactory().getMonitorDAO();
		
	}

	public MonitorDAO getMonitorDAO() {
		return monitorDAO;
	}
	
	public Optional<Monitor> getMonitorById(String dni){
		return this.monitorDAO.findById(dni);
	}
}
