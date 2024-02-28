package com.wallet.app.Controller;

import com.wallet.app.Model.Account;
import com.wallet.app.Service.AccountService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
public class AccountController {
    public AccountService accountService;
    @GetMapping("/ping")
    public String test (){
        return "pong";
    }
    public AccountController(AccountService accountService){
        this.accountService = accountService;
    }
    @GetMapping("/accounts")
    public List<Account> all() throws SQLException {
        return accountService.allAccount();
    }
    @DeleteMapping("/delete_account/{id}")
    public String deleteClient(@PathVariable int id) throws SQLException {
        accountService.deleteAccount(id);
        return "Account successfully deleted ";
    }
    @PostMapping("/insert_Account")
    public Account insertClient(@RequestBody Account toInsert){
        return accountService.insert(toInsert);
    }
}
