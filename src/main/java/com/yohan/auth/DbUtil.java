package com.yohan.auth;

import org.keycloak.component.ComponentModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static com.yohan.auth.CustomUserStorageProviderConstants.*;

public class DbUtil {
    public static Connection getConnection(ComponentModel config) throws SQLException {

        String driverClass = config.get(CONFIG_KEY_JDBC_DRIVER, CONFIG_KEY_JDBC_DRIVER);
        try {
            Class.forName(driverClass);
        }
        catch(ClassNotFoundException nfe) {
            // ... error handling omitted
        }

        return DriverManager.getConnection(
                config.get(CONFIG_KEY_JDBC_URL,CONFIG_KEY_JDBC_URL),
                config.get(CONFIG_KEY_DB_USERNAME,CONFIG_KEY_DB_USERNAME),
                config.get(CONFIG_KEY_DB_PASSWORD, CONFIG_KEY_DB_PASSWORD));
    }
}
