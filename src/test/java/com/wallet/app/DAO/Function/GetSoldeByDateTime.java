package com.wallet.app.DAO.Function;

import com.wallet.app.Model.Account;


import java.sql.Timestamp;

public class GetSoldeByDateTime {
    public static void main(String[] args) {

        Account testAccount = new Account();
        testAccount.setLastUpdateDateTime(Timestamp.valueOf( "2024-02-28 08:33:22.581941"));
        testAccount.setId(2);

        GetSoldeByDateTime getSoldeByDateTime = new GetSoldeByDateTime();
    }

}
