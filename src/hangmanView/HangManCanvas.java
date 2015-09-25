package hangmanView;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;


public class HangManCanvas extends JPanel{

	public void drawStandBase(Graphics g){
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawLine(20, 350, 300, 350);
	}
	
	public void drawStandLeft(Graphics g){
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawLine(20, 350, 20, 20);
	}
	
	public void drawStandTop(Graphics g){
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawLine(20, 20, 170, 20);
	}
	
	public void drawNoose(Graphics g){
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawLine(170, 40, 170, 20);
	}
	
	public void drawHead(Graphics g){
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawOval(140, 40, 60, 60);
	}
	
	public void drawBody(Graphics g){
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawLine(170, 100, 170, 240);
	}
	
	public void drawLegLeft(Graphics g){
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawLine(110, 310, 170, 240);
	}
	
	public void drawLegRight(Graphics g){
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawLine(230, 310, 170, 240);
	}
	
	public void drawArmLeft(Graphics g){
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawLine(110, 100, 170, 170);
	}
	
	public void drawArmRight(Graphics g){
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawLine(230, 100, 170, 170);
	}
	
	public void drawEyes(Graphics g){
		Graphics2D g2d = (Graphics2D) g;
		//left eye
		g2d.drawLine(155, 60, 165, 70);
		g2d.drawLine(165, 60, 155, 70);
		
		//right eye
		g2d.drawLine(175, 60, 185, 70);
		g2d.drawLine(185, 60, 175, 70);
	}
	
}
