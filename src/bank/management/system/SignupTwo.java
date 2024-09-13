package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignupTwo extends JFrame implements  ActionListener {
    
    JTextField panTextField,adharTextField;
    JButton next;
    JRadioButton syes,sno,eyes,eno;
    JComboBox religion ,income, category,occupation,education;
    String formno;
    
    SignupTwo(String formno){
     this.formno=formno;
        setLayout(null);
      setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
        
        JLabel additionalDetails= new JLabel("Page 2: Additional Details" );
        additionalDetails.setFont(new Font("Railway", Font.BOLD,38));
        additionalDetails.setBounds(290,80,500,40);
        add(additionalDetails);
        JLabel religional = new JLabel("Religion:" );
        religional.setFont(new Font("Railway", Font.BOLD,20));
        religional.setBounds(100,140,200,30);
        add(religional);
        String valReligion[]={"Hindu","Muslim","Sikh","Christian"};
        religion = new JComboBox(valReligion);
        religion.setBounds(300,140,400,30);
        religion.setBackground(Color.WHITE);
        add(religion);
       
        JLabel categorya = new JLabel("Category:" );
        categorya.setFont(new Font("Railway", Font.BOLD,20));
        categorya.setBounds(100,190,400,30);
        add(categorya);
        String valCategory[]= {"General","OBC","SC","ST","Other"};
        category = new JComboBox(valCategory);
          category.setBounds(300,190,400,30);
          category.setBackground(Color.WHITE);
        add(category);
       
        JLabel incomeb = new JLabel("Income:" );
        incomeb.setFont(new Font("Railway", Font.BOLD,20));
        incomeb.setBounds(100,240,400,30);
        add(incomeb);
         String valIncome[]= {"Null","<1,50,000","<2,50,000","<5.00,000","upto 10,00,000"};
         income= new JComboBox(valIncome);
          income.setBounds(300,240,400,30);
          income.setBackground(Color.WHITE);
        add(income);
        
        JLabel educational = new JLabel("Education:" );
        educational.setFont(new Font("Railway", Font.BOLD,20));
        educational.setBounds(100,290,200,30);
        add(educational);
        JLabel qualification = new JLabel("Qualification:" );
        qualification.setFont(new Font("Railway", Font.BOLD,20));
        qualification.setBounds(100,320,200,30);
        add(qualification);
         String valEducation[]= {"Non-Graduate","Graduate","Post Graduation","Doctorate","others"};
        education= new JComboBox(valEducation);
          education.setBounds(300,320,400,30);
          education.setBackground(Color.WHITE);
        add(education);
       
        JLabel boccupation = new JLabel("Occupation:" );
        boccupation.setFont(new Font("Railway", Font.BOLD,20));
        boccupation.setBounds(100,390,400,30);
        add(boccupation);
       String valOccupation[]= {"Self-Employed","Business Man","Student","Retired","others"};
        occupation= new JComboBox(valOccupation);
          occupation.setBounds(300,390,400,30);
          occupation.setBackground(Color.WHITE);
        add(occupation);
        JLabel pan = new JLabel("PAN No:" );
        pan.setFont(new Font("Railway", Font.BOLD,20));
        pan.setBounds(100,440,200,30);
        add(pan);
        panTextField = new JTextField();
        panTextField.setFont(new Font("Railway", Font.BOLD,24));
        panTextField.setBounds(300,440,400,30);
        add(panTextField);
        JLabel adhar = new JLabel("Adhaar No.:" );
        adhar.setFont(new Font("Railway", Font.BOLD,20));
        adhar.setBounds(100,490,200,30);
        add(adhar);
        adharTextField = new JTextField();
        adharTextField.setFont(new Font("Railway", Font.BOLD,24));
        adharTextField.setBounds(300,490,400,30);
        add(adharTextField);
        JLabel senior = new JLabel("Senior Citizen:" );
        senior.setFont(new Font("Railway", Font.BOLD,20));
        senior.setBounds(100,540,200,30);
        add(senior);
        syes= new JRadioButton("Yes");
        syes.setBounds(300,540,100,30);
        syes.setBackground(Color.WHITE);
        add(syes);
        sno= new JRadioButton("No");
        sno.setBounds(450,540,100,30);
        sno.setBackground(Color.WHITE);
        add(sno);
        ButtonGroup seniorgroup = new ButtonGroup();
        seniorgroup.add(syes);
        seniorgroup.add(sno);
        
        JLabel exist = new JLabel("Existing Account:" );
        exist.setFont(new Font("Railway", Font.BOLD,20));
        exist.setBounds(100,590,200,30);
        add(exist);
        eyes= new JRadioButton("Yes");
        eyes.setBounds(300,590,100,30);
        eyes.setBackground(Color.WHITE);
        add(eyes);
        eno= new JRadioButton("No");
        eno.setBounds(450,590,100,30);
        eno.setBackground(Color.WHITE);
        add(eno);
        ButtonGroup existgroup = new ButtonGroup();
        existgroup.add(eyes);
        existgroup.add(eno);
    
        
        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Railway", Font.BOLD,14));
        next.setBounds(620,660,80,30);
        next.addActionListener(this);
        add(next);
        getContentPane().setBackground(Color.WHITE);
        
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
       
        String sreligion= (String)religion.getSelectedItem();
        String scategory = (String)category.getSelectedItem();
        
        String sincome = (String)income.getSelectedItem();
         String seducation = (String)education.getSelectedItem();
          String soccupation= (String)occupation.getSelectedItem();
           
        String seniorcitizen = null;
        if(syes.isSelected()){
            seniorcitizen= "Yes";
        }else if(sno.isSelected()){
            seniorcitizen= "No";
        }
       
        String existingaccount= null;
        if(eyes.isSelected()){
            existingaccount="Yes";
        }else if(eno.isSelected()){
            existingaccount= "No";
        }
        String span= panTextField.getText();
        String sadhar= adharTextField.getText();
       
        try{
           
               Conn c= new Conn();
               String query= "insert into signuptwo values( '"+ formno+"', '"+sreligion+"','"+scategory+"','"+sincome+"','"+soccupation+"','"+seducation+"','"+span+"','"+sadhar+"','"+existingaccount+"','"+seniorcitizen+"')";
          c.s.executeUpdate(query);
            setVisible(false);
                    new SignupThree(formno).setVisible(true);
           }
        catch(Exception e){
            System.out.println(e);
    }
    }
    public static void main(String args[]){
        new SignupTwo(" ");
    }
}

