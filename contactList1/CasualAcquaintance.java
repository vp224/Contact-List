/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contactList1;

import java.io.*;
import java.time.LocalDate;
import java.time.format.*;
public class CasualAcquaintance extends Acquaintance implements Serializable {
    public String place1,situation,othrUseInf;
    public LocalDate casaqdate;
    public CasualAcquaintance(String name,Long mobileNo, String email,String date, String place, String circumstances,String otherUsefulInfo) throws Exception {
       super(name,email,mobileNo);
       this.casaqdate = LocalDate.parse(date,DateTimeFormatter.ofPattern("dd-MM-uuuu"));
        if(place.length()>100)
           throw new Exception("text greater than 100 characters!!...wrong input");
        else
           place1 = place;            
        if(circumstances.length()>100)
           throw new Exception("text greater than 100 characters!!...wrong input");
        else
           situation= circumstances;
        if(otherUsefulInfo.length()>100)
           throw new Exception("text greater than 100 characters!!...wrong input");
        else
           othrUseInf = otherUsefulInfo;
    }
    @Override
    public String toString() {
        return super.toString()+"Casual acquaintance date:"+this.casaqdate.toString()+"\n"+"Place of meeting:"+place1+"\n"+"Circumstances:"+situation+"\n"+"OtherUsefulInfo"+othrUseInf+"\n"+"-----------------------------"+"\n";
    }
}
