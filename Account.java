/**
 * Name: Nrushanth Suthaharan
 * Date: Jan 19,2022
 * Description: Account class acts as super class to publicAccount and CorporateAccount 
 * holding some user details and methods
*/
// import statements
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;
import java.util.ArrayList;


public abstract class Account{
    // initialize intance variables
    private int accountNum;
    private String password;
    //initialize the contact details
    private String firstName;
    private String lastName;
    private String number;
    private String email;
    
    //constructor method
    public Account(int accountNum, String password, String firstName, String lastName, String number, String email){
        this.accountNum = accountNum;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.number = number;
        this.email = email;
        
    // get account number    
    }
    public int getAccountNum(){
        return accountNum;
    }
    // get account password
    public String getPassword(){
        return password;
    }
    // get first name
    public String getFirstName(){
        return firstName;
    }
    // get last name
    public String getLastName(){
        return lastName;
    }
    // get number
    public  String getNumber(){
        return number; 
    }
    // get email
    public  String getEmail(){
        return email;
    }
    //accountNumber is fixed, unchangeable
    
    
    public  void setPassword(String password){ // set account password
        this.password = password;
    }
    
    public  void setFirstName(String firstName){ // set first name
        this.firstName = firstName;
    }
    public  void setLastName(String lastName){ // set last name
        this.lastName = lastName;
    }
    public  void setNumber(String number){ // set new number
        this.number = number;
    }
    public  void setEmail(String email){ // set new email
        this.email = email;
    }
}