package com.wallet.app.Controller;

import com.wallet.app.Model.Category_transaction;
import com.wallet.app.Model.Currency;
import com.wallet.app.Service.Category_transactionService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
public class Category_TransactionController {
    private Category_transactionService categoryTransactionService;
    public Category_TransactionController(Category_transactionService categoryTransactionService){
        this.categoryTransactionService = categoryTransactionService;
    }
    @GetMapping("/category")
    public List<Category_transaction> all() throws SQLException {
        return categoryTransactionService.allCategoryTransaction();
    }
    @DeleteMapping("/delete_categoryTransaction/{id}")
    public String deleteClient(@PathVariable int id) throws SQLException {
        categoryTransactionService.deleteCategoryTransaction(id);
        return "Category transaction successfully deleted ";
    }
}
