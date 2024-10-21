package com.bank;

import java.util.Scanner;
import com.bank.service.BankService;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankService bankService = CustomerServiceAssociate.customerService();

        bankService.toSleep("🙏🙏---Welcome to Union Bank of India---🙏🙏");

        while (true) {
            bankService.toSleep("Enter \n1. for Registration \n2. for LogIn");
            int userInput = sc.nextInt();

            switch (userInput) {
                case 1:
                    bankService.toSleep("---**--Registration--**---");
                    bankService.userRegistration();
                    break;
                case 2:
                    bankService.toSleep("---**--User login--**---");
                    bankService.userlogin();
                    break;
                default:
                    bankService.toSleep("Invalid Selection");
            }

            // Ask if the user wants to continue only once after the action
            System.out.println("Do you want to continue? (yes/no)");
            String choice = sc.next();
            if (!"yes".equalsIgnoreCase(choice)) {
                break;  // Exit the loop if the user does not choose "yes"
            }
        }

        bankService.toSleep("Thank you, visit again!");
        sc.close();  // Close the Scanner resource
    }
}
