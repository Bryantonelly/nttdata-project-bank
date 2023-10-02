package com.nttdata.bank.creditservice.model.service;

import java.util.List;

import com.nttdata.bank.creditservice.model.entity.Credit;

public interface CreditService {
	
	public List<Credit> getCreditByCustomer(Long customerId);
	public Credit createCreditPersonal(Long customerId);
	public Credit createCreditBusiness(Long customerId);
	public String makeCreditPayment(Long id, Double paymentAumont);
}
