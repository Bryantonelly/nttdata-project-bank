package com.nttdata.bank.customerservice.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nttdata.bank.customerservice.model.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
