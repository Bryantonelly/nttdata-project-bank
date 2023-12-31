package com.nttdata.bank.creditservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.nttdata.bank.creditservice.model.client.MovementFeignClient;
import com.nttdata.bank.creditservice.model.entity.Credit;
import com.nttdata.bank.creditservice.model.entity.CreditBusiness;
import com.nttdata.bank.creditservice.model.entity.CreditPersonal;
import com.nttdata.bank.creditservice.model.entity.Movement;
import com.nttdata.bank.creditservice.model.repository.CreditRepository;
import com.nttdata.bank.creditservice.model.service.CreditService;

@Service
public class CreditServiceImpl implements CreditService{
	
	@Autowired
	private CreditRepository creditRepository;
	
	@Autowired
	private MovementFeignClient movementFeign;
	
	@Override
	public List<Credit> getCreditByCustomer(Long customerId) {
		return creditRepository.findByCustomerId(customerId);
	}

	@Override
	public Credit createCreditPersonal(Long customerId) {
		List<Credit> listCreditPersonal = creditRepository.findByCustomerIdAndCreditType(customerId, "personal");
		if(!listCreditPersonal.isEmpty()) {
			return null;
		}
		
		CreditPersonal creditPersonal = new CreditPersonal();
		creditPersonal.setCustomerId(customerId);
		creditPersonal.setCreditType("personal");
		return creditRepository.save(creditPersonal);
	}

	@Override
	public Credit createCreditBusiness(Long customerId) {
		CreditBusiness creditBusiness = new CreditBusiness();
		creditBusiness.setCustomerId(customerId);
		creditBusiness.setCreditType("business");
		return creditRepository.save(creditBusiness);
	}

	@Override
	public String makeCreditPayment(Long id, Double paymentAumont) {
		Credit credit = creditRepository.findById(id).orElse(null);
		if(credit != null) {
			if(paymentAumont <= 0) {
				return "Payment amount is invalid, enter a number greater than 0";
			}
			
			if(paymentAumont > credit.getAmount()) {
				return "the payment is greater than the credit amount";
			}
			
			credit.setAmount(credit.getAmount() - paymentAumont);
			creditRepository.save(credit);
			
			Movement movement = new Movement();
			movement.setAccountId(id);
			movement.setTypeMovement("payment");
			movement.setTypeProduct("credit");
			movement.setAmount(paymentAumont);
			
			ResponseEntity<String> response = movementFeign.createMovement(movement);
			
			if(response.getStatusCode() == HttpStatus.CREATED) {
				return "Payment: "+paymentAumont;
			}
		}
		return "Credit Not Found";
	}

}
