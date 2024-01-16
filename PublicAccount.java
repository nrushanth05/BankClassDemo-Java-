/**
 * Name: Nrushanth Suthaharan
 * Date: Jan 08, 2023
 * Description: PublicAccount object to represent the public accounts in the bank
 */

public class PublicAccount extends Account{
    //initialize the contact details
    private String birthDate;
    private String residence;
    private double loanInterest = 8.1;

    

    //create a constructor
    public PublicAccount(int accountNum, String password, String firstName, String lastName, String number, String email, String birthDate, String residence){
        super(accountNum,password, firstName, lastName, number,email);
        //set values to all contact details
        this.birthDate = birthDate;
        this.residence = residence;
    }
    // create savings account
    SavingsAccount savings = new SavingsAccount();
    ChequingsAccount chequings = new ChequingsAccount(); // create chequings account
    Loans loans = new Loans(); // create new loan list
    //get birthdate
    public  String getBirthDate(){
        return birthDate;
    }
    // get residence
    public  String getResidence(){
        return residence;
    }
    // set birthdate
    public  void setBirthDate(String date){
        birthDate = date;
    }
    // set residence
    public  void setResidence(String address){
        residence = address;
    }
    // deposit money into account
    public  void deposit(double amount, String accountType){
        if(accountType.equals("savings")){ // deposit into savings account
            savings.setBalance(savings.getBalance()+amount);
        }
        else{ // deposit into chequings account
            chequings.setBalance(chequings.getBalance()+amount);
        }
    }
    //withdraw money from account
    public  void withdraw(double amount, String accountType){
        if(amount<savings.getBalance() && amount<chequings.getBalance()){ // check if amount can be withdrawn
            if(accountType.equals("savings")){ // withdraw from savings
                savings.setBalance(savings.getBalance()-amount);
            }
            else{ // withdraw from chequings
                chequings.setBalance(chequings.getBalance()-amount);
            }
        }
    }
    //print the public account details
    public String toString(){
        //printf to format output
    	String output = String.format("%-15s%-15s%-15s%-20s%-15s%-15s%-15s\n","Account number","First Name","Last Name","Phone #","Email","BirthDate","Address");
    	output += "\n";
    	output += String.format("%-15s%-15s%-15s%-20s%-15s%-15s%-15s\n",super.getAccountNum(),super.getFirstName(),super.getLastName(),super.getNumber(),super.getEmail(),birthDate,residence);

    	return output;
    }
}