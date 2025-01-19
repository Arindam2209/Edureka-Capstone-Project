package com.tcs.user.service;

import java.util.List;

import com.tcs.user.DTO.BankAccountDTO;
import com.tcs.user.entity.User;

public interface UserService {
	
	void save(User user);
	List<User> findAll();
	User findById(int id);
	void deleteById(int id);
	void deleteByUserId(int userId);
	List<BankAccountDTO> getUserAccounts(int id);

}
