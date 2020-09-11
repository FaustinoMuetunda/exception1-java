/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entites;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author faust
 */
public class Reservation {

    private Integer roonNumber;
    private Date checkIn;
    private Date checkOut;

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Reservation() {
    }

    public Reservation(Integer roonNumber, Date checkIn, Date checkOut) {
        this.roonNumber = roonNumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Integer getRoonNumber() {
        return roonNumber;
    }

    public void setRoonNumber(Integer roonNumber) {
        this.roonNumber = roonNumber;
    }

    public Date getChecIn() {
        return checkIn;
    }

    public Date getChecOut() {
        return checkOut;
    }
    //conversão da duracao em dias, com base nas duas datas in e out

    public long duration() {
        long diff = checkOut.getTime() - checkIn.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }

    public String updateDates(Date checkIn, Date checkOut) {

        Date now = new Date();
        if (checkIn.before(now) || checkOut.before(now)) {

            return "Reservation dates for update must be future dates";
        }
        if (!checkOut.after(checkIn)) {

            return "Check-out date must be after check-in dates";

        }

        this.checkIn = checkIn;
        this.checkOut = checkOut;

        return null;

    }

    @Override
    public String toString() {
        return "Room "
                + roonNumber
                + ", check-in: "
                + sdf.format(checkIn)
                + ", check-out: "
                + sdf.format(checkOut)
                + ", "
                + duration()
                + " nights";
    }

}

/*
   public long duration(){
    
    
        long diff=checOut.getTime() -checOut.getTime();
        //para converter millissegundo em dias
        //o TimerUnit é uma classe de conversão de milissegundo para dias da classe java
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
        
        
    }
 */
