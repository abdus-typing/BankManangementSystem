package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.sql.*;

public class changePIN extends JFrame implements ActionListener {
    JButton cancel, change;
    JPasswordField pinPassfield,pin2Passfield;
    String cardnumber, pinno;

    changePIN(String cardnumber, String pinno){
        this.cardnumber=cardnumber;
        this.pinno=pinno;
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("logos/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,800, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,800);
        add(image);

        JLabel text=new JLabel("Change your PIN number");
        text.setForeground(Color.WHITE);
        text.setBounds(220,310,200,30);
        text.setFont(new Font("Raleway", Font.BOLD, 16));
        image.add(text);

        JLabel pintext=new JLabel("New PIN: ");
        pintext.setForeground(Color.WHITE);
        pintext.setBounds(180,360,200,20);
        pintext.setFont(new Font("Raleway", Font.BOLD, 12));
        image.add(pintext);
        pinPassfield=new JPasswordField();
        pinPassfield.setBounds(260,360,180,22);
        image.add(pinPassfield);


        JLabel confirmpin=new JLabel("Confirm PIN: ");
        confirmpin.setForeground(Color.WHITE);
        confirmpin.setBounds(180,390,200,20);
        confirmpin.setFont(new Font("Raleway", Font.BOLD, 12));
        image.add(confirmpin);
        pin2Passfield=new JPasswordField();
        pin2Passfield.setBounds(260,390,180,22);
        image.add(pin2Passfield);

        change=new JButton("Change");
        change.setBackground(Color.WHITE);
        change.setBounds(430,440,80,25);
        change.addActionListener(this);
        image.add(change);

        cancel=new JButton("Cancel");
        cancel.setBackground(Color.WHITE);
        cancel.setBounds(340,440,80,25);
        cancel.addActionListener(this);
        image.add(cancel);

        setSize(900,740);
        setLocation(300,20);
        setUndecorated(true);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        }
        public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==cancel){
            setVisible(false);
            new Transactions(cardnumber, pinno).setVisible(true);
        }
        else{ //button change
            try{
                String newpin=new String(pinPassfield.getPassword());
                String repin=new String(pin2Passfield.getPassword());
                if(!newpin.equals(repin)){
                    JOptionPane.showMessageDialog(null,"Entered PINs do not match.");
                    return;
                }
                if(newpin.isEmpty()){
                    JOptionPane.showMessageDialog(null,"please enter PIN.");
                    return;
                }
                if(repin.isEmpty()){
                    JOptionPane.showMessageDialog(null,"please confirm PIN.");
                    return;
                }
                conn con=new conn();

                String queryOne="update bank set pin=? where card_no=?";
                PreparedStatement psOne = con.c.prepareStatement(queryOne);
                psOne.setString(1, repin);
                psOne.setString(2, cardnumber);
                psOne.executeUpdate();

                String queryTwo="update login set pin_no=? where cardNumber=?";
                PreparedStatement psTwo = con.c.prepareStatement(queryTwo);
                psTwo.setString(1, repin);
                psTwo.setString(2, cardnumber);
                psTwo.executeUpdate();

                String queryThree="update signupthree set pin_no=? where cardNumber=?";
                PreparedStatement psThree = con.c.prepareStatement(queryThree);
                psThree.setString(1, repin);
                psThree.setString(2, cardnumber);
                psThree.executeUpdate();


                JOptionPane.showMessageDialog(null, "PIN Change successful.");
                setVisible(false);
                new Transactions(cardnumber,repin).setVisible(true);


            }catch(Exception e){
                System.out.println(e);
            }
        }
    }

    public static void main(String[] args) {
        new changePIN("","");
    }
}