package com.bank.model;

import java.time.LocalDate;

public class BankCustomerDetails {
	private int id;
	private String firstname;
	private String lastname;
	private String emailid;
	private String password;
	private long mobilenumber;
	private long adharnumber;
	private String gender;
	private String adress;
	private double amount;
	private long accountnumber;
	private LocalDate dateofbirth;
	
	public BankCustomerDetails(LocalDate dateofbirth) {
		super();
		this.dateofbirth = dateofbirth;
	}
	public LocalDate getDateofbirth() {
		return dateofbirth;
	}
	public void setDateofbirth(LocalDate dateofbirth) {
		this.dateofbirth = dateofbirth;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public long getMobilenumber() {
		return mobilenumber;
	}
	public void setMobilenumber(long mobilenumber) {
		this.mobilenumber = mobilenumber;
	}
	public long getAdharnumber() {
		return adharnumber;
	}
	public void setAdharnumber(long adharnumber) {
		this.adharnumber = adharnumber;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double d) {
		this.amount = d;
	}
	public long getAccountnumber() {
		return accountnumber;
	}
	public void setAccountnumber(long accountnumber) {
		this.accountnumber = accountnumber;
	}
	
	
	public BankCustomerDetails(int id, String firstname, String lastname, String emailid, String password,
			long mobilenumber, long adharnumber, String gender, String adress, double amount, long accountnumber
	) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.emailid = emailid;
		this.password = password;
		this.mobilenumber = mobilenumber;
		this.adharnumber = adharnumber;
		this.gender = gender;
		this.adress = adress;
		this.amount = amount;
		this.accountnumber = accountnumber;
		
	}
	public BankCustomerDetails() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "BankCustomerDetails [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", emailid="
				+ emailid + ", password=" + password + ", mobilenumber=" + mobilenumber + ", adharnumber=" + adharnumber
				+ ", gender=" + gender + ", adress=" + adress + ", amount=" + amount + ", accountnumber="
				+ accountnumber + "]";
	}
	
	
	
	
	
}
