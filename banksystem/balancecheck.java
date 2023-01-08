package banksystem;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*;


class balancecheck extends JFrame implements ActionListener {

    JTextField t1, t2;
    JButton back, exit;
    JLabel text ;
    String cardno, password;
    
    
    

    balancecheck(String cardno) {
        this.cardno = cardno;

        exit = new JButton("Вихід");
        exit.setBounds(20, 300, 100, 30);
        exit.addActionListener(this);
        add(exit);


        back = new JButton("Назад");
        back.setBounds(20, 350, 100, 30);
        back.addActionListener(this);
        add(back);


        text = new JLabel();
        text.setForeground(Color.BLACK);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(50, 150, 200, 35);
        add(text);

        int balance = 0;
        try{
            conmysql c = new conmysql();
            ResultSet rs = c.s.executeQuery("select * from bank where cardno = '"+cardno+"'");
            while (rs.next()) {
                if (rs.getString("type").equals("Внесення коштів")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        }catch(Exception e){}

        text.setText("Ваш поточний баланс "+balance+ "грн.");

      

        setSize(500, 500);
        setUndecorated(true);
        setLocation(500,200);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == back){
            setVisible(false);
            new transactionsmenu(cardno, password).setVisible(true);
        }if(ae.getSource() == exit){
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new balancecheck("").setVisible(true);
    }
}