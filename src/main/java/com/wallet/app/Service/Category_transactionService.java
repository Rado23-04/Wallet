package com.wallet.app.Service;

import com.wallet.app.DAO.Category_transactionDAO;
import com.wallet.app.Model.AccountTransaction;
import com.wallet.app.Model.Category_transaction;
import com.wallet.app.Model.Currency;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
@Service
public class Category_transactionService {
    private Category_transactionDAO categoryTransactionDAO;
    public Category_transactionService (Category_transactionDAO categoryTransactionDAO){
        this.categoryTransactionDAO = categoryTransactionDAO;
    }
    public List<Category_transaction> allCategoryTransaction() throws SQLException {
        return categoryTransactionDAO.findAll();
    }
    public void deleteCategoryTransaction(int id) throws SQLException {
        categoryTransactionDAO.delete(id);
    }
    public Category_transaction insert(Category_transaction toInsert){
        categoryTransactionDAO.save(toInsert);
        return toInsert;
    }
}
