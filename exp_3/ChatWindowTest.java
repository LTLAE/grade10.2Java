import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

class ChatWindowTest extends Frame {
    public static void main(String[] args){
        ChatWindowTest window = new ChatWindowTest();
        window.ShowNewMsg("12345");

    }
    Label friendName = new Label("TestUser");
    TextArea MSGArea = new TextArea("You have joined the Chatroom" + "\n");
    TextField messageSend = new TextField();
    Button sendButton = new Button("Send");
    Panel sendArea = new Panel();

    public ChatWindowTest() {
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
                    while (true) {
                        // send data
                        OutputStream outputStream = socket.getOutputStream();
                        // Scanner scanner = new Scanner(System.in);
                        // String requestData = scanner.nextLine();
                        String requestData = messageSend.getText();
                        if (requestData == "/quit") break;  //if user inputs "/quit", close client
                        outputStream.write(requestData.getBytes());
                        messageSend.setText("");
                    }
                    socket.close();
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