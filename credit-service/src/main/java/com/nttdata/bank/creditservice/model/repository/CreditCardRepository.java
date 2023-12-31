package com.nttdata.bank.creditservice.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nttdata.bank.creditservice.model.entity.CreditCard;

@Repository
public interface CreditCardRepository extends JpaRepository<CreditCard, Long>{

}
