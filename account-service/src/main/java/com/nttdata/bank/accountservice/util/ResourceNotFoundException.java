package com.nttdata.bank.accountservice.util;

public class ResourceNotFoundException extends RuntimeException {
	public ResourceNotFoundException(String mensaje) {
		super(mensaje);
	}
}
