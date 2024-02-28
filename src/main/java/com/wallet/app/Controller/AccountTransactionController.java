package com.wallet.app.Controller;

import com.wallet.app.Model.AccountTransaction;
import com.wallet.app.Service.AccountTransactionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
