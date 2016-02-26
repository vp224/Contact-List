/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contactList1;

import java.io.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
public class PersonalFriends extends Acquaintance implements Serializable {
    public String context,specificEvents;
    public LocalDate acquaintanceDate;
    public PersonalFriends(String name,String email,String specificEvents,String context,String acquaintanceDate,Long mobno) throws Exception {
        super(name,email,mobno);
        if(context.length()>100)
            throw new Exception("text greater than 100 characters!!...wrong input");//if the characters exceed 100 characters throw an exception
        else
            this.specificEvents = specificEvents;
        if(context.length()>100)
            throw new Exception("text greater than 100 characters!!...wrong input");//if the characters exceed 100 characters throw an exception
        else
            this.context = context;
        this.acquaintanceDate = LocalDate.parse(acquaintanceDate,DateTimeFormatter.ofPattern("dd-MM-uuuu"));
    }
    @Override
    public String toString() {
        return super.toString()+"Context:"+this.context+"\n"+"Acquaintance date of personal friend:"+this.acquaintanceDate.toString()+"\n"+"Specific Events:"+this.specificEvents+"\n"+"------------------------------------------";
    }
}

