/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookingsystemhlc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
/**
 *
 * @author abdul
 */
public class MainFrame extends JFrame implements ActionListener{
    private ArrayList<Coach> coachesAL;
    private ArrayList<Student> studentsAL;
    private ArrayList<Bookings> bookingsAL;
    
    private Dimension windowSize= new Dimension(1000,750);
    private Container c;
    private CardLayout cardlayout;
    private JPanel allPanels;
    private JPanel loginPanel;
    private JPanel parentPanel;
    private JPanel parentSearchResultPanel;
    
    private Font titleFont = new Font("Serif", Font.BOLD, 25);
    
    // Login Panel
    private JLabel loginTitleLabel;
    private JLabel loginStudentNameLabel;    
    private JTextField loginStudentNameField;    
    private JButton loginParentButton;
    private JButton loginSubmitButton;
    
    //Parent Panel
    private JLabel parentTitleLabel;
   
    private JTextField parentSearchField;    
    private JButton parentSearchButton;
    private JButton parentStudentButton;
    
    ArrayList<Coach> coachSearchResult = new ArrayList<Coach>();
    
    
    
    public MainFrame(ArrayList<Coach> coachesAL, ArrayList<Student> studentsAL, ArrayList<Bookings> bookingsAL){
        super("Booking System HLC");
        
        this.coachesAL = coachesAL;
        this.studentsAL = studentsAL;
        this.bookingsAL = bookingsAL;
        
        
//        setBounds(300, 90, 900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setSize(windowSize);
        
        c = getContentPane();
//        c.setLayout(null);
        cardlayout = new CardLayout();
        allPanels = new JPanel(cardlayout);
        
        generateLoginPanel();
        generateParentPanel();


        allPanels.add(loginPanel,"rp");
        allPanels.add(parentPanel,"pp");
        
        c.add(allPanels);

        setVisible(true);
        
    }
    
    public void generateLoginPanel(){                      
        loginTitleLabel = new JLabel("Student Registration");
        loginTitleLabel.setSize(300, 50);
//        loginTitleLabel.setPreferredSize(new Dimension(300,50));
        loginTitleLabel.setFont(titleFont);       
        loginTitleLabel.setLocation(350,45);   
        loginTitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        loginTitleLabel.setVerticalAlignment(SwingConstants.CENTER);
//        loginTitleLabel.setOpaque(true);        
//        loginTitleLabel.setBackground(Color.red);
        

        loginStudentNameLabel = new JLabel("Student Name: ");
        loginStudentNameLabel.setSize(300, 50);       
//        loginStudentNameLabel.setPreferredSize(new Dimension(300,50));
        loginStudentNameLabel.setLocation(300,130);
            
        loginStudentNameField = new JTextField();
        loginStudentNameField.setSize(400,50);
//        loginStudentNameField.setPreferredSize(new Dimension(400,50));
        loginStudentNameField.setLocation(300,170);
        loginStudentNameField.addActionListener(this);
        
        loginSubmitButton = new JButton("Submit");
        loginSubmitButton.setSize(100,50);
//        loginSubmitButton.setPreferredSize(new Dimension(100,50));
        loginSubmitButton.setLocation(450, 270);
        loginSubmitButton.addActionListener(this);
        
        
        loginParentButton = new JButton("Parent Login");
        loginParentButton.setSize(150,50);
//        loginParentButton.setPreferredSize(new Dimension(150,50));
        loginParentButton.setLocation(800, 45);
        loginParentButton.addActionListener(this);
        
        
        // Panel
        loginPanel = new JPanel();
        loginPanel.setLayout(null);
        
        loginPanel.add(loginTitleLabel);
        loginPanel.add(loginStudentNameLabel);
        loginPanel.add(loginStudentNameField);
        loginPanel.add(loginSubmitButton);   
        loginPanel.add(loginParentButton);     
}
    
    public void generateParentPanel(){
        parentTitleLabel = new JLabel("Appointment Booking");
        parentTitleLabel.setSize(300, 50);
//        parentTitleLabel.setPreferredSize(new Dimension(300,50));
        parentTitleLabel.setFont(titleFont);       
        parentTitleLabel.setLocation(350,45);   
        parentTitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        parentTitleLabel.setVerticalAlignment(SwingConstants.CENTER);
        
        parentSearchField = new JTextField();
        parentSearchField.setSize(400,50);
//        parentSearchField.setPreferredSize(new Dimension(400,50));
        parentSearchField.setLocation(300,170);
        parentSearchField.addActionListener(this);
        
        parentSearchButton = new JButton("Search");
        parentSearchButton.setSize(150, 50);
        parentSearchButton.setLocation(710,170);
        parentSearchButton.addActionListener(this);
        
        //Search Result Panel
        parentSearchResultPanel = new JPanel();
        parentSearchResultPanel.setLayout(new GridLayout(0,5));
        parentSearchResultPanel.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
        parentSearchResultPanel.setLocation(10,250);
        parentSearchResultPanel.setSize(windowSize.width-25,windowSize.height-300);
        
        
//        coachSearchResult = coachesAL;
        
//        JLabel idLabel = new JLabel("ID");
//        JLabel nameLabel = new JLabel("Coach Name");
//        JLabel phoneLabel = new JLabel("Mobile No.");
//        JLabel expertiseLabel = new JLabel("Expertise");
//        JLabel officeHourLabel = new JLabel("Office Hours");
//        parentSearchResultPanel.add(idLabel);
//        parentSearchResultPanel.add(nameLabel);
//        parentSearchResultPanel.add(phoneLabel);
//        parentSearchResultPanel.add(expertiseLabel);
//        parentSearchResultPanel.add(officeHourLabel);
        
                
//        for(Coach c : coachSearchResult) {   
//            parentSearchResultPanel.add(new JLabel(c.getId()+""));
//            parentSearchResultPanel.add(new JLabel(c.getFullName()));
//            parentSearchResultPanel.add(new JLabel(c.getTelephoneNo()));
//            parentSearchResultPanel.add(new JLabel(c.getExpertiseString()));
////            parentSearchResultPanel.add(new JLabel(c.getOfficeHour()));
//            JPanel officeHourPanel = new JPanel();
//            officeHourPanel.setLayout(new GridLayout(3,0));
//            officeHourPanel.setSize(100,100);
//            officeHourPanel.add(new JLabel(c.getOfficeHour()));
//            officeHourPanel.add(new JLabel(c.getOfficeHour()));
//            officeHourPanel.add(new JLabel(c.getOfficeHour()));
//            parentSearchResultPanel.add(officeHourPanel);
//        }
        
//        JLabel label1 = new JLabel("tes111111111111111t");label1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
//        JLabel label2 = new JLabel("test22222222222222");label2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
//        JLabel label3 = new JLabel("test3333333333");label3.setBorder(BorderFactory.createLineBorder(Color.BLACK));
//        JLabel label4 = new JLabel("test44");JLabel label5 = new JLabel("test44444555555");
//        parentSearchResultPanel.add(label1);parentSearchResultPanel.add(label2);parentSearchResultPanel.add(label3);
//parentSearchResultPanel.add(label4);parentSearchResultPanel.add(label5);
//        parentSearchResultPanel.setOpaque(true);        
//        parentSearchResultPanel.setBackground(Color.red);

       
        // Parent Panel
        parentPanel = new JPanel();
        parentPanel.setLayout(null);
        parentPanel.add(parentTitleLabel);
        parentPanel.add(parentSearchField);
        parentPanel.add(parentSearchButton);
//        parentPanel.add(parentSearchResultPanel);
        
        
        
        
//        JScrollPane scrollPane=new JScrollPane(panel, 
//   ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,  
//   ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        
        
    }
    
      
    
    public void actionPerformed(ActionEvent e) {
//        System.out.println("action performed");
//        c.add(loginPanel);

        if(e.getSource()==loginSubmitButton){
            System.out.println("submit Button");
            cardlayout.show(allPanels, "bp");
//            System.out.println(s);
        }
        
        if(e.getSource()==loginParentButton){
            System.out.println("parent Button");
            cardlayout.show(allPanels, "pp");
//            cardlayout.
//            System.out.println(s);
        }
        
        if(e.getSource()==parentSearchField){
//            System.out.println("Search field\n" + e.getActionCommand());
//            System.out.println(s);
        }
        
        // Parent searching for coaches
        if(e.getSource()==parentSearchButton){
            System.out.println("Searching for " + parentSearchField.getText());   
            ArrayList<Coach> res = new ArrayList<Coach>();
            for(Coach c : coachesAL){
                if(c.getFullName().toLowerCase().contains(parentSearchField.getText().toLowerCase())){
                    System.out.println(c.getId()+"\t"+c.getFullName()+ "\t"+c.getExpertiseString()+"\t"+c.getOfficeHour());
                    res.add(c);
                }
            }
            coachSearchResult = res;
            showCoachSearchResult();
        }
        
    }
    
    public void showCoachSearchResult(){
        JLabel idLabel = new JLabel("ID");
        JLabel nameLabel = new JLabel("Coach Name");
        JLabel phoneLabel = new JLabel("Mobile No.");
        JLabel expertiseLabel = new JLabel("Expertise");
        JLabel officeHourLabel = new JLabel("Office Hours");
        parentSearchResultPanel.add(idLabel);
        parentSearchResultPanel.add(nameLabel);
        parentSearchResultPanel.add(phoneLabel);
        parentSearchResultPanel.add(expertiseLabel);
        parentSearchResultPanel.add(officeHourLabel);
        
                
        for(Coach c : coachSearchResult) {   
            parentSearchResultPanel.add(new JLabel(c.getId()+""));
            parentSearchResultPanel.add(new JLabel(c.getFullName()));
            parentSearchResultPanel.add(new JLabel(c.getTelephoneNo()));
            parentSearchResultPanel.add(new JLabel(c.getExpertiseString()));
//            parentSearchResultPanel.add(new JLabel(c.getOfficeHour()));
            JPanel officeHourPanel = new JPanel();
            officeHourPanel.setLayout(new GridLayout(3,0));
            officeHourPanel.setSize(100,100);
            officeHourPanel.add(new JLabel(c.getOfficeHour()));
            officeHourPanel.add(new JLabel(c.getOfficeHour()));
            officeHourPanel.add(new JLabel(c.getOfficeHour()));
            parentSearchResultPanel.add(officeHourPanel);
        }
        
        parentPanel.add(parentSearchResultPanel);
        
        
        
        
    }
    
    
        
}
