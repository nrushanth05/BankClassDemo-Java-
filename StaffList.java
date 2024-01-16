/**
 * Name: Nrushanth Suthaharan
 * Date: Jan 10, 2023
 * Description: Staff list object with all staffs, details, and methods for those staffs
*/

import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;
import java.util.ArrayList;

public class StaffList {
    
    ArrayList<Staff> list = new ArrayList<Staff>(); // make list of staff object
    
    private int numStaff = 0;
    // constructor method
    public StaffList(){
        
    }
    
    // get number of staff
    public int getNumStaff() {
    	return numStaff;
    }
    public void addStaff(){
        //get user input
        //user can input or leave certain parameters blank without affecting the program
        //first name and last name and number are a must however
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a First Name: ");
        String firstName = input.nextLine();
        System.out.println("Enter a Last Name: ");
        String lastName = input.nextLine();
        System.out.println("Enter their position: ");
        String position = input.nextLine();
        System.out.println("Enter the branch location: ");
        String branch = input.nextLine();
        System.out.println("Enter their number: ");
        String number = input.nextLine();
        System.out.println("Enter an email: ");
        String email = input.nextLine();
        System.out.println("Enter a birth date: ");
        String birthDate = input.nextLine();
        System.out.println("Enter a home address: ");
        String residence = input.nextLine();
        System.out.println("Enter the salary: ");
        double salary = input.nextDouble();
        input.nextLine();
        //create a new Staff object with new staff details
        Staff staff = new Staff(firstName, lastName, number);
        staff.setPosition(position);
        staff.setBranch(branch);
        staff.setEmail(email);
        staff.setBirthDate(birthDate);
        staff.setResidence(residence);
        staff.setSalary(salary);
        //add staff to the array list
        list.add(staff);
        numStaff++;
    }
    //function to display all the staffs in the stafflist
    public void displayAllStaff(){
        //use 'printf' to equally space out the displays to make the output more clean
        System.out.printf("%-15s%-15s%-15s%-20s%-15s%-15s%-15s%-15s%-15s\n","First Name","Last Name","Position","Branch","Phone #","Email","BirthDate","Address","Salary");
        System.out.println();   
        //loops through entire list
        for(int i =0; i < list.size(); i ++){
            //outputs only the staff with details
            if(list.get(i).getFirstName()!=null){
                System.out.printf("%-15s%-15s%-15s%-20s%-15s%-15s%-15s%-15s%-15s\n",list.get(i).getFirstName(),list.get(i).getLastName(),list.get(i).getPosition(),list.get(i).getBranch(),list.get(i).getNumber(),list.get(i).getEmail(),list.get(i).getBirthDate(),list.get(i).getResidence(),list.get(i).getSalary());
                
                
            }
        }
        //empty lines to create spaces in the output
        System.out.println();
        System.out.println();
        System.out.println();
        
    }
    //function to display a single staff in the staff list using an index parameter
    public void displayOneStaff(int index){
        System.out.print(list.get(index).toString());
    }
    //function to sort list by first and last names
    public void sortFirstLastNames(){
    	Scanner input = new Scanner(System.in);
        //Selection sort
        for (int i = 1; i < list.size(); i++) {
            //temporary staff object
            Staff temp = list.get(i);
            String firstLastName = list.get(i).getFirstName()+list.get(i).getLastName();
            int j = i;
            while (j > 0 && (list.get(j-1).getFirstName()+list.get(j-1).getLastName()).compareToIgnoreCase(firstLastName)<0) {
                list.set(j,list.get(j-1));
                
                j--;
            }
            list.set(j, temp);
            
        }
        
    }
    //function to modify a staff's details
    public void modifyStaff(){
        Scanner input = new Scanner(System.in);
        //lines to seperate and organise terminal screen
        System.out.println("=======================================");
        System.out.println("=======================================");
        System.out.println("=======================================");
        //get staff info
        System.out.print("Enter the first name: ");
        String firstName = input.nextLine();
        System.out.print("Enter the last name: ");
        String lastName = input.nextLine();
        //loops through list
        for(int i = 0; i < list.size(); i++){
            //checks for the staff by matching first name and last name
            if(list.get(i).getFirstName().equals(firstName) && list.get(i).getLastName().equals(lastName)){
                //calls the toString to display the current contact
                list.get(i).toString();
                while(true){
                	//menu system to select changes
                    System.out.println("=======================================");
                    System.out.println("=======================================");
                    System.out.println("Enter the number of what you want to change from the menu below: ");
                    System.out.println("0 Everything is fine");
                    System.out.println("1 to change first name");
                    System.out.println("2 to change last name");
                    System.out.println("3 to change position");
                    System.out.println("4 to change branch");
                    System.out.println("5 to change phone number");
                    System.out.println("6 to change email");
                    System.out.println("7 to change birth date");
                    System.out.println("8 to change home address");
                    System.out.println("9 to change salary");
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
                    //change the position
                    else if(num ==3){
                        System.out.print("Enter a new position: ");
                        String position = input.nextLine();
                        list.get(i).setPosition(position);
                    }
                    //change the branch
                    else if(num ==4){
                        System.out.print("Enter a new branch");
                        String branch = input.nextLine();
                        list.get(i).setBranch(branch);
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
                    //change the birthdate
                    else if(num == 7){
                        System.out.print("Enter a birth date: ");
                        String birthDate = input.nextLine();
                        list.get(i).setBirthDate(birthDate);
                    }
                    //change the address
                    else if(num == 8){
                        System.out.print("Enter a home address: ");
                        String address = input.nextLine();
                        list.get(i).setResidence(address);
                    }
                    //change the relation
                    else if(num == 9){
                        System.out.print("Enter a salary: ");
                        double salary = input.nextDouble();
                        list.get(i).setSalary(salary);
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
    //function to remove a single staff
    public void removeStaff(){
        Scanner input = new Scanner(System.in);
        System.out.println("=======================================");
        System.out.println("=======================================");
        System.out.println("=======================================");
        //get first name and last name from staff
        System.out.print("Enter the first name: ");
        String firstName = input.nextLine();
        System.out.print("Enter the last name: ");
        String lastName = input.nextLine();
        
        for(int i= 0; i < list.size(); i++){
            //checks for the staff
            if(list.get(i).getFirstName().equals(firstName) && list.get(i).getLastName().equals(lastName)){
                //displays the staff information
          
                System.out.println("=======================================");
                System.out.println("=======================================");
                System.out.print(list.get(i).toString());
                //double checks confirmation to delete
                System.out.println("Are you sure you want to remove this contact ('y' for yes)");
                String command = input.nextLine();
                if(command.equals("y")) {
	                //removes this index from the phone book
	                list.remove(i);
	                numStaff--;
                }
            }
            //error message
            else if(i==list.size()-1){
                System.out.println("Contact not found!");
            }
        }
    }
    //function to find index of a single staff
    public int search(String firstName, String lastName, int start, int end){
        //binary search
        //sort
        sortFirstLastNames();
        if(start>end) {
        	return -1;
        }
        else {
        	int mid = (start+end)/2;
        	String fullName = firstName +lastName;
        	// if staff is at mid index
        	if(list.get(mid).getFirstName().equals(firstName) && list.get(mid).getLastName().equals(lastName)) {
        		return mid;
        	}
        	//if staff is on the right
        	else if(fullName.compareToIgnoreCase(list.get(mid).getFirstName()+list.get(mid).getLastName())<0) {
        		return search(firstName,lastName,mid+1,end);
        	}
        	//if staff is on the left
        	else {
        		return search(firstName,lastName,start,mid-1);
        	}
        }
        
    }
    //function to sort stafflist by first names
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
                   //store list.get(i) in a new Staff object
                   Staff temp = list.get(i);
                   //swap the two staff objects
                   list.set(i,list.get(i+1));
                   list.set(i+1, temp);
                   swap = true;
                   
               }
           }
           j++;
        }
        //display the contacts using displayAllContacts function
        displayAllStaff();
        //ask user if they want to reverse the list
        System.out.println("Would you like to alphabetically reverse the list? ('y' for yes)");
        String command = input.nextLine();
        //reverses the list
        if(command.equals("y")){
            //calls the reverseList function to reverse the list
            list = reverseList();

        }
    }
    //function to reverse the order of the staffList
    public ArrayList<Staff> reverseList(){
        //create a new arrayList of Staff objects
        ArrayList<Staff> newList = new ArrayList<Staff>();
        //loop through list in reverse
        for(int i = list.size()-1;i>=0;i--){
            //add each item to the new array list
            newList.add(list.get(i));
        }
        //return the new list
        return newList;
    }
    
    //function to sort staffList by last names
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
            //make new Staff object as a temp storage
            Staff temp = list.get(i);
            //swap the smallest staff with the next contact in order
            list.set(i,list.get(minIndex));
            list.set(minIndex,temp);
        }
        //call displayAllStaff function to display the staff
        displayAllStaff();
        //asks user if they want to reverse the list
        System.out.println("Would you like to alphabetically reverse the list? ('y' for yes)");
        String command = input.nextLine();
        //reverses the list
        if(command.equals("y")){
            //calls the reverseList function to reverse the list
            list = reverseList();

        }
        
    }
    //function to import staff details from a csv. file to staffList
    //this does work in codeHS but file must be added to left column
    public void insert(){
        //create a new array list of Staff objects
        ArrayList<Staff> newList = new ArrayList<Staff>();
        Scanner input = new Scanner(System.in);
        //ask if you would like to overwrite or add to current list
        System.out.print("Would you like to overwrite you current staff list or add to it ('y' to overwrite and 'n' to add)? ");
        String command = input.nextLine();
        //get name of file
        System.out.print("What is the name of the file: ");
        String fileName = input.nextLine();
        //outputs the format of the csv. file
        System.out.println("The file format should be:");
        System.out.println("First name, Last name, Position , Branch, Phone #, Email, BirthDate, Address, Salary");
        //try and catch block to avoid File/other .io errors
        try{
            // create a scanner with the designated file
            //wil throw error if file is not found
            Scanner in = new Scanner(new File(fileName));
            
            //if overwriting
            if(command.equals("y")){
            	numStaff =0;
                //loop while there is information stored in the next line of the csv file
                while(in.hasNext()){
                    //isolate the current line from the csv. file
                    String line = in.nextLine();
                    //create a scanner of that line
                    Scanner items = new Scanner(line);
                    //seperate the items from the line using the ',' indicator
                    items.useDelimiter(",");
                    //get contacts details
                    String firstName = items.next();
                    String lastName = items.next();
                    String position = items.next();
                    String branch = items.next();
                    String number = items.next();
                    String email = items.next();
                    String birthDate = items.next();
                    String address = items.next();
                    double salary = items.nextInt();
                    //make new Staff object with staff details
                    Staff temp = new Staff(firstName,lastName, number);
                    temp.setPosition(position);
                    temp.setBranch(branch);
                    temp.setEmail(email);
                    temp.setBirthDate(birthDate);
                    temp.setResidence(address);
                    temp.setSalary(salary);
                    //add the Staff obect to newList
                    newList.add(temp);
                    //close items scanner
                    items.close();
                    numStaff++;
                    
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
                    //get staff details
                    String firstName = items.next();
                    String lastName = items.next();
                    String position = items.next();
                    String branch = items.next();
                    String number = items.next();
                    String email = items.next();
                    String birthDate = items.next();
                    String address = items.next();
                    double salary = items.nextInt();
                    //create new Staff object with contact details
                    Staff temp = new Staff(firstName,lastName, number);
                    temp.setPosition(position);
                    temp.setBranch(branch);
                    temp.setEmail(email);
                    temp.setBirthDate(birthDate);
                    temp.setResidence(address);
                    temp.setSalary(salary);
                    //add the Staff object to the input array list/current phone book
                    list.add(temp);
                    //close the items scanner
                    items.close();
                    numStaff++;
                    
                }
                //close the in scanner to save the changes
                in.close();
                
                
            }
        }catch(Exception e){
            // error message incase of error
                System.out.print("file not found");
            }
        
    }
    //function to export the staffList to a csv. file
    public void export(){
        Scanner input = new Scanner(System.in);
        //get name of file
        System.out.print("What is the name of the file: ");
        String fileName = input.nextLine();
        //try and catch block to avoid filenotfound error
        try{
            //create a printwriter object with fileName
            PrintWriter export = new PrintWriter(fileName);
            //loop through staffList
            for(int i =0;i<list.size();i++){
                //write to csv. file in correct formatting
                export.print(list.get(i).getFirstName()+","+list.get(i).getLastName()+","+list.get(i).getPosition()+","+list.get(i).getBranch()+","+list.get(i).getNumber()+","+list.get(i).getEmail()+","+list.get(i).getBirthDate()+","+list.get(i).getResidence()+","+list.get(i).getSalary());
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