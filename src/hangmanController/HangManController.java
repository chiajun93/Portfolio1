package hangmanController;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import hangmanModel.HangManModel;
import hangmanView.HangManCanvas;
import hangmanView.HangManView;
import hangmanView.HangManView2;

public class HangManController implements ActionListener {
	private HangManModel model;
	private JTextPane usedLettersField;
	private JTextArea wordsDisplayed;
	private HangManCanvas canvas;
	private JTextField guessText;

	public HangManController(HangManModel model, HangManView view) throws FileNotFoundException {
		this.model = model;
		usedLettersField = view.getUsedLettersField();
		wordsDisplayed = view.getWordsDisplayed();
		canvas = view.getHangmanCanvas();
		guessText = view.getGuessText();
		model.addObserver(view);
	}

	public HangManController(HangManModel model, HangManView2 view) throws FileNotFoundException {
		this.model = model;
		usedLettersField = view.getUsedLettersField();
		wordsDisplayed = view.getWordsDisplayed();
		guessText = view.getGuessText();
		model.addObserver(view);
	}

	public void setUsedLetter(String letter) {
		model.guessLetter(letter);
	}

	public void updateLetterGuess() {
		ArrayList<String> letterList = model.getLettersGuessed();
		String usedLetters = letterList.toString();
		usedLettersField.setText(usedLetters.substring(1, usedLetters.length() - 1));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("New Game")) {
			newGame();
		} else if (e.getActionCommand().equals("Open Dictionary")) {
			JFileChooser fileChoose = new JFileChooser();
			fileChoose.setDialogTitle("Choose a new dictionary text file");
			int returnVal = fileChoose.showOpenDialog(null);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				String filePath = fileChoose.getSelectedFile().getAbsolutePath();
				if (!filePath.contains("txt")) {
					JOptionPane.showMessageDialog(null, "Invalid text file!");
					return;
				}
				model = new HangManModel(filePath);
				newGame();
			}

			else {
				return;
			}
		} else if (e.getActionCommand().equals("Exit")) {
			exitGame();
		}

		else {
			// get the letter that the player guessed
			String letter = guessText.getText();

			// clear the guess field to make guessing again easier
			guessText.setText("");

			// if there was more than one char or wasn't a letter, stop
			// executing
			if (letter.length() > 1 || !letter.matches("[a-zA-Z]+")) {
				return;
			}

			setUsedLetter(letter);
			updateLetterGuess();

			wordsDisplayed.setText(model.getWordDisplay());
			if (model.hasWon()) {
				JOptionPane.showMessageDialog(null, "Congrats, you have won!");
			}

			else if (model.hasLost()) {
				JOptionPane.showMessageDialog(null, "You lost!");
				wordsDisplayed.setText(model.getGoalWord());
			}
		}
		wordsDisplayed.setText(model.getWordDisplay());
	}

	public void initView() {
		wordsDisplayed.setText(model.getWordDisplay());
	}

	/**
	 * Starts a new game
	 */
	public void newGame() {
		// set a new goal word
		model.setNewGoalWord();
		canvas.getGraphics().clearRect(0, 0, 345, 360);
		updateLetterGuess();
		initView();
	}

	/**
	 * Exits the game
	 */
	public void exitGame() {
		System.exit(0);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				int option = JOptionPane.showOptionDialog(null, "Please choose your HangMan's GUI.", "View Selector",
						JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, "View 1, View 2".split(","),
						"View 1");
				try {
					HangManModel hangModel = new HangManModel();
					HangManView hangView = new HangManView(hangModel);
					HangManView2 hangView2 = new HangManView2(hangModel);
					HangManController controller;
					if (option == 0) {
						controller = new HangManController(hangModel, hangView);
						hangView.addBtnGuessController(controller);
						hangView.addNewGameController(controller);
						hangView.addOpenDictionaryController(controller);
						hangView.addExitGameController(controller);
						controller.initView();
						hangView.setVisible(true);
					}

					else {
						controller = new HangManController(hangModel, hangView2);
						hangView2.addBtnGuessController(controller);
						hangView2.addNewGameController(controller);
						hangView2.addOpenDictionaryController(controller);
						hangView2.addExitGameController(controller);
						controller.initView();
						hangView2.setVisible(true);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
