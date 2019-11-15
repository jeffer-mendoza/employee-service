package com.fonyou.employee.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class ActiveTimeUtil {

    private Calendar inicio;
    private Calendar fin;

    public ActiveTimeUtil(Date dateStart, Date dateEnd, int month, int year) throws ParseException {
        inicio = new GregorianCalendar();
        fin = new GregorianCalendar();
        Calendar query = new GregorianCalendar(year, month - 1, 30);
        inicio.setTime(dateStart);
        if(dateEnd != null && dateEnd.before(query.getTime())) {
            fin.setTime(dateEnd);
        } else {
            fin = query;
        }
    }

    private int totalMonths() {
        int difA = fin.get(Calendar.YEAR) - inicio.get(Calendar.YEAR);
        return (difA * 12 + fin.get(Calendar.MONTH) - inicio.get(Calendar.MONTH)) + 1 ;
    }

    public int calculateTotalDays() {
        return totalMonths() * 30 - inicio.get(Calendar.DAY_OF_MONTH) - (30 - fin.get(Calendar.DAY_OF_MONTH) + 1);
    }

}
