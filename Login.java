import java.awt.Font;

import javax.swing.*;



import java.awt.Color;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

    JButton login, signup;
    JTextField cardnoField, passwordTextField;
    JPasswordField passwordField;
    

    Login() {

        setLayout(null);

        JLabel text = new JLabel("Welcome to TDPbank");
        text.setBounds(200, 40, 400, 40);
        text.setFont(new Font("Osward", Font.BOLD, 38));
        add(text);

        getContentPane().setBackground(Color.darkGray);

        JLabel cardno = new JLabel("Номер карти");
        cardno.setBounds(120, 150, 200, 40);
        cardno.setFont(new Font("Raleway", Font.BOLD, 28));
        add(cardno);

        cardnoField = new JTextField();
        cardnoField.setBounds(300, 150, 250, 40);
        add(cardnoField);

        JLabel password = new JLabel("Пароль");
        password.setBounds(120, 220, 400, 40);
        password.setFont(new Font("Raleway", Font.BOLD, 28));
        add(password);

        passwordTextField = new JPasswordField();
        passwordTextField.setBounds(300, 220, 250, 40);
        add(passwordTextField);

        login = new JButton("Увійти");
        login.setBounds(300, 300, 100, 30);
        login.addActionListener(this);
        add(login);

        signup = new JButton("Зареєструватись");
        signup.setBounds(300, 350, 100, 30);
        signup.addActionListener(this);
        add(signup);

        setTitle("BMS");
        setSize(800, 500);
        setVisible(true);
        setLocation(350, 200);

    }

    public void actionPerformed(ActionEvent ae) {
        try{
        
        if (ae.getSource() == login) {
            conmysql c = new conmysql();
            String cardno = cardnoField.getText();
            String password = passwordTextField.getText();
            
            String Query = "select * from login where cardno = '"+cardno+"' and password = '"+password+"' ";
            try{
                ResultSet rs = c.s.executeQuery(Query);
                if(rs.next()){
                    setVisible(false);
                    new transactionsmenu(cardno, password).setVisible(true);
                
                }else{
                    JOptionPane.showMessageDialog(null, "Не вірний номер карти чи пароль");
                }

            }catch (Exception e){
                System.out.println(e);
            }
            

        } else if (ae.getSource() == signup) {
            setVisible(false);
            new signup1().setVisible(true);

        }

        }catch (Exception e){
            System.out.println(e);
        }

    }

    public static void main(String[] args) {
        new Login();
    }
}
