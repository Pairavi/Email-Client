public class personal extends recipients implements detailsStore{
    private String nickname;
    private String birthday;

    public personal(String name, String nickname, String email, String birthday) {
        super(name, email);
        this.nickname=nickname;
        this.birthday=birthday;
    }


    public String getNickname() {
        return nickname;
    }

    public String getBirthday() {
        return birthday;
    }

    @Override
    public String getbdaymsg() {
        return "hugs and love on your birthday.  ";
    }
}

