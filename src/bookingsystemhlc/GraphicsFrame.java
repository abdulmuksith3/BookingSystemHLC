/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookingsystemhlc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.border.EmptyBorder;

public class GraphicsFrame extends JFrame implements ActionListener {

    private ArrayList<Coach> coachesAL;
    private ArrayList<Student> studentsAL;
    private ArrayList<Lessons> lessonsAL;
    private ArrayList<Bookings> bookingsAL;

    private ArrayList<Lessons> lessonsAL2;
    private ArrayList<Coach> coachesAL2;

    private Student student = null;
    private ArrayList<Bookings> studentBookings = new ArrayList<Bookings>();

    private Container c;

    private JPanel mainPanel;
    private JPanel studentPanel;
    private JPanel parentPanel;
    private JPanel bookingPanel;
    private JPanel coachAppointmentPanel;

    private JLabel loginTitleLabel;
    private JLabel loginStudentNameLabel;
    private JTextField loginStudentNameField;
    private JButton loginParentButton;
    private JButton loginSubmitButton;

    private JTextField studentSearchField;
    private JButton studentSearchButton;
    private String[] searchType = {"Expertise", "Coach"};
    private JComboBox searchTypeDropdown;
    private JScrollPane scrollPanel;
    private JTable lessonsTable;

    private JButton myBookingsButton;

    private JButton studentPanelButton;

    private String parentName;
    private JTextField parentSearchField;
    private JButton parentSearchButton;
    private JButton parentBookingButton;
    private JTable coachesTable;
    private JTable appointmentTable;
    private Coach selectedCoach;

    public GraphicsFrame(ArrayList<Coach> coachesAL, ArrayList<Student> studentsAL, ArrayList<Lessons> lessonsAL, ArrayList<Bookings> bookingsAL) {
        super("Booking System HLC");
        this.coachesAL = coachesAL;
        this.studentsAL = studentsAL;
        this.lessonsAL = lessonsAL;
        this.bookingsAL = bookingsAL;
        this.lessonsAL2 = lessonsAL;
        this.coachesAL2 = coachesAL;

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

    public void generateMainPanel() {
        mainPanel = new JPanel(new BorderLayout());
//        mainPanel.setLayout(new BorderLayout());

        loginTitleLabel = new JLabel("Student Registration");
        loginTitleLabel.setPreferredSize(new Dimension(200, 200));
        loginTitleLabel.setFont(new Font("Serif", Font.BOLD, 25));
//        loginTitleLabel.setOpaque(true);
//        loginTitleLabel.setBackground(Color.yellow);
        loginTitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        loginTitleLabel.setVerticalAlignment(SwingConstants.CENTER);
        mainPanel.add(loginTitleLabel, BorderLayout.NORTH);

        loginStudentNameLabel = new JLabel("Enter Your Name: ");
        loginStudentNameLabel.setSize(new Dimension(200, 200));
//        add(loginStudentNameLabel, BorderLayout.CENTER);

        loginStudentNameField = new JTextField();
        loginStudentNameField.setPreferredSize(new Dimension(500, 50));
//        loginStudentNameField.setSize(50,50);
        loginStudentNameField.addActionListener(this);
//        add(loginStudentNameField, BorderLayout.CENTER);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(4, 0));

        JPanel rowOne = new JPanel(new FlowLayout());
        rowOne.add(loginStudentNameLabel);
        rowOne.add(loginStudentNameField);

//        centerPanel.add(loginStudentNameLabel);
        centerPanel.add(rowOne);
        mainPanel.add(centerPanel, BorderLayout.CENTER);

        loginParentButton = new JButton("Parent Login");
        loginParentButton.setPreferredSize(new Dimension(100, 50));
        loginParentButton.addActionListener(this);

        loginSubmitButton = new JButton("Student Login");
        loginSubmitButton.setPreferredSize(new Dimension(100, 50));
        loginSubmitButton.addActionListener(this);

        JPanel southPanel = new JPanel();
        southPanel.setLayout(new GridLayout(2, 0));
        southPanel.add(loginSubmitButton);
        southPanel.add(loginParentButton);
        mainPanel.add(southPanel, BorderLayout.SOUTH);
    }

    public void generateStudentPanel() {
        studentPanel = new JPanel(new BorderLayout());

        JLabel greetingLabel = new JLabel("Hello " + student.getFullName() + "!");
        greetingLabel.setPreferredSize(new Dimension(200, 100));
        greetingLabel.setFont(new Font("Serif", Font.BOLD, 25));
        greetingLabel.setBorder(new EmptyBorder(0, 30, 0, 0));
        studentPanel.add(greetingLabel, BorderLayout.NORTH);

        studentSearchField = new JTextField();
        studentSearchField.setPreferredSize(new Dimension(625, 50));
//        studentPanel.add(studentSearchField, BorderLayout.CENTER);

        searchTypeDropdown = new JComboBox(searchType);
//        searchTypeDropdown.setSelectedIndex(0);
        searchTypeDropdown.setPreferredSize(new Dimension(100, 50));
//        studentPanel.add(searchTypeDropdown, BorderLayout.CENTER);

        studentSearchButton = new JButton("Search");
        studentSearchButton.setPreferredSize(new Dimension(100, 50));
//        studentPanel.add(studentSearchButton, BorderLayout.CENTER);
        studentSearchButton.addActionListener(this);

//        JPanel centerPanel = new JPanel(new GridLayout(2,0));
        JPanel centerPanel = new JPanel(new BorderLayout());
//        centerPanel.setLayout(new BoxLayout(centerPanel,BoxLayout.Y_AXIS));
        JPanel rowOne = new JPanel(new FlowLayout());
        rowOne.add(studentSearchField);
        rowOne.add(searchTypeDropdown);
        rowOne.add(studentSearchButton);
//        rowOne.setSize(200,500);
        rowOne.setPreferredSize(new Dimension(200, 100));
//        centerPanel.setSize(200,200);

//        JPanel rowTwo = new JPanel(new BorderLayout());        
//        lessonsTable = new JTable(lessonsAL2.size()+1, 7);
//        for (int j = 0; j < columnNames.length; j++) {
//            String columnName = columnNames[j];
//            lessonsTable.setValueAt(columnName, 0, j);
//        }
//
//        for (int i = 0; i < lessonsAL2.size(); i++) {
//            int k = i + 1;
//            lessonsTable.setValueAt(lessonsAL2.get(i).getId(), k, 0);
//            lessonsTable.setValueAt(lessonsAL2.get(i).getName(), k, 1);
//            lessonsTable.setValueAt(lessonsAL2.get(i).getCoach().getFullName(),k, 2);
//            lessonsTable.setValueAt(lessonsAL2.get(i).getDateTime(), k, 3);
//            lessonsTable.setValueAt(lessonsAL2.get(i).getPlace(), k, 4);
//            lessonsTable.setValueAt(lessonsAL2.get(i).getCapacity(), k, 5);
//            if(lessonsAL2.get(i).getCapacity() <= 0) {
//                lessonsTable.setValueAt("Lesson Full", k, 6);
//            } else {
//              lessonsTable.setValueAt("Click here to Book", k, 6);
//            }            
//        }
        String[][] tableData = new String[lessonsAL2.size()][];
        String[] columnNames = {"Lesson ID", "Expertise", "Coach", "Date&Time", "Location", "Capacity", "Book"};
        int counter = 0;
        for (Lessons l : lessonsAL2) {
            String bookingButton = "Click Here to Book";
            if (l.getCapacity() == 0) {
                bookingButton = "Lesson Full";
            }
            if (!studentBookings.isEmpty()) {
                for (Bookings b : studentBookings) {
                    if (b.getStatus().equals("Cancelled")) {
                        System.out.println("Cancelled Booking");
                    } else if (b.getLesson().getId() == l.getId()) {
                        bookingButton = "Booked";
                    } else if (b.getLesson().getDateTime().equals(l.getDateTime())) {
                        bookingButton = "Time Conflict";
                    }

                }
            }

            String[] tempData = {l.getId() + "", l.getName(), l.getCoach().getFullName(), getDateTimeString(l.getDateTime()), l.getPlace(), l.getCapacity() + "", bookingButton};
            tableData[counter] = tempData;
            counter++;
        }
        lessonsTable = new JTable(tableData, columnNames);

//        lessonsTable.setFillsViewportHeight(true); 
//        lessonsTable.setRowHeight(0, 50);
        lessonsTable.setRowSelectionAllowed(false);
        lessonsTable.setColumnSelectionAllowed(false);
//        System.out.println(lessonsTable.getCellSelectionEnabled());
        lessonsTable.setCellSelectionEnabled(true);
//        lessonsTable.setEnabled(false);
        lessonsTable.getTableHeader().setReorderingAllowed(false);
        lessonsTable.getColumnModel().getColumn(3).setPreferredWidth(120);
        lessonsTable.getColumnModel().getColumn(6).setPreferredWidth(120);
//        System.out.println(lessonsTable.getSelectedColumn());
//        System.out.println(lessonsTable.getCellSelectionEnabled());
        lessonsTable.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mousePressed(MouseEvent e) {
//                System.out.println("-------" + lessonsTable.getSelectedColumn()+"--"+lessonsTable.getSelectedRow());
//                System.out.println(e);
//                System.out.println(lessonsTable.getValueAt(lessonsTable.getSelectedRow(),  lessonsTable.getSelectedColumn()));
                System.out.println("Student Trying to Book Lesson");
                studentLessonBooking();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseEntered(MouseEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseExited(MouseEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });

//        System.out.println(lessonsTable.);
//                lessonsTable.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
//        rowTwo.add(lessonsTable, BorderLayout.CENTER);
//        JScrollPane scrollPanel = new JScrollPane(rowTwo);
        scrollPanel = new JScrollPane(lessonsTable);
        scrollPanel.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPanel.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

        centerPanel.add(rowOne, BorderLayout.NORTH);
        centerPanel.add(scrollPanel, BorderLayout.CENTER);

        studentPanel.add(centerPanel, BorderLayout.CENTER);
        JPanel emptyWest = new JPanel();
        JPanel emptyEast = new JPanel();
        myBookingsButton = new JButton("My TimeTable");
        myBookingsButton.addActionListener(this);
        emptyEast.add(myBookingsButton);
        JPanel emptySouth = new JPanel();

        studentPanel.add(emptyEast, BorderLayout.EAST);
        studentPanel.add(emptyWest, BorderLayout.WEST);
        studentPanel.add(emptySouth, BorderLayout.SOUTH);
        add(studentPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        String res ="";

        if (e.getSource() == loginSubmitButton) {
//            res = "studentlogin";
            studentLogin();
        }
        if (e.getSource() == loginParentButton) {
//            res = "parentlogin";
            parentLogin();
        }
        if (e.getSource() == studentSearchButton) {
//            System.out.println(searchTypeDropdown.getSelectedItem());
            studentSearch();
        }
        if (e.getSource() == myBookingsButton) {
            generateMyBookings();
        }
        if (e.getSource() == studentPanelButton) {
//            System.out.println("studentPanel-------");
            bookingPanel.setVisible(false);
            generateStudentPanel();
        }
        if (e.getSource() == parentSearchButton) {
            parentPanel.setVisible(false);
            parentSearch();
            parentLogin();
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

    public void studentLogin() {

        int count = 0;
        System.out.println("Student trying to Login");
        String studentName = loginStudentNameField.getText();

        for (Student s : studentsAL) {
            if (s.getFullName().equalsIgnoreCase(studentName)) {
                student = s;

                for (Bookings b : bookingsAL) {
                    if(b.getBookingType().equals("Lesson")){
                    if (b.getStudent().equals(s)) {
                        studentBookings.add(b);
//                        System.out.println("My Booking " + b.getId() + " " + b.getLesson().getName() + " " + b.getLesson().getCoach().getFullName() + " " + b.getLesson().getDateTime());
                    }}
                }
                mainPanel.setVisible(false);
                generateStudentPanel();
//                System.out.println("Logged in: " + s.getFullName());
//                System.out.println("Total Bookings: " + studentBookings.size());
            } else {
//                        break;
                count++;
            }
        }
        if (count == studentsAL.size()) {
            System.out.println("New Student");
        }
    }

    public void parentLogin() {
        parentPanel = new JPanel(new BorderLayout());
        parentName = loginStudentNameField.getText();

        JLabel titleLabel = new JLabel("Welcome " + parentName + "!");
        titleLabel.setPreferredSize(new Dimension(500, 100));

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(titleLabel);

        JPanel midPanel = new JPanel(new BorderLayout());
        JPanel midPanelTop = new JPanel(new FlowLayout());
        midPanelTop.setPreferredSize(new Dimension(700, 100));
        parentSearchField = new JTextField();
        parentSearchField.setPreferredSize(new Dimension(700, 50));
        parentSearchButton = new JButton("Search");
        parentSearchButton.setPreferredSize(new Dimension(150, 50));
        parentSearchButton.addActionListener(this);

        midPanelTop.add(parentSearchField);
        midPanelTop.add(parentSearchButton);

        String[] columnNames = {"Coach ID", "Name", "Phone", "Expertise", "Office Hours", "Book"};
        String[][] tableData = new String[coachesAL2.size()][];
        int counter = 0;

        for (Coach c : coachesAL2) {
            String[] coach = {c.getId() + "", c.getFullName(), c.getTelephoneNo(), c.getExpertiseString(), getOfficeHourShortString(c.getOfficeHour()), "Click Here to Book"};
            tableData[counter] = coach;
            counter++;
        }

        coachesTable = new JTable(tableData, columnNames);
        coachesTable.setRowSelectionAllowed(false);
        coachesTable.setColumnSelectionAllowed(false);
        coachesTable.setCellSelectionEnabled(true);
//        coachesTable.setEnabled(false);
        coachesTable.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mousePressed(MouseEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

                generateCoachAppointmentPanel();

//                coa/
            }

            @Override
            public void mouseReleased(MouseEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseEntered(MouseEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseExited(MouseEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });

        JScrollPane scrollPane = new JScrollPane(coachesTable);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        midPanel.add(midPanelTop, BorderLayout.NORTH);
        midPanel.add(scrollPane, BorderLayout.CENTER);

        JPanel emptyWest = new JPanel();
        JPanel emptyEast = new JPanel();
        JPanel emptySouth = new JPanel();
        parentPanel.add(topPanel, BorderLayout.NORTH);
        parentPanel.add(midPanel, BorderLayout.CENTER);
        parentPanel.add(emptyWest, BorderLayout.WEST);
        parentPanel.add(emptyEast, BorderLayout.EAST);
        parentPanel.add(emptySouth, BorderLayout.SOUTH);

        mainPanel.setVisible(false);
        add(parentPanel);

    }

    public void parentSearch() {
        String searchValue = parentSearchField.getText();
        ArrayList<Coach> tempAL = new ArrayList<Coach>();

        for (Coach c : coachesAL) {
            if (c.getFullName().toLowerCase().contains(searchValue.toLowerCase())) {
                tempAL.add(c);
            }
        }
        coachesAL2 = tempAL;
    }

    public void generateCoachAppointmentPanel() {
        int row = coachesTable.getSelectedRow();
        int column = coachesTable.getSelectedColumn();
        String clickValue = coachesTable.getValueAt(row, column).toString();
        selectedCoach = null;

        if (clickValue.equals("Click Here to Book")) {
            for (Coach c : coachesAL2) {
                if ((c.getId() + "").equals(coachesTable.getValueAt(row, 0))) {
                    selectedCoach = c;
                }
            }
        }

        coachAppointmentPanel = new JPanel(new BorderLayout());
        JPanel topPanel = new JPanel(new BorderLayout());
        JPanel midPanel = new JPanel(new BorderLayout());
        JPanel emptyWest = new JPanel();
        JPanel emptyEast = new JPanel();
        JPanel emptySouth = new JPanel();

        JLabel titleLabel = new JLabel("Coach Name: " + selectedCoach.getFullName());
        titleLabel.setPreferredSize(new Dimension(400, 50));
        JLabel subTitleLabel = new JLabel("Office Hour Timing: " + getOfficeHourShortString(selectedCoach.getOfficeHour()));
        subTitleLabel.setPreferredSize(new Dimension(400, 100));

        topPanel.add(titleLabel, BorderLayout.NORTH);
        topPanel.add(subTitleLabel, BorderLayout.CENTER);

        String[] columnNames = {"Date", "Time", "Book Slot"};
        String[][] tableData = new String[12][];
//        ArrayList<String[]> data = new ArrayList<String[]>();
        ArrayList<Bookings> selectedCoachAppointmentsAL = new ArrayList<Bookings>();
        int counter = 0;
        if (selectedCoach != null) {
            for (Bookings b : bookingsAL) {
//                b.getCoach().getId() == selectedCoach.getId();
//                b.getBookingType().equals("Appointment");
//                b.getSlot();
//                b.getBookingDateTime();
                if (b.getBookingType().equals("Appointment")) {
                    if ((b.getCoach().getId() == selectedCoach.getId()) && b.getStatus().equals("Booked")) {
                        selectedCoachAppointmentsAL.add(b);
                    }
                }

            }
//                String tempDate = getDateTimeShortString(c.getOfficeHour());
//                String oneHour = addHour(c.getOfficeHour());
//                String res = tempDate.concat(" - "+oneHour);
//                System.out.println("res" + res);
//            String officeHour = getOfficeHourShortString(selectedCoach.getOfficeHour());

            for (int i = 0; i < 4; i++) {
//                System.out.println("Week " + (i + 1));
                String[] data1 = null, data2 = null, data3 = null;
                // Slot 1
                String[] tempData1 = {getOfficeHourDate(selectedCoach.getOfficeHour(), i), getOfficeTimeString(selectedCoach.getOfficeHour(), 1), "Click Here to Book"};
                data1 = tempData1;
                //Slot 2
                String[] tempData2 = {getOfficeHourDate(selectedCoach.getOfficeHour(), i), getOfficeTimeString(selectedCoach.getOfficeHour(), 2), "Click Here to Book"};
                data2 = tempData2;
                //Slot 3
                String[] tempData3 = {getOfficeHourDate(selectedCoach.getOfficeHour(), i), getOfficeTimeString(selectedCoach.getOfficeHour(), 3), "Click Here to Book"};
                data3 = tempData3;

                for (Bookings b : selectedCoachAppointmentsAL) {
                    if (b.getBookingDateTime().equals(getOfficeHourLongDate(selectedCoach.getOfficeHour(), i)) && b.getSlot() == 1) {
                        String[] tempData = {getOfficeHourDate(selectedCoach.getOfficeHour(), i), getOfficeTimeString(selectedCoach.getOfficeHour(), 1), "Booked"};
                        data1 = tempData;
                    } else if (b.getBookingDateTime().equals(getOfficeHourLongDate(selectedCoach.getOfficeHour(), i)) && b.getSlot() == 2) {
                        String[] tempData = {getOfficeHourDate(selectedCoach.getOfficeHour(), i), getOfficeTimeString(selectedCoach.getOfficeHour(), 2), "Booked"};
                        data2 = tempData;
                    } else if (b.getBookingDateTime().equals(getOfficeHourLongDate(selectedCoach.getOfficeHour(), i)) && b.getSlot() == 3) {
                        String[] tempData = {getOfficeHourDate(selectedCoach.getOfficeHour(), i), getOfficeTimeString(selectedCoach.getOfficeHour(), 3), "Booked"};
                        data3 = tempData;
                    }
                }

                tableData[counter] = data1;
                tableData[counter + 1] = data2;
                tableData[counter + 2] = data3;
                counter += 3;
//                data.add(tempData1);
//                data.add(tempData2);
//                data.add(tempData3);
            }

        }

        appointmentTable = new JTable(tableData, columnNames);
        appointmentTable.setRowSelectionAllowed(false);
        appointmentTable.setColumnSelectionAllowed(false);
        appointmentTable.setCellSelectionEnabled(true);
//        appointmentTable.setEnabled(false);
        appointmentTable.setRowHeight(35);
        appointmentTable.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mousePressed(MouseEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                handleAppointmentBooking();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseEntered(MouseEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseExited(MouseEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

        });
//        JTable appointmentTable = new JTable(5, 5);

        JScrollPane scrollPane = new JScrollPane(appointmentTable);

        midPanel.add(scrollPane, BorderLayout.CENTER);

        coachAppointmentPanel.add(topPanel, BorderLayout.NORTH);
        coachAppointmentPanel.add(midPanel, BorderLayout.CENTER);
        coachAppointmentPanel.add(emptyWest, BorderLayout.WEST);
        coachAppointmentPanel.add(emptyEast, BorderLayout.EAST);
        coachAppointmentPanel.add(emptySouth, BorderLayout.SOUTH);

        parentPanel.setVisible(false);
        add(coachAppointmentPanel);
    }

    public void studentSearch() {
        String searchType = searchTypeDropdown.getSelectedItem() + "";
        String searchValue = studentSearchField.getText();
        ArrayList<Lessons> tempAL = new ArrayList<Lessons>();
        if (searchType.equals("Expertise")) {
            System.out.println("Expertise Search");
//            tempAL.clear();
            for (Lessons l : lessonsAL) {
                if (l.getName().toLowerCase().contains(searchValue.toLowerCase())) {
                    System.out.println(l.getId() + "\t" + l.getName() + "\t" + l.getCoach().getFullName() + "\t" + l.getDateTime() + "\t" + l.getPlace() + "\t" + l.getCapacity());
                    tempAL.add(l);
                }
            }
        } else if (searchType.equals("Coach")) {
            System.out.println("Coach Search");
//            tempAL.clear();
            for (Lessons l : lessonsAL) {
                if (l.getCoach().getFullName().toLowerCase().contains(searchValue.toLowerCase())) {
                    System.out.println(l.getId() + "\t" + l.getName() + "\t" + l.getCoach().getFullName() + "\t" + l.getDateTime() + "\t" + l.getPlace() + "\t" + l.getCapacity());
                    tempAL.add(l);
                }
            }
        }

        lessonsAL2 = tempAL;

        studentPanel.setVisible(false);
        generateStudentPanel();

//        System.out.println(searchType + "-------" + searchValue);
//        studentPanel.remove(lessonsTable);
//        String[][] d = new String[2][];
//        tableData = d;
//        JTable tempTable = new JTable(d, columnNames);
//        scrollPanel.add(tempTable);
//        lessonsTable=tempTable;
//        System.out.println("------" + lessonsAL2.size());
//        studentPanel.revalidate();
//        studentPanel.repaint();
//        System.out.println("------" + lessonsAL2.size());
//        studentPanel.updateUI();
//        studentPanel.validate();
//        studentPanel.revalidate();
//        studentPanel.repaint();
    }

//    public JTabel getSearchResult(){
//        JTabel = new JTable()
//        return 
//    }
    public void studentLessonBooking() {
//        System.out.println("-------------------------------");
        int row = lessonsTable.getSelectedRow();
        int column = lessonsTable.getSelectedColumn();
//        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++");
        String selectedValue = lessonsTable.getValueAt(row, column).toString();
        System.out.println(row + "" + column + "" + selectedValue);

        Lessons selectedLesson = null;
        for (Lessons l : lessonsAL2) {
            if ((l.getId() + "").equals(lessonsTable.getValueAt(row, 0).toString())) {
//                System.out.println("id"+l.getId() + l.getName());
                selectedLesson = l;
            }
        }

        if (selectedValue.equals("Click Here to Book")) {
            System.out.println("Booking");
            int res = JOptionPane.showConfirmDialog(studentPanel, "Please confirm that you would like to book the lesson " + selectedLesson.getName() + " on " + selectedLesson.getDateTime(), "Confirm Booking", JOptionPane.YES_NO_OPTION);
//            System.out.println("RES " + res);
            if (res == JOptionPane.YES_OPTION) {
//                System.out.println("YES CHOSEN-BOOKED");
                if (selectedLesson.getCapacity() > 0) {
                    lessonsAL.get(lessonsAL.indexOf(selectedLesson)).setCapacity(selectedLesson.getCapacity() - 1);
//                    lessonsAL2.get(lessonsAL2.indexOf(selectedLesson)).setCapacity(selectedLesson.getCapacity()-1);
                    Bookings newBooking = new Bookings(student, selectedLesson, "Booked");
                    bookingsAL.add(newBooking);
                    studentBookings.add(newBooking);
                }

                studentPanel.setVisible(false);
                generateStudentPanel();
            }
        } else if (selectedValue.equals("Lesson Full")) {
//            System.out.println("Sorry Lesson Full");
            JOptionPane.showMessageDialog(studentPanel, "Sorry, the lesson is fully booked.", "Alert", JOptionPane.WARNING_MESSAGE);
        } else if (selectedValue.equals("Time Conflict")) {
            JOptionPane.showMessageDialog(studentPanel, "Sorry, the lesson you're trying to book conflicts with the timing of another lesson.", "Alert", JOptionPane.WARNING_MESSAGE);
        } else if (selectedValue.equals("Booked")) {
            generateMyBookings();
        }

    }

    public void generateMyBookings() {
        System.out.println("MyBookings Panel");
        bookingPanel = new JPanel(new BorderLayout());

        JLabel titleLabel = new JLabel("My Bookings");
        titleLabel.setFont(new Font("Serif", Font.BOLD, 25));
//        titleLabel.setPreferredSize(new);

        studentPanelButton = new JButton("Search Lessons");
        studentPanelButton.addActionListener(this);

        JPanel topPanel = new JPanel(new FlowLayout());
        topPanel.setPreferredSize(new Dimension(500, 70));
        topPanel.add(titleLabel);
        topPanel.add(studentPanelButton);

        bookingPanel.add(topPanel, BorderLayout.NORTH);

        JPanel midPanel = new JPanel();
        midPanel.setPreferredSize(new Dimension(700, 500));
//        midPanel.setBorder(BorderFactory.createLineBorder(Color.black));

//        JLabel label = new JLabel("Test");
//        midPanel.add(label,4,2);
        int columnLength = 6;
        int rowLength = 5;
        JTable timeTable = new JTable(rowLength, columnLength);
        timeTable.setRowHeight(100);
        for (int i = 0; i < columnLength; i++) {
            timeTable.getColumnModel().getColumn(i).setPreferredWidth(125);
        }
//        Enum< timeTable.getColumnModel().getColumns();
//        timeTable.setMinimumSize(new Dimension(700,500));
        timeTable.setRowSelectionAllowed(false);
        timeTable.setColumnSelectionAllowed(false);
        timeTable.setCellSelectionEnabled(true);
//        timeTable.setEnabled(false);
//        timeTable.setAlignmentX(SwingConstants.CENTER);
//        timeTable.setAlignmentY(SwingConstants.CENTER);
//timeTable.setHorizontalAlignment(SwingConstants.CENTER);

        //Coulmn Titles
        String[] columnTitles = {"Time", "Mon", "Tue", "Wed", "Thu", "Fri"};
        for (int i = 0; i < columnTitles.length; i++) {
            timeTable.setValueAt(columnTitles[i], 0, i);
        }

        //Row Titles
        String[] rowTitles = {"Time", "15:00", "16:00", "17:00", "18.00"};
        for (int i = 0; i < rowTitles.length; i++) {
            timeTable.setValueAt(rowTitles[i], i, 0);
        }

        for (Bookings b : studentBookings) {
            Lessons l = b.getLesson();
            String value = "(ID " + b.getId() + ") " + l.getName();
            String day = getDayString(l.getDateTime());
            String time = getTimeString(l.getDateTime());
            String date = getDateString(l.getDateTime());
            int tableRow = getRow(time);

//            timeTable.setValueAt(, NORMAL);
            switch (day) {
                case "Mon":
                    timeTable.setValueAt(value, tableRow, 1);
//                    timeTable.getColumnModel().getColumn(1).setCellRenderer();
                    break;
                case "Tue":
                    timeTable.setValueAt(value, tableRow, 2);
                    break;
                case "Wed":
                    timeTable.setValueAt(value, tableRow, 3);
                    break;
                case "Thu":
                    timeTable.setValueAt(value, tableRow, 4);
                    break;
                case "Fri":
                    timeTable.setValueAt(value, tableRow, 5);
                    break;
            }
        }

        timeTable.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mousePressed(MouseEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                int row = timeTable.getSelectedRow();
                int column = timeTable.getSelectedColumn();
//                   String selectedValue = timeTable.getValueAt(row, column).toString();

            }

            @Override
            public void mouseReleased(MouseEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseEntered(MouseEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseExited(MouseEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });

        midPanel.add(timeTable);

        bookingPanel.add(midPanel, BorderLayout.CENTER);

        JPanel emptyWest = new JPanel();
        JPanel emptyEast = new JPanel();
        JPanel emptySouth = new JPanel();
        bookingPanel.add(emptyEast, BorderLayout.EAST);
        bookingPanel.add(emptyWest, BorderLayout.WEST);
        bookingPanel.add(emptySouth, BorderLayout.SOUTH);

        studentPanel.setVisible(false);
        add(bookingPanel);
    }

    public void handleAppointmentBooking() {
        int row = appointmentTable.getSelectedRow();
        int column = appointmentTable.getSelectedColumn();
        String selectedValue = appointmentTable.getValueAt(row, column).toString();
        String selectedDate = appointmentTable.getValueAt(row, 0).toString();
        String selectedTime = appointmentTable.getValueAt(row, 1).toString();
        int bookingSlot = getBookingSlot(selectedTime);
//        Bookings tempBooking = null;

        if (selectedValue.equals("Click Here to Book")) {
            int res = JOptionPane.showConfirmDialog(coachAppointmentPanel, "Please confirm that you would like to book the appointment for " + selectedCoach.getFullName() + " on " + selectedDate + " at " + selectedTime, "Confirm Booking", JOptionPane.YES_NO_OPTION);
//            System.out.println("RES " + res);
            if (res == JOptionPane.YES_OPTION) {
                //        Bookings (Coach coach, String note, int slot, String status, String dateTime_

                bookingsAL.add(new Bookings(selectedCoach, loginStudentNameField.getText(), bookingSlot , "Booked", getLongDate(selectedDate, selectedCoach.getOfficeHour())));
            }
        } else if (selectedValue.equals("Booked")) {
            JOptionPane.showMessageDialog(coachAppointmentPanel, "Sorry, the appointment slot is already booked.", "Alert", JOptionPane.WARNING_MESSAGE);
        }
        
        coachAppointmentPanel.setVisible(false);
        generateCoachAppointmentPanel();

    }

    public String getDateTimeString(String dateTime) {
        String res = "";

        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E, yyyy-MM-dd HH:mm");
        LocalDateTime localDT = LocalDateTime.parse(dateTime, dateFormat);
        res = localDT.format(formatter);
        System.out.println(res);

        return res;
    }

    public String getDayString(String dateTime) {
        String res = "";

        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E");
        LocalDateTime localDT = LocalDateTime.parse(dateTime, dateFormat);
        res = localDT.format(formatter);
        System.out.println(res);

        return res;
    }

    public String getTimeString(String dateTime) {
        String res = "";

        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalDateTime localDT = LocalDateTime.parse(dateTime, dateFormat);
        res = localDT.format(formatter);
        System.out.println(res);

        return res;
    }
    
    public String getShortTimeString(String dateTime) {
        String res = "";

        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalDateTime localDT = LocalDateTime.parse(dateTime, dateFormat);
        res = localDT.format(formatter);
        System.out.println(res);

        return res;
    }

    public String getDateString(String dateTime) {
        String res = "";

        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd");
        LocalDateTime localDT = LocalDateTime.parse(dateTime, dateFormat);
        res = localDT.format(formatter);
        System.out.println(res);

        return res;
    }

    public String getDateTimeShortString(String dateTime) {
        String res = "";

        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E, yyyy-MM-dd HH:mm");
        LocalDateTime localDT = LocalDateTime.parse(dateTime, dateFormat);
        res = localDT.format(formatter);
//        System.out.println(res);

        return res;
    }
    
    public String getLongDate(String date, String time) {
        String res = "";
        String finalDate = date + " " + getShortTimeString(time);
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("E, dd-MMM-yyyy HH:mm:ss");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime localDT = LocalDateTime.parse(finalDate, dateFormat);
        res = localDT.format(formatter);
        System.out.println(res);

        return res;
    }

    public String addHour(String dateTime) {
//        System.out.println("dateTime ----- " + dateTime);
        String res = "";

        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalDateTime localDT = LocalDateTime.parse(dateTime, dateFormat).plusHours(1);
        res = localDT.format(formatter);
//        System.out.println(res);/

        return res;
    }

    public String getOfficeHourString(String dateTime) {
        //        System.out.println("dateTime ----- " + dateTime);
        String res = getDateTimeShortString(dateTime) + " - " + addHour(dateTime);
//        System.out.println("resssss " + res);

        return res;
    }

    public String getOfficeHourShortString(String dateTime) {
        //        System.out.println("dateTime ----- " + dateTime);
        String res = getDayString(dateTime) + ", " + getTimeString(dateTime) + " - " + addHour(dateTime);
//        System.out.println("resssss " + res);

        return res;
    }

    public int getRow(String time) {
        int res = 1;

        if (time.equals("16:00")) {
            res = 2;
        } else if (time.equals("17:00")) {
            res = 3;
        } else if (time.equals("18:00")) {
            res = 4;
        } else if (time.equals("19:00")) {
            res = 5;
        }

        return res;
    }

    private String getOfficeHourDate(String dateTime, int i) {
        String res = "";

        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E, dd-MMM-yyyy");
        LocalDateTime localDT = LocalDateTime.parse(dateTime, dateFormat).plusWeeks(i);
        res = localDT.format(formatter);
//        System.out.println(res + "-------------");
        return res;
    }

    private String getOfficeHourLongDate(String dateTime, int i) {
        String res = "";

        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime localDT = LocalDateTime.parse(dateTime, dateFormat).plusWeeks(i);
        res = localDT.format(formatter);
//        System.out.println(res + "-------------");
        return res;
    }

    private String getOfficeTimeString(String dateTime, int i) {
        String res = "";
        LocalDateTime localDTStart = null, localDTEnd = null;
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

        switch (i) {
            case 1:
                localDTStart = LocalDateTime.parse(dateTime, dateFormat).plusMinutes(0);
                localDTEnd = LocalDateTime.parse(dateTime, dateFormat).plusMinutes(20);
                break;
            case 2:
                localDTStart = LocalDateTime.parse(dateTime, dateFormat).plusMinutes(20);
                localDTEnd = LocalDateTime.parse(dateTime, dateFormat).plusMinutes(40);
                break;
            case 3:
                localDTStart = LocalDateTime.parse(dateTime, dateFormat).plusMinutes(40);
                localDTEnd = LocalDateTime.parse(dateTime, dateFormat).plusMinutes(60);
                break;
        }

        res = localDTStart.format(formatter) + " - " + localDTEnd.format(formatter);

        return res;
    }

    public int getBookingSlot(String dateTime) {
        int res = 0;
        // Receives 16:00 - 16:20 splits by "-" then splits again by ":" to get the end time minutes
        String endMinutes = dateTime.split(" - ")[1].split(":")[1];
        
        if(endMinutes.equals("20")) {
            res = 1;
        } else if(endMinutes.equals("40")){
            res = 2;
        } else if(endMinutes.equals("00")){
            res = 3;
        }
        

        return res;
    }

}
