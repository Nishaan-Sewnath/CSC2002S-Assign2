
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.CountDownLatch;

import javax.swing.JButton;
import javax.swing.JPanel;

public class WordPanel extends JPanel implements Runnable {
		public static volatile boolean done;
		private WordRecord[] words;
		private int noWords;
		private int maxY;

		public void paintComponent(Graphics g) {
			
		    int width = getWidth();
		    int height = getHeight();
		    g.clearRect(0,0,width,height);
		    g.setColor(Color.red);
		    g.fillRect(0,maxY-10,width,height);

		    g.setColor(Color.black);
		    g.setFont(new Font("Helvetica", Font.PLAIN, 26));
		   //draw the words
		   repaint();
		   validate();
		   //animation must be added
		   if(done == true){
		    for (int i=0;i<noWords;i++){	    	
		    	//g.drawString(words[i].getWord(),words[i].getX(),words[i].getY());	
		    	g.drawString(words[i].getWord(),words[i].getX(),words[i].getY()+20);	//y-offset for skeleton so that you can see the words	
		   	//words[i].setPos(words[i].getX(), words[i].getY());
			repaint();
			validate();

		    }

		  }
		  }
		
		WordPanel(WordRecord[] words, int maxY) {
			this.words=words; //will this work?
			//super(words) = words;
			noWords = words.length;
			done=false;
			this.maxY=maxY;		
		}


		@Override
		public void run() {
			//add in code to animate this
			while(done == true){
				repaint();
				for(int j = 0 ; j<noWords;j++){
					words[j].drop(words[j].getSpeed());
					words[j].setPos(words[j].getX(), words[j].getY());
					
					if(words[j].dropped()){

						

					}
					repaint();
					validate();
	
				}

				//JPanel.repaint();
				//JPanel.validate();
				
			}


			//words.matchWord(words.getWord());
		}

	}


