package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Logout extends JFrame implements ActionListener {

    JButton confirmButton, cancelButton;

    Logout() {
        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 400, 200);
        panel.setBackground(new Color(200, 220, 240));
        panel.setLayout(null);
        add(panel);

        JLabel title = new JLabel("Confirm Logout");
        title.setFont(new Font("Tahoma", Font.BOLD, 20));
        title.setBounds(120, 30, 200, 30);
        title.setForeground(Color.BLACK);
        panel.add(title);

        JLabel message = new JLabel("Are you sure you want to logout?");
        message.setFont(new Font("Tahoma", Font.PLAIN, 14));
        message.setBounds(80, 70, 300, 30);
        panel.add(message);

        confirmButton = new JButton("Logout");
        confirmButton.setBounds(80, 120, 100, 30);
        confirmButton.setBackground(Color.RED);
        confirmButton.setForeground(Color.WHITE);
        confirmButton.addActionListener(this);
        panel.add(confirmButton);

        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(220, 120, 100, 30);
        cancelButton.setBackground(Color.GREEN);
        cancelButton.setForeground(Color.WHITE);
        cancelButton.addActionListener(this);
        panel.add(cancelButton);

        setUndecorated(true);
        setSize(410, 210);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == confirmButton) {
            JOptionPane.showMessageDialog(this, "Logged out successfully.");
            System.exit(0); // Close the application
        } else if (e.getSource() == cancelButton) {
            setVisible(false); // Close the logout window
        }
    }

    public static void main(String[] args) {
        new Logout();
    }
}
