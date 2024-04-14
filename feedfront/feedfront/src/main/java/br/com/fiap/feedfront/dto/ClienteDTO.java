package br.com.fiap.feedfront.dto;

import lombok.Data;

import jakarta.validation.constraints.*;;

@SuppressWarnings("unused")
@Data
public class ClienteDTO {
    @NotBlank
    private String nome;

    @NotBlank
    @Email
    private String email;
}
