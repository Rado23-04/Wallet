package com.wallet.app.DAO;

import com.wallet.app.ConnectionDatabase.ConfigurationDatabase;
import com.wallet.app.Generic.GenericDAO;
import com.wallet.app.Model.Account;
import com.wallet.app.Model.Currency;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.wallet.app.ConnectionDatabase.ConfigurationDatabase.getConnection;

@Repository
public class CurrencyDAO implements GenericDAO<Currency> {
    @Override
    public List<Currency> findAll() {
        List<Currency> currencyList = new ArrayList<>();

        String sql = "select * from \"Currency\";";
        try (Connection connection = ConfigurationDatabase.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Currency currency = new Currency();
                currency.setId(resultSet.getInt("id"));
                currency.setName(resultSet.getString("name"));
                currency.setCode(resultSet.getString("code"));
                currencyList.add(currency);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return currencyList;
    }

    @Override
    public List<Currency> saveAll(List<Currency> toSave) {
        return null;
    }

    @Override
    public Currency save(Currency toSave) {
        return null;
    }

    @Override
    public  void delete(int id) {
        String sql = "DELETE FROM \"Currency\" where id = ?;";
        try(PreparedStatement statement = getConnection().prepareStatement(sql)){
            statement.setInt(1,id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
