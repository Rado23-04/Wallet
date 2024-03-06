package com.wallet.app.Generic;

import java.sql.SQLException;
import java.util.List;

public interface GenericDAO<Z> {
    List<Z> findAll();
    List<Z> saveAll(List<Z> toSave);
    Z save(Z toSave) throws SQLException;

    <Z> void delete(int id);

}
