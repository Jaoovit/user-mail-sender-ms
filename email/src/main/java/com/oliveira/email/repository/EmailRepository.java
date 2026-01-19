package com.oliveira.email.repository;

import com.oliveira.email.model.Email;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EmailRepository extends JpaRepository<Email, UUID> {

}
