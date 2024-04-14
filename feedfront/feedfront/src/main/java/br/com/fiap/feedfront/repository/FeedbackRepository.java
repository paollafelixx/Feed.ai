package br.com.fiap.feedfront.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.feedfront.model.Feedback;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
}
