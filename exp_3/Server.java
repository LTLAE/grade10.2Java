import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        int port = 14514;

        try {
            // listing to ports
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Waiting for clients to connect...");
            while (true) {
                // when client connects
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected：" + clientSocket.getInetAddress());

                // create a new thread to process a connection
                ServerThread clientHandler = new ServerThread(clientSocket);
                new Thread(clientHandler).start();
            }
        } catch (IOException e) {
            e.printStackTrace();    //debug catch from ChatGPT
        }
    }

    static class ServerThread implements Runnable {
        private Socket clientSocket;

        public ServerThread(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        @Override
        public void run() {
            try {
                while (true) {
                    // receive data
                    InputStream inputStream = clientSocket.getInputStream();
                    byte[] buffer = new byte[1024];
                    String receivedData = new String(buffer, 0, inputStream.read(buffer));
                    System.out.println("Client：" + receivedData);
                    if (receivedData == "/quit") break;
                    // send data
                    OutputStream outputStream = clientSocket.getOutputStream();
                    String responseData = "Client: " + receivedData;
                    outputStream.write(responseData.getBytes());
                }
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}