import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Objects;

public class LoginApp extends JFrame {
    private JTextField emailField;
    private JPasswordField passwordField;
    private static final String DB_URL = "jdbc:sqlserver://localhost:1433;databaseName=master;encrypt=false";
    private static final String DB_USER = "temp";
    private static final String DB_PASSWORD = "test123";

    public LoginApp() {
        setTitle("Login Screen");
        setSize(350, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2, 10, 10));

        // Email Label and Text Field
        panel.add(new JLabel("Email:"));
        emailField = new JTextField();
        panel.add(emailField);

        // Password Label and Password Field
        panel.add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        panel.add(passwordField);

        // Login Button
        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(new LoginAction());
        panel.add(loginButton);

        add(panel);
    }

    private class LoginAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String email = emailField.getText();
            String password = new String(passwordField.getPassword()); // Password is ignored for validation

            String userName = authenticateUser(email);
            if (userName != null) {
                JOptionPane.showMessageDialog(null, "Welcome, " + userName + "!", "Login Successful", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "User not found.", "Login Failed", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private static String authenticateUser(String email) {
        String userName = null;
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String query = "SELECT names FROM Users WHERE Email = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                userName = rs.getString("Names");
            }
            rs.close();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userName;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LoginApp loginApp = new LoginApp();
            loginApp.setVisible(true);
        });
    }

    private static String FixedAuthenticateUser(String email,String password) {
        String userName = null;
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String query = "SELECT Names,Passwords FROM Users WHERE Email = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String dbpassword = rs.getString("Passwords");
                if(Objects.equals(password, dbpassword))
                    userName=rs.getString("Names");
            }
            rs.close();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userName;
    }
    public static Boolean isvalidLogin(String email,String password)
    {
        return !Objects.equals(FixedAuthenticateUser(email,password), null);
    }
}