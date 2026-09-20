package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//import java.awt.event.ActionListener;
import java.util.*;
import com.toedter.calendar.JDateChooser;
public class signup extends JFrame implements ActionListener {
    long appno;
    JTextField nameTextField, fnameTextField, phoneTextField, mailTextField, addrTextField, ctTextField, pinTextField, stateTextField, countryTextField;
    JDateChooser dobField;
    JRadioButton male, female, other, married, unmarried, dontsay;
    JButton next;
    signup() {
        setLayout(null);

        Random random= new Random();
        appno =Math.abs(random.nextLong()%8000L + 1000L);

        JLabel formno = new JLabel("APPLICATION FORM NO." + appno);
        formno.setFont(new Font("Raleway",Font.BOLD, 38));
        formno.setBounds(140,20,600,40); //only works when setLayout(null)
        add(formno);

        JLabel personalDetails = new JLabel("Page 1. Personal Details");
        personalDetails.setFont(new Font("Raleway",Font.BOLD, 22));
        personalDetails.setBounds(290,80,400,25); //only works when setLayout(null)
        add(personalDetails);

        JLabel name = new JLabel("Name:");
        name.setFont(new Font("Raleway",Font.BOLD, 18));
        name.setBounds(100,140,100,25); //only works when setLayout(null)
        add(name);
         nameTextField = new JTextField();
        nameTextField.setFont(new Font("Raleway",Font.BOLD, 14));
        nameTextField.setBounds(300,140,400,25);
        add(nameTextField);

        JLabel fname = new JLabel("Father's Name:");
        fname.setFont(new Font("Raleway",Font.BOLD, 18));
        fname.setBounds(100,190,200,25);
        add(fname);
         fnameTextField = new JTextField();
        fnameTextField.setFont(new Font("Raleway",Font.BOLD, 14));
        fnameTextField.setBounds(300,190,400,25);
        add(fnameTextField);

        JLabel dob = new JLabel("Date Of Birth:");
        dob.setFont(new Font("Raleway",Font.BOLD, 18));
        dob.setBounds(100,240,200,25);
        add(dob);
         dobField = new JDateChooser();
        dobField.setFont(new Font("Raleway",Font.BOLD, 14));
        dobField.setBounds(300,240,400,25);
        add(dobField);

        JLabel gender = new JLabel("Gender:");
        gender.setFont(new Font("Raleway",Font.BOLD, 18));
        gender.setBounds(100,290,200,25);
        add(gender);
         male=new JRadioButton("Male");
        male.setBounds(300,290,70,25);
        male.setBackground(Color.WHITE);
         female=new JRadioButton("Female");
        female.setBounds(400,290,70,25);
        female.setBackground(Color.WHITE);
         other=new JRadioButton("Prefer not to say");
        other.setBounds(500,290,150,25);
        other.setBackground(Color.WHITE);
        add(male);
        add(female);
        add(other);
        ButtonGroup genderchoose= new ButtonGroup(); //to choose only one gender radio button at a time
        genderchoose.add(male);
        genderchoose.add(female);
        genderchoose.add(other);

        JLabel phone = new JLabel("Phone No. ");
        phone.setFont(new Font("Raleway",Font.BOLD, 18));
        phone.setBounds(100, 340, 200,25);
        add(phone);
        phoneTextField = new JTextField();
        phoneTextField.setFont(new Font("Raleway",Font.BOLD, 14));
        phoneTextField.setBounds(300,340,400,25);
        add(phoneTextField);

        JLabel email = new JLabel("Email Address:");
        email.setFont(new Font("Raleway",Font.BOLD, 18));
        email.setBounds(100,390,200,25);
        add(email);
         mailTextField = new JTextField();
        mailTextField.setFont(new Font("Raleway",Font.BOLD, 14));
        mailTextField.setBounds(300,390,400,25);
        add(mailTextField);

        JLabel marital = new JLabel("Marital Status:");
        marital.setFont(new Font("Raleway",Font.BOLD, 18));
        marital.setBounds(100,440,200,25);
        add(marital);
         married=new JRadioButton("Married");
        married.setBounds(300,440,70,25);
        married.setBackground(Color.WHITE);
         unmarried=new JRadioButton("Unmarried");
        unmarried.setBounds(400,440,100,25);
        unmarried.setBackground(Color.WHITE);
         dontsay=new JRadioButton("Other");
        dontsay.setBounds(500,440,70,25);
        dontsay.setBackground(Color.WHITE);
        add(married);
        add(unmarried);
        add(dontsay);
        ButtonGroup maritalstatus= new ButtonGroup();
        maritalstatus.add(married);
        maritalstatus.add(unmarried);
        maritalstatus.add(dontsay);

        JLabel addr = new JLabel("Address:");
        addr.setFont(new Font("Raleway",Font.BOLD, 18));
        addr.setBounds(100,490,200,25);
        add(addr);
         addrTextField = new JTextField();
        addrTextField.setFont(new Font("Raleway",Font.BOLD, 14));
        addrTextField.setBounds(300,490,400,25);
        add(addrTextField);

        JLabel city = new JLabel("City:");
        city.setFont(new Font("Raleway",Font.BOLD, 18));
        city.setBounds(100,540,200,25);
        add(city);
         ctTextField = new JTextField();
        ctTextField.setFont(new Font("Raleway",Font.BOLD, 14));
        ctTextField.setBounds(300,540,400,25);
        add(ctTextField);

        JLabel pincode = new JLabel("Pincode:");
        pincode.setFont(new Font("Raleway",Font.BOLD, 18));
        pincode.setBounds(100,590,200,25);
        add(pincode);
         pinTextField = new JTextField();
        pinTextField.setFont(new Font("Raleway",Font.BOLD, 14));
        pinTextField.setBounds(300,590,400,25);
        add(pinTextField);

        JLabel state = new JLabel("State:");
        state.setFont(new Font("Raleway",Font.BOLD, 18));
        state.setBounds(100,640,200,30);
        add(state);
         stateTextField = new JTextField();
        stateTextField.setFont(new Font("Raleway",Font.BOLD, 14));
        stateTextField.setBounds(300,640,400,30);
        add(stateTextField);

        JLabel country = new JLabel("Country:");
        country.setFont(new Font("Raleway",Font.BOLD, 18));
        country.setBounds(100,690,200,25);
        add(country);
         countryTextField = new JTextField();
        countryTextField.setFont(new Font("Raleway",Font.BOLD, 14));
        countryTextField.setBounds(300,690,400,25);
        add(countryTextField);

        next= new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,17));
        next.setBounds(620,720,80,25);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.WHITE);

        setSize(900,790);
        setLocation(500,10);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent aet){
        String formno = ""+appno;  //long
        String name=nameTextField.getText(); //setText
        String fname= fnameTextField.getText();
        String dob = ((JTextField) dobField.getDateEditor().getUiComponent()).getText();
        String gender= null;
        if(male.isSelected()){
            gender ="Male";
        }else if(female.isSelected()){
            gender= "Female";
        }else if(other.isSelected()){
            gender="Prefer not to say";
        }

        String phone=phoneTextField.getText();
        String email=mailTextField.getText();
        String marital= null;
        if(married.isSelected()){
            marital="Married";
        }else if(unmarried.isSelected()){
            marital="Unmarried";
        }else if(dontsay.isSelected()){
            marital="Other";
        }
        String address=addrTextField.getText();
        String city=ctTextField.getText();
        String state= stateTextField.getText();
        String pin= pinTextField.getText();
        String country= countryTextField.getText();

        try{
            if(name.equals("")){
                JOptionPane.showMessageDialog(null, "Name is a required field");
            }
            else{
                conn c= new conn();
                String query= "insert into signup values ('"+formno+"', '"+name+"','"+fname+"','"+dob+"','"+gender+"','"+phone+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+pin+"','"+state+"','"+country+"')";
                c.s.executeUpdate(query);

                setVisible(false);
                new SignupTwo(formno).setVisible(true);
            }
        }catch(Exception e){
            System.out.println(e);

        }
    }

    public static void main(String[] args) {
        new signup();
    }
}