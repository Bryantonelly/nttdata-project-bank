package com.nttdata.bank.accountservice.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nttdata.bank.accountservice.model.entity.Account;



@Repository
public interface AccountRepository extends JpaRepository<Account, Long>{
	
	public List<Account> findByCustomerId(Long id);
}
