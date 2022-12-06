import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener {

    JButton login, signup, clear;
    JTextField cardNumField, cardPinField;
    JPasswordField pinTexField;

    Login() {

        setLayout(null);

        JLabel text = new JLabel("Welcome to TDPbank");
        text.setBounds(200, 40, 400, 40);
        text.setFont(new Font("Osward", Font.BOLD, 38));
        add(text);

        getContentPane().setBackground(Color.WHITE);

        JLabel cardnum = new JLabel("num");
        cardnum.setBounds(120, 150, 150, 40);
        cardnum.setFont(new Font("Raleway", Font.BOLD, 28));
        add(cardnum);

        cardNumField = new JTextField();
        cardNumField.setBounds(200, 150, 250, 40);
        add(cardNumField);

        JLabel cardpin = new JLabel("pin");
        cardpin.setBounds(120, 220, 400, 40);
        cardpin.setFont(new Font("Raleway", Font.BOLD, 28));
        add(cardpin);

        cardPinField = new JPasswordField();
        cardPinField.setBounds(200, 220, 250, 40);
        add(cardPinField);

        login = new JButton("sign in");
        login.setBounds(300, 300, 100, 30);
        login.addActionListener(this);
        add(login);

        clear = new JButton("clear");
        clear.setBounds(430, 300, 100, 30);
        clear.addActionListener(this);
        add(clear);

        signup = new JButton("sign up");
        signup.setBounds(300, 350, 230, 30);
        signup.addActionListener(this);
        add(signup);

        setTitle("BMS");
        setSize(800, 500);
        setVisible(true);
        setLocation(350, 200);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == clear) {
            cardNumField.setText("");
            cardPinField.setText("");

        } else if (ae.getSource() == login) {

        } else if (ae.getSource() == signup) {

        }

    }

    public static void main(String[] args) {
        new Login();
    }
}
