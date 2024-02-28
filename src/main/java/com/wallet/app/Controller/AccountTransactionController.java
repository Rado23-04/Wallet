package com.wallet.app.Controller;

import com.wallet.app.Model.Account;
import com.wallet.app.Model.AccountTransaction;
import com.wallet.app.Service.AccountTransactionService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
public class AccountTransactionController {
    private AccountTransactionService accountTransactionService;
    public AccountTransactionController (AccountTransactionService accountTransactionService){
        this.accountTransactionService = accountTransactionService;
    }
    @GetMapping("/accountTransaction")
    public List<AccountTransaction> all() throws SQLException {
        return accountTransactionService.allTransaction();
    }
    @DeleteMapping("/delete_accountTransaction/{id}")
    public String deleteClient(@PathVariable int id) throws SQLException {
        accountTransactionService.deleteAccountTransaction(id);
        return "Account transaction successfully deleted ";
    }
    @PostMapping("/insert_AccountTransaction")
    public AccountTransaction insertClient(@RequestBody AccountTransaction toInsert){
        return accountTransactionService.insert(toInsert);
    }
}
