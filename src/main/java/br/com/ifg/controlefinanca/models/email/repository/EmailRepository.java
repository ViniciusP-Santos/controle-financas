package br.com.ifg.controlefinanca.models.email.repository;

import br.com.ifg.controlefinanca.models.email.entity.Email;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepository extends JpaRepository<Email, Long> {
}
