package banksystem;

import java.awt.event.*;
import javax.swing.*;



public class transactionsmenu extends JFrame implements ActionListener{

    JLabel select, checkbalanse, text;
    JButton deposit, withdrawl, passwordchange, balancecheck, showoperations, exit;
    
    String cardno, password;
   
    transactionsmenu(String cardno, String password){
        this.cardno = cardno;
        this.password = password;
        
       
        
        
        setLayout(null);

        JLabel select = new JLabel("Виберіть необхідну операцію");
        select.setBounds(235, 300, 700, 35);
      
        add(select);

        deposit = new JButton("Покласти гроші");
        deposit.setBounds(170,499,150,35); 
        deposit.addActionListener(this);
        add(deposit);

        withdrawl = new JButton("Зняти готівку");
        withdrawl.setBounds(390,499,150,35); 
        withdrawl.addActionListener(this);
        add(withdrawl);

        passwordchange = new JButton("Зміна паролю");
        passwordchange.setBounds(170,543,150,35); 
        passwordchange.addActionListener(this);
        add(passwordchange);

        showoperations = new JButton("Переглянути історію операцій");
        showoperations.setBounds(390,543,270,35); 
        showoperations.addActionListener(this);
        add(showoperations);

        balancecheck = new JButton("Переглянути баланс");
        balancecheck.setBounds(390,588,270,35); 
        balancecheck.addActionListener(this);
        add(balancecheck);

       

        exit = new JButton("Вихід");
        exit.setBounds(170,588,150,35); 
        exit.addActionListener(this);
        add(exit);
        


        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
        
        }
    
    public void actionPerformed(ActionEvent ae){

        if(ae.getSource() == deposit){ //Перехід на вікно 
            setVisible(false);
            new deposit(cardno).setVisible(true);
            
        }if(ae.getSource() == withdrawl){ //Перехід на вікно зняття готівки
            setVisible(false);
            new withdrawl(cardno).setVisible(true);
        }if(ae.getSource() == exit){ //Вихід з програми
            System.exit(0);
        }if(ae.getSource() == passwordchange){ //Перехід на вікно зміни паролю
            setVisible(false);
            new passwordchange(cardno, password).setVisible(true);
       
        }if(ae.getSource() == showoperations){ //Перехід на вікно історій операцій
            setVisible(false);
            new showoperations(cardno).setVisible(true);
        }if(ae.getSource() == balancecheck){
            setVisible(false);
            new balancecheck(cardno).setVisible(true);
        }
        }
    
    public static void main(String[] args){
        new transactionsmenu("", "");
    }
}