import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;

public class Event {
    private String name, type, location, time, date, notes;
    private int id;
    private int repeatEvent;
    private int alert;
    private ArrayList<String> inviteeList = new ArrayList<>();
    private Exception EventNameEmptyException;
    private Exception EventTimeEmptyException;
    private Exception EventDateEmptyException;
    private Database db;

    public Event() {
        db = new Database();
    }

    public Event(int id) {
        db = new Database();
        ResultSet rs = db.query("SELECT * FROM event WHERE id = " + id);
        try {
            rs.next();
            setName(rs.getString("name"));
            setLocation(rs.getString("location"));
            setType(rs.getString("type"));
            setDate(rs.getString("date"));
            setTime(rs.getString("date"));
            setRepeatEvent(rs.getString("repeatEvent"));
            setAlert(rs.getString("alert"));
            setNotes(rs.getString("notes"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNotes() {
        return base64ToString(notes);
    }

    public void setNotes(String notes) {
        this.notes = stringToBase64(notes.trim());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRepeatEvent() {
        switch (repeatEvent) {
            case 1:
                return "Every Day";
            case 2:
                return "Every Week";
            case 3:
                return "Every 2 Weeks";
            case 4:
                return "Every Month";
            case 5:
                return "Every Year";
            case 0:
            default:
                return "None";
        }
    }

    public void setRepeatEvent(String str) {
        switch (str.trim()) {
            case "Every Day":
                alert = 1;
                break;
            case "Every Week":
                alert = 2;
                break;
            case "Every 2 Weeks":
                alert = 3;
                break;
            case "Every Month":
                alert = 4;
            case "Every Year":
                alert = 5;
                break;
            case "None":
            default:
                alert = 0;
        }
    }

    public String getAlert() {
        String strAlert = "None";
        switch (alert) {
            case 0:
                strAlert = "None";
                break;
            case 1:
                strAlert = "At time of event";
                break;
            case 2:
                strAlert = "30 minutes before";
                break;
            case 3:
                strAlert = "1 hour before";
                break;
            case 4:
                strAlert = "1 day before";
                break;
            case 5:
                strAlert = "1 week before";
                break;
        }
        return strAlert;
    }

    public void setAlert(String str) {
        switch (str.trim()) {
            case "At time of event":
                alert = 1;
                break;
            case "30 minutes before":
                alert = 2;
                break;
            case "1 hour before":
                alert = 3;
                break;
            case "1 day before":
                alert = 4;
            case "1 week before":
                alert = 5;
                break;
            case "None":
            default:
                alert = 0;
        }
    }

    private String joinDateTime() {
        return date + " " + time;
    }

    public int saveEvent() throws Exception {
        int newEventId = 0;

        if (name.trim().length() == 0) {
            throw EventNameEmptyException;
        } else if (time.trim().length() == 0) {
            throw EventTimeEmptyException;
        } else if (date.trim().length() == 0) {
            throw EventDateEmptyException;
        } else {
            String query = "INSERT INTO event (name, type, location, date, repeatEvent, alert, notes) VALUES ('%s', '%s', '%s', '%s', '%d', '%d', '%s')";
            int rs = db.update(String.format(query, name, type, location, joinDateTime(), repeatEvent, alert, notes));
            System.out.println("Save Event Result: " + rs);

            if (rs != 0) {
                Database db = new Database();
                ResultSet lastInsert = db.getLastInsertId();
                lastInsert.next();

                newEventId = lastInsert.getInt("id");
                System.out.println("getLastInsertId : " + lastInsert);
                User user = new User();

                for (String str : inviteeList) {
                    int userId = user.getIdByName(str);
                    if (userId != 0) {
                        saveInvitee(newEventId, userId);
                        System.out.println(String.format("Event ID: %d | User ID: %d", newEventId, userId));
                    } else {
                        userId = user.getIdByEmail(str);
                        saveInvitee(newEventId, userId);
                        System.out.println(String.format("Event ID: %d | User ID: %d", newEventId, userId));
                    }
                }
            }
        }

        return newEventId;
    }

    public int updateEvent() throws Exception {
        int newEventId = 0;

        if (name.trim().length() == 0) {
            throw EventNameEmptyException;
        } else if (time.trim().length() == 0) {
            throw EventTimeEmptyException;
        } else if (date.trim().length() == 0) {
            throw EventDateEmptyException;
        } else {
            String query = "UPDATE event SET name = '%s', type = '%s', location = '%s', date = '%s', repeatEvent = '%d', alert = '%d', notes = '%s' WHERE even_id = '%d'";
            int rs = db.update(String.format(query, name, type, location, joinDateTime(), repeatEvent, alert, notes, id));
            System.out.println("Save Event Result: " + rs);

            if (rs != 0) {
                Database db = new Database();
                ResultSet lastInsert = db.getLastInsertId();
                lastInsert.next();

                newEventId = lastInsert.getInt("id");
                System.out.println("getLastInsertId : " + lastInsert);
                User user = new User();

                for (String str : inviteeList) {
                    int userId = user.getIdByName(str);
                    if (userId != 0) {
                        saveInvitee(newEventId, userId);
                        System.out.println(String.format("Event ID: %d | User ID: %d", newEventId, userId));
                    } else {
                        userId = user.getIdByEmail(str);
                        saveInvitee(newEventId, userId);
                        System.out.println(String.format("Event ID: %d | User ID: %d", newEventId, userId));
                    }
                }
            }
        }

        return newEventId;
    }

    public void saveInvitee(int event_id, int user_id) {
        String query = "INSERT INTO invitee (event_id, user_id) VALUES ('%d', '%d')";
        ResultSet rs = db.query(String.format(query, event_id, user_id));
        System.out.println("Save Invitee Result: " + rs);
    }

    public String stringToBase64(String str) {
        System.out.println("Input String: " + str);

        // Encode into Base64 format
        String base64 = Base64.getEncoder().encodeToString(str.getBytes());

        // print encoded String
        System.out.println("Encoded String: " + base64);

        return base64;
    }

    public String base64ToString(String base64) {
        // print encoded String
        System.out.println("Encoded String: " + base64);

        // decode into String from encoded format
        byte[] actualByte = Base64.getDecoder().decode(base64);

        String actualString = new String(actualByte);

        // print actual String
        System.out.println("Actual String: " + actualString);

        return actualString;
    }
}
