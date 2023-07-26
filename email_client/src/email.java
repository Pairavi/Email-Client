import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Properties;

public class email implements Serializable {
    public static String date;
    public static String Mail;
    public static String subject;
    public static String content;
    static ArrayList<email> Mails_List=new ArrayList<>();

    public email(String date, String Mail, String subject, String content){
        this.date=date;
        this.Mail=Mail;
        this.subject=subject;
        this.content=content;
    }

    @Override
    public String toString() {
        return "Date: " + date + "\nMail: " + Mail + "\nSubject: " + subject + "\nBody: " + content;
    }

    public static ArrayList<email> addMails(email mails){
        Mails_List.add(mails);
        return Mails_List;
    }

    public String getDate() {
        return date;
    }

    public String getMail() {
        return Mail;
    }

    public String getSubject() {
        return subject;
    }

    public String getContent() {
        return content;
    }

    public static void send_email() throws Exception{
        System.out.println("Preparing to send email");

        final String myaccountEmail = "uththara1126@gmail.com";
        final String password = "opbxwqelhooie";

        //get the session object
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");



        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myaccountEmail, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myaccountEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(Mail));
            message.setSubject(subject);
            message.setText(content+"\n"+"\nT.Pairavi");

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }

}
