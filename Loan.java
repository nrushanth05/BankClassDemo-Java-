/**
 * Name: Nrushanth Suthaharan
 * Date: Jan 18, 2022
 * Description: Loan class is an object used in all accounts in the bank
 * and acts as a money lending service from the bank, with negative interest
*/
public class Loan {
    // initalize instance variables
    private int loanNumber = 0 ;
    private double interest = 7.8;
    private double amountRem = 0;
    private int loanPeriod = 2;
    private String loanEndDate;
    
    // constructer 
    public Loan(int loanNumber,double amount,int period, String loanEndDate){
        this.loanNumber = loanNumber;
        amountRem = amount;
        loanPeriod = period;
        this.loanEndDate = loanEndDate;
    }
    // get loan number
    public int getLoanNumber(){
        return loanNumber;
    }
    // get interest rate
    public double getInterest(){
        return interest;
    }
    // get amount owed
    public double getAmount(){
        return amountRem;
    }
    // get loan period
    public int getLoanPeriod(){
        return loanPeriod;
    }
    // get loan end date
    public String getEndDate(){
        return loanEndDate;
    }
    // set interest rate
    public void setInterest(double interest){
        this.interest = interest;
    }
    // set amount
    public void setAmount(double amount){
        this.amountRem = amount;
    }
    // set loan period
    public void setLoanPeriod(int period){
        loanPeriod = period;
    }
    // set end date
    public void setEndDate(String date){
        loanEndDate = date;
    }
    // make payment
    public void makePayment(double amount){
        amountRem -= amount; // subtract amount from amount owed
    }
    //function to increment loan amount by interest rate
    // this function is automatically applied every month like in savings account
    public void incrementLoan(){
        amountRem += (amountRem/interest);
    }
    // print the loan details (formatted)
    public String toString(){
        String output = String.format("%-15s%-15s%-15s%-15s%-20s\n","Loan number","Amount Owed","Loan Peiod/annual","End date","Interest");
    	output += "\n";
    	output += String.format("%-15s%-15s%-15s%-15s%-20s\n",loanNumber,amountRem, loanPeriod,loanEndDate,interest);
    	return output;
    	
    }
}