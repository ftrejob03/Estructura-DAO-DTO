package mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.Entity.Grupo;

public class GrupoMapper implements Mapper<ResultSet, Grupo> {

    @Override
    public Grupo map(ResultSet rs) {
        try {
            Grupo grupo = new Grupo();
            grupo.setNumeroGrupo(rs.getInt("numero_grupo"));
            grupo.setInformaciones(rs.getString("informaciones"));
            return grupo;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Object[] toInsertParams(Grupo grupo) {
        return new Object[] {
            grupo.getNumeroGrupo(),
            grupo.getInformaciones()
        };
    }
}