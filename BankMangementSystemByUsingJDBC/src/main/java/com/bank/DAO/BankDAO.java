package com.bank.DAO;

import java.util.List;

import com.bank.model.BankCustomerDetails;

public interface BankDAO {
	List<BankCustomerDetails> getAllBankCustomerDetails();
	int inserBankCustomerDetails(BankCustomerDetails bankCustomerDetails);
	BankCustomerDetails userSigning(String emailormobilenumber,String password);
	int amountupdate(double amount,long accountnumber);
	
		
	

}
