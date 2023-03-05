package PhoneBook.Guide;
import PhoneBook.FileFormat.FileFormat;

import java.util.HashMap;
import java.util.Map;


public class Phonebook {

    private static HashMap<Integer, Contact> phonebookList = new HashMap<>();
    private static HashMap<Integer, Contact> phonebookSerchList = new HashMap<>();

    public static String listContacts(){
        if (phonebookList.size() == 0) {
            return "\nСправочник пуст\n";
        }else {
            return phonebookList.values().toString();
        }
    }

    public static String listSearchContacts(){
        if (phonebookSerchList.size() == 0) {
            return "\nПоиск не дал резульатата по этим параметрам поиска.\n";
        }else {
            return phonebookSerchList.values().toString();
        }
    }

    public static String countContacts(){
        if (phonebookList.size() == 0) {
            return "\nСправочник пуст\n";
        }else if (phonebookList.size() == 1){
            return String.format("\nВ справочнике %d контакт.\n", phonebookList.size());
        } else if (phonebookList.size() > 1 && phonebookList.size() < 5){
            return String.format("\nВ справочнике %d контакта.\n", phonebookList.size());
        } else {
            return String.format("\nВ справочнике %d контактов.\n", phonebookList.size());
        }
    }


    // create
    public static void addContact(String s) {
        String[] string = s.split(" ");
        int id = phonebookList.size();
        for (int i = id + 1; i < id + 2; i++) {
            phonebookList.put(i, new Contact(string));
        }
    }

    // find

    public static void searchContact(String s) {
        int id = 0;
        if (Character.isDigit(s.charAt(0))) {
            int phoneNum = Integer.parseInt(s);
            for (Contact contact: phonebookList.values()) {
                if (phoneNum == contact.getPhoneNumber()) {
                    phonebookSerchList.put(id, contact);
                    id++;
                }
            }
        } else if (Character.isLetter(s.charAt(0))){
            for (Contact contact: phonebookList.values()) {
                if ((contact.getFirstName().toLowerCase().contains(s.toLowerCase()))||
                        (contact.getLastName().toLowerCase().contains(s.toLowerCase()))) {
                    phonebookSerchList.put(id, contact);
                    id++;
                }
            }
        }
    }

    // delete
    public static String deleteContact(int phoneNum) {
        if (phonebookList.size() == 0) {
            return "Справочник пуст...";
        } else {
            for (Map.Entry<Integer, Contact> contact: phonebookList.entrySet()) {
                if (contact.getValue().getPhoneNumber() == phoneNum) {
                    phonebookList.remove(contact.getKey());
                    Phonebook.setPhonebookList(phonebookList);
                    return "\nКонтакт удалён.\n";
                }
            }
        }
        return "Такого номера телефона нет в справочнике.";
    }

    public static void setPhonebookList(HashMap<Integer, Contact> phonebookList) {
        Phonebook.phonebookList = phonebookList;
    }

        public static void saveAs(String path, FileFormat format) {
        format.saveAs(phonebookList, path);
    }

}
