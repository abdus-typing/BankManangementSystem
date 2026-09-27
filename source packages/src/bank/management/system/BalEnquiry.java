package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.*;
public class BalEnquiry extends JFrame implements ActionListener{
    String cardnumber, pinno;
    JButton back;
    BalEnquiry(String cardnumber, String pinno){
        this.cardnumber=cardnumber;
        this.pinno =pinno;

        setLayout(null);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("logos/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,800,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,800);
        add(image);

        JLabel text=new JLabel("Available Balance:");
        text.setBounds(180,300,200,30);
        text.setFont(new Font("Raleway",Font.BOLD,16));
        text.setForeground(Color.WHITE);
        image.add(text);

        back=new JButton("Back");
        back.setBounds(425,412,80,25);
        back.addActionListener(this);
        image.add(back);

        conn c=new conn();
        int balance=0;
        try{
            String query = "select * from bank where card_no = ? and pin = ?";
            PreparedStatement ps = c.c.prepareStatement(query);
            ps.setString(1, cardnumber);
            ps.setString(2, pinno);
            ResultSet res = ps.executeQuery();
            while(res.next()){
                if(res.getString("type").equals("Deposit")){
                    balance += Integer.parseInt(res.getString("amount"));
                }else if(res.getString("type").equals("Withdrawal")){
                    balance -= Integer.parseInt(res.getString("amount"));
                }
            }
        }catch(Exception e){
            System.out.println(e);
        }

        JLabel currentBal=new JLabel("Your current Account balance is "+ balance);
        currentBal.setBounds(180,350,400,20);
        currentBal.setForeground(Color.WHITE);
        image.add(currentBal);

        setSize(900,740);
        setLocation(300,20);
        setUndecorated(true);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==back){
            setVisible(false);
            new Transactions(cardnumber, pinno).setVisible(true);
        }

    }

    public static void main(String[] args) {
        new BalEnquiry("","");
    }
}
