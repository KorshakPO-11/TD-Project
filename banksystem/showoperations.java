package banksystem;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class showoperations extends JFrame implements ActionListener{
 
    JButton exit;
    JLabel text;
    String cardno, password;
    showoperations(String cardno){
        super("Operations history");
        getContentPane().setBackground(Color.WHITE);
        setSize(400,600);
        setLocation(20,20);
        
        text = new JLabel();
        add(text);
        
        JLabel l2 = new JLabel("TDP Bank");
        l2.setBounds(150, 20, 100, 20);
        add(l2);
        
        JLabel l3 = new JLabel();
        l3.setBounds(20, 80, 300, 20);
        add(l3);
        
        JLabel l4 = new JLabel();
        l4.setBounds(20, 400, 300, 20);
        add(l4);
        
        try{
            conmysql c = new conmysql();
            ResultSet rs = c.s.executeQuery("select * from login where cardno = '"+cardno+"'");
            while(rs.next()){
                l3.setText("Card Number:    " + rs.getString("cardno").substring(0, 4) + "XXXXXXXX" + rs.getString("cardno").substring(12));
            }
        }catch(Exception e){}
        	 
        try{
            int balance = 0;
            conmysql c  = new conmysql();
            ResultSet rs = c.s.executeQuery("select * from bank where cardno = '"+cardno+"'");
            while(rs.next()){
                text.setText(text.getText() + "<html>"+rs.getString("date")+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");
                if(rs.getString("type").equals("Внесення коштів")){  //&nbsp нерозривний пробіл для розділення рядків з історією
                    balance += Integer.parseInt(rs.getString("amount"));
                }else{
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
            l4.setText("На вашому балансі "+balance+" грн");
        }catch(Exception e){
            e.printStackTrace();
        }
        
        setLayout(null);

        exit = new JButton("Вихід");
        exit.setBounds(20, 500, 100, 25);
        exit.addActionListener(this);
        add(exit);

        
        
        text.setBounds(20, 140, 400, 200);
        
    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == exit){
            System.exit(0);
        }
    }
    
    public static void main(String[] args){
        new showoperations("").setVisible(true);
    }
    
}