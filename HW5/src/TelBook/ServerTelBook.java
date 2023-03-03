package TelBook;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTelBook {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(1234)) {
            System.out.println("Сервер запущен, ожидает соединения...");
            Socket socket = serverSocket.accept();
            System.out.println("Клиент подключился");
            DataOutputStream dataOutput = new DataOutputStream(socket.getOutputStream());
            DataInputStream dataInput = new DataInputStream(socket.getInputStream());

            boolean flag = true;
            while (flag) {
                String clientRequest = dataInput.readUTF();
                switch (clientRequest) {
                    case "1" :
                        dataOutput.writeUTF("Ответ от сервера к клиенту: " + clientRequest);
                        break;
                    case "2" :
                        dataOutput.writeUTF("Ответ от сервера к клиенту: " + clientRequest);
                        break;
                    case "3" :
                        dataOutput.writeUTF("Ответ от сервера к клиенту: " + clientRequest);
                        break;
                    case "4" :
                        dataOutput.writeUTF("Ответ от сервера к клиенту: " + clientRequest);
                        break;
                    case "5" :
                        dataOutput.writeUTF("Ответ от сервера к клиенту: " + clientRequest);
                        break;
                    case "6":
                        dataOutput.writeUTF("Ответ от сервера к клиенту: " + clientRequest);
                        break;
                    case "0" :
                        flag = false;


                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
