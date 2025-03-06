package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Billing extends JFrame implements ActionListener {
    JTextField paymentAmountField;
    JTextArea servicesAvailedArea;
    Choice patientIdChoice, paymentModeChoice, accountTypeChoice;
    JButton generateProvisionalButton, generateFinalButton, backButton;

    Billing() {
        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 840, 540);
        panel.setBackground(new Color(180, 200, 220));
        panel.setLayout(null);
        add(panel);

        ImageIcon imageIcon=new ImageIcon(ClassLoader.getSystemResource("icon/bcd.jpg"));
        Image image=imageIcon.getImage().getScaledInstance(300,180,Image.SCALE_SMOOTH);
        ImageIcon imageIcon1=new ImageIcon(image);
        JLabel label=new JLabel(imageIcon1);
        label.setBounds(500,30,350,200);
        label.setFont(new Font("Tahoma",Font.BOLD,14));
        label.setForeground(Color.WHITE);
        panel.add(label);

        JLabel title = new JLabel("Billing Module");
        title.setFont(new Font("Tahoma", Font.BOLD, 22));
        title.setBounds(330, 10, 300, 30);
        title.setForeground(Color.BLACK);
        panel.add(title);

        JLabel patientLabel = new JLabel("Patient ID:");
        patientLabel.setBounds(50, 50, 150, 20);
        patientLabel.setFont(new Font("Tahoma",Font.BOLD,14));
        patientLabel.setForeground(Color.BLACK);
        panel.add(patientLabel);

        patientIdChoice = new Choice();
        try {
            conn c = new conn();
            ResultSet rs = c.statement.executeQuery("SELECT Number FROM patient_info");
            while (rs.next()) {
                patientIdChoice.add(rs.getString("Number"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        patientIdChoice.setBounds(250, 50, 150, 20);
        panel.add(patientIdChoice);

        JLabel paymentModeLabel = new JLabel("Payment Mode:");
        paymentModeLabel.setBounds(50, 100, 150, 20);
        paymentModeLabel.setFont(new Font("Tahoma",Font.BOLD,14));
        paymentModeLabel.setForeground(Color.BLACK);
        panel.add(paymentModeLabel);

        paymentModeChoice = new Choice();
        paymentModeChoice.add("Cash");
        paymentModeChoice.add("Credit Card");
        paymentModeChoice.add("Cheque");
        paymentModeChoice.add("DD");
        paymentModeChoice.setBounds(250, 100, 150, 20);
        panel.add(paymentModeChoice);

        JLabel accountTypeLabel = new JLabel("Account Type:");
        accountTypeLabel.setBounds(50, 150, 150, 20);
        accountTypeLabel.setFont(new Font("Tahoma",Font.BOLD,14));
        accountTypeLabel.setForeground(Color.BLACK);
        panel.add(accountTypeLabel);

        accountTypeChoice = new Choice();
        accountTypeChoice.add("Self");
        accountTypeChoice.add("LIC Account");
        accountTypeChoice.add("Company Account");
        accountTypeChoice.add("Donor Account");
        accountTypeChoice.setBounds(250, 150, 150, 20);
        panel.add(accountTypeChoice);

        JLabel paymentAmountLabel = new JLabel("Payment Amount:");
        paymentAmountLabel.setBounds(50, 200, 150, 20);
        paymentAmountLabel.setFont(new Font("Tahoma",Font.BOLD,14));
        paymentAmountLabel.setForeground(Color.BLACK);
        panel.add(paymentAmountLabel);

        paymentAmountField = new JTextField();
        paymentAmountField.setBounds(250, 200, 150, 20);
        panel.add(paymentAmountField);

        JLabel servicesAvailedLabel = new JLabel("Services Availed:");
        servicesAvailedLabel.setBounds(50, 250, 150, 20);
        servicesAvailedLabel.setFont(new Font("Tahoma",Font.BOLD,14));
        servicesAvailedLabel.setForeground(Color.BLACK);
        panel.add(servicesAvailedLabel);

        servicesAvailedArea = new JTextArea();
        servicesAvailedArea.setBounds(250, 250, 300, 100);
        panel.add(servicesAvailedArea);

        generateProvisionalButton = new JButton("Generate Provisional Bill");
        generateProvisionalButton.setBounds(100, 400, 200, 30);
        generateProvisionalButton.setForeground(Color.BLACK);
        generateProvisionalButton.setBackground(Color.green);
        generateProvisionalButton.addActionListener(this);
        panel.add(generateProvisionalButton);

        generateFinalButton = new JButton("Generate Final Bill");
        generateFinalButton.setBounds(350, 400, 200, 30);
        generateFinalButton.setForeground(Color.BLACK);
        generateFinalButton.setBackground(Color.red);
        generateFinalButton.addActionListener(this);
        panel.add(generateFinalButton);

        backButton = new JButton("BACK");
        backButton.setBounds(600, 400, 120, 30);
        backButton.setForeground(Color.BLACK);
        backButton.setBackground(Color.orange);
        backButton.addActionListener(this);
        panel.add(backButton);

        setUndecorated(true);
        setSize(850, 550);
        setLocation(300, 100);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == generateProvisionalButton || e.getSource() == generateFinalButton) {
            try {
                String patientId = patientIdChoice.getSelectedItem();
                String paymentMode = paymentModeChoice.getSelectedItem();
                String accountType = accountTypeChoice.getSelectedItem();
                String paymentAmount = paymentAmountField.getText();
                String services = servicesAvailedArea.getText();
                String billType = e.getSource() == generateProvisionalButton ? "Provisional" : "Final";

                conn c = new conn();
                String query = "INSERT INTO billing (patient_id, payment_mode, account_type, payment_amount, services_availed, bill_type) " +
                        "VALUES ('" + patientId + "', '" + paymentMode + "', '" + accountType + "', '" + paymentAmount + "', '" + services + "', '" + billType + "')";
                c.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, billType + " Bill Generated Successfully");
                setVisible(false);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (e.getSource() == backButton) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Billing();
    }
}