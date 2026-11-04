package modelo.ImplDAO;

import java.sql.SQLException;

public class Principal {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		MonitorService monitorService=new MonitorService(new DAOFactoryJDBC().getMonitorDAO());
	}

}
