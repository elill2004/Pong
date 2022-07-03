import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;


public class PongGame implements ActionListener, KeyListener{
	//Properties
	JFrame theFrame = new JFrame("Pong");
	PongPanel thePanel = new PongPanel();
	Timer theTimer = new Timer(1000/60, this);
	
	//Methods
	//Repaint panel
	public void actionPerformed(ActionEvent evt){
		if(evt.getSource() == theTimer){
			thePanel.repaint();
		}
	}
	//Use W and S to move paddle
	//Extra feature reset game
	public void keyReleased(KeyEvent evt){
		if(evt.getKeyChar() == 'w'){
			thePanel.intP1Def = 0;
		}else if(evt.getKeyChar() == 's'){
			thePanel.intP1Def = 0;
		}else if(evt.getKeyCode() == 38){
			thePanel.intP2Def = 0;
		}else if(evt.getKeyCode() == 40){
			thePanel.intP2Def = 0;
		}
	}
	
	//Use spacebar to serve, up and down to move paddle
	public void keyPressed(KeyEvent evt){
		if(evt.getKeyChar() == 32){
			thePanel.blnPlay = true;
			thePanel.blnWin = false;
		}
		if(evt.getKeyChar() == 'w'){
			thePanel.intP1Def = -7;
		}else if(evt.getKeyChar() == 's'){
			thePanel.intP1Def = +7;
		}else if(evt.getKeyCode() == 38){
			thePanel.intP2Def = -7;
		}else if(evt.getKeyCode() == 40){
			thePanel.intP2Def = +7;
		}
	}
	
	public void keyTyped(KeyEvent evt){
		
	}
	
			
		
		
	
	//Constructor
	public PongGame(){
		thePanel.setPreferredSize(new Dimension(800, 600));
		theFrame.setContentPane(thePanel);
		theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		theFrame.pack();
		theFrame.setVisible(true);
		theFrame.setResizable(false);
		theFrame.addKeyListener(this);
		theTimer.start();
	}
	
	//main method
	public static void main(String[] args){
		new PongGame();
	}
	
}
