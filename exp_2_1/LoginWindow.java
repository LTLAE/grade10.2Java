import java.awt.*;

public class LoginWindow extends Frame {
    public LoginWindow() {
        Label userNameLabel = new Label("Username:");
        Label passwordLabel = new Label("Password:");
        TextField usernameField = new TextField();
        usernameField.setPreferredSize(new Dimension(200,25));
        TextField passwordField = new TextField();
        passwordField.setPreferredSize(new Dimension(200,25));
        passwordField.setEchoChar('•');
        Button loginButton = new Button("Login");
        loginButton.setPreferredSize(new Dimension(100,50));

        Panel userName = new Panel();
        Panel password = new Panel();

        userName.add(userNameLabel);
        userName.add(usernameField);
        password.add(passwordLabel);
        password.add(passwordField);
        add(userName);
        add(password);
        add(loginButton);

        setLayout(new GridLayout(3,1));
        setTitle("Login");
        setSize(400, 200);
        setVisible(true);

        //Window close button listener from ChatGPT
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        new LoginWindow();
    }
}

