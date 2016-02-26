/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contactList1;


import java.io.*;


public class ProfessionalFriends extends Acquaintance implements Serializable {
    public String comInterst;
    public ProfessionalFriends(String name,String email, String comInterest,Long mobileNo) throws Exception {
        super(name,email,mobileNo);
        if(comInterest.length()>100)
            throw new Exception("text greater than 100 characters!!...wrong input");
        else
            this.comInterst=comInterest;
    }
    @Override
    public String toString() {
        return super.toString()+"CommonInterests:"+this.comInterst+"\n"+"-------------------------------------------"+"\n";
    }
}