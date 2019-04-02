public class Event {
    private String name, type, location, time, date, notes;
    private int id;
    private int repeatEvent;
    private int alert;
    private Exception EventNameEmptyException;
    private Exception EventTimeEmptyException;
    private Exception EventDateEmptyException;
    private Database db;

    public Event() {
        db = new Database();
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
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
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

    public boolean saveEvent() throws Exception {
        boolean status = false;

        if (name.trim().length() == 0) {
            throw EventNameEmptyException;
        } else if (time.trim().length() == 0) {
            throw EventTimeEmptyException;
        } else if (date.trim().length() == 0) {
            throw EventDateEmptyException;
        } else {
            String query = "INSERT INTO event (name, type, location, time, date, repeatEvent, alert, notes) VALUES ('%s', '%s', '%s', '%s', '%s', '%d', '%d', '%s')";
            int rs = db.update(String.format(query, name, type, location, time, date, repeatEvent, alert, notes));
            System.out.println("Result: " + rs);

            if (rs != 0) {
                status = true;
            }
        }

        return status;
    }
}
