package School;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ServerSchool {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String request;

        try (Socket socket = new Socket("localhost", 1234)) {
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());

            while (true) {
                System.out.println("Введите сообщение...");
                request = sc.nextLine();
                dataOutputStream.writeUTF(request);
                if("end".equals(request)) break;
                System.out.println("Получили от сервера: " + dataInputStream.readUTF());
            }


        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
