package com.dh.ReservaConsulta.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;

import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfiguracaoJdbc {
    private String jdbcDriver;
    private String dbUrl;
    private String nomeUsuario;
    private String senha;

    public ConfiguracaoJdbc() {
        try {
            Properties props = new Properties();
            FileInputStream in = new FileInputStream("db.properties");
            props.load(in);
            in.close();

            this.jdbcDriver = props.getProperty("jdbcDriver");
            this.dbUrl = props.getProperty("dbUrl");
            this.nomeUsuario = props.getProperty("username");
            this.senha = props.getProperty("password");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Connection conectarBancoDeDados() throws SQLException {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(dbUrl, nomeUsuario, senha);
        } catch (SQLException e) {
            throw new SQLException("Impossível se conectar ao banco", e);
        }
        return connection;
    }
}
