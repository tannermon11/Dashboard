/**
 * Created by Tanner on 4/21/2018.
 */

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author David
 */
public class Suggestion {

	static ArrayList<String> words = new ArrayList<>();
	public Suggestion() {
		//JFrame frame = new JFrame();
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


		AutoSuggestor autoSuggestor = new AutoSuggestor(GUI.champSearch, new GUI(), null, Color.WHITE.brighter(), Color.BLUE, Color.RED, 0.75f) {
			int max = 0;
			@Override

			boolean wordTyped(String typedWord) {
				//create list for dictionary this in your case might be done via calling a method which queries db and returns results as arraylist
					if(words.size() == 0) {
						words.add("Aatrox");
						words.add("Ahri");
						words.add("Akali");
						words.add("Alistar");
						words.add("Amumu");
						words.add("Anivia");
						words.add("Annie");
						words.add("Ashe");
						words.add("Aurelion Sol");
						words.add("Azir");
						words.add("Bard");
						words.add("Blitzcrank");
						words.add("Brand");
						words.add("Braum");
						words.add("Caitlyn");
						words.add("Camille");
						words.add("Cassiopeia");
						words.add("Cho'Gath");
						words.add("Corki");
						words.add("Darius");
						words.add("Diana");
						words.add("Dr. Mundo");
						words.add("Draven");
						words.add("Ekko");
						words.add("Elise");
						words.add("Evelynn");
						words.add("Fiddlesticks");
						words.add("Fiora");
						words.add("Fizz");
						words.add("Galio");
						words.add("Gangplank");
						words.add("Garen");
						words.add("Gnar");
						words.add("Gragas");
						words.add("Graves");
						words.add("Hecarim");
						words.add("Heimerdinger");
						words.add("Illaoi");
						words.add("Irelia");
						words.add("Ivern");
						words.add("Janna");
						words.add("Jarvan IV");
						words.add("Jax");
						words.add("Jayce");
						words.add("Jhin");
						words.add("Jinx");
						words.add("Kai'sa");
						words.add("Kalista");
						words.add("Karma");
						words.add("Karthus");
						words.add("Kassadin");
						words.add("Katarina");
						words.add("Kayle");
						words.add("Kayn");
						words.add("Kennen");
						words.add("Kha'Zix");
						words.add("Kindred");
						words.add("Kled");
						words.add("Kog'Maw");
						words.add("LeBlanc");
						words.add("Lee Sin");
						words.add("Leona");
						words.add("Lissandra");
						words.add("Lucian");
						words.add("Lulu");
						words.add("Lux");
						words.add("Malphite");
						words.add("Malzahar");
						words.add("Maokai");
						words.add("Master Yi");
						words.add("Miss Fortune");
						words.add("Mordekaiser");
						words.add("Morgana");
						words.add("Nami");
						words.add("Nasus");
						words.add("Nautilus");
						words.add("Nidalee");
						words.add("Nocturne");
						words.add("Nunu");
						words.add("Olaf");
						words.add("Orianna");
						words.add("Pantheon");
						words.add("Poppy");
						words.add("Pyke");
						words.add("Quinn");
						words.add("Rakan");
						words.add("Rammus");
						words.add("Rek'Sai");
						words.add("Renekton");
						words.add("Rengar");
						words.add("Riven");
						words.add("Rumble");
						words.add("Ryze");
						words.add("Sejuani");
						words.add("Shaco");
						words.add("Shen");
						words.add("Shyvana");
						words.add("Singed");
						words.add("Sion");
						words.add("Sivir");
						words.add("Skarner");
						words.add("Sona");
						words.add("Soraka");
						words.add("Swain");
						words.add("Syndra");
						words.add("Tahm Kench");
						words.add("Taliyah");
						words.add("Talon");
						words.add("Taric");
						words.add("Teemo");
						words.add("Thresh");
						words.add("Tristana");
						words.add("Trundle");
						words.add("Tryndamere");
						words.add("Twisted Fate");
						words.add("Twitch");
						words.add("Udyr");
						words.add("Urgot");
						words.add("Varus");
						words.add("Vayne");
						words.add("Veigar");
						words.add("Vel'Koz");
						words.add("Vi");
						words.add("Viktor");
						words.add("Vladimir");
						words.add("Volibear");
						words.add("Warwick");
						words.add("Wukong");
						words.add("Xayah");
						words.add("Xerath");
						words.add("Xin Zhao");
						words.add("Yasuo");
						words.add("Yorick");
						words.add("Zac");
						words.add("Zed");
						words.add("Ziggs");
						words.add("Zilean");
						words.add("Zoe");
						words.add("Zyra");
					}

				int[] countArray = new int[26];
				for(String word : words) {
					if(word.startsWith("A"))
						countArray[0]++;
					else if(word.startsWith("B"))
						countArray[1]++;
					else if(word.startsWith("C"))
						countArray[2]++;
					else if(word.startsWith("D"))
						countArray[3]++;
					else if(word.startsWith("E"))
						countArray[4]++;
					else if(word.startsWith("F"))
						countArray[5]++;
					else if(word.startsWith("G"))
						countArray[6]++;
					else if(word.startsWith("H"))
						countArray[7]++;
					else if(word.startsWith("I"))
						countArray[8]++;
					else if(word.startsWith("J"))
						countArray[9]++;
					else if(word.startsWith("K"))
						countArray[10]++;
					else if(word.startsWith("L"))
						countArray[11]++;
					else if(word.startsWith("M"))
						countArray[12]++;
					else if(word.startsWith("N"))
						countArray[13]++;
					else if(word.startsWith("O"))
						countArray[14]++;
					else if(word.startsWith("P"))
						countArray[15]++;
					else if(word.startsWith("Q"))
						countArray[16]++;
					else if(word.startsWith("R"))
						countArray[17]++;
					else if(word.startsWith("S"))
						countArray[18]++;
					else if(word.startsWith("T"))
						countArray[19]++;
					else if(word.startsWith("U"))
						countArray[20]++;
					else if(word.startsWith("V"))
						countArray[21]++;
					else if(word.startsWith("W"))
						countArray[22]++;
					else if(word.startsWith("X"))
						countArray[23]++;
					else if(word.startsWith("Y"))
						countArray[24]++;
					else if(word.startsWith("Z"))
						countArray[25]++;
				}

				max = getMax(countArray);

				Map<String, Integer> myMap = new HashMap<>();
				String[] myArray = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q",
				"R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
				for(int i=0; i<26; i++) {
					myMap.put(myArray[i], countArray[i]);
				}

				Integer theMax = max;
				int count = 0;

				for (int aCountArray : countArray) {
					if (aCountArray == max) {
						count++;
					}
				}

				System.out.println(Arrays.asList(myMap)); // method 1

				String[] letters = new String[myMap.size()];

				count = 0;
				for(Map.Entry entry: myMap.entrySet()){
					if(theMax.equals(entry.getValue())){
						letters[count] = (String) entry.getKey();
						//break; //breaking because its one to one map
					}
					count++;
				}


				System.out.println("The max champions with a starting letter is " + max + " with the letter " + Arrays.toString(Arrays.stream(letters)
						.filter(s -> (s != null && s.length() > 0))
						.toArray(String[]::new)));

				setDictionary(words);
				//addToDictionary("bye");//adds a single word

				return super.wordTyped(typedWord);//now call super to check for any matches against newest dictionary
			}
		};



		/*JPanel p = new JPanel();

		p.add(f);

		frame.add(p);

		frame.pack();
		frame.setVisible(true);*/
	}

	public static int getMax(int[] inputArray){
		int maxValue = inputArray[0];
		for(int i=1;i < inputArray.length;i++){
			if(inputArray[i] > maxValue){
				maxValue = inputArray[i];
			}
		}
		return maxValue;
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new Suggestion();
			}
		});
	}
}

class AutoSuggestor {

	private final JTextField textField;
	private final Window container;
	private JPanel suggestionsPanel;
	private JWindow autoSuggestionPopUpWindow;
	private String typedWord;
	public final ArrayList<String> dictionary = new ArrayList<>();
	private int currentIndexOfSpace, tW, tH;
	private DocumentListener documentListener = new DocumentListener() {
		@Override
		public void insertUpdate(DocumentEvent de) {
			checkForAndShowSuggestions();
		}

		@Override
		public void removeUpdate(DocumentEvent de) {
			checkForAndShowSuggestions();
		}

		@Override
		public void changedUpdate(DocumentEvent de) {
			checkForAndShowSuggestions();
		}
	};
	private final Color suggestionsTextColor;
	private final Color suggestionFocusedColor;

	public AutoSuggestor(JTextField textField, Window mainWindow, ArrayList<String> words, Color popUpBackground, Color textColor, Color suggestionFocusedColor, float opacity) {
		this.textField = textField;
		this.suggestionsTextColor = textColor;
		this.container = mainWindow;
		this.suggestionFocusedColor = suggestionFocusedColor;
		this.textField.getDocument().addDocumentListener(documentListener);

		setDictionary(words);

		typedWord = "";
		currentIndexOfSpace = 0;
		tW = 0;
		tH = 0;

		autoSuggestionPopUpWindow = new JWindow(mainWindow);
		autoSuggestionPopUpWindow.setOpacity(opacity);

		suggestionsPanel = new JPanel();
		suggestionsPanel.setLayout(new GridLayout(0, 1));
		suggestionsPanel.setBackground(popUpBackground);

		addKeyBindingToRequestFocusInPopUpWindow();

		textField.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					String value = textField.getText();
					MyTwitch.openUrl("champion.gg/champion/" + value);
				}

			}

			@Override
			public void keyReleased(KeyEvent e) {

			}
		});
	}



	private void addKeyBindingToRequestFocusInPopUpWindow() {
		textField.getInputMap(JComponent.WHEN_FOCUSED).put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0, true), "Down released");
		textField.getActionMap().put("Down released", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent ae) {//focuses the first label on popwindow
				for (int i = 0; i < suggestionsPanel.getComponentCount(); i++) {
					if (suggestionsPanel.getComponent(i) instanceof SuggestionLabel) {
						((SuggestionLabel) suggestionsPanel.getComponent(i)).setFocused(true);
						autoSuggestionPopUpWindow.toFront();
						autoSuggestionPopUpWindow.requestFocusInWindow();
						suggestionsPanel.requestFocusInWindow();
						suggestionsPanel.getComponent(i).requestFocusInWindow();
						break;
					}
				}
			}
		});
		suggestionsPanel.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0, true), "Down released");
		suggestionsPanel.getActionMap().put("Down released", new AbstractAction() {
			int lastFocusableIndex = 0;

			@Override
			public void actionPerformed(ActionEvent ae) {//allows scrolling of labels in pop window (I know very hacky for now :))

				ArrayList<SuggestionLabel> sls = getAddedSuggestionLabels();
				int max = sls.size();

				if (max > 1) {//more than 1 suggestion
					for (int i = 0; i < max; i++) {
						SuggestionLabel sl = sls.get(i);
						if (sl.isFocused()) {
							if (lastFocusableIndex == max - 1) {
								lastFocusableIndex = 0;
								sl.setFocused(false);
								autoSuggestionPopUpWindow.setVisible(false);
								setFocusToTextField();
								checkForAndShowSuggestions();//fire method as if document listener change occured and fired it

							} else {
								sl.setFocused(false);
								lastFocusableIndex = i;
							}
						} else if (lastFocusableIndex <= i) {
							if (i < max) {
								sl.setFocused(true);
								autoSuggestionPopUpWindow.toFront();
								autoSuggestionPopUpWindow.requestFocusInWindow();
								suggestionsPanel.requestFocusInWindow();
								suggestionsPanel.getComponent(i).requestFocusInWindow();
								lastFocusableIndex = i;
								break;
							}
						}
					}
				} else {//only a single suggestion was given
					autoSuggestionPopUpWindow.setVisible(false);
					setFocusToTextField();
					checkForAndShowSuggestions();//fire method as if document listener change occured and fired it
				}
			}
		});
	}

	private void setFocusToTextField() {
		container.toFront();
		container.requestFocusInWindow();
		textField.requestFocusInWindow();
	}

	public ArrayList<SuggestionLabel> getAddedSuggestionLabels() {
		ArrayList<SuggestionLabel> sls = new ArrayList<>();
		for (int i = 0; i < suggestionsPanel.getComponentCount(); i++) {
			if (suggestionsPanel.getComponent(i) instanceof SuggestionLabel) {
				SuggestionLabel sl = (SuggestionLabel) suggestionsPanel.getComponent(i);
				sls.add(sl);
			}
		}
		return sls;
	}

	private void checkForAndShowSuggestions() {
		typedWord = getCurrentlyTypedWord();

		suggestionsPanel.removeAll();//remove previos words/jlabels that were added

		//used to calcualte size of JWindow as new Jlabels are added
		tW = 0;
		tH = 0;

		boolean added = wordTyped(typedWord);

		if (!added) {
			if (autoSuggestionPopUpWindow.isVisible()) {
				autoSuggestionPopUpWindow.setVisible(false);
			}
		} else {
			showPopUpWindow();
			setFocusToTextField();
		}
	}

	protected void addWordToSuggestions(String word) {
		SuggestionLabel suggestionLabel = new SuggestionLabel(word, suggestionFocusedColor, suggestionsTextColor, this);

		calculatePopUpWindowSize(suggestionLabel);

		suggestionsPanel.add(suggestionLabel);
	}

	public String getCurrentlyTypedWord() {//get newest word after last white spaceif any or the first word if no white spaces
		String text = textField.getText();
		String wordBeingTyped = "";
		if (text.contains(" ")) {
			int tmp = text.lastIndexOf(" ");
			if (tmp >= currentIndexOfSpace) {
				currentIndexOfSpace = tmp;
				wordBeingTyped = text.substring(text.lastIndexOf(" "));
			}
		} else {
			wordBeingTyped = text;
		}
		return wordBeingTyped.trim();
	}

	private void calculatePopUpWindowSize(JLabel label) {
		//so we can size the JWindow correctly
		if (tW < label.getPreferredSize().width) {
			tW = label.getPreferredSize().width;
		}
		tH += label.getPreferredSize().height;
	}

	private void showPopUpWindow() {
		autoSuggestionPopUpWindow.getContentPane().add(suggestionsPanel);
		autoSuggestionPopUpWindow.setMinimumSize(new Dimension(textField.getWidth(), 30));
		autoSuggestionPopUpWindow.setSize(tW, tH);
		autoSuggestionPopUpWindow.setVisible(true);

		int windowX = 0;
		int windowY = 0;

		windowX = container.getX() + textField.getX() + 10;
		if (suggestionsPanel.getHeight() > autoSuggestionPopUpWindow.getMinimumSize().height) {
			windowY = container.getY() + textField.getY() + textField.getHeight() + autoSuggestionPopUpWindow.getMinimumSize().height+25;
			//System.out.println("1: " + windowY + "," + container.getY()+ "," + textField.getY() + "," + textField.getHeight() + "," + autoSuggestionPopUpWindow.getMinimumSize().height);
		} else {
			windowY = container.getY() + textField.getY() + textField.getHeight() + autoSuggestionPopUpWindow.getHeight()+25;
			//System.out.println("2: " + windowY + "," + container.getY()+ "," + textField.getY() + "," + textField.getHeight() + "," + autoSuggestionPopUpWindow.getMinimumSize().height);
		}

		autoSuggestionPopUpWindow.setLocation(windowX, windowY);
		autoSuggestionPopUpWindow.setMinimumSize(new Dimension(textField.getWidth(), 30));
		autoSuggestionPopUpWindow.revalidate();
		autoSuggestionPopUpWindow.repaint();

	}

	public void setDictionary(ArrayList<String> words) {
		dictionary.clear();
		if (words == null) {
			return;//so we can call constructor with null value for dictionary without exception thrown
		}
		for (String word : words) {
			dictionary.add(word);
		}
	}

	public JWindow getAutoSuggestionPopUpWindow() {
		return autoSuggestionPopUpWindow;
	}

	public Window getContainer() {
		return container;
	}

	public JTextField getTextField() {
		return textField;
	}

	public void addToDictionary(String word) {
		dictionary.add(word);
	}

	boolean wordTyped(String typedWord) {

		if (typedWord.isEmpty()) {
			return false;
		}
		//System.out.println("Typed word: " + typedWord);

		boolean suggestionAdded = false;

		for (String word : dictionary) {//get words in the dictionary which we added
			boolean fullymatches = true;
			for (int i = 0; i < typedWord.length(); i++) {//each string in the word
				if (!typedWord.toLowerCase().startsWith(String.valueOf(word.toLowerCase().charAt(i)), i)) {//check for match
					fullymatches = false;
					break;
				}
			}
			if (fullymatches) {
				addWordToSuggestions(word);
				suggestionAdded = true;
			}
		}
		return suggestionAdded;
	}
}

class SuggestionLabel extends JLabel {

	private boolean focused = false;
	private final JWindow autoSuggestionsPopUpWindow;
	private final JTextField textField;
	private final AutoSuggestor autoSuggestor;
	private Color suggestionsTextColor, suggestionBorderColor;

	public SuggestionLabel(String string, final Color borderColor, Color suggestionsTextColor, AutoSuggestor autoSuggestor) {
		super(string);

		this.suggestionsTextColor = suggestionsTextColor;
		this.autoSuggestor = autoSuggestor;
		this.textField = autoSuggestor.getTextField();
		this.suggestionBorderColor = borderColor;
		this.autoSuggestionsPopUpWindow = autoSuggestor.getAutoSuggestionPopUpWindow();

		initComponent();
	}

	private void initComponent() {
		setFocusable(true);
		setForeground(suggestionsTextColor);

		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent me) {
				super.mouseClicked(me);

				replaceWithSuggestedText();

				autoSuggestionsPopUpWindow.setVisible(false);
			}
		});

		getInputMap(JComponent.WHEN_FOCUSED).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, true), "Enter released");
		getActionMap().put("Enter released", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				replaceWithSuggestedText();
				autoSuggestionsPopUpWindow.setVisible(false);
			}
		});
	}

	public void setFocused(boolean focused) {
		if (focused) {
			setBorder(new LineBorder(suggestionBorderColor));
		} else {
			setBorder(null);
		}
		repaint();
		this.focused = focused;
	}

	public boolean isFocused() {
		return focused;
	}

	private void replaceWithSuggestedText() {
		String suggestedWord = getText();
		String text = textField.getText();
		String typedWord = autoSuggestor.getCurrentlyTypedWord();
		String t = text.substring(0, text.lastIndexOf(typedWord));
		String tmp = t + text.substring(text.lastIndexOf(typedWord)).replace(typedWord, suggestedWord);
		textField.setText(tmp);
	}
}
