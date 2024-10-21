package com.bank.service;

import java.time.LocalDate;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

import javax.xml.bind.ParseConversionEvent;

import com.bank.DAO.BankDAO;
import com.bank.DAO.BankDAOImpl;
import com.bank.DAO.BankStatementDAO;
import com.bank.DAO.BankStatementDAOimpl;
import com.bank.model.BankCustomerDetails;
import com.bank.model.BankStatementDetails;
import com.google.protobuf.TextFormat.Parser;

public class BankServiceImpl implements BankService {
	 Scanner sc = new Scanner(System.in);
    
    BankDAO bankDAO = new BankDAOImpl();
    BankCustomerDetails customerlogin;
    BankStatementDAO bankstatementDAO=new BankStatementDAOimpl();
    List<BankCustomerDetails> allCustomerDetails = bankDAO.getAllBankCustomerDetails();
    
    @Override
    public void toSleep(String name) {
        for (int i = 0; i < name.length(); i++) {
            System.out.print(name.charAt(i));
            try {
                Thread.sleep(40);  // Added a delay of 500 milliseconds for better visual effect
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("\n");
    }

    @Override
    public void userRegistration() {
       
        
        // First name and Last name input
        System.out.print("Enter Your First Name: ");
        String firstName = sc.next();
        System.out.print("Enter Your Last Name: ");
        String lastName = sc.next();
        
        // Email input with validation
        String emailId;
        while (true) {
            System.out.print("Enter Your Email (must end with @gmail.com): ");
            emailId = sc.next();
            if (emailId.endsWith("@gmail.com")) {
            	boolean isEmailidUnique=true;
            	for(BankCustomerDetails customer:allCustomerDetails)
            	{
            		if(customer.getEmailid().equals(emailId))
            		{
            			isEmailidUnique=false;
            			System.out.println("Emailid is already taken ,please enter a different one.");
            			break;
            		}
            	}
            	if(isEmailidUnique)
            	{
            		break;
            	}
               
            } 
            else
            {
                System.out.println("Invalid Email! Please enter a valid Gmail address.");
            }
        }
        
        // Password input and validation
        String password;
        while (true) {
            System.out.print("Enter Your Password (min 4 characters): ");
            password = sc.next();
            
            if (password.length() >= 4) {
                boolean isPasswordUnique = true;
                for (BankCustomerDetails customer : allCustomerDetails) {
                    if (customer.getPassword().equals(password)) {
                        isPasswordUnique = false;
                        System.out.println("Password is already taken, please enter a different one.");
                        break;
                    }
                }
                if (isPasswordUnique) {
                    break;
                }
            } else {
                System.out.println("Password is too short, please enter at least 4 characters.");
            }
        }

        // Confirm Password
        while (true) {
            System.out.print("Confirm Your Password: ");
            String confirmPassword = sc.next();
            if (confirmPassword.equals(password)) {
                break;
            } else {
                System.out.println("Passwords do not match, please try again.");
            }
        }

        // Mobile Number Validation
        long mobileNumber;
        while (true) {
            System.out.print("Enter Your Mobile Number (10 digits): ");
            mobileNumber = sc.nextLong();
            if (mobileNumber>=6000000000l && mobileNumber<=9999999999l)
            {
            	boolean isMobileNumberUnique=true;
            	for(BankCustomerDetails bankCustomerDetails:allCustomerDetails)
            	{
            		if(bankCustomerDetails.getMobilenumber()==mobileNumber)
            		{
            			isMobileNumberUnique=false;
            			System.out.println("Mobile number is already taken,enter new mobile number:");
            			break;
            		}
            	}
            	if(isMobileNumberUnique)
            	{
            		break;
            	}
                
            } else {
                System.out.println("Invalid mobile number, please enter a 10-digit number.");
            }
        }
        
        

        // Aadhar Number input
        System.out.print("Enter Your Aadhar Number: ");
        long aadharNumber = sc.nextLong();
        while (true) {
            // Check if the Aadhar number is 12 digits long
            if (aadharNumber >= 100000000000L && aadharNumber <= 999999999999L) {
                boolean isAadharNumberUnique = true;
                // Check if the Aadhar number is unique
                for (BankCustomerDetails bankCustomerDetails : allCustomerDetails) {
                    if (bankCustomerDetails.getAdharnumber() == aadharNumber) {
                        isAadharNumberUnique = false;
                        System.out.println("Aadhar number is already taken, enter a new Aadhar number:");
                        aadharNumber = sc.nextLong();  // Take new input here
                        break;
                    }
                }
                // If Aadhar number is unique, break out of the loop
                if (isAadharNumberUnique) {
                    break;
                }
            } else {
                // If the Aadhar number is not valid, prompt for a new one
                System.out.println("Enter a valid Aadhar number with 12 digits:");
                aadharNumber = sc.nextLong();  // Take new input here
            }
        }
        
        System.out.println("Enter your date of birth in(yyyy-mm-dd)");
        String db=sc.next();

        Random random = new Random();
        long accountNumber = 10000 + random.nextInt(90000);  // Generates a number between 10000 and 99999
        

        
        // Gender input
        System.out.print("Enter Your Gender: ");
        String gender = sc.next();
        
        

        // Address input
        System.out.print("Enter Your Address: ");
       
        String address = sc.next();
        
       

        // Amount input
        System.out.print("Enter Your Initial Deposit Amount: ");
        int amount = sc.nextInt();
        
       
        
        
        
        BankCustomerDetails newCustomer = new BankCustomerDetails();
        newCustomer.setFirstname(firstName);
        newCustomer.setLastname(lastName);
        newCustomer.setEmailid(emailId);
        newCustomer.setPassword(password);
        newCustomer.setMobilenumber(mobileNumber);
        newCustomer.setAdharnumber(aadharNumber);
        newCustomer.setGender(gender);
        newCustomer.setAdress(address);
        newCustomer.setAccountnumber(accountNumber);
        newCustomer.setAmount(amount);
        newCustomer.setDateofbirth(LocalDate.parse(db));
        
        
      int res=  bankDAO.inserBankCustomerDetails(newCustomer);
      if(res!=0)
      {
    	  System.out.println(" User registration successful! ");
      }
      else
      {
    	  System.out.println("Server Error 500");
      }
        // Registration complete message
        
        
        // Optionally, you can now add logic to save the user details to the database.
    }

	@Override
	public void userlogin() {
		// TODO Auto-generated method stub
		System.out.println("Enter your emailid or password");
		String emailormobilenumber=sc.next();
		System.out.println("Enter your password");
		String password=sc.next();
		BankService bs=new BankServiceImpl();
		
		customerlogin=bankDAO.userSigning(emailormobilenumber, password);
		if(customerlogin!=null)
		{
			Random random=new Random();
			int otp=100000+random.nextInt(999999);
			System.out.println("Your otp is :"+otp);
			System.out.println("Please enter your otp");
			int count=0;
			while(count<3)
			{
				if(sc.nextInt()==otp){
					if(customerlogin.getGender().equalsIgnoreCase("MALE"))
					{
						bs.toSleep("Hello Mr "+customerlogin.getFirstname()+" "+customerlogin.getLastname());
					}
					else
					{
						bs.toSleep("Hello Ms "+customerlogin.getFirstname()+" "+customerlogin.getLastname());		
					}
					userFunctionlities();
					break;
				}
				else if(count==2)
				{
					System.out.println("You have exceeded your chances...");
					count++;
				}
				else
				{
					System.out.println("Invalid otp,please enter your correct otp");
					count++;
				}
			}
			
		}
		else
		{
			System.out.println("Invalid credentials");
		}
	}

	
	
	
	@Override
	public void userFunctionlities() {
		boolean status=true;
		while(status) {
			System.out.println("enter \n1.for credit \n2.to debit \n3.to check balance \n4.create statement ");
		
		switch (sc.nextInt()) {
		case 1:
			System.out.println("credit");
			credit();
			break;
		case 2:
			System.out.println("debit");
			debit();
			break;
		case 3:
			System.out.println("check balance");
			checkBalance();
			break;
		case 4:
			System.out.println("create statement");
			checkStatement();
			break;

		default:
			System.out.println("invalid selection");
			break;
		}
		System.out.println("Do u want to continue!!!");
		String choice=sc.next();
		if(!choice.equalsIgnoreCase("yes"))
		{
			System.out.println("Thank u visit again!!");
			status=false;
		}
	}
}
	
	
	
	public void credit()
	{
		System.out.println("Enter the amount to be credited !!!!!");
		Double amount=sc.nextDouble();
		if(amount>=0)
		{
			
			double credit=amount+customerlogin.getAmount();
			customerlogin.setAmount(credit);
			if(bankDAO.amountupdate(amount,customerlogin.getAccountnumber())!=0)
			{
				
				BankStatementDetails bankStatementDetails=new BankStatementDetails();
				bankStatementDetails.setAccountnumber(customerlogin.getAccountnumber());
				bankStatementDetails.setBalanceamount(credit);
				bankStatementDetails.setTransactionamount(amount);
				if(bankstatementDAO.insertBankStatement(bankStatementDetails)!=0)
				{
					System.out.println("Amount credited succesfully!!!");
					System.out.println("Do u want to know your current balance!!!!..");
					String option=sc.next();
					if(option.equalsIgnoreCase("yes"))
					{
						System.out.println("Your Current Balance is :"+credit);
					}
					
					
				}
				else
				{
					System.out.println("Server issue");
				}

			
			}
			else
			{
				System.out.println("Enter valid amount");
			}
		}
			
		
	 }
	
	public void debit() {
		System.out.println("Enter amount");
		double userenteredamount=sc.nextDouble();
		if(userenteredamount>=0)
		{
			
			double dababaseamount=customerlogin.getAmount();
			
			if(dababaseamount>=userenteredamount)
			{
				
				System.out.println("ok");
				double sub=dababaseamount-userenteredamount;
				customerlogin.setAmount(sub);
				if(bankDAO.amountupdate(sub,customerlogin.getAccountnumber())!=0)
				{
					
					BankStatementDetails bankStatementDetails=new BankStatementDetails();
					bankStatementDetails.setAccountnumber(customerlogin.getAccountnumber());
					bankStatementDetails.setBalanceamount(sub);
					bankStatementDetails.setTransactionamount(userenteredamount);
					if(bankstatementDAO.insertBankStatement(bankStatementDetails)!=0)
					{
						System.out.println("Amount debited succesfully!!!");
						System.out.println("Do u want to know your current balance!!!!..");
						String option=sc.next();
						if(option.equalsIgnoreCase("yes"))
						{
							System.out.println("Your Current Balance is :"+sub);
						}
						
						
					}
				}
				else
				{
					System.out.println("Server issue 500!");
				}
			}
			else
			{
				System.out.println("insufficient balanace");
			}
		}
		else
		{
			System.out.println("invalid amount entered");
		}
	}

	@Override
	public void checkBalance() {
		System.out.println("Enter your account number");
		long enteredaccnumber=sc.nextLong();
		if(customerlogin.getAccountnumber()==enteredaccnumber)
		{
			if(customerlogin.getGender().equalsIgnoreCase("male"))
			{
				System.out.println("Hello Mr"+customerlogin.getFirstname()+"!!!!!!");
				System.out.println("Your Current balance is:"+customerlogin.getAmount());
				
			}
			else
			{
				System.out.println("Hello Ms"+customerlogin.getFirstname()+"!!!!!!");
				System.out.println("Your Current balance is:"+customerlogin.getAmount());
			}
		}
		else
		{
			System.out.println("Enter your account number properly...");
		}
		
		
	}

	@Override
	public void checkStatement() {
		System.out.println("Enter your account number");
		long accountnumber=sc.nextLong();
	List<BankStatementDetails> listbankStatementDetails	=bankstatementDAO.checkStatement(accountnumber);
	   for(BankStatementDetails bankStatementDetails:listbankStatementDetails)
	   {
		   System.out.println("                  "+"Transaction_id: "+bankStatementDetails.getTransactionid());  
		   	System.out.println("                 "+"Account_Number: "+bankStatementDetails.getAccountnumber());
		   	System.out.println("                 "+"Account_Balance: "+bankStatementDetails.getBalanceamount());
		   	System.out.println("                 "+"Transaction_amount: "+bankStatementDetails.getTransactionamount());
		   	System.out.println("                 "+"Date_of_Transaction: "+bankStatementDetails.getDateoftransaction());
		   	System.out.println("                 "+"Time_of_Transaction: "+bankStatementDetails.getTransactiontime());
		   	System.out.println("-----------------------------------------------------------------------------------------------------------");
	   }
		// TODO Auto-generated method stub
		
	}
	
	


//	@Override
//	public void otpgeneration() {
//		// TODO Auto-generated method stub
//		
//	}
//    
    

	
}
