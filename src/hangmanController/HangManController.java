package hangmanController;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import hangmanModel.HangManModel;
import hangmanView.HangManView;

public class HangManController implements ActionListener {
	private HangManModel model;
	private HangManView view;
	
	public HangManController(HangManModel model, HangManView view){
		this.model = model;
		this.view = view;
	}
	
	
	public void guess(){
		
	}
	
	public void setUsedLetter(String letter){
		model.guessLetter(letter);
	}
	
	public void updateLetterGuess(){
		ArrayList<String> letterList = model.getLettersGuessed();
		String usedLetters = letterList.toString();
		view.getUsedLettersField().setText(usedLetters.substring(1, usedLetters.length() - 1));
	}
	
	public void updateViewCanvas(){
		view.getHangmanCanvas().drawStandBase(view.getGraphics());
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String letter = view.getGuessText().getText();
		if(letter.length() > 1){
			return;
		}
		
		setUsedLetter(letter);
		updateLetterGuess();
		view.getWordsDisplayed().setText(model.getWordDisplay());
		view.getHangmanCanvas().drawStandBase(view.getGraphics());
		
		if(model.hasWon()){
			JOptionPane.showMessageDialog(null, "Congrats, you have won!");
		}
		
		else if(model.hasLost()){
			JOptionPane.showMessageDialog(null, "You lost!");
		}
	}
	
	public void initView(){
		view.getWordsDisplayed().setText(model.getWordDisplay());
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HangManModel hangModel = new HangManModel();
					HangManView hangView = new HangManView();
					HangManController controller = new HangManController(hangModel, hangView);
					hangView.addBtnGuessController(controller);
					controller.initView();
					
					hangView.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	
}
