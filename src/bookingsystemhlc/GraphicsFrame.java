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

public class GraphicsFrame extends JFrame implements ActionListener, MouseListener {

    private DateTime dt = new DateTime();
    private ArrayList<Coach> coachesAL;
    private ArrayList<Student> studentsAL;
    private ArrayList<Lessons> lessonsAL;
    private ArrayList<Bookings> bookingsAL;
    
    private ArrayList<Lessons> lessonsAL2;
    private ArrayList<Coach> coachesAL2;

    private Student student = null;
    private ArrayList<Bookings> studentBookingsAL = new ArrayList<Bookings>();

    private Container c;

    private JPanel mainPanel;
    private JPanel studentPanel;
    private JPanel parentPanel;
    private JPanel bookingPanel;
    private JPanel coachAppointmentPanel;
    private JPanel newStudentPanel;

    private JLabel loginTitleLabel;
    private JLabel loginNameLabel;
    private JTextField loginNameField;
    private JButton loginParentButton;
    private JButton loginStudentButton;

    private JTextField studentSearchField;
    private JButton studentSearchButton;
    private String[] searchType = {"Expertise", "Coach"};
    private JComboBox searchTypeDropdown;
    private JScrollPane scrollPanel;
    private JTable lessonsTable;

    private JButton myBookingsButton;
    private JTable timeTable;
    private JButton prevWeekButton;
    private JButton nextWeekButton;
    private int weekNo = 1;
    private boolean isBookingChange = false;
    private Bookings changingBooking;

    private JButton studentPanelButton;

    private String parentName = "";
    private JTextField parentSearchField;
    private JButton parentSearchButton;
    private JTable coachesTable;
    private JTable appointmentTable;
    private Coach selectedCoach;
    private JButton appointmentBookingBackButton;

    private JTextField studentAddressField, studentTelephoneField;
    private JButton newStudentRegisterButton;

    private JMenuItem logout, report1, report2;

    public GraphicsFrame() {
    }

    public GraphicsFrame(ArrayList<Coach> coachesAL, ArrayList<Student> studentsAL, ArrayList<Lessons> lessonsAL, ArrayList<Bookings> bookingsAL, String test) {
        //Constructor for JUnit Testing Purposes
        this.coachesAL = coachesAL;
        this.studentsAL = studentsAL;
        this.lessonsAL = lessonsAL;
        this.bookingsAL = bookingsAL;
        this.lessonsAL2 = lessonsAL;
        this.coachesAL2 = coachesAL;
        
        
    }

    public GraphicsFrame(ArrayList<Coach> coachesAL, ArrayList<Student> studentsAL, ArrayList<Lessons> lessonsAL, ArrayList<Bookings> bookingsAL) {
        super("Booking System HLC");
        this.coachesAL = coachesAL;
        this.studentsAL = studentsAL;
        this.lessonsAL = lessonsAL;
        this.bookingsAL = bookingsAL;
        this.lessonsAL2 = lessonsAL;
        this.coachesAL2 = coachesAL;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        c = getContentPane();

        JMenuBar mb = new JMenuBar();
        setJMenuBar(mb);

        JMenu profile = new JMenu("Profile");
        logout = new JMenuItem("Logout");
        logout.addActionListener(this);
        profile.add(logout);
        mb.add(profile);

        JMenu reports = new JMenu("Reports");
        report1 = new JMenuItem("Generate Report - Lessons");
        report1.addActionListener(this);
        report2 = new JMenuItem("Generate Report - Student");
        report2.addActionListener(this);
        reports.add(report1);
        reports.add(report2);
        mb.add(reports);

        generateMainPanel();

        add(mainPanel);

        setResizable(true);
        setSize(900, 700);
        setLocationRelativeTo(null);

        setVisible(true);
    }

    //------------------Main Login Panel-------------------------------
    public void generateMainPanel() {
        mainPanel = new JPanel(new BorderLayout());

        loginTitleLabel = new JLabel("Student Registration");
        loginTitleLabel.setPreferredSize(new Dimension(200, 200));
        loginTitleLabel.setFont(new Font("Serif", Font.BOLD, 25));
        loginTitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        loginTitleLabel.setVerticalAlignment(SwingConstants.CENTER);
        mainPanel.add(loginTitleLabel, BorderLayout.NORTH);

        loginNameLabel = new JLabel("Enter Your Name: ");
        loginNameLabel.setSize(new Dimension(200, 200));

        loginNameField = new JTextField();
        loginNameField.setPreferredSize(new Dimension(500, 50));
        loginNameField.addActionListener(this);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(4, 0));

        JPanel rowOne = new JPanel(new FlowLayout());
        rowOne.add(loginNameLabel);
        rowOne.add(loginNameField);

        centerPanel.add(rowOne);
        mainPanel.add(centerPanel, BorderLayout.CENTER);

        loginParentButton = new JButton("Parent Login");
        loginParentButton.setPreferredSize(new Dimension(100, 50));
        loginParentButton.addActionListener(this);

        loginStudentButton = new JButton("Student Login");
        loginStudentButton.setPreferredSize(new Dimension(100, 50));
        loginStudentButton.addActionListener(this);

        JPanel southPanel = new JPanel();
        southPanel.setLayout(new GridLayout(2, 0));
        southPanel.add(loginStudentButton);
        southPanel.add(loginParentButton);
        mainPanel.add(southPanel, BorderLayout.SOUTH);
    }

    //-------------------Student Start--------------------------------
    public void studentLogin() {

        int count = 0;
        System.out.println("Student trying to Login");
        String studentName = loginNameField.getText();

        for (Student s : studentsAL) {
            if (s.getFullName().equalsIgnoreCase(studentName)) {
                student = s;

                for (Bookings b : bookingsAL) {
                    if (b.getBookingType().equals("Lesson")) {
                        if (b.getStudent().equals(s)) {
                            studentBookingsAL.add(b);
                        }
                    }
                }
                mainPanel.setVisible(false);
                generateStudentPanel();
            } else {
                count++;
            }
        }
        if (count == studentsAL.size()) {
            System.out.println("New Student");
            mainPanel.setVisible(false);
            generateNewStudentPanel();
        }
    }

    public void generateStudentPanel() {
        studentPanel = new JPanel(new BorderLayout());

        JLabel greetingLabel = new JLabel("Hello " + student.getFullName() + "!");
        greetingLabel.setToolTipText("Attend");
        greetingLabel.setPreferredSize(new Dimension(625, 100));
        greetingLabel.setFont(new Font("Serif", Font.BOLD, 25));
        greetingLabel.setBorder(new EmptyBorder(0, 30, 0, 0));

        myBookingsButton = new JButton("My TimeTable");
        myBookingsButton.setPreferredSize(new Dimension(200, 50));
        myBookingsButton.addActionListener(this);

        JPanel topPanel = new JPanel(new FlowLayout());
        topPanel.add(greetingLabel);
        topPanel.add(myBookingsButton);

        studentPanel.add(topPanel, BorderLayout.NORTH);

        studentSearchField = new JTextField();
        studentSearchField.setPreferredSize(new Dimension(625, 50));

        searchTypeDropdown = new JComboBox(searchType);
        searchTypeDropdown.setPreferredSize(new Dimension(100, 50));

        studentSearchButton = new JButton("Search");
        studentSearchButton.setPreferredSize(new Dimension(100, 50));
        studentSearchButton.addActionListener(this);

        JPanel centerPanel = new JPanel(new BorderLayout());
        JPanel rowOne = new JPanel(new FlowLayout());
        rowOne.add(studentSearchField);
        rowOne.add(searchTypeDropdown);
        rowOne.add(studentSearchButton);
        rowOne.setPreferredSize(new Dimension(200, 100));

        String[][] tableData = new String[lessonsAL2.size()][];
        String[] columnNames = {"Lesson ID", "Expertise", "Coach", "Date&Time", "Location", "Capacity", "Click Below"};
        int counter = 0;
        for (Lessons l : lessonsAL2) {
            String bookingButton = "Available";
            if (l.getCapacity() == 0) {
                bookingButton = "Lesson Full";
            }
            if (!studentBookingsAL.isEmpty()) {
                for (Bookings b : studentBookingsAL) {
                    if (b.getLesson().getId() == l.getId()) {

                        if (b.getStatus().equals("Cancelled")) {

                        } else {
//                            bookingButton = b.getStatus();
                            bookingButton = b.getStatus();
                        }
                    } else if (b.getLesson().getDateTime().equals(l.getDateTime()) && b.getStatus().equals("Booked")) {
                        bookingButton = "Time Conflict";
                    }

                }
            }

            String[] tempData = {l.getId() + "", l.getName(), l.getCoach().getFullName(), dt.getDateTimeString(l.getDateTime()), l.getPlace(), l.getCapacity() + "", bookingButton};
            tableData[counter] = tempData;
            counter++;
        }
        lessonsTable = new JTable(tableData, columnNames);

        lessonsTable.setRowSelectionAllowed(false);
        lessonsTable.setColumnSelectionAllowed(false);
        lessonsTable.setCellSelectionEnabled(true);
        lessonsTable.getTableHeader().setReorderingAllowed(false);
        lessonsTable.getColumnModel().getColumn(3).setPreferredWidth(120);
        lessonsTable.getColumnModel().getColumn(6).setPreferredWidth(120);
        lessonsTable.addMouseListener(this);

        scrollPanel = new JScrollPane(lessonsTable);
        scrollPanel.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPanel.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

        centerPanel.add(rowOne, BorderLayout.NORTH);
        centerPanel.add(scrollPanel, BorderLayout.CENTER);

        studentPanel.add(centerPanel, BorderLayout.CENTER);
        JPanel emptyWest = new JPanel();
        JPanel emptyEast = new JPanel();
        JPanel emptySouth = new JPanel();

        studentPanel.add(emptyEast, BorderLayout.EAST);
        studentPanel.add(emptyWest, BorderLayout.WEST);
        studentPanel.add(emptySouth, BorderLayout.SOUTH);
        add(studentPanel);
    }

    public void generateNewStudentPanel() {
        newStudentPanel = new JPanel(new BorderLayout());
        JPanel topPanel = new JPanel();
        JPanel midPanel = new JPanel(new GridLayout(6, 0));
        JPanel emptyWest = new JPanel();
        JPanel emptyEast = new JPanel();
        JPanel emptySouth = new JPanel();

        JLabel titleLabel = new JLabel("New Student Registration");
        titleLabel.setPreferredSize(new Dimension(150, 100));
        topPanel.add(titleLabel);

        JPanel row1 = new JPanel(new FlowLayout());
        JPanel row2 = new JPanel(new FlowLayout());
        JPanel row3 = new JPanel(new FlowLayout());
        JPanel row4 = new JPanel(new FlowLayout());

        JLabel studentNameLabel = new JLabel("Full Name :");
        studentNameLabel.setPreferredSize(new Dimension(100, 40));

        JLabel studentAddressLabel = new JLabel("Address :");
        studentAddressLabel.setPreferredSize(new Dimension(100, 40));

        JLabel studentTelephoneLabel = new JLabel("Telephone No. :");
        studentTelephoneLabel.setPreferredSize(new Dimension(100, 40));

//        studentNameField = new JTextField();
//        studentNameField.setPreferredSize(new Dimension(200,40));
//        studentNameField.setText(loginNameField.getText());
//        loginNameField = new JTextField();
        loginNameField.setPreferredSize(new Dimension(200, 40));
//        loginNameField.setText(this.loginNameField.getText());

        studentAddressField = new JTextField();
        studentAddressField.setPreferredSize(new Dimension(200, 40));

        studentTelephoneField = new JTextField();
        studentTelephoneField.setPreferredSize(new Dimension(200, 40));

        newStudentRegisterButton = new JButton("Register");
        newStudentRegisterButton.addActionListener(this);
        newStudentRegisterButton.setPreferredSize(new Dimension(100, 50));

        row1.add(studentNameLabel);
        row1.add(loginNameField);
        row2.add(studentAddressLabel);
        row2.add(studentAddressField);
        row3.add(studentTelephoneLabel);
        row3.add(studentTelephoneField);
        row4.add(newStudentRegisterButton);

        midPanel.add(row1);
        midPanel.add(row2);
        midPanel.add(row3);
        midPanel.add(row4);

        newStudentPanel.add(topPanel, BorderLayout.NORTH);
        newStudentPanel.add(midPanel, BorderLayout.CENTER);
        newStudentPanel.add(emptyWest, BorderLayout.WEST);
        newStudentPanel.add(emptyEast, BorderLayout.EAST);
        newStudentPanel.add(emptySouth, BorderLayout.SOUTH);

        add(newStudentPanel);
    }

    public ArrayList<Lessons> studentLessonSearch(String value, String type) {
        String searchType = "";
        String searchValue = "";

//     For JUnit testing purposes
        if (value != "" && type != "") {
            searchType = type;
            searchValue = value;
        } else {
            searchType = searchTypeDropdown.getSelectedItem() + "";
            searchValue = studentSearchField.getText();
        }

        ArrayList<Lessons> tempAL = new ArrayList<Lessons>();
        if (searchType.equals("Expertise")) {
            System.out.println("Expertise Search");
            for (Lessons l : lessonsAL) {
                if (l.getName().toLowerCase().contains(searchValue.toLowerCase())) {
//                    System.out.println(l.getId() + "\t" + l.getName() + "\t" + l.getCoach().getFullName() + "\t" + l.getDateTime() + "\t" + l.getPlace() + "\t" + l.getCapacity());
                    tempAL.add(l);
                }
            }
        } else if (searchType.equals("Coach")) {
            System.out.println("Coach Search");
            for (Lessons l : lessonsAL) {
                if (l.getCoach().getFullName().toLowerCase().contains(searchValue.toLowerCase())) {
//                    System.out.println(l.getId() + "\t" + l.getName() + "\t" + l.getCoach().getFullName() + "\t" + l.getDateTime() + "\t" + l.getPlace() + "\t" + l.getCapacity());
                    tempAL.add(l);
                }
            }
        }

        lessonsAL2 = tempAL;
        //        For JUnit testing purposes     
        if (value != "" && type != "") {
            return tempAL;
        }
        studentPanel.setVisible(false);
        generateStudentPanel();

        return null;
    }

    public void studentLessonBooking() {
        int row = lessonsTable.getSelectedRow();
        int column = lessonsTable.getSelectedColumn();
        String selectedValue = lessonsTable.getValueAt(row, column).toString();

        Lessons selectedLesson = null;
        for (Lessons l : lessonsAL2) {
            if ((l.getId() + "").equals(lessonsTable.getValueAt(row, 0).toString())) {
                selectedLesson = l;
            }
        }

        if (selectedValue.equals("Available")) {
            System.out.println("Booking");
            int res = JOptionPane.showConfirmDialog(studentPanel, "Please confirm that you would like to book the lesson " + selectedLesson.getName() + " on " + selectedLesson.getDateTime(), "Confirm Booking", JOptionPane.YES_NO_OPTION);

            if (res == JOptionPane.YES_OPTION) {

                if (selectedLesson.getCapacity() > 0) {
                    lessonsAL.get(lessonsAL.indexOf(selectedLesson)).setCapacity(selectedLesson.getCapacity() - 1);
                    if (isBookingChange) {
                        bookingsAL.get(bookingsAL.indexOf(changingBooking)).setLesson(selectedLesson);
                        bookingsAL.get(bookingsAL.indexOf(changingBooking)).setStatus("Booked");
                        isBookingChange = false;
                    } else {
                        Bookings newBooking = new Bookings(student, selectedLesson, "Booked");
                        bookingsAL.add(newBooking);
                        studentBookingsAL.add(newBooking);
                    }

                }

                studentPanel.setVisible(false);
                generateStudentPanel();
            }
        } else if (selectedValue.equals("Lesson Full")) {
            JOptionPane.showMessageDialog(studentPanel, "Sorry, the lesson is fully booked.", "Alert", JOptionPane.WARNING_MESSAGE);
        } else if (selectedValue.equals("Time Conflict")) {
            JOptionPane.showMessageDialog(studentPanel, "Sorry, the lesson you're trying to book conflicts with the timing of another booked lesson.", "Alert", JOptionPane.WARNING_MESSAGE);
        } else if (selectedValue.equals("Attended")) {
            JOptionPane.showMessageDialog(studentPanel, "You have attended this lesson already!", "Lesson Attended", JOptionPane.OK_OPTION);
        } else if (selectedValue.equals("Booked")) {
            Bookings selectedBooking = null;
            for (Bookings b : studentBookingsAL) {
                if (b.getLesson().getId() == selectedLesson.getId() && b.getBookingType().equals("Lesson")) {
                    selectedBooking = b;

                }
            }
            handleBooking(selectedBooking, studentPanel);
            studentPanel.setVisible(false);
            generateStudentPanel();

        }

    }

    public void generateStudentTimetablePanel() {
        System.out.println("MyBookings Panel");
        bookingPanel = new JPanel(new BorderLayout());

        JLabel titleLabel = new JLabel("My Bookings");
        titleLabel.setFont(new Font("Serif", Font.BOLD, 25));
        titleLabel.setPreferredSize(new Dimension(700, 40));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        studentPanelButton = new JButton("Go Back");
        studentPanelButton.addActionListener(this);

        prevWeekButton = new JButton("<");
        prevWeekButton.addActionListener(this);

        nextWeekButton = new JButton(">");
        nextWeekButton.addActionListener(this);

        JLabel weekLabel = new JLabel("Week " + weekNo);

        JPanel topPanel = new JPanel(new GridLayout(2, 0));
//        topPanel.setPreferredSize(new Dimension(500, 70));
        JPanel row1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        row1.setPreferredSize(new Dimension(700, 50));
        JPanel row2 = new JPanel(new FlowLayout());

        row1.add(studentPanelButton);
        row1.add(titleLabel);

        row2.add(prevWeekButton);
        row2.add(weekLabel);
        row2.add(nextWeekButton);

        topPanel.add(row1);
        topPanel.add(row2);

        bookingPanel.add(topPanel, BorderLayout.NORTH);

        JPanel midPanel = new JPanel();
        midPanel.setPreferredSize(new Dimension(700, 500));

        int columnLength = 6;
        int rowLength = 5;
        timeTable = new JTable(rowLength, columnLength);
        timeTable.setRowHeight(100);
        for (int i = 0; i < columnLength; i++) {
            timeTable.getColumnModel().getColumn(i).setPreferredWidth(125);
        }
        timeTable.setRowSelectionAllowed(false);
        timeTable.setColumnSelectionAllowed(false);
        timeTable.setCellSelectionEnabled(true);

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
        
        for (Bookings b : studentBookingsAL) {
            if ((b.getStatus().equals("Booked") || b.getStatus().equals("Attended")) && dt.getBookingWeek(b.getLesson().getDateTime()) == weekNo) {
//                System.out.println("TimeTable -------------" + b.getId() + "\t" + b.getStatus());
               System.out.println("////////////////////////// " + b.getLesson().getDateTime());
Lessons l = b.getLesson();
                String value = "(ID " + b.getId() + ") " + l.getName();
                String day = dt.getDayString(l.getDateTime());
                String time = dt.getTimeString(l.getDateTime());
                String date = dt.getDateString(l.getDateTime());
                int tableRow = dt.getRow(time);

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
        }

        timeTable.addMouseListener(this);
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

    public void handleTimeTablePress() {
        int row = timeTable.getSelectedRow();
        int column = timeTable.getSelectedColumn();
        Bookings selectedBooking = null;

        try {
            String selectedValue = timeTable.getValueAt(row, column).toString().substring(4, 6);

            for (Bookings b : bookingsAL) {
                if ((b.getId() + "").equals(selectedValue)) {
                    selectedBooking = b;
                }
            }
            handleBooking(selectedBooking, bookingPanel);
            bookingPanel.setVisible(false);
            generateStudentPanel();
        } catch (Exception exception) {
            System.out.println("No Booking at that time ");
        }
    }

    public String handleBooking(Bookings selectedBooking, JPanel currentPanel) {
        int res = 0;
        String[] options = {"Attend", "Cancel Booking", "Change Booking"};
        if (selectedBooking.getStatus().equals("Attended")) {
            JOptionPane.showMessageDialog(bookingPanel, "You have attended this lesson already!", "Lesson Attended", JOptionPane.OK_OPTION);
        } else {

            res = JOptionPane.showOptionDialog(
                    currentPanel,
                    "Lesson: " + selectedBooking.getLesson().getName()
                    + "\nCoach: " + selectedBooking.getLesson().getCoach().getFullName()
                    + " \nTime: " + selectedBooking.getLesson().getDateTime()
                    + "\nLocation: " + selectedBooking.getLesson().getPlace(),
                    "Booking Details", 0, JOptionPane.INFORMATION_MESSAGE, null, options, null);
        }

//                    System.out.println("JOPTION " + res);
//                      res = 0 -> Attend
//                      res = 1 -> Cancel Booking
//                      res = 2 -> Change Booking
        int index = bookingsAL.indexOf(selectedBooking);
        int studentBookingIndex = studentBookingsAL.indexOf(selectedBooking);
        if (res == 0) {
            System.out.println("Attending");
            selectedBooking.setStatus("Attended");
        } else if (res == 1) {
            System.out.println("Cancelling");
            selectedBooking.setStatus("Cancelled");
            selectedBooking.getLesson().setCapacity(selectedBooking.getLesson().getCapacity() + 1);

        } else if (res == 2) {
            System.out.println("Changing");
            JOptionPane.showMessageDialog(currentPanel, "Please note the next lesson you book will replace the booking you're trying to change", "Change Booking", JOptionPane.INFORMATION_MESSAGE);
            selectedBooking.setStatus("Changing Lesson");
            selectedBooking.getLesson().setCapacity(selectedBooking.getLesson().getCapacity() + 1);
            changingBooking = selectedBooking;
            isBookingChange = true;
        }
        bookingsAL.remove(index);
        studentBookingsAL.remove(studentBookingIndex);

        bookingsAL.add(index, selectedBooking);
        studentBookingsAL.add(studentBookingIndex, selectedBooking);

//        bookingPanel.setVisible(false);
        return "";
    }

    //-------------------Parent Start-------------------------------    
    public void generateParentPanel() {
        parentPanel = new JPanel(new BorderLayout());
        parentName = loginNameField.getText();

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

        String[] columnNames = {"Coach ID", "Name", "Phone", "Expertise", "Office Hours", "Click Below"};
        String[][] tableData = new String[coachesAL2.size()][];
        int counter = 0;

        for (Coach c : coachesAL2) {
            String[] coach = {c.getId() + "", c.getFullName(), c.getTelephoneNo(), c.getExpertiseString(), dt.getOfficeHourShortString(c.getOfficeHour()), "Available"};
            tableData[counter] = coach;
            counter++;
        }

        coachesTable = new JTable(tableData, columnNames);
        coachesTable.setRowSelectionAllowed(false);
        coachesTable.setColumnSelectionAllowed(false);
        coachesTable.setCellSelectionEnabled(true);
        coachesTable.addMouseListener(this);

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

    public ArrayList<Coach> parentCoachSearch(String value, String type) {
        String searchValue = "";

//        For JUnit testing purposes
        if (value != "" && type != "") {
            searchValue = value;
        } else {
            searchValue = parentSearchField.getText();
        }

        ArrayList<Coach> tempAL = new ArrayList<Coach>();
        for (Coach c : coachesAL) {
            if (c.getFullName().toLowerCase().contains(searchValue.toLowerCase()) || c.getExpertiseString().toLowerCase().contains(searchValue.toLowerCase())) {
                tempAL.add(c);
            }
        }
        coachesAL2 = tempAL;

//        For JUnit testing purposes
        return tempAL;
    }

    public void generateCoachAppointmentPanel() {
        int row = coachesTable.getSelectedRow();
        int column = coachesTable.getSelectedColumn();
        String clickValue = coachesTable.getValueAt(row, column).toString();
        selectedCoach = null;

        if (clickValue.equals("Available")) {
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
        JLabel subTitleLabel = new JLabel("Office Hour Timing: " + dt.getOfficeHourShortString(selectedCoach.getOfficeHour()));
        subTitleLabel.setPreferredSize(new Dimension(400, 100));
        appointmentBookingBackButton = new JButton("Go Back");
        appointmentBookingBackButton.addActionListener(this);

        topPanel.add(appointmentBookingBackButton, BorderLayout.NORTH);
        topPanel.add(titleLabel, BorderLayout.CENTER);
        topPanel.add(subTitleLabel, BorderLayout.SOUTH);

        String[] columnNames = {"Date", "Time", "Click Below"};
        String[][] tableData = new String[12][];
//        ArrayList<String[]> data = new ArrayList<String[]>();
        ArrayList<Bookings> selectedCoachAppointmentsAL = new ArrayList<Bookings>();
        int counter = 0;
        if (selectedCoach != null) {
            for (Bookings b : bookingsAL) {
//                b.getCoach().getId() == selectedCoach.getId();
//                b.getBookingType().equals("Appointment");
//                b.getSlot();
//                b.getAppointmentBookingDateTime();
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
                String[] tempData1 = {dt.getOfficeHourDate(selectedCoach.getOfficeHour(), i), dt.getOfficeTimeString(selectedCoach.getOfficeHour(), 1), "Available"};
                data1 = tempData1;
                //Slot 2
                String[] tempData2 = {dt.getOfficeHourDate(selectedCoach.getOfficeHour(), i), dt.getOfficeTimeString(selectedCoach.getOfficeHour(), 2), "Available"};
                data2 = tempData2;
                //Slot 3
                String[] tempData3 = {dt.getOfficeHourDate(selectedCoach.getOfficeHour(), i), dt.getOfficeTimeString(selectedCoach.getOfficeHour(), 3), "Available"};
                data3 = tempData3;

                for (Bookings b : selectedCoachAppointmentsAL) {
                    if (b.getAppointmentBookingDateTime().equals(dt.getOfficeHourLongDate(selectedCoach.getOfficeHour(), i)) && b.getSlot() == 1) {
                        String[] tempData = {dt.getOfficeHourDate(selectedCoach.getOfficeHour(), i), dt.getOfficeTimeString(selectedCoach.getOfficeHour(), 1), "Booked - by " + b.getNote()};
                        data1 = tempData;
                    } else if (b.getAppointmentBookingDateTime().equals(dt.getOfficeHourLongDate(selectedCoach.getOfficeHour(), i)) && b.getSlot() == 2) {
                        String[] tempData = {dt.getOfficeHourDate(selectedCoach.getOfficeHour(), i), dt.getOfficeTimeString(selectedCoach.getOfficeHour(), 2), "Booked - by " + b.getNote()};
                        data2 = tempData;
                    } else if (b.getAppointmentBookingDateTime().equals(dt.getOfficeHourLongDate(selectedCoach.getOfficeHour(), i)) && b.getSlot() == 3) {
                        String[] tempData = {dt.getOfficeHourDate(selectedCoach.getOfficeHour(), i), dt.getOfficeTimeString(selectedCoach.getOfficeHour(), 3), "Booked - by " + b.getNote()};
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
        appointmentTable.setRowHeight(35);
        appointmentTable.addMouseListener(this);

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

    public void handleAppointmentBooking() {
        int row = appointmentTable.getSelectedRow();
        int column = appointmentTable.getSelectedColumn();
        String selectedValue = appointmentTable.getValueAt(row, column).toString();
        String selectedDate = appointmentTable.getValueAt(row, 0).toString();
        String selectedTime = appointmentTable.getValueAt(row, 1).toString();
        int bookingSlot = dt.getBookingSlot(selectedTime);
//        Bookings tempBooking = null;

        if (selectedValue.equals("Available")) {
            int res = JOptionPane.showConfirmDialog(coachAppointmentPanel, "Please confirm that you would like to book the appointment for " + selectedCoach.getFullName() + " on " + selectedDate + " at " + selectedTime, "Confirm Booking", JOptionPane.YES_NO_OPTION);
//            System.out.println("RES " + res);
            if (res == JOptionPane.YES_OPTION) {
                //        Bookings (Coach coach, String note, int slot, String status, String dateTime_

                bookingsAL.add(new Bookings(selectedCoach, loginNameField.getText(), bookingSlot, "Booked", dt.getLongDate(selectedDate, selectedCoach.getOfficeHour())));
            }
        } else if (selectedValue.equals("Booked")) {
            JOptionPane.showMessageDialog(coachAppointmentPanel, "Sorry, the appointment slot is already booked.", "Alert", JOptionPane.WARNING_MESSAGE);
        }

        coachAppointmentPanel.setVisible(false);
        generateCoachAppointmentPanel();

    }

    //-------------------EventHandler Start------------------------------- 
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == loginStudentButton) {
            if (loginNameField.getText().length() > 0) {
                studentLogin();
            } else {
                JOptionPane.showMessageDialog(c, "Please enter your name in the field");
            }

        }
        if (e.getSource() == loginParentButton) {

            if (loginNameField.getText().length() > 0) {
                generateParentPanel();
            } else {
                JOptionPane.showMessageDialog(c, "Please enter your name in the field");
            }
        }
        if (e.getSource() == studentSearchButton) {
            studentLessonSearch("", "");
        }
        if (e.getSource() == myBookingsButton) {
            generateStudentTimetablePanel();
        }
        if (e.getSource() == studentPanelButton) {
            bookingPanel.setVisible(false);
            generateStudentPanel();
        }
        if (e.getSource() == parentSearchButton) {
            parentPanel.setVisible(false);
            parentCoachSearch("", "");
            generateParentPanel();
        }
        if (e.getSource() == newStudentRegisterButton) {
            studentsAL.add(new Student(loginNameField.getText(), studentAddressField.getText(), studentTelephoneField.getText()));

            newStudentPanel.setVisible(false);

            studentLogin();
        }

        if (e.getSource() == prevWeekButton) {
            if (weekNo > 1) {
                weekNo--;
                bookingPanel.setVisible(false);
                generateStudentTimetablePanel();
            }
        }
        if (e.getSource() == nextWeekButton) {
            if (weekNo < 4) {
                weekNo++;
                bookingPanel.setVisible(false);
                generateStudentTimetablePanel();
            }
        }
        if (e.getSource() == logout) {
            System.out.println("Logging out");
            if (student != null || parentName.length() > 0) {
                setVisible(false);
                new GraphicsFrame(coachesAL, studentsAL, lessonsAL, bookingsAL);
            } else {
                JOptionPane.showMessageDialog(c, "You are not logged in!");
            }

        }
        if (e.getSource() == report1) {
            System.out.println("Report 1");
            Report r = new Report(coachesAL, studentsAL, lessonsAL, bookingsAL);
            r.generateReport1();
        }
        if (e.getSource() == report2) {
            System.out.println("Report 2");
            Report r = new Report(coachesAL, studentsAL, lessonsAL, bookingsAL);
            r.generateReport2();
        }
        if (e.getSource() == appointmentBookingBackButton) {
            coachAppointmentPanel.setVisible(false);
            generateParentPanel();
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if (e.getSource() == lessonsTable) {
            System.out.println("lessonsTable Table Mouse Event");
            studentLessonBooking();
        }
        if (e.getSource() == coachesTable) {
            System.out.println("coachesTable Table Mouse Event");
            generateCoachAppointmentPanel();
        }
        if (e.getSource() == appointmentTable) {
            handleAppointmentBooking();
        }
        if (e.getSource() == timeTable) {
            handleTimeTablePress();
        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
