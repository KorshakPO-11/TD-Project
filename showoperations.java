import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class showoperations extends JFrame implements ActionListener{
 
    JButton exit, back;
    JLabel text;
    String cardno, password;
    
    showoperations(String cardno){
        super("Mini Statement");
        getContentPane().setBackground(Color.WHITE);
        setSize(400,600);
        setLocation(20,20);
        
        text = new JLabel();
        add(text);
        
        JLabel bank = new JLabel("TDPbank");
        bank.setBounds(150, 20, 100, 20);
        add(bank);
        
        JLabel cardum = new JLabel();
        cardum.setBounds(20, 80, 300, 20);
        add(cardum);
        
        JLabel balancelabel = new JLabel();
        balancelabel.setBounds(20, 400, 300, 20);
        add(balancelabel);
        
        try{
            conmysql c = new conmysql();
            ResultSet rs = c.s.executeQuery("select * from login where cardno = '"+cardno+"'");
            while(rs.next()){
                cardum.setText("Card Number:    " + rs.getString("cardno").substring(0, 4) + "XXXXXXXX" + rs.getString("cardno").substring(12));
            }
        }catch(Exception e){}
        	 
        try{
            int balance = 0;
            conmysql c  = new conmysql();
            ResultSet rs = c.s.executeQuery("SELECT * FROM bank where cardno = '"+cardno+"'");
            while(rs.next()){
                text.setText(text.getText() + "<html>"+rs.getString("date")+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");
                if(rs.getString("type").equals("Депозит")){
                    balance += Integer.parseInt(rs.getString("amount"));
                }else{
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
            balancelabel.setText("Ваш поточний баланс: "+balance+" грн.");
        }catch(Exception e){
            e.printStackTrace();
        }
        
        setLayout(null);
        exit = new JButton("Вихід");
        add(exit);
        
        exit.addActionListener(this);
        
        text.setBounds(20, 140, 400, 200);
        exit.setBounds(20, 500, 100, 25);

        back = new JButton("Назад");
        back.setBounds(200, 500, 100, 25);
        back.addActionListener(this);
        add(back);

    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == back){
            setVisible(false);
            new transactionsmenu(cardno, password).setVisible(true);
            
        }if(ae.getSource() == exit){
            setVisible(false);
            
           
        }
    }
    
    public static void main(String[] args){
        new showoperations("").setVisible(true);
    }
    
}