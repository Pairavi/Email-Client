import java.lang.String;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileWriter;
import java.io.IOException;


public class recipients  {
    private String name;
    private String email;
    static int recipients_num = 0;    //for counting total number of recipients

    public recipients(String name, String email) {
        this.name = name;
        this.email = email;
        recipients.recipients_num++;        // increase the recepient count by one
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public static int getRecipients_num(){
        return recipients_num;
    }

}



