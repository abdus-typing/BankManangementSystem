package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.sql.SQLException;

public class miniStatement extends JFrame{
    String cardnumber, pinno;
    miniStatement(String cardnumber, String pinno){
        this.cardnumber=cardnumber;
        this.pinno=pinno;
        setLayout(null);

        setTitle("Mini Statement");

        JLabel ministatement=new JLabel();
        add(ministatement);

        JLabel bank=new JLabel("Bandana Bank");
        bank.setBounds(150,40,200,20);
        bank.setFont(new Font("Raleway",Font.BOLD,16));
        add(bank);

        JLabel card=new JLabel();
        card.setBounds(15,120,300,20);
        add(card);



        JLabel bal=new JLabel();
        add(bal);


        conn dbconn=null;
        ResultSet resLogin=null;
        ResultSet resBank=null;
        PreparedStatement loginPs=null;
        PreparedStatement bankPs=null;
        try{
            dbconn=new conn();
            String loginQuery = "select * from login where cardNumber = ? and pin_no = ?";
            loginPs = dbconn.c.prepareStatement(loginQuery);
            loginPs.setString(1, cardnumber);
            loginPs.setString(2, pinno);
            resLogin = loginPs.executeQuery();

            while(resLogin.next()){
                String fullCardNumber= resLogin.getString("cardNumber");
                if(fullCardNumber!=null && fullCardNumber.length()>=16){
                    card.setText("Card Number: XXXXXXXXXXXX"+resLogin.getString("cardNumber").substring(12));
                }
            }
            String bankQuery = "select * from bank where card_no = ? and pin = ?";
            bankPs = dbconn.c.prepareStatement(bankQuery);
            bankPs.setString(1, cardnumber);
            bankPs.setString(2, pinno);
            resBank = bankPs.executeQuery();
            StringBuilder statementText = new StringBuilder("<html>");

            int balance=0;
            while(resBank.next()){
                String date=resBank.getString("date");
                String type=resBank.getString("type");
                String amt=resBank.getString("amount");
                int amount=Integer.parseInt(amt);
                //mini statement text
                statementText.append(date).append("&nbsp;&nbsp;")
                        .append(type).append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;")
                        .append(amt).append("<br><br>");
                if(type.equals("Deposit")){
                    balance+=amount;
                }else if(type.equals("Withdrawal")){
                    balance-=amount;
                }
            }
            statementText.append("</html>");
            ministatement.setText(statementText.toString());
            bal.setText("Current Balance: "+balance);
            bal.setBounds(15,520,300,20);
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            try{
                if(resLogin!=null) resLogin.close();
                if(resBank!=null) resBank.close();
                if(loginPs!=null) loginPs.close();
                if(bankPs!=null) bankPs.close();
                if(dbconn!=null && dbconn.c!=null) dbconn.c.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }

        ministatement.setBounds(15,100,400,400);
        bal.setBounds(15,520,400,100);

        setLocation(200,15);
        setSize(400,650);
        setUndecorated(true);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        new miniStatement("","");
    }
}
