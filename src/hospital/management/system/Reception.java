package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Reception extends JFrame
{

    Reception()
    {

        JPanel panel=new JPanel();
        panel.setLayout(null);
        panel.setBounds(5,160,1525,670);
        panel.setBackground(new Color(109,164,170));
        add(panel);

        JPanel panel1=new JPanel();
        panel1.setLayout(null);
        panel1.setBounds(5,5,1525,150);
        panel1.setBackground(new Color(109,164,170));
        add(panel1);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Icon/dr.png"));
        Image image=i1.getImage().getScaledInstance(300,130,Image.SCALE_SMOOTH);
        ImageIcon i2=new ImageIcon(image);
        JLabel label=new JLabel(i2);
        label.setBounds(980,0,250,250);
        panel1.add(label);

        ImageIcon i11=new ImageIcon(ClassLoader.getSystemResource("Icon/amb.png"));
        Image image1=i11.getImage().getScaledInstance(300,100,Image.SCALE_SMOOTH);
        ImageIcon i22=new ImageIcon(image1);
        JLabel label1=new JLabel(i22);
        label1.setBounds(700,50,500,100);
        panel1.add(label1);

        JButton btn1=new JButton(" Patient Registration ");
        btn1.setBounds(30,15,200,30);
        btn1.setBackground(new Color(246,215,118));
        panel1.add(btn1);
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                new Patient_registration();
            }
        });

        JButton btn2=new JButton(" Doctor Scheduling  ");
        btn2.setBounds(30,58,200,30);
        btn2.setBackground(new Color(246,215,118));
        panel1.add(btn2);
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                    new Doctor_Schedule();
            }
        });

        JButton btn3=new JButton("Investigation Reporting ");
        btn3.setBounds(30,100,200,30);
        btn3.setBackground(new Color(246,215,118));
        panel1.add(btn3);
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                new Investigations_Reporting();
            }
        });
        JButton btn4=new JButton("OPD Billing  ");
        btn4.setBounds(270,15,200,30);
        btn4.setBackground(new Color(246,215,118));
        panel1.add(btn4);
        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                new OPD_Billing();
            }
        });

        JButton btn5=new JButton(" Patient Management ");
        btn5.setBounds(270,58,200,30);
        btn5.setBackground(new Color(246,215,118));
        panel1.add(btn5);
        btn5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                    new Patient_Management();
            }
        });

        JButton btn6=new JButton(" Out Patient Management ");
        btn6.setBounds(270,100,200,30);
        btn6.setBackground(new Color(246,215,118));
        panel1.add(btn6);
        btn6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                    new Out_Patient_Management();
            }
        });

        JButton btn7=new JButton(" Central Store ");
        btn7.setBounds(510,15,200,30);
        btn7.setBackground(new Color(246,215,118));
        panel1.add(btn7);
        btn7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                new Central_Store();
            }
        });

        JButton btn8=new JButton(" Billing ");
        btn8.setBounds(510,58,200,30);
        btn8.setBackground(new Color(246,215,118));
        panel1.add(btn8);
        btn8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                    new Billing();
            }
        });

        JButton btn9=new JButton(" Logout ");
        btn9.setBounds(510,100,200,30);
        btn9.setBackground(new Color(246,215,118));
        panel1.add(btn9);
        btn9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                new Logout();
            }
        });



        setSize(1950,1090);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);


        setVisible(true);
    }




    public static void main(String args[])
    {
        new Reception();
    }

}
