package DAL.config;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class Database {
    private static SQLServerDriver driver;
    private static BasicDataSource connectionString;
    private static JdbcTemplate connection;

    public Database() {
        this.driver = new SQLServerDriver();
        this.connectionString = new BasicDataSource();
    }
    
    private BasicDataSource getConnectionString(){
        connectionString.setDriver(this.driver);
        connectionString.setUsername("ADM_JSCAN");
        connectionString.setPassword("Y33bkxs9@");
        connectionString.setUrl("jdbc:sqlserver://jscanserver.database.windows.net:1433;database=jscandb;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");
        
        return connectionString;
    }
    
    public JdbcTemplate getConnection(){
        BasicDataSource dataSource = getConnectionString();
        this.connection = new JdbcTemplate(dataSource);
        
        return this.connection;
    }
}
