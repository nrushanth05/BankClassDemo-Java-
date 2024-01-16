/**
 * Name: Nrushanth Suthaharan
 * Date: Jan 08, 2023
 * Description: Staff object to represent the staffs in the bank
 */

public class Staff {
    //initialize the staff details
    private String firstName;
    private String lastName;
    private String position;
    private String branch;
    private String number;
    private String email;
    private String birthDate;
    private String residence;
    private double salary;
    
    //create a constructor
    public Staff(String newFirstName, String newLastName, String number){
        //set values to all staff details
        firstName = newFirstName;
        lastName = newLastName;
        this.number = number;
    }
    //get first name
    public  String getFirstName(){
        return this.firstName;
    }
    //get last name
    public  String getLastName(){
        return this.lastName;
    }
    //get position
    public String getPosition(){
        return this.position;
    }
    // get branch
    public String getBranch(){
        return this.branch;
    }
    //get phone number
    public  String getNumber(){
        return this.number;
    }
    //get email
    public  String getEmail(){
        return this.email;
    }
    //get birth date
    public  String getBirthDate(){
        return this.birthDate;
    
    }
    //get home address
    public  String getResidence(){
        return this.residence;
    }
    //get the salary
    public  double getSalary(){
        return this.salary;
    }
    
    
    
    
    
    //set the first name
    public  void setFirstName(String firstName){
        this.firstName = firstName;
    }
    //set the last name
    public  void setLastName(String lastName){
        this.lastName = lastName;
    }
    // set the position
    public void setPosition(String position){
        this.position = position;
    }
    //set the branch
    public void setBranch(String branch){
        this.branch = branch;
    }
    //set the phone number
    public  void setNumber(String number){
        this.number = number;
    }
    //set the email
    public  void setEmail(String email){
        this.email = email;
    }
    //set the birth date
    public  void setBirthDate(String birthDate){
        this.birthDate = birthDate;
    }
    //set the home address
    public  void setResidence(String homeAddress){
        this.residence = homeAddress;
    }
    //set the salary
    public  void setSalary(double salary){
        this.salary = salary;
    }
    //print out the Staff details
    public String toString(){
    	String output = String.format("%-15s%-15s%-15s%-20s%-15s%-15s%-15s%-15s%-15s\n","First Name","Last Name","Position","Branch","Phone #","Email","BirthDate","Address","Salary");
    	output += "\n";
    	output += String.format("%-15s%-15s%-15s%-20s%-15s%-15s%-15s%-15s%-15s\n",firstName,lastName,position, branch, number,email,birthDate,residence,salary);
        //System.out.printf("%-15s%-15s%-15s%-20s%-15s%-15s%-15s\n","First Name","Last Name","Phone #","Email","BirthDate","Address","Relation");
        //System.out.println();
        //System.out.printf("%-15s%-15s%-15s%-20s%-15s%-15s%-15s\n",firstName,lastName,number,email,birthDate,homeAddress,relation);
    	return output;
    }
}