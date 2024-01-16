/**
 * Name: Nrushanth Suthaharan
 * Date: Jan 10, 2023
 * Description: PublicAccounts object with all methods and display functions related to
 * the PublicAccount object
*/

// import statements
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;
import java.util.ArrayList;

public class PublicAccountsList {
    
    //initialize instance variables: the array list of publicaccount and account numbers
    ArrayList<PublicAccount> list = new ArrayList<PublicAccount>();
    ArrayList<Integer> accountNumbers = new ArrayList<Integer>();
    // number of accounts
    private int numAccounts = 0;
    //constructor
    public PublicAccountsList(){
        accountNumbers.add( 1000000);
    }
    // get number of accounts
    public int getNumAccounts() {
    	return numAccounts;
    }
    // get a unique account number, automatically when object created
    public int newAccountNum(){
        int currentNum = 1000000;
        while(accountNumbers.contains(currentNum)){ // make new account number
            currentNum++;
        }
        return currentNum;
        
    }
    //function to return a specific account using index
    public PublicAccount getAccount(int index){
        
        return list.get(index);
    }
    
    
    public void setAccount(int index, PublicAccount account){
        list.set(index, account);
    }
    
    public void addAccount(){
        //get user input
        //user can input or leave certain parameters blank without affecting the program
        //first name and last name are a must however
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a First Name: ");
        String firstName = input.nextLine();
        System.out.println("Enter a Last Name: ");
        String lastName = input.nextLine();
        int accountNumber = newAccountNum();
        System.out.println("Account number will be: " + Integer.toString(accountNumber));
        accountNumbers.add(accountNumber);
        System.out.println("Enter the account password: ");
        String password = input.nextLine();
        System.out.println("Enter their number: ");
        String number = input.nextLine();
        System.out.println("Enter an email: ");
        String email = input.nextLine();
        System.out.println("Enter a birth date: ");
        String birthDate = input.nextLine();
        System.out.println("Enter a home address: ");
        String residence = input.nextLine();
        input.nextLine();
        //create a new publicAccount object with new account details
        PublicAccount account = new PublicAccount(accountNumber,password,firstName, lastName, number, email, birthDate, residence);
        //add account to the array list
        list.add(account);
        numAccounts++;
    }
    //function to display all the accounts in the publicAccountsList
    public void displayAllAccounts(){
        //use 'printf' to equally space out the displays to make the output more clean
        System.out.printf("%-15s%-15s%-15s%-20s%-15s%-15s%-15s\n","Account number","First Name","Last Name","Phone #","Email","BirthDate","Address");
        System.out.println();   
        //loops through entire list
        for(int i =0; i < list.size(); i ++){
            //outputs only the accounts with details
            if(list.get(i).getFirstName()!=null){
                System.out.printf("%-15s%-15s%-15s%-20s%-15s%-15s%-15s\n",list.get(i).getAccountNum(),list.get(i).getFirstName(),list.get(i).getLastName(),list.get(i).getNumber(),list.get(i).getEmail(),list.get(i).getBirthDate(),list.get(i).getResidence());
                
                
            }
        }
        //empty lines to create spaces in the output
        System.out.println();
        System.out.println();
        System.out.println();
        
    }
    //function to display a single account in the staff list using an index parameter
    //better option is to use toString of Staff class
    public void displayOneAccount(int index){
        System.out.print(list.get(index).toString());
    }
    //function to modify the details of a single account
    public void sortFirstLastNames(){
    	Scanner input = new Scanner(System.in);
        //Selection sort
        for (int i = 1; i < list.size(); i++) {
            PublicAccount temp = list.get(i);
            String firstLastName = list.get(i).getFirstName()+list.get(i).getLastName();
            int j = i;
            while (j > 0 && (list.get(j-1).getFirstName()+list.get(j-1).getLastName()).compareToIgnoreCase(firstLastName)<0) {
                list.set(j,list.get(j-1));
                
                j--;
            }
            list.set(j, temp);
            
        }
        
    }
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
        //loops through list
        for(int i = 0; i < list.size(); i++){
            //checks for the user by matching first name and last name
            if(list.get(i).getFirstName().equals(firstName) && list.get(i).getLastName().equals(lastName)){
                //calls the toString to display the current account
                System.out.println(list.get(i).toString());
                System.out.println("Savings balance: "+list.get(i).savings.getBalance());
                System.out.println("Chequings balance: " + list.get(i).chequings.getBalance());
                while(true){
                	//menu system to select changes
                    System.out.println("=======================================");
                    System.out.println("=======================================");
                    System.out.println("Enter the number of what you want to change from the menu below: ");
                    System.out.println("0 Everything is fine");
                    System.out.println("1 to change first name");
                    System.out.println("2 to change last name");
                    System.out.println("3 to change the password");
                    System.out.println("4 to change phone number");
                    System.out.println("5 to change email");
                    System.out.println("6 to change birth date");
                    System.out.println("7 to change home address");
                    System.out.println("8 to deposit money");
                    System.out.println("9 to withdraw money");

                    int num = input.nextInt();
                    //empty input statement to consume the \n from previous answer
                    input.nextLine();
                    if(num == 1){
                        System.out.print("Enter a first name: ");
                        firstName = input.nextLine();
                        //change first name
                        list.get(i).setFirstName(firstName);
                    }
                    //change last name
                    else if(num == 2){
                        System.out.print("Enter a last name: ");
                        lastName = input.nextLine();
                        list.get(i).setLastName(lastName);
                    }
                    //change the password
                    else if(num ==3){
                        System.out.print("Enter a new password: ");
                        String password = input.nextLine();
                        list.get(i).setPassword(password);
                    }
                    //change the phone number
                    else if(num == 4){
                        System.out.print("Enter a phone number: ");
                        String number = input.nextLine();
                        list.get(i).setNumber(number);
                        
                    }
                    //change the email
                    else if(num == 5){
                        System.out.print("Enter a email: ");
                        String email = input.nextLine();
                        list.get(i).setEmail(email);
                    }
                    //change the birthdate
                    else if(num == 6){
                        System.out.print("Enter a birth date: ");
                        String birthDate = input.nextLine();
                        list.get(i).setBirthDate(birthDate);
                    }
                    //change the address
                    else if(num == 7){
                        System.out.print("Enter a home address: ");
                        String address = input.nextLine();
                        list.get(i).setResidence(address);
                    }
                    else if(num ==8){ // make deposit
                        System.out.print("Enter an amount: ");
                        double amount = input.nextDouble();
                        input.nextLine();
                        System.out.print("Enter account type ('savings' for savings):" );
                        String accountType = input.nextLine();
                        list.get(i).deposit(amount,accountType);
                    }
                    else if(num == 9 ){
                        System.out.print("Enter an amount: ");
                        double amount = input.nextDouble();
                        input.nextLine();
                        System.out.print("Enter account type ('savings' for savings):" );
                        String accountType = input.nextLine();
                        list.get(i).withdraw(amount,accountType);
                        
                    }
                    //exits the loop
                    else if(num == 0){
                        break;
                    }
                }
                
                
            }
            //prints error message
            else if(i==list.size()-1){
                System.out.print("Contact not found!");
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
        
        for(int i= 0; i < list.size(); i++){
            //checks for the user
            if(list.get(i).getFirstName().equals(firstName) && list.get(i).getLastName().equals(lastName)){
                //displays the account information
          
                System.out.println("=======================================");
                System.out.println("=======================================");
                System.out.print(list.get(i).toString());
                //double checks confirmation to delete
                System.out.println("Are you sure you want to remove this account ('y' for yes)");
                String command = input.nextLine();
                if(command.equals("y")) {
	                //removes this index from the publicAccountsList
	                list.remove(i);
	                numAccounts--;
                }
            }
            //error message
            else if(i==list.size()-1){
                System.out.println("Contact not found!");
            }
        }
    }
    //function to find and display a single account
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
                   //store list.get(i) in a new publicAccount object
                   PublicAccount temp = list.get(i);
                   //swap the two account objects
                   list.set(i,list.get(i+1));
                   list.set(i+1, temp);
                   swap = true;
                   
               }
           }
           j++;
        }
        //display the accounts using displayAllContacts function
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
    //function to reverse the order of the publicAccountsList
    public ArrayList<PublicAccount> reverseList(){
        //create a new arrayList of publicAccount objects
        ArrayList<PublicAccount> newList = new ArrayList<PublicAccount>();
        //loop through list in reverse
        for(int i = list.size()-1;i>=0;i--){
            //add each item to the new array list
            newList.add(list.get(i));
        }
        //return the new list
        return newList;
    }
    
    //function to sort publicAccountsList by last names
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
            //make new publicAccount object as a temp storage
            PublicAccount temp = list.get(i);
            //swap the smallest account with the next account in order
            list.set(i,list.get(minIndex));
            list.set(minIndex,temp);
        }
        //call displayAllContacts function to display the accounts
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
        //create a new array list of publicAccount objects
        ArrayList<PublicAccount> newList = new ArrayList<PublicAccount>();
        Scanner input = new Scanner(System.in);
        //ask if you would like to overwrite or add to current list
        System.out.print("Would you like to overwrite you current public accounts list or add to it ('y' to overwrite and 'n' to add)? ");
        String command = input.nextLine();
        //get name of file
        System.out.print("What is the name of the file: ");
        String fileName = input.nextLine();
        //outputs the format of the csv. file
        System.out.println("The file format should be:");
        System.out.println("Account Number, password, First name, Last name, Phone #, Email, BirthDate, Address");
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
                    String firstName = items.next();
                    String lastName = items.next();
                    String number = items.next();
                    String email = items.next();
                    String birthDate = items.next();
                    String address = items.next();
                    //make new Staff object with account details
                    PublicAccount temp = new PublicAccount(accountNum,password,firstName,lastName, number, email, birthDate, address);
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
                    String firstName = items.next();
                    String lastName = items.next();
                    String number = items.next();
                    String email = items.next();
                    String birthDate = items.next();
                    String address = items.next();
                    //make new Staff object with account details
                    PublicAccount temp = new PublicAccount(accountNum,password,firstName,lastName, number, email, birthDate, address);
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
    //function to export the publicAccountsList to a csv. file
    public void export(){
        Scanner input = new Scanner(System.in);
        //get name of file
        System.out.print("What is the name of the file: ");
        String fileName = input.nextLine();
        //try and catch block to avoid filenotfound error
        try{
            //create a printwriter object with fileName
            PrintWriter export = new PrintWriter(fileName);
            //loop through publicAccountsList
            for(int i =0;i<list.size();i++){
                //write to csv. file in correct formatting
                export.print(list.get(i).getAccountNum()+","+list.get(i).getPassword()+","+list.get(i).getFirstName()+","+list.get(i).getLastName()+","+list.get(i).getNumber()+","+list.get(i).getEmail()+","+list.get(i).getBirthDate()+","+list.get(i).getResidence());
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