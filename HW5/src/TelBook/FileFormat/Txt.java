package TelBook.FileFormat;

import TelBook.Document.Contacts;

import java.io.FileWriter;
import java.io.IOException;

public class Txt extends FileFormat {

    public void saveAs(Contacts contact, String path) {
        try (FileWriter writer = new FileWriter(path + ".txt", false)) {
                writer.write("File Format - txt\n");
                writer.write(contact.getData());
                writer.flush();
            } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}

