//Joey Gronovius, Cedric Nixon, Juhi Patel 8th Period
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.Timer;

import java.util.*;


public class Landscape extends JPanel implements ActionListener
{
  // TODO Your Instance Variables Here
	private Image sniperPic;
	private Image towerPic;
	private Image forest;
	private int times;
	boolean spawn = false;
	private ArrayList<Enemy> grunts;
	public  int score = 0;
	public  int lives = 10;
	private  javax.swing.Timer timer;

  public Landscape () {
	  super();

	  setBackground(Color.WHITE);
	  // TODO Add more customizations to the panel
	  sniperPic = (new ImageIcon("sniperPic.jpg")).getImage();
	  towerPic = (new ImageIcon("towerPic.jpg")).getImage();
	  forest = (new ImageIcon("forest.jpg")).getImage();
	  grunts = new ArrayList<Enemy>();
	 
	  timer = new Timer(1000, this);
	  timer.setInitialDelay(0);
	  timer.start(); 
  }
  
  public void update() 
  {
	    if (spawn==true)
	    {
	    	Enemy grunt = new Enemy("snoop.gif", 1100,420,150,150);
	    	grunts.add(grunt);
	 	    spawn = false;
	    }
	    if (lives > 0)
	    {
		    for(int i = 0; i < grunts.size(); i++)
		    {
		    	if (grunts.get(i).getX() >= 100) //bc 100 can't movebyamount of odd number b/c stuck at 101
			    {
		    		grunts.get(i).moveByAmount(-4,0);
			    	//repaint();
			    }
			    if (grunts.get(i).getX()== 100)
			    {
			    	grunts.get(i).swapVisibility();
			    	lives = lives - 1;
			    }
		    }
	    }
  }

  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);  // Call JPanel's paintComponent method to paint the background
    int width = getWidth();
    int height = getHeight();
	
    //double ratioX = width/800.0;
    //double ratioY = height/600.0;
    //Graphics2D g2 = (Graphics2D)g;
    //g2.scale(ratioX,ratioY);
    
    g.drawImage(forest,0,0,1200,600,this);
    g.drawImage(towerPic,-120,70,500,550,this);
    g.drawImage(sniperPic, 100, 200, 100, 100, this);
    g.setColor(Color.RED);
    Font myFont = new Font("Monospaced", Font.BOLD, 25);
    g.setFont(myFont);
    g.drawString("Lives: " + lives, 400, 50);
    g.drawString("Score: " + score, 600, 50);
    if (lives == 0)
    {
    	Font end = new Font("Monospaced", Font.BOLD, 80);
        g.setFont(end);
        g.drawString("GAME OVER",400,300);
    }
    

    for(int i = 0; i < grunts.size(); i++) 
    {
    	grunts.get(i).draw(g, this);
    }
    
  }

 
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		spawn = true;
		repaint();
	}
	/* public boolean checkHit(Projectile Projectile)
	  {
		  int x = Projectile.getX() + Projectile.getWidth()/2;
		  int y = Projectile.getY() + Projectile.getHeight()/2;
		  int nx= (int) grunt.getX(); //+ enemy.getWidth()/2;
		  	int ny = (int) this.getY(); //+ enemy.getHeight()/2;
		  	if ( x > nx && x<nx+Enemy.width && y > ny && y < ny+Enemy.height)
		  	{
		  		return true;
		  	}
		  	else
		  		return false;
	  }*/
}



