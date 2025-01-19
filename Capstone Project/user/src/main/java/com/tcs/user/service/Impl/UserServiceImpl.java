package com.tcs.user.service.Impl;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.tcs.user.DTO.BankAccountDTO;
import com.tcs.user.entity.User;
import com.tcs.user.repository.UserRepo;
import com.tcs.user.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepo userRepo;
	
	@Autowired
	RestTemplate restTemplate;

	@Override
	public void save(User user) {
		userRepo.save(user);
		String url="http://localhost:9090/bank";
		BankAccountDTO bankDTO=new BankAccountDTO(user.getAccountNumber(),user.getAccountType(), user.getUserId());
		ResponseEntity<BankAccountDTO> resp=restTemplate.postForEntity(url, bankDTO, BankAccountDTO.class);
		System.out.println(resp);
		if(resp.getStatusCode()==HttpStatus.OK) {
			userRepo.save(user);
		}
		
		else
		{
			System.out.println("Failed to Connect.....");
		}
	}

	@Override
	public List<User> findAll() {
		String url="http://localhost:9090/bank";
		BankAccountDTO[] bankDTO= restTemplate.getForObject(url, BankAccountDTO[].class);
		for(BankAccountDTO bank:bankDTO) {
			System.out.println(bank.toString());
		}
		return userRepo.findAll();
	}

	@Override
	public User findById(int id) {
		return userRepo.findById(id).get();
	}

	@Override
	public void deleteByUserId(int userId) {
		String url="http://localhost:9090/bank";
//		+String.valueOf(userId);
		restTemplate.delete(url,userId);
//		userRepo.deleteByUserId(userId);
	}

	@Override
	public List<BankAccountDTO> getUserAccounts(int id) {
		String url="http://localhost:9090/bank/"+String.valueOf(id);
		System.out.println(url);
		BankAccountDTO[] bankDTO= restTemplate.getForObject(url, BankAccountDTO[].class);
		List<BankAccountDTO> l = new ArrayList<>();
		for(BankAccountDTO bank:bankDTO) {
//			System.out.println(bank.toString());
			l.add(bank);
		}
		return l;
		
	}

	@Override
	public void deleteById(int id) {
		userRepo.deleteById(id);
	}

}
