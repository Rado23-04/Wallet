package com.wallet.app.Model;
import lombok.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
@Getter
@AllArgsConstructor
@Setter
@ToString
@NoArgsConstructor
public class Transaction {
    private int id;
    private String label;
    private Double amount;
    private Timestamp dateTime;
    private String type;
    private int idAccount;
    private int idCategory;
}
