package br.com.fiap.feedfront;

import org.junit.jupiter.api.Test;

import br.com.fiap.feedfront.model.Cliente;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.*;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ClienteTest {

    @Test
    public void testClienteValidation() {
        // Criar um cliente com dados válidos
        Cliente cliente = new Cliente(1L, "Billie", "billie@outlook.com");

        // Validar o cliente
        Set<ConstraintViolation<Cliente>> violations = getValidator().validate(cliente);

        // Verificar se não há violações de validação
        assertTrue(violations.isEmpty(), "Não deve haver violações de validação");

        // Verificar se os valores foram atribuídos corretamente
        assertEquals(1L, cliente.getId(), "O ID deve ser 1");
        assertEquals("Billie", cliente.getNome(), "O nome deve ser 'Billie'");
        assertEquals("billie@outlook.com", cliente.getEmail(), "O email deve ser 'billie@outlook.com'");
    }

    // Método utilitário para obter o validador
    private Validator getValidator() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        return factory.getValidator();
    }
}
