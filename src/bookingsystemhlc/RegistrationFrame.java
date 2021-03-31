/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookingsystemhlc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author abdul
 */
public class RegistrationFrame extends JFrame implements ActionListener{

    private Container c;
    private CardLayout cardlayout;
    private JPanel allPanels;
    private JPanel registrationPanel;
    private JPanel bookingPanel;
    
    private JLabel titleLabel;
    private JLabel nameLabel;
    
    private JTextField studentNameField;
    
    private JButton parentButton;
    private JButton submitButton;
    
    public RegistrationFrame(){
        super("Registration Form");
//        setBounds(300, 90, 900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setSize(1000,750);
        
        c = getContentPane();
//        c.setLayout(null);
        cardlayout = new CardLayout();
        allPanels = new JPanel(cardlayout);
        
        generateRegistrationPanel();


        allPanels.add(registrationPanel,"rp");
//        allPanels.add(bookingPanel,"bp");
        
        c.add(allPanels);

        setVisible(true);
        
    }
    
    public void generateRegistrationPanel(){                      
        titleLabel = new JLabel("Student Registration");
        titleLabel.setSize(300, 50);
        titleLabel.setLocation(450,25);

        nameLabel = new JLabel("Student Name: ");
        nameLabel.setSize(300, 50);
        nameLabel.setLocation(300,110);
            
        studentNameField = new JTextField();
        studentNameField.setSize(400,50);
        studentNameField.setLocation(300,150);
        studentNameField.addActionListener(this);
        
        submitButton = new JButton("Submit");
        submitButton.setSize(100,50);
        submitButton.setLocation(450, 250);
        submitButton.addActionListener(this);
        
        
        // Panel
        registrationPanel = new JPanel();
        registrationPanel.setLayout(null);
        
        registrationPanel.add(titleLabel);
        registrationPanel.add(nameLabel);
        registrationPanel.add(studentNameField);
        registrationPanel.add(submitButton);        
}
    
      
    
    public void actionPerformed(ActionEvent e) {
//        System.out.println("action performed");
//        c.add(registrationPanel);

        if(e.getSource()==submitButton){
            System.out.println("submit Button");
            cardlayout.show(allPanels, "bp");
//            System.out.println(s);
        }
    }
    
    
        
}
