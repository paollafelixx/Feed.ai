package br.com.fiap.feedfront.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.feedfront.dto.FeedbackDTO;
import br.com.fiap.feedfront.exception.ResourceNotFoundException;
import br.com.fiap.feedfront.model.Feedback;
import br.com.fiap.feedfront.repository.ClienteRepository;
import br.com.fiap.feedfront.repository.FeedbackRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class FeedbackService {
    @Autowired
    private FeedbackRepository feedbackRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Feedback> listarFeedbacks() {
        return feedbackRepository.findAll();
    }

    @SuppressWarnings("deprecation")
    public Feedback cadastrarFeedback(FeedbackDTO feedbackDTO) {
        Feedback feedback = new Feedback(null, null, null, null);
        feedback.setCliente(clienteRepository.getById(feedbackDTO.getClienteId()));
        feedback.setMensagem(feedbackDTO.getMensagem());
        feedback.setData(LocalDateTime.now());
        return feedbackRepository.save(feedback);
    }

    public Feedback atualizarFeedback(Long id, FeedbackDTO feedbackDTO) {
        Feedback feedback = feedbackRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Feedback não encontrado com o ID: " + id));

        feedback.setMensagem(feedbackDTO.getMensagem());
        feedback.setData(LocalDateTime.now());

        return feedbackRepository.save(feedback);
    }

    public void deletarFeedback(Long id) {
        Feedback feedback = feedbackRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Feedback não encontrado com o ID: " + id));

        feedbackRepository.delete(feedback);
    }
}
