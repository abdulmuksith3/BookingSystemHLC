/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookingsystemhlc;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTime {
    /*
    @return Mon, 2021-02-31 
    */
    public String getDateTimeString(String dateTime) {
        String res = "";

        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E, yyyy-MM-dd HH:mm");
        LocalDateTime localDT = LocalDateTime.parse(dateTime, dateFormat);
        res = localDT.format(formatter);

        return res;
    }
    
    public String getNumericDateString(String dateTime) {
        String res = "";
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd");
        LocalDateTime localDT = LocalDateTime.parse(dateTime, dateFormat);
        res = localDT.format(formatter);
//        System.out.println(res + "+++++++++++");

        return res;
    }

    public String getDayString(String dateTime) {
        String res = "";

        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E");
        LocalDateTime localDT = LocalDateTime.parse(dateTime, dateFormat);
        res = localDT.format(formatter);
//        System.out.println(res);

        return res;
    }

    public String getDayMonthYearString(String dateTime) {
        String res = "";

        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
        LocalDateTime localDT = LocalDateTime.parse(dateTime, dateFormat);
        res = localDT.format(formatter);
//        System.out.println(res);

        return res;
    }

    public String getTimeString(String dateTime) {
        String res = "";

        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalDateTime localDT = LocalDateTime.parse(dateTime, dateFormat);
        res = localDT.format(formatter);
//        System.out.println(res);

        return res;
    }

    public String getShortTimeString(String dateTime) {
        String res = "";

        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalDateTime localDT = LocalDateTime.parse(dateTime, dateFormat);
        res = localDT.format(formatter);
//        System.out.println(res);

        return res;
    }

    public String getDateString(String dateTime) {
        String res = "";

        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd");
        LocalDateTime localDT = LocalDateTime.parse(dateTime, dateFormat);
        res = localDT.format(formatter);
//        System.out.println(res);

        return res;
    }

    public String getDateTimeShortString(String dateTime) {
        String res = "";

        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E, yyyy-MM-dd HH:mm");
        LocalDateTime localDT = LocalDateTime.parse(dateTime, dateFormat);
        res = localDT.format(formatter);
//        System.out.println(res);

        return res;
    }

    public String getLongDate(String date, String time) {
        String res = "";
        String finalDate = date + " " + getShortTimeString(time);
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("E, dd-MMM-yyyy HH:mm:ss");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime localDT = LocalDateTime.parse(finalDate, dateFormat);
        res = localDT.format(formatter);
//        System.out.println(res);

        return res;
    }

    public String addHour(String dateTime) {
//        System.out.println("dateTime ----- " + dateTime);
        String res = "";

        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalDateTime localDT = LocalDateTime.parse(dateTime, dateFormat).plusHours(1);
        res = localDT.format(formatter);
//        System.out.println(res);/

        return res;
    }

    public String getOfficeHourString(String dateTime) {
        //        System.out.println("dateTime ----- " + dateTime);
        String res = getDateTimeShortString(dateTime) + " - " + addHour(dateTime);
//        System.out.println("resssss " + res);

        return res;
    }

    public String getOfficeHourShortString(String dateTime) {
        //        System.out.println("dateTime ----- " + dateTime);
        String res = getDayString(dateTime) + ", " + getTimeString(dateTime) + " - " + addHour(dateTime);
//        System.out.println("resssss " + res);

        return res;
    }

    public String getOfficeHourDate(String dateTime, int i) {
        String res = "";

        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E, dd-MMM-yyyy");
        LocalDateTime localDT = LocalDateTime.parse(dateTime, dateFormat).plusWeeks(i);
        res = localDT.format(formatter);
//        System.out.println(res + "-------------");
        return res;
    }

    public String getOfficeHourLongDate(String dateTime, int i) {
        String res = "";

        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime localDT = LocalDateTime.parse(dateTime, dateFormat).plusWeeks(i);
        res = localDT.format(formatter);
//        System.out.println(res + "-------------");
        return res;
    }

    public String getOfficeTimeString(String dateTime, int i) {
        String res = "";
        LocalDateTime localDTStart = null, localDTEnd = null;
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

        switch (i) {
            case 1:
                localDTStart = LocalDateTime.parse(dateTime, dateFormat).plusMinutes(0);
                localDTEnd = LocalDateTime.parse(dateTime, dateFormat).plusMinutes(20);
                break;
            case 2:
                localDTStart = LocalDateTime.parse(dateTime, dateFormat).plusMinutes(20);
                localDTEnd = LocalDateTime.parse(dateTime, dateFormat).plusMinutes(40);
                break;
            case 3:
                localDTStart = LocalDateTime.parse(dateTime, dateFormat).plusMinutes(40);
                localDTEnd = LocalDateTime.parse(dateTime, dateFormat).plusMinutes(60);
                break;
        }

        res = localDTStart.format(formatter) + " - " + localDTEnd.format(formatter);

        return res;
    }

    public int getBookingSlot(String dateTime) {
        int res = 0;
        // Receives 16:00 - 16:20 splits by "-" then splits again by ":" to get the end time minutes
        String endMinutes = dateTime.split(" - ")[1].split(":")[1];

        if (endMinutes.equals("20")) {
            res = 1;
        } else if (endMinutes.equals("40")) {
            res = 2;
        } else if (endMinutes.equals("00")) {
            res = 3;
        }

        return res;
    }
    
    public int getRow(String time) {
        int res = 1;

        if (time.equals("16:00")) {
            res = 2;
        } else if (time.equals("17:00")) {
            res = 3;
        } else if (time.equals("18:00")) {
            res = 4;
        } else if (time.equals("19:00")) {
            res = 5;
        }

        return res;
    }
    
    public int getBookingWeek(String dateTime) {
        int res = 0;
        int numericDate = Integer.parseInt(getNumericDateString(dateTime));
        if (numericDate <= 7) {
            res = 1;
        } else if (numericDate <= 14) {
            res = 2;
        } else if (numericDate <= 21) {
            res = 3;
        } else {
            res = 4;
        }

        return res;
    }
}
