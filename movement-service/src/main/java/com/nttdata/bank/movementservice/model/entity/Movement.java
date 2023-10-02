package com.nttdata.bank.movementservice.model.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Movement {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long accountId;
	private Long customerId;
	private String typeMovement;
	private String typeProduct;
	private Double amount;
	private LocalDateTime date;
	@Transient
	private Customer customer;
}
