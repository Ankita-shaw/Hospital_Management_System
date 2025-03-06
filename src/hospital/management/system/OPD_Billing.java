package hospital.management.system;

import javax.swing.*;
        import java.awt.*;
        import java.awt.event.*;
        import java.sql.*;

public class OPD_Billing extends JFrame implements ActionListener {
    JTextField  chargesField, concessionField, authorityField;
    Choice categoryChoice, paymentTypeChoice,patientIdField;
    JButton b1,b2;

    OPD_Billing() {
        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 840, 540);
        panel.setBackground(new Color(80, 150, 170));
        panel.setLayout(null);
        add(panel);

        ImageIcon imageIcon=new ImageIcon(ClassLoader.getSystemResource("icon/feature1.jpg"));
        Image image=imageIcon.getImage().getScaledInstance(300,200,Image.SCALE_SMOOTH);
        ImageIcon imageIcon1=new ImageIcon(image);
        JLabel label=new JLabel(imageIcon1);
        label.setBounds(550,150,200,200);
        panel.add(label);

        JLabel title = new JLabel("OPD Billing");
        title.setFont(new Font("Tahoma", Font.BOLD, 22));
        title.setBounds(300, 10, 200, 30);
        panel.add(title);


        JLabel patientLabel = new JLabel("Patient ID:");
        patientLabel.setBounds(50, 50, 100, 20);
        patientLabel.setFont(new Font("Tahoma",Font.BOLD,14));
        patientLabel.setForeground(Color.BLACK);
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
        patientIdField.setBounds(300, 50, 150, 20);
        panel.add(patientIdField);



        JLabel chargesLabel = new JLabel("Charges:");
        chargesLabel.setBounds(50, 100, 100, 20);
        chargesLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        chargesLabel.setForeground(Color.BLACK);
        panel.add(chargesLabel);

        chargesField = new JTextField();
        chargesField.setBounds(300, 100, 150, 20);
        panel.add(chargesField);

        JLabel concessionLabel = new JLabel("Concession:");
        concessionLabel.setBounds(50, 150, 100, 20);
        concessionLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        concessionLabel.setForeground(Color.BLACK);
        panel.add(concessionLabel);

        concessionField = new JTextField();
        concessionField.setBounds(300, 150, 150, 20);
        panel.add(concessionField);

        JLabel authorityLabel = new JLabel("Concession Authority:");
        authorityLabel.setBounds(50, 200, 170, 20);
        authorityLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        authorityLabel.setForeground(Color.BLACK);
        panel.add(authorityLabel);

        authorityField = new JTextField();
        authorityField.setBounds(300, 200, 150, 20);
        panel.add(authorityField);

        JLabel categoryLabel = new JLabel("Category:");
        categoryLabel.setBounds(50, 250, 100, 20);
        categoryLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        categoryLabel.setForeground(Color.BLACK);
        panel.add(categoryLabel);

        categoryChoice = new Choice();
        categoryChoice.add("General");
        categoryChoice.add("Emergency");
        categoryChoice.add("Panel");
        categoryChoice.setBounds(300, 250, 150, 20);
        panel.add(categoryChoice);

        JLabel paymentLabel = new JLabel("Payment Type:");
        paymentLabel.setBounds(50, 300, 140, 20);
        paymentLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        paymentLabel.setForeground(Color.BLACK);
        panel.add(paymentLabel);

        paymentTypeChoice = new Choice();
        paymentTypeChoice.add("Cash");
        paymentTypeChoice.add("Credit");
        paymentTypeChoice.setBounds(300, 300, 150, 20);
        panel.add(paymentTypeChoice);

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
            String patientId = patientIdField.getSelectedItem();
            String charges = chargesField.getText();
            String concession = concessionField.getText();
            String authority = authorityField.getText();
            String category = categoryChoice.getSelectedItem();
            String paymentType = paymentTypeChoice.getSelectedItem();

            conn c = new conn();
            String q1 = "INSERT INTO opd_billing (patient_id, charges, concession, authority, category, payment_type) " +
                    "VALUES ('" + patientId + "','" + charges + "','" + concession + "','" + authority + "','" + category + "','" + paymentType + "')";

            c.statement.executeUpdate(q1);
            JOptionPane.showMessageDialog(null,"Added Successfully");
            setVisible(false);
        }catch(Exception E){
            E.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new OPD_Billing();
    }
}
