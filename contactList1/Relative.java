/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contactList1;

import java.io.*;
import java.time.*;
import java.time.format.*;
public class Relative extends Acquaintance implements Serializable {
    public LocalDate bDay,lastMeetingDate;
    public Relative (String name, Long mobileNo, String email, String birthDay, String lastMeetingDate) {
        super(name, email,mobileNo);
        this.bDay = LocalDate.parse(birthDay,DateTimeFormatter.ofPattern("dd-MM-uuuu"));
        this.lastMeetingDate = LocalDate.parse(lastMeetingDate,DateTimeFormatter.ofPattern("dd-MM-uuuu"));
    }
    @Override
    public String toString() {
        return super.toString()+"Birthday:"+this.bDay.toString()+"\n"+"LastMeetingDate:"+this.lastMeetingDate.toString()+"\n"+"-------------------------------------"+"\n";
    }
}