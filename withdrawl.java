import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class withdrawl extends JFrame implements ActionListener{
    
    
    
    
    
    JTextField amount;

    JButton withdrawl, back;

    String pin;

    withdrawl(String pin){
        this.pin = pin;
        setLayout(null);
        

        JLabel text = new JLabel("Введіть суму для зняття грошей");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(170, 300, 400, 20);
        add(text);

        amount = new JTextField();
        amount.setFont(new Font("Raleway", Font.BOLD, 22));
        amount.setBounds(170, 350, 320, 25);
        add(amount);

        withdrawl = new JButton("Зняти гроші");
        withdrawl.setBounds(355, 485, 150, 30);
        withdrawl.addActionListener(this);
        add(withdrawl);
        
        back = new JButton("Назад");
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);
        add(back);

        setSize(900, 900);
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
        if (ae.getSource() == withdrawl) {
            String number = amount.getText();
            Date date = new Date();
            if(number.equals("")){
                JOptionPane.showMessageDialog(null, "Введіть кількість");

            }else{
                try{
                conmysql c = new conmysql();
                String Query = "insert into bank values('"+pin+"', '"+date+"', 'Виведення грошей', '"+number+"')";
                c.s.executeUpdate(Query);
                JOptionPane.showMessageDialog(null, "З вашого рахунку знято "+number+" грн. \n Операція успішно виконана");
                setVisible(false);
                new transactionsmenu(pin).setVisible(true);



                }catch (Exception e){
                    System.out.println(e); 
                }
                    

            }


        }else if (ae.getSource() == back) {
            setVisible(false);
            new transactionsmenu(pin).setVisible(true);
            
        }
        
        }
    

    public static void main(String args[]) {
        new withdrawl (null);
    }
}