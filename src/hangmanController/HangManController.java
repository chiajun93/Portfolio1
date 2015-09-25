package hangmanController;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import hangmanModel.HangManModel;
import hangmanView.HangManView;

public class HangManController implements ActionListener {
	private HangManModel model;
	private HangManView view;

	public HangManController(HangManModel model, HangManView view) {
		this.model = model;
		this.view = view;
		model.addObserver(view);
	}

	public void setUsedLetter(String letter) {
		model.guessLetter(letter);
	}

	public void updateLetterGuess() {
		ArrayList<String> letterList = model.getLettersGuessed();
		String usedLetters = letterList.toString();
		view.getUsedLettersField().setText(usedLetters.substring(1, usedLetters.length() - 1));
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

		else if (e.getActionCommand().equals("View 1")) {

		}

		else if (e.getActionCommand().equals("View 2")) {

		}

		else {
			// get the letter that the player guessed
			String letter = view.getGuessText().getText();

			// clear the guess field to make guessing again easier
			view.getGuessText().setText("");

			// if there was more than one char or wasn't a letter, stop
			// executing
			if (letter.length() > 1 || !letter.matches("[a-zA-Z]+")) {
				return;
			}

			setUsedLetter(letter);
			updateLetterGuess();

			view.getWordsDisplayed().setText(model.getWordDisplay());
			if (model.hasWon()) {
				JOptionPane.showMessageDialog(null, "Congrats, you have won!");
			}

			else if (model.hasLost()) {
				JOptionPane.showMessageDialog(null, "You lost!");
				view.getWordsDisplayed().setText(model.getGoalWord());
			}
		}
		view.getWordsDisplayed().setText(model.getWordDisplay());
	}

	public void initView() {
		view.getWordsDisplayed().setText(model.getWordDisplay());
	}

	/**
	 * Starts a new game
	 */
	public void newGame() {
		// set a new goal word
		model.setNewGoalWord();
		view.getHangmanCanvas().getGraphics().clearRect(0, 0, 345, 360);
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
				try {
					HangManModel hangModel = new HangManModel();
					HangManView hangView = new HangManView(hangModel);
					HangManController controller = new HangManController(hangModel, hangView);
					hangView.addBtnGuessController(controller);
					hangView.addNewGameController(controller);
					hangView.addOpenDictionaryController(controller);
					hangView.addExitGameController(controller);
					controller.initView();
					
					hangView.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
