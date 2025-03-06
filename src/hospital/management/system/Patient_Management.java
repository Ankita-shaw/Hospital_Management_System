package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Patient_Management extends JFrame implements ActionListener {
    JTextField patientNameField, clinicalDataField;
    JTextArea servicesArea;
    Choice patientIdField, consultantIdField, bedNumberField;
    JButton addButton, backButton;

    Patient_Management() {
        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 840, 540);
        panel.setBackground(new Color(120, 160, 180));
        panel.setLayout(null);
        add(panel);

        ImageIcon imageIcon=new ImageIcon(ClassLoader.getSystemResource("icon/roomm.png"));
        Image image=imageIcon.getImage().getScaledInstance(200,200,Image.SCALE_SMOOTH);
        ImageIcon imageIcon1=new ImageIcon(image);
        JLabel label=new JLabel(imageIcon1);
        label.setBounds(580,150,240,200);
        panel.add(label);

        JLabel title = new JLabel("Patient Management");
        title.setFont(new Font("Tahoma", Font.BOLD, 22));
        title.setBounds(280, 10, 300, 30);
        title.setForeground(Color.BLACK);
        panel.add(title);

        JLabel patientLabel = new JLabel("Patient ID:");
        patientLabel.setBounds(50, 50, 150, 20);
        patientLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(patientLabel);

        patientIdField = new Choice();
        try {
            conn c = new conn();
            ResultSet rs = c.statement.executeQuery("SELECT Number FROM patient_info");
            while (rs.next()) {
                patientIdField.add(rs.getString("Number"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        patientIdField.setBounds(300, 50, 150, 20);
        panel.add(patientIdField);

        JLabel consultantLabel = new JLabel("Consultant ID:");
        consultantLabel.setBounds(50, 100, 150, 20);
        consultantLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(consultantLabel);

        consultantIdField = new Choice();
        try {
            conn c = new conn();
            ResultSet rs = c.statement.executeQuery("SELECT doctor_id FROM doctor");
            while (rs.next()) {
                consultantIdField.add(rs.getString("doctor_id"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        consultantIdField.setBounds(300, 100, 150, 20);
        panel.add(consultantIdField);

        JLabel bedLabel = new JLabel("Room Number:");
        bedLabel.setBounds(50, 150, 150, 20);
        bedLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(bedLabel);

        bedNumberField = new Choice();
        try {
            conn c = new conn();
            ResultSet rs = c.statement.executeQuery("SELECT room_no FROM Room");
            while (rs.next()) {
                bedNumberField.add(rs.getString("room_no"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        bedNumberField.setBounds(300, 150, 150, 20);
        panel.add(bedNumberField);

        JLabel clinicalLabel = new JLabel("Clinical Data:");
        clinicalLabel.setBounds(50, 200, 150, 20);
        clinicalLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(clinicalLabel);

        clinicalDataField = new JTextField();
        clinicalDataField.setBounds(300, 200, 150, 20);
        panel.add(clinicalDataField);

        JLabel servicesLabel = new JLabel("Services Provided:");
        servicesLabel.setBounds(50, 250, 150, 20);
        servicesLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(servicesLabel);

        servicesArea = new JTextArea();
        servicesArea.setBounds(300, 250, 250, 100);
        panel.add(servicesArea);

        addButton = new JButton("ADD");
        addButton.setBounds(150, 450, 120, 30);
        addButton.setForeground(Color.WHITE);
        addButton.setBackground(Color.BLACK);
        addButton.addActionListener(this);
        panel.add(addButton);

        backButton = new JButton("BACK");
        backButton.setBounds(300, 450, 120, 30);
        backButton.setForeground(Color.WHITE);
        backButton.setBackground(Color.BLACK);
        backButton.addActionListener(this);
        panel.add(backButton);

        setUndecorated(true);
        setSize(850, 550);
        setLocation(300, 100);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            try {
                String patientId = patientIdField.getSelectedItem();
                String consultantId = consultantIdField.getSelectedItem();
                String bedNumber = bedNumberField.getSelectedItem();
                String clinicalData = clinicalDataField.getText();
                String services = servicesArea.getText();

                conn c = new conn();
                String query = "INSERT INTO patient_management (patient_id, consultant_id, bed_number, clinical_data, services) " +
                        "VALUES ('" + patientId + "', '" + consultantId + "', '" + bedNumber + "', '" + clinicalData + "', '" + services + "')";

                c.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Added Successfully");
                setVisible(false);
            }catch(Exception E){
                E.printStackTrace();
            }
        } else if (e.getSource() == backButton) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Patient_Management();
    }
}
