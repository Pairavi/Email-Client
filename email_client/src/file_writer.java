import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class file_writer {
    public File fileExistence(String url) throws IOException {
        File file = new File(url);
        if (file.exists()==false)
            file.createNewFile();
        return file;
    }

    public void WriteFile(String data) {

        try{
            FileWriter fileWriter=new FileWriter(fileExistence("clientList.txt"),true);
            BufferedWriter writer=new BufferedWriter(fileWriter);

            writer.write(data);
            writer.newLine();
            writer.flush();
            writer.close();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}