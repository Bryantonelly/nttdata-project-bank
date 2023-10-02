package com.nttdata.bank.creditservice.model.entity;


import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class CreditBusiness extends Credit{
	
	private String companyName;
}
