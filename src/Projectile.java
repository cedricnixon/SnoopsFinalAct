
public class Projectile extends MovingImage {

	int x0,y0; 
	double velx, vely;
	boolean hasclicked=false;
	public Projectile(int x,int y)
	{
		super("bomb.png", x, y,50,50);
		velx=0;
		vely=0;
	}
	
	public void shoot()
	{
		//if(SimpleWindow.go)
		
			int distX = SimpleWindow.getXMouse() - getX();
			int distY = SimpleWindow.getYMouse() - getY();
		double angle = Math.atan2(distY, distX);
		if(SimpleWindow.go && hasclicked == false) {
			//while(this.getX()!=640)
			velx= (5*Math.cos(angle));
			vely= (5*Math.sin(angle));
			
			hasclicked=true;
		}
		
	}
	
	
	

	public void move() {
		moveByAmount((int)velx,(int)vely);
	}
		
	}
	
	
	
