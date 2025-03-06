package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class login extends JFrame implements ActionListener{
    JTextField textField;
    JPasswordField jPasswordField;
    JButton b1, b2;
    JCheckBox showPassword;

    login() {
        setTitle("Hospital Management System - Login");
        setLayout(null);

        JLabel titleLabel = new JLabel("Welcome to HMS");
        titleLabel.setBounds(240, 10, 300, 40);
        titleLabel.setFont(new Font("Verdana", Font.BOLD, 28));
        titleLabel.setForeground(new Color(128, 0, 128));
        add(titleLabel);

        JLabel nameLabel = new JLabel("Username");
        nameLabel.setBounds(40, 60, 100, 30);
        nameLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(nameLabel);

        JLabel password = new JLabel("Password");
        password.setBounds(40, 110, 100, 30);
        password.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(password);

        textField = new JTextField();
        textField.setBounds(150, 60, 180, 30);
        textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
        textField.setBackground(new Color(240, 240, 255));
        add(textField);

        jPasswordField = new JPasswordField();
        jPasswordField.setBounds(150, 110, 180, 30);
        jPasswordField.setFont(new Font("Tahoma", Font.PLAIN, 15));
        add(jPasswordField);

        showPassword = new JCheckBox("Show Password");
        showPassword.setBounds(150, 145, 150, 20);
        showPassword.addActionListener(e -> jPasswordField.setEchoChar(showPassword.isSelected() ? (char) 0 : '*'));
        add(showPassword);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/abc.jpg"));
        JLabel label = new JLabel(new ImageIcon(imageIcon.getImage().getScaledInstance(350, 180, Image.SCALE_SMOOTH)));
        label.setBounds(350, 50, 350, 180);
        add(label);

        b1 = new JButton("Login");
        b1.setBounds(70, 190, 120, 40);
        b1.setFont(new Font("Arial", Font.BOLD, 15));
        b1.setBackground(new Color(60, 179, 113));
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Cancel");
        b2.setBounds(210, 190, 120, 40);
        b2.setFont(new Font("Arial", Font.BOLD, 15));
        b2.setBackground(new Color(255, 69, 0));
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        add(b2);

        getContentPane().setBackground(new Color(255, 228, 225)); // Soft pink background
        setSize(750, 300);
        setLocation(400, 270);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new login();
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==b1)
        {
          try{
              conn c=new conn();
              String user=textField.getText();
              String pass=jPasswordField.getText();

              String q="select * from login where ID='"+user+"' and PW='"+pass+"'";
              ResultSet resultSet=c.statement.executeQuery(q);


              if(resultSet.next())
              {
                  new Reception();
                  setVisible(false);
              }
              else
              {
                  JOptionPane.showMessageDialog(null,"Invalid");

              }
          }catch(Exception E)
          {
              E.printStackTrace();
          }
        }else
        {
            System.exit(10);
        }

    }
}
