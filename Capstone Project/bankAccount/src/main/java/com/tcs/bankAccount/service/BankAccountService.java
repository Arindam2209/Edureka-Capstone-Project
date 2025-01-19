package com.tcs.bankAccount.service;

import java.util.List;

import com.tcs.bankAccount.entity.BankAccount;

public interface BankAccountService {
	
	void save(BankAccount bankAccount);
	List<BankAccount> findAll();
	BankAccount findById(int id);
	void deleteById(int id);
	List<BankAccount> findByUserId(int userId);
	void deleteByUserId(int userId);

}
