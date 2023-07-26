import java.io.IOException;

public class official extends recipients{
    private String designation;

    public official(String name, String mail, String designation) throws IOException {
        super(name, mail);
        this.designation=designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getDesignation() {
        return designation;
    }
}
