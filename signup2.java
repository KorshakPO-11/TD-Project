import java.awt.Color;
import java.util.Random;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Font;

public class signup2 extends JFrame implements ActionListener{

    JTextField passwordTextField, passwordaccesTextField;
    JButton reg, cancel;
    
    


    signup2(){

        setLayout(null);

        JLabel password = new JLabel("Пароль:");
        password.setFont(new Font("Raleway", Font.BOLD, 20));
        password.setBounds(100, 140, 100, 30);
        add(password);

        passwordTextField = new JTextField();
        passwordTextField.setBounds(100, 200, 100, 30);
        add(passwordTextField);

        JLabel passwordacces = new JLabel("підтверділь пароль");
        passwordacces.setFont(new Font("Raleway", Font.BOLD, 20));
        passwordacces.setBounds(100, 240, 200, 30);
        add(passwordacces);

        passwordaccesTextField = new JTextField();
        passwordaccesTextField.setBounds(100, 300, 100, 30);
        add(passwordaccesTextField);


        JLabel cardnum  = new JLabel("Card Number:");
        cardnum.setFont(new Font("Raleway", Font.BOLD, 18));
        cardnum.setBounds(100, 340, 300, 30);
        add(cardnum);
        
        JLabel card = new JLabel("****-****-****-4184");
        card.setFont(new Font("Raleway", Font.BOLD, 18));
        card.setBounds(100, 400, 300, 30);
        add(card);

        JLabel pinlabel = new JLabel("PIN:");
        pinlabel.setFont(new Font("Raleway", Font.BOLD, 18));
        pinlabel.setBounds(100,440,200,30);
        add(pinlabel);
        
        JLabel pinnum = new JLabel("****");
        pinnum.setFont(new Font("Raleway", Font.BOLD, 18));
        pinnum.setBounds(330,500,200,30);
        add(pinnum);

        

        getContentPane().setBackground(Color.WHITE);
        
        setSize(850,850);
        setLocation(500,120);
        setVisible(true);

        reg = new JButton("Зареєструватись");
        reg.setBounds(250,720,150,30);
        reg.addActionListener(this);
        add(reg);

        cancel = new JButton("Відміна");
        cancel.setBounds(420,720,100,30);
        cancel.addActionListener(this);

        add(cancel);

    }
    public void actionPerformed(ActionEvent ae) {

        String password = passwordTextField.getText();
        String passwordacces = passwordaccesTextField.getText();
        

        Random ran = new Random();
        long first7 = (ran.nextLong() % 90000000L) + 5040936000000000L;
        String cardno = "" + Math.abs(first7);
        
        long first3 = (ran.nextLong() % 9000L) + 1000L;
        String pin = "" + Math.abs(first3);

       
       

        try{
            if(ae.getSource()== reg ){
                
                if(password.equals("")){
                    JOptionPane.showMessageDialog(null, "Введіть пароль для реєстрації");

               
                
                }if(!passwordacces.equals(password)){
                    JOptionPane.showMessageDialog(null, "Пароль не співпадає");


                }else{
                    conmysql c = new conmysql();
                    String Query1 = "insert into signup2 values('"+cardno+"','"+pin+"','"+password+"')";

                    c.s.executeUpdate(Query1); 

                    String Query2 = "insert into login values('"+cardno+"','"+password+"')";

                    c.s.executeUpdate(Query2);
                    JOptionPane.showMessageDialog(null, "Card Number: " + cardno + "\n Pin:"+ pin);
                    
                    
                }
            
            }else if(ae.getSource()==cancel){
                System.exit(0);
            }
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
    }
    

    public static void main(String[] args) {
        new signup2();
    }


}

