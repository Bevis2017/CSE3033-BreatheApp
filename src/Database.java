import java.sql.*;

public class Database {

    private String dbDriver = "com.mysql.cj.jdbc.Driver";
    private String dbHost = "128.199.86.173:3306";
    private String dbName = "kdupg";
    private String dbUser = "CSE3033";
    private String dbPass = "CSE3033";

    private Connection connection = null;

    public Database() {
        connect();
    }

    protected void connect() {
        try {
            String url = "jdbc:mysql://" + dbHost + "/" + dbName;
            Class.forName(dbDriver);
            connection = DriverManager.getConnection(url, dbUser, dbPass);
            System.out.println("Database connection established");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void disconnect() {
        if (connection != null) {
            try {
                connection.close();
                connection = null;
                System.out.println("Database connection terminated");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    protected void reconnect() {
        disconnect();
        connect();
    }

    protected Connection getConnection() {
        return connection;
    }

    protected ResultSet query(String q) {
        ResultSet rs = null;

        try {
            Statement stmt = connection.createStatement();
            rs = stmt.executeQuery(q);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rs;
    }

    protected int update(String q) {
        System.out.println("update SQL: " + q);
        int result = 0;

        try {
            Statement stmt = connection.createStatement();
            result = stmt.executeUpdate(q);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    // debug
    public static void main(String[] args) {
        Database db = new Database();

        ResultSet rs = db.query("SELECT * FROM user");

        try {
            if (rs.next()) {
                System.out.println(rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        db.disconnect();
    }
}
