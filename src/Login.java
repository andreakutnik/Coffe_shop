import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Login implements ActionListener {
    JLabel usernameLbl, passwordLbl;
    JTextField usernameTxt;
    JPasswordField passwordTxt;
    JButton loginBtn, signupBtn;

    Color primaryColor;

    Font textTheme;

    private final JFrame loginFrame;

    ImagePanel appIcon;

    Login() {
        loginFrame = new JFrame("Login");
        loginFrame.setVisible(true);
        loginFrame.setLayout(null);
        loginFrame.setSize(800, 600);
        loginFrame.setLocationRelativeTo(null);
        loginFrame.getContentPane().setBackground(Color.WHITE);
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        primaryColor = new Color(207, 48, 30);
        textTheme = new Font("Verdana", Font.PLAIN, 16);

        appIcon = new ImagePanel("Images/cup.png");
        appIcon.setBounds(500, 150, 256, 256);

        usernameLbl = new JLabel("Username");
        usernameTxt = new JTextField();
        passwordLbl = new JLabel("Password");
        passwordTxt = new JPasswordField();
        loginBtn = new JButton("Login");
        signupBtn = new JButton("Don't have an Account yet? SignUp");

        usernameLbl.setBounds(60, 140, 100, 30);
        usernameLbl.setForeground(primaryColor);
        usernameLbl.setFont(textTheme);

        usernameTxt.setBounds(60, 180, 300, 30);
        usernameTxt.setForeground(Color.GRAY);
        usernameTxt.setFont(textTheme);
        usernameTxt.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));

        passwordLbl.setBounds(60, 220, 100, 30);
        passwordLbl.setForeground(primaryColor);
        passwordLbl.setFont(textTheme);

        passwordTxt.setBounds(60, 260, 300, 30);
        passwordTxt.setForeground(Color.GRAY);
        passwordTxt.setFont(textTheme);
        passwordTxt.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));

        loginBtn.setBounds(60, 320, 300, 40);
        loginBtn.setBackground(primaryColor);
        loginBtn.setForeground(Color.WHITE);
        loginBtn.setFont(textTheme);
        loginBtn.setOpaque(true);
        loginBtn.setBorderPainted(false);
        loginBtn.addActionListener(this);


        signupBtn.setBounds(40, 380, 340, 40);
        signupBtn.setBackground(Color.white);
        signupBtn.setForeground(primaryColor);
        signupBtn.setFont(textTheme);
        signupBtn.setOpaque(true);
        signupBtn.setBorderPainted(false);
        signupBtn.addActionListener(this);


        loginFrame.add(appIcon);
        loginFrame.add(usernameLbl);
        loginFrame.add(usernameTxt);
        loginFrame.add(passwordLbl);
        loginFrame.add(passwordTxt);
        loginFrame.add(loginBtn);
        loginFrame.add(signupBtn);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == loginBtn) {

            String username = usernameTxt.getText();
            String password = String.valueOf(passwordTxt.getPassword());
            if (username.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter all fields", "Try Again", JOptionPane.ERROR_MESSAGE);
                return;
            }

            try {
                Class.forName(Constants.jdbcClass);
                Connection con = DriverManager.getConnection(Constants.connectionAddress, Constants.databaseUser, Constants.databasePassword);
                Statement stmt = con.createStatement();

                String sql = "select * from users where username='" + username + "' and password='" + password
                        + "'";
                ResultSet rs = stmt.executeQuery(sql);
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "Successful", "Login", JOptionPane.INFORMATION_MESSAGE);
                    loginFrame.dispose();
                    new Home();
                } else {
                    JOptionPane.showMessageDialog(null, "Account does not exist", "Login", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == signupBtn) {
            loginFrame.dispose();
            new SignUp();
        }
    }
}