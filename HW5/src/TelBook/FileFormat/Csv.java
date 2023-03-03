package TelBook.FileFormat;

import TelBook.Document.Contacts;

import java.io.FileWriter;
import java.io.IOException;

public class Csv extends FileFormat {

    public void saveAs(Contacts contact, String path) {
        try (FileWriter writer = new FileWriter(path + ".csv", false)) {
            writer.write("File Format - csv\n");
            writer.write(contact.getData());
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
