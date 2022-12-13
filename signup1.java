import java.awt.Color;
import java.util.Random;
import javax.swing.*;
import java.awt.event.*;

import java.awt.Font;


import com.toedter.calendar.JDateChooser;

public class signup1 extends JFrame implements ActionListener{

    long random;
    JTextField nameTextField, fnameTextField, adressTextField, emailTextField, pinTextField, cityTextField, telnumberTextField;
    JButton next;
    JRadioButton male, female, married, unmarried, other;
    JDateChooser dateChooser;



    signup1() {
        setLayout(null);

        Random ran = new Random();
        long random = Math.abs((ran.nextLong() % 9000L) + 1000L);

        JLabel formnum = new JLabel("Форма номер." + random);
        formnum.setFont(new Font("Raleway", Font.BOLD, 38));
        formnum.setBounds(140, 20, 600, 40);
        add(formnum);

        JLabel personaldetails = new JLabel("Персональні дані");
        personaldetails.setFont(new Font("Raleway", Font.BOLD, 30));
        personaldetails.setBounds(290, 80, 400, 30);
        add(personaldetails);

        JLabel name = new JLabel("Ім'я:");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100, 140, 100, 30);
        add(name);

        nameTextField = new JTextField();
        nameTextField.setBounds(300, 140, 400, 30);
        add(nameTextField);

        JLabel fname = new JLabel("Прізвище:");
        fname.setFont(new Font("Raleway", Font.BOLD, 20));
        fname.setBounds(100, 190, 200, 30);
        add(fname);

        fnameTextField = new JTextField();
        fnameTextField.setBounds(300, 190, 400, 30);
        add(fnameTextField);

        JLabel dateofbirth = new JLabel("Дата народження:");
        dateofbirth.setFont(new Font("Raleway", Font.BOLD, 20));
        dateofbirth.setBounds(100, 240, 200, 30);
        add(dateofbirth);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(300, 240, 400, 30);
        dateChooser.setForeground(new Color(105, 105, 105));
        add(dateChooser);

        JLabel email = new JLabel("Електронна пошта:");
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setBounds(100, 290, 200, 30);
        add(email);

        emailTextField = new JTextField();
        emailTextField.setBounds(300, 290, 400, 30);
        add(emailTextField);

        JLabel gender = new JLabel("Стать:");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(100, 340, 200, 30);
        add(gender);

        male = new JRadioButton("Чолоівча");
        male.setBounds(300, 340, 100, 30);
        male.setBackground(Color.WHITE);
        add(male);

        female = new JRadioButton("Жіноча");
        female.setBounds(450, 340, 100, 30);
        female.setBackground(Color.WHITE);
        add(female);

        ButtonGroup gendergr = new ButtonGroup();
        gendergr.add(male);
        gendergr.add(female);

        JLabel maritalstatus = new JLabel("Сімейне положення:");
        maritalstatus.setFont(new Font("Raleway", Font.BOLD, 20));
        maritalstatus.setBounds(100, 390, 220, 30);
        add(maritalstatus);

        married = new JRadioButton("Одружений");
        married.setBounds(310, 390, 100, 30);
        married.setBackground(Color.WHITE);
        add(married);

        unmarried = new JRadioButton("не одружений");
        unmarried.setBounds(430, 390, 110, 30);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);

        other = new JRadioButton("інше");
        other.setBounds(560, 390, 100, 30);
        other.setBackground(Color.WHITE);
        add(other);

        ButtonGroup maritalstat = new ButtonGroup();
        maritalstat.add(married);
        maritalstat.add(unmarried);
        maritalstat.add(other);

        JLabel city = new JLabel("Місто:");
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(100, 440, 340, 30);
        add(city);

        cityTextField = new JTextField();
        cityTextField.setBounds(300, 440, 400, 30);
        add(cityTextField);

        JLabel adress = new JLabel("Адреса проживання:");
        adress.setFont(new Font("Raleway", Font.BOLD, 20));
        adress.setBounds(100, 490, 370, 30);
        add(adress);

        adressTextField = new JTextField();
        adressTextField.setBounds(310, 490, 400, 30);
        add(adressTextField);

        JLabel telnumber = new JLabel("Номер телефону:");
        telnumber.setFont(new Font("Номер телефону", Font.BOLD, 20));
        telnumber.setBounds(100, 540, 400, 30);
        add(telnumber);

        telnumberTextField = new JTextField();
        telnumberTextField.setBounds(300, 540, 400, 30);
        add(telnumberTextField);

        setTitle("signup");
        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
        getContentPane().setBackground(Color.white);

        JButton next = new JButton("Далі");
        next.setBounds(620, 660, 80, 30);
        next.addActionListener(this);
        

        add(next);

       
    
    }
    public void actionPerformed(ActionEvent ae) {

        

        String formnum = "" + random;
        
        String name = nameTextField.getText();
        String fname = fnameTextField.getText();
        String email = emailTextField.getText();
        String city = cityTextField.getText();
        String telnumber = telnumberTextField.getText();
        String adress = adressTextField.getText();

        String dateofbirth = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();

        String gender = null;
        if(male.isSelected()){ 
            gender = "Чоловік";
        }else if(female.isSelected()){ 
            gender = "Жінка";
        }
            
       
        String marital = null;
        if(married.isSelected()){ 
            marital = "Одружений(на)";
        }else if(unmarried.isSelected()){ 
            marital = "не одружений(на)";
        }else if(other.isSelected()){ 
            marital = "інше";
        }

       
       

        try{
            if (name.equals("")){
                JOptionPane.showMessageDialog(null, "Данні відсутні");
            

            } else {
                
            
                conmysql c = new conmysql();
                String Query = "insert into signup1 values('"+formnum+"','"+name+"','"+fname+"','"+dateofbirth+"','"+gender+"','"+email+"','"+marital+"','"+adress+"','"+city+"','"+telnumber+"')";
                c.s.executeUpdate(Query);
                setVisible(false);
                new signup2().setVisible(true);

            }

        }catch (Exception e){
            System.out.println(e);

        }
    }
        



    public static void main(String[] args) {
        new signup1();
    }
}
