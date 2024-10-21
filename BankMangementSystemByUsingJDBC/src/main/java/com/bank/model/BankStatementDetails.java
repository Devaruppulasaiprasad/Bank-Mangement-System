package com.bank.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class BankStatementDetails {
//	Transaction_id, Date_of_Transaction, Transaction_Amount, Time_Of_TranTsaction, Balance_Amount, Account_Number
	private int transactionid;
	private LocalDate dateoftransaction;
	private LocalTime transactiontime;
	private double transactionamount;
	private double balanceamount;
	private long accountnumber;
	public int getTransactionid() {
		return transactionid;
	}
	public void setTransactionid(int transactionid) {
		this.transactionid = transactionid;
	}
	public LocalDate getDateoftransaction() {
		return dateoftransaction;
	}
	public void setDateoftransaction(LocalDate dateoftransaction) {
		this.dateoftransaction = dateoftransaction;
	}
	public LocalTime getTransactiontime() {
		return transactiontime;
	}
	public void setTransactiontime(LocalTime transactiontime) {
		this.transactiontime = transactiontime;
	}
	public double getTransactionamount() {
		return transactionamount;
	}
	public void setTransactionamount(double transactionamount) {
		this.transactionamount = transactionamount;
	}
	public double getBalanceamount() {
		return balanceamount;
	}
	public void setBalanceamount(double balanceamount) {
		this.balanceamount = balanceamount;
	}
	public long getAccountnumber() {
		return accountnumber;
	}
	public void setAccountnumber(long accountnumber) {
		this.accountnumber = accountnumber;
	}
	public BankStatementDetails(int transactionid, LocalDate dateoftransaction, LocalTime transactiontime,
			double transactionamount, double balanceamount, long accountnumber) {
		super();
		this.transactionid = transactionid;
		this.dateoftransaction = dateoftransaction;
		this.transactiontime = transactiontime;
		this.transactionamount = transactionamount;
		this.balanceamount = balanceamount;
		this.accountnumber = accountnumber;
	}
	public BankStatementDetails() {
		
	}
	
	
	

}
