package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import java.sql.*;
public class Withdraw extends JFrame implements ActionListener{
    JButton wdraw, back;
    JTextField amt;
    String cardnumber,pinno;
    Withdraw(String cardnumber, String pinno){
        this.cardnumber=cardnumber;
        this.pinno=pinno;
        setLayout(null);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("logos/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,800,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,700);
        add(image);

        JLabel text=new JLabel("Enter amount to withdraw:");
        text.setFont(new Font("Raleway", Font.PLAIN,14));
        text.setForeground(Color.WHITE);
        text.setBounds(180,220,200,30);
        image.add(text);

        amt=new JTextField("");
        amt.setBackground(Color.WHITE);
        amt.setBounds(300,250,200,30);
        image.add(amt);

        wdraw= new JButton("Withdraw");
        wdraw.setBounds(390,350,100,25);
//        wdraw.setBackground(Color.WHITE);
        wdraw.setForeground(Color.BLACK);
        wdraw.addActionListener(this);
        image.add(wdraw);

        back= new JButton("Back");
        back.setBounds(390,380,100,25);
//        back.setBackground(Color.WHITE);
        back.setForeground(Color.BLACK);
        back.addActionListener(this);
        image.add(back);

        setSize(900,700);
        setLocation(300,10);
        setUndecorated(true);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==wdraw){
            String number=amt.getText();
            Date date=new Date();
            if(number.isEmpty()){
                JOptionPane.showMessageDialog(null, "The withdrawal amount cannnot be empty");
            }else{
                try{
                    conn con=new conn();
                    String query="Insert into bank values('" + cardnumber + "','" + pinno + "', '" + date + "','Withdraw','" + number +"')";
                    con.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs. "+number+" has been withdrawn successfull");
                    setVisible(false);
                    new Transactions(cardnumber, pinno).setVisible(true);
                }catch(Exception e){
                    System.out.println(e);
                }
            }

        }else if(ae.getSource()==back){
            setVisible(false);
            new Transactions(cardnumber,pinno).setVisible(true);
        }
    }
    public static void main(String[] args) {
        new Withdraw("","");
    }
}
