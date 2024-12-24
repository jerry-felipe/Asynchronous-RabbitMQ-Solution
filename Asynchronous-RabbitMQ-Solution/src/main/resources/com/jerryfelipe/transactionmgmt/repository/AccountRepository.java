package com.jerryfelipe.transactionmgmt.repository;

import com.jerryfelipe.transactionmgmt.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
