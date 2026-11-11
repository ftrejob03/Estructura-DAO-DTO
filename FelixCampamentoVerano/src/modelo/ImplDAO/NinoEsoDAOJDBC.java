package modelo.ImplDAO;

import java.util.Collection;
import java.util.Optional;

import handler.CollectionHandler;
import handler.OptionalHandler;
import mapper.NinoEsoMapper;
import modelo.AbstractDAO.NinoEsoDAO;
import modelo.Entity.NinoEso;
import modelo.acceso.AccessJdbc;

public class NinoEsoDAOJDBC implements NinoEsoDAO {
	private final AccessJdbc accessJDBC;
	private final NinoEsoMapper mapper = new NinoEsoMapper();
	
	public NinoEsoDAOJDBC(AccessJdbc accessJDBC) {
		this.accessJDBC = accessJDBC;
	}

	@Override
	public boolean create(NinoEso entidad) {
		if (entidad == null) return false;
		
		String sqlPadre = String.format("INSERT INTO nino (numero_nino, nombre, apellidos, fecha_nacimiento, numero_grupo) VALUES "
				+ "(%d, '%s', '%s', '%s', %d)", 
				entidad.getNumeroNino(),
				entidad.getNombre(),
				entidad.getApellidos(),
				entidad.getFechaNacimiento(),
				entidad.getGrupo().getNumeroGrupo()
		);
		
		String sqlHijo = String.format("INSERT INTO nino_eso (numero_nino, numero_tienda) VALUES (%d, %d)",
				entidad.getNumeroNino(),
				entidad.getTienda().getNumeroTienda()
		);
		int filasPadre = accessJDBC.executeUpdate(sqlPadre);
		if (filasPadre > 0) {
			int filasHijo = accessJDBC.executeUpdate(sqlHijo);
			return filasHijo > 0;
		}
		return false;
	}

	@Override
	public Collection<NinoEso> findAll() {
		String sql = "SELECT n.numero_nino, n.nombre, n.apellidos, n.fecha_nacimiento, n.numero_grupo, ne.numero_tienda "
				+ "FROM nino n INNER JOIN nino_eso ne ON n.numero_nino = ne.numero_nino";
		return accessJDBC.executeQuery(sql, new CollectionHandler<>(mapper));
	}

	@Override
	public Optional<NinoEso> findById(Integer id) {
		String sql = "SELECT n.numero_nino, n.nombre, n.apellidos, n.fecha_nacimiento, n.numero_grupo, ne.numero_tienda "
				+ "FROM nino n INNER JOIN nino_eso ne ON n.numero_nino = ne.numero_nino WHERE n.numero_nino = "+id;
		return accessJDBC.executeQuery(sql, new OptionalHandler<>(mapper), id);
	}
	
	@Override
	public Optional<NinoEso> deleteById(Integer id) {
		Optional<NinoEso> ninoExistente = findById(id);
		if (ninoExistente.isPresent()) {
			String sqlHijo = "DELETE FROM nino_eso WHERE numero_nino = "+id;
			String sqlPadre = "DELETE FROM nino WHERE numero_nino = "+id;
			
			accessJDBC.executeUpdate(sqlHijo);
			accessJDBC.executeUpdate(sqlPadre);
		}
		return ninoExistente;
	}
}