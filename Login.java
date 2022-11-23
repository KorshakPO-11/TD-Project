import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Login extends JFrame {
    Login() {

        JLabel text = new JLabel("Welcome to TDPbank");
        text.setBounds(200, 40, 400, 40);
        text.setFont(new Font("Osward", Font.BOLD, 38));
        add(text);

        JLabel cardnum = new JLabel("num");
        cardnum.setBounds(120, 150, 150, 40);
        cardnum.setFont(new Font("Raleway", Font.BOLD, 28));
        add(cardnum);

        JLabel cardpin = new JLabel("pin");
        cardpin.setBounds(120, 220, 400, 40);
        cardpin.setFont(new Font("Raleway", Font.BOLD, 28));
        add(cardpin);

        setTitle("BMS");
        setSize(800, 500);
        setVisible(true);
        setLocation(350, 200);
    }

    public static void main(String[] args) {
        new Login();
    }
}
