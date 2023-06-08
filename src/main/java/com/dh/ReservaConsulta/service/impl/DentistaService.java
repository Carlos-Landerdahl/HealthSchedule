package com.dh.ReservaConsulta.service.impl;

import com.dh.ReservaConsulta.repository.IDentista;
import com.dh.ReservaConsulta.dto.request.DentistaRequestDTO;
import com.dh.ReservaConsulta.dto.response.DentistaResponseDTO;
import com.dh.ReservaConsulta.entity.Dentista;

import com.dh.ReservaConsulta.service.IDentistaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
public class DentistaService implements IDentistaService {
    private IDentista<Dentista> dentistaIDao;

    @Autowired
    public DentistaService(IDentista<Dentista> dentistaIDao) {
        this.dentistaIDao = dentistaIDao;
    }

    @Override
    public DentistaResponseDTO salvar(DentistaRequestDTO requestDTO) throws SQLException {
        ObjectMapper mapper = new ObjectMapper();
        Dentista dentista = mapper.convertValue(requestDTO, Dentista.class );
        Dentista saveDentista = dentistaIDao.salvar(dentista);
        DentistaResponseDTO dentistaResponseDTO = mapper.convertValue(saveDentista, DentistaResponseDTO.class);

        return dentistaResponseDTO;
    }

    @Override
    public List<Dentista> buscarTodos() throws SQLException {
        return dentistaIDao.buscarTodos();
    }

    @Override
    public Optional<Dentista> buscarPorId(int id) throws SQLException{
        return dentistaIDao.buscarPorId(id);
    }

    @Override
    public void excluir(int id) throws SQLException{
        dentistaIDao.excluir(id);
    }
}
