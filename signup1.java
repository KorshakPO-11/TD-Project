import java.awt.Color;
import java.util.Random;
import javax.swing.JTextField;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;

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
        nameJTextField.setBounds(300, 140, 400, 20);
        add(nameJTextField);

        JLabel fname = new JLabel("Прізвище:");
        fname.setFont(new Font("Raleway", Font.BOLD, 20));
        fname.setBounds(100, 160, 200, 30);
        add(fname);

        JTextField fnameJTextField = new JTextField();
        fnameJTextField.setBounds(300, 160, 400, 20);
        add(fnameJTextField);

        JLabel dateofbirth = new JLabel("Дата народження:");
        dateofbirth.setFont(new Font("Raleway", Font.BOLD, 20));
        dateofbirth.setBounds(100, 180, 200, 30);
        add(dateofbirth);

        JLabel gender = new JLabel("Стать:");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(100, 200, 200, 30);
        add(gender);

        JLabel email = new JLabel("Електронна пошта:");
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setBounds(100, 220, 200, 30);
        add(email);

        JTextField emailJTextField = new JTextField();
        emailJTextField.setBounds(300, 220, 400, 20);
        add(emailJTextField);

        JLabel maritalstatus = new JLabel("Сімейне положення:");
        maritalstatus.setFont(new Font("Raleway", Font.BOLD, 20));
        maritalstatus.setBounds(100, 240, 220, 30);
        add(maritalstatus);

        JLabel city = new JLabel("Місто:");
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(100, 260, 220, 30);
        add(city);

        JTextField cityJTextField = new JTextField();
        cityJTextField.setBounds(300, 260, 400, 20);
        add(cityJTextField);

        JLabel adress = new JLabel("Адреса проживання:");
        adress.setFont(new Font("Raleway", Font.BOLD, 20));
        adress.setBounds(100, 280, 220, 30);
        add(adress);

        JTextField adressJTextField = new JTextField();
        adressJTextField.setBounds(300, 280, 400, 20);
        add(adressJTextField);

        JLabel pin = new JLabel("ПІН код:");
        pin.setFont(new Font("Raleway", Font.BOLD, 20));
        pin.setBounds(100, 300, 220, 30);
        add(pin);

        JTextField pinJTextField = new JTextField();
        pinJTextField.setBounds(300, 300, 400, 20);
        add(pinJTextField);

        setTitle("signup");
        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
        getContentPane().setBackground(Color.white);

    }

    public static void main(String[] args) {
        new signup1();
    }
}
