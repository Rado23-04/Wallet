package com.wallet.app.Model;
import lombok.*;

@Getter
@AllArgsConstructor
@Setter
@ToString
@NoArgsConstructor
public class Currency {
    private int id;
    private String name;
    private String code;
}
