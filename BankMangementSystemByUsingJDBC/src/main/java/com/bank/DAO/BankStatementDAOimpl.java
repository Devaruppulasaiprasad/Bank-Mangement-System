package com.bank.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.bank.model.BankStatementDetails;

public class BankStatementDAOimpl implements BankStatementDAO{
	
		private static final String url="jdbc:mysql://localhost:3306/techa62projects?user=root&password=root";

		@Override
		public int insertBankStatement(BankStatementDetails bankStatementDetails) {
			// TODO Auto-generated method stub
			String insert="insert into bank_statement (Date_of_Transaction, Transaction_Amount, Time_Of_Transaction, Balance_Amount, Account_Number) values(?,?,?,?,?)";
			try {
				Connection connection=DriverManager.getConnection(url);
				PreparedStatement preparedStatement=connection.prepareStatement(insert);
				preparedStatement.setDate(1,Date.valueOf(LocalDate.now()));
				preparedStatement.setDouble(2, bankStatementDetails.getTransactionamount());
				preparedStatement.setTime(3, Time.valueOf(LocalTime.now()));
				preparedStatement.setDouble(4, bankStatementDetails.getBalanceamount());
				preparedStatement.setLong(5,bankStatementDetails.getAccountnumber());
				 return preparedStatement.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return 0;
			}
			
			
			
		}

		@Override
		public List<BankStatementDetails> checkStatement(long accountnumber) {
		    String select = "SELECT * FROM bank_statement WHERE Account_Number = ?";
		    List<BankStatementDetails> bankStatementDetailsList = new ArrayList<>();

		    try (Connection connection = DriverManager.getConnection(url);
		         PreparedStatement preparedStatement = connection.prepareStatement(select)) {
		        
		        preparedStatement.setLong(1, accountnumber);
		        try (ResultSet resultSet = preparedStatement.executeQuery()) {
		            while (resultSet.next()) {
		                BankStatementDetails bankStatementDetails = new BankStatementDetails();
		                bankStatementDetails.setAccountnumber(resultSet.getLong("Account_Number"));
		                bankStatementDetails.setBalanceamount(resultSet.getDouble("Balance_Amount"));
		                bankStatementDetails.setDateoftransaction(resultSet.getDate("Date_of_Transaction").toLocalDate());
		                bankStatementDetails.setTransactiontime(resultSet.getTime("Time_Of_Transaction").toLocalTime());
		                bankStatementDetails.setTransactionid(resultSet.getInt("Transaction_id"));
		                bankStatementDetails.setTransactionamount(resultSet.getDouble("Transaction_Amount"));

		                bankStatementDetailsList.add(bankStatementDetails);
		            }
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }

		    return bankStatementDetailsList;
		}

			// TODO Auto-generated method stub
			
		}
		

	



