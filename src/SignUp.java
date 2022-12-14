import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class SignUp implements ActionListener {
    JLabel usernameLbl, passwordLbl, firstnameLbl, lastnameLbl;
    JTextField usernameTxt, firstnameTxt, lastnameTxt;
    JPasswordField passwordTxt;
    JButton loginBtn, signupBtn;

    Color primaryColor;

    Font textTheme;

    private final JFrame signupFrame;

    ImagePanel appIcon;

    SignUp() {
        signupFrame = new JFrame("SignUp");
        signupFrame.setVisible(true);
        signupFrame.setLayout(null);
        signupFrame.setSize(800, 600);
        signupFrame.setLocationRelativeTo(null);
        signupFrame.getContentPane().setBackground(Color.WHITE);
        signupFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        primaryColor = new Color(207, 48, 30);
        textTheme = new Font("Verdana", Font.PLAIN, 16);

        appIcon = new ImagePanel("Images/cup.png");
        appIcon.setBounds(500, 150, 256, 256);

        firstnameLbl = new JLabel("Firstname");
        firstnameTxt = new JTextField();
        lastnameLbl = new JLabel("Lastname");
        lastnameTxt = new JTextField();
        usernameLbl = new JLabel("Username");
        usernameTxt = new JTextField();
        passwordLbl = new JLabel("Password");
        passwordTxt = new JPasswordField();
        signupBtn = new JButton("SignUp");
        loginBtn = new JButton("Already have an Account? Login");

        firstnameLbl.setBounds(60, 80, 100, 30);
        firstnameLbl.setForeground(primaryColor);
        firstnameLbl.setFont(textTheme);

        firstnameTxt.setBounds(60, 120, 300, 30);
        firstnameTxt.setForeground(Color.GRAY);
        firstnameTxt.setFont(textTheme);
        firstnameTxt.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));

        lastnameLbl.setBounds(60, 160, 100, 30);
        lastnameLbl.setForeground(primaryColor);
        lastnameLbl.setFont(textTheme);

        lastnameTxt.setBounds(60, 200, 300, 30);
        lastnameTxt.setForeground(Color.GRAY);
        lastnameTxt.setFont(textTheme);
        lastnameTxt.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));

        usernameLbl.setBounds(60, 240, 100, 30);
        usernameLbl.setForeground(primaryColor);
        usernameLbl.setFont(textTheme);

        usernameTxt.setBounds(60, 280, 300, 30);
        usernameTxt.setForeground(Color.GRAY);
        usernameTxt.setFont(textTheme);
        usernameTxt.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));

        passwordLbl.setBounds(60, 320, 100, 30);
        passwordLbl.setForeground(primaryColor);
        passwordLbl.setFont(textTheme);

        passwordTxt.setBounds(60, 360, 300, 30);
        passwordTxt.setForeground(Color.GRAY);
        passwordTxt.setFont(textTheme);
        passwordTxt.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));

        signupBtn.setBounds(60, 420, 300, 40);
        signupBtn.setBackground(primaryColor);
        signupBtn.setForeground(Color.white);
        signupBtn.setFont(textTheme);
        signupBtn.setOpaque(true);
        signupBtn.setBorderPainted(false);
        signupBtn.addActionListener(this);

        loginBtn.setBounds(40, 480, 340, 40);
        loginBtn.setBackground(Color.white);
        loginBtn.setForeground(primaryColor);
        loginBtn.setFont(textTheme);
        loginBtn.setOpaque(true);
        loginBtn.setBorderPainted(false);
        loginBtn.addActionListener(this);


        signupFrame.add(appIcon);
        signupFrame.add(firstnameLbl);
        signupFrame.add(firstnameTxt);
        signupFrame.add(lastnameLbl);
        signupFrame.add(lastnameTxt);
        signupFrame.add(usernameLbl);
        signupFrame.add(usernameTxt);
        signupFrame.add(passwordLbl);
        signupFrame.add(passwordTxt);
        signupFrame.add(loginBtn);
        signupFrame.add(signupBtn);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == signupBtn) {

            String username = usernameTxt.getText();
            String password = String.valueOf(passwordTxt.getPassword());
            String firstname = firstnameTxt.getText();
            String lastname = lastnameTxt.getText();

            if (username.isEmpty() || password.isEmpty() || firstname.isEmpty() || lastname.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter all fields", "Try Again", JOptionPane.ERROR_MESSAGE);
                return;
            }

            try {
                Class.forName(Constants.jdbcClass);
                Connection con = DriverManager.getConnection(Constants.connectionAddress, Constants.databaseUser, Constants.databasePassword);

                String signUpQuery = "INSERT INTO users (username, password, firstname, lastname, type) VALUES (?, ?, ?, ?, ?)";

                PreparedStatement signUpStatement = con.prepareStatement(signUpQuery);
                signUpStatement.setString(1, username);
                signUpStatement.setString(2, password);
                signUpStatement.setString(3, firstname);
                signUpStatement.setString(4, lastname);
                signUpStatement.setString(5, "waiter");

                signUpStatement.execute();

                JOptionPane.showMessageDialog(null, "Successful", "Sign Up", JOptionPane.INFORMATION_MESSAGE);
                signupFrame.dispose();
            } catch (SQLException e) {
                if (e instanceof SQLIntegrityConstraintViolationException) {
                    JOptionPane.showMessageDialog(null, "Username already exists!", "Sign Up", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Failed", "Sign Up", JOptionPane.ERROR_MESSAGE);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            signupFrame.dispose();
            new Login();
        }
    }
}