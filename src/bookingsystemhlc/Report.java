/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookingsystemhlc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;

public class Report {

    private JPanel reportPanel1;
    private JPanel reportPanel2;
    
    private DateTime dt = new DateTime();
    private ArrayList<Coach> coachesAL;
    private ArrayList<Student> studentsAL;
    private ArrayList<Lessons> lessonsAL;
    private ArrayList<Bookings> bookingsAL;
    
    public Report(ArrayList<Coach> coachesAL, ArrayList<Student> studentsAL, ArrayList<Lessons> lessonsAL, ArrayList<Bookings> bookingsAL) {
        this.coachesAL = coachesAL;
        this.studentsAL = studentsAL;
        this.lessonsAL = lessonsAL;
        this.bookingsAL = bookingsAL;
    }
    
    public void generateReportFrame(JPanel panel, String frameName) {
        JFrame reportFrame = new JFrame(frameName);
        reportFrame.add(panel);
        reportFrame.setSize(900, 650);
        reportFrame.setLocationRelativeTo(null);
        reportFrame.setVisible(true);
    }
    
    public void generateReport1() {
        reportPanel1 = new JPanel(new BorderLayout());
        
        JPanel topPanel = new JPanel(new GridLayout(0, 2));
        topPanel.setPreferredSize(new Dimension(900, 70));
        JLabel label1 = new JLabel("Lessons Booking Stats");
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        label1.setVerticalAlignment(SwingConstants.CENTER);
        JLabel label2 = new JLabel("Visitor Appointments Stats");
        label2.setHorizontalAlignment(SwingConstants.CENTER);
        label2.setVerticalAlignment(SwingConstants.CENTER);
        topPanel.add(label1);
        topPanel.add(label2);
        
        JPanel midPanel = new JPanel(new GridLayout(0, 2, 25, 0));
        JPanel midLeftPanel = new JPanel();
        midLeftPanel.setLayout(new BoxLayout(midLeftPanel, BoxLayout.Y_AXIS));
        JPanel midRightPanel = new JPanel();
        midRightPanel.setLayout(new BoxLayout(midRightPanel, BoxLayout.Y_AXIS));
        ArrayList<ArrayList<Bookings>> allLessonsBookingsAL = new ArrayList<ArrayList<Bookings>>();
        ArrayList<ArrayList<Bookings>> allCoachBookingsAL = new ArrayList<ArrayList<Bookings>>();
        
        for (Lessons l : lessonsAL) {
            ArrayList<Bookings> perLessonBookingsAL = new ArrayList<Bookings>();
            for (Bookings b : bookingsAL) {
                if (b.getBookingType().equals("Lesson") && b.getLesson().getId() == l.getId()) {
                    perLessonBookingsAL.add(b);
                }
            }
            if (perLessonBookingsAL.size() > 0) {
                allLessonsBookingsAL.add(perLessonBookingsAL);
            }
        }
        
        String[] leftTableColumnNames = {"Booking ID", "Student", "Status"};
        for (ArrayList<Bookings> list : allLessonsBookingsAL) {
            String[][] leftTableData = new String[list.size()][];
            for (int i = 0; i < list.size(); i++) {
                Bookings b = list.get(i);
                String[] temp = {b.getId() + "", b.getStudent().getFullName(), b.getStatus()};
                leftTableData[i] = temp;
            }
            
            JPanel lessonPanel = new JPanel(new BorderLayout());
            JLabel lessonLabel = new JLabel("Lesson ID: " + list.get(0).getLesson().getId() + "     " + list.get(0).getLesson().getName() + "     " + dt.getDateTimeShortString(list.get(0).getLesson().getDateTime()) + "     " + list.get(0).getLesson().getCoach().getFullName());
            lessonLabel.setPreferredSize(new Dimension(400, 30));
            lessonLabel.setHorizontalAlignment(SwingConstants.CENTER);
            JPanel emptySouth = new JPanel();
            lessonPanel.add(lessonLabel, BorderLayout.NORTH);
            JTable table = new JTable(leftTableData, leftTableColumnNames);
//                        JTable table = new JTable(5, 3);

            table.setCellSelectionEnabled(false);
            table.setEnabled(false);
//            lessonPanel.add(table);
            JScrollPane tablePane = new JScrollPane(table);
            tablePane.setPreferredSize(new Dimension(400, 100));
            lessonPanel.add(tablePane, BorderLayout.CENTER);
            lessonPanel.add(emptySouth, BorderLayout.SOUTH);

//            System.out.println("-----------" + list);
            midLeftPanel.add(lessonPanel);
        }

//        for (Bookings b : bookingsAL) {
//            if (b.getBookingType().equals("Lesson")) {
//                allLessonsBookingsAL.add(b);
//                
//            } else {
//                allCoachBookingsAL.add(b);
//            }
//        }
        for (Coach c : coachesAL) {
            ArrayList<Bookings> perCoachBookingsAL = new ArrayList<Bookings>();
            for (Bookings b : bookingsAL) {
                if (b.getBookingType().equals("Appointment") && b.getCoach().getId() == c.getId()) {
                    perCoachBookingsAL.add(b);
                }
                
            }
            if (perCoachBookingsAL.size() > 0) {
                allCoachBookingsAL.add(perCoachBookingsAL);
                
            }
        }
        
        String[] rightTableColumnNames = {"Booking ID", "Parent", "Date", "Time"};
        for (ArrayList<Bookings> list : allCoachBookingsAL) {
//            System.out.println("+++++++++" + list);
            String[][] rightTableData = new String[list.size()][];
            
            for (int i = 0; i < list.size(); i++) {
                Bookings b = list.get(i);
                String[] temp = {b.getId() + "", b.getNote(), dt.getDayMonthYearString(b.getAppointmentBookingDateTime()), dt.getOfficeTimeString(b.getAppointmentBookingDateTime(), b.getSlot())};
                rightTableData[i] = temp;
            }
            
            JPanel coachPanel = new JPanel(new BorderLayout());
            JLabel coachLabel = new JLabel("Coach ID: " + list.get(0).getCoach().getId() + "     " + list.get(0).getCoach().getFullName() + "     " + dt.getOfficeHourShortString(list.get(0).getCoach().getOfficeHour()));
            coachLabel.setPreferredSize(new Dimension(400, 30));
            coachLabel.setHorizontalAlignment(SwingConstants.CENTER);
            JPanel emptySouth = new JPanel();
            coachPanel.add(coachLabel, BorderLayout.NORTH);
            JTable table = new JTable(rightTableData, rightTableColumnNames);
//                        JTable table = new JTable(5, 3);
            table.setEnabled(false);
            
            table.setCellSelectionEnabled(false);
//            lessonPanel.add(table);
            JScrollPane tablePane = new JScrollPane(table);
            tablePane.setPreferredSize(new Dimension(400, 100));
            coachPanel.add(tablePane, BorderLayout.CENTER);
            coachPanel.add(emptySouth, BorderLayout.SOUTH);

//            System.out.println("-----------" + list);
            midRightPanel.add(coachPanel);
            
        }

//        for (int i = 0; i < allLessonsBookingsAL.size(); i++) {
//            Lessons l = allLessonsBookingsAL.get(i).getLesson();
//            
//            String[] temp = {l.getId()+"",l.getName(),getDateTimeShortString(l.getDateTime()), l.getCoach().getFullName()};
//            leftTableData[i] = temp;
//        }
//        JTable leftTable = new JTable(leftTableData, leftTableColumnNames);
//        JTable rightTable = new JTable(rightTableData, rightTableColumnNames);
        JScrollPane leftScrollPane = new JScrollPane(midLeftPanel);
        JScrollPane rightScrollPane = new JScrollPane(midRightPanel);
        midPanel.add(leftScrollPane);
        midPanel.add(rightScrollPane);
        
        JPanel emptyWest = new JPanel();
        JPanel emptyEast = new JPanel();
        JPanel emptySouth = new JPanel();
        reportPanel1.add(topPanel, BorderLayout.NORTH);
        reportPanel1.add(midPanel, BorderLayout.CENTER);
        reportPanel1.add(emptyWest, BorderLayout.WEST);
        reportPanel1.add(emptyEast, BorderLayout.EAST);
        reportPanel1.add(emptySouth, BorderLayout.SOUTH);
        
        generateReportFrame(reportPanel1, "Report - Lesson & Approintment Listing");
    }
    
    public void generateReport2() {
        reportPanel2 = new JPanel(new BorderLayout());
        JPanel topPanel = new JPanel();
        JPanel midPanel = new JPanel();
        midPanel.setLayout(new BoxLayout(midPanel, BoxLayout.Y_AXIS));
        JPanel emptySouth = new JPanel();
        JPanel emptyWest = new JPanel();
        JPanel emptyEast = new JPanel();
        
        topPanel.setPreferredSize(new Dimension(900, 70));
        JLabel titleLabel = new JLabel("Student Bookings");
        topPanel.add(titleLabel);
        ArrayList<ArrayList<Bookings>> allStudentsBookingsAL = new ArrayList<ArrayList<Bookings>>();
        String[] tableColumnNames = {"Booking ID", "Lesson", "Date & Time", "Coach", "Status"};
        for (Student s : studentsAL) {
            ArrayList<Bookings> studentBookingsAL = new ArrayList<Bookings>();
            for (Bookings b : bookingsAL) {
                if (b.getBookingType().equals("Lesson") && b.getStudent().getId() == s.getId()) {
                    
                    studentBookingsAL.add(b);
                    
                }
            }
            if (studentBookingsAL.size() > 0) {
                allStudentsBookingsAL.add(studentBookingsAL);
            }
        }
        
        for (ArrayList<Bookings> list : allStudentsBookingsAL) {
            String[][] tableData = new String[list.size()][];
            for (int i = 0; i < list.size(); i++) {
                String[] temp = {list.get(i).getId() + "", list.get(i).getLesson().getName(), list.get(i).getLesson().getDateTime(), list.get(i).getLesson().getCoach().getFullName(), list.get(i).getStatus()};
                tableData[i] = temp;
            }
            
            JPanel studentRecordPanel = new JPanel(new BorderLayout());
            studentRecordPanel.setPreferredSize(new Dimension(700, 100));
            JLabel studentLabel = new JLabel("Student ID: " + list.get(0).getStudent().getId() + "    " + list.get(0).getStudent().getFullName());
            studentRecordPanel.add(studentLabel, BorderLayout.NORTH);
            
            JTable table = new JTable(tableData, tableColumnNames);
            table.setCellSelectionEnabled(false);
            table.setEnabled(false);
            
            JScrollPane tablePane = new JScrollPane(table);
            tablePane.setPreferredSize(new Dimension(800, 200));
            studentRecordPanel.add(tablePane, BorderLayout.CENTER);
            studentRecordPanel.add(new JPanel(), BorderLayout.SOUTH);
            
            JScrollPane tableScrollPanel = new JScrollPane(studentRecordPanel);
            midPanel.add(tableScrollPanel);
        }
        JScrollPane midScrollPanel = new JScrollPane(midPanel);
        
        reportPanel2.add(topPanel, BorderLayout.NORTH);
        reportPanel2.add(midScrollPanel, BorderLayout.CENTER);
        reportPanel2.add(emptySouth, BorderLayout.SOUTH);
        reportPanel2.add(emptyEast, BorderLayout.EAST);
        reportPanel2.add(emptyWest, BorderLayout.WEST);
        
        generateReportFrame(reportPanel2, "Report - Student Listing");
    }
    
}
