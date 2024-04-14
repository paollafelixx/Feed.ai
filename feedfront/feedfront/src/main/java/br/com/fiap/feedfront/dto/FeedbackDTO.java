package br.com.fiap.feedfront.dto;

import lombok.Data;

import jakarta.validation.constraints.*;;;

@SuppressWarnings("unused")
@Data
public class FeedbackDTO {
    private Long clienteId;

    @NotBlank
    private String mensagem;
}
