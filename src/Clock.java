import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Tanner on 10/4/2016.
 */
class Clock extends JPanel{
    Clock() {
        setPreferredSize(new Dimension(600,100));
        setLayout(new GridBagLayout());
        setBackground(Color.black);
        clockLabel clockTime = new clockLabel("time");
        clockLabel clockDay = new clockLabel("day");
        clockLabel clockDate = new clockLabel("date");
        add(clockTime);
        add(clockDay);
        add(clockDate);
    }
}

class clockLabel extends JLabel implements ActionListener {

    private String type;
    private SimpleDateFormat sdf;
    private String font = "antar";

    public clockLabel(String type) {
        this.type = type;
        setForeground(Color.green);

        switch (type) {
            case "date":
                sdf = new SimpleDateFormat("MMMM d yyyy");
                setFont(new Font(font, Font.PLAIN, 26));
                break;
            case "time":
                sdf = new SimpleDateFormat("h:mm:ss a ");
                setFont(new Font(font, Font.PLAIN, 40));
                break;
            case "day":
                sdf = new SimpleDateFormat("EEEE, ");
                setFont(new Font(font, Font.PLAIN, 26));
                break;
            default:
                sdf = new SimpleDateFormat();
                break;
        }

        Timer t = new Timer(1000, this);
        t.start();
    }

    public void actionPerformed(ActionEvent ae) {
        Date d = new Date();
        setText(sdf.format(d));
    }

}
