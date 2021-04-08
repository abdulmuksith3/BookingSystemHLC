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
import javax.swing.border.EmptyBorder;

public class GraphicsFrame extends JFrame implements ActionListener{
    private ArrayList<Coach> coachesAL;
    private ArrayList<Student> studentsAL;
    private ArrayList<Lessons> lessonsAL;
    private ArrayList<Bookings> bookingsAL;
    private ArrayList<Lessons> lessonsAL2;
    private Student student = null;
    
    private Container c;
    
    private JPanel mainPanel;
    private JPanel studentPanel;
    private JPanel parentPanel;
    
    private JLabel loginTitleLabel;
    private JLabel loginStudentNameLabel;    
    private JTextField loginStudentNameField;    
    private JButton loginParentButton;
    private JButton loginSubmitButton;
    
    private JTextField studentSearchField;
    private JButton studentSearchButton;
    private String[] searchType = {"Expertise","Coach"};
    private JComboBox searchTypeDropdown;
    private JTable lessonsTable;
    

    public GraphicsFrame(ArrayList<Coach> coachesAL, ArrayList<Student> studentsAL, ArrayList<Lessons> lessonsAL, ArrayList<Bookings> bookingsAL){
        super("Booking System HLC");
        this.coachesAL = coachesAL;
        this.studentsAL = studentsAL;
        this.lessonsAL = lessonsAL;
        this.bookingsAL = bookingsAL;
        this.lessonsAL2 = lessonsAL;
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setLayout (new BoxLayout(getContentPane (), BoxLayout.Y_AXIS));
//        setLayout(new BorderLayout());
        
        
        c = getContentPane();
        
        generateMainPanel();
        
        add(mainPanel);
        
//        for (int i = 0; i < 10; i++) {
//            
//            JLabel label2 = new JLabel ("Label 2");
//            label2.setToolTipText("Tool tip for label 2");
//            label2.setPreferredSize(new Dimension(200,200));
//            add (label2);
//        }
        

        setResizable(true);
        setSize(900, 650);
        setVisible(true);
    }
    
    public void generateMainPanel(){
        mainPanel = new JPanel(new BorderLayout());
//        mainPanel.setLayout(new BorderLayout());
        
        loginTitleLabel = new JLabel("Student Registration");
        loginTitleLabel.setPreferredSize(new Dimension(200,200));
        loginTitleLabel.setFont(new Font("Serif", Font.BOLD, 25));
//        loginTitleLabel.setOpaque(true);
//        loginTitleLabel.setBackground(Color.yellow);
        loginTitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        loginTitleLabel.setVerticalAlignment(SwingConstants.CENTER);
        mainPanel.add(loginTitleLabel, BorderLayout.NORTH);
        
        
        loginStudentNameLabel = new JLabel("Enter Your Name: ");
        loginStudentNameLabel.setSize(new Dimension(200,200));
//        add(loginStudentNameLabel, BorderLayout.CENTER);
        
        loginStudentNameField = new JTextField();
        loginStudentNameField.setPreferredSize(new Dimension(500,50));
//        loginStudentNameField.setSize(50,50);
        loginStudentNameField.addActionListener(this);
//        add(loginStudentNameField, BorderLayout.CENTER);
        
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(4,0));        
        
        JPanel rowOne = new JPanel(new FlowLayout());
        rowOne.add(loginStudentNameLabel);
        rowOne.add(loginStudentNameField);
        
//        centerPanel.add(loginStudentNameLabel);
        centerPanel.add(rowOne);
        mainPanel.add(centerPanel, BorderLayout.CENTER);
        
        loginParentButton = new JButton("Parent Login");
        loginParentButton.setPreferredSize(new Dimension(100,50));
        loginParentButton.addActionListener(this);
        
        loginSubmitButton = new JButton("Student Login");
        loginSubmitButton.setPreferredSize(new Dimension(100,50));
        loginSubmitButton.addActionListener(this);
        
        JPanel southPanel = new JPanel();        
        southPanel.setLayout(new GridLayout(2,0));        
        southPanel.add(loginSubmitButton);
        southPanel.add(loginParentButton);
        mainPanel.add(southPanel, BorderLayout.SOUTH);           
    }
    
    public void generateStudentPanel(){
        studentPanel = new JPanel(new BorderLayout());
        
        JLabel greetingLabel = new JLabel("Hello " + student.getFullName()+"!");
        greetingLabel.setPreferredSize(new Dimension(200,100));
        greetingLabel.setFont(new Font("Serif",Font.BOLD,25));
        greetingLabel.setBorder(new EmptyBorder(0,30,0,0));
        studentPanel.add(greetingLabel, BorderLayout.NORTH);
        
        studentSearchField = new JTextField();
        studentSearchField.setPreferredSize(new Dimension(625,50));
//        studentPanel.add(studentSearchField, BorderLayout.CENTER);
        
        searchTypeDropdown = new JComboBox(searchType);
//        searchTypeDropdown.setSelectedIndex(0);
        searchTypeDropdown.setPreferredSize(new Dimension(100,50));
//        studentPanel.add(searchTypeDropdown, BorderLayout.CENTER);
        
        studentSearchButton = new JButton("Search");
        studentSearchButton.setPreferredSize(new Dimension(100,50));
//        studentPanel.add(studentSearchButton, BorderLayout.CENTER);
        studentSearchButton.addActionListener(this);
        
//        JPanel centerPanel = new JPanel(new GridLayout(2,0));
        JPanel centerPanel = new JPanel(new BorderLayout());
//        centerPanel.setLayout(new BoxLayout(centerPanel,BoxLayout.Y_AXIS));
        JPanel rowOne = new JPanel(new FlowLayout());
        rowOne.add(studentSearchField);
        rowOne.add(searchTypeDropdown);
        rowOne.add(studentSearchButton);
//        rowOne.setSize(200,200);
//        centerPanel.setSize(200,200);
        
        JPanel rowTwo = new JPanel(new BorderLayout());
        String[] columnNames = {"ID", "Expertise", "Coach", };
        lessonsTable = new JTable(lessonsAL2.size(), 7);      
        
        rowTwo.add(lessonsTable, BorderLayout.CENTER);
        
        JScrollPane scrollPanel = new JScrollPane(rowTwo);
        scrollPanel.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPanel.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        
        centerPanel.add(rowOne,BorderLayout.NORTH);
        centerPanel.add(scrollPanel, BorderLayout.CENTER);
        
        studentPanel.add(centerPanel, BorderLayout.CENTER);
        
        add(studentPanel);
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {        
//        String res ="";
        
        if(e.getSource() == loginSubmitButton){
//            res = "studentlogin";
            studentLogin();
        }
        if(e.getSource() == loginParentButton){
//            res = "parentlogin";
            parentLogin();
        }
        if(e.getSource() == studentSearchButton){
//            System.out.println(searchTypeDropdown.getSelectedItem());
            studentSearch();
        }
        
//        switch(res){
//            case "studentlogin":
//                int count = 0;
//                System.out.println("Student trying to Login");
//                String studentName = loginStudentNameField.getText();
//                for(Student s : studentsAL){
//                    if(s.getFullName().equalsIgnoreCase(studentName)){
//                        student = s;
//                        mainPanel.setVisible(false);
//                        generateStudentPanel();
//                        System.out.println("Logged in: " + s.getFullName());
//                    } else {
////                        break;
//                           count++;
//                    }
//                }
//                if(count == studentsAL.size()){
//                    System.out.println("New Student");
//                }
//                
//                break;
//            case "parentlogin":
//                System.out.println("parent");
//                break;
//    }
        
    }
    
    public void studentLogin(){
        
        int count = 0;
        System.out.println("Student trying to Login");
        String studentName = loginStudentNameField.getText();
        
        for(Student s : studentsAL){
                    if(s.getFullName().equalsIgnoreCase(studentName)){
                        student = s;
                        mainPanel.setVisible(false);
                        generateStudentPanel();
                        System.out.println("Logged in: " + s.getFullName());
                    } else {
//                        break;
                           count++;
                    }
        }
        if(count == studentsAL.size()){
                    System.out.println("New Student");
        }
    }
    
    public void parentLogin(){
        
    }
    
    public void studentSearch(){
        String searchType = searchTypeDropdown.getSelectedItem()+"";
        String searchValue = studentSearchField.getText();
        
        if(searchType.equals("Expertise")){
            System.out.println("Expertise Search");
            for(Lessons l : lessonsAL){
            if(l.getName().toLowerCase().contains(searchValue.toLowerCase())){
                System.out.println(l.getId() + "\t"+l.getName() +"\t"+l.getCoach().getFullName()+ "\t"+l.getDateTime()+ "\t"+l.getPlace()+"\t"+l.getCapacity());
            }
        }
        }
        if(searchType.equals("Coach")){
            System.out.println("Coach Search");
            for(Lessons l : lessonsAL){
            if(l.getCoach().getFullName().toLowerCase().contains(searchValue.toLowerCase())){
                System.out.println(l.getId() + "\t"+l.getName() +"\t"+l.getCoach().getFullName()+ "\t"+l.getDateTime()+ "\t"+l.getPlace()+"\t"+l.getCapacity());
            }
        }
        }
        
        System.out.println(searchType + "-------" + searchValue);

    }
    
}
