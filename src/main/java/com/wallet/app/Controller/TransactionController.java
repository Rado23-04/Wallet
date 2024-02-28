package com.wallet.app.Controller;

import com.wallet.app.Model.Transaction;
import com.wallet.app.Service.TransactionService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    @DeleteMapping("/delete_transaction/{id}")
    public String deleteClient(@PathVariable int id) throws SQLException {
        transactionService.deleteTransaction(id);
        return "Transaction successfully deleted";
    }
}
