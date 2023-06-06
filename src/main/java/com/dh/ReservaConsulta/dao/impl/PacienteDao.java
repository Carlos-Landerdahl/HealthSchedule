package com.dh.ReservaConsulta.dao.impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dh.ReservaConsulta.config.ConfiguracaoJdbc;
import com.dh.ReservaConsulta.dao.IPaciente;
import com.dh.ReservaConsulta.model.Paciente;

@Repository
public class PacienteDao implements IPaciente<Paciente>{

  private ConfiguracaoJdbc configuracaoJdbc;

  @Autowired
  public PacienteDao(ConfiguracaoJdbc configuracaoJDBC) {
    this.configuracaoJdbc = configuracaoJDBC;
  }

  @Override
  public Paciente salvar(Paciente paciente) throws SQLException {
    String query = "INSERT INTO paciente (nome, sobrenome, endereco, rg, dataalta) " +
            "VALUES (?, ?, ?, ?, ?)";

    try (Connection connection = configuracaoJdbc.conectarBancoDeDados();
         PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

      preparedStatement.setString(1, paciente.getNome());
      preparedStatement.setString(2, paciente.getSobrenome());
      preparedStatement.setString(3, paciente.getEndereco());
      preparedStatement.setString(4, paciente.getRg());
      preparedStatement.setString(5, paciente.getDataAlta());
      preparedStatement.executeUpdate();

      ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
      if (generatedKeys.next()) {
        paciente.setId(generatedKeys.getInt(1));
        System.out.println("Paciente criado: " + paciente.toString());
      }
    }
    return paciente;
  }

  @Override
  public List<Paciente> buscarTodos() throws SQLException {
    String query = "SELECT * FROM paciente";
    List<Paciente> pacienteList = new ArrayList<>();

    try (Connection connection = configuracaoJdbc.conectarBancoDeDados();
         Statement statement = connection.createStatement();
         ResultSet resultSet = statement.executeQuery(query)) {

      while (resultSet.next()) {
        int id = resultSet.getInt("id");
        String nome = resultSet.getString("nome");
        String sobrenome = resultSet.getString("sobrenome");
        String endereco = resultSet.getString("endereco");
        String rg = resultSet.getString("rg");
        String dataAlta = resultSet.getString("dataalta");

        Paciente paciente = new Paciente(id, nome, sobrenome, endereco, rg, dataAlta);
        pacienteList.add(paciente);
      }
    }
    return pacienteList;
  }

  @Override
  public void excluir(int id) throws SQLException {
    String query = "DELETE FROM paciente WHERE ID = ?";

    try (Connection connection = configuracaoJdbc.conectarBancoDeDados();
         PreparedStatement preparedStatement = connection.prepareStatement(query)) {

      preparedStatement.setInt(1, id);
      preparedStatement.executeUpdate();
    }
  }
}