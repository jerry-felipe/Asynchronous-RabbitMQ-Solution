package com.jerryfelipe.transactionmgmt.repository;

import com.jerryfelipe.transactionmgmt.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}