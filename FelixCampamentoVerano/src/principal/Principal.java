package principal;

import java.sql.SQLException;

import modelo.ImplDAO.DAOFactoryJDBC;
import modelo.ImplDAO.MonitorService;

public class Principal {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		MonitorService monitorService=new MonitorService(new DAOFactoryJDBC().getMonitorDAO());
	}

}
