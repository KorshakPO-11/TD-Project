package banksystem;


import java.awt.*;
import java.awt.event.*;
import java.util.regex.Pattern;

import javax.swing.*;


public class passwordchange extends JFrame implements ActionListener{
    String cardno, password;
    JButton changepin, back;
    JTextField passwordTextField, passwordaccesTextField;
    

    passwordchange(String cardno, String password){
        this.cardno = cardno;
        this.password = password;

        setLayout(null);

        JLabel text = new JLabel("Зміна паролю");
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(100,330,800,35);
        text.setForeground(Color.black);
        add(text);

        JLabel newpassword = new JLabel("Новий пароль:");
        newpassword.setFont(new Font("Raleway", Font.BOLD, 20));
        newpassword.setBounds(100, 140, 200, 30);
        add(newpassword);

        passwordTextField = new JTextField();
        passwordTextField.setBounds(100, 200, 100, 30);
        add(passwordTextField);

        JLabel passwordacces = new JLabel("Підтверділь пароль");
        passwordacces.setFont(new Font("Raleway", Font.BOLD, 20));
        passwordacces.setBounds(100, 240, 200, 30);
        add(passwordacces);

        passwordaccesTextField = new JTextField();
        passwordaccesTextField.setBounds(100, 300, 100, 30);
        add(passwordaccesTextField);
        

        changepin = new JButton("Змінити пароль");
        changepin.setBounds(100,370,150,35);
        changepin.addActionListener(this);
        add(changepin);       

        back = new JButton("Назад");
        back.setBounds(100, 420, 150, 35);
        back.addActionListener(this);
        add(back);


        setSize(660,808);
        setLocation(500,0);
        
        setVisible(true);



}
public void actionPerformed(ActionEvent ae){

    try{
        String newpassword = passwordTextField.getText();
        String passwordacces = passwordaccesTextField.getText();

        if(!newpassword.equals(passwordacces)){ //Перевірка співпадіння парою 
            JOptionPane.showMessageDialog(null, "Пароль не співпадає");
            return;

        }if(ae.getSource() == changepin){ //Перевірка на придатність паролю
            if (!(Pattern.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$", newpassword))) {
                JOptionPane.showMessageDialog(null, "Введіть прийнятний пароль", "Помилка", JOptionPane.ERROR_MESSAGE);
                return;
            
            
            }
            if (newpassword.equals("")){
                JOptionPane.showMessageDialog(null, "Введіть пароль");
            }
            if (passwordacces.equals("")){
                JOptionPane.showMessageDialog(null, "Підтвердіть новий пароль");
            }
            conmysql c = new conmysql(); 
            //Внесення нових даних в базу даних
            String Query1 = "update login set password = '"+newpassword+"' where password = '"+password+"'";
            String Query2 = "update signup2 set password = '"+newpassword+"' where password = '"+password+"'";
           
            c.s.executeUpdate(Query1);
            c.s.executeUpdate(Query2);

            JOptionPane.showMessageDialog(null, "Пароль успішно змінено");
                setVisible(false);
                new transactionsmenu(cardno, newpassword).setVisible(true);
            }else if (ae.getSource() == back) { //Повернення на вікно транзакцій 
                setVisible(false);
                new transactionsmenu(cardno, password).setVisible(true);
                
            }

    }catch (Exception e){
        System.out.println(e);
    }
}

public static void main(String[] args){
    new passwordchange("","").setVisible(true);
}
}