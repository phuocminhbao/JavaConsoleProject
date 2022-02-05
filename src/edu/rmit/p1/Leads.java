package edu.rmit.p1;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.time.format.DateTimeFormatter;
public class Leads {
    private static int leadId =0 ;
    private String name;
    private Date dob;
    private boolean gender;
    private String phone;
    private String email;
    private String address;
    final static String DATE_FORMAT = "dd/MM/yyyy";



    public int getLeadId() {
        return leadId;

    }

    public Leads(){
        leadId++;
    }

    public String leadIdFormat(){
        String IdFormat = null;
        String IdFormat1 = Integer.toString(leadId);
        if(leadId > 0 && leadId <10){
            IdFormat = "lead_00" + leadId;
        }
        else if (leadId > 9 && leadId <100){
            IdFormat = "lead_0" + leadId;
        }
        else
            IdFormat = "lead_" + IdFormat1;
        return IdFormat;
    }


    public String getName() {
        return name;
    }

    public boolean setName (String name){
        String constraint = "([A-Z][a-z]*)(\\s[A-Z][a-z]*)*";
        if (name.matches(constraint)) {
            this.name = name;
            return true;
        }
        System.out.println("Please enter a valid name !!!");
        return false;
    }

    public Date getDob() {
        return dob;
    }

    public boolean setDob(String dob) {
            Date date ;
            try {
                DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
                dateFormat.setLenient(false);
                date = dateFormat.parse(dob);
            } catch (ParseException e) {
    //            e.printStackTrace();
                System.out.println("Date entered must be in the format dd/MM/yyyy !!!");
                return false;
            }

            this.dob = date;
            return true;
    }

    public String stringDob(){
        DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
        return dateFormat.format(dob);
    }

    public boolean getGender() {
        return gender;
    }

    public boolean setGender(String gender) {
        String isGender =gender.toLowerCase();
        if(isGender.contentEquals("male")){
            this.gender = true;
            return true;
        }
        if(isGender.contentEquals("female")){
            this.gender = false;
            return true;
        }
        System.out.println("Please enter a valid gender !!!");
        return false;

    }

    public String getPhone() {
        return phone;
    }

    public boolean setPhone(String phone) {
        String constraint = "[0-9]{10}";
        if (phone.matches(constraint)) {
            this.phone = phone;
            return true;
        }
        System.out.println("Please enter a valid phone number !!!");
        return false;
    }

    public String getEmail() {
        return email;
    }

    public boolean setEmail(String email) {
        String constraint = "^([a-z0-9_.])+\\@(([a-z0-9-])+\\.)+([a-z0-9]{2,4})+$";
        if (email.matches(constraint)) {
            this.email = email;
            return true;
        }
        System.out.println("Please enter a valid email address !!!");
        return false;
    }

    public String getAddress() {
        return address;
    }

    public boolean setAddress(String address) {
        if (address.trim().hashCode() == 0) {
            System.out.println("The address field cannot be empty !!!");
            return false;
        }
        this.address = address;
        return true;
    }

    public void increaseID(){
            leadId++;
    }

    @Override
    public String toString() {
        return "Leads{" +
                "name='" + name + '\'' +
                ", dob=" + dob +
                ", gender=" + gender +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public String showLead(){
        return name + "," + dob + "," + gender + "," + phone + "," + email + "," + address;
    }

}
