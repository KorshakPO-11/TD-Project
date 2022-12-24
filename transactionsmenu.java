
import java.awt.event.*;
import javax.swing.*;




public class transactionsmenu extends JFrame implements ActionListener{

    JLabel select, checkbalanse;
    JButton deposit, withdrawl, cardpinchange, showbalance, passwordchange, exit;
    
    String pin;
   
    transactionsmenu(String pin){
        this.pin = pin;

        
        
        
        

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

        cardpinchange = new JButton("Зміна пін коду");
        cardpinchange.setBounds(170,543,150,35); 
        add(cardpinchange);


        showbalance = new JButton("Переглянути баланс");
        showbalance.setBounds(390,543,150,35); 
        showbalance.addActionListener(this);
        add(showbalance);

       

        exit = new JButton("вихід");
        exit.setBounds(170,588,150,35); 
        add(exit);


        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);

      

        
        
        
        
    }
    
    public void actionPerformed(ActionEvent ae){

        if(ae.getSource() == deposit){
            setVisible(false);
            new deposit(pin).setVisible(true);
            
        }if(ae.getSource() == showbalance){
            setVisible(false);
            new BalanceCheck(pin).setVisible(true);
            
        }if(ae.getSource() == withdrawl){
            setVisible(false);
            new withdrawl(pin).setVisible(true);
        }
       
    }
    
    public static void main(String[] args){
        new transactionsmenu("");
    }
}