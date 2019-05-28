package DAL;

import DAL.config.Database;
import Model.Computador;
import Model.Funcionario;
import java.sql.SQLException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDAO implements IDAO<Funcionario> {

    private static Database db;
    private static JdbcTemplate connection;

    public UserDAO() throws SQLException {
        db = new Database();
        connection = db.getConnection();
    }

    @Override
    public boolean Get() throws SQLException {
        //Pegar o user no banco
        
        if(Funcionario.getNmEmail().equals("") || Funcionario.getNmSenha().equals("")){
            return false;
        }
        
        connection.query("SELECT "
                + "IDFUNCIONARIO, NMEMAIL, NMSENHA, IDTIPO "
                + "FROM TB_FUNCIONARIO "
                + "WHERE NMEMAIL = ? "
                + "AND NMSENHA = ?",
                new BeanPropertyRowMapper<Funcionario>(Funcionario.class),
                Funcionario.getNmEmail(),
                //Funcionario.getNmSenha().hashCode());
                Funcionario.getNmSenha());

        //Verificar se o usuário existe no sistema
        if (Funcionario.getIdFuncionario() != 0) {

            if(Funcionario.getIdTipo() == 1){
                return true; //validação no front por ser mais facil
            }

            //Verificar se existe um computador
            connection.query("SELECT "
                    + "C.IDCOMPUTADOR, "
                    + "C.NMCOMPUTADOR, "
                    + "C.NMSISTEMAOPERACIONAL, "
                    + "C.NMMODELOSISTEMA, "
                    + "C.VLMEMORIARAM, "
                    + "C.VLARMAZENAMENTO, "
                    + "C.NMPROCESSADOR "
                    + "FROM TB_COMPUTADOR C "
                    + "WHERE IDFUNCIONARIO = ?",
                    new BeanPropertyRowMapper<Computador>(Computador.class),
                    Funcionario.getIdFuncionario());

            //Caso não, crio
            if (Computador.getIdComputador() == 0) {
                new OshiInfoDAO().Insert();
            }
            
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public void Insert() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
