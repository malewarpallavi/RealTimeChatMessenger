# Real-Time Chat Messenger

A Java-based **client-server communication system** using **TCP/IP Socket Programming**. The application enables text-based messaging between a client and server through a TCP connection.

## 🚀 Key Features

* **TCP/IP Communication:** Uses Java `Socket` and `ServerSocket` for client-server communication.
* **Client-Server Messaging:** Client sends messages to the server, and the server sends responses back to the client.
* **Stream-Based Communication:** Uses Java I/O streams such as `BufferedReader` and `PrintStream` for sending and receiving messages.
* **Platform Independence:** Built using Core Java and standard Java networking APIs.

## 🏗️ Project Architecture

The application follows a **client-server architecture**.

The client establishes a TCP connection with the server using a socket. The server listens for a connection using `ServerSocket`, accepts the client connection, and communicates with the client through input and output streams.

### System Architecture

```text
                    TCP/IP Connection
                         Port 5100
                            │
                            │
             ┌──────────────┴──────────────┐
             │                             │
             ▼                             ▼
      ┌──────────────┐             ┌──────────────┐
      │    Client    │             │    Server    │
      │              │             │              │
      │   Client.java│             │  Server.java │
      │              │             │              │
      │   Socket     │◄───────────►│ ServerSocket │
      │              │             │              │
      └──────────────┘             └──────────────┘
             │                             │
             │                             │
             ▼                             ▼
      Input / Output                Input / Output
          Streams                      Streams
```

### 🔄 Communication Flow

```text
1. Server starts
       │
       ▼
2. ServerSocket listens on port 5100
       │
       ▼
3. Client creates Socket connection
       │
       ▼
4. Server accepts the connection
       │
       ▼
5. Client sends message
       │
       ▼
6. Server receives and displays message
       │
       ▼
7. Server sends response
       │
       ▼
8. Client receives and displays response
```

### 📡 Message Flow

The current implementation follows a simple request-response communication model:

```text
        Client                         Server
          │                              │
          │──── "Hello Server" ─────────►│
          │                              │
          │                              │
          │◄──── "Hello Client" ─────────│
          │                              │
          │──── "How are you?" ─────────►│
          │                              │
          │◄──── "I am fine" ────────────│
          │                              │
```

The communication continues until the client enters `"end"`.

## 🛠️ Tech Stack

* **Language:** Java
* **Networking:** Java Sockets, TCP/IP
* **I/O:** `BufferedReader`, `PrintStream`, `InputStreamReader`
* **Architecture:** Client-Server

## 📂 Project Structure

```text
RealTimeChatMessenger/
├── Client.java          # Connects to the server and sends/receives messages
├── Server.java          # Accepts the client connection and responds to messages
└── README.md            # Project documentation
```

## ▶️ How to Run

### 1. Compile the Server

```bash
javac Server.java
```

### 2. Compile the Client

```bash
javac Client.java
```

### 3. Start the Server

Run the server first:

```bash
java Server
```

The server will wait for a client connection on port `5100`.

### 4. Start the Client

Open another terminal and run:

```bash
java Client
```

The client will connect to the server and the chat session can begin.

## 💻 Example

### Server

```text
Server is Waiting at Port no 5100
Server Successfully connected with client

-------------------Server Messenger ready to Chat-------------------

Client Say: Hello Server
Enter msg for Client:
Hello Client
```

### Client

```text
Client is ready to Connect with Server........
Client is Connected Successfully....

-------------------Client Messenger ready to Chat-------------------

Enter Your Msg For Server:
Hello Server

Server say: Hello Client
```

## 📌 Current Limitations

The current version is intentionally a basic implementation of socket-based communication.

* Supports one client connection at a time.
* Does not currently use multiple threads.
* Does not currently support broadcasting between multiple clients.
* Does not currently implement user authentication.
* Does not currently use a database for message storage.
* Chat history is not persisted by the current implementation.

## 🔮 Future Enhancements

The project can be extended with:

* Multiple client support
* Java multithreading
* Message broadcasting
* Private messaging
* Usernames
* Persistent chat logging
* Database-based message storage
* Authentication
* TLS/SSL encryption
* Improved message protocol

## 👩‍💻 Author

**Pallavi Omprakash Malewar**

## 📄 License

This project is developed for educational and learning purposes.
