package com.wallet.app.DAO;

import com.wallet.app.ConnectionDatabase.ConfigurationDatabase;
import com.wallet.app.Generic.GenericDAO;
import com.wallet.app.Model.Account;
import com.wallet.app.Model.Category_transaction;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Repository
public class Category_transactionDAO implements GenericDAO<Category_transaction> {
    @Override
    public List<Category_transaction> findAll() {
        List<Category_transaction> categoryTransactions = new ArrayList<>();

        String sql = "SELECT * FROM \"Transaction_category\";";


        try (Connection connection = ConfigurationDatabase.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Category_transaction categoryTransaction = new Category_transaction();
                categoryTransaction.setId(resultSet.getInt("id"));
                categoryTransaction.setName(resultSet.getString("name"));
                categoryTransaction.setItemList(resultSet.getString("items_list"));

                categoryTransactions.add(categoryTransaction);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return categoryTransactions;
    }

    @Override
    public List<Category_transaction> saveAll(List<Category_transaction> toSave) {
        return null;
    }

    @Override
    public Category_transaction save(Category_transaction toSave) {
        return null;
    }

    @Override
    public Category_transaction delete(Category_transaction toDelete) {
        return null;
    }
}
