package com.wallet.app.Generic;

import java.util.List;

public interface GenericDAO<Z> {
    List<Z> findAll();
    List<Z> saveAll(List<Z> toSave);
    Z save(Z toSave);

    <Z> void delete(int id);

}
