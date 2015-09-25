package hangmanView;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.io.FileNotFoundException;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import hangmanController.HangManController;
import hangmanModel.HangManModel;

import javax.swing.SwingConstants;

/**
 * View that does not draw the hangman.  It only shows the score and turn counts
 * @author Charlie
 *
 */
public class HangManView2 extends JFrame implements Observer {
	/**
	 * Declare all required variables.
	 */
	private static final long serialVersionUID = 1L;
	private JMenuBar menuBar;
	private JPanel contentPane;
	private JTextField textFieldGuess;
	private JTextPane usedLetters;
	private JPanel  panel_Phrase;
	private JButton btnGuess;
	private JTextArea textAreaGuesses;
	private JMenuItem mntmNewGame, mntmExit, mntmOpenDictionary;
	private HangManModel model = null;
	private int guesses;
	
	public HangManView2(HangManModel model) throws FileNotFoundException {
		this.model = model;
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		
		//center the game
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
		menuBar = new JMenuBar();
		menuBar.setToolTipText("");
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		mntmNewGame = new JMenuItem("New Game");
		mnFile.add(mntmNewGame);
		
		mntmOpenDictionary = new JMenuItem("Open Dictionary");
		mnFile.add(mntmOpenDictionary);
		
		mntmExit = new JMenuItem("Exit");
		mnFile.add(mntmExit);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_WordWindow = new JPanel();
		panel_WordWindow.setBounds(10, 393, 674, 57);
		contentPane.add(panel_WordWindow);
		panel_WordWindow.setLayout(null);
		
		usedLetters = new JTextPane();
		usedLetters.setFont(new Font("Tahoma", Font.BOLD, 18));
		usedLetters.setEditable(false);
		usedLetters.setBounds(10, 11, 609, 35);
		panel_WordWindow.add(usedLetters);
		
		JPanel panel_Graphic = new JPanel();
		panel_Graphic.setBounds(339, 11, 345, 360);
		contentPane.add(panel_Graphic);
		panel_Graphic.setLayout(null);
		
		JTextArea textAreaScore = new JTextArea();
		textAreaScore.setBounds(144, 11, 191, 100);
		panel_Graphic.add(textAreaScore);
		
		JTextArea textAreaRemainingGuesses = new JTextArea();
		textAreaRemainingGuesses.setBounds(144, 133, 191, 100);
		panel_Graphic.add(textAreaRemainingGuesses);
		
		JTextArea textAreaRemainingLetters = new JTextArea();
		textAreaRemainingLetters.setBounds(144, 249, 191, 100);
		panel_Graphic.add(textAreaRemainingLetters);
		
		JLabel lblScore = new JLabel("Score:");
		lblScore.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblScore.setBounds(39, 49, 58, 21);
		panel_Graphic.add(lblScore);
		
		JLabel lblGuessesRemaining = new JLabel("Remaining Guesses:");
		lblGuessesRemaining.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblGuessesRemaining.setBounds(10, 178, 131, 21);
		panel_Graphic.add(lblGuessesRemaining);
		
		JLabel lblRemainingLetters = new JLabel("Remaining Letters:");
		lblRemainingLetters.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblRemainingLetters.setBounds(10, 290, 131, 21);
		panel_Graphic.add(lblRemainingLetters);
		
		JPanel panel_Guess = new JPanel();
		panel_Guess.setBounds(10, 11, 319, 65);
		contentPane.add(panel_Guess);
		panel_Guess.setLayout(null);
		
		JLabel lblGuessALetter = new JLabel("Guess a Letter:");
		lblGuessALetter.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblGuessALetter.setBounds(10, 21, 131, 21);
		panel_Guess.add(lblGuessALetter);
		
		textFieldGuess = new JTextField();
		textFieldGuess.setBounds(140, 23, 67, 20);
		panel_Guess.add(textFieldGuess);
		textFieldGuess.setColumns(1);
		
		btnGuess = new JButton("Guess!");
		btnGuess.setBounds(220, 22, 89, 23);
		panel_Guess.add(btnGuess);
		
		panel_Phrase = new JPanel();
		panel_Phrase.setBounds(10, 87, 319, 284);
		contentPane.add(panel_Phrase);
		panel_Phrase.setLayout(null);
		
		textAreaGuesses = new JTextArea();
		textAreaGuesses.setEditable(false);
		textAreaGuesses.setFont(new Font("Monospaced", Font.BOLD, 25));
		textAreaGuesses.setBounds(10, 11, 299, 262);
		panel_Phrase.add(textAreaGuesses);
		
		JLabel lblLettersGuessed = new JLabel("Letters Guessed:");
		lblLettersGuessed.setBounds(20, 378, 109, 14);
		contentPane.add(lblLettersGuessed);
		lblLettersGuessed.setHorizontalAlignment(SwingConstants.LEFT);
	}
	
	public JButton getGuessButton(){
		return btnGuess;
	}
	
	public JTextField getGuessText(){
		return textFieldGuess;
	}
	
	public JTextPane getUsedLettersField(){
		return usedLetters;
	}
	
	public JTextArea getWordsDisplayed(){
		return textAreaGuesses;
	}
	
	public void addBtnGuessController(HangManController hangController){
		btnGuess.addActionListener(hangController);
	}
	
	public void addNewGameController(HangManController hangController){
		mntmNewGame.addActionListener(hangController);
	}
	
	public void addOpenDictionaryController(HangManController hangController){
		mntmOpenDictionary.addActionListener(hangController);
	}
	
	public void addExitGameController(HangManController hangController){
		mntmExit.addActionListener(hangController);
	}
	
	/*public HangManCanvas getHangmanCanvas(){
		return hangmanCanvas;
	}*/
	
	public void updateViewCanvas(){
		guesses = model.getGuessesRemaining();
		
		/*if(guesses == 10){
			hangmanCanvas.drawStandBase(hangmanCanvas.getGraphics());
		}
		else if(guesses == 9){
			hangmanCanvas.drawStandLeft(hangmanCanvas.getGraphics());
			
		}
		else if(guesses == 8){
			hangmanCanvas.drawStandTop(hangmanCanvas.getGraphics());
			
		}
		else if(guesses == 7){
			hangmanCanvas.drawNoose(hangmanCanvas.getGraphics());
			
		}
		else if(guesses == 6){
			hangmanCanvas.drawHead(hangmanCanvas.getGraphics());
			
		}
		else if(guesses == 5){
			hangmanCanvas.drawBody(hangmanCanvas.getGraphics());
			
		}
		else if(guesses == 4){
			hangmanCanvas.drawLegLeft(hangmanCanvas.getGraphics());
			
		}
		else if(guesses == 3){
			hangmanCanvas.drawLegRight(hangmanCanvas.getGraphics());
			
		}
		else if(guesses == 2){
			hangmanCanvas.drawArmLeft(hangmanCanvas.getGraphics());
			
		}
		else if(guesses == 1){
			hangmanCanvas.drawArmRight(hangmanCanvas.getGraphics());
		}
		else if(guesses == 0){
			hangmanCanvas.drawEyes(hangmanCanvas.getGraphics());
		}*/
	}
	@Override
	public void update(Observable o, Object arg) {
		if(o == model){
			updateViewCanvas();
		}
	}
}
