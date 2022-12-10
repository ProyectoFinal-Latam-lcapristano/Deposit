package com.bank.deposit;

import java.util.List;
import java.util.Optional;

public interface IDepositService {
	public List<Deposit> findAll();
	public Optional<Deposit> findById(Long id);
	public Deposit save(Deposit deposit);
	public void delete(Deposit deposit);
}
