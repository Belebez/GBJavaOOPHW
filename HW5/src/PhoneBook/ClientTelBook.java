package PhoneBook;

import PhoneBook.ConsoleMenu.MyMenu;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientTelBook {
    static MyMenu myMenu = new MyMenu();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String request;

        try (Socket socket = new Socket("localhost", 1234)) {
            DataOutputStream dataOutput = new DataOutputStream(socket.getOutputStream());
            DataInputStream dataInput = new DataInputStream(socket.getInputStream());

            System.out.print(myMenu.menuConsole());

            while (true) {
                request = sc.next();
                dataOutput.writeUTF(request);
                if("0".equals(request)) {
                    System.out.println("Good Bye!");
                    break;
                }
                System.out.println(dataInput.readUTF());
            }

        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
