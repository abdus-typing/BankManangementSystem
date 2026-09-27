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
        wdraw.setForeground(Color.BLACK);
        wdraw.addActionListener(this);
        image.add(wdraw);

        back= new JButton("Back");
        back.setBounds(390,380,100,25);
        back.setForeground(Color.BLACK);
        back.addActionListener(this);
        image.add(back);

        setSize(900,700);
        setLocation(300,10);
        setUndecorated(true);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == wdraw) {
            String number = amt.getText();
            Date date = new Date();

            if (number.isEmpty()) {
                JOptionPane.showMessageDialog(null, "The withdrawal amount cannot be empty");
            } else {
                try {
                    conn con = new conn();
                    int withdrawAmount = Integer.parseInt(number);
                    int balance = 0;

                    // 1. Calculate the current balance first
                    String selectQuery = "select * from bank where card_no = ? and pin = ?";
                    PreparedStatement selectPs = con.c.prepareStatement(selectQuery);
                    selectPs.setString(1, cardnumber);
                    selectPs.setString(2, pinno);
                    ResultSet rs = selectPs.executeQuery();

                    while (rs.next()) {
                        if (rs.getString("type").equals("Deposit")) {
                            balance += Integer.parseInt(rs.getString("amount"));
                        } else {
                            // Assuming any non-Deposit is a withdrawal
                            balance -= Integer.parseInt(rs.getString("amount"));
                        }
                    }

                    // 2. Check if the user has enough money
                    if (balance < withdrawAmount) {
                        JOptionPane.showMessageDialog(null, "Insufficient Balance. Current Balance: Rs " + balance);
                        return; // Stop execution, do not proceed to insertion
                    }

                    // 3. If balance is sufficient, insert the withdrawal record
                    String insertQuery = "Insert into bank values(?,?,?,?,?)";
                    PreparedStatement insertPs = con.c.prepareStatement(insertQuery);
                    insertPs.setString(1, cardnumber);
                    insertPs.setString(2, pinno);
                    insertPs.setString(3, date.toString());
                    insertPs.setString(4, "Withdrawal");
                    insertPs.setString(5, number);
                    insertPs.executeUpdate();

                    JOptionPane.showMessageDialog(null, "Rs. " + number + " has been withdrawn successfully");
                    setVisible(false);
                    new Transactions(cardnumber, pinno).setVisible(true);

                } catch (NumberFormatException nfe) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid numeric amount");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else if (ae.getSource() == back) {
            setVisible(false);
            new Transactions(cardnumber, pinno).setVisible(true);
        }
    }
    public static void main(String[] args) {
        new Withdraw("","");
    }
}
