package com.workshop.voting_intention.model.repository;

import com.workshop.voting_intention.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
