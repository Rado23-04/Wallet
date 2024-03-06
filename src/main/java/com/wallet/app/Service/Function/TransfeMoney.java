package com.wallet.app.Service.Function;


import com.wallet.app.Model.Account;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import static com.wallet.app.ConnectionDatabase.ConfigurationDatabase.getConnection;
@Service
public class TransfeMoney {
    public Account DoTransactionbetween(Account account, String label, double amount, String typeTransaction, int id_account, int id_category) throws SQLException {
        String sql = "INSERT INTO  \"Transaction\" (label, amount, type, id_account,id_category)" +
                "VALUES (?, ?, ?, ?, ?);";
        try (PreparedStatement statement = getConnection().prepareStatement(sql)) {
            statement.setString(1, label);
            statement.setDouble(2, amount);
            statement.setString(3, typeTransaction);
            statement.setInt(4, id_account);
            statement.setInt(5, id_category);

            statement.executeUpdate();

            Double accountPay = account.getPay();
            if (accountPay != null) {
                if (account.getType().equals("Banque") || (!account.getType().equals("Banque") && accountPay >= amount)) {
                    if (typeTransaction.equals("debit")) {
                        account.setPay(accountPay - amount);
                    } else if (typeTransaction.equals("credit")) {
                        account.setPay(accountPay + amount);
                    }
                    String updateDebit = "UPDATE \"Account\" SET pay = pay - ? WHERE id = ?";
                    try (PreparedStatement statement1 = getConnection().prepareStatement(updateDebit)) {
                        statement1.setDouble(1, account.getPay());
                        statement1.setInt(2, account.getId());
                        statement1.executeUpdate();
                    }
                    String updateCredit = "UPDATE \"Account\" SET pay = pay + ? WHERE id = ?";
                    try(PreparedStatement statement2 = getConnection().prepareStatement(updateCredit)){
                        statement2.setDouble(1,account.getPay());
                        statement2.setInt(2, account.getId());

                    }
                }
            }
        }
        return account;
    }
    }
/**
 * update Account set pay = pay - ? where id = ?;
 * select amount from transaction where
 *
 *
 *
 *
 *
 * update Account set pay = pay + ? where id = ?
 *
 *
 */