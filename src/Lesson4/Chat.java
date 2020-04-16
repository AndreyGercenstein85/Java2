package Lesson4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Chat extends JFrame {
    private String screenName;

    JPanel jpN = new JPanel(new GridLayout());
    JPanel jpS = new JPanel(new GridLayout());

    JButton jb = new JButton("send");
    JTextArea chatArea = new JTextArea(8,40);
    JScrollPane jsp = new JScrollPane(chatArea);
    JTextField jtf = new JTextField();
    JMenuBar mainMenu = new JMenuBar();


    Chat(String screenName) {
        this.screenName = screenName;
        setSize(400, 400);
        setTitle("Chat Client 1.0: [" + screenName + "]");
        setMinimumSize(new Dimension(400, 400));

        chatArea.setLineWrap(true);
        chatArea.setEditable(false);
        jb.addActionListener(e -> {
            if(jtf.getText().length() != 0)
            sendMessage();
        });
        jtf.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER && jtf.getText().length() != 0) sendMessage();
            }
        });

        jpN.add(jsp);
        jpS.add(jtf);
        jpS.add(jb);

        add(jpN);
        add("South", jpS);

        setJMenuBar(mainMenu);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    void sendMessage() {
        String out = jtf.getText();
        chatArea.setEditable(false);
        chatArea.setBackground(Color.LIGHT_GRAY);
        chatArea.append("[" + screenName + "]: " + getTime() + ": " + out + "\n");
        jtf.setText("");
        jtf.grabFocus();
    }

    public String getTime() {
        return new SimpleDateFormat("HH:mm:ss").format(new Date());
    }

    public static void main(String[] args) {
        new Chat("Andrey");
    }
}
