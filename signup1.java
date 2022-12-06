import java.awt.Color;
import java.util.Random;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

import java.awt.Font;

import com.toedter.calendar.JDateChooser;

public class signup1 extends JFrame {

    signup1() {
        setLayout(null);

        Random ran = new Random();
        long random = Math.abs((ran.nextLong() % 9000L) + 1000L);

        JLabel formnum = new JLabel("aplication form num." + random);
        formnum.setFont(new Font("Raleway", Font.BOLD, 38));
        formnum.setBounds(140, 20, 600, 40);
        add(formnum);

        JLabel personaldetails = new JLabel("Personal details");
        personaldetails.setFont(new Font("Raleway", Font.BOLD, 30));
        personaldetails.setBounds(290, 80, 400, 30);
        add(personaldetails);

        JLabel name = new JLabel("Ім'я:");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100, 140, 100, 30);
        add(name);

        JTextField nameJTextField = new JTextField();
        nameJTextField.setBounds(300, 140, 400, 30);
        add(nameJTextField);

        JLabel fname = new JLabel("Прізвище:");
        fname.setFont(new Font("Raleway", Font.BOLD, 20));
        fname.setBounds(100, 190, 200, 30);
        add(fname);

        JTextField fnameJTextField = new JTextField();
        fnameJTextField.setBounds(300, 190, 400, 30);
        add(fnameJTextField);

        JLabel dateofbirth = new JLabel("Дата народження:");
        dateofbirth.setFont(new Font("Raleway", Font.BOLD, 20));
        dateofbirth.setBounds(100, 240, 200, 30);
        add(dateofbirth);

        JDateChooser dateChooser = new JDateChooser();
        dateChooser.setBounds(300, 240, 400, 30);
        dateChooser.setForeground(new Color(105, 105, 105));
        add(dateChooser);

        JLabel email = new JLabel("Електронна пошта:");
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setBounds(100, 290, 200, 30);
        add(email);

        JTextField emailJTextField = new JTextField();
        emailJTextField.setBounds(300, 290, 400, 30);
        add(emailJTextField);

        JLabel gender = new JLabel("Стать:");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(100, 340, 200, 30);
        add(gender);

        JRadioButton male = new JRadioButton("Чолоівча");
        male.setBounds(300, 340, 100, 30);
        male.setBackground(Color.WHITE);
        add(male);

        JRadioButton female = new JRadioButton("Жіноча");
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

        JRadioButton married = new JRadioButton("Одружений");
        married.setBounds(310, 390, 100, 30);
        married.setBackground(Color.WHITE);
        add(married);

        JRadioButton unmarried = new JRadioButton("не одружений");
        unmarried.setBounds(430, 390, 110, 30);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);

        JRadioButton other = new JRadioButton("інше");
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

        JTextField cityJTextField = new JTextField();
        cityJTextField.setBounds(300, 440, 400, 30);
        add(cityJTextField);

        JLabel adress = new JLabel("Адреса проживання:");
        adress.setFont(new Font("Raleway", Font.BOLD, 20));
        adress.setBounds(100, 490, 370, 30);
        add(adress);

        JTextField adressJTextField = new JTextField();
        adressJTextField.setBounds(310, 490, 400, 30);
        add(adressJTextField);

        JLabel pin = new JLabel("ПІН код:");
        pin.setFont(new Font("Raleway", Font.BOLD, 20));
        pin.setBounds(100, 540, 400, 30);
        add(pin);

        JTextField pinJTextField = new JTextField();
        pinJTextField.setBounds(300, 540, 400, 30);
        add(pinJTextField);

        setTitle("signup");
        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
        getContentPane().setBackground(Color.white);

        JButton next = new JButton("Далі");
        next.setBounds(620, 660, 80, 30);
        add(next);

    }

    public static void main(String[] args) {
        new signup1();
    }
}
