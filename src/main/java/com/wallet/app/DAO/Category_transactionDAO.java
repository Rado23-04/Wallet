package com.wallet.app.DAO;

import com.wallet.app.ConnectionDatabase.ConfigurationDatabase;
import com.wallet.app.Generic.GenericDAO;
import com.wallet.app.Model.Category_transaction;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.wallet.app.ConnectionDatabase.ConfigurationDatabase.getConnection;

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
        String sql = "INSERT INTO  \"Transaction_category\" (name, items_list)"+
                "VALUES (?, ?);";
        try (PreparedStatement statement = getConnection().prepareStatement(sql)){
            statement.setString(1,toSave.getName());
            statement.setString(2,toSave.getItemList());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM \"Transaction_category\" where id = ?;";
        try(PreparedStatement statement = getConnection().prepareStatement(sql)){
            statement.setInt(1,id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
