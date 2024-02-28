package com.wallet.app.DAO;

import com.wallet.app.Generic.GenericDAO;
import com.wallet.app.Model.Transaction;

import java.util.List;

public class TransactionDAO implements GenericDAO<Transaction> {
    @Override
    public List<Transaction> findAll() {
        return null;
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
    public Transaction delete(Transaction toDelete) {
        return null;
    }
}
