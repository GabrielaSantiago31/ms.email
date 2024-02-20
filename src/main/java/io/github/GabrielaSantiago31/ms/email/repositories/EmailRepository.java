package io.github.GabrielaSantiago31.ms.email.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.GabrielaSantiago31.ms.email.models.Email;

public interface EmailRepository extends JpaRepository<Email, Long>{

}
