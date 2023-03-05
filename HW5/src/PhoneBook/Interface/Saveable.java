package PhoneBook.Interface;

import PhoneBook.Guide.Contact;

import java.util.HashMap;

public interface Saveable {

    void saveAs(HashMap<Integer, Contact> contact, String path);
}
