package com.wallet.app.DAO;


import com.wallet.app.Generic.GenericDAO;
import com.wallet.app.Model.Account;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.wallet.app.ConnectionDatabase.ConfigurationDatabase.getConnection;


@Repository
public class AccountDAO implements GenericDAO<Account> {

    @Override
    public List<Account> findAll() {
        List<Account> accounts = new ArrayList<>();

        String sql = "SELECT * FROM \"Account\";";


        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Account account = new Account();
                account.setId(resultSet.getInt("id"));
                account.setName(resultSet.getString("name"));
                account.setPay(resultSet.getDouble("pay"));
                account.setLastUpdateDateTime(resultSet.getTimestamp("last_update_date_time"));
                account.setIdCurrency(resultSet.getInt("id_currency"));
                account.setType(resultSet.getString("type"));
                accounts.add(account);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return accounts;
    }

    @Override
    public List<Account> saveAll(List<Account> toSave) {
        return null;
    }

    @Override
    public Account save(Account toSave) {
        return null;
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM \"Account\" where id = ?";
        try(PreparedStatement statement = getConnection().prepareStatement(sql)){
            statement.setInt(1,id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
