package com.crossroads.springboot.APIs;

import com.crossroads.springboot.Entities.UserProfile;
import com.crossroads.springboot.connectors.JDBCConnection;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Slf4j

@RestController

@RequestMapping("info/")
public class JDBCSource {
    private final JDBCConnection jdbcConnection;

    @Autowired
    public JDBCSource(JDBCConnection jdbcConnection) {
        this.jdbcConnection = jdbcConnection;
    }

    @GetMapping("users")
    public List<UserProfile> GetUsers() throws SQLException {
        List<UserProfile> userList = new ArrayList<>();
        String connectionProperties = jdbcConnection.getConnectionProperties();
        return  JDBCConnection.getUsers(2);


       // return userList;
    }

}
