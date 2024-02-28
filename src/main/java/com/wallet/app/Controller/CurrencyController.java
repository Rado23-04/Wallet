package com.wallet.app.Controller;

import com.wallet.app.Model.Currency;
import com.wallet.app.Service.CurrencyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
