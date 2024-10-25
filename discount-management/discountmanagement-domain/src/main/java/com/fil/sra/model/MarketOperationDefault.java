package com.fil.sra.model;

import lombok.*;
import lombok.experimental.SuperBuilder;



@SuperBuilder
@Getter
@Setter
public class MarketOperationDefault extends MarketOperation{

    protected double discounted_value;

    protected boolean isPercent;

    protected int applyDiscount() {
        if(isPercent){
            for(ProductDiscounted productDiscounted : products){
                productDiscounted.setActualPrice(
                        (productDiscounted.getActualPrice()*(100-discounted_value)/100)
                );
            }
        } else {
            for(ProductDiscounted productDiscounted : products){
                if(!(productDiscounted.getActualPrice() < discounted_value)){
                    productDiscounted.setActualPrice(productDiscounted.getActualPrice()-discounted_value);
                }
            }
        }
    }
}
