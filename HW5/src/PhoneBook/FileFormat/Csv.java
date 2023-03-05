package PhoneBook.FileFormat;

import PhoneBook.Guide.Phonebook;
import PhoneBook.Guide.Contact;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class Csv extends FileFormat {

    public void saveAs(HashMap<Integer, Contact> contact, String path) {
        try (FileWriter writer = new FileWriter(path + ".csv", false)) {
            writer.write("File Format - csv\n");
            writer.write(Phonebook.listContacts().toString());
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
