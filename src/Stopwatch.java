import javax.swing.*;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Tanner on 12/13/2016.
 */
public class Stopwatch extends JPanel{

    Instant first;
    boolean isActivated = false;
    JButton activate = new JButton("Start");
    JButton reset = new JButton("Reset");
    JTextField time = new JTextField(15);
    Timer timer;
    Duration temp = Duration.ZERO;

    public Stopwatch() {

        add(activate);
        add(reset);
        add(time);

        timer = new Timer(100, e1 -> {
            String result = applyRegex(LocalTime.MIDNIGHT.plus(activator().plus(temp)).format(DateTimeFormatter.ofPattern("HH:mm:ss:SSS")));
            time.setText(result);
        });

        activate.addActionListener(e -> {

            if(!isActivated) { //Start
                isActivated = true;
                first = Instant.now();
                timer.start();
                activate.setText("Pause");
            }
            else { //Pause
                isActivated = false;
                temp = temp.plus(activator());
                timer.stop();
                activate.setText("Start");
            }
        });

        reset.addActionListener(e -> { //Reset
            isActivated = false;
            temp = Duration.ZERO;
            activator();
            timer.stop();
            activate.setText("Start");
        });

    }

    public Duration activator() {
        return Duration.between(first, Instant.now());
    }

    public String applyRegex(String txt) {

        String re1="([^00:][^_]++)";


        Pattern p = Pattern.compile(re1,Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
        Matcher m = p.matcher(txt);
        if (m.find())
            return m.group(1);

        return "";
    }

}
