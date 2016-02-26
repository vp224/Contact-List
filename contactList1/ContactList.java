/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//S.vishnu praneeth
//14CS30031

package contactList1;

import java.io.*;
import java.util.*;
import shortTermCourseManagement.*;
//execeptions
class EmptyListException extends Exception {//thrown when contact list is empty
    public EmptyListException() {
        super("Contact List is empty");
    }
}

class AcquaintancefoundException extends Exception {//thrown when same acquaintance is found 
    public AcquaintancefoundException() {
        super("The Acquaintance is same as other");
    }
}

class AcquaintanceunfoundException extends Exception {//thrown when no acquaintance with similar characteristic found
    public AcquaintanceunfoundException() {
        super("The Acquaintance is not there");
    }
}

public class ContactList implements Serializable {

    private ArrayList<Acquaintance> aqs = new ArrayList<Acquaintance>();//array list of acquaintances
    public ArrayList<Acquaintance> acqsreturn() throws EmptyListException {//returns the array lst of acquaintances
        if (aqs.isEmpty()) 
            throw new EmptyListException();           
        else 
            return aqs;
    }
    public boolean delacq(Acquaintance newAcq) throws EmptyListException {//deletes a particular acquaintance using remove method
        if (aqs.isEmpty()) {
            throw new EmptyListException();
        }
        else 
         return aqs.remove(newAcq);
    }
    public void appendaq(Acquaintance newAcq) throws AcquaintancefoundException {//adds a new acquaintance to the array list of acquiantances
        if (aqs.indexOf(newAcq) == -1) {
            aqs.add(newAcq);
        } else {
            throw new AcquaintancefoundException();
        }
    }
    
   /* public static void main(String args[]) {//main method
        ContactList contcs = new ContactList();
        TestClass.testfn(contcs);
    }*/
}

class TestClass {//main class to which contact  list is passed and the options as specified in the question are performed here

    public static void testfn(ContactList contcs) {
        Scanner s= new Scanner(System.in);
        File f = new File("contcs.dat");
        if (f.exists()) {//if the file already exists the data whic was stored previously is being read again
            System.out.println("List already present...for reading type read");
            String var=s.nextLine();
            if(var.equals("read")) 
                System.out.println("DATA WHICH IS STORED PREVIOUSLY IS BEING READ");
            else 
                System.out.println("List initialise..");
            } 
        else 
            System.out.println("List initialise...");
        first:
        for(int i=0;;i++){
            try {// different options to perform as specified in the questoion
                System.out.println("1.)Create Acquaintance");
                System.out.println("2.)Delete acquaintance");
                System.out.println("3.)Display Entire List");
                System.out.println("4.)Display the list of speciﬁc category of acquaintance");
                System.out.println("5.)Read Data");
                System.out.println("6.)Save data");
                System.out.println("7.)Search acquaintance");
                System.out.println("8.)Terminate");
                String sk;
                int choice = s.nextInt();
                switch (choice) 
                {
                    case 1: {//case 1 to create a new acquaintance of a specific type
                            System.out.print("Enter Relative||Professional Friend||Personal Friend||Casual Acquaintance : ");
                            sk=s.nextLine();// just like fflush(stdin) in C to handle input string after an integer
                            String input=s.nextLine();
                            if(input.equals("Professional Friend"))
                                {//access the details
                                    System.out.println("Enter the professional friends name");
                                    String pronam=s.nextLine();
                                    System.out.println("Enter the professional friends mobile no");
                                    Long prommob=s.nextLong();
                                    System.out.println("Enter the professional friends email");
                                    sk=s.nextLine();
                                    String proemail=s.nextLine();
                                    System.out.println("Enter the professional friends common interests");
                                    String prointerest=s.nextLine();
                                    try{
                                        ProfessionalFriends pf=new ProfessionalFriends(pronam,proemail,prointerest,prommob);
                                        contcs.appendaq(pf);
                                        System.out.println("####Professional friends details  succesfully####");
                                    } catch (Exception e) {
                                        System.out.println(e);
                                    }
                                }
                            else if(input.equals("Personal Friend")) 
                                {//access the details
                                    System.out.println("Enter the personal friends name");
                                    String personalfnam=s.nextLine();
                                    System.out.println("Enter the personal friends mobile number");
                                    Long personalfmob=s.nextLong();
                                    System.out.println("Enter the personal friends email ");
                                    sk=s.nextLine();
                                    String personalfemail=s.nextLine();
                                    System.out.println("Enter the personal friends context");
                                    String personalfcon=s.nextLine();
                                    System.out.println("Enter the personal friends aquaintance date in the format of dd-mm-yyyy");
                                    String personalfdat=s.nextLine();
                                    System.out.println("Enter the personal friends specific events");
                                    String personalfsp=s.nextLine();
                                    try {
                                        PersonalFriends perf=new PersonalFriends(personalfnam,personalfemail,personalfsp,personalfcon,personalfdat,personalfmob);
                                        contcs.appendaq(perf);//calls the append method to append the required acquaintance
                                        System.out.println("Personal friends added successfully");
                                    } catch (Exception e) {
                                        System.out.println(e.getClass());
                                    }
                                }
                                
                            else if(input.equals("Relative")) 
                                {//access the details
                                    System.out.println("Enter the relatives name");
                                    String relnam=s.nextLine();
                                   
                                    System.out.println("Enter the relatives mobile number");
                                    Long relmob=s.nextLong();
                                    System.out.println("Enter the relatives email");
                                    sk=s.nextLine();
                                    String relemail=s.nextLine();
                                    System.out.println("Enter the relatives birthday");
                                    String relbday=s.nextLine();
                                    System.out.println("Enter the relatives last meeting date in the form of yyyy-mm-dd hh:mm:ss");
                                    String rellastdat=s.nextLine();
                                    try 
                                    {
                                        Relative r=new Relative(relnam, relmob, relemail, relbday, rellastdat);
                                        contcs.appendaq(r);//calling the append function to ad in the required acquaintance
                                        System.out.println("relatives details added!!");
                                    } catch (Exception e) {
                                        System.out.println(e.getClass());
                                    }
                                }
                                else if(input.equals("Casual Acquaintance"))
                                {//access the details
                                    System.out.println("Enter the Casual acquaintance name");
                                    String casaqnam=s.nextLine();
                                    System.out.println("Enter the mobile number of the casual acquaintance ");
                                    Long casaqmob=s.nextLong();
                                    System.out.println("Enter the email of the Casual acquaintance");
                                    sk=s.nextLine();
                                    String casaqemail=s.nextLine();
                                    System.out.println("Enter where the meeting of Casual acquaintance occured");
                                    String casaqwhere=s.nextLine();
                                    System.out.println("Enter when the meeting of Casual acquaintance occured ");
                                    String casaqwhen=s.nextLine();
                                    System.out.println("Enter the circumstances of Casual acquaintance");
                                    String casaqcircum=s.nextLine();
                                    System.out.println("Enter any other Useful information of Casual Acquaintance");
                                    String casaqotherinfo=s.nextLine();
                                    try 
                                    {
                                        CasualAcquaintance ca=new CasualAcquaintance(casaqnam,casaqmob,casaqemail,casaqwhen,casaqwhere,casaqcircum,casaqotherinfo);
                                        contcs.appendaq(ca);
                                        System.out.println("Casual Acquaintance added");
                                    } catch (Exception e) {
                                        System.out.println(e.getClass());
                                    }
                                }
                                else
                                    System.out.println("Wrong Input");
                                   
                            }
                    break;
                    case 2: {
                            ArrayList<Acquaintance> delacquaintance = new ArrayList<Acquaintance>();
                            System.out.println("Enter acquaintance name to be deleted  and if more than one present a list will be presented from type the index of the acquaintance in this list to be deleted");
                            String delnam = s.nextLine();
                            contcs.acqsreturn().stream().filter(e->e.name1.equals(delnam)).forEach(delacquaintance::add);
                            if (delacquaintance.isEmpty()) {
                                throw new AcquaintanceunfoundException();
                            }
                            else if (delacquaintance.size() == 1) {
                                contcs.delacq(delacquaintance.get(0));
                            } 
                            else {
                                int j = 0; 
                                while(j < delacquaintance.size()) {
                                    System.out.println(j+".)"+delacquaintance.get(j));
                                    j++;
                                }
                                System.out.println("Enter the index number of the acquaintance in the above list you want to delete");
                                try {//use the index number to delete the acquaintance
                                    if (contcs.delacq(delacquaintance.get(s.nextInt()))) {
                                        System.out.println("Acquaintance deleted");
                                    } 
                                    else {
                                        throw new AcquaintanceunfoundException();
                                    }
                                } 
                                catch (Exception e) 
                                {
                                    System.out.println(e.getClass());
                                }
                            }
                    }
                    break;
                    case 3: 
                    {
                        try 
                        {
                            contcs.acqsreturn().forEach(e->System.out.println(e.toString("name")));//displaying the list of acquaintances using a lambda expression
                        } 
                        catch (Exception e) {
                            System.out.println(e.getClass());
                        }
                    }
                    break;
                    case 4: {
                        System.out.print("Enter Relative||ProfessionalFriends||PersonalFriends||CasualAcquaintance : ");
                        String input = s.nextLine();
                        if (input.isEmpty()) {
                            input = s.nextLine();
                        }
                        switch (input) {
                            case "Relative":contcs.acqsreturn().stream().filter(e -> e instanceof Relative).forEach(e -> System.out.println((Relative) e));
                                break;
                            case "PersonalFriends":contcs.acqsreturn().stream().filter(e -> e instanceof PersonalFriends).forEach(e -> System.out.println((PersonalFriends) e));
                                break;
                            case "ProfessionalFriends":contcs.acqsreturn().stream().filter(e -> e instanceof ProfessionalFriends).forEach(e -> System.out.println((ProfessionalFriends) e));
                                break;
                            case "CasualAcquaintance":contcs.acqsreturn().stream().filter(e -> e instanceof CasualAcquaintance).forEach(e -> System.out.println((CasualAcquaintance) e));
                                break;
                            default:System.out.println("Wrong Input");
                                break;
                        }
                    }
                    break;
                        case 5:{//read data
                            try {
                                contcs = (ContactList) ReadData.read(contcs, "contcs");
                                System.out.println("###Reading data###");
                            } catch (Exception e) {
                                System.out.println(e.getClass());
                            }
                        } break;
                    case 6: {//save data
                            try 
                            {
                                SaveData.save(contcs,"contcs");
                                System.out.println("####Data saved succesfully####");
                            } 
                            catch (Exception e) {
                                System.out.println(e.getClass());
                            }
                        }
                    break;
                    case 7: 
                    {//input the acquaintance name to search based on the name using a lambda expression
                        System.out.println("Enter the name of the acquaintance to search for");
                        String input = s.nextLine();
                        contcs.acqsreturn().stream().filter(e -> e.name1.equals(input)).forEach(System.out::println);
                    }
                    break;
                    case 8:
                        System.out.println("Enter save to save data");
                        if (s.nextLine().equals("save")) {
                            try {
                                SaveData.save(contcs,"contcs");
                                System.out.println("Data Saving going on");
                            } catch (Exception e) {
                                System.out.println(e.getClass());
                            }
                        }
                        break first;
                    default:
                        System.out.println("ChoiceOutOfBoundsException");//console message printing if the chioce value is entered wrongly
                        break;
                }
            }
            catch (Exception e) {
                System.out.println(e.getClass());
            }
        }
    }
}
