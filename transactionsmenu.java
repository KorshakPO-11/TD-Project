
import java.awt.event.*;
import java.sql.ResultSet;

import javax.swing.*;

import java.awt.*;






public class transactionsmenu extends JFrame implements ActionListener{

    JLabel select, checkbalanse, text;
    JButton deposit, withdrawl, cardpinchange, passwordchange, showoperations, exit;
    
    String cardno, password;
   
    transactionsmenu(String cardno, String password){
        this.cardno = cardno;
        this.password = password;
        

        
        
        
        

        setLayout(null);

        JLabel select = new JLabel("Виберіть необхідну транзакцію");
        select.setBounds(235, 300, 700, 35);
        add(select);

        deposit = new JButton("Депозит");
        deposit.setBounds(170,499,150,35); 
        deposit.addActionListener(this);
        add(deposit);

        withdrawl = new JButton("Вивід грошей");
        withdrawl.setBounds(390,499,150,35); 
        withdrawl.addActionListener(this);
        add(withdrawl);

        cardpinchange = new JButton("Зміна паролю");
        cardpinchange.setBounds(170,543,150,35); 
        cardpinchange.addActionListener(this);
        add(cardpinchange);


        

        showoperations = new JButton("Переглянути операції");
        showoperations.setBounds(390,543,200,35); 
        showoperations.addActionListener(this);
        add(showoperations);

       

        exit = new JButton("вихід");
        exit.setBounds(170,588,150,35); 
        exit.addActionListener(this);
        add(exit);


        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);

        text = new JLabel();
        text.setForeground(Color.BLACK);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(50, 150, 400, 35);
        
        add(text);

        int balance = 0;
        try{
            conmysql c = new conmysql();
            ResultSet rs = c.s.executeQuery("select * from bank where cardno = '"+cardno+"'");
            while (rs.next()) {
                if (rs.getString("type").equals("Депозит")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        }catch(Exception e){}

        text.setText("Ваш поточний баланс "+balance+ "грн.");
        
        
        
    }
    
    public void actionPerformed(ActionEvent ae){

        if(ae.getSource() == deposit){
            setVisible(false);
            new deposit(cardno).setVisible(true);
            
        }if(ae.getSource() == withdrawl){
            setVisible(false);
            new withdrawl(cardno).setVisible(true);
        }if(ae.getSource() == exit){
            System.exit(0);
        }if(ae.getSource() == cardpinchange){
            setVisible(false);
            new passwordchange(cardno, password).setVisible(true);
       
        }if(ae.getSource() == showoperations){
            setVisible(false);
            new showoperations(cardno).setVisible(true);
        }
        }
    
    public static void main(String[] args){
        new transactionsmenu("", "");
    }
}