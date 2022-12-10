package com.bank.deposit;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepositService implements IDepositService {

	@Autowired
	private DepositRepository repository;
	
	@Override
	public List<Deposit> findAll() {
		return repository.findAll();
	}

	@Override
	public Optional<Deposit> findById(Long id) {
		return repository.findById(id);
	}

	@Override
	public Deposit save(Deposit deposit) {
		return repository.save(deposit);
	}

	@Override
	public void delete(Deposit deposit) {
		repository.delete(deposit);
	}

}
