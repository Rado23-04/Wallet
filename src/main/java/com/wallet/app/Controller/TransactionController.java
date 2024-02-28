package com.wallet.app.Controller;

import com.wallet.app.Model.Transaction;
import com.wallet.app.Service.TransactionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;
@RestController
public class TransactionController {
    private TransactionService transactionService;
    public TransactionController(TransactionService transactionService){
        this.transactionService = transactionService;
    }
    @GetMapping("/transaction")
    public List<Transaction> all() throws SQLException {
        return transactionService.allTransaction();
    }
}
