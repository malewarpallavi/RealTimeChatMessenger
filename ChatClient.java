import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ChatClient {
    public static void main(String[] args) {
        String hostname = "localhost";
        int port = 12345;

        try (Socket socket = new Socket(hostname, port);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             Scanner scanner = new Scanner(System.in)) {

            // Thread to read messages from server
            Thread readThread = new Thread(() -> {
                try {
                    String serverMessage;
                    while ((serverMessage = in.readLine()) != null) {
                        System.out.println(serverMessage);
                    }
                } catch (IOException e) {
                    System.out.println("Disconnected from server.");
                }
            });
            readThread.start();

            // Main thread to send messages
            while (true) {
                String message = scanner.nextLine();
                out.println(message);
                if (message.equalsIgnoreCase("/quit")) {
                    break;
                }
            }

        } catch (IOException e) {
            System.out.println("Server not found or not responding.");
        }
    }
}