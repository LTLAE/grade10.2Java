import javax.swing.*;
import java.awt.*;

public class MenuWindow extends JFrame{
    public MenuWindow(){
        JMenuBar menuBar = new JMenuBar();

        JMenu File = new JMenu("File");

        JMenu Format = new JMenu("Format");
            JMenuItem Language = new JMenuItem("Language");
            JMenu molSys = new JMenu("Format");
                JMenuItem bin = new JMenuItem("Binary");
                JMenuItem oct = new JMenuItem("Octal");
                JMenuItem dec = new JMenuItem("Decimal");

        JMenu Help = new JMenu("Help");

        menuBar.add(File);

        menuBar.add(Format);
            Format.add(Language);
            Format.add(molSys);
                molSys.add(bin);
                molSys.add(oct);
                molSys.add(dec);

        menuBar.add(Help);

        setLayout(new GridLayout(8,1));
        add(menuBar);
        setTitle("Menu");
        setSize(400, 200);
        setVisible(true);



        //Window close button listener from ChatGPT
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args){
        new MenuWindow();
    }
}