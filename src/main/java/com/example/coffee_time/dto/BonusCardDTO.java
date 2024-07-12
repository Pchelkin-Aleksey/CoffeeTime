package com.example.coffee_time.dto;

import com.example.coffee_time.entity.BonusCard;

public record BonusCardDTO(
        Long id,
        Long client_id,
        Integer amount,
        Integer discount_percent) {

    public BonusCard toEntity(){
        return new BonusCard(id,client_id,amount,discount_percent);
    }

    public BonusCardDTO fromEntity(BonusCard bonusCard){
        return bonusCard == null
                ? new BonusCardDTO(null, null, null, null)
                : new BonusCardDTO(bonusCard.getId(), bonusCard.getClient_id(), bonusCard.getAmount(), bonusCard.getDiscount_percent());
    }
}