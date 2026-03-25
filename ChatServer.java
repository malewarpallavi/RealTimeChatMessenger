import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.CopyOnWriteArraySet;

public class ChatServer {

    // Use CopyOnWriteArraySet for thread-safe operations
    private static Set<ClientHandler> clientHandlers = new CopyOnWriteArraySet<>();

    public static void main(String[] args) {
        int port = 12345;
        System.out.println("Starting chat server on port " + port + "...");

        try (ServerSocket serverSocket = new ServerSocket(port)) {

            // Start server input thread for server-side messages
            Thread serverInputThread = new Thread(() -> {
                Scanner scanner = new Scanner(System.in);
                while (true) {
                    String serverMessage = scanner.nextLine().trim();
                    if (!serverMessage.isEmpty()) {
                        broadcastMessage("Server: " + serverMessage);
                    }
                }
            });
            serverInputThread.setDaemon(true); // Allow JVM to exit if main thread exits
            serverInputThread.start();

            // Accept incoming clients
            while (true) {
                Socket clientSocket = serverSocket.accept();
                ClientHandler clientHandler = new ClientHandler(clientSocket);
                clientHandlers.add(clientHandler);
                new Thread(clientHandler).start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Broadcast message to all clients and log/print on server
    public static void broadcastMessage(String message) {
        System.out.println(message); // server terminal
        for (ClientHandler client : clientHandlers) {
            client.sendMessage(message);
        }
        logMessage(message);
    }

    private static void logMessage(String message) {
        try (FileWriter fw = new FileWriter("chat_log.txt", true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.println(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void removeClient(ClientHandler clientHandler) {
        clientHandlers.remove(clientHandler);
        System.out.println(clientHandler.getClientName() + " disconnected.");
    }
}

class ClientHandler implements Runnable {
    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;
    private String clientName;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    public String getClientName() {
        return clientName;
    }

    @Override
    public void run() {
        try {
            out = new PrintWriter(socket.getOutputStream(), true); // autoFlush
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Ask for client name
            out.println("Enter your name:");
            clientName = in.readLine().trim();
            ChatServer.broadcastMessage(clientName + " has joined the chat!");

            String message;
            while ((message = in.readLine()) != null) {
                if (message.equalsIgnoreCase("/quit")) {
                    break;
                }
                ChatServer.broadcastMessage(clientName + ": " + message);
            }
        } catch (IOException e) {
            System.out.println("Connection error with " + clientName);
        } finally {
            try {
                ChatServer.removeClient(this);
                ChatServer.broadcastMessage(clientName + " has left the chat.");
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void sendMessage(String message) {
        if (out != null) {
            out.println(message);
        }
    }
}