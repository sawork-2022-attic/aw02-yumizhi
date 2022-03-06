package com.example.poshell.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Item {
    private Product product;
    private int amount;

    @Override
    public String toString(){
        return product.toString() +"\t" + amount;
    }
    public void modifyAmount(int newAmount){
        if(newAmount > 0){
            amount = newAmount;
        }
    }
}
