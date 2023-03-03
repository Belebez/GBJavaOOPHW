package TelBook;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientTelBook {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String request;

        try (Socket socket = new Socket("localhost", 1234)) {
            DataOutputStream dataOutput = new DataOutputStream(socket.getOutputStream());
            DataInputStream dataInput = new DataInputStream(socket.getInputStream());


            boolean flag = true;
            while (flag) {
                System.out.print("\nТелефонный справочник\n \nВыберите пункт:\n" +
                        "1. Показать cправочник.\n" +
                        "2. Количество контактов.\n" +
                        "3. Найти контакт.\n" +
                        "4. Добавить контакт.\n" +
                        "5. Удалить контакт.\n" +
                        "6. Добавить справочник.\n" +
                        "\n" +
                        "0. Выход\n");
                System.out.print("\nВведите номер задачи --> ");
                request = sc.next();
                dataOutput.writeUTF(request);
                if("0".equals(request)) {
                    System.out.println("Good Bye!");
                    flag = false;
                }
                System.out.println("Получили от сервера: " + dataInput.readUTF());

            }


        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
