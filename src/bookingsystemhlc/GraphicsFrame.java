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
    private Container c;
    
    private JPanel mainPanel;
    private JPanel parentPanel;
    
    private JLabel loginTitleLabel;
    private JLabel loginStudentNameLabel;    
    private JTextField loginStudentNameField;    
    private JButton loginParentButton;
    private JButton loginSubmitButton;

    public GraphicsFrame(ArrayList<Coach> coachesAL, ArrayList<Student> studentsAL, ArrayList<Bookings> bookingsAL){
        super("Booking System HLC");
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setLayout (new BoxLayout(getContentPane (), BoxLayout.Y_AXIS));
        setResizable(false);
        setSize(1000, 750);
        setVisible(true);
        
        c = getContentPane();
        
        generateMainPanel();
        
        
//        for (int i = 0; i < 10; i++) {
//            
//            JLabel label2 = new JLabel ("Label 2");
//            label2.setToolTipText("Tool tip for label 2");
//            label2.setPreferredSize(new Dimension(200,200));
//            add (label2);
//        }
        

        
    }
    
    public void generateMainPanel(){
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        
        loginTitleLabel = new JLabel("Student Registration");
        loginTitleLabel.setPreferredSize(new Dimension(200,200));
//        loginTitleLabel.setOpaque(true);
//        loginTitleLabel.setBackground(Color.yellow);
         loginTitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        loginTitleLabel.setVerticalAlignment(SwingConstants.CENTER);
        add(loginTitleLabel, BorderLayout.NORTH);
        
        loginStudentNameLabel = new JLabel("Enter Your Name: ");
        loginStudentNameLabel.setPreferredSize(new Dimension(200,200));
        add(loginStudentNameLabel, BorderLayout.CENTER);
        
        loginStudentNameField = new JTextField();
//        loginStudentNameField.setPreferredSize(new Dimension(50,50));
//        loginStudentNameField.setSize(50,50);
        loginStudentNameField.addActionListener(this);
        add(loginStudentNameField, BorderLayout.CENTER);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
