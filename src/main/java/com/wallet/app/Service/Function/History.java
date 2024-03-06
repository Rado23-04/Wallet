package com.wallet.app.Service.Function;

import com.wallet.app.Model.Transaction;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.wallet.app.ConnectionDatabase.ConfigurationDatabase.getConnection;

public class History {
    public List<Transaction> TransactionHistory(Transaction transaction){
        List<Transaction> TransactionHistory = new ArrayList<>();
        String sql = "SELECT * FROM \"Transaction\" WHERE date_time >= ? AND\n" +
                "    date_time <= ? and id_account= ?;";

        try (PreparedStatement statement = getConnection().prepareStatement(sql)){
                statement.setTimestamp(1,transaction.getDateTime());
                statement.setTimestamp(2,transaction.getDateTime());
                statement.setInt(3,transaction.getIdAccount());

                try(ResultSet resultSet = statement.executeQuery()){
                    while (resultSet.next()){
                        Transaction transactions = new Transaction();
                        transactions.setId(resultSet.getInt("id"));
                        transactions.setLabel(resultSet.getString("label"));
                        transactions.setAmount(resultSet.getDouble("amount"));
                        transactions.setDateTime(resultSet.getTimestamp("date_time"));
                        transactions.setType(resultSet.getString("type"));
                        transactions.setIdAccount(resultSet.getInt("id_account"));
                        transactions.setIdCategory(resultSet.getInt("id_category"));
                        TransactionHistory.add(transactions);
                    }
                }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return TransactionHistory;
    }
}
