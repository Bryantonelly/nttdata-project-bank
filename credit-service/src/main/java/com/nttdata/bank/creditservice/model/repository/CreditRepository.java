package com.nttdata.bank.creditservice.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nttdata.bank.creditservice.model.entity.Credit;

@Repository
public interface CreditRepository extends JpaRepository<Credit, Long>{
	
	public List<Credit> findByCustomerIdAndCreditType(Long customerId, String creditType);
	public List<Credit> findByCustomerId(Long customerId);
}
