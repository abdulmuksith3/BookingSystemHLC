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

public class GraphicsFrame extends JFrame implements ActionListener{
    private ArrayList<Coach> coachesAL;
    private ArrayList<Student> studentsAL;
    private ArrayList<Bookings> bookingsAL;
    
    private Student student = null;
    
    private Container c;
    
    private JPanel mainPanel;
    private JPanel existingStudentPanel;
    private JPanel newStudentPanel;
    private JPanel parentPanel;
    
    private JLabel loginTitleLabel;
    private JLabel loginStudentNameLabel;    
    private JTextField loginStudentNameField;    
    private JButton loginParentButton;
    private JButton loginSubmitButton;
    
    private JTextField studentSearchField;
    private JButton studentSearchButton;
    private JComboBox searchType;
    

    public GraphicsFrame(ArrayList<Coach> coachesAL, ArrayList<Student> studentsAL, ArrayList<Bookings> bookingsAL){
        super("Booking System HLC");
        this.coachesAL = coachesAL;
        this.studentsAL = studentsAL;
        this.bookingsAL = bookingsAL;
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setLayout (new BoxLayout(getContentPane (), BoxLayout.Y_AXIS));
//        setLayout(new BorderLayout());
        setResizable(false);
        setSize(1000, 750);
        setVisible(true);
        
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
        

        
    }
    
    public void generateMainPanel(){
        mainPanel = new JPanel(new BorderLayout());
//        mainPanel.setLayout(new BorderLayout());
        
        loginTitleLabel = new JLabel("Student Registration");
        loginTitleLabel.setPreferredSize(new Dimension(200,200));
//        loginTitleLabel.setOpaque(true);
//        loginTitleLabel.setBackground(Color.yellow);
        loginTitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        loginTitleLabel.setVerticalAlignment(SwingConstants.CENTER);
        mainPanel.add(loginTitleLabel, BorderLayout.NORTH);
        
        
        loginStudentNameLabel = new JLabel("Enter Your Name: ");
        loginStudentNameLabel.setPreferredSize(new Dimension(200,200));
//        add(loginStudentNameLabel, BorderLayout.CENTER);
        
        loginStudentNameField = new JTextField();
        loginStudentNameField.setPreferredSize(new Dimension(50,50));
//        loginStudentNameField.setSize(50,50);
        loginStudentNameField.addActionListener(this);
//        add(loginStudentNameField, BorderLayout.CENTER);
        
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(4,0));
        centerPanel.add(loginStudentNameLabel);
        centerPanel.add(loginStudentNameField);
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
    
    public void generateExisitingStudentPanel(){
        existingStudentPanel = new JPanel(new BorderLayout());
        
        studentSearchField = new JTextField();
        
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {        
        String res ="";
        
        if(e.getSource() == loginSubmitButton){
            res = "studentlogin";
        }
        if(e.getSource() == loginParentButton){
            res = "parentlogin";
        }
        
        switch(res){
            case "studentlogin":
                System.out.println("Student trying to Login");
                String studentName = loginStudentNameField.getText();
                for(Student s : studentsAL){
                    if(s.getFullName().equalsIgnoreCase(studentName)){
                        student = s;
                        mainPanel.setVisible(false);
                        System.out.println("Logged in: " + s.getFullName());
                    } else {
                        System.out.println("New Student");
                    }
                }
                
                break;
            case "parentlogin":
                System.out.println("parent");
                break;
    }
        
    }
    
}
