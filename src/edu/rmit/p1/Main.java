package edu.rmit.p1;

import javax.print.attribute.DocAttribute;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.InputMismatchException;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileNotFoundException;



public class Main {

    public static void main(String[] args) throws ParseException {
        Leads lead = new Leads();
        Date date = new Date();
        lead.setDob("17/7/2015");
        System.out.println(lead.getDob());
        System.out.println(lead.getDob().getTime());
        int day = (int) ((date.getTime() - lead.getDob().getTime())/(1000*60*60*24));
        int age = (int)(day/365.25);
        System.out.println(age);
        System.out.println(lead.getDob().getMonth()+1 == 7);
        System.out.println(lead.getDob().getYear()+1900);
//        long date1 = 0;
//        long date2 = 0;
//        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//        date1 = sdf.parse("3/1/2000").getTime();
//        date2 = sdf.parse("22/7/2000").getTime();
//        System.out.println(date1 >= date2);
    }
}
