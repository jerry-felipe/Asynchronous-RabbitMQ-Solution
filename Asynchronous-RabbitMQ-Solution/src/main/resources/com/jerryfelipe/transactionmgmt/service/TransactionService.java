package com.jerryfelipe.transactionmgmt.service;

import com.jerryfelipe.transactionmgmt.entity.Account;
import com.jerryfelipe.transactionmgmt.entity.Transaction;
import com.jerryfelipe.transactionmgmt.repository.AccountRepository;
import com.jerryfelipe.transactionmgmt.repository.TransactionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransactionService {

    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;

    public TransactionService(AccountRepository accountRepository, TransactionRepository transactionRepository) {
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
    }

    @Transactional
    public void processTransfer(Long sourceAccountId, Long targetAccountId, Double amount, String uniqueKey) {
        transactionRepository.findByUniqueKey(uniqueKey).ifPresent(transaction -> {
            throw new IllegalStateException("Transaction already processed");
        });

        Account source = accountRepository.findById(sourceAccountId)
                .orElseThrow(() -> new IllegalArgumentException("Source account not found"));

        Account target = accountRepository.findById(targetAccountId)
                .orElseThrow(() -> new IllegalArgumentException("Target account not found"));

        if (source.getBalance() < amount) {
            throw new IllegalArgumentException("Insufficient balance");
        }

        source.setBalance(source.getBalance() - amount);
        target.setBalance(target.getBalance() + amount);

        accountRepository.save(source);
        accountRepository.save(target);

        Transaction transaction = new Transaction();
        transaction.setSourceAccount(source);
        transaction.setTargetAccount(target);
        transaction.setAmount(amount);
        transaction.setStatus("COMPLETED");
        transaction.setUniqueKey(uniqueKey);

        transactionRepository.save(transaction);
    }
}
