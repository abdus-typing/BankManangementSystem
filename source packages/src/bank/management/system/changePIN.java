package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;

public class changePIN extends JFrame implements ActionListener {
    JButton cancel, change;
    JTextField pinTextfield,pin2Textfield;
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
        pinTextfield=new JTextField();
        pinTextfield.setBounds(260,360,180,22);
        image.add(pinTextfield);


        JLabel confirmpin=new JLabel("Confirm PIN: ");
        confirmpin.setForeground(Color.WHITE);
        confirmpin.setBounds(180,390,200,20);
        confirmpin.setFont(new Font("Raleway", Font.BOLD, 12));
        image.add(confirmpin);
        pin2Textfield=new JTextField();
        pin2Textfield.setBounds(260,390,180,22);
        image.add(pin2Textfield);

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
                String newpin=pinTextfield.getText();
                String repin=pin2Textfield.getText();
                if(!newpin.equals(repin)){
                    JOptionPane.showMessageDialog(null,"Entered PINs do not match.");
                }
                if(newpin.isEmpty()){
                    JOptionPane.showMessageDialog(null,"please enter PIN.");
                }
                if(repin.isEmpty()){
                    JOptionPane.showMessageDialog(null,"please confirm PIN.");
                }
                conn con=new conn(); //to change existing pin to all db tables
                String queryOne="update bank set pin='"+repin+"' where pin='"+pinno+"'";
                String querytwo="update login set pin_no='"+repin+"' where pin_no='"+pinno+"'";
                String queryThree="update signupthree set pin_no='"+repin+"' where pin_no='"+pinno+"'";
                con.s.executeUpdate(queryOne);
                con.s.executeUpdate(querytwo);
                con.s.executeUpdate(queryThree);
                JOptionPane.showMessageDialog(null, "PIN Change successful.");
                setVisible(false);
                new Transactions(cardnumber,pinno).setVisible(true);


            }catch(Exception e){
                System.out.println(e);
            }
        }
    }

    public static void main(String[] args) {
        new changePIN("","");
    }
}