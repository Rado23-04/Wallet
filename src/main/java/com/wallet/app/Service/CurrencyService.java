package com.wallet.app.Service;

import com.wallet.app.DAO.CurrencyDAO;
import com.wallet.app.Model.Account;
import com.wallet.app.Model.Currency;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
@Service
public class CurrencyService {
    private CurrencyDAO currencyDAO;
    public CurrencyService (CurrencyDAO currencyDAO){
        this.currencyDAO = currencyDAO;
    }
    public List<Currency> allCurrency() throws SQLException {
        return currencyDAO.findAll();
    }
    public void deleteCurrency(int id) throws SQLException {
        currencyDAO.delete(id);
    }
    public Currency insert(Currency toInsert){
        currencyDAO.save(toInsert);
        return toInsert;
    }
}
