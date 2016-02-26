/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contactList1;

import java.io.*;


public class Acquaintance implements Serializable {
    protected String name1,email1;
    protected Long mobno1;
    
    public Acquaintance(String name,String email,Long mobno) {
        name1 = name;
        email1 = email;
        mobno1=mobno;
    }
    public String toString(String property) {
        if(property.equals("name")) 
            return name1;
        else if(property.equals("mobno"))
            return Long.toString(mobno1);
        else if(property.equals("email"))
            return email1;
        return "Name:"+name1 +"\n"+"Mobile No:"+mobno1 +"\n"+"Email:"+email1+"\n";
    }
    @Override
    public String toString() {
        return "Name:"+name1+"\n"+"Mobile No:"+mobno1 +"\n"+"Email:"+email1+"\n";
    }
}
