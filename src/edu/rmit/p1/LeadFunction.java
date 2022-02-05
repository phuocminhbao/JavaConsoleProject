package edu.rmit.p1;



import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LeadFunction implements Function{

    public Scanner openFile(String fileName) {
        Scanner sc = null;
        try {
            sc = new Scanner(new File(fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return sc;
    }

    @Override
    public void view() {
        Scanner file = openFile("leads.csv");

        while(file.hasNext()){
            String line =  file.nextLine();
            String[] tokens = line.split(",");

            System.out.println("------------------------");
            System.out.println("Lead id: "+tokens[0].substring(5,8));
            System.out.println("Name: "+tokens[1]);
            System.out.println("Date of birth: "+tokens[2]);
            System.out.println("Gender: "+tokens[3]);
            System.out.println("Phone number: "+tokens[4]);
            System.out.println("Address: "+tokens[5]);

        }
    }


//    public void add1() {
//        try {
//            Scanner sc = new Scanner(System.in);
//            System.out.println("Enter the number of leads you want to add");
//            byte leadNum = sc.nextByte();
//            if(leadNum ==0){                            // no lead will be add
//                System.out.println("Return to the menu");
//                Main.menu();
//            }
//            if(leadNum == 1){                           // lead with 1 and leads with more than 1
//                System.out.println("Enter a lead");
//            }
//            else System.out.println("Enter leads");
//            for (int i = 1; i <= leadNum; i++){
//                System.out.println("Name: ");
//                String name = sc.next();
//                System.out.println("Gender: male or female");
//                String gender = sc.next();
//                System.out.println("Date of birth (dd/MM/yyyy)");
//                String dob = sc.next();
//                System.out.println("Phone number:");
//                String phone = sc.next();
//                System.out.println("Email: ");
//                String email = sc.next();
//                System.out.println("Address: ");
//                String address = sc.next();
//                Leads leads = new Leads( name, dob,gender, phone, email, address);
//                FileWriter fw = new FileWriter("leads.csv", true);
//                BufferedWriter bw = new BufferedWriter(fw);
//                bw.write(leads.leadIdFormat() + "," + leads.getName() + "," + dob + "," + leads.isGender() + ","  + leads.getPhone() + "," + leads.getEmail() + ","  + leads.getAddress() );
//                bw.newLine();
//                bw.close();
//            }
//
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//    }
    @Override
    public void add(){
        try{

        Scanner scanner = new Scanner(System.in);

            Leads leads = new Leads();

            System.out.print("Please enter your name: ");
            while (!leads.setName(scanner.nextLine()));

            System.out.print("Please enter your birthday (dd/MM/yyyy): ");
            while (!leads.setDob(scanner.nextLine()));

            System.out.println("Please enter your gender: ");
            while (!leads.setGender(scanner.nextLine()));

            System.out.print("Please enter your phone number: ");
            while (!leads.setPhone(scanner.nextLine()));

            System.out.print("Please enter your email address: ");
            while (!leads.setEmail(scanner.nextLine()));

            System.out.print("Please enter your address: ");
            while (!leads.setAddress(scanner.nextLine()));

            FileWriter fw = new FileWriter("leads.csv", true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(leads.leadIdFormat() + "," +
                    leads.getName() + "," +
                    leads.stringDob() + "," +
                    leads.getGender() + "," +
                    leads.getPhone() + "," +
                    leads.getEmail() + "," +
                    leads.getAddress());
            bw.newLine();
            bw.close();

        }catch (IOException e){
            e.printStackTrace();
        }

    }

    @Override
    public void delete() {

        String tempFile = "temp.csv";
        File oldFile = new File("leads.csv");
        File newFile = new File(tempFile);

        String currentLine;
        String data[];
        String id = idFind();

        try {
            FileWriter fw = new FileWriter(tempFile,true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            FileReader fr = new FileReader("leads.csv");
            BufferedReader br = new BufferedReader(fr);



            while ((currentLine = br.readLine()) != null){
                data = currentLine.split(",");
                if (!data[0].equalsIgnoreCase(id)){
                    pw.println(currentLine);
                }
            }

            pw.flush();
            pw.close();
            fr.close();
            br.close();
            bw.close();
            fw.close();

            oldFile.delete();
            File dump = new File("leads.csv");
            newFile.renameTo(dump);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    private List<Leads> Leadcheck = new ArrayList<>();

    @Override
    public void update() {
        String tempFile = "temp.csv";
        File oldFile = new File("leads.csv");
        File newFile = new File(tempFile);



        String currentLine;
        String data[];
        String id = idFind();

        try {
            FileWriter fw = new FileWriter(tempFile,true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            FileReader fr = new FileReader("leads.csv");
            BufferedReader br = new BufferedReader(fr);

            String newname;
            String newdob;
            String newgender;
            String newphone;
            String newemail;
            String newaddress;
            Scanner newdata = new Scanner(System.in);


            System.out.println("Enter name");
            newname = newdata.nextLine();
            System.out.println("Enter DOB");
            newdob = newdata.nextLine();
            System.out.println("Enter gender");
            newgender = newdata.nextLine();
            System.out.println("Enter phone");
            newphone = newdata.nextLine();
            System.out.println("Enter email");
            newemail = newdata.nextLine();
            System.out.println("Enter address");
            newaddress = newdata.nextLine();


            while ((currentLine = br.readLine()) != null){
                data = currentLine.split(",");
                if (data[0].equalsIgnoreCase(id)){
                    pw.println(id + "," + "," + newdob + "," + newgender + "," + newphone + "," + newemail + "," + newaddress);
                }
            }

            pw.flush();
            pw.close();
            fr.close();
            br.close();
            bw.close();
            fw.close();

            oldFile.delete();
            File dump = new File("leads.csv");
            newFile.renameTo(dump);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String idFind(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter an id");
        int deleteId = sc.nextInt();
        String strID;

        if(deleteId > 0 && deleteId <10){
            strID = "lead_00" + deleteId;
        }
        else if (deleteId > 9 && deleteId <100){
            strID = "lead_0" + deleteId;
        }
        else
            strID = "lead_" + deleteId;
        return strID;
    }


}
