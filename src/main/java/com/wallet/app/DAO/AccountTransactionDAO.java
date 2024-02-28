package com.wallet.app.DAO;

import com.wallet.app.ConnectionDatabase.ConfigurationDatabase;
import com.wallet.app.Generic.GenericDAO;
import com.wallet.app.Model.AccountTransaction;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.wallet.app.ConnectionDatabase.ConfigurationDatabase.getConnection;

@Repository
public class AccountTransactionDAO implements GenericDAO<AccountTransaction> {
    @Override
    public List<AccountTransaction> findAll() {
        List<AccountTransaction> accountTransactions = new ArrayList<>();

        String sql = "SELECT * FROM \"Account_transaction\";";


        try (Connection connection = ConfigurationDatabase.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                AccountTransaction accountTransaction = new AccountTransaction();
                accountTransaction.setId(resultSet.getInt("id"));
                accountTransaction.setId_transaction(resultSet.getInt("id_transaction"));
                accountTransaction.setId_account(resultSet.getInt("id_account"));

                accountTransactions.add(accountTransaction);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return accountTransactions;
    }

    @Override
    public List<AccountTransaction> saveAll(List<AccountTransaction> toSave) {
        return null;
    }

    @Override
    public AccountTransaction save(AccountTransaction toSave) {
        return null;
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM \"Account_transaction\" where id = ?;";
        try(PreparedStatement statement = getConnection().prepareStatement(sql)){
            statement.setInt(1,id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
