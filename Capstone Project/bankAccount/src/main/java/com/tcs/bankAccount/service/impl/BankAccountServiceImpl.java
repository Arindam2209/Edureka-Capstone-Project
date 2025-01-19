package com.tcs.bankAccount.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.bankAccount.entity.BankAccount;
import com.tcs.bankAccount.repository.BankAccountRepo;
import com.tcs.bankAccount.service.BankAccountService;

@Service
public class BankAccountServiceImpl implements BankAccountService {
	
	@Autowired
	BankAccountRepo bankAccountRepo;

	@Override
	public void save(BankAccount bankAccount) {
		bankAccountRepo.save(bankAccount);
	}

	@Override
	public List<BankAccount> findAll() {
		return bankAccountRepo.findAll();
	}

	@Override
	public BankAccount findById(int id) {
		return bankAccountRepo.findById(id).get();
	}

	@Override
	public void deleteById(int id) {
		bankAccountRepo.deleteById(id);
	}

	@Override
	public List<BankAccount> findByUserId(int userId) {
		return bankAccountRepo.findByUserId(userId);
	}

	@Override
	public void deleteByUserId(int userId) {
		bankAccountRepo.deleteByUserId(userId);
		
	}

}

