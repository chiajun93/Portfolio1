package hangmanView;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.image.ImageObserver;
import java.io.FileNotFoundException;
import java.text.AttributedCharacterIterator;

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
import java.awt.ScrollPane;


public class HangManView extends JFrame{
	private JMenuBar menuBar;
	private JPanel contentPane;
	private JTextField textFieldGuess;
	private JTextPane usedLetters;
	private JPanel drawField, panel_Phrase;
	private JButton btnGuess;
	private JTextArea textAreaGuesses;
	private HangManCanvas hangmanCanvas;
	

	public HangManView() throws FileNotFoundException {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		
		menuBar = new JMenuBar();
		menuBar.setToolTipText("");
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmOpenDictionary = new JMenuItem("Open Dictionary");
		mnFile.add(mntmOpenDictionary);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mnFile.add(mntmExit);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_WordWindow = new JPanel();
		panel_WordWindow.setBounds(10, 382, 674, 57);
		contentPane.add(panel_WordWindow);
		panel_WordWindow.setLayout(null);
		
		usedLetters = new JTextPane();
		usedLetters.setBounds(10, 11, 609, 35);
		panel_WordWindow.add(usedLetters);
		
		JPanel panel_Graphic = new JPanel();
		panel_Graphic.setBounds(339, 11, 345, 360);
		contentPane.add(panel_Graphic);
		panel_Graphic.setLayout(null);
		
		hangmanCanvas = new HangManCanvas();
		hangmanCanvas.setBounds(0, 0, 345, 360);
		panel_Graphic.add(hangmanCanvas);
		
		// Create a drawing field
//		drawField = new JPanel(){
//			public void paint(Graphics g) {
//				Graphics2D g2d = (Graphics2D) g;
//				//head
//				g2d.drawOval(130, 100, 60, 60);
//				//neck
//				g2d.drawLine(160, 161, 160, 200);
//				//left hand
//				g2d.drawLine(110, 210, 160, 200);
//				//right hand
//				g2d.drawLine(210, 210, 160, 200);
//				//body
//				g2d.drawLine(160, 200, 160, 250);
//				//left leg
//				g2d.drawLine(110, 280, 160, 250);
//				//right leg
//				g2d.drawLine(210, 280, 160, 250);
//			}
//		};
//		drawField.setBounds(0, 0, 345, 360);
//		panel_Graphic.add(drawField);
//		drawField.setLayout(null);
		
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
		textAreaGuesses.setBounds(10, 11, 299, 262);
		panel_Phrase.add(textAreaGuesses);
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
	
	public HangManCanvas getHangmanCanvas(){
		return hangmanCanvas;
	}
}
