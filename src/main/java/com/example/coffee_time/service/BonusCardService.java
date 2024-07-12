package com.example.coffee_time.service;

import com.example.coffee_time.dto.BonusCardDTO;
import com.example.coffee_time.entity.BonusCard;
import com.example.coffee_time.exception.EntityNotFoundException;
import com.example.coffee_time.repository.BonusCardRepository;
import lombok.Data;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Data
public class BonusCardService {

    private final BonusCardRepository bonusCardRepository;

    public BonusCard findById(Long card_id){
      return bonusCardRepository.findById(card_id)
              .orElseThrow(() ->  new EntityNotFoundException(String.format("bonus not found", card_id)));
    }
}
