package TelBook.Application;

import TelBook.Document.Contacts;

import java.util.ArrayList;
import java.util.List;

public class Notepad {
    private List<Contacts> contactsList;
    private int index;

    public Notepad() {
        contactsList = new ArrayList<>();
        index = -1;
    }

    public void newContact() {
        contactsList.add(new Contacts());
        index++;
    }



}
