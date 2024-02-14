import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;



public class ClientMain {
    public static void main(String[] args) {
        Thread receive = new Thread(new ClientReceive());
        receive.run();
    }
}

class ChatWindow extends Frame {
    Label friendName = new Label("TestUser");
    TextArea MSGArea = new TextArea("You have joined the Chatroom" + "\n");
    TextField messageSend = new TextField();
    Button sendButton = new Button("Send");
    Panel sendArea = new Panel();

    public ChatWindow() {
        messageSend.setPreferredSize(new Dimension(800, 100));
        sendButton.setPreferredSize(new Dimension(100, 50));

        sendArea.add(messageSend);
        sendArea.add(sendButton);
        sendArea.setPreferredSize(new Dimension(1000, 100));

        sendButton.addActionListener(new ActionListener() { //when send button clicked
            @Override
            public void actionPerformed(ActionEvent d) {
                try {
                    Socket socket = new Socket("localhost", 14514);
                    // send data
                    OutputStream outputStream = socket.getOutputStream();
                    // Scanner scanner = new Scanner(System.in);
                    // String requestData = scanner.nextLine();
                    ShowNewMsg("Me: " + messageSend.getText());
                    String requestData = messageSend.getText();
                    outputStream.write(requestData.getBytes());
                    messageSend.setText("");

                } catch (IOException e) {
                    e.printStackTrace();    //debug catch from ChatGPT
                }
            }
        });

        setLayout(new BorderLayout());
        add(friendName, BorderLayout.NORTH);
        add(MSGArea, BorderLayout.CENTER);
        add(sendArea, BorderLayout.SOUTH);

        setTitle("Welcome Computer Science 233 Longtail Eralbrunia 114514 to the Chatroom.");
        setSize(1000, 800);
        setVisible(true);
        //Window close button listener from ChatGPT
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                System.exit(0);
            }
        });
    }

    public void ShowNewMsg(String input) {
        String currentText = MSGArea.getText();
        currentText = currentText + "\n" + input;
        MSGArea.setText(currentText);
    }
}

class ClientReceive implements Runnable {
    public void run() {
        ChatWindow windowOP = new ChatWindow();
        try {
            Socket socket = new Socket("localhost", 14514);
            while (true) {
                // send data
                // OutputStream outputStream = socket.getOutputStream();
                // Scanner scanner = new Scanner(System.in);
                // String requestData = scanner.nextLine();
                // if(requestData == "/quit")  break;  //if user inputs "/quit", close client
                // outputStream.write(requestData.getBytes());

                // receive data
                InputStream inputStream = socket.getInputStream();
                byte[] buffer = new byte[1024];
                String responseData = new String(buffer, 0, inputStream.read(buffer));
                // System.out.println(responseData);
                windowOP.ShowNewMsg(responseData);

            }

        } catch (IOException e) {
            e.printStackTrace();    //debug catch from ChatGPT
        }
    }
}