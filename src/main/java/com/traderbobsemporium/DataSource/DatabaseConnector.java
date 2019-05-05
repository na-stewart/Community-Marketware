package main.java.com.traderbobsemporium.DataSource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.xml.bind.PropertyException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseConnector {
    private static HikariConfig config = new HikariConfig();
    public static HikariDataSource ds;


    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    public static void configSetup() throws IOException, PropertyException {
        config.setJdbcUrl("jdbc:mysql://" + "localhost" + ":3306/traderbobsemporium");
        config.setUsername("root");
        config.setPassword("root");
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        ds = new HikariDataSource(config);
    }
}