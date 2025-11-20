package com.skillbridge.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrilhaDTO {
    @NotBlank(message = "nome é obrigatório")
    private String nome;

    private String descricao;

    @NotBlank(message = "nivel é obrigatório")
    @Pattern(regexp = "INICIANTE|INTERMEDIARIO|AVANCADO", message = "nivel deve ser INICIANTE, INTERMEDIARIO ou AVANCADO")
    private String nivel;

    @NotNull(message = "cargaHoraria é obrigatória")
    @Min(value = 1, message = "cargaHoraria deve ser positiva")
    private Integer cargaHoraria;

    private String focoPrincipal;
}
