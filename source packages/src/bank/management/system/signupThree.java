package bank.management.system;

import javax.swing.*;
import java.awt.*;

public class signupThree extends JFrame{
    JRadioButton Saving, current, fd, recurring;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit, cancel;
    signupThree(){
        setLayout(null);
        JLabel l1= new JLabel("Page 3: Account details:");
        l1.setFont(new Font("Raleway", Font.BOLD, 22));
        l1.setBounds(250,40,400,40);
        add(l1);
        JLabel type= new JLabel("Account Type:");
        type.setFont(new Font("Raleway", Font.BOLD,20));
        type.setBounds(100,120,150,40);
        add(type);

        Saving =new JRadioButton("Saving Account");
        Saving.setFont(new Font("Raleway", Font.BOLD, 16));
        Saving.setBounds(280, 120, 150,40);
        add(Saving);
        current =new JRadioButton("Current Account");
        current.setFont(new Font("Raleway", Font.BOLD, 16));
        current.setBounds(430, 120, 150,40);
        add(current);
        fd =new JRadioButton("Fixed Deposit Account");
        fd.setFont(new Font("Raleway", Font.BOLD, 16));
        fd.setBounds(280, 160, 200,40);
        add(fd);
        recurring =new JRadioButton("Recurring Account");
        recurring.setFont(new Font("Raleway", Font.BOLD, 16));
        recurring.setBounds(480, 160, 170,40);
        add(recurring);
        ButtonGroup actype= new ButtonGroup();
        actype.add(Saving); actype.add(current); actype.add(fd); actype.add(recurring);


        JLabel cardno=new JLabel("Card Number:");
        cardno.setFont(new Font("Raleway", Font.BOLD, 20));
        cardno.setBounds(100,240,150,40);
        add(cardno);
        JLabel cnum=new JLabel("(Your 16-digit Card Number)");
        cnum.setFont(new Font("Raleway", Font.BOLD, 12));
        cnum.setBounds(100,275,250,15);
        add(cnum);
        JLabel cnumber=new JLabel("XXXX-XXXX-XXXX-1512");
        cnumber.setFont(new Font("Raleway", Font.BOLD, 20));
        cnumber.setBounds(280,240,400,40);
        add(cnumber);

        JLabel pin_no=new JLabel("Pin No.:");
        pin_no.setFont(new Font("Raleway", Font.BOLD, 20));
        pin_no.setBounds(100, 300, 150, 40);
        add(pin_no);
        JLabel pnum=new JLabel("(Your 4-digit password)");
        pnum.setFont(new Font("Raleway", Font.BOLD, 12));
        pnum.setBounds(100,330,250,15);
        add(pnum);
        JLabel pin_pass= new JLabel("XXXX");
        pin_pass.setFont(new Font("Raleway", Font.BOLD, 20));
        pin_pass.setBounds(280,300,400,40);
        add(pin_pass);

        JLabel servicesReq=new JLabel("Services Required:");
        servicesReq.setFont(new Font("Raleway", Font.BOLD, 18));
        servicesReq.setBounds(100, 370, 200, 40);
        add(servicesReq);
        c1=new JCheckBox("Debit Card");
        c1.setFont(new Font("Raleway", Font.BOLD, 16));
        c1.setBounds(100,420,200,30);
        add(c1);
        c2=new JCheckBox("Credit Card");
        c2.setFont(new Font("Raleway",Font.BOLD, 16));
        c2.setBounds(300,420,200,30);
        add(c2);
        c3=new JCheckBox("Mobile Banking");
        c3.setFont(new Font("Raleway",Font.BOLD, 16));
        c3.setBounds(100,460,200,30);
        add(c3);
        c4=new JCheckBox("Internet Banking");
        c4.setFont(new Font("Raleway", Font.BOLD, 16));
        c4.setBounds(300,460,200,30);
        add(c4);
        c5=new JCheckBox("Passbook");
        c5.setFont(new Font("Raleway", Font.BOLD, 16));
        c5.setBounds(100,500,200,30);
        add(c5);
        c6=new JCheckBox("Cheque Book");
        c6.setFont(new Font("Raleway", Font.BOLD, 16));
        c6.setBounds(300,500,200,30);
        add(c6);
        c7=new JCheckBox("E-Mail & SMS Alerts");
        c7.setFont(new Font("Raleway", Font.BOLD, 16));
        c7.setBounds(100,540,200,30);
        add(c7);

        JCheckBox c8= new JCheckBox("I hereby declare that the given details are true to the extent of my knowledge.");
        c8.setFont(new Font("Raleway",Font.BOLD, 14));
        c8.setBounds(100,620,600,20);
        add(c8);

        submit= new JButton("Submit");
        submit.setForeground(Color.WHITE);
        submit.setBackground(Color.BLACK);
        submit.setBounds(640,700,100,30);
        submit.setFont(new Font("Raleway", Font.BOLD,14));
        add(submit);

        cancel= new JButton("Cancel");
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.BLACK);
        cancel.setBounds(520,700,100,30);
        cancel.setFont(new Font("Raleway", Font.BOLD,14));
        add(cancel);


        setSize(820,800);
        setLocation(350,5);
        setVisible(true);

    }
    public static void main(String args[]){
        new signupThree();
    }
}
