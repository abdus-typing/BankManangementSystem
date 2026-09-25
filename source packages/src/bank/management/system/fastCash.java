package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Date;

public class fastCash extends JFrame implements ActionListener {
    JButton onehund, twohund, fivehundred, onethou, twothous, fivethous, tenthous, back;
    String cardnumber, pinno;
    fastCash(String cardnumber, String pinno){
        this.cardnumber=cardnumber;
        this.pinno=pinno;
        setLayout(null);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("logos/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,800, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,800);
        add(image);

        JLabel cash=new JLabel("Choose cash amount to withdraw");
        cash.setBounds(220,300,300,30);
        cash.setFont(new Font("Oswald", Font.PLAIN,14));
        cash.setForeground(Color.WHITE);
        image.add(cash);

        onehund=new JButton("Rs. 100");
        onehund.setBounds(160,370,120,25);
        onehund.setFont(new Font("Raleway",Font.BOLD,12));
        onehund.setForeground(Color.BLACK);
        onehund.addActionListener(this);
        image.add(onehund);

        twohund=new JButton("Rs. 200");
        twohund.setBounds(392,370,120,25);
        twohund.setFont(new Font("Raleway",Font.BOLD,12));
        twohund.setForeground(Color.BLACK);
        twohund.addActionListener(this);
        image.add(twohund);

        fivehundred=new JButton("Rs. 500");
        fivehundred.setBounds(160,400,120,25);
        fivehundred.setFont(new Font("Raleway",Font.BOLD,12));
        fivehundred.setForeground(Color.BLACK);
        fivehundred.addActionListener(this);
        image.add(fivehundred);

        onethou=new JButton("Rs. 1000");
        onethou.setBounds(392,400,120,25);
        onethou.setFont(new Font("Raleway",Font.BOLD,12));
        onethou.setForeground(Color.BLACK);
        onethou.addActionListener(this);
        image.add(onethou);

        twothous=new JButton("Rs. 2000");
        twothous.setBounds(160,430,120,25);
        twothous.setFont(new Font("Raleway",Font.BOLD,12));
        twothous.setForeground(Color.BLACK);
        twothous.addActionListener(this);
        image.add(twothous);

        fivethous=new JButton("Rs. 5000");
        fivethous.setBounds(392,430,120,25);
        fivethous.setFont(new Font("Raleway",Font.BOLD,12));
        fivethous.setForeground(Color.BLACK);
        fivethous.addActionListener(this);
        image.add(fivethous);

        tenthous=new JButton("Rs. 10000");
        tenthous.setBounds(160,460,120,25);
        tenthous.setFont(new Font("Raleway",Font.BOLD,12));
        tenthous.setForeground(Color.BLACK);
        tenthous.addActionListener(this);
        image.add(tenthous);

        back=new JButton("Back");
        back.setBounds(392,460,120,25);
        back.setFont(new Font("Raleway",Font.BOLD,12));
        back.setForeground(Color.BLACK);
        back.addActionListener(this);
        image.add(back);


        setSize(900,740);
        setLocation(300,10);
        setUndecorated(true);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==back){
            setVisible(false);
            new Transactions(cardnumber, pinno).setVisible(true);
        }else{ //dynamic
            String amount=((JButton)ae.getSource()).getText().substring(3).trim(); //Rs. 2000-> 2 is at index 3
            conn con=new conn();
            try{
                ResultSet res=con.s.executeQuery("Select * from bank where pin='"+pinno+"'");
                int bal=0;
                while(res.next()){
                    if(res.getString("type").equals("Deposit")){
                        bal += Integer.parseInt(res.getString("amount"));
                    }else{
                        bal-=Integer.parseInt(res.getString("amount"));
                    }
                }
                if (bal<Integer.parseInt(amount) && ae.getSource()!= back){
                   JOptionPane.showMessageDialog(null, "Insufficient Balance to perform action.");
                   return;
                }
                Date date=new Date();

                String query= "insert into bank values('"+cardnumber+"','"+pinno+"','"+date+"','Withdrawal','"+amount+"')";
                con.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs. "+amount+" debit successful.");

                setVisible(false);
                new Transactions(cardnumber, pinno).setVisible(true);
            }catch(Exception e){
                System.out.println(e);
            }
        }
    }

    public static void main(String[] args) {
        new fastCash("","");
    }
}
