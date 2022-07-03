import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;
import java.awt.image.*;
import javax.imageio.*;

public class PongPanel extends JPanel{
	//Properties
	int intP1Y = 100;
	int intP1Def = 0;
	int intP2Y = 100;
	int intP2Def = 0;
	int intBallX = 400;
	int intBallY = 300;
	int intBallDefX = 4;
	int intBallDefY = 4;
	int intP1Score = 0;
	int intP2Score = 0;
	boolean blnPlay = false;
	boolean blnWin = false;
	BufferedImage winImage = null;
	BufferedImage paddleImage = null;
	BufferedImage ballImage = null;
	Font newFont = new Font("SansSerif", Font.PLAIN, 96);
	
	//Methods
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		//Draw screen
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 800, 600);
		g.setColor(Color.WHITE);
		//P1
		//Extra feature paddle images
		g.drawImage(paddleImage, 60, intP1Y, null);
		//P2
		g.drawImage(paddleImage, 740, intP2Y, null);
		//lines
		g.fillRect(395, 0, 10, 50);
		g.fillRect(395, 60, 10, 50);
		g.fillRect(395, 120, 10, 50);
		g.fillRect(395, 180, 10, 50);
		g.fillRect(395, 240, 10, 50);
		g.fillRect(395, 300, 10, 50);
		g.fillRect(395, 360, 10, 50);
		g.fillRect(395, 420, 10, 50);
		g.fillRect(395, 480, 10, 50);
		g.fillRect(395, 540, 10, 50);
		g.setFont(newFont);
		g.drawString(Integer.toString(intP1Score), 285, 95);
		g.drawString(Integer.toString(intP2Score), 450, 95);
		if(blnWin == true){
			//Extra feature win image
			g.setColor(Color.WHITE);
			g.drawImage(winImage, 200, 200, null);
			g.setFont(newFont);
			g.drawString("Press spacebar to play again", 0, 500);
			intP1Score =0;
			intP2Score =0;
		}
		

		if((intP1Score < 5 && intP2Score < 5) && blnPlay == true){
			super.paintComponent(g);
			if(intP1Score < 4 && intP1Score < 4){
				g.setColor(Color.BLACK);
				g.fillRect(0, 0, 800, 600);
			}else{
				//Extra feature background changes colour
				g.setColor(Color.BLUE);
				g.fillRect(0, 0, 800, 600);
			}
			g.setColor(Color.WHITE);
			//P1
			g.drawImage(paddleImage, 60, intP1Y, null);
			//P2
			g.drawImage(paddleImage, 740, intP2Y, null);
			//Ball
			//Extra feature ball image
			g.drawImage(ballImage, intBallX, intBallY, null);
			//Lines
			g.fillRect(395, 0, 10, 50);
			g.fillRect(395, 60, 10, 50);
			g.fillRect(395, 120, 10, 50);
			g.fillRect(395, 180, 10, 50);
			g.fillRect(395, 240, 10, 50);
			g.fillRect(395, 300, 10, 50);
			g.fillRect(395, 360, 10, 50);
			g.fillRect(395, 420, 10, 50);
			g.fillRect(395, 480, 10, 50);
			g.fillRect(395, 540, 10, 50);
			g.setFont(newFont);
			g.drawString(Integer.toString(intP1Score), 285, 95);
			g.drawString(Integer.toString(intP2Score), 450, 95);
				
			//ball movement
			intBallX = intBallX + intBallDefX;
			intBallY = intBallY + intBallDefY;
				
			if(intBallY > 590){
				intBallDefY = -4;
			}else if(intBallY < 0){
				intBallDefY = 4;
			}
				
			if(intBallX > 805){
				intP1Score += 1;
				blnPlay = false;
				intBallX = 400;
				intBallY = 300;
				g.fillRect(intBallX, intBallY, 10, 10);
				intBallDefX = 4;
			}else if(intBallX < -17){
				intP2Score += 1;
				blnPlay = false;
				intBallX = 400;
				intBallY = 300;
				g.fillRect(intBallX, intBallY, 10, 10);
				intBallDefX = -4;
			}
				
			//Left paddle collision detection
			if(intBallX <= 70 && intBallX >= 50 && intBallY > intP1Y+5 && intBallY < intP1Y + 55){
				intBallDefX = 4;
			}
				
			//Right paddle collision detection
			if(intBallX >= 730 && intBallX <= 750 && intBallY > intP2Y+5  && intBallY < intP2Y + 55){
				intBallDefX = -4;
			}
				
			//paddle movement
			if(intP1Y <= 0){
				intP1Def = +7;
				intP1Y = intP1Y + intP1Def;
			}else if(intP1Y >= 550){
				intP1Def = -7;
				intP1Y = intP1Y + intP1Def;
			}else{
				intP1Y = intP1Y + intP1Def;
			}
				
			if(intP2Y <= 0){
				intP2Def = +7;
				intP2Y = intP2Y + intP2Def;
			}else if(intP2Y >= 550){
				intP2Def = -7;
				intP2Y = intP2Y + intP2Def;
			}else{
				intP2Y = intP2Y + intP2Def;
			}
			if(intP1Score == 5 || intP2Score == 5){
				blnPlay = false;
				blnWin = true;
				intP1Score =0;
				intP2Score =0;
			}
		}
	}
	
	//Constructor
	public PongPanel(){
		super();
		try{
			winImage = ImageIO.read(new File("win.png"));
		}catch(IOException e){
			System.out.println("Invalid Picture");
		}
		try{
			paddleImage = ImageIO.read(new File("paddle.png"));
		}catch(IOException e){
			System.out.println("Invalid Picture");
		}
		try{
			ballImage = ImageIO.read(new File("ball.png"));
		}catch(IOException e){
			System.out.println("Invalid Picture");
		}
	}
	
	
}
