package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.date;
import java.sql.*;
public class Deposit extends JFrame implements ActionListener{
    JTextField amt;
    JButton deposit, back;
    String pinno, cardnumber;
    Deposit(String cardnumber,String pinno){
        this.cardnumber=cardnumber;
        this.pinno=pinno;
        setLayout(null);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("logos/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,800,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,800);
        add(image);

        JLabel text=new JLabel("Enter deposit amount:");
        text.setBounds(170,282,200,30);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Oswald", Font.PLAIN,14));
        image.add(text);

        amt=new JTextField("");
        amt.setBounds(330,285,180,30);
        amt.setFont(new Font("Raleway",Font.BOLD,12));
        image.add(amt);

        deposit=new JButton("Deposit");
        deposit.setBounds(410,403,100,25);
        deposit.addActionListener(this);
        image.add(deposit);

        back=new JButton("Back");
        back.setBounds(410,432,100,25);
        back.addActionListener(this);
        image.add(back);

        setSize(900,740);
        setLocation(300,10);
        setUndecorated(true);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==deposit){
            String number = amt.getText();
            Date date=new Date();
            if(number.isEmpty()){
                JOptionPane.showMessageDialog(null,"Please enter the amount to deposit. It can't be zero");
            }else{
                try {
                    int depositAmount=Integer.parseInt(number);
                    if(depositAmount<=0){
                        JOptionPane.showMessageDialog(null,"Please enter an amount greater than zero.");
                        return;
                    }
                    conn con = new conn();
                    String query = "insert into bank values (?,?,?,?,?)";
                    PreparedStatement ps = con.c.prepareStatement(query);
                    ps.setString(1, cardnumber);
                    ps.setString(2, pinno);
                    ps.setString(3, date.toString());
                    ps.setString(4, "Deposit");
                    ps.setString(5, number);
                    ps.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Rs. " + number + " deposited successfully.");
                    setVisible(false);
                    new Transactions(cardnumber,pinno).setVisible(true);
                    }
                catch(NumberFormatException ne){
                    JOptionPane.showMessageDialog(null, "Please enter valid numeric amount");
                }
                catch(Exception e){
                        System.out.println(e);
                    }
                }
        } else if (ae.getSource()==back) {
            setVisible(false);
            new Transactions(cardnumber,pinno).setVisible(true);
        }
    }
    public static void main(String[] args) {
        new Deposit("","");
    }
}
