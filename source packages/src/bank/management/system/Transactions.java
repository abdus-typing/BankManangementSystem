package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.EventListener;

public class Transactions extends JFrame implements ActionListener{
    JButton deposit,fastcash,withdrawal,ministatement, balEnquiry,pinchange,exit;
    String cardNumber, pinno;
    Transactions(String cardNumber, String pinno){
        this.cardNumber=cardNumber;
        this.pinno=pinno;
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("logos/atm.jpg"));
        Image i2= i1.getImage().getScaledInstance(900,800, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image= new JLabel(i3);
        image.setBounds(0,0,900,800);
        add(image);

        JLabel text=new JLabel("Please select your transaction");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway",Font.BOLD, 14));
        text.setBounds(235,300,700,35);
        image.add(text);

        deposit=new JButton("Deposit");
        deposit.setBounds(160,368,150,25);
        deposit.addActionListener(this);
        image.add(deposit);

        fastcash= new JButton("Fast Cash");
        fastcash.setBounds(360,368,150,25); //only gap adjusted i.e x =160+deposit width +extra
        fastcash.addActionListener(this);
        image.add(fastcash);

        withdrawal= new JButton("Cash Withdrawal");
        withdrawal.setBounds(160,399,150,25); //368+25 +extra for space(6 extra)
        withdrawal.addActionListener(this);
        image.add(withdrawal);

        ministatement= new JButton("Mini Statement");
        ministatement.setBounds(360,399,150,25); //adjusted to side with fast cash
        ministatement.addActionListener(this);
        image.add(ministatement);

        balEnquiry=new JButton("Balance Enquiry");
        balEnquiry.setBounds(160,430,150,25); //below above two rows therefore y adjusted
        balEnquiry.addActionListener(this);
        image.add(balEnquiry);

        pinchange=new JButton("Change PIN");
        pinchange.setBounds(360,430,150,25);
        pinchange.addActionListener(this);
        image.add(pinchange);

        exit=new JButton("Exit");
        exit.setBounds(360,461,150,25); //430(prev)+25+6
        exit.addActionListener(this);
        image.add(exit);

        setSize(900,740);
        setLocation(300,20);
        setUndecorated(true);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==exit){
            System.exit(0);
        } else if (ae.getSource()==deposit) {
            setVisible(false);
            new Deposit(cardNumber,pinno).setVisible(true);
        } else if(ae.getSource()==withdrawal){
            setVisible(false);
            new Withdraw(cardNumber,pinno).setVisible(true);
        } else if(ae.getSource()==fastcash){
            setVisible(false);
            new fastCash(cardNumber,pinno).setVisible(true);
        } else if(ae.getSource()==pinchange){
            setVisible(false);
            new changePIN(cardNumber,pinno).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Transactions("","");
    }
}
