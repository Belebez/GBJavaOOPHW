package TelBook.Interface;

import TelBook.Document.Contacts;

public interface Saveable {

    void saveAs(Contacts contact, String path);
}
