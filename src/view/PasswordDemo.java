package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PasswordDemo extends JFrame {
    public PasswordDemo() {
        super("Password Demo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 2));

        JLabel userLabel = new JLabel("Username:");
        JTextField userField = new JTextField(10);
        panel.add(userLabel);
        panel.add(userField);

        JLabel passLabel = new JLabel("Password:");
        JPasswordField passField = new JPasswordField(10);
        panel.add(passLabel);
        panel.add(passField);

        JButton showPass = new JButton("Show Password");
        showPass.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (showPass.getText().equals("Show Password")) {
                    passField.setEchoChar((char) 0);
                    showPass.setText("Hide Password");
                } else {
                    passField.setEchoChar('\u25CF');
                    showPass.setText("Show Password");
                }
            }
        });

        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = userField.getText();
                String password = new String(passField.getPassword());
                JOptionPane.showMessageDialog(PasswordDemo.this, "Username: " + username + "\nPassword: " + password);
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(showPass);
        buttonPanel.add(loginButton);

        Container contentPane = getContentPane();
        contentPane.add(panel, BorderLayout.CENTER);
        contentPane.add(buttonPanel, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        PasswordDemo pd = new PasswordDemo();
        pd.setVisible(true);
    }
}

