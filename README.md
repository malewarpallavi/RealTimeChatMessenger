# Real-Time Chat Messenger

A robust, Java-based Peer-to-Peer (P2P) communication system leveraging **TCP/IP Socket Programming**. This application enables real-time text-based messaging between multiple concurrent clients with persistent server-side logging for audit trails.

## 🚀 Key Features
* **Multi-Threaded Architecture:** Utilizes Java Threads to handle multiple client connections simultaneously without blocking the communication flow.
* **Real-Time Broadcasting:** Implements a server-side broadcast mechanism that distributes messages to all active peers instantly.
* **Persistent Chat Logging:** Automatically records all conversation history with timestamps into a `chat_log.txt` file for future reference and data integrity.
* **Platform Independence:** Built entirely in Core Java, ensuring the application runs seamlessly across Windows, Linux, and macOS (JRE compatible).
* **Lightweight & Scalable:** Optimized network overhead using custom packet structures and efficient I/O stream handling.

## 🛠️ Tech Stack
* **Language:** Java (JDK 8+)
* **Networking:** Java Sockets (TCP/IP)
* **Concurrency:** Java Multithreading (Thread Class & Runnable Interface)
* **File Handling:** Java I/O Streams (`BufferedWriter`, `PrintWriter`)

## 📂 Project Structure
```text
RealTimeChatMessenger/
├── ChatServer.java      # Handles client connections and message broadcasting
├── ChatClient.java      # User interface for sending and receiving messages
├── chat_log.txt         # Auto-generated log file for session history
└── README.md            # Project documentation
