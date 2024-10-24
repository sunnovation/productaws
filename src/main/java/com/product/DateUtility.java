package com.product;


import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;

public class DateUtility {

    public static LocalDate exiryDate() {
        Calendar clndr=Calendar.getInstance();
        clndr.add(Calendar.DAY_OF_MONTH, 4);
        clndr.add(Calendar.DAY_OF_YEAR, 3);
        clndr.add(Calendar.DAY_OF_WEEK, 3);
        SimpleDateFormat dateFormat=new SimpleDateFormat("dd-MM-yyyy");
        dateFormat.format(clndr.getTime());
        LocalDate expDt=clndr.getTime().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        return  expDt;

    }

}
