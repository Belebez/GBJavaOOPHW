package PhoneBook;
import PhoneBook.ConsoleMenu.MyMenu;
import PhoneBook.FileFormat.Csv;
import PhoneBook.FileFormat.Txt;
import PhoneBook.Guide.Phonebook;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLOutput;


public class ServerTelBook {
    static MyMenu myMenu = new MyMenu();

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(1234)) {
            System.out.println("Сервер запущен, ожидает соединения...");
            Socket socket = serverSocket.accept();
            System.out.println("Клиент подключился");
            DataOutputStream dataOutput = new DataOutputStream(socket.getOutputStream());
            DataInputStream dataInput = new DataInputStream(socket.getInputStream());


            Phonebook.addContact("Ivan Petrov 1234");
            Phonebook.addContact("Ivannn Petrovvv 789");


            boolean flag = true;
            while (flag) {
                String clientRequest = dataInput.readUTF();
                switch (clientRequest) {
                    case "1" :
                        dataOutput.writeUTF("PhoneBook: \n" + Phonebook.listContacts() + myMenu.menuConsole());
                        break;
                    case "2" :
                        dataOutput.writeUTF(Phonebook.countContacts() + myMenu.menuConsole());
                        break;
                    case "3" :
                        //search
                        serverSearchContact(dataOutput, dataInput);
                        break;
                    case "4" :
                        // addContact
                        serverAddContact(dataOutput, dataInput);
                        break;
                    case "5" :
                        //del
                        serverRemoveContact(dataOutput, dataInput);
                        break;
                    case "6":
                        //write
                        serverSaveAs(dataOutput, dataInput);
                        break;
                    case "0" :
                        flag = false;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void serverAddContact(DataOutputStream dataOutput, DataInputStream dataInput) throws IOException {
        dataOutput.writeUTF("\nВведите Имя контакта: ");
        String firstName = dataInput.readUTF();
        dataOutput.writeUTF("\nВведите Фамилию: ");
        String lastName = dataInput.readUTF();
        dataOutput.writeUTF("\nВведите номер телефона: ");
        String phoneNum = dataInput.readUTF();
        String contact = firstName + " " + lastName + " " + phoneNum;
        Phonebook.addContact(contact);
        dataOutput.writeUTF("\nКонтакт добавлен.\n" + myMenu.menuConsole());
    }

    public static void serverSearchContact(DataOutputStream dataOutput, DataInputStream dataInput) throws IOException {
        dataOutput.writeUTF("\nВведите данные для поиска: ");
        String findString = dataInput.readUTF();
        Phonebook.searchContact(findString);
        dataOutput.writeUTF(Phonebook.listSearchContacts() + myMenu.menuConsole());
    }

    public static void serverRemoveContact(DataOutputStream dataOutput, DataInputStream dataInput) throws IOException {
        dataOutput.writeUTF("\nВведите номер телефона: ");
        String findString = dataInput.readUTF();
        dataOutput.writeUTF(Phonebook.deleteContact(Integer.parseInt(findString)) + myMenu.menuConsole());
    }

    public static void serverSaveAs (DataOutputStream dataOutput, DataInputStream dataInput) throws IOException {
        dataOutput.writeUTF(myMenu.fileFormat());
        String num = dataInput.readUTF();
        switch (num) {
            case "1" :
                dataOutput.writeUTF(myMenu.nameFileFormat());
                String nameFile = dataInput.readUTF();
                Phonebook.saveAs(nameFile, new Txt());
                dataOutput.writeUTF("\nФайл сохранён.\n" + myMenu.menuConsole());
                break;
            case "2":
                dataOutput.writeUTF(myMenu.nameFileFormat());
                String nameFile1 = dataInput.readUTF();
                Phonebook.saveAs(nameFile1, new Csv());
                dataOutput.writeUTF("\nФайл сохранён.\n" + myMenu.menuConsole());
                break;
        }
    }
}
