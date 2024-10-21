package com.bank;

import com.bank.service.BankService;
import com.bank.service.BankServiceImpl;

public class CustomerServiceAssociate {
	
	public static BankService customerService()
	{
		return new BankServiceImpl();
		
	}

}
