import com.mysql.cj.exceptions.CJCommunicationsException;

import javax.jws.soap.SOAPBinding;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class User {
    private String userId, userEmail, userName, userPwd;
    private static Database db;

    public User() {
        // constructor
        db = new Database();
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

    public static void main(String[] args) {
        User u = new User();
        if (u.createAccount("admin2", "me@google.com", "abc123")) {
            System.out.println("OK");
        } else {
            System.out.println("ERROR");
        }
    }
}
