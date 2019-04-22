import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;

public class Event {
    private String name, type, location, time, date, notes, inviteeHash;
    private int id;
    private int repeatEvent;
    private int alert;
    private ArrayList<String> inviteeList = new ArrayList<>();
    private Exception EventNameEmptyException;
    private Exception EventTimeEmptyException;
    private Exception EventDateEmptyException;
    private Database db;
    private Token token = new Token();

    public Event() {
        db = new Database();
        token.readToken();
    }

    public Event(int id) {
        token.readToken();

        db = new Database();
        ResultSet rs = db.query("SELECT * FROM event WHERE id = " + id);
        try {
            rs.next();
            this.id = id;
            setName(rs.getString("name"));
            setLocation(rs.getString("location"));
            setType(rs.getString("type"));
            setDate(rs.getString("date"));
            setTime(rs.getString("date"));
            repeatEvent = rs.getInt("repeatEvent");
            alert = rs.getInt("alert");
            notes = rs.getString("notes");
            inviteeHash = rs.getString("inviteeHash");
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
                return "Never";
        }
    }

    public void setRepeatEvent(String str) {
        switch (str.trim()) {
            case "Every Day":
                repeatEvent = 1;
                break;
            case "Every Week":
                repeatEvent = 2;
                break;
            case "Every 2 Weeks":
                repeatEvent = 3;
                break;
            case "Every Month":
                repeatEvent = 4;
                break;
            case "Every Year":
                repeatEvent = 5;
                break;
            case "Never":
            default:
                repeatEvent = 0;
                break;
        }
        System.out.println(String.format("[Event][setRepeatEvent] Option: %s | ID: %d", str, alert));
    }

    public String getAlert() {
        switch (alert) {
            case 1:
                return "At time of event";
            case 2:
                return "30 minutes before";
            case 3:
                return "1 hour before";
            case 4:
                return "1 day before";
            case 5:
                return "1 week before";
            case 0:
            default:
                return "None";
        }
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
                break;
            case "1 week before":
                alert = 5;
                break;
            case "None":
            default:
                alert = 0;
                break;
        }
    }

    private String joinDateTime() {
        return date + " " + time;
    }

    public void setInviteeHash(String str) {
        System.out.println("[Event][setInviteeHash] string: " + str);
        inviteeHash = stringToBase64(str.trim());
        System.out.println("[Event][setInviteeHash] hash: " + inviteeHash);
    }

    public String getInviteeHash() {
        return base64ToString(inviteeHash);
    }

    public void setInviteeList(ArrayList<String> al) {
        inviteeList = al;
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
            String query = "INSERT INTO event (name, type, location, date, repeatEvent, alert, notes, inviteeHash, createdBy) VALUES ('%s', '%s', '%s', '%s', '%d', '%d', '%s', '%s', '%d')";
            int rs = db.update(String.format(query, name, type, location, joinDateTime(), repeatEvent, alert, notes, inviteeHash, token.getUserId()));
            System.out.println("Save Event Result: " + rs);

            if (rs != 0) {
                db = new Database();
                String queryLastEventId = "SELECT * FROM event ORDER BY id DESC";
                ResultSet lastEventId = db.query(queryLastEventId);
                try {
                    if (lastEventId.next()) {
                        newEventId = lastEventId.getInt("id");
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                System.out.println("Last Event ID : " + newEventId);
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
        if (name.trim().length() == 0) {
            throw EventNameEmptyException;
        } else if (time.trim().length() == 0) {
            throw EventTimeEmptyException;
        } else if (date.trim().length() == 0) {
            throw EventDateEmptyException;
        } else {
            // get original invitee hash before update
            String originalInviteeHash = getOriginalInviteeHash();

            // update data in event table
            String query = "UPDATE event SET name = '%s', type = '%s', location = '%s', date = '%s', repeatEvent = '%d', alert = '%d', notes = '%s', inviteeHash = '%s' WHERE id = '%d'";
            int rs = db.update(String.format(query, name, type, location, joinDateTime(), repeatEvent, alert, notes, inviteeHash, id));
            System.out.println("Save Event Result: " + rs);

            if (rs != 0) {
                // check inviteeHash
                System.out.println("Latest Invitee Hash: " + inviteeHash);
                if (!inviteeHash.equals(originalInviteeHash)) {
                    System.out.println("[Event] Invitee List Changed");

                    // delete all invitee of this event from db
                    int rsDelete = deleteInviteeByEventId(id);
                    if (rsDelete != 0) {
                        System.out.println("Current Invitee Deleted.");
                    } else {
                        System.out.println("New Invitee Added.");
                    }

                    // add new invitee
                    for (String str : inviteeList) {
                        // clean whitespace
                        str = str.trim();
                        User user = new User();
                        int userId = user.getIdByName(str);

                        // check invitee user id
                        if (userId != 0) {
                            saveInvitee(id, userId);
                            System.out.println(String.format("Event ID: %d | User ID: %d | User Name: '%s'", id, userId, str));
                        } else {
                            userId = user.getIdByEmail(str);
                            saveInvitee(id, userId);
                            System.out.println(String.format("Event ID: %d | User ID: %d | User Name: '%s'", id, userId, str));
                        }
                    }
                } else {
                    System.out.println("[Event] Invitee List Not Changed");
                }

            }
        }

        return id;
    }

    public ResultSet getAllEventByUserId(int uid) {
        String query = "SELECT * FROM event WHERE createdBy = '%d' OR id IN (SELECT event_id from invitee where user_id = '%d') ORDER BY date ASC";

        return db.query(String.format(query, uid, uid));
    }

    public String getOriginalInviteeHash() {
        String queryGetInviteeHash = "SELECT * FROM event WHERE id = '%d'";
        ResultSet rsInviteeHash = db.query(String.format(queryGetInviteeHash, id));
        String hash = null;

        try {
            if (rsInviteeHash.next()) {
                hash = rsInviteeHash.getString("inviteeHash");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("Original Invitee Hash: " + hash);

        return hash;
    }

    public int deleteInviteeByEventId(int eid) {
        String query = "DELETE FROM invitee WHERE event_id ='%d'";
        int rs = db.update(String.format(query, eid));

        return rs;
    }

    public void saveInvitee(int event_id, int user_id) {
        String query = "INSERT INTO invitee (event_id, user_id) VALUES ('%d', '%d')";
        int rs = db.update(String.format(query, event_id, user_id));
        System.out.println("Save Invitee Result: " + rs);
    }

    public String stringToBase64(String str) {
        //System.out.println("Input String: " + str);

        // Encode into Base64 format
        String base64 = Base64.getEncoder().encodeToString(str.getBytes());

        // print encoded String
        //System.out.println("Encoded String: " + base64);

        return base64;
    }

    public String base64ToString(String base64) {
        // print encoded String
        //System.out.println("Encoded String: " + base64);

        // decode into String from encoded format
        byte[] actualByte = Base64.getDecoder().decode(base64);

        String actualString = new String(actualByte);

        // print actual String
        //System.out.println("Actual String: " + actualString);

        return actualString;
    }
}
