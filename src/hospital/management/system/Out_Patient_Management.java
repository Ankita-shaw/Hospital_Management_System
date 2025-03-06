package hospital.management.system;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

    public class Out_Patient_Management extends JFrame implements ActionListener {
        Choice patientIdChoice;
        JTextField complaintsField, historyField, diagnosisField, investigationField, medicinesField, adviceField, nextVisitField;
        JButton b1,b2;
        JLabel date;

        Out_Patient_Management() {
            JPanel panel = new JPanel();
            panel.setBounds(5, 5, 840, 540);
            panel.setBackground(new Color(90, 156, 163));
            panel.setLayout(null);
            add(panel);

            ImageIcon imageIcon=new ImageIcon(ClassLoader.getSystemResource("icon/download.jpeg"));
            Image image=imageIcon.getImage().getScaledInstance(200,200,Image.SCALE_SMOOTH);
            ImageIcon imageIcon1=new ImageIcon(image);
            JLabel label=new JLabel(imageIcon1);
            label.setBounds(550,150,200,200);
            panel.add(label);

            JLabel title = new JLabel("Out-Patient Management");
            title.setFont(new Font("Tahoma", Font.BOLD, 20));
            title.setBounds(300, 10, 300, 30);
            panel.add(title);



            JLabel patientLabel = new JLabel("Patient ID:");
            patientLabel.setBounds(50, 50, 100, 20);
            patientLabel.setFont(new Font("Tahoma",Font.BOLD,14));
            patientLabel.setForeground(Color.WHITE);
            panel.add(patientLabel);
            patientIdChoice = new Choice();
            try {
                conn c = new conn();
                ResultSet rs = c.statement.executeQuery("SELECT Number from patient_info");
                while (rs.next()) {
                    patientIdChoice.add(rs.getString("Number"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            patientIdChoice.setBounds(300, 50, 150, 20);
            panel.add(patientIdChoice);

            JLabel labelComplaints =new JLabel(" Complaints: ");
            labelComplaints.setBounds(50,100,100,20);
            labelComplaints.setFont(new Font("Tahoma",Font.BOLD,14));
            labelComplaints.setForeground(Color.WHITE);
            panel.add(labelComplaints);

            complaintsField=new JTextField();
            complaintsField.setBounds(300,100,150,20);
            panel.add(complaintsField);

            JLabel labelHistory=new JLabel(" History: ");
            labelHistory.setBounds(50,150,100,20);
            labelHistory.setFont(new Font("Tahoma",Font.BOLD,14));
            labelHistory.setForeground(Color.WHITE);
            panel.add(labelHistory);

            historyField=new JTextField();
            historyField.setBounds(300,150,150,20);
            panel.add(historyField);

            JLabel labelDiagnosis=new JLabel(" Diagnosis: ");
            labelDiagnosis.setBounds(50,200,100,20);
            labelDiagnosis.setFont(new Font("Tahoma",Font.BOLD,14));
            labelDiagnosis.setForeground(Color.WHITE);
            panel.add(labelDiagnosis);

            diagnosisField=new JTextField();
            diagnosisField.setBounds(300,200,150,20);
            panel.add(diagnosisField);

            JLabel labelInvestigation=new JLabel(" Investigation: ");
            labelInvestigation.setBounds(50,250,140,20);
            labelInvestigation.setFont(new Font("Tahoma",Font.BOLD,14));
            labelInvestigation.setForeground(Color.WHITE);
            panel.add(labelInvestigation);

            investigationField=new JTextField();
            investigationField.setBounds(300,250,150,20);
            panel.add(investigationField);

            JLabel labelMedicines=new JLabel(" Medicines: ");
            labelMedicines.setBounds(50,300,100,20);
            labelMedicines.setFont(new Font("Tahoma",Font.BOLD,14));
            labelMedicines.setForeground(Color.WHITE);
            panel.add(labelMedicines);

            medicinesField=new JTextField();
            medicinesField.setBounds(300,300,140,20);
            panel.add(medicinesField);

            JLabel labelAdvice=new JLabel(" Advice: ");
            labelAdvice.setBounds(50,350,100,20);
            labelAdvice.setFont(new Font("Tahoma",Font.BOLD,14));
            labelAdvice.setForeground(Color.WHITE);
            panel.add(labelAdvice);

            adviceField=new JTextField();
            adviceField.setBounds(300,350,150,20);
            panel.add(adviceField);

            JLabel labelNext=new JLabel(" Next Visit: ");
            labelNext.setBounds(50,400,100,20);
            labelNext.setFont(new Font("Tahoma",Font.BOLD,14));
            labelNext.setForeground(Color.WHITE);
            panel.add(labelNext);

            nextVisitField=new JTextField();
            nextVisitField.setBounds(300,400,150,20);
            panel.add(nextVisitField);


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

        public static void main(String args[])
        {
            new Out_Patient_Management();
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            conn  c=new conn();
            String s1= patientIdChoice.getSelectedItem();
            String s2=complaintsField.getText();
            String s3=historyField.getText();
            String s4=diagnosisField.getText();
            String s5=investigationField.getText();
            String s6=medicinesField.getText();
            String s7=adviceField.getText();
            String s8=nextVisitField.getText();

            try
            {
                String q="insert into out_patient values('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"','"+s7+"','"+s8+"')";

                c.statement.executeUpdate(q);
                JOptionPane.showMessageDialog(null,"Added Successfully");
                setVisible(false);
            }catch(Exception E){
                E.printStackTrace();
            }
        }

    }
