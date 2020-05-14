import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by Tanner on 10/4/2016.
 */

class WorldClock extends JPanel{

    static int timeLabelSize = 14;
    static int DDLabelSize = 12;

    WorldClock() {
        setPreferredSize(new Dimension(800,125));
        setLayout(new GridLayout(4,0));
        setBackground(Color.black);
        JLabel AZ = new JLabel("AZ:");
        AZClockLabel clockTime = new AZClockLabel("time");
        AZClockLabel clockDay = new AZClockLabel("day");
        AZClockLabel clockDate = new AZClockLabel("date");
        add(AZ);
        add(clockTime);
        add(clockDay);
        add(clockDate);
        JLabel WC = new JLabel("West Coast:");
        WestCoastClockLabel clockTime2 = new WestCoastClockLabel("time");
        WestCoastClockLabel clockDay2 = new WestCoastClockLabel("day");
        WestCoastClockLabel clockDate2 = new WestCoastClockLabel("date");
        add(WC);
        add(clockTime2);
        add(clockDay2);
        add(clockDate2);
        JLabel MT = new JLabel("Mountain:");
        MountainClockLabel clockTime3 = new MountainClockLabel("time");
        MountainClockLabel clockDay3 = new MountainClockLabel("day");
        MountainClockLabel clockDate3 = new MountainClockLabel("date");
        add(MT);
        add(clockTime3);
        add(clockDay3);
        add(clockDate3);
        JLabel CT = new JLabel("Central:");
        CentralClockLabel clockTime4 = new CentralClockLabel("time");
        CentralClockLabel clockDay4 = new CentralClockLabel("day");
        CentralClockLabel clockDate4 = new CentralClockLabel("date");
        add(CT);
        add(clockTime4);
        add(clockDay4);
        add(clockDate4);
        JLabel EC = new JLabel("East:");
        EastCoastClockLabel clockTime5 = new EastCoastClockLabel("time");
        EastCoastClockLabel clockDay5 = new EastCoastClockLabel("day");
        EastCoastClockLabel clockDate5 = new EastCoastClockLabel("date");
        add(EC);
        add(clockTime5);
        add(clockDay5);
        add(clockDate5);
        JLabel LD = new JLabel("London:");
        LondonClockLabel clockTime6 = new LondonClockLabel("time");
        LondonClockLabel clockDay6 = new LondonClockLabel("day");
        LondonClockLabel clockDate6 = new LondonClockLabel("date");
        add(LD);
        add(clockTime6);
        add(clockDay6);
        add(clockDate6);
        JLabel PR = new JLabel("Paris:");
        ParisClockLabel clockTime7 = new ParisClockLabel("time");
        ParisClockLabel clockDay7 = new ParisClockLabel("day");
        ParisClockLabel clockDate7 = new ParisClockLabel("date");
        add(PR);
        add(clockTime7);
        add(clockDay7);
        add(clockDate7);
        JLabel AUS = new JLabel("Australia:");
        AustraliaClockLabel clockTime8 = new AustraliaClockLabel("time");
        AustraliaClockLabel clockDay8 = new AustraliaClockLabel("day");
        AustraliaClockLabel clockDate8 = new AustraliaClockLabel("date");
        add(AUS);
        add(clockTime8);
        add(clockDay8);
        add(clockDate8);
        AZ.setForeground(Color.white);
        MT.setForeground(Color.white);
        CT.setForeground(Color.white);
        EC.setForeground(Color.white);
        WC.setForeground(Color.white);
        PR.setForeground(Color.white);
        LD.setForeground(Color.white);
        AUS.setForeground(Color.white);
    }
}

class AZClockLabel extends JLabel implements ActionListener {

    private String type;
    private SimpleDateFormat sdf;
    private String font = "antar";

    AZClockLabel(String type) {
        this.type = type;
        setForeground(Color.green);

        switch (type) {
            case "date":
                sdf = new SimpleDateFormat("MMMM d yyyy");
                setFont(new Font(font, Font.PLAIN, WorldClock.DDLabelSize));
                break;
            case "time":
                sdf = new SimpleDateFormat("h:mm:ss a ");
                setFont(new Font(font, Font.PLAIN, WorldClock.timeLabelSize));
                break;
            case "day":
                sdf = new SimpleDateFormat("EEEE,");
                setFont(new Font(font, Font.PLAIN, WorldClock.DDLabelSize));
                break;
            default:
                sdf = new SimpleDateFormat();
                break;
        }

        sdf.setTimeZone(TimeZone.getTimeZone("MST")); //Arizona

        Timer t = new Timer(1000, this);
        t.start();
    }

    public void actionPerformed(ActionEvent ae) {
        Date d = new Date();
        setText(sdf.format(d));
    }

}
class WestCoastClockLabel extends JLabel implements ActionListener {

    private String type;
    private SimpleDateFormat sdf;
    private String font = "antar";

    WestCoastClockLabel(String type) {
        this.type = type;
        setForeground(Color.green);

        switch (type) {
            case "date":
                sdf = new SimpleDateFormat("MMMM d yyyy");
                setFont(new Font(font, Font.PLAIN, WorldClock.DDLabelSize));
                break;
            case "time":
                sdf = new SimpleDateFormat("h:mm:ss a ");
                setFont(new Font(font, Font.PLAIN, WorldClock.timeLabelSize));
                break;
            case "day":
                sdf = new SimpleDateFormat("EEEE, ");
                setFont(new Font(font, Font.PLAIN, WorldClock.DDLabelSize));
                break;
            default:
                sdf = new SimpleDateFormat();
                break;
        }

        sdf.setTimeZone(TimeZone.getTimeZone("PST8PDT")); //West Coast

        Timer t = new Timer(1000, this);
        t.start();
    }

    public void actionPerformed(ActionEvent ae) {
        Date d = new Date();
        setText(sdf.format(d));
    }

}
class MountainClockLabel extends JLabel implements ActionListener {

    private String type;
    private SimpleDateFormat sdf;
    private String font = "antar";

    MountainClockLabel(String type) {
        this.type = type;
        setForeground(Color.green);

        switch (type) {
            case "date":
                sdf = new SimpleDateFormat("MMMM d yyyy");
                setFont(new Font(font, Font.PLAIN, WorldClock.DDLabelSize));
                break;
            case "time":
                sdf = new SimpleDateFormat("h:mm:ss a ");
                setFont(new Font(font, Font.PLAIN, WorldClock.timeLabelSize));
                break;
            case "day":
                sdf = new SimpleDateFormat("EEEE, ");
                setFont(new Font(font, Font.PLAIN, WorldClock.DDLabelSize));
                break;
            default:
                sdf = new SimpleDateFormat();
                break;
        }

        sdf.setTimeZone(TimeZone.getTimeZone("MST7MDT")); //Mountain

        Timer t = new Timer(1000, this);
        t.start();
    }

    public void actionPerformed(ActionEvent ae) {
        Date d = new Date();
        setText(sdf.format(d));
    }

}
class CentralClockLabel extends JLabel implements ActionListener {

    private String type;
    private SimpleDateFormat sdf;
    private String font = "antar";

    CentralClockLabel(String type) {
        this.type = type;
        setForeground(Color.green);

        switch (type) {
            case "date":
                sdf = new SimpleDateFormat("MMMM d yyyy");
                setFont(new Font(font, Font.PLAIN, WorldClock.DDLabelSize));
                break;
            case "time":
                sdf = new SimpleDateFormat("h:mm:ss a ");
                setFont(new Font(font, Font.PLAIN, WorldClock.timeLabelSize));
                break;
            case "day":
                sdf = new SimpleDateFormat("EEEE, ");
                setFont(new Font(font, Font.PLAIN, WorldClock.DDLabelSize));
                break;
            default:
                sdf = new SimpleDateFormat();
                break;
        }

        sdf.setTimeZone(TimeZone.getTimeZone("CST6CDT")); //Central


        Timer t = new Timer(1000, this);
        t.start();
    }

    public void actionPerformed(ActionEvent ae) {
        Date d = new Date();
        setText(sdf.format(d));
    }

}
class EastCoastClockLabel extends JLabel implements ActionListener {

    private String type;
    private SimpleDateFormat sdf;
    private String font = "antar";

    EastCoastClockLabel(String type) {
        this.type = type;
        setForeground(Color.green);

        switch (type) {
            case "date":
                sdf = new SimpleDateFormat("MMMM d yyyy");
                setFont(new Font(font, Font.PLAIN, WorldClock.DDLabelSize));
                break;
            case "time":
                sdf = new SimpleDateFormat("h:mm:ss a ");
                setFont(new Font(font, Font.PLAIN, WorldClock.timeLabelSize));
                break;
            case "day":
                sdf = new SimpleDateFormat("EEEE, ");
                setFont(new Font(font, Font.PLAIN, WorldClock.DDLabelSize));
                break;
            default:
                sdf = new SimpleDateFormat();
                break;
        }

        sdf.setTimeZone(TimeZone.getTimeZone("EST5EDT")); //East Coast


        Timer t = new Timer(1000, this);
        t.start();
    }

    public void actionPerformed(ActionEvent ae) {
        Date d = new Date();
        setText(sdf.format(d));
    }

}
class LondonClockLabel extends JLabel implements ActionListener {

    private String type;
    private SimpleDateFormat sdf;
    private String font = "antar";

    LondonClockLabel(String type) {
        this.type = type;
        setForeground(Color.green);

        switch (type) {
            case "date":
                sdf = new SimpleDateFormat("MMMM d yyyy");
                setFont(new Font(font, Font.PLAIN, WorldClock.DDLabelSize));
                break;
            case "time":
                sdf = new SimpleDateFormat("h:mm:ss a ");
                setFont(new Font(font, Font.PLAIN, WorldClock.timeLabelSize));
                break;
            case "day":
                sdf = new SimpleDateFormat("EEEE, ");
                setFont(new Font(font, Font.PLAIN, WorldClock.DDLabelSize));
                break;
            default:
                sdf = new SimpleDateFormat();
                break;
        }

        sdf.setTimeZone(TimeZone.getTimeZone("Europe/London")); //London


        Timer t = new Timer(1000, this);
        t.start();
    }

    public void actionPerformed(ActionEvent ae) {
        Date d = new Date();
        setText(sdf.format(d));
    }

}
class ParisClockLabel extends JLabel implements ActionListener {

    private String type;
    private SimpleDateFormat sdf;
    private String font = "antar";

    ParisClockLabel(String type) {
        this.type = type;
        setForeground(Color.green);

        switch (type) {
            case "date":
                sdf = new SimpleDateFormat("MMMM d yyyy");
                setFont(new Font(font, Font.PLAIN, WorldClock.DDLabelSize));
                break;
            case "time":
                sdf = new SimpleDateFormat("h:mm:ss a ");
                setFont(new Font(font, Font.PLAIN, WorldClock.timeLabelSize));
                break;
            case "day":
                sdf = new SimpleDateFormat("EEEE, ");
                setFont(new Font(font, Font.PLAIN, WorldClock.DDLabelSize));
                break;
            default:
                sdf = new SimpleDateFormat();
                break;
        }

        sdf.setTimeZone(TimeZone.getTimeZone("Europe/Paris")); //Paris


        Timer t = new Timer(1000, this);
        t.start();
    }

    public void actionPerformed(ActionEvent ae) {
        Date d = new Date();
        setText(sdf.format(d));
    }

}
class AustraliaClockLabel extends JLabel implements ActionListener {

    private String type;
    private SimpleDateFormat sdf;
    private String font = "antar";

    AustraliaClockLabel(String type) {
        this.type = type;
        setForeground(Color.green);

        switch (type) {
            case "date":
                sdf = new SimpleDateFormat("MMMM d yyyy");
                setFont(new Font(font, Font.PLAIN, WorldClock.DDLabelSize));
                break;
            case "time":
                sdf = new SimpleDateFormat("h:mm:ss a ");
                setFont(new Font(font, Font.PLAIN, WorldClock.timeLabelSize));
                break;
            case "day":
                sdf = new SimpleDateFormat("EEEE, ");
                setFont(new Font(font, Font.PLAIN, WorldClock.DDLabelSize));
                break;
            default:
                sdf = new SimpleDateFormat();
                break;
        }

        sdf.setTimeZone(TimeZone.getTimeZone("Australia/Sydney")); //Australia


        Timer t = new Timer(1000, this);
        t.start();
    }

    public void actionPerformed(ActionEvent ae) {
        Date d = new Date();
        setText(sdf.format(d));
    }

}
