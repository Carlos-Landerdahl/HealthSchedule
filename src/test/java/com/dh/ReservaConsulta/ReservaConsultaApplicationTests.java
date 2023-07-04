package com.dh.ReservaConsulta;

import com.dh.ReservaConsulta.entity.Consulta;
import com.dh.ReservaConsulta.entity.Dentista;
import com.dh.ReservaConsulta.entity.Paciente;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;
import java.time.LocalTime;

@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
class ReservaConsultaApplicationTests {

	@Autowired
	public MockMvc mockMvc;

	@Test
	@DisplayName("Lista todos os dentistas cadastrados no banco")
	void buscarTodosDentistas() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/dentistas/buscar"))
				.andDo(MockMvcResultHandlers.print())
				.andExpect(MockMvcResultMatchers.status().isOk());
	}
	@Test
	@DisplayName("Buscar um dentista por ID")
	void buscarDentistaID() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/dentistas/buscar/{ID}","1"))
				.andDo(MockMvcResultHandlers.print())
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	@DisplayName("Cadastrando um dentista")
	void cadastrarDentista() throws Exception {
		var dentista = new Dentista(12,"Joao","Gomes","2589");

		ObjectMapper mapper = new ObjectMapper();

		mockMvc.perform(MockMvcRequestBuilders.post("/dentistas/admin")
						.contentType(MediaType.APPLICATION_JSON)
						.content(mapper.writeValueAsString(dentista)))
				.andDo(MockMvcResultHandlers.print())
				.andExpect(MockMvcResultMatchers.status().isCreated());
	}
	@Test
	@DisplayName("Cadastrando um paciente")
	void cadastrarPaciente() throws Exception {
		var paciente = new Paciente(19,"Fabio","Junior",null, "112288-6","28/06/2023" );

		ObjectMapper mapper = new ObjectMapper();

		mockMvc.perform(MockMvcRequestBuilders.post("/pacientes/admin")
						.contentType(MediaType.APPLICATION_JSON)
						.content(mapper.writeValueAsString(paciente)))
				.andDo(MockMvcResultHandlers.print())
				.andExpect(MockMvcResultMatchers.status().isCreated());
	}

	@Test
	@DisplayName("Lista todos os pacientes cadastrados no banco")
	void buscarTodosPacientes() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/pacientes/buscar"))
				.andDo(MockMvcResultHandlers.print())
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	@DisplayName("Buscar um paciente pelo ID")
	void buscarPacienteID() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/pacientes/buscar/{id}","1"))
				.andDo(MockMvcResultHandlers.print())
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	@DisplayName("Cadastrando uma consulta")
	void cadastrarConsulta() throws Exception {
		var dentista = new Dentista();
		dentista.setId(1); // ID do dentista

		var paciente = new Paciente();
		paciente.setId(1); // ID do paciente

		var consulta = new Consulta();
		consulta.setDentista(dentista);
		consulta.setPaciente(paciente);
		consulta.setDataConsulta(LocalDate.now());
		consulta.setHoraConsulta(LocalTime.now());

		ObjectMapper mapper = new ObjectMapper();
		mapper.findAndRegisterModules();
		mockMvc.perform(MockMvcRequestBuilders.post("/consultas/admin")
						.contentType(MediaType.APPLICATION_JSON)
						.content(mapper.writeValueAsString(consulta)))
				.andDo(MockMvcResultHandlers.print())
				.andExpect(MockMvcResultMatchers.status().isCreated());
	}

	@Test
	@DisplayName("Lista todas as consultas cadastrados no banco")
	void buscarTodasConsultas() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/consultas/buscar"))
				.andDo(MockMvcResultHandlers.print())
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	@DisplayName("Buscar um consulta pelo ID")
	void buscarConsultaID() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/consultas/buscar/{id}","2"))
				.andDo(MockMvcResultHandlers.print())
				.andExpect(MockMvcResultMatchers.status().isOk());
	}
}
