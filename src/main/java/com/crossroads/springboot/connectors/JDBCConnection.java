package com.crossroads.springboot.connectors;

import com.crossroads.springboot.Entities.UserProfile;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.integration.IntegrationProperties;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class JDBCConnection {
    private static final String database = "crossroads";

    private static ConnectionProperties connectionProperties = null;

    @Autowired
    public JDBCConnection(ConnectionProperties connectionProperties) {
        this.connectionProperties = connectionProperties;
    }

    public String getConnectionProperties() {
        return connectionProperties.getUrl();
    }

    public static List<UserProfile> getUsers(int limit) throws SQLException {
        List<UserProfile> users = new ArrayList<>();
        Connection myCon = DriverManager.getConnection(connectionProperties.getUrl(),connectionProperties.getUsername(),connectionProperties.getPassword());
        String query = "select username from " + database + ".users limit " + limit;
        PreparedStatement statement;
        statement = myCon.prepareStatement(query);
        ResultSet result = statement.executeQuery();

        while (result.next())
        {
            UserProfile user = new UserProfile();
            user.setUsername(result.getString("username"));
            users.add(user);
        }
        return users;

    }
}
