package DAL;

import java.sql.SQLException;

interface IDAO<T> {
    boolean Get() throws SQLException;
    void Insert() throws SQLException;
}
