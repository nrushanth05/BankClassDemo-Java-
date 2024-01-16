/**
 * Name: Nrushanth Suthaharan
 * Date: 19/2023/01
 * Description: SavingsAccount is an object used in public accounts where 
 * interests are compounded and main storage is kept
*/
public class SavingsAccount{
    
    //initilize instance variables
    private double moneyBalance = 0;
    private double savingsInterest = 1.12;

    //constructer 
    public SavingsAccount(){

    }
    // get the moneyBalance;
    public  double getBalance(){
        return moneyBalance;
    }
    // get the interest
    public  double getInterest(){
        return savingsInterest;
    }
    //set the moneyBalance
    public  void setBalance(double num){
        moneyBalance = num;
    }
    // set the interest
    public  void setInterest(double interest){
        savingsInterest = interest;
    }
    // function to increment the money Balance by interest rate
    public void incrementSavings(){
        moneyBalance += (moneyBalance/savingsInterest);
    }
    // toString function
    public  String toString(){
        String output = String.format("%-15s%-15s\n","Money Balance","Savings Interest");
    	output += "\n";
    	output += String.format("%-15s%-15s\n",moneyBalance,savingsInterest);
    	return output;
    }
}