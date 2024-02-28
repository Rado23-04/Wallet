package com.wallet.app.DAO;

import com.wallet.app.ConnectionDatabase.ConfigurationDatabase;
import com.wallet.app.Generic.GenericDAO;
import com.wallet.app.Model.Account;
import com.wallet.app.Model.Transaction;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.wallet.app.ConnectionDatabase.ConfigurationDatabase.getConnection;

@Repository
public class TransactionDAO implements GenericDAO<Transaction> {
    @Override
    public List<Transaction> findAll() {
        List<Transaction> transactions = new ArrayList<>();

        String sql = "SELECT * FROM \"Transaction\";";


        try (Connection connection = ConfigurationDatabase.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Transaction transaction = new Transaction();
                transaction.setId(resultSet.getInt("id"));
                transaction.setLabel(resultSet.getString("label"));
                transaction.setAmount(resultSet.getDouble("amount"));
                transaction.setDateTime(resultSet.getTimestamp("date_time"));
                transaction.setType(resultSet.getString("type"));
                transaction.setIdAccount(resultSet.getInt("id_account"));
                transaction.setIdCategory(resultSet.getInt("id_category"));

                transactions.add(transaction);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return transactions;
    }

    @Override
    public List<Transaction> saveAll(List<Transaction> toSave) {
        return null;
    }

    @Override
    public Transaction save(Transaction toSave) {
        return null;
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM \"Transaction\" where id = ?;";
        try(PreparedStatement statement = getConnection().prepareStatement(sql)){
            statement.setInt(1,id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
