package com.jerryfelipe.transactionmgmt.repository;

import com.jerryfelipe.transactionmgmt.model.JwtToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JwtTokenRepository extends JpaRepository<JwtToken, Long> {
}