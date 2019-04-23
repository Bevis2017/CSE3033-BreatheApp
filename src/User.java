import com.sendgrid.*;
import org.apache.commons.lang3.RandomStringUtils;

import java.io.IOException;
import java.security.SecureRandom;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User {
    private int userId;
    private String userEmail, userName, userPwd;
    private static Database db;

    public User() {
        // constructor
        db = new Database();
    }

    public User(int uid) {
        // constructor
        db = new Database();

        ResultSet rs = db.query(String.format("SELECT * FROM user WHERE id = '%d'", uid));

        try {
            rs.next();
            userId = rs.getInt("id");
            userEmail = rs.getString("email");
            userName = rs.getString("name");
            userPwd = rs.getString("password");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getUserId() {
        return userId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public boolean isUserNameAvailable(String un) {
        ResultSet rs = db.query(String.format("Select * FROM user WHERE name = '%s'", un));

        boolean status = true;

        try {
            if (rs.next()) {
                status = false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Reconnecting ...");
            db.reconnect();
        }

        return status;
    }

    public boolean isUserEmailAvailable(String email) {
        ResultSet rs = db.query(String.format("Select * FROM user WHERE email = '%s'", email));

        boolean status = true;

        try {
            if (rs.next()) {
                status = false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Reconnecting ...");
            db.reconnect();
        }

        return status;
    }

    public ResultSet searchUserByName(String keywords) {
        String query = "SELECT * FROM user WHERE name LIKE '%%%s%%'";
        String completeQuery = String.format(query, keywords);
        System.out.println("[User] [searchUserByName] query: " + completeQuery);
        ResultSet rs = db.query(completeQuery);

        return  rs;
    }

    public int getIdByName(String name) {
        ResultSet rs = db.query(String.format("SELECT * FROM user WHERE name = '%s'", name.trim()));
        int id = 0;

        try {
            if (rs.next()) {
                id = rs.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return id;
    }

    public int getIdByEmail(String email) {
        ResultSet rs = db.query(String.format("SELECT * FROM user WHERE email = '%s'", email));
        int id = 0;

        try {
            if (rs.next()) {
                id = rs.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return id;
    }

    public boolean createAccount(String username, String email, String password) {
        boolean status = false;

        if (isUserNameAvailable(username) && isUserEmailAvailable(email)) {
            String query = "INSERT INTO user (name, email, password) VALUES ('%s', '%s', '%s')";
            int rs = db.update(String.format(query, username, email, password));
            System.out.println("Result: " + rs);

            if (rs != 0) {
                status = true;
            }
        }

        return status;
    }

    public int login(String email, String pass) {
        String query = "Select * FROM user WHERE email = '%s' AND password = '%s'";
        ResultSet rs = db.query(String.format(query, email, pass));

        System.out.println("EMAIL: " + email);
        System.out.println("PWD: " + pass);

        int userId = -1;

        try {
            if (rs.next()) {
                System.out.println("USER ID: " + rs.getString("id"));
                userId = rs.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userId;
    }

    public boolean resetPassword(String email) {
        String query = "UPDATE user SET password = '%s' WHERE email = '%s'";
        String newPass = generatePassword();
        int rs = db.update(String.format(query, newPass, email));
        boolean status = false;

        if (rs > 0) {
            sendEmail(email, newPass);
            status = true;
        }

        return status;
    }

    private String generatePassword() {
        int randomStrLength = 10;
        char[] possibleCharacters = ("ABCDEFGHIJKLMNPQRSTUVWXYZabcdefghijkmnpqrstuvwxyz23456789").toCharArray();
        String randomStr = RandomStringUtils.random(randomStrLength, 0, possibleCharacters.length - 1, false, false, possibleCharacters, new SecureRandom());
        System.out.println("Generated Password: " + randomStr);
        return randomStr;
    }

    public boolean sendEmail(String email, String pass) {
        boolean status = false;
        String SENDGRID_API_KEY = "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";
        SendGrid sg = new SendGrid(SENDGRID_API_KEY);
        Request request = new Request();

        Email from = new Email("CSE3033@assignment.kdupg.edu.my", "BreatheApp");
        Email to = new Email(email);
        String subject = "New Password For Your BreatheApp Account";
        String msg = String.format("Your new password is: %s", pass);
        Content content = new Content("text/plain", msg);
        Mail mail = new Mail(from, subject, to, content);

        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sg.api(request);

            if (response.getStatusCode() == 202) {
                status = true;
                System.out.println("Email sent!");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("Fail to send email!");
        }
        return status;
    }

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public static boolean validateEmail(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
    }

    public static void main(String[] args) {
        User u = new User();
        if (u.createAccount("admin2", "me@google.com", "abc123")) {
            System.out.println("OK");
        } else {
            System.out.println("ERROR");
        }
        u.generatePassword();
        u.sendEmail("Bevis.Goh@my.com", u.generatePassword());
    }
}
