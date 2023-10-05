package br.com.shire42.customerbff.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    private UUID id;
    private String name;
    private String lastName;
    private String email;
    private List<Wallet> wallets;

}
