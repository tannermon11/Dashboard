import javax.sound.sampled.*;
import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

/**
 * Created by Tanner on 10/2/2016.
 */
public class GUI extends JFrame {
    boolean isMuted = false;
    JPanel top = new JPanel(new GridLayout(1, 3));
    JPanel fav = new JPanel(new GridBagLayout());
    JPanel url = new JPanel();
    JPanel yt = new JPanel();
    JPanel explorer = new JPanel();
    JPanel mic = new JPanel();
    JPanel clock = new JPanel();
    JPanel stopWatch = new JPanel();
    JPanel twitch = new JPanel();
    JLabel message = new JLabel("Type URL to open here: ");
    JTextField input = new JTextField();
    JTextField search = new JTextField(15);
    JButton open = new JButton("Open");
    JButton searchButton = new JButton("Search");
    JLabel favLabel = new JLabel("Favorites");
    JButton star = new JButton("★");
    JButton save = new JButton("Save");
    JButton mute = new JButton("Mute");
    JTabbedPane tp = new JTabbedPane();
    JCheckBox alwaysActive = new JCheckBox("Always on top");
    DefaultListModel<String> listModel;
    DefaultListModel<String> twitchModel;
    JList<String> favList;
    JList<String> twitchList;
    File f = new File(FileSystemView.getFileSystemView().getDefaultDirectory().getPath() + "\\URLFavorites.txt");

    public GUI() {
        Clock cl = new Clock();
        Stopwatch sw = new Stopwatch();
        listModel = new DefaultListModel<>();
        favList = new JList<>(listModel);
        twitchModel = new DefaultListModel<>();
        twitchList = new JList<>(twitchModel);
        favList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        top.add(message);
        top.add(input);
        top.add(open);
        top.add(star);
        top.add(save);
        fav.add(favLabel);
        fav.add(favList);
        yt.add(search);
        yt.add(searchButton);
        mic.add(mute);
        clock.add(cl);
        clock.add(alwaysActive);
        stopWatch.add(sw);
        twitch.add(twitchList);
        tp.addTab("Sites", url);
        tp.addTab("Youtube", yt);
        tp.addTab("Restart explorer", explorer);
        tp.addTab("Mic Volume", mic);
        tp.addTab("Clock", clock);
        tp.addTab("Stop Watch", stopWatch);
        tp.addTab("Twitch", twitch);

        yt.setSize(new Dimension(200, 100));

        add(tp);
        tp.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
        url.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.gridy = 0;
        url.add(top, c);
        c.gridy = 1;
        url.add(fav, c);

        setSize(new Dimension(750, 200));
        setVisible(true);

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        if (f.exists()) {
            try {
                BufferedReader br = new BufferedReader(new FileReader(f));
                String line;
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                    listModel.addElement(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        twitchModel.addElement("<html><a href=\"twitch.tv/tannermon\">My Twitch Channel</a></html>");
        twitchModel.addElement("<html><a href=\"https://streamlabs.com/dashboard\">Twitch Alerts</a></html>");
        //twitchModel.addElement("<html><a href=\"https://www.twitch.tv/tannermon/chat?popout=\">Popout Chat</a></html>");


        open.addActionListener(e -> {
            String value = input.getText();
            MyTwitch.openUrl(value);
        });

        star.addActionListener(e -> {
            String value = input.getText();
            listModel.addElement(value);
            pack();
        });

        save.addActionListener(e -> save());

        searchButton.addActionListener(e -> {
            String text = search.getText();
            text = text.replace(" ", "%20");
            MyTwitch.openUrl("youtube.com/results?search_query=" + text);
        });

        mute.addActionListener(e -> {
            if (!isMuted) {
                setDeviceSensitivity(0);
                isMuted = true;
                mute.setText("Un-mute");
            } else {
                setDeviceSensitivity(70);
                isMuted = false;
                mute.setText("Mute");
            }
        });

        alwaysActive.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.DESELECTED)
                setAlwaysOnTop(false);
            else
                setAlwaysOnTop(true);
        });

        tp.addChangeListener(e -> {
            if (tp.getSelectedIndex() == 2)
                try {
                    Runtime.getRuntime().exec("taskkill /F /IM explorer.exe").waitFor();
                    Runtime.getRuntime().exec("\"C:\\Windows\\explorer.exe\"");
                } catch (IOException | InterruptedException e1) {
                    e1.printStackTrace();
                }
            pack();
        });

        twitchList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int index = twitchList.locationToIndex(e.getPoint());

                if (e.getClickCount() == 2) {
                    twitchList.clearSelection();
                    String selection = twitchList.getModel().getElementAt(index);
                    if (selection.contains("html")) {
                        selection = selection.substring(selection.indexOf("\"") + 1, selection.indexOf("\">"));
                    }
                    MyTwitch.openUrl(selection);
                }
            }
        });

        favList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int index = favList.locationToIndex(e.getPoint());
                if (e.getClickCount() == 2) {
                    favList.clearSelection();
                    String selection = favList.getModel().getElementAt(index);
                    if (selection.contains("html")) {
                        selection = selection.substring(selection.indexOf("\"") + 1, selection.indexOf("\">"));
                    }
                    MyTwitch.openUrl(selection);
                }
                if (e.getButton() == MouseEvent.BUTTON3) {
                    removeLineFromFile(FileSystemView.getFileSystemView().getDefaultDirectory().getPath() + "\\URLFavorites.txt", favList.getModel().getElementAt(index));
                    listModel.remove(index);
                }
            }
        });

        favList.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_R) {
                    int index = favList.getSelectedIndex();
                    String rename = JOptionPane.showInputDialog("What do you want to rename this to?");
                    if (rename == null) { //On cancel
                        rename = favList.getModel().getElementAt(index);
                        return;
                    }
                    String mySelection = favList.getModel().getElementAt(index);
                    String newName = "<html><a href=\"" + mySelection + "\"> " + rename + "</a></html>";
                    listModel.remove(index);
                    listModel.add(index, newName);
                    save();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        input.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    String value = input.getText();
                    MyTwitch.openUrl(value);
                }

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        search.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    String value = search.getText().replace(" ", "%20");
                    MyTwitch.openUrl("youtube.com/results?search_query=" + value);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
    }

    public void save() {
        try (PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream(f), "UTF-8"))) {
            for (int i = 0; i < listModel.getSize(); i++) {
                pw.println(listModel.getElementAt(i));
            }
        } catch (UnsupportedEncodingException | FileNotFoundException e1) {
            e1.printStackTrace();
        }
    }

    public void removeLineFromFile(String file, String lineToRemove) {

        try {
            File inFile = new File(file);

            if (!inFile.isFile()) {
                System.out.println("Parameter is not an existing file");
                return;
            }

            //Construct the new file that will later be renamed to the original filename.
            File tempFile = new File(inFile.getAbsolutePath() + ".tmp");

            BufferedReader br = new BufferedReader(new FileReader(file));
            PrintWriter pw = new PrintWriter(new FileWriter(tempFile));

            String line;

            //Read from the original file and write to the new
            //unless content matches data to be removed.
            while ((line = br.readLine()) != null) {

                if (!line.trim().equals(lineToRemove)) {

                    pw.println(line);
                    pw.flush();
                }
            }
            pw.close();
            br.close();

            System.gc();
            if (!inFile.delete()) {
                System.out.println("Could not delete file");
                return;
            }

            //Rename the new file to the filename the original file had.
            if (!tempFile.renameTo(inFile))
                System.out.println("Could not rename file");

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void setDeviceSensitivity(final int sensitivity) {
        Port lineIn = null;
        Mixer.Info[] info = AudioSystem.getMixerInfo();
        Mixer mixer = null;
        for (Mixer.Info anInfo : info) {
            mixer = AudioSystem.getMixer(anInfo);
        }
        try {
            if (mixer != null) {
                if (mixer.isLineSupported(Port.Info.LINE_IN)) {
                    lineIn = (Port) mixer.getLine(Port.Info.LINE_IN);
                    if (lineIn != null) {
                        lineIn.open();
                    }
                } else if (mixer.isLineSupported(Port.Info.MICROPHONE)) {
                    lineIn = (Port) mixer.getLine(Port.Info.MICROPHONE);
                    lineIn.open();
                } else {
                    System.out.println("Unable to get Input Port");
                    return;
                }
            }
            if (lineIn != null) {
                lineIn.getControls();
            }

            if (lineIn != null && lineIn.isControlSupported(FloatControl.Type.MASTER_GAIN)) {
                System.out.println("kewl");
            }

            CompoundControl cc = null;
            if (lineIn != null) {
                cc = (CompoundControl) lineIn.getControls()[0];
            }
            Control[] controls;
            controls = cc != null ? cc.getMemberControls() : new Control[0];
            for (final Control c : controls)
                if (c instanceof FloatControl) {
                    System.out.println("BEFORE LINE_IN VOL = " + ((FloatControl) c).getValue());
                    ((FloatControl) c).setValue((float) sensitivity / 100);
                    System.out.println("AFTER LINE_IN VOL = " + ((FloatControl) c).getValue());
                }
        } catch (final Exception e) {
            System.out.println(e);
        }
    }
}
