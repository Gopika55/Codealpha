package jframepro;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;

@SuppressWarnings("serial")
public class Studentgrade extends JFrame {

    static class Student {
        String name;
        int grade;

        Student(String name, int grade) {
            this.name = name;
            this.grade = grade;
        }
    }

    private ArrayList<Student> students = new ArrayList<>();
    private JTextField studentCountField;
    private JTextArea nameArea;
    private JTextArea gradeArea;
    private JTextArea resultArea;

    public Studentgrade() {
        // Set up the frame
        setTitle("Student Grade Tracker");
        setSize(533, 580);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create components
        JLabel studentCountLabel = new JLabel("Enter the number of students: ");
        studentCountLabel.setHorizontalAlignment(SwingConstants.CENTER);
        studentCountLabel.setFont(new Font("Sitka Subheading", Font.BOLD | Font.ITALIC, 15));
        studentCountField = new JTextField(10);
        studentCountField.setFont(new Font("Sitka Subheading", Font.BOLD | Font.ITALIC, 14));
        JButton addStudentsButton = new JButton("Add Students");
        addStudentsButton.setFont(new Font("Sitka Subheading", Font.BOLD | Font.ITALIC, 15));
        addStudentsButton.setForeground(new Color(0, 0, 0));
        addStudentsButton.setBackground(new Color(240, 230, 140));

        JLabel nameLabel = new JLabel("Enter student names (one per line): ");
        nameLabel.setFont(new Font("Sitka Subheading", Font.BOLD | Font.ITALIC, 15));
        nameArea = new JTextArea(10, 30);
        nameArea.setFont(new Font("Sitka Subheading", Font.BOLD | Font.ITALIC, 14));
        nameArea.setBackground(SystemColor.text);
        JScrollPane nameScrollPane = new JScrollPane(nameArea);

        JLabel gradeLabel = new JLabel("Enter student grades (one per line): ");
        gradeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        gradeLabel.setFont(new Font("Sitka Subheading", Font.BOLD | Font.ITALIC, 15));
        gradeArea = new JTextArea(10, 30);
        gradeArea.setFont(new Font("Sitka Subheading", Font.BOLD | Font.ITALIC, 14));
        gradeArea.setBackground(SystemColor.text);
        JScrollPane gradeScrollPane = new JScrollPane(gradeArea);

        JButton calculateButton = new JButton("Calculate");
        calculateButton.setFont(new Font("Sitka Subheading", Font.BOLD | Font.ITALIC, 15));
        resultArea = new JTextArea(5, 40);
        resultArea.setFont(new Font("Sitka Subheading", Font.BOLD | Font.ITALIC, 14));
        resultArea.setBackground(SystemColor.text);
        resultArea.setEditable(false);
        JScrollPane resultScrollPane = new JScrollPane(resultArea);

        // Add components to the frame
        JPanel panel = new JPanel();
        panel.setBackground(new Color(105, 105, 105));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(studentCountLabel);
        panel.add(studentCountField);
        panel.add(addStudentsButton);
        panel.add(nameLabel);
        panel.add(nameScrollPane);
        panel.add(gradeLabel);
        panel.add(gradeScrollPane);
        panel.add(calculateButton);
        panel.add(resultScrollPane);
        getContentPane().add(panel);

        // Add action listeners
        addStudentsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addStudents();
            }
        });

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateResults();
            }
        });
    }

    private void addStudents() {
        students.clear();  // Clear previous student data

        try {
            int studentCount = Integer.parseInt(studentCountField.getText().trim());

            String[] names = nameArea.getText().split("\n");
            String[] grades = gradeArea.getText().split("\n");

            if (names.length != studentCount || grades.length != studentCount) {
                JOptionPane.showMessageDialog(this, "Number of names and grades must match the student count.");
                return;
            }

            for (int i = 0; i < studentCount; i++) {
                String name = names[i].trim();
                int grade = Integer.parseInt(grades[i].trim());
                students.add(new Student(name, grade));
            }

            JOptionPane.showMessageDialog(this, "Students added successfully!");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter valid numbers for student count and grades.");
        }
    }

    private void calculateResults() {
        if (students.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No students available.");
            return;
        }

        int sum = 0, highest = Integer.MIN_VALUE, lowest = Integer.MAX_VALUE;

        for (Student student : students) {
            int grade = student.grade;
            sum += grade;
            if (grade > highest) highest = grade;
            if (grade < lowest) lowest = grade;
        }

        double average = (double) sum / students.size();

        resultArea.setText(String.format("Highest Grade: %.1f\n", (double) highest));
        resultArea.append(String.format("Average Grade: %.1f\n", average));
        resultArea.append(String.format("Lowest Grade: %.1f\n", (double) lowest));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Studentgrade tracker = new Studentgrade();
            tracker.setVisible(true);
        });
    }
}
