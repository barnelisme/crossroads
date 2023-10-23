package com.crossroads.springboot.APIs;

import com.crossroads.springboot.connectors.ConnectionProperties;
import com.crossroads.springboot.connectors.JDBCConnection;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController

@RequestMapping("/health/")
public class healthcheck {

    private final JDBCConnection jdbcConnection;

    @Autowired
    public healthcheck(JDBCConnection jdbcConnection) {
        this.jdbcConnection = jdbcConnection;
    }
    @GetMapping("name")
    public String ServerName()
    {
        return "test";
    }

    @GetMapping("con")
    public String getConnection() {
        String connectionProperties = jdbcConnection.getConnectionProperties();
        return "Connection Properties: " + connectionProperties;
    }

}
