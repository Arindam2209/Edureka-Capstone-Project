package com.tcs.bankAccount.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.bankAccount.entity.BankAccount;
import com.tcs.bankAccount.service.BankAccountService;

@RestController
public class BankAccountController {
	
	@Autowired
	BankAccountService bankAccountService;
	
	@PostMapping("/bank")
	void Create(@RequestBody BankAccount bankAccount)
	{
		bankAccountService.save(bankAccount);
		System.out.println(bankAccount.toString());
	}
	
	@GetMapping("/bank")
	List<BankAccount> Read( )
	{
		return bankAccountService.findAll();
	}
	
//	@GetMapping("/bank/{id}")
//	BankAccount ReadById(@PathVariable int id)
//	{
//		return bankAccountService.findById(id);
//	}
	
	@GetMapping("/bank/{userId}")
	List<BankAccount> ReadByUserId(@PathVariable int userId)
	{
		return bankAccountService.findByUserId(userId);
	}
	
	@PutMapping("/bank")
	void Update(BankAccount bankAccount)
	{
		bankAccountService.save(bankAccount);
	}
	
	@DeleteMapping("/bank/{userId}")
	void Delete(@PathVariable int userId)
	{
		bankAccountService.deleteByUserId(userId);
	}

}
