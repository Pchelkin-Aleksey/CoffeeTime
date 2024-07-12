package com.example.coffee_time.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "bonus_card")
@AllArgsConstructor
@NoArgsConstructor
public class BonusCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long client_id;
    private Integer amount;
    private Integer discount_percent;

}
