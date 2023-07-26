import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.lang.String;


public class Email_Client {
    //getting current date
    static Date date = new Date();
    static SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
    static String strDate = formatter.format(date);


    public static void main(String[] args) throws Exception {
//creating birthday subject
        String birthday_subject = "birthday wishes";

//creating array lists to store information
        ArrayList<recipients> people = new ArrayList<>();
        ArrayList<detailsStore> birthday_people = new ArrayList<>();

        file_writer File_writer = new file_writer();
        File_writer.fileExistence("clientList.txt"); // checking existence of file


        FileReader fileReader = new FileReader("clientList.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        for (String file_record = bufferedReader.readLine(); file_record != null; file_record = bufferedReader.readLine(
        )) {
            String[] splitRecord = file_record.split(": ");
            if (splitRecord.length == 2) {
                String type = splitRecord[0];
                String details = splitRecord[1];
                String[] record = details.split(",");


                if (Objects.equals(type, "Official")) {
                    official person_1 = new official(record[0], record[1], record[2]);
                    people.add(person_1);
                } else if (Objects.equals(type, "Office_friend")) {
                    official_friends person_2 = new official_friends(record[0], record[1], record[2], record[3]);
                    people.add(person_2);
                    birthday_people.add(person_2);
                } else if (Objects.equals(type, "Personal")) {
                    personal person_3 = new personal(record[0], record[1], record[2], record[3]);
                    people.add(person_3);
                    birthday_people.add(person_3);
                }
            }
        }


        Scanner scanner = new Scanner(System.in);
        System.out.println("Please wait!");

        System.out.println(("put your valid mail and password in email.java in line 51,52"));



        // Send birthday emails only once at the beginning of the program
            for (detailsStore t : birthday_people) {
                if (t.getBirthday().substring(5).equals(strDate.substring(5))) {
                    email mail = new email(strDate, t.getEmail(), birthday_subject, t.getbdaymsg());
                    mail.send_email();
                    email.addMails(mail);
                    Serialization.writeObjectToFile(email.Mails_List);
                }
            }

        boolean exitFlag = false;
        while (!exitFlag) {
            System.out.println("Enter option type: \n"
                    + "1 - Adding a new recipient\n"
                    + "2 - Sending an email\n"
                    + "3 - Printing out all the recipients who have birthdays\n"
                    + "4 - Printing out details of all the emails sent\n"
                    + "5 - Printing out the number of recipient objects in the application");

                String optionInput = scanner.nextLine();

                switch (optionInput) {
                    case "1":
                        Scanner scanner1 = new Scanner(System.in);
                        System.out.println("Enter the details in the following format \n"
                                + "Official: name,email,designation\n"
                                + "Office_friend: name,email,designation,birthday\n"
                                + "Personal: name,nick-name,email,birthday");

                        String recipient = scanner1.nextLine();

                        file_writer obj = new file_writer();
//add the details of recipient to clientList file
                        obj.WriteFile(recipient);
                        System.out.println("Successfully updated......!");
                        break;

                    case "2":
// input format - email, subject, content
// code to send an email
                        Scanner scanner2 = new Scanner(System.in);
                        System.out.println("Enter the details in the following format \n"
                                + "email,subject,content");
                        String e_mail, subject, content;
                        String line;
                        String[] lineVector;

                        line = scanner2.nextLine(); //read 1,2,3

//separate all values by comma
                        lineVector = line.split(",");

                        try {
                            e_mail = lineVector[0];
                            subject = lineVector[1];
                            content = lineVector[2];
                            email mail = new email(strDate, e_mail, subject, content);
                            mail.send_email();
                        } catch (ArrayIndexOutOfBoundsException e) {
                            System.out.println("Invalid Input");
                        }
                        break;

                    case "3":
// input format - yyyy/MM/dd (ex: 2018/09/17)
// code to print recipients who have birthdays on the given date
                        Scanner scanner3 = new Scanner(System.in);
                        System.out.println("Enter the date in the following format\n"
                                + "input format - yyyy/MM/dd (ex: 2018/09/17)");
                        String given_birthday_date = scanner3.nextLine();

//comparing the birthday date with specified input date
                        for (detailsStore k : birthday_people) {
                            if (Integer.parseInt(given_birthday_date.substring(0, 4)) > Integer.parseInt(k.getBirthday().substring(
                                    0, 4))) {
                                if (given_birthday_date.substring(5).equals(k.getBirthday().substring(5))) {
                                    System.out.println(k.getName());
                                }
                            }
                        }
                        break;

                    case "4":
                        System.out.println("Enter the date in the following format\n"
                                + "input format - yyyy/MM/dd (ex: 2018/09/17)");
                        String given_date = scanner.nextLine();
                        ArrayList<email> mailsArrayList = Serialization.deserialization();

                        // Create a flag to check if any email is found for the given date
                        boolean emailFound = false;

                        for (email mail : mailsArrayList) {
                            if (given_date.equals(mail.getDate())) {
                                System.out.println("Subject: " + mail.getSubject());
                                System.out.println("Content: " + mail.getContent());
                                System.out.println("Receiver Mail address: " + mail.getMail());
                                emailFound = true;
                            }
                        }

                        // Check if any email was found for the given date
                        if (!emailFound) {
                            System.out.println("No emails found for the given date.");
                        }
                        break;


                    case "5":
// code to print the number of recipient objects in the application
                        System.out.println("Number of recipients is : " + recipients.getRecipients_num());
                        break;
                    case "exit":
                        exitFlag = true;
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                        break;
            }
            System.out.println("Program successfully completed....!!");
        }
    }
}