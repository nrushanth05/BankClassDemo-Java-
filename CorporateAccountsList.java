/**
 * Name: Nrushanth Suthaharan
 * Date: Jan 10, 2023
 * Description: CorporateAccounts object with all methods and display functions
 * related to the corporateAccount object
*/
// import statements
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;
import java.util.ArrayList;

public class CorporateAccountsList {
    ArrayList<CorporateAccount> list = new ArrayList<CorporateAccount>(); // create list of corporateAccounts
    ArrayList<Integer> accountNumbers = new ArrayList<Integer>(); // create a list of account numbers
    
    private int numAccounts = 0; // keep track of number of accounts
    //constructor method
    public CorporateAccountsList(){
        accountNumbers.add( 1000000);
    }
    //get number of accounts
    public int getNumAccounts() {
    	return numAccounts;
    }
    // function to get a unique account number
    public int newAccountNum(){
        int currentNum = 1000000;
        while(accountNumbers.contains(currentNum)){ // check if number is already made
            currentNum++;
        }
        return currentNum; // get new number
        
    }
    // return a specific accouny
    public CorporateAccount getAccount(int index){
        
        return list.get(index);
    }
    // function to set an account
    public void setAccount(int index, CorporateAccount account){
        list.set(index, account);
    }
    //function to add account 
    public void addAccount(){
        //get user input
        //user can input or leave certain parameters blank without affecting the program
        //first name and last name are a must however
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a First Name: ");
        String firstName = input.nextLine();
        System.out.println("Enter a Last Name: ");
        String lastName = input.nextLine();
        System.out.println("Enter a company name: ");
        String companyName = input.nextLine();
        int accountNumber = newAccountNum(); // make new accountNumber
        System.out.println("Account number will be: " + Integer.toString(accountNumber));
        accountNumbers.add(accountNumber); // state the accountNum
        System.out.println("Enter the account password: ");
        String password = input.nextLine();
        System.out.println("Enter their number: ");
        String number = input.nextLine();
        System.out.println("Enter an email: ");
        String email = input.nextLine();
        System.out.println("Enter head quarter address: ");
        String location = input.nextLine();
        input.nextLine();
        //create a new CorporateAccount object with new account details
        CorporateAccount account = new CorporateAccount(accountNumber,password,companyName,firstName, lastName, number, email, location);
        //add account to the array list
        list.add(account);
        numAccounts++;
    }
    //function to display all the accounts in the corporate accounts list
    public void displayAllAccounts(){
        //use 'printf' to equally space out the displays to make the output more clean
        System.out.printf("%-15s%-15s%-15s%-20s%-15s%-15s%-15s\n","Account number","Company name","First Name","Last Name","Phone #","Email","Address");
        System.out.println();   
        //loops through entire list
        for(int i =0; i < list.size(); i ++){
            //outputs only the accounts with details
            if(list.get(i).getFirstName()!=null){
                System.out.printf("%-15s%-15s%-15s%-20s%-15s%-15s%-15s\n",list.get(i).getAccountNum(),list.get(i).getCompanyName(),list.get(i).getFirstName(),list.get(i).getLastName(),list.get(i).getNumber(),list.get(i).getEmail(),list.get(i).getLocation());
                
                
            }
        }
        //empty lines to create spaces in the output
        System.out.println();
        System.out.println();
        System.out.println();
        
    }
    //function to display a single account in the list using an index parameter
    //better option is to use toString of CorporateAccount class
    public void displayOneAccount(int index){
        System.out.print(list.get(index).toString());
    }
    //function to sort accounts using first and last names
    public void sortFirstLastNames(){
    	Scanner input = new Scanner(System.in);
        //Selection sort
        for (int i = 1; i < list.size(); i++) {
            CorporateAccount temp = list.get(i);
            String firstLastName = list.get(i).getFirstName()+list.get(i).getLastName();
            int j = i;
            while (j > 0 && (list.get(j-1).getFirstName()+list.get(j-1).getLastName()).compareToIgnoreCase(firstLastName)<0) {
                list.set(j,list.get(j-1));
                
                j--;
            }
            list.set(j, temp);
            
        }
        
    }
    // function to modify the details of a single account
    public void modifyAccount(){
        Scanner input = new Scanner(System.in);
        //lines to seperate and organise terminal screen
        System.out.println("=======================================");
        System.out.println("=======================================");
        System.out.println("=======================================");
        //get account info
        System.out.print("Enter the first name: ");
        String firstName = input.nextLine();
        System.out.print("Enter the last name: ");
        String lastName = input.nextLine();
        System.out.print("Enter the account number: ");
        int accountNum = input.nextInt();
        input.nextLine();
        //loops through list
        for(int i = 0; i < list.size(); i++){
            //checks for the user by matching first name and last name
            if(list.get(i).getFirstName().equals(firstName) && list.get(i).getLastName().equals(lastName)|| list.get(i).getAccountNum() == accountNum){
                //calls the toString to display the current account
                System.out.println(list.get(i).toString());
                System.out.println("Balance: " + list.get(i).getBalance());
                while(true){
                	//menu system to select changes
                    System.out.println("=======================================");
                    System.out.println("=======================================");
                    System.out.println("Enter the number of what you want to change from the menu below: ");
                    System.out.println("0 Everything is fine");
                    System.out.println("1 to change the company name");
                    System.out.println("2 to change first name");
                    System.out.println("3 to change last name");
                    System.out.println("4 to change the password");
                    System.out.println("5 to change phone number");
                    System.out.println("6 to change email");
                    System.out.println("7 to change head quarter address");
                    System.out.println("8 to deposit money");
                    System.out.println("9 to withdraw money");

                    int num = input.nextInt();
                    //empty input statement to consume the \n from previous answer
                    input.nextLine();
                    if(num ==1){ // change company name
                        System.out.print("Enter a new company name: ");
                        String companyName = input.nextLine();
                        list.get(i).setCompanyName(companyName);
                    }
                    else if(num == 2){ // change first name
                        System.out.print("Enter a first name: ");
                        firstName = input.nextLine();
                        //change first name
                        list.get(i).setFirstName(firstName);
                    }
                    //change last name
                    else if(num == 3){
                        System.out.print("Enter a last name: ");
                        lastName = input.nextLine();
                        list.get(i).setLastName(lastName);
                    }
                    //change the password
                    else if(num ==4){
                        System.out.print("Enter a new password: ");
                        String password = input.nextLine();
                        list.get(i).setPassword(password);
                    }
                    //change the phone number
                    else if(num == 5){
                        System.out.print("Enter a phone number: ");
                        String number = input.nextLine();
                        list.get(i).setNumber(number);
                        
                    }
                    //change the email
                    else if(num == 6){
                        System.out.print("Enter a email: ");
                        String email = input.nextLine();
                        list.get(i).setEmail(email);
                    }
                    //change the head quarters address
                    else if(num == 7){
                        System.out.print("Enter a new address: ");
                        String address = input.nextLine();
                        list.get(i).setLocation(address);
                    }
                    else if(num ==8){ // deposit money
                        System.out.print("Enter amount: ");
                        double amount = input.nextDouble();
                        input.nextLine();
                        list.get(i).deposit(amount);
                    }
                    else if(num ==9){ // withdraw money
                        System.out.print("Enter amount: ");
                        double amount = input.nextDouble();
                        input.nextLine();
                        list.get(i).withdraw(amount);
                    }
                    //exits the loop
                    else if(num == 0){
                        break;
                    }
                }
                
                
            }
            //prints error message
            else if(i==list.size()-1){
                System.out.print("Account not found!");
            }
            
        }
        
        
        
    }
    //function to remove a single account
    public void removeAccount(){
        Scanner input = new Scanner(System.in);
        System.out.println("=======================================");
        System.out.println("=======================================");
        System.out.println("=======================================");
        //get first name and last name from user
        System.out.print("Enter the first name: ");
        String firstName = input.nextLine();
        System.out.print("Enter the last name: ");
        String lastName = input.nextLine();
        System.out.print("Enter the account number: ");
        int accountNum = input.nextInt();
        input.nextLine();
        
        for(int i= 0; i < list.size(); i++){
            //checks for the user
            if(list.get(i).getFirstName().equals(firstName) && list.get(i).getLastName().equals(lastName) || list.get(i).getAccountNum() == accountNum){
                //displays the account information
          
                System.out.println("=======================================");
                System.out.println("=======================================");
                System.out.print(list.get(i).toString());
                //double checks confirmation to delete
                System.out.println("Are you sure you want to remove this account ('y' for yes)");
                String command = input.nextLine();
                if(command.equals("y")) {
	                //removes this index from the corporate accounts list
	                list.remove(i);
	                numAccounts--;
                }
            }
            //error message
            else if(i==list.size()-1){
                System.out.println("Account not found!");
            }
        }
    }
    //function to find the index of a single account
    public int search(int accountNumber,String firstName, String lastName, int start, int end){
        //binary search
        //sort
        sortFirstLastNames();
        if(start>end) {
        	return -1;
        }
        else {
        	int mid = (start+end)/2;
        	String fullName = firstName +lastName;
        	// if account is at mid index
        	if(list.get(mid).getFirstName().equals(firstName) && list.get(mid).getLastName().equals(lastName) && list.get(mid).getAccountNum()==accountNumber) {
        		return mid;
        	}
        	//if account is on the right
        	else if(fullName.compareToIgnoreCase(list.get(mid).getFirstName()+list.get(mid).getLastName())<0 && list.get(mid).getAccountNum()!=accountNumber) {
        		return search(accountNumber,firstName,lastName,mid+1,end);
        	}
        	//if account is on the left
        	else {
        		return search(accountNumber,firstName,lastName,start,mid-1);
        	}
        }
        
    }
    //function to sort list by first names
    public void sortFirstName(){
        //improved bubble sort
        Scanner input = new Scanner(System.in);
        boolean swap = true;
        int j =1;
        while(swap){
           swap =false;
           for(int i =0; i< list.size()-j;i++){
               //checks if a first name is alphabetically smaller than the next
               if(list.get(i).getFirstName().compareToIgnoreCase(list.get(i+1).getFirstName())<0){
                   //store list.get(i) in a new CorporateAccount object
                   CorporateAccount temp = list.get(i);
                   //swap the two account objects
                   list.set(i,list.get(i+1));
                   list.set(i+1, temp);
                   swap = true;
                   
               }
           }
           j++;
        }
        //display the accounts using displayAllaccounts function
        displayAllAccounts();
        //ask user if they want to reverse the list
        System.out.println("Would you like to alphabetically reverse the list? ('y' for yes)");
        String command = input.nextLine();
        //reverses the list
        if(command.equals("y")){
            //calls the reverseList function to reverse the list
            list = reverseList();

        }
    }
    //function to reverse the order of the corporate accounts list
    public ArrayList<CorporateAccount> reverseList(){
        //create a new arrayList of CorporateAccount objects
        ArrayList<CorporateAccount> newList = new ArrayList<CorporateAccount>();
        //loop through list in reverse
        for(int i = list.size()-1;i>=0;i--){
            //add each item to the new array list
            newList.add(list.get(i));
        }
        //return the new list
        return newList;
    }
    
    //function to sort corporate accounts list by last names
    public void sortLastName(){
        //selection sort
        Scanner input = new Scanner(System.in);
        for(int i =0; i < list.size();i++){
            int minIndex =i;
            for(int j = i+1; j< list.size();j++){
                //finds the smallest index
                if(list.get(j).getLastName().compareToIgnoreCase(list.get(minIndex).getLastName())<0){
                    minIndex =j;
                }
            }
            //make new CorporateAccount object as a temp storage
            CorporateAccount temp = list.get(i);
            //swap the smallest account with the next account in order
            list.set(i,list.get(minIndex));
            list.set(minIndex,temp);
        }
        //call displayAllaccounts function to display the accounts
        displayAllAccounts();
        //asks user if they want to reverse the list
        System.out.println("Would you like to alphabetically reverse the list? ('y' for yes)");
        String command = input.nextLine();
        //reverses the list
        if(command.equals("y")){
            //calls the reverseList function to reverse the list
            list = reverseList();

        }
        
    }
    //function to import account details from a csv. file to list
    //this does work in codeHS but file must be added to left column
    public void insert(){
        //create a new array list of CorporateAccount objects
        ArrayList<CorporateAccount> newList = new ArrayList<CorporateAccount>();
        Scanner input = new Scanner(System.in);
        //ask if you would like to overwrite or add to current list
        System.out.print("Would you like to overwrite you current corporate accounts list or add to it ('y' to overwrite and 'n' to add)? ");
        String command = input.nextLine();
        //get name of file
        System.out.print("What is the name of the file: ");
        String fileName = input.nextLine();
        //outputs the format of the csv. file
        System.out.println("The file format should be:");
        System.out.println("Account Number, password, Company Name,First name, Last name, Phone #, Email, Address");
        //try and catch block to avoid File/other .io errors
        try{
            // create a scanner with the designated file
            //wil throw error if file is not found
            Scanner in = new Scanner(new File(fileName));
            
            //if overwriting
            if(command.equals("y")){
            	numAccounts =0;
                //loop while there is information stored in the next line of the csv file
                while(in.hasNext()){
                    //isolate the current line from the csv. file
                    String line = in.nextLine();
                    //create a scanner of that line
                    Scanner items = new Scanner(line);
                    //seperate the items from the line using the ',' indicator
                    items.useDelimiter(",");
                    //get accounts details
                    int accountNum = items.nextInt();
                    String password = items.next();
                    String companyName = items.next();
                    String firstName = items.next();
                    String lastName = items.next();
                    String number = items.next();
                    String email = items.next();
                    String address = items.next();
                    //make new Staff object with account details
                    CorporateAccount temp = new CorporateAccount(accountNum,password,companyName,firstName,lastName, number, email, address);
                    //add the Staff obect to newList
                    newList.add(temp);
                    //close items scanner
                    items.close();
                    numAccounts++;
                    
                }
                //close in scanner
                in.close();
                
                list = newList;
            }
            else{
                //loop while there is information stored in the next line of the csv file
                while(in.hasNext()){
                    //isolate the current line from the csv. file
                    String line = in.nextLine();
                    //create a scanner of that line
                    Scanner items = new Scanner(line);
                    //seperate the items from the line using the ',' indicator
                    items.useDelimiter(",");
                    //get accounts details
                    int accountNum = items.nextInt();
                    String password = items.next();
                    String companyName = items.next();
                    String firstName = items.next();
                    String lastName = items.next();
                    String number = items.next();
                    String email = items.next();
                    String address = items.next();
                    //make new Staff object with account details
                    CorporateAccount temp = new CorporateAccount(accountNum,password,companyName,firstName,lastName, number, email, address);
                    //add the Staff obect to newList
                    list.add(temp);
                    //close items scanner
                    items.close();
                    numAccounts++;
                    
                }
                //close the in scanner to save the changes
                in.close();
                
                
            }
        }catch(Exception e){
            // error message incase of error
                System.out.print("file not found");
            }
        
    }
    //function to export the corporate accounts list to a csv. file
    public void export(){
        Scanner input = new Scanner(System.in);
        //get name of file
        System.out.print("What is the name of the file: ");
        String fileName = input.nextLine();
        //try and catch block to avoid filenotfound error
        try{
            //create a printwriter object with fileName
            PrintWriter export = new PrintWriter(fileName);
            //loop through corporate accounts list
            for(int i =0;i<list.size();i++){
                //write to csv. file in correct formatting
                export.print(list.get(i).getAccountNum()+","+list.get(i).getPassword()+","+list.get(i).getCompanyName()+","+list.get(i).getFirstName()+","+list.get(i).getLastName()+","+list.get(i).getNumber()+","+list.get(i).getEmail()+","+list.get(i).getLocation());
                //move to next line
                export.println();
                
            }
            //close export to save changes
            export.close();
        }catch(Exception e){
            //error message
            System.out.print("error");
        }
        
    }
}