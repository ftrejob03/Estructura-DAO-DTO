package modelo.acceso;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import handler.Handler;

public class AccessJdbc {
    private final String driver = "com.mysql.cj.jdbc.Driver";
    private final String urlBaseDatos;
    private final String user;
    private final String password;

    public AccessJdbc(String bbdd, String user, String password) throws ClassNotFoundException {
        Class.forName(driver);
        this.urlBaseDatos = "jdbc:mysql://localhost:3307/" + bbdd;
        this.user = user;
        this.password = password;
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(urlBaseDatos, user, password);
    }

    // Para SELECTs con o sin parámetros
    public <T> T executeQuery(String sql, Handler<T> handler, Object... params) {
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            setParameters(stmt, params);
            try (ResultSet rs = stmt.executeQuery()) {
                return handler.transform(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Para INSERT, UPDATE, DELETE
    public int executeUpdate(String sql, Object... params) {
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            setParameters(stmt, params);
            return stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    private void setParameters(PreparedStatement stmt, Object... params) throws SQLException {
        for (int i = 0; i < params.length; i++) {
            stmt.setObject(i + 1, params[i]);
        }
    }
}
