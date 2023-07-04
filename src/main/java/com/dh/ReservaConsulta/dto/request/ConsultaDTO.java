package com.dh.ReservaConsulta.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class ConsultaDTO {
    private Integer dentistaId;
    private Integer pacienteId;
    private LocalDate dataConsulta;
    private LocalTime horaConsulta;
}
