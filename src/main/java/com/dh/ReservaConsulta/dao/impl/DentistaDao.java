package com.dh.ReservaConsulta.dao.impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dh.ReservaConsulta.config.ConfiguracaoJdbc;
import com.dh.ReservaConsulta.dao.IDentista;
import com.dh.ReservaConsulta.model.Dentista;

@Repository
public class DentistaDao implements IDentista<Dentista>{

    private ConfiguracaoJdbc configuracaoJdbc;

    @Autowired
    public DentistaDao(ConfiguracaoJdbc configuracaoJdbc){
        this.configuracaoJdbc = configuracaoJdbc;
    }

    @Override
    public Dentista salvar(Dentista dentista) throws SQLException {
        String query = "INSERT INTO dentista (nome, sobrenome, matricula) VALUES (?, ?, ?)";

        try (Connection connection = configuracaoJdbc.conectarBancoDeDados();
             PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, dentista.getNome());
            preparedStatement.setString(2, dentista.getSobrenome());
            preparedStatement.setString(3, dentista.getMatricula());
            preparedStatement.executeUpdate();
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();

            if (generatedKeys.next()) {
                dentista.setId(generatedKeys.getInt(1));
                System.out.println("Dentista criado: " + dentista);
            }
        }

        return dentista;
    }

    @Override
    public List<Dentista> buscarTodos() throws SQLException {
        String query = "SELECT * FROM dentista";
        List<Dentista> dentistaList = new ArrayList<>();

        try (Connection connection = configuracaoJdbc.conectarBancoDeDados();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nome = resultSet.getString("nome");
                String sobrenome = resultSet.getString("sobrenome");
                String matricula = resultSet.getString("matricula");
                Dentista dentista = new Dentista(id, nome, sobrenome, matricula);
                dentistaList.add(dentista);
            }
        }
        return dentistaList;
    }

    @Override
    public void excluir(int id) throws SQLException {
        String query = "DELETE FROM dentista WHERE ID = ?";

        try (Connection connection = configuracaoJdbc.conectarBancoDeDados();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }
    }
}
