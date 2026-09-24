package bank.management.system;

import javax.swing.*;// swing -> java's gui widget toolkit for building desktop windows
import java.awt.*; //abstract window toolkit
import java.awt.event.*;
import java.sql.*;

// agar hamare pass koi interface hai aur hame uss interface ko implement krwate hai to uss  interface ke andr jitne bhi method hote hai usko hme ovrride karana parta hai
public class login extends JFrame implements ActionListener{
//bank.management.system.login is not abstract and does not override abstract method actionPerformed(java.awt.event.ActionEvent) in java.awt.event.ActionListener

    JButton loginButton, clear, register;
    JTextField cardTextField; JPasswordField pinTextField;

    login(){
        setTitle("ATM frame");
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("logos/atmlogo.jpg"));
        Image i2= i1.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel label= new JLabel(i3);
        label.setBounds(70,10,100,100);
        add(label);

        JLabel text = new JLabel("Welcome to ATM");
        text.setFont(new Font("Oswald",Font.BOLD, 35));
        text.setBounds(200,40,400,40);
        add(text);

        JLabel cardno = new JLabel("card no.:");
        cardno.setFont(new Font("Raleway",Font.BOLD, 22));
        cardno.setBounds(120,150,150,30);
        add(cardno);

         cardTextField= new JTextField();
        cardTextField.setBounds(300,150,230,30);
        cardTextField.setFont(new Font("Arial", Font.BOLD, 15));
        add(cardTextField);

        JLabel pin = new JLabel("pin no.:");
        pin.setFont(new Font("Raleway",Font.BOLD, 22));
        pin.setBounds(120,220,250,30);
        add(pin);

         pinTextField =new JPasswordField();
        pinTextField.setBounds(300,220,230,30);
        pinTextField.setFont(new Font("Arial", Font.BOLD, 15));
        add(pinTextField);

         loginButton = new JButton("Sign in");
        loginButton.setBounds(300,300,100,30);
        loginButton.setBackground(Color.BLACK);
        loginButton.setForeground(Color.WHITE);
        loginButton.addActionListener(this);
        add(loginButton);

         clear = new JButton("Clear");
        clear.setBounds(430,300,100,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);


         register = new JButton("Register");
        register.setBounds(300,350,230,30);
        register.setBackground(Color.BLACK);
        register.setForeground(Color.WHITE);
        register.addActionListener(this);
        add(register);

        getContentPane().setBackground(Color.WHITE);

        setSize(800,480);
        setLocation(350,200);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    @Override
    public void actionPerformed(ActionEvent aet){
        // You will handle button clicks here. For example:
        // if (aet.getActionCommand().equals("Clear")) { ... }
        if (aet.getSource()==loginButton){
            conn connection=new conn();
            String cardNumber=cardTextField.getText();
            String pinno=pinTextField.getText();
            String query="select * from login where cardnumber = '"+cardNumber+"' and pin_no = '"+pinno+"'";
            try{
                ResultSet rs=connection.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Transactions(cardNumber,pinno).setVisible(true);
                } else JOptionPane.showMessageDialog(null,"Incorrect Card Number or PIN entered.");
            } catch (Exception e) {
                System.out.println(e);
            }
        }else if(aet.getSource()==clear){
            cardTextField.setText("");
            pinTextField.setText("");
        }else if(aet.getSource()==register){
            setVisible(false);
            new signup().setVisible(true);
        }
    }
    public static void main(String[] args) {
        new login();
    }
}