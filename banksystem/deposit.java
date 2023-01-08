package banksystem;



import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

import javax.swing.*;
import java.util.*;

public class deposit extends JFrame implements ActionListener{
    
    JTextField amount, pinaccept;
    
    JButton deposit, back;


    String cardno, password;

    deposit(String cardno){
        this.cardno = cardno;
       
        setLayout(null);
        

        JLabel text = new JLabel("Введіть суму для яку ви хочете покласти на карту");
        text.setForeground(Color.black);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(170, 300, 400, 20);
        add(text);

        JLabel pinac = new JLabel();
        add(pinac);

        amount = new JTextField();
        amount.setFont(new Font("Raleway", Font.BOLD, 22));
        amount.setBounds(170, 350, 320, 25);
        add(amount);

        deposit = new JButton("Покласти гроші");
        deposit.setBounds(355, 485, 150, 30);
        deposit.addActionListener(this);
        add(deposit);

        pinaccept = new JTextField();
        pinaccept.setBounds(200, 520, 150, 30);
        add(pinaccept);
        
        back = new JButton("Назад");
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);
        add(back);


        setSize(901, 900);
        setLocation(300, 0);
        setVisible(true);

        amount.addKeyListener(new KeyAdapter() {
            
            public void keyPressed(KeyEvent ke) {
              
                if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') {
                amount.setEditable(true);
                
               } else {
                amount.setEditable(false);
                JOptionPane.showMessageDialog(null, "Використання букв неприйнятно", "Помилка", JOptionPane.ERROR_MESSAGE);
               }
            }

           
        });
       

    }

    
    public void actionPerformed(ActionEvent ae) {

        
        if (ae.getSource() == deposit) {
            String number = amount.getText();
            
            Date date = new Date();
            if(number.equals("")){
                JOptionPane.showMessageDialog(null, "Введіть кількість");

            
            }else{
                try{
                    conmysql c = new conmysql();
                String pin = pinaccept.getText();
                String Query2 = "select * from login where pin = '"+pin+"'";

                
                try{
                    ResultSet rs = c.s.executeQuery(Query2);
                    if(rs.next()){
                String Query = "insert into bank values('"+cardno+"','"+pin+"', '"+date+"', 'Внесення коштів', '"+number+"')";
                c.s.executeUpdate(Query);
                JOptionPane.showMessageDialog(null, "На ваш рахунок переведено "+number+" грн. \n Операція успішно виконана");
                setVisible(false);
                new transactionsmenu(cardno, password).setVisible(true);
                    }else {
                        JOptionPane.showMessageDialog(null, "Введіть PIN-код для підтвердження операції");
                    }
                }catch (Exception e){
                    System.out.println(e);}

                }catch (Exception e){
                    System.out.println(e); 
                }
                    

            }


        }else if (ae.getSource() == back) {
            setVisible(false);
            new transactionsmenu(cardno, password).setVisible(true);
            
        }
        
     
    
    }
    

    public static void main(String args[]) {
        
        new deposit("").setVisible(true);
    }

    
}