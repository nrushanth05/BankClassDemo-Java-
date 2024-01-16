/**
 * Name: Nrushanth Suthaharan
 * Date: Jan 18, 2022
 * Description: List of loans with functions
*/

//import statements
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;
import java.util.ArrayList;

public class Loans {
    ArrayList<Loan> list = new ArrayList<Loan>(); // make a list of loans
    ArrayList<Integer> loanNumbers = new ArrayList<Integer>(); // make a list of loan numbers
    
    private int numLoans = 0;
    //constructor
    public Loans(){
        loanNumbers.add( 1000000);
    }
    // get number of loans
    public int getNumLoans() {
    	return numLoans;
    }
    //function to get a unique bank number
    public int newLoanNum(){
        int currentNum = 1000000;
        while(loanNumbers.contains(currentNum)){ // check if currentNum already in list
            currentNum++; // add to currentNum
        }
        return currentNum; // get unique number
        
    }
    // get the loan
    public Loan getLoan(int index){
        
        return list.get(index);
    }
    
    // set a loan
    public void setLoan(int index, Loan loan){
        list.set(index,loan);
    }
    public void addLoan(){
        //get user input
        //user can input or leave certain parameters blank without affecting the program
        //first name and last name are a must however
        Scanner input = new Scanner(System.in);
        int loanNumber = newLoanNum();
        System.out.println("Loan number will be: " + Integer.toString(loanNumber));
        loanNumbers.add(loanNumber);
        System.out.println("Enter loan amount: ");
        double amount = input.nextDouble();
        input.nextLine();
        System.out.println("Enter the loan period/year (# of payments in one year): ");
        int period = input.nextInt();
        input.nextLine();
        System.out.println("Enter the end date: ");
        String endDate = input.nextLine();
        //create a new loan object with new loan details
        Loan loan = new Loan(loanNumber,amount,period, endDate);
        //add loan to the array list
        list.add(loan);
        numLoans++;
    }
    //function to display all the loans in the loan list
    public void displayAllLoans(){
        //use 'printf' to equally space out the displays to make the output more clean
        System.out.printf("%-15s%-15s%-15s%-15s%-20s\n","Loan number","Amount Owed","Loan Peiod/annual","End date","Interest");
        System.out.println();   
        //loops through entire list
        for(int i =0; i < list.size(); i ++){
            //outputs only the laons with details
            System.out.printf("%-15s%-15s%-15s%-15s%-20s\n",list.get(i).getLoanNumber(),list.get(i).getAmount(),list.get(i).getLoanPeriod(),list.get(i).getEndDate(),list.get(i).getInterest());
                
                
            
        }
        //empty lines to create spaces in the output
        System.out.println();
        System.out.println();
        System.out.println();
        
    }
    //function to display a single loan in the loan list using an index parameter
    public void displayOneLoan(int index){
        System.out.print(list.get(index).toString());
    }
    //function to search for a loan, returns index
    public int search(){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter loan number: ");
        int number = input.nextInt();
        for(int i =0; i < list.size();i++){
            if(number== list.get(i).getLoanNumber()){
                return i;
            }
            
        }
        return -1;
        
    }
    // function to modify loan details
    public void modifyLoan(){
        Scanner input = new Scanner(System.in);
        int index = search();
        if(index >=0){
            list.get(index).toString();
            System.out.println();
            while(true){
            	//menu system to select changes
                System.out.println("=======================================");
                System.out.println("=======================================");
                System.out.println("Enter the number of what you want to change from the menu below: ");
                System.out.println("0 Everything is fine");
                System.out.println("1 to make payment");
                System.out.println("2 to change loan amount");
                System.out.println("3 to change interest");
                System.out.println("4 to change loan period");
                System.out.println("5 to change loan end date");
                
                int num = input.nextInt();
                input.nextLine();
                if(num == 1){ // to make payment to loan
                    System.out.println("Enter amount: ");
                    double amount = input.nextDouble();
                    input.nextLine();
                    list.get(index).makePayment(amount); // make payement
                }
                else if(num ==2){ // to change the loan amount
                    System.out.println("Enter the loan amount: ");
                    double amount = input.nextDouble();
                    input.nextLine();
                    list.get(index).setAmount(amount); // set amount
                }
                else if(num ==3){ // to change the interest
                    System.out.println("Enter the interest: ");
                    double interest = input.nextDouble();
                    input.nextLine();
                    list.get(index).setInterest(interest); // set interest
                }
                else if(num ==4){ // to change the loan period
                    System.out.println("Enter the new period (# payments per year): ");
                    int period  = input.nextInt();
                    input.nextLine();
                    list.get(index).setLoanPeriod(period); // set loan period
                }
                else if(num ==5){ // to change the loan end date
                    System.out.println("Enter the new end date: ");
                    String date = input.nextLine();
                    list.get(index).setEndDate(date); // set end date
                }
                else{
                    break; // exit loop
                }
            }
        }
    }
    //function to remove a loan
    public void removeLoan(int index){
        if(list.get(index).getAmount()<=0){ //check if loan has been payed
            list.remove(index);
            
        }
    }
    
    
}