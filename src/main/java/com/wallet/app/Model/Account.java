package com.wallet.app.Model;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import lombok.*;

@Getter
@AllArgsConstructor
@Setter
@ToString
@NoArgsConstructor
public class Account {
    private int id;
    private String name;
    private Double pay;
    private Timestamp lastUpdateDateTime;
    private int idCurrency;
    private String type;

}
