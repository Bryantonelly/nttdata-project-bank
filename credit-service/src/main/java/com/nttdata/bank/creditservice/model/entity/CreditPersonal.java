package com.nttdata.bank.creditservice.model.entity;


import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class CreditPersonal extends Credit{
	
	private String documentIdentity;
}
