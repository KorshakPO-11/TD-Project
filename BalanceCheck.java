import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*;


class BalanceCheck extends JFrame implements ActionListener {

    
    JButton back;
    JLabel text;
    String pin;

    BalanceCheck(String pin) {
        this.pin = pin;
        setLayout(null);


        text = new JLabel();
        text.setForeground(Color.black);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(50, 150, 400, 35);
       
        add(text);

        
        
        back = new JButton("Назад");
        back.addActionListener(this);
        back.setBounds(50,250 ,100, 35);
        add(back);

        

        

        int balance = 0;
        try{
            conmysql c = new conmysql();
            ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pin+"'");
            while (rs.next()) {
                if (rs.getString("type").equals("Депозит")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        }catch(Exception e){}
        
       

        text.setText("Ваш поточний баланс "+balance+ "грн.");

        setSize(400, 500);
        
        setLocation(500, 0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new transactionsmenu(pin).setVisible(true);
    }

    public static void main(String[] args) {
        new BalanceCheck("").setVisible(true);
    }
}