import java.io.IOException;

public class official_friends extends official implements detailsStore{

    private String birthday;

    public official_friends(String name, String mail, String designation, String birthday) throws IOException {
        super(name, mail, designation);
        this.birthday=birthday;
    }


    @Override
    public String getBirthday() {
        return birthday;
    }

    @Override
    public String getbdaymsg() {
        return "Wish you a Happy Birthday.  ";
    }

    @Override
    public String getEmail() {
        return super.getEmail();
    }
}
