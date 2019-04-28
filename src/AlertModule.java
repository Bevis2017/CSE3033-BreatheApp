import org.apache.commons.lang3.time.DateUtils;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

public class AlertModule {
    private Event event = new Event();
    // default alert msg header
    private String msgTime = "You have an event now";

    public AlertModule(int uid) {
        // creating an instance of timer class
        Timer timer = new Timer();

        // get data from db
        ResultSet rsTodayEvents = event.getAllTodayActiveEventByUserId(uid);

        try {
            while (rsTodayEvents.next()) {
                // get event date and set timer
                String eventDate = rsTodayEvents.getString("date");
                //DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
                Date date = format.parse(eventDate);
                System.out.println("Event Date: " + date);

                // assign all event details to variable
                int eventId = rsTodayEvents.getInt("id");
                int alertType = rsTodayEvents.getInt("alert");

                Event tempEvent = new Event(eventId);

                System.out.println("Event Name: " + tempEvent.getName());

                // set alert time
                switch (alertType) {
                    case 1:
                        // At time of event
                        break;
                    case 2:
                        // 30 minutes before
                        date = DateUtils.addMinutes(date, -30);
                        msgTime = "You have an event after 30 minutes";
                        break;
                    case 3:
                        // 1 hour before
                        date = DateUtils.addHours(date, -1);
                        msgTime = "You have an event after 1 hour";
                        break;
                    case 4:
                        // 1 day before
                        date = DateUtils.addDays(date, -1);
                        msgTime = "You have an event on tomorrow";
                        break;
                    case 5:
                        // 1 week before
                        date = DateUtils.addWeeks(date, -1);
                        msgTime = "You have an event after 1 week";
                        break;
                    case 0:
                    default:
                        // None (At time of event)
                        break;
                }

                System.out.println("Event Alert Time: " + date); // debug

                // set schedule
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        // show alert msg
                        String msg = "%s, details as below: \n\nEvent Name: %s \nTime: %s \nLocation: %s \nNotes: %s";
                        String fullMsg = String.format(msg, msgTime, event.getName(), event.getTime(), event.getLocation(), event.getNotes());
                        JOptionPane.showMessageDialog(new Frame(), fullMsg, "You have an event!", JOptionPane.INFORMATION_MESSAGE);
                    }
                }, date);
            }
        } catch (SQLException | ParseException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        //obj = new AlertModule();
        new AlertModule(17);

    }
} 