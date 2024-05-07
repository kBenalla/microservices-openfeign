package org.com.microservicecommand.repository;

import org.com.microservicecommand.entities.Command;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandRepository extends JpaRepository<Command,Integer> {
}
