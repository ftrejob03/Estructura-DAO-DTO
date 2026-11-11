package mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.Entity.Grupo;
import modelo.Entity.NinoEso;
import modelo.Entity.Tienda;

public class NinoEsoMapper implements Mapper<ResultSet, NinoEso> {

	@Override
	public NinoEso map(ResultSet rs) {
		try {
			NinoEso ninoESO = new NinoEso();
			ninoESO.setNumeroNino(rs.getInt("numero_nino"));
			ninoESO.setNombre(rs.getString("nombre"));
			ninoESO.setApellidos(rs.getString("apellidos"));
			
			java.sql.Date fechaSQL = rs.getDate("fecha_nacimiento");
			if (fechaSQL != null) {
				ninoESO.setFechaNacimiento(fechaSQL.toLocalDate());
			}
			Grupo grupo = new Grupo();
			grupo.setNumeroGrupo(rs.getInt("numero_grupo"));
			ninoESO.setGrupo(grupo);
			
			Tienda tienda = new Tienda();
			tienda.setNumeroTienda(rs.getInt("numero_tienda"));
			ninoESO.setTienda(tienda);
			
			return ninoESO;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Object[] toInsertParams(NinoEso ninoEso) {
		return new Object[] {
				ninoEso.getNumeroNino(),
				ninoEso.getNombre(),
				ninoEso.getApellidos(),
				ninoEso.getFechaNacimiento(),
				ninoEso.getGrupo().getNumeroGrupo(),
				ninoEso.getTienda().getNumeroTienda()
		};
	}
}
