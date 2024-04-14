package br.com.fiap.feedfront.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.fiap.feedfront.dto.FeedbackDTO;
import br.com.fiap.feedfront.model.Feedback;
import br.com.fiap.feedfront.service.FeedbackService;

import java.util.List;

@RestController
@RequestMapping("/feedbacks")
public class FeedbackController {
    @Autowired
    private FeedbackService feedbackService;

    @GetMapping
    public ResponseEntity<List<Feedback>> listarFeedbacks() {
        List<Feedback> feedbacks = feedbackService.listarFeedbacks();
        return ResponseEntity.ok(feedbacks);
    }

    @PostMapping
    public ResponseEntity<Feedback> cadastrarFeedback(@RequestBody FeedbackDTO feedbackDTO) {
        Feedback feedback = feedbackService.cadastrarFeedback(feedbackDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(feedback);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Feedback> atualizarFeedback(@PathVariable Long id, @RequestBody FeedbackDTO feedbackDTO) {
        Feedback feedbackAtualizado = feedbackService.atualizarFeedback(id, feedbackDTO);
        return ResponseEntity.ok(feedbackAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarFeedback(@PathVariable Long id) {
        feedbackService.deletarFeedback(id);
        return ResponseEntity.noContent().build();
    }
}
