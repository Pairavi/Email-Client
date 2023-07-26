import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

class Serialization {
    static File file = new File("sentList.txt");
    public static <filename> void writeObjectToFile(ArrayList<email> Mail_list) {
        try{
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            for(email email:Mail_list){
                oos.writeObject(email);
            }
            fos.close();
            oos.close();
        } catch (IOException ex){
            ex.printStackTrace();
        }
    }


    // De-serializing 'Obj'
    public static ArrayList<email> deserialization() throws IOException {
        if (file.length() != 0) {
            ArrayList<email> Mail_list_1 = new ArrayList<>();
            Mail_list_1 = new ArrayList<>();
            email sent_mail = null;
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
//Read objects one by one
            while (true) {
                try {
                    sent_mail = (email) in.readObject();
                    Mail_list_1.add(sent_mail);
                } catch (EOFException e) {
                    break;
                }catch (ClassNotFoundException c){
                    break;
                }
            }
        }
        return email.Mails_List;
    }



//        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
//            while (true) {
//                try {
//                    email sent_mail = (email) in.readObject();
//                    Mail_list_1.add(sent_mail);
//                } catch (EOFException e) {
//                    break; // End of file reached, exit the loop
//                } catch (ClassNotFoundException | IOException c) {
//                    c.printStackTrace(); // Handle the class not found exception or IOException, or log it
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace(); // Handle or log IOExceptions that might occur
//        }
//
//        return Mail_list_1;
//    }

}