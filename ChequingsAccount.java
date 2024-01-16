/**
 * Name: Nrushanth Suthaharan
 * Date: Jan 19, 2022
 * Description: Chequings Account class is an object used in publicAccount
 * with the ability to store money and hold a list of interactions
 * it cannot gain the benefits of interest however
*/

public class ChequingsAccount{
    // initialize intance variables
    private double moneyBalance = 0; // money balance
    private double[] interactions = new double[1400]; // list of interactions
    private int countInteractions = 0;
    //constructor method
    public ChequingsAccount(){

    }
    
    // function to get balance
    public double getBalance(){
        return moneyBalance;
    }
    // function to set balance
    public  void setBalance(double amount){
        moneyBalance = amount;
        interactions[countInteractions] = (amount-moneyBalance);
        countInteractions ++;
    }
    // function to display a list of all interactions
    public String toString(){
        String output = "";
        for(int i = 0; i< interactions.length;i++){
            output+= Integer.toString(i)+"st interaction: "+ interactions[i];
            output += "\n";
        }
        
        return output;
    }
}