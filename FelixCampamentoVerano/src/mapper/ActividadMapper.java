package mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.Entity.Actividad;

public class ActividadMapper implements Mapper<ResultSet, Actividad> {

    @Override
    public Actividad map(ResultSet rs) {
        try {
            Actividad actividad = new Actividad();
            actividad.setCodigoActividad(rs.getString("codigo_actividad"));
            actividad.setNombreActividad(rs.getString("nombre_actividad"));
            actividad.setDescripcion(rs.getString("descripcion"));
            return actividad;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Object[] toInsertParams(Actividad actividad) {
        return new Object[] {
            actividad.getCodigoActividad(),
            actividad.getNombreActividad(),
            actividad.getDescripcion()
        };
    }
}