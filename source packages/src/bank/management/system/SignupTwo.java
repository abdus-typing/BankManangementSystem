package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//import java.awt.event.ActionListener; we have already imported the above line
import java.util.*;
public class SignupTwo extends JFrame implements ActionListener {
    long random;
    JTextField panTextField, aadhaarTextField;
    JComboBox relg,catg, incomee, educated, occup;
    JRadioButton seniorcyes,seniorcno, existing,notexisting;
    JButton next;
    String formno;

    SignupTwo(String formno) {
        this.formno=formno;
        setLayout(null);

        setTitle("Page 2: NEW ACCOUNT APPLICATION FORM");

        JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway",Font.BOLD, 30));
        additionalDetails.setBounds(290,70, 400,35); //only works when setLayout(null)
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
        aadhaarTextField.setBounds(300,440,400,25);
        aadhaar.setBackground(Color.WHITE);
        add(aadhaarTextField);

        JLabel SrCitizen = new JLabel("Senior Citizen:");
        SrCitizen.setFont(new Font("Raleway",Font.BOLD, 18));
        SrCitizen.setBounds(100,490,200,25);
        add(SrCitizen);
        seniorcyes = new JRadioButton("Yes");
        seniorcyes.setFont(new Font("Raleway",Font.BOLD, 14));
        seniorcyes.setBounds(300,490,60,25);
        seniorcyes.setBackground(Color.WHITE);
        add(seniorcyes);
        seniorcno = new JRadioButton("No");
        seniorcno.setFont(new Font("Raleway",Font.BOLD, 14));
        seniorcno.setBounds(380,490,60,25);
        seniorcno.setBackground(Color.WHITE);
        add(seniorcno);
        ButtonGroup senior=new ButtonGroup();
        senior.add(seniorcyes);
        senior.add(seniorcno);

        JLabel existac = new JLabel("Have existing A/C?");
        existac.setFont(new Font("Raleway",Font.BOLD, 18));
        existac.setBounds(100,540,200,25);
        add(existac);
        existing = new JRadioButton("Yes");
        existing.setFont(new Font("Raleway",Font.BOLD, 14));
        existing.setBounds(300,540,60,25);
        existing.setBackground(Color.WHITE);
        add(existing);
        notexisting = new JRadioButton("No");
        notexisting.setFont(new Font("Raleway",Font.BOLD, 14));
        notexisting.setBounds(380,540,60,25);
        notexisting.setBackground(Color.WHITE);
        add(notexisting);
        ButtonGroup existsButton=new ButtonGroup();
        existsButton.add(existing);
        existsButton.add(notexisting);



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
//        String name=nameTextField.getText(); //setText
//        String fname= fnameTextField.getText();
        String religion=(String) relg.getSelectedItem();
        String category= (String) catg.getSelectedItem();
        String education= (String) educated.getSelectedItem();
        String occupation=(String) occup.getSelectedItem();
        String income=(String) incomee.getSelectedItem();

//        String dob = ((JTextField) dobField.getDateEditor().getUiComponent()).getText();
        String seniorC= null;
        if(seniorcyes.isSelected()){
            seniorC ="Yes";
        }else if(seniorcno.isSelected()) {
            seniorC = "No";
        }

        String existingAc=null;
        if(existing.isSelected()){
            existingAc="Yes";
        }
        else if(notexisting.isSelected()){
            existingAc="No";
        }

        String aadhar=aadhaarTextField.getText();
        String pan=panTextField.getText();

        try{
            {
                conn c= new conn();
                String query= "insert into signuptwo values ('"+formno+"','"+religion+"', '"+category+"','"+education+"','"+occupation+"','"+income+"','"+aadhar+"','"+pan+"','"+seniorC+"','"+existingAc+"')";
                c.s.executeUpdate(query);

                //next signup page
            }
        }catch(Exception e){
            System.out.println(e);

        }
    }

    public static void main(String[] args) {
        new SignupTwo("");
    }
}