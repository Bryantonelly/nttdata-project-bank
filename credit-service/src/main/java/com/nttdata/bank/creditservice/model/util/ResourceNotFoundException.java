package com.nttdata.bank.creditservice.model.util;

public class ResourceNotFoundException extends RuntimeException {
	public ResourceNotFoundException(String mensaje) {
		super(mensaje);
	}
}
