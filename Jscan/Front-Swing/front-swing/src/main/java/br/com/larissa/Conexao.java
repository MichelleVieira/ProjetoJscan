
package br.com.larissa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Conexao {
    private Connection connection;
    private String connectionString = "jdbc:sqlserver://jsca.database.windows.net:1433;database=jsan_db;user=adm_jscan"
            + ";password=Y33bkxs9@;encrypt=true;"
            + "hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
    
    public List<String> conectaai(String queryStatement){
        List<String> resultado= new ArrayList<String>();
        try {
                connection = DriverManager.getConnection(connectionString);
                String schema = connection.getSchema();
                List lista = new ArrayList();
                System.out.println("Successful connection - Schema: " + schema);


                try (Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(queryStatement)) {

                 //resultado= resultSet.getString(2);
                 while (resultSet.next())
                    {
                        System.out.println(resultSet.getString(1));
                        System.out.println(resultSet.getString(2));
                        resultado.add(resultSet.getString(1));
                        resultado.add(resultSet.getString(2));
                    }
                    connection.close();
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }
         return resultado;
    } 
    
}
