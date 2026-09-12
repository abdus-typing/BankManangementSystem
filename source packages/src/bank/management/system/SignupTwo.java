package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//import java.awt.event.ActionListener; we have already imported the above line
import java.util.*;
import com.toedter.calendar.JDateChooser;
public class SignupTwo extends JFrame implements ActionListener {
//    long appno;
    JTextField nameTextField, fnameTextField,phoneTextField,mailTextField, addrTextField, panTextField, aadhaarTextField, ctTextField, pinTextField, stateTextField, countryTextField;
    JComboBox relg,catg, incomee, educated, occup;
    JRadioButton seniorcyes,seniorcno, existing,notexisting, male, female, other, married, unmarried, dontsay;
    JButton next;
    JDateChooser dobField;
    long formno;
    SignupTwo() {
        setLayout(null);

        setTitle("Page 2: NEW ACCOUNT APPLICATION FORM");

        JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway",Font.BOLD, 30));
        additionalDetails.setBounds(290,80, 400,25); //only works when setLayout(null)
        add(additionalDetails);

        JLabel religion = new JLabel("Religion:");
        religion.setFont(new Font("Raleway",Font.BOLD, 18));
        religion.setBounds(100,140,100,25); //only works when setLayout(null)
        add(religion);
        String valueReligion[]= {"Hinduism","Islam","Sikhism","Christianity","Buddhism","Other"};
        relg=new JComboBox(valueReligion);
        relg.setBounds(300,140,400,25);
        relg.setBackground(Color.WHITE);
        add(relg);

        JLabel category = new JLabel("Category:");
        category.setFont(new Font("Raleway",Font.BOLD, 18));
        category.setBounds(100,190,200,25);
        add(category);
        String valueCategory[]={"General","OBC","SC/ST","Other"};
         catg=new JComboBox(valueCategory);
        catg.setBounds(300,190,400,25);
        catg.setBackground(Color.WHITE);
        add(catg);

        JLabel EductaionalQualification = new JLabel("Educational Qualification:");
        EductaionalQualification.setFont(new Font("Raleway",Font.BOLD, 18));
        EductaionalQualification.setBounds(100,240,200,25);
        add(EductaionalQualification);
        String educat[]={"Nil","Matriculation","Higher Secondary","Graduate","Post-graduate","Doctorate"};
        educated=new JComboBox(educat);
        educated.setBounds(300,240,400,25);
        educated.setBackground(Color.WHITE);
        add(educated);

        JLabel Occupation = new JLabel("Occupation: ");
        Occupation.setFont(new Font("Raleway",Font.BOLD, 18));
        Occupation.setBounds(100, 290, 200,25);
        add(Occupation);
        String occp[]={"Salaried","Business","Govt Employee","Retired","Self-Employed","Student","Others"};
        occup=new JComboBox(occp);
        occup.setBounds(300,290,400,25);
        occup.setBackground(Color.WHITE);
        add(occup);


        JLabel  Income= new JLabel("Annual Income:");
        Income.setFont(new Font("Raleway",Font.BOLD, 18));
        Income.setBounds(100,340,200,25);
        add(Income);
        String incomeCat[]={"Null","Less than Rs. 1,50,000","Rs. 1,50,000-3,50,000","Rs. 3,50,000-7,00,000","Rs. 7,00,000-10,00,000","More than Rs. 10,00,000"};
        incomee=new JComboBox(incomeCat);
        incomee.setBounds(300,340,400,25);
        incomee.setBackground(Color.WHITE);
        add(incomee);



        JLabel pan = new JLabel("PAN no.:");
        pan.setFont(new Font("Raleway",Font.BOLD, 18));
        pan.setBounds(100,390,200,25);
        add(pan);
        panTextField = new JTextField();
        panTextField.setFont(new Font("Raleway",Font.BOLD, 14));
        panTextField.setBounds(300,390,400,25);
        add(panTextField);

        JLabel aadhaar = new JLabel("Aadhaar Number:");
        aadhaar.setFont(new Font("Raleway",Font.BOLD, 18));
        aadhaar.setBounds(100,440,200,25);
        add(aadhaar);
        aadhaarTextField = new JTextField();
        aadhaarTextField.setFont(new Font("Raleway",Font.BOLD, 14));
        aadhaarTextField.setBounds(300,390,400,25);
        aadhaar.setBackground(Color.WHITE);
        add(aadhaarTextField);

        JLabel SrCitizen = new JLabel("Senior Citizen:");
        SrCitizen.setFont(new Font("Raleway",Font.BOLD, 18));
        SrCitizen.setBounds(100,490,200,25);
        add(SrCitizen);
        seniorcyes = new JRadioButton("Yes");
        seniorcyes.setFont(new Font("Raleway",Font.BOLD, 14));
        seniorcyes.setBounds(300,490,400,25);
        seniorcyes.setBackground(Color.WHITE);
        add(seniorcyes);
        seniorcno = new JRadioButton("No");
        seniorcno.setFont(new Font("Raleway",Font.BOLD, 14));
        seniorcno.setBounds(380,490,400,25);
        seniorcno.setBackground(Color.WHITE);
        add(seniorcno);
        ButtonGroup senior=new ButtonGroup();
        senior.add(seniorcyes);
        senior.add(seniorcno);

        JLabel existac = new JLabel("Have any existing account?");
        existac.setFont(new Font("Raleway",Font.BOLD, 18));
        existac.setBounds(100,540,200,25);
        add(existac);
        existing = new JRadioButton("Yes");
        existing.setFont(new Font("Raleway",Font.BOLD, 14));
        existing.setBounds(300,540,400,25);
        existing.setBackground(Color.WHITE);
        add(existing);
        notexisting = new JRadioButton("No");
        notexisting.setFont(new Font("Raleway",Font.BOLD, 14));
        notexisting.setBounds(380,540,400,25);
        notexisting.setBackground(Color.WHITE);
        add(notexisting);
        ButtonGroup existsButton=new ButtonGroup();
        existsButton.add(existing);
        existsButton.add(notexisting);

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
//        String formno = ""+appno;  //long
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
            }
        }catch(Exception e){
            System.out.println(e);

        }
    }

    public static void main(String[] args) {
        new SignupTwo();
    }
}