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
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.border.EmptyBorder;

public class GraphicsFrame extends JFrame implements ActionListener {

    private ArrayList<Coach> coachesAL;
    private ArrayList<Student> studentsAL;
    private ArrayList<Lessons> lessonsAL;
    private ArrayList<Bookings> bookingsAL;
    private ArrayList<Lessons> lessonsAL2;
    private Student student = null;
    private ArrayList<Bookings> studentBookings = new ArrayList<Bookings>();

    private Container c;

    private JPanel mainPanel;
    private JPanel studentPanel;
    private JPanel parentPanel;
    private JPanel bookingPanel;

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
    String[][] tableData;
    String[] columnNames = {"Lesson ID", "Expertise", "Coach", "Date&Time", "Location", "Capacity", "Book"};
    private JButton myBookingsButton;

    private JButton studentPanelButton;
    
    private String parentName;
    private JTextField parentSearchField;
    private JButton parentSearchButton;
    private JButton parentBookingButton;
    private JTable coachesTable;
    

    public GraphicsFrame(ArrayList<Coach> coachesAL, ArrayList<Student> studentsAL, ArrayList<Lessons> lessonsAL, ArrayList<Bookings> bookingsAL) {
        super("Booking System HLC");
        this.coachesAL = coachesAL;
        this.studentsAL = studentsAL;
        this.lessonsAL = lessonsAL;
        this.bookingsAL = bookingsAL;
        this.lessonsAL2 = lessonsAL;
        this.tableData = new String[lessonsAL2.size()][];

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
        lessonsTable.getTableHeader().setReorderingAllowed(false);
        lessonsTable.getColumnModel().getColumn(3).setPreferredWidth(120);
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
                    if (b.getStudent().equals(s)) {
                        studentBookings.add(b);
//                        System.out.println("My Booking " + b.getId() + " " + b.getLesson().getName() + " " + b.getLesson().getCoach().getFullName() + " " + b.getLesson().getDateTime());
                    }
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
        
        JLabel titleLabel = new JLabel("Welcome " + parentName+"!");  
        titleLabel.setPreferredSize(new Dimension(500,100));
        
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(titleLabel);
                
        JPanel midPanel = new JPanel(new BorderLayout());
        JPanel midPanelTop = new JPanel(new FlowLayout());
        midPanelTop.setPreferredSize(new Dimension(700,100));
        parentSearchField = new JTextField();
        parentSearchField.setPreferredSize(new Dimension(700,50));        
        parentSearchButton = new JButton("Search");
        parentSearchButton.setPreferredSize(new Dimension(150,50));
        
        midPanelTop.add(parentSearchField);
        midPanelTop.add(parentSearchButton);
        
        String[] columnNames = {"ID", "Name", "Phone", "Expertise", "Office Hours", "Book"};
        String[][] tableData = new String[coachesAL.size()][];
        int counter = 0;
        
        for(Coach c : coachesAL){
            String[] coach = {c.getId()+"", c.getFullName(), c.getTelephoneNo(), c.getExpertiseString(), c.getOfficeHour(), "Book"};
            tableData[counter] = coach;
            counter++;
        }        
        
        coachesTable = new JTable(tableData, columnNames);
        
        
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

    public void studentSearch() {
        String searchType = searchTypeDropdown.getSelectedItem() + "";
        String searchValue = studentSearchField.getText();
        ArrayList<Lessons> tempAL = new ArrayList<Lessons>();
        if (searchType.equals("Expertise")) {
            System.out.println("Expertise Search");
            tempAL.clear();
            for (Lessons l : lessonsAL) {
                if (l.getName().toLowerCase().contains(searchValue.toLowerCase())) {
                    System.out.println(l.getId() + "\t" + l.getName() + "\t" + l.getCoach().getFullName() + "\t" + l.getDateTime() + "\t" + l.getPlace() + "\t" + l.getCapacity());
                    tempAL.add(l);
                }
            }
        }
        if (searchType.equals("Coach")) {
            System.out.println("Coach Search");
            tempAL.clear();
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
        int row = lessonsTable.getSelectedRow();
        int column = lessonsTable.getSelectedColumn();
        String selectedValue = lessonsTable.getValueAt(row, column).toString();
        System.out.println(row + "" + column + "" + selectedValue);

        Lessons selectedLesson = null;
        for (Lessons l : lessonsAL) {
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
//        timeTable.setAlignmentX(SwingConstants.CENTER);
//        timeTable.setAlignmentY(SwingConstants.CENTER);
//timeTable.setHorizontalAlignment(SwingConstants.CENTER);
        

        //Coulmn Titles
        String[] columnTitles = {"Time","Mon", "Tue", "Wed", "Thu", "Fri"};
        for (int i = 0; i < columnTitles.length; i++) {
            timeTable.setValueAt(columnTitles[i], 0, i);
        }
        
        //Row Titles
        String[] rowTitles = {"Time","15:00", "16:00", "17:00", "18.00"};
        for (int i = 0; i < rowTitles.length; i++) {
            timeTable.setValueAt(rowTitles[i], i, 0);            
        }
        
        for(Bookings b : studentBookings) {
            Lessons l = b.getLesson();
            String value = "(ID " + b.getId() + ") " + l.getName();
            String day = getDayString(l.getDateTime());
            String time = getTimeString(l.getDateTime());
            String date = getDateString(l.getDateTime());
            int tableRow = getRow(time);
            
//            timeTable.setValueAt(, NORMAL);
            switch(day){
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
    
     public String getDateString(String dateTime) {
        String res = "";
        
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd");
        LocalDateTime localDT = LocalDateTime.parse(dateTime, dateFormat);
        res = localDT.format(formatter);
        System.out.println(res);
        
        return res;
    }
     
     public int getRow(String time){
        int res = 1;
         
        if(time.equals("16:00")) {
            res = 2;
        }
        else if(time.equals("17:00")){
            res = 3;
        }
        else if(time.equals("18:00")){
            res = 4;
        }
        else if(time.equals("19:00")){
            res = 5;
        }
        
        return res;         
     }

}
