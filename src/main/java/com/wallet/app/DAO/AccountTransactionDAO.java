package com.wallet.app.DAO;

import com.wallet.app.Generic.GenericDAO;
import com.wallet.app.Model.AccountTransaction;

import java.util.List;

public class AccountTransactionDAO implements GenericDAO<AccountTransaction> {
    @Override
    public List<AccountTransaction> findAll() {
        return null;
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
    public AccountTransaction delete(AccountTransaction toDelete) {
        return null;
    }
}
