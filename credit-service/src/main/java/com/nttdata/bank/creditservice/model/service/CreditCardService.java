package com.nttdata.bank.creditservice.model.service;

import com.nttdata.bank.creditservice.model.entity.CreditCard;

public interface CreditCardService {
	public CreditCard createCreditCard(CreditCard creditCard);
	public String loadConsumptionCard(Long id, Double consumptionAmount);
	public Double getBalance(Long id);
}
