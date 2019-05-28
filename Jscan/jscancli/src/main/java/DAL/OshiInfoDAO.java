package DAL;

import DAL.config.Database;
import Model.Computador;
import Model.Funcionario;
import java.sql.SQLException;
import org.springframework.jdbc.core.JdbcTemplate;

public class OshiInfoDAO implements IDAO<Computador> {

    private static Database db;
    private static JdbcTemplate connection;

    public OshiInfoDAO() throws SQLException {
        db = new Database();
        connection = db.getConnection();
    }

    @Override
    public boolean Get() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void Insert() throws SQLException {       
        connection.update("INSERT INTO TB_COMPUTADOR "
                + " VALUES (?,?,?,?,?,?,?)",
                Computador.getNmComputador(),
                Computador.getNmSistemaOperacional(),
                Computador.getNmModeloSistema(),
                Computador.getVlMemoriaRam(),
                Computador.getVlArmazenamento(),
                Computador.getNmProcessador(),
                Funcionario.getIdFuncionario());
    }
}
