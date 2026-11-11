package modelo.AbstractDAO;

import modelo.ImplDAO.DAOFactoryJDBC;

public abstract class DaoFactory {
    
    // Método estático para obtener la factoría concreta deseada
    public static DaoFactory getFactory() {
        try {
            return new DAOFactoryJDBC();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // DAOs del campamento
    public abstract ActividadDAO getActividadDAO();
//    public abstract CabanaDAO getCabanaDAO();
    public abstract GrupoDAO getGrupoDAO();
    public abstract MonitorDAO getMonitorDAO();
//    public abstract TiendaDAO getTiendaDAO();
    public abstract NinoEsoDAO getNinoEsoDAO();
//    public abstract NinoPrimariaDAO getNinoPrimariaDAO();
    public abstract GrupoActividadMonitorDAO getGrupoActividadMonitorDAO();
}
