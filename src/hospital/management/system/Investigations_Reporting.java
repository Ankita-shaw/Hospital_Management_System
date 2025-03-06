package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Investigations_Reporting extends JFrame implements ActionListener {
    JTextField requisitionField, testNameField;
    JTextArea resultsArea;
    Choice statusChoice, patientIdField, doctorIdField;
    JButton b1,b2;

    Investigations_Reporting() {
        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 840, 540);
        panel.setBackground(new Color(100, 180, 200));
        panel.setLayout(null);
        add(panel);

        ImageIcon imageIcon=new ImageIcon(ClassLoader.getSystemResource("icon/npl.jpg"));
        Image image=imageIcon.getImage().getScaledInstance(200,200,Image.SCALE_SMOOTH);
        ImageIcon imageIcon1=new ImageIcon(image);
        JLabel label=new JLabel(imageIcon1);
        label.setBounds(580,150,240,200);
        panel.add(label);

        JLabel title = new JLabel("Investigations Reporting");
        title.setFont(new Font("Tahoma", Font.BOLD, 22));
        title.setBounds(280, 10, 300, 30);
        panel.add(title);

        JLabel requisitionLabel = new JLabel("Requisition ID:");
        requisitionLabel.setBounds(50, 50, 150, 20);
        requisitionLabel.setFont(new Font("Tahoma",Font.BOLD,14));
        requisitionLabel.setForeground(Color.WHITE);
        panel.add(requisitionLabel);

        requisitionField = new JTextField();
        requisitionField.setBounds(300, 50, 150, 20);
        panel.add(requisitionField);

        JLabel patientLabel = new JLabel("Patient ID:");
        patientLabel.setBounds(50, 100, 150, 20);
        patientLabel.setFont(new Font("Tahoma",Font.BOLD,14));
        patientLabel.setForeground(Color.WHITE);
        panel.add(patientLabel);


        patientIdField = new Choice();
        try {
            conn c = new conn();
            ResultSet rs = c.statement.executeQuery("SELECT Number from patient_info");
            while (rs.next()) {
                patientIdField.add(rs.getString("Number"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        patientIdField.setBounds(300, 100, 150, 20);
        panel.add(patientIdField);

        JLabel doctorLabel = new JLabel("Doctor ID:");
        doctorLabel.setBounds(50, 150, 150, 20);
        doctorLabel.setFont(new Font("Tahoma",Font.BOLD,14));
        doctorLabel.setForeground(Color.WHITE);
        panel.add(doctorLabel);

        doctorIdField = new Choice();
        try {
            conn c = new conn();
            ResultSet rs = c.statement.executeQuery("SELECT doctor_id from doctor");
            while (rs.next()) {
                doctorIdField.add(rs.getString("doctor_id"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        doctorIdField.setBounds(300, 150, 150, 20);
        panel.add(doctorIdField);

        JLabel testLabel = new JLabel("Test Name:");
        testLabel.setBounds(50, 200, 150, 20);
        testLabel.setFont(new Font("Tahoma",Font.BOLD,14));
        testLabel.setForeground(Color.WHITE);
        panel.add(testLabel);

        testNameField = new JTextField();
        testNameField.setBounds(300, 200, 150, 20);
        panel.add(testNameField);

        JLabel resultsLabel = new JLabel("Results:");
        resultsLabel.setBounds(50, 250, 150, 20);
        resultsLabel.setFont(new Font("Tahoma",Font.BOLD,14));
        resultsLabel.setForeground(Color.WHITE);
        panel.add(resultsLabel);

        resultsArea = new JTextArea();
        resultsArea.setBounds(300, 250, 250, 100);
        panel.add(resultsArea);

        JLabel statusLabel = new JLabel("Status:");
        statusLabel.setBounds(50, 370, 150, 20);
        statusLabel.setFont(new Font("Tahoma",Font.BOLD,14));
        statusLabel.setForeground(Color.WHITE);
        panel.add(statusLabel);

        statusChoice = new Choice();
        statusChoice.add("Pending");
        statusChoice.add("Completed");
        statusChoice.add("Validated");
        statusChoice.setBounds(300, 370, 150, 20);
        panel.add(statusChoice);

        b1=new JButton("ADD");
        b1.setBounds(150,450,120,30);
        b1.setForeground(Color.WHITE);
        b1.setBackground(Color.black);
        b1.addActionListener(this);
        panel.add(b1);

        b2=new JButton("BACK");
        b2.setBounds(300,450,120,30);
        b2.setForeground(Color.WHITE);
        b2.setBackground(Color.black);
        b2.addActionListener(this);
        panel.add(b2);

        setUndecorated(true);
        setSize(850, 550);
        setLocation(300, 100);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String requisitionId = requisitionField.getText();
            String patientId = patientIdField.getSelectedItem();
            String doctorId = doctorIdField.getSelectedItem();
            String testName = testNameField.getText();
            String results = resultsArea.getText();
            String status = statusChoice.getSelectedItem();

            conn c = new conn();
            String q1 = "INSERT INTO investigations_reporting (requisition_id, patient_id, doctor_id, test_name, results, status) " +
                    "VALUES ('" + requisitionId + "','" + patientId + "','" + doctorId + "','" + testName + "','" + results + "','" + status + "')";

            c.statement.executeUpdate(q1);
            JOptionPane.showMessageDialog(null,"Added Successfully");
            setVisible(false);
        }catch(Exception E){
            E.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Investigations_Reporting();
    }
}
