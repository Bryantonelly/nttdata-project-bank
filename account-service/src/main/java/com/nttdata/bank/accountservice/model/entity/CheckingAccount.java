package com.nttdata.bank.accountservice.model.entity;


import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class CheckingAccount extends Account{
	
	private Double maintenanceFee;
}
