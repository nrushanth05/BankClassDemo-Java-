/**
 * Name: Nrushanth Suthaharan
 * Date: Jan 19, 2022
 * Description: CorporateAccount class is a subclass of account and holds all of the
 * corporate accounts in the bank
 * it has its own interest values and specific functions
*/

public class CorporateAccount extends Account{
    // initialize instance variable for corporate Account class
    private String location;
    private String companyName;
    private double moneyBalance = 0.0;
    //private double loanInterest = 4.3;
    private double interest = 1.8;
    private double taxBreak = 22.0;
    //constructor method
    public CorporateAccount(int accountNum,String password, String companyName, String firstName, String lastName, String number, String email, String location){
        super( accountNum,  password,  firstName,lastName, number,email); // call super class
        this.location = location;
        this.companyName = companyName;
    }
    
    Loans loans = new Loans(); // make list of loans
    //get location
    public String getLocation(){
        return location;
    }
    //function to get company name
    public String getCompanyName(){
        return companyName;
    }
    // functio to get account balance
    public double getBalance(){
        return moneyBalance;
    }
    // function to get interest
    public double getInterest(){
        return interest;
    }
    // function to get taxBreak
    public double getTax(){
        return taxBreak;
    }
    // function to set taxBreak
    public void setTax(double tax){
        taxBreak = tax;
    }
    // function to set location
    public void setLocation(String location){
        this.location = location;
    }
    // function to set company name
    public void setCompanyName(String name){
        companyName = name;
    }
    // function to set interest rate
    public void setInterest(double interest){
        this.interest = interest;
    }
    // function to withdraw money from account
    public void withdraw(double amount){
        if(amount< moneyBalance){ // check if amount is available
            moneyBalance -= amount;
            
        }
        else{
            System.out.print("Insufficient funds");
        }
    }
    // function to deposit money into account
    public void deposit(double amount){
        moneyBalance += amount;
    }
    // function to increment balance
    // calls automatically every month
    public void incrementBalance(){
        moneyBalance += (moneyBalance/(taxBreak-interest)); // increment
    }
    // prints the details of the corporate account
    public String toString(){
    	String output = String.format("%-15s%-15s%-15s%-20s%-15s%-15s%-15s\n","Account number","Company name","First Name","Last Name","Phone #","Email","Address");
    	output += "\n";
    	output += String.format("%-15s%-15s%-15s%-20s%-15s%-15s%-15s\n",super.getAccountNum(),companyName,super.getFirstName(),super.getLastName(),super.getNumber(),super.getEmail(),location);

    	return output;
    }
    
}