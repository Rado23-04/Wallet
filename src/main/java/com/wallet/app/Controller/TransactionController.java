package com.wallet.app.Controller;

import com.wallet.app.Model.Currency;
import com.wallet.app.Model.Transaction;
import com.wallet.app.Service.TransactionService;
import org.springframework.web.bind.annotation.*;

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
    @DeleteMapping("/delete_transaction/{id}")
    public String deleteClient(@PathVariable int id) throws SQLException {
        transactionService.deleteTransaction(id);
        return "Transaction successfully deleted";
    }
    @PostMapping("/insert_Transaction")
    public Transaction insertClient(@RequestBody Transaction toInsert){
        return transactionService.insert(toInsert);
    }
}
