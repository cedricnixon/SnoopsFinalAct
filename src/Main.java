import javax.swing.JFrame;



public class Main {
	private static Landscape panel;
	public static SimpleWindow project;
	
	public static void main(String[] args)
	  {
		
	    JFrame w = new JFrame("Simple Window");
	    w.setBounds(100, 100, 1200, 600); //starts at 100,100 & window size 800,800							
	    w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    panel = new Landscape();
	    project = new SimpleWindow();
	
	    w.add(panel);
	    w.setResizable(false);
	    w.setVisible(true);
	    start();
	  }
	
	private static void start() {
		while (true) {
			// update game
			panel.update();
			project.run();
			// repaint
			panel.repaint();
	        		
			
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
