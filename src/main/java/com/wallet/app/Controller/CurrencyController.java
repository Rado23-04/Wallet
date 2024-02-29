package com.wallet.app.Controller;

import com.wallet.app.Model.Account;
import com.wallet.app.Model.Currency;
import com.wallet.app.Service.CurrencyService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
@RestController
public class CurrencyController {
    public CurrencyService currencyService;
    public CurrencyController(CurrencyService currencyService){
        this.currencyService = currencyService;
    }
    @GetMapping("/currency")
    public List<Currency> all() throws SQLException {
        return currencyService.allCurrency();
    }
    @DeleteMapping("/delete_currency/{id}")
    public String deleteClient(@PathVariable int id) throws SQLException {
        currencyService.deleteCurrency(id);
        return "Currency successfully deleted ";
    }
    @PostMapping("/insert_Currency")
    public Currency insertClient(@RequestBody Currency toInsert){
        return currencyService.insert(toInsert);
    }
}
