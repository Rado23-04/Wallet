package com.wallet.app.Service.Function;

import com.wallet.app.Model.Account;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.wallet.app.ConnectionDatabase.ConfigurationDatabase.getConnection;

@Service
public class GetSoldeByDateTime {
    public List<Account> findByDateTime(Account account){
        List<Account> SoldeCompte = new ArrayList<>();

        String SoldeByDateTime = "select * from \"Account\" where last_update_date_time = ? and id = ?;";

       try (PreparedStatement statement = getConnection().prepareStatement(SoldeByDateTime)){
           statement.setTimestamp(1,account.getLastUpdateDateTime());
           statement.setInt(2,account.getId());

           try (ResultSet resultSet = statement.executeQuery()){
               while (resultSet.next()){
                   Account account1 = new Account();
                   account1.setId(resultSet.getInt("id"));
                   account1.setName(resultSet.getString("name"));
                   account1.setPay(resultSet.getDouble("pay"));
                   account1.setLastUpdateDateTime(resultSet.getTimestamp("last_update_date_time"));
                   account1.setIdCurrency(resultSet.getInt("id_currency"));
                   account1.setType(resultSet.getString("type"));
                   SoldeCompte.add(account1);
               }
           }
       } catch (SQLException e) {
           throw new RuntimeException(e);
       }
        return SoldeCompte;
    }
}
/*
 SELECT * FROM "Account" WHERE last_update_date_time = '2024-02-28 08:33:22.581941' and id = 2;
    string sql = select * from "Account" where last_update_date_time = ? and id = ?;
 */

