package com.wallet.app.DAO;

import com.wallet.app.Model.Account;
import com.wallet.app.Service.Function.TransfeMoney;

import java.sql.SQLException;
import java.sql.Timestamp;

public class AccountDAOTest {
    public static void main(String[] args) throws SQLException {
        TransfeMoney transfeMoney = new TransfeMoney();
        Account account = new Account();

        System.out.println("Solde initial : " + account.getPay());

        account = transfeMoney.DoTransactionbetween(account, "Dépôt", 1000.0, "credit",4,6);
        System.out.println("Solde après dépôt : " + account.getPay());

        account = transfeMoney.DoTransactionbetween(account, "Retrait", 1000.0, "debit",3,6);
        System.out.println("Solde après retrait : " + account.getPay());



        System.out.println("Solde final : " + account.getPay());
    }
}


/*
  try {
            account = transfeMoney.DoTransactionbetween(account, "Achat", 60.0, "debit",1,1);
        } catch (RuntimeException e) {
            System.out.println("Transaction échouée : " + e.getMessage());
        }
 */