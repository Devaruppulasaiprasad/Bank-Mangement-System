package com.bank.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.bank.model.BankCustomerDetails;
import com.bank.service.BankService;
import com.bank.service.BankServiceImpl;

public class BankDAOImpl implements BankDAO{
	private Connection connection;
	private static final  String url="jdbc:mysql://localhost:3306/techa62projects?user=root&password=root";
	private static final String insert="insert into bankcustomerdetails(Firstname, Lastname, Email_Id, Password, Mobile_Number, Adhar_Number, Gender, Adress,Account_Number, Amount,Date_Of_Birth)values (?,?,?,?,?,?,?,?,?,?,?)";
	private static final String select="select * from bankcustomerdetails";

	@Override
	public List<BankCustomerDetails> getAllBankCustomerDetails() {
		// TODO Auto-generated method stub
		
		try {
			 connection=DriverManager.getConnection(url);
			PreparedStatement preparedstatement=connection.prepareStatement(select);
			ResultSet set=preparedstatement.executeQuery();
			List<BankCustomerDetails>listBankCustomerDetails=new ArrayList<BankCustomerDetails>();
			if(set.isBeforeFirst())
			{
				while(set.next())
				{
					BankCustomerDetails bankCustomerDetails=new BankCustomerDetails();
					bankCustomerDetails.setAdharnumber(set.getLong("Adhar_Number"));
					bankCustomerDetails.setEmailid(set.getString("Email_Id"));
					bankCustomerDetails.setPassword(set.getString("Password"));
					bankCustomerDetails.setMobilenumber(set.getLong("Mobile_Number"));
					listBankCustomerDetails.add(bankCustomerDetails);
					
					
				}
				return listBankCustomerDetails;
			}
			else
			{
				return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public int inserBankCustomerDetails(BankCustomerDetails bankCustomerDetails) {
		BankService bankService=new BankServiceImpl();
		

		try {
			connection=DriverManager.getConnection(url);
			PreparedStatement preparedStatement=connection.prepareStatement(insert);
			preparedStatement.setString(1, bankCustomerDetails.getFirstname());
	        preparedStatement.setString(2, bankCustomerDetails.getLastname());
	        preparedStatement.setString(3, bankCustomerDetails.getEmailid());
	        preparedStatement.setString(4, bankCustomerDetails.getPassword());
	        preparedStatement.setLong(5, bankCustomerDetails.getMobilenumber());
	        preparedStatement.setLong(6, bankCustomerDetails.getAdharnumber());
	        preparedStatement.setString(7, bankCustomerDetails.getGender());
	        preparedStatement.setString(8, bankCustomerDetails.getAdress());
	       
	        preparedStatement.setLong(9, bankCustomerDetails.getAccountnumber());
	        preparedStatement.setDouble(10, bankCustomerDetails.getAmount());
	        LocalDate localDate=bankCustomerDetails.getDateofbirth();
	        preparedStatement.setDate(11,Date.valueOf(localDate));
	        
	        
	        return preparedStatement.executeUpdate();
//			System.out.println(preparedStatement.executeUpdate()); 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
		
		// TODO Auto-generated method stub
		
	}

	@Override
	public BankCustomerDetails userSigning(String emailorpassword,String password) {
		String login="select * from bankcustomerdetails where (Email_Id=? OR Mobile_Number=? )AND Password=?";
		try {
			connection=DriverManager.getConnection(url);
			PreparedStatement preparedStatement=connection.prepareStatement(login);
			preparedStatement.setString(1, emailorpassword);
			preparedStatement.setString(2,emailorpassword);
			preparedStatement.setString(3, password);
			ResultSet set=preparedStatement.executeQuery();
			if(set.next())
			{
				BankCustomerDetails bankCustomerDetails=new BankCustomerDetails();
		         bankCustomerDetails.setGender(set.getString("Gender"));
		         bankCustomerDetails.setFirstname(set.getString("Firstname"));
		         bankCustomerDetails.setLastname(set.getString("Lastname"));
		         bankCustomerDetails.setAmount(set.getDouble("Amount"));
		         bankCustomerDetails.setAccountnumber(set.getLong("Account_Number"));
		         
				return bankCustomerDetails;
			}
			else
			{
				return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		// TODO Auto-generated method stub
		
	}

	@Override
	public int amountupdate(double amount, long accountnumber) {
		String update="update bankcustomerdetails set Amount=? where Account_Number=?";
		try {
			connection=DriverManager.getConnection(url);
			PreparedStatement preparedStatement=connection.prepareStatement(update);
			preparedStatement.setDouble(1,amount);
			preparedStatement.setLong(2, accountnumber);
			return preparedStatement.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		// TODO Auto-generated method stub
		
	}

	
	

	
		
	
	
	
	
	

}
