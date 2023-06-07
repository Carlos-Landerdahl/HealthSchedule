package com.dh.ReservaConsulta.service;

import com.dh.ReservaConsulta.dao.IDentista;
import com.dh.ReservaConsulta.dto.request.DentistaRequestDTO;
import com.dh.ReservaConsulta.dto.response.DentistaResponseDTO;
import com.dh.ReservaConsulta.model.Dentista;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class DentistaService {
    private IDentista<Dentista> dentistaIDao;

    @Autowired
    public DentistaService(IDentista<Dentista> dentistaIDao) {
        this.dentistaIDao = dentistaIDao;
    }

    public DentistaResponseDTO salvar(DentistaRequestDTO requestDTO) throws SQLException {
        ObjectMapper mapper = new ObjectMapper();
        Dentista dentista = mapper.convertValue(requestDTO, Dentista.class );
        Dentista saveDentista = dentistaIDao.salvar(dentista);
        DentistaResponseDTO dentistaResponseDTO = mapper.convertValue(saveDentista, DentistaResponseDTO.class);

        return dentistaResponseDTO;
    }

    public List<Dentista> buscarTodos() throws SQLException {
        return dentistaIDao.buscarTodos();
    }

    public void excluir(int id) throws SQLException{
        dentistaIDao.excluir(id);
    }
}
