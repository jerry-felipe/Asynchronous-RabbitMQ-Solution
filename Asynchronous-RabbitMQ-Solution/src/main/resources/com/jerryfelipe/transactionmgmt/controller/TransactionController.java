package com.example.transactionmgmt.controller;

import com.jerryfelipe.transactionmgmt.service.TransactionService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/transfer")
    public void processTransfer(@RequestParam Long sourceAccountId,
                                @RequestParam Long targetAccountId,
                                @RequestParam Double amount,
                                @RequestParam String uniqueKey) {
        transactionService.processTransfer(sourceAccountId, targetAccountId, amount, uniqueKey);
    }
}
