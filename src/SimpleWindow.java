import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;

import javax.swing.*;

/**
   TODO Write a one-sentence summary of your class here.
   TODO Follow it with additional details about its purpose, what abstraction
   it represents, and how to use it.

   @author  TODO Your Name
   @version TODO Date

   Period - TODO Your Period
   Assignment - TODO Name of Assignment

   Sources - TODO list collaborators
 */
@SuppressWarnings("serial")
public class SimpleWindow extends JPanel implements MouseListener
{
  public static final int DRAWING_WIDTH = 800;
  public static final int DRAWING_HEIGHT = 600;
  public static int x,y;
  private Projectile bomb;
  public static boolean go=false;
  //private MovingImage platform;
  //boolean jumpflag, walkflagleft, walkflagright = false;
  
  public SimpleWindow () {
	  super();
	  bomb = new Projectile(0,0);
	  //platform = new MovingImage("bricks.png",200,500,400,50);
	  //setBackground(Color.CYAN);
  }

  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);  // Call JPanel's paintComponent method to paint the background

    int width = getWidth();
    int height = getHeight();
    
    
    double ratioX = (double)width/DRAWING_WIDTH;
    double ratioY = (double)height/DRAWING_HEIGHT;
    
    Graphics2D g2 = (Graphics2D)g;
    AffineTransform at = g2.getTransform();
    g2.scale(ratioX,ratioY);
    
    //platform.draw(g,this);
    bomb.draw(g,this);
    
    g2.setTransform(at);
  }

  
  /*public void keyPressed(KeyEvent e) {
  	if (e.getKeyCode() == KeyEvent.VK_LEFT) {
		// WALK LEFT
  		walkflagleft=true;
  	} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
  		// WALK RIGHT
  		walkflagright=true;
  	} else if (e.getKeyCode() == KeyEvent.VK_UP) {
  		// JUMP
  		jumpflag=true;
  	}
  }
    
  public void keyReleased(KeyEvent e) {
  	if (e.getKeyCode() == KeyEvent.VK_LEFT) {
		walkflagleft=false;
  	} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
  		walkflagright=false;
  	}
  	else if(e.getKeyCode()==KeyEvent.VK_UP)
  	{
  		jumpflag=false;
  	}
  }

  public void keyTyped(KeyEvent e) {
  	
  }*/
  
  
  public void run() {
  	while(true) {
  		JFrame w = new JFrame("Simple Window");
  	    w.setBounds(100, 100, 640, 480);
  	    w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  	    SimpleWindow panel = new SimpleWindow();
  	    w.addMouseListener(panel);
  	    w.add(panel);
  	    w.setResizable(true);
  	    w.setVisible(true); 	
  		
  		bomb.shoot();
  		bomb.move();
  		checkBomb();
  		//checkHit();
  		repaint();
  		// WAIT
  		try{
  			Thread.sleep(20);
  		}catch (InterruptedException e){
  			//TO DO Auto generated catch block
  			e.printStackTrace();
  			
  		}
  	}
  }
  
  public void checkBomb() {
  	int x = bomb.getX() + bomb.getWidth()/2;
  	int y = bomb.getY() + bomb.getHeight()/2;
  	
  	if (x < 0 || x > DRAWING_WIDTH || y < 0 || y > DRAWING_HEIGHT)
  		bomb = new Projectile(0,0);
  }
  


  // As your program grows, you may want to...
  //   1) Move this main method into its own 'main' class
  //   2) Customize the JFrame by writing a class that extends it, then creating that type of object in your main method instead
  public static void main(String[] args)
  {
    JFrame w = new JFrame("Simple Window");
    w.setBounds(100, 100, 640, 480);
    w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    SimpleWindow panel = new SimpleWindow();
    w.addMouseListener(panel);
    w.add(panel);
    w.setResizable(true);
    w.setVisible(true);
    
    panel.run();
  }

@Override
public void mouseClicked(MouseEvent e) {
	// TODO Auto-generated method stub
	go=true;
	x=e.getX();
	y=e.getY();
	
}
public static int getXMouse()
{
	return x;
}

public static int getYMouse()
{
	return y;
}

@Override
public void mousePressed(MouseEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void mouseReleased(MouseEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void mouseEntered(MouseEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void mouseExited(MouseEvent e) {
	// TODO Auto-generated method stub
	
}
}
