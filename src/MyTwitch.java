import java.awt.*;
import java.io.IOException;

/**
 * Created by Tanner on 10/2/2016.
 */
public class MyTwitch {
    public static void main(String[] args) {
        new GUI();
        /*Mixer.Info [] mixers = AudioSystem.getMixerInfo();
        System.out.println("There are " + mixers.length + " mixer info objects");

        for (Mixer.Info mixerInfo : mixers)
        {
            System.out.println("mixer name: " + mixerInfo.getName());
            Mixer mixer = AudioSystem.getMixer(mixerInfo);
            Line.Info [] lineInfos = mixer.getSourceLineInfo();
            for (Line.Info lineInfo : lineInfos)
            {
                System.out.println("  Line.Info: " + lineInfo);
                try {
                    Line line = mixer.getLine(lineInfo);
                    FloatControl volCtrl =
                            (FloatControl)line.getControl(FloatControl.Type.MASTER_GAIN);
                    System.out.println("    volCtrl.getValue() = " + volCtrl.getValue());
                } catch (LineUnavailableException e) {
                    e.printStackTrace();
                } catch (IllegalArgumentException iaEx)
                {
                    System.out.println("    " + iaEx);
                }
            }
        }*/
    }
    public static void openUrl(String url) {
        try {
            Runtime.getRuntime().exec("\"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe\" " + url);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void listFonts() {
        String fonts[] =
                GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();

        for (String font : fonts) {
            System.out.println(font);
        }
    }

}
