package com.bank.DAO;

import java.util.List;

import com.bank.model.BankStatementDetails;

public interface BankStatementDAO {
	 int insertBankStatement(BankStatementDetails bankStatementDetails) ;
	 List <BankStatementDetails> checkStatement(long accountnumber);

}
