package br.com.shire42.customerbff.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Wallet {

    private String name;
    private String description;
    private Double resource;
    private List<Card> cards;

}
