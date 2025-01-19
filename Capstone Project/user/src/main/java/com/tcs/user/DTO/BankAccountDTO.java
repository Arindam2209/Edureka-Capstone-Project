package com.tcs.user.DTO;

public class BankAccountDTO {
	
	String accountNumber;
	String accountType;
	int userId;
	public BankAccountDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BankAccountDTO(String accountNumber, String accountType, int userId) {
		super();
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.userId=userId;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "BankAccountDTO [accountNumber=" + accountNumber + ", accountType=" + accountType + ", userId=" + userId
				+ "]";
	}
	

}
