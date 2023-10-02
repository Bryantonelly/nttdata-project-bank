package com.nttdata.bank.movementservice.model.service;

import java.util.List;

import com.nttdata.bank.movementservice.model.entity.Movement;

public interface MovementService {
	
	public Movement saveMovement(Movement movement);
	public Movement getMovementById(Long id);
	public List<Movement> getAllMovements();
}
