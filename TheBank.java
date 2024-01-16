/**
 * Name: Nrushanth Suthaharan
 * Date: Jan 13, 2022
 * Description: Welcome to my bank, feel free to make and modify accounts
 * or take out loans or make smart savings investments with the highest savings interest of any bank!
*/

import java.time.LocalDate;  // import the LocalDate class
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;
import java.util.ArrayList;

public class TheBank
{
    //create accounts and staff lists
    static PublicAccountsList publicAccountsList = new PublicAccountsList();
    static CorporateAccountsList corporateAccountsList = new CorporateAccountsList();
    static StaffList staffList = new StaffList();
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        int currentMonth = 01;//current month
        
        LocalDate date = LocalDate.now();  // Create a date object
        String output = date.toString();
        System.out.println(output);
        
        String month = output.substring(5,7); // get only month
        String dayString = output.substring(8,10); // get only day

        int day = Integer.parseInt(dayString);

        
        if(!(month.equals(Integer.toString(currentMonth)))){
            incrementAccounts(); //add interest to all accounts and loans
            currentMonth ++;// add to month
            if(currentMonth == 13){ // check if january is reached
                currentMonth = 1;
            }
        }
        //if else statements to adjust next interest period to end of month
        //January - December
        if(currentMonth == 1){
            System.out.println("Number of days until next interest period: " + Integer.toString(31-day));
        }
        else if(currentMonth == 2){
            System.out.println("Number of days until next interest period: " + Integer.toString(28-day));
        }
        else if(currentMonth ==3){
            System.out.println("Number of days until next interest period: " + Integer.toString(31-day));
        }
        else if(currentMonth ==4){
            System.out.println("Number of days until next interest period: " + Integer.toString(30-day));
        }
        else if(currentMonth ==5){
            System.out.println("Number of days until next interest period: " + Integer.toString(31-day));
        }
        else if(currentMonth ==6){
            System.out.println("Number of days until next interest period: " + Integer.toString(30-day));
        }
        else if(currentMonth ==7){
            System.out.println("Number of days until next interest period: " + Integer.toString(31-day));
        }
        else if(currentMonth ==8){
            System.out.println("Number of days until next interest period: " + Integer.toString(31-day));
        }
        else if(currentMonth == 9){
            System.out.println("Number of days until next interest period: " + Integer.toString(30-day));
        }
        else if(currentMonth == 10){
            System.out.println("Number of days until next interest period: " + Integer.toString(31-day));
        }
        else if(currentMonth == 11){
            System.out.println("Number of days until next interest period: " + Integer.toString(30-day));
        }
        else{
            System.out.println("Number of days until next interest period: " + Integer.toString(31-day));
        }
        // Introduction statements
        System.out.println();
        System.out.println("==================================================================");
        System.out.println("==================================================================");
        System.out.println("==================================================================");
        System.out.println();
        System.out.println("Welcome to the IMSS bank (Internation Money Storage & Safekeeping)");
        System.out.println("Unlike most bank, our bank compound interest every month!");
        System.out.println();
        //main menu 1
        System.out.println("Loading files . . .");
        System.out.println("Importing the staff list: ");
        staffList.insert();
        System.out.println("Importing the public accounts list: ");
        publicAccountsList.insert();
        System.out.println("Importing the corporate accounts list: ");
        corporateAccountsList.insert();
        while(true){
            //main menu
            System.out.println("==============================================");
            System.out.println("==============================================");
            System.out.println("==============================================");
            System.out.println("Choose from the menu below: ");
            System.out.println("1 to view your staff menu");
            System.out.println("2 to view your public accounts");
            System.out.println("3 to view your corporate accounts");
            System.out.println("4 to transfer money");
            System.out.println("0 to save & exit");
            
            int number = input.nextInt();    
            input.nextLine();
            //go into staff menu
            if (number == 1){
                System.out.println("This is your stafflist \nWhat would you like to do today?");
                //menu system for user to choose commands
                
                int numRan = 1;
                while(numRan ==1){
                    System.out.println("==============================================");
                    System.out.println("==============================================");
                    System.out.println("==============================================");
                    System.out.println("Choose from the menu below: ");
                    System.out.println("1 to enter a new staff");
                    System.out.println("2 to display all staffs");
                    System.out.println("3 to find a staff");
                    System.out.println("4 to modify a staff");
                    System.out.println("5 to remove a staff");
                    System.out.println("6 to sort your staffs using first name");
                    System.out.println("7 to sort your staffs using last names");
                    System.out.println("8 to export your staff list");
                    System.out.println("9 to import data");
                    System.out.println("10 to sort your staff using first and last name");
                    System.out.println("0 to exit");
                    
                    staffList.sortFirstLastNames(); // sort staff list
                    
        
                    
                    int num = input.nextInt();
                    input.nextLine();
                    if(num == 1){
                        //call addStaff to add a Staff to stafflist
                        staffList.addStaff();
                    }
                    else if(num == 2){
                        // calls displayAllStaffs function to show all the Staffs
                    	staffList.displayAllStaff();
                    }
                    else if(num == 3){
                    	System.out.print("What is the first name: "); // get staff data
                    	String firstName = input.nextLine();
                    	
                    	System.out.print("What is the last name: ");
                    	String lastName = input.nextLine();
                        // calls the search function to find and display a specific Staff
                    	int index = staffList.search(firstName,lastName, 0, staffList.getNumStaff()-1);
                    	if(index ==-1){
                    	    System.out.println("Staff not found!");
                    	    break;
                    	}
                    	staffList.displayOneStaff(index);
                    	
                    }
                    else if(num ==4 ){
                        // calls the modify function to modify a single Staff
                    	staffList.modifyStaff();
                    }
                    else if (num==5){
                        //calls the removeStaff function to remove a single Staff
                    	staffList.removeStaff();
                    }
                    else if(num==6){
                        // calls the sortFirstName function to sort the staff list 
                        //alphabetically using first names
                        staffList.sortFirstName();
                    }
                    else if(num==7){
                        // calls the sortLastName function to sort the staff list
                        //alphabetically using last names
                        staffList.sortLastName();
                    }
                    else if(num==8){
                        //calls the export function to export the stafflist
                        //doesn't work in codeHS, only eclipse
                    	staffList.export();
                    }
                    else if(num==9){
                        //calls the insert function to import Staffs from a csv. file to the staffList
                        staffList.insert();
                    }
                    else if(num == 10) {
                    	//calls the sortFirstLastNames function to sort list by first and last names
                    	staffList.sortFirstLastNames();
                    }
                    else{
                        //exits the loop
                        numRan = 2;
                    }
                }
                continue;
            }
            else if(number == 2){ // public accounts
                System.out.println("This is your list of public accounts \n what would you like to do today: ");
                //menu system for user to choose commands in public accounts
                int numRan =1;
                
                while(numRan ==1){
                    System.out.println("==============================================");
                    System.out.println("==============================================");
                    System.out.println("==============================================");
                    System.out.println("Choose from the menu below: ");
                    System.out.println("1 to enter a new account");
                    System.out.println("2 to display all accounts");
                    System.out.println("3 to find an account");
                    System.out.println("4 to modify an account (deposit/withdraw money)");
                    System.out.println("5 to remove an account");
                    System.out.println("6 to sort your accounts using first name");
                    System.out.println("7 to sort your accounts using last names");
                    System.out.println("8 to export your accounts list");
                    System.out.println("9 to import data");
                    System.out.println("10 to sort your accounts using first and last name");
                    System.out.println("11 to view the loans of an account");
                    System.out.println("0 to exit");
                    
                    publicAccountsList.sortFirstLastNames();
                    
        
                    
                    int num = input.nextInt();
                    input.nextLine();
                    if(num == 1){
                        //call addAccount to add an account to list
                        publicAccountsList.addAccount();
                    }
                    else if(num == 2){
                        // calls displayAllAccounts to display the list
                    	publicAccountsList.displayAllAccounts();
                    }
                    else if(num == 3){
                        //get account data
                    	System.out.println("Enter account number: ");
                    	int account = input.nextInt();
                    	input.nextLine();
                    	System.out.print("What is the first name: ");
                    	String firstName = input.nextLine();
                    	
                    	System.out.print("What is the last name: ");
                    	String lastName = input.nextLine();
                    	
                        // calls the search function to find and display a specific account
                    	int index = publicAccountsList.search(account,firstName,lastName, 0, publicAccountsList.getNumAccounts()-1);
                    	if(index == -1){
                            System.out.println("Account not found!");
                            break;
                        }
                    	publicAccountsList.displayOneAccount(index);
                        System.out.println("Savings balance: "+publicAccountsList.getAccount(index).savings.getBalance());
                        System.out.println("Chequings balance: " + publicAccountsList.getAccount(index).chequings.getBalance());
                    	
                    }
                    else if(num ==4 ){
                        // calls the modify function to modify a single account
                    	publicAccountsList.modifyAccount();
                    }
                    else if (num==5){
                        //calls the removeAccount function to remove a single ccount
                    	publicAccountsList.removeAccount();
                    }
                    else if(num==6){
                        // calls the sortFirstName function to sort the publicAccountsList 
                        //alphabetically using first names
                        publicAccountsList.sortFirstName();
                    }
                    else if(num==7){
                        // calls the sortLastName function to sort the publicAccountsList 
                        //alphabetically using last names
                        publicAccountsList.sortLastName();
                    }
                    else if(num==8){
                        //calls the export function to export the publicAccountsList
                        //doesn't work in codeHS, only eclipse
                    	publicAccountsList.export();
                    }
                    else if(num==9){
                        //calls the insert function to import Staffs from a csv. file to the publicAccountsList
                        publicAccountsList.insert();
                    }
                    else if(num == 10) {
                    	//calls the sortFirstLastNames function to sort list by first and last names
                    	publicAccountsList.sortFirstLastNames();
                    }
                    else if(num ==11){ // accessing the loans
                        //get account details
                        System.out.println("Enter account number: ");
                        int account = input.nextInt();
                        input.nextLine();
                        System.out.println("Enter first name: ");
                        String firstName = input.nextLine();
                        System.out.println("Enter last name: ");
                        String lastName = input.nextLine();
                        //calls search to find account
                        int index = publicAccountsList.search(account,firstName, lastName,0, publicAccountsList.getNumAccounts()-1);
                        if(index == -1){ // check if account exists
                            System.out.println("Account not found!");
                            break;
                        }
                        PublicAccount currentAccount = publicAccountsList.getAccount(index); // make temporary account
                        System.out.println("==============================================");
                        System.out.println("==============================================");
                        System.out.println("==============================================");
                        System.out.println("Choose from the menu below: ");
                        System.out.println("1 to enter a new loan");
                        System.out.println("2 to display all loans");
                        System.out.println("3 to find a loan (or to deposit)");
                        System.out.println("4 to modify a loan");
                        System.out.println("5 to remove a loan");
                        int command = input.nextInt();
                        input.nextLine();
                        if(command ==1){ // add a loan
                            currentAccount.loans.addLoan();
                            publicAccountsList.setAccount(index, currentAccount);
                        }
                        else if(command ==2){ // show all loans on account
                            currentAccount.loans.displayAllLoans();
                        }
                        else if(command ==3){
                            
                            int indexLoan = currentAccount.loans.search();
                            if(indexLoan == -1){
                                System.out.println("Loan not found!");
                                break;
                            }
                            currentAccount.loans.displayOneLoan(indexLoan);
                            System.out.println("Enter amount:"); // get amount
                            double amount = input.nextDouble();
                            input.nextLine();
                            currentAccount.loans.getLoan(indexLoan).makePayment(amount); // make payment
                            publicAccountsList.setAccount(index, currentAccount);

                        }
                        else if(command ==4){ // call modifyLoan() to edit the loan
                            currentAccount.loans.modifyLoan();
                            publicAccountsList.setAccount(index, currentAccount);
                        }
                        else{ // remove loan
                            int indexLoan = currentAccount.loans.search();
                            if(indexLoan == -1){
                                System.out.println("Loan not found!");
                                break;
                            }
                            currentAccount.loans.removeLoan(indexLoan); // remove the loan
                        }
                        
                    }
                    else{
                        //exits the loop
                        numRan = 2;
                    }
                }
                continue;
            }
            //the codes for corporate accounts are exactly the same as those for public accounts
            //there are only slight changes in the backend
            else if(number ==3){
                System.out.println("This is your list of corporate accounts \n what would you like to do today: ");
                //menu system for user to choose commands
                
                int numRan = 1;
                while(numRan ==1){
                    System.out.println("==============================================");
                    System.out.println("==============================================");
                    System.out.println("==============================================");
                    System.out.println("Choose from the menu below: ");
                    System.out.println("1 to enter a new account");
                    System.out.println("2 to display all accounts");
                    System.out.println("3 to find an account");
                    System.out.println("4 to modify an account (deposit/withdraw money)");
                    System.out.println("5 to remove an account");
                    System.out.println("6 to sort your accounts using first name");
                    System.out.println("7 to sort your accounts using last names");
                    System.out.println("8 to export your accounts list");
                    System.out.println("9 to import data");
                    System.out.println("10 to sort your accounts using first and last name");
                    System.out.println("11 to view the loans of an account");
                    System.out.println("0 to exit");
                    
                    corporateAccountsList.sortFirstLastNames();
                    
        
                    
                    int num = input.nextInt();
                    input.nextLine();
                    if(num == 1){
                        //call addStaff to add a Staff to phonebook
                        corporateAccountsList.addAccount();
                    }
                    else if(num == 2){
                        // calls displayAllStaffs function to show all the Staffs in the phonebook
                    	corporateAccountsList.displayAllAccounts();
                    }
                    else if(num == 3){
                    	//consume the "enter" from previous answer to not skip this question
                    	System.out.println("Enter account number: ");
                    	int account = input.nextInt();
                    	input.nextLine();
                    	System.out.print("What is the first name: ");
                    	String firstName = input.nextLine();
                    	
                    	System.out.print("What is the last name: ");
                    	String lastName = input.nextLine();

                        // calls the search function to find and display a specific Staff
                    	int index = corporateAccountsList.search(account,firstName,lastName, 0, corporateAccountsList.getNumAccounts()-1);
                    	if(index == -1){
                            System.out.println("Account not found!");
                            break;
                        }
                    	corporateAccountsList.displayOneAccount(index);
                    	System.out.println("Balance: " + corporateAccountsList.getAccount(index).getBalance());
                    	
                    }
                    else if(num ==4 ){
                        // calls the modify function to modify a single Staff
                    	corporateAccountsList.modifyAccount();
                    }
                    else if (num==5){
                        //calls the removeStaff function to remove a single Staff
                    	corporateAccountsList.removeAccount();
                    }
                    else if(num==6){
                        // calls the sortFirstName function to sort the phone diary 
                        //alphabetically using first names
                        corporateAccountsList.sortFirstName();
                    }
                    else if(num==7){
                        // calls the sortLastName function to sort the phone diary 
                        //alphabetically using last names
                        corporateAccountsList.sortLastName();
                    }
                    else if(num==8){
                        //calls the export function to export the phone diary
                        //doesn't work in codeHS, only eclipse
                    	corporateAccountsList.export();
                    }
                    else if(num==9){
                        //calls the insert function to import Staffs from a csv. file to the staffList
                        corporateAccountsList.insert();
                    }
                    else if(num == 10) {
                    	//calls the sortFirstLastNames function to sort list by first and last names
                    	corporateAccountsList.sortFirstLastNames();
                    }
                    else if(num ==11){ // view the loans
                        System.out.println("Enter account number: "); // get account details
                        int account = input.nextInt();
                        input.nextLine();
                        System.out.println("Enter first name: ");
                        String firstName = input.nextLine();
                        System.out.println("Enter last name: ");
                        String lastName = input.nextLine();
                        int index = corporateAccountsList.search(account,firstName, lastName,0, corporateAccountsList.getNumAccounts()-1);
                        CorporateAccount currentAccount = corporateAccountsList.getAccount(index); // access the account
                        System.out.println("==============================================");
                        System.out.println("==============================================");
                        System.out.println("==============================================");
                        System.out.println("Choose from the menu below: "); // menu for loans
                        System.out.println("1 to enter a new loan");
                        System.out.println("2 to display all loans");
                        System.out.println("3 to find a loan (or to deposit)");
                        System.out.println("4 to modify a loan");
                        System.out.println("5 to remove a loan");
                        int command = input.nextInt();
                        input.nextLine();
                        if(command ==1){
                            currentAccount.loans.addLoan(); // calls addLoan() to add a new loan
                            corporateAccountsList.setAccount(index, currentAccount);
                        }
                        else if(command ==2){
                            currentAccount.loans.displayAllLoans(); // calls displayAllLoans() to show loans
                        }
                        else if(command ==3){
                            
                            int indexLoan = currentAccount.loans.search(); // search for loan
                            if(indexLoan == -1){
                                System.out.println("Loan not found!"); // loan not found message
                                break;
                            }
                            currentAccount.loans.displayOneLoan(indexLoan); // display single loan details
                            System.out.println("Enter amount:"); // get amount
                            double amount = input.nextDouble();
                            input.nextLine();
                            Loan currentLoan = currentAccount.loans.getLoan(indexLoan); // access loan
                            currentLoan.makePayment(amount); //make payment of amount to loan
                            currentAccount.loans.setLoan(indexLoan, currentLoan);
                            corporateAccountsList.setAccount(index, currentAccount);
                        }
                        else if(command ==4){
                            currentAccount.loans.modifyLoan(); // modify the loan details
                            corporateAccountsList.setAccount(index, currentAccount);
                        }
                        else{
                            int indexLoan = currentAccount.loans.search(); // find loan
                            if(indexLoan == -1){
                                System.out.println("Loan not found!");
                                break;
                            }
                            currentAccount.loans.removeLoan(indexLoan); // remove the loan
                        }
                    }
                    else{
                        //exits the loop
                        numRan =2;
                    }
                }
                continue;
            }
            else if(number ==4){ // calls moneyTransfer function
                moneyTransfer();
                continue;
            }
            else{
                // export all lists
                System.out.println("Make sure file names are the same as the imported filenames (Use eclipse)");
                System.out.println("Saving staff list: ");
                staffList.export();
                System.out.println("Saving public accounts list: ");
                publicAccountsList.export();
                System.out.println("Saving corporate accounts list: ");
                corporateAccountsList.export();
                break;
            }
        }
        
    }
    //function to increment all loans and accounts
    public static void incrementAccounts(){
        //all public accounts
        for(int i =0;i< publicAccountsList.getNumAccounts();i++){
            //increment savings
            publicAccountsList.getAccount(i).savings.incrementSavings();

            //increment all loans in public account
            for(int j = 0; j < publicAccountsList.getAccount(i).loans.getNumLoans();j++){
                Loan current = publicAccountsList.getAccount(i).loans.getLoan(j);
                current.incrementLoan();
            }
        }
        //all corporate accounts
        for(int x = 0; x< corporateAccountsList.getNumAccounts();x++){
            //increment balance
            corporateAccountsList.getAccount(x).incrementBalance();
            //increment all loans in corporate account
            for(int y = 0; y< corporateAccountsList.getAccount(x).loans.getNumLoans();y++){
                corporateAccountsList.getAccount(x).loans.getLoan(y).incrementLoan();
            }
        }
    }
    //function to transfer money between two accounts
    public static int moneyTransfer(){
        Scanner input = new Scanner(System.in);
        //get donor account details
        System.out.println("Enter your account number: ");
        int accountDonor = input.nextInt();
        input.nextLine();
        System.out.println("Enter your first name: ");
        String donorFirstName = input.nextLine();
        System.out.println("Enter your last name: ");
        String donorLastName = input.nextLine();
        System.out.println("Enter your account type ('p' for public/'c' for corporate): ");
        String donorType = input.nextLine();
        //get recieving account details
        System.out.println("Enter recieving account number: ");
        int accountReciever = input.nextInt();
        input.nextLine();
        System.out.println("Enter first name of account owner: ");
        String recieverFirstName = input.nextLine();
        System.out.println("Enter the last name of account owner: ");
        String recieverLastName = input.nextLine();
        System.out.println("Enter the recieving account type ('p' for public/'c' for corporate): ");
        String recieverType = input.nextLine();
        System.out.println("Enter amount: ");
        double amount = input.nextDouble();
        input.nextLine();
        //notify user of transaction feee
        System.out.println("There will be a transaction fee of: " + amount/25.0+ "$");
        double fee = amount/25.0;
        System.out.println("Would you like to finalize the transaction (y for yes)?"); // confirm
        String command = input.nextLine();
        if(command.equals("y")){
            if(donorType.equals("p") && recieverType.equals("p")){ // public account to public account
                //get donor index in public list
                int donorIndex = publicAccountsList.search(accountDonor,donorFirstName,donorLastName,0,publicAccountsList.getNumAccounts()-1);
                if(donorIndex == -1){
                    System.out.print("Donor account not found!");
                    return 0;
                }
                //get reciever index in public list
                int recieverIndex = publicAccountsList.search(accountReciever,donorFirstName,donorLastName,0,publicAccountsList.getNumAccounts()-1);
                if(recieverIndex == -1){
                    System.out.print("Reciever account not found!");
                    return 0;
                }
                publicAccountsList.getAccount(donorIndex).withdraw(amount+fee, "savings");//withdraw from donor
                publicAccountsList.getAccount(recieverIndex).deposit(amount,"savings"); // deposit into reciever account
                //code is similar for all other scenarios
            }
            else if(donorType.equals("p")){ // public account to corporate account
                int donorIndex = publicAccountsList.search(accountDonor,donorFirstName,donorLastName,0,publicAccountsList.getNumAccounts()-1);
                if(donorIndex == -1){
                    System.out.print("Donor account not found!");
                    return 0;
                }
                int recieverIndex = corporateAccountsList.search(accountReciever,donorFirstName,donorLastName,0,corporateAccountsList.getNumAccounts()-1);
                if(recieverIndex == -1){
                    System.out.print("Reciever account not found!");
                    return 0;
                }
                publicAccountsList.getAccount(donorIndex).withdraw(amount+fee, "savings");
                corporateAccountsList.getAccount(recieverIndex).deposit(amount);
                
            }
            else if(recieverType.equals("p")){ // corporate account to public account
                int donorIndex = corporateAccountsList.search(accountDonor, donorFirstName, donorLastName, 0, corporateAccountsList.getNumAccounts()-1);
                if(donorIndex == -1){
                    System.out.print("Donor account not found!");
                    return 0;
                }
                int recieverIndex = publicAccountsList.search(accountReciever, donorFirstName, donorLastName,0,publicAccountsList.getNumAccounts()-1);
                if(recieverIndex == -1){
                    System.out.print("Reciever account not found!");
                    return 0;
                }
                corporateAccountsList.getAccount(donorIndex).withdraw(amount+fee);
                publicAccountsList.getAccount(recieverIndex).deposit(amount,"checkings");
            }
            else{ // corporate account to corporate account
                int donorIndex = corporateAccountsList.search(accountDonor, donorFirstName, donorLastName, 0, corporateAccountsList.getNumAccounts()-1);
                if(donorIndex == -1){
                    System.out.print("Donor account not found!");
                    return 0;
                }
                int recieverIndex = corporateAccountsList.search(accountReciever,donorFirstName,donorLastName,0,corporateAccountsList.getNumAccounts()-1);
                if(recieverIndex == -1){
                    System.out.print("Reciever account not found!");
                    return 0;
                }
                corporateAccountsList.getAccount(donorIndex).withdraw(amount+fee);
                corporateAccountsList.getAccount(recieverIndex).deposit(amount);
                
            }
            System.out.println("Transaction complete");
            return 1;//confirmation of transaction completion
        }
        return 2; // transaction cancelled
    }

    
}