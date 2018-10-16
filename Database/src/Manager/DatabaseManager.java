package Manager;

import DataSource.DataSource;
import com.sun.rowset.CachedRowSetImpl;
import sun.misc.Cache;

import javax.sql.rowset.CachedRowSet;
import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Author Aidan Stewart
 * @Year 2018
 * Copyright (c)
 * All rights reserved.
 */
public class DatabaseManager {

    public ResultSet receiver(String query) throws SQLException {
        CachedRowSet cachedRowSet = new CachedRowSetImpl();
        Connection connection = DataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        cachedRowSet.populate(preparedStatement.executeQuery());
        tryToCloseReceiver(preparedStatement, connection);
        return cachedRowSet;
    }

    private void tryToCloseReceiver(PreparedStatement preparedStatement, Connection connection){
        try {
          closeReceiver(preparedStatement, connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void closeReceiver(PreparedStatement preparedStatement, Connection connection) throws SQLException {
        connection.close();
        preparedStatement.close();
    }

    public void update(String query) throws SQLException {
        PreparedStatement preparedStatement = DataSource.getConnection().prepareStatement(query);
        preparedStatement.execute();
        preparedStatement.close();
    }
}
