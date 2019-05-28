package DAL;

import DAL.config.Database;
import Model.Computador;
import OSHI.PcLeitura;
import java.sql.SQLException;
import Model.LeituraPc;
import org.springframework.jdbc.core.JdbcTemplate;

public class OshiReadDAO implements IDAO<PcLeitura> {

    private Database db;
    private JdbcTemplate connection;

    public OshiReadDAO() throws SQLException {
        db = new Database();
        connection = db.getConnection();
    }
    
    @Override
    public boolean Get() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Insert() throws SQLException {
        connection.update(" INSERT INTO TB_LEITURA_PC " +
                        "(IdComputador, " +
                        "VLLEITURAARMAZENAMENTO, " +
                        "VLLEITURACPU, " +
                        "VLLEITURAMEMORIA, " +
                        "DTREGISTRO, " +
                        "MDLEITURADISCO, " +
                        "TPATIVIDADE, " +
                        "VLPROCESSO) " +
            " VALUES (?,?,?,?, CURRENT_TIMESTAMP, ?, ?, ?)",
            Computador.getIdComputador(),
            LeituraPc.getActualStoragePercentage(),
            LeituraPc.getProcessing(),
            LeituraPc.getActualMemoryPercentage(),
            LeituraPc.getAvarageRead(),
            LeituraPc.getUpTime(),
            LeituraPc.getProcessNumber());

        int id = Computador.getIdComputador();
    }
}
