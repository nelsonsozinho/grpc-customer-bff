package br.com.shire42.customerbff.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Card {

    private String holder;
    private String expiration;
    private String number;
    private String cvc;

}
