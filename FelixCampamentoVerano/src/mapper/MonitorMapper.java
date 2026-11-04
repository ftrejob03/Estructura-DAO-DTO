package mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.Entity.Monitor;

public class MonitorMapper implements Mapper<ResultSet, Monitor> {

    @Override
    public Monitor map(ResultSet rs) {
        try {
            Monitor monitor = new Monitor();
            monitor.setDni(rs.getString("dni"));
            monitor.setNombre(rs.getString("nombre"));
            monitor.setApellidos(rs.getString("apellidos"));
            monitor.setTelefono(rs.getString("telefono"));
            return monitor;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    @Override
    public Object[] toInsertParams(Monitor monitor) {
        return new Object[] {
            monitor.getDni(),
            monitor.getNombre(),
            monitor.getApellidos(),
            monitor.getTelefono()
        };
    }
}