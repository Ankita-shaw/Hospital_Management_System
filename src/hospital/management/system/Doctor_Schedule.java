package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Doctor_Schedule extends JFrame implements ActionListener {
    JComboBox<String> deptComboBox, doctorComboBox;
    JLabel doctorNameLabel,date;
    JButton submitButton, backButton;
    Choice c1,c2,c3,c4,c5;
    JButton b1,b2;

    Doctor_Schedule() {
        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 840, 540);
        panel.setBackground(new Color(90,156,163));
        panel.setLayout(null);
        add(panel);

        ImageIcon imageIcon=new ImageIcon(ClassLoader.getSystemResource("icon/dr.png"));
        Image image=imageIcon.getImage().getScaledInstance(200,200,Image.SCALE_SMOOTH);
        ImageIcon imageIcon1=new ImageIcon(image);
        JLabel label=new JLabel(imageIcon1);
        label.setBounds(550,150,200,200);
        panel.add(label);

        JLabel labelName=new JLabel("Doctor Scheduling ");
        labelName.setBounds(500,11,260,53);
        labelName.setFont(new Font("Tahoma",Font.BOLD,20));
        panel.add(labelName);


        JLabel labelID=new JLabel(" ID: ");
        labelID.setBounds(35,50,200,14);
        labelID.setFont(new Font("Tahoma",Font.BOLD,14));
        labelID.setForeground(Color.WHITE);
        panel.add(labelID);

        c3=new Choice();
        try{
            conn c=new conn();
            ResultSet resultSet=c.statement.executeQuery("select * from doctor");
            while(resultSet.next())
            {
                c3.add(resultSet.getString("dept_id"));
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }

        c3.setBounds(300,50,150,20);
        c3.setFont(new Font("Tahoma",Font.BOLD,14));
        c3.setForeground(Color.WHITE);
        c3.setBackground(new Color(3,45,48));
        panel.add(c3);

        JLabel doctorID=new JLabel(" Doctor ID: ");
        doctorID.setBounds(35,100,200,14);
        doctorID.setFont(new Font("Tahoma",Font.BOLD,14));
        doctorID.setForeground(Color.WHITE);
        panel.add(doctorID);
        c2=new Choice();
        try{
            conn c=new conn();
            ResultSet resultSet=c.statement.executeQuery("select * from doctor_schedule");
            while(resultSet.next())
            {
                c2.add(resultSet.getString("doctor_id"));
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }

        c2.setBounds(300,100,150,20);
        c2.setFont(new Font("Tahoma",Font.BOLD,14));
        c2.setForeground(Color.WHITE);
        c2.setBackground(new Color(3,45,48));
        panel.add(c2);


        doctorNameLabel = new JLabel("Doctor Name:");
        doctorNameLabel.setBounds(35, 150, 200, 14);
        doctorNameLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        doctorNameLabel.setForeground(Color.WHITE);
        panel.add(doctorNameLabel);

        c1=new Choice();
        try{
            conn c=new conn();
            ResultSet resultSet=c.statement.executeQuery("select * from doctor");
            while(resultSet.next())
            {
                c1.add(resultSet.getString("doctor_name"));
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }

        c1.setBounds(300,150,150,20);
        c1.setFont(new Font("Tahoma",Font.BOLD,14));
        c1.setForeground(Color.WHITE);
        c1.setBackground(new Color(3,45,48));
        panel.add(c1);



        JLabel labelDate=new JLabel(" Time : ");
        labelDate.setBounds(35,200,200,14);
        labelDate.setFont(new Font("Tahoma",Font.BOLD,14));
        labelDate.setForeground(Color.WHITE);
        panel.add(labelDate);

        java.util.Date date1=new java.util.Date();

        date=new JLabel(""+date1);
        date.setBounds(300,200,250,20);
        date.setForeground(Color.white);
        date.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(date);



        JLabel labelDoctor=new JLabel(" Doctor Type: ");
        labelDoctor.setBounds(35,250,200,14);
        labelDoctor.setFont(new Font("Tahoma",Font.BOLD,14));
        labelDoctor.setForeground(Color.WHITE);
        panel.add(labelDoctor);

        c4=new Choice();
        try{
            conn c=new conn();
            ResultSet resultSet=c.statement.executeQuery("select * from doctor_schedule");
            while(resultSet.next())
            {
                c4.add(resultSet.getString("doctor_type"));
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }

        c4.setBounds(300,250,150,20);
        c4.setFont(new Font("Tahoma",Font.BOLD,14));
        c4.setForeground(Color.WHITE);
        c4.setBackground(new Color(3,45,48));
        panel.add(c4);


        JLabel labelVisiting=new JLabel(" Visiting Hours : ");
        labelVisiting.setBounds(35,300,200,14);
        labelVisiting.setFont(new Font("Tahoma",Font.BOLD,14));
        labelVisiting.setForeground(Color.WHITE);
        panel.add(labelVisiting);

        c5=new Choice();
        try{
            conn c=new conn();
            ResultSet resultSet=c.statement.executeQuery("select * from doctor_schedule");
            while(resultSet.next())
            {
                c5.add(resultSet.getString("visit_hours"));
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }

        c5.setBounds(300,300,170,20);
        c5.setFont(new Font("Tahoma",Font.BOLD,14));
        c5.setForeground(Color.WHITE);
        c5.setBackground(new Color(3,45,48));
        panel.add(c5);

        b1=new JButton("ADD");
        b1.setBounds(100,430,120,30);
        b1.setForeground(Color.WHITE);
        b1.setBackground(Color.black);
        b1.addActionListener(this);
        panel.add(b1);

        b2=new JButton("BACK");
        b2.setBounds(260,430,120,30);
        b2.setForeground(Color.WHITE);
        b2.setBackground(Color.black);
        b2.addActionListener(this);
        panel.add(b2);

        setUndecorated(true);
        setSize(850,550);
        setLayout(null);
        setLocation(300,100);
        setVisible(true);

    }
    public static void main(String args[])
    {
        new Doctor_Schedule();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        conn  c=new conn();
        String s1= c3.getSelectedItem();
        String s2=c2.getSelectedItem();
        String s3=c1.getSelectedItem();
        String s4=date.getText();
        String s5=c4.getSelectedItem();
        String s6=c5.getSelectedItem();



        try
        {
            String q="insert into doctor_info values('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"')";

            c.statement.executeUpdate(q);
            JOptionPane.showMessageDialog(null,"Added Successfully");
            setVisible(false);
        }catch(Exception E){
            E.printStackTrace();
        }
    }

}


