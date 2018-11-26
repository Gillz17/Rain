import java.awt.*;
import java.util.*;

public class Drop {
	
	private Random random;
	private int x, y, ySpeed, len;
	
	public Drop(){
		random = new Random();
		x = random.nextInt(Rain.width);
		y = -500 -random.nextInt(950);
		len = 4 + random.nextInt(7);
	
		if(len == 4){
			ySpeed = 1;
		}if(len == 5){
			ySpeed = 2;
		}if(len == 6){
			ySpeed = 3;
		}if(len == 7){
			ySpeed = 4;
		}if(len == 8){
			ySpeed = 5;
		}if(len == 9){
			ySpeed = 6;
		}if(len == 10){
			ySpeed = 7;
		}
	}
	
	public void update(){
		y += ySpeed;
		if(y> Rain.height){
			y = -50 -random.nextInt(450);
			if(len == 4){
				ySpeed = 1;
			}if(len == 5){
				ySpeed = 2;
			}if(len == 6){
				ySpeed = 3;
			}if(len == 7){
				ySpeed = 4;
			}if(len == 8){
				ySpeed = 5;
			}if(len == 9){
				ySpeed = 6;
			}if(len == 10){
				ySpeed = 7;
			}
		}
	}
	
	public void draw(Graphics g){
		
		if(len == 4){
			g.setColor(new Color(179,218,255));
			g.drawRect(x, y, 0, len);
		}if(len == 5 || len == 6){
			g.setColor(new Color(153,206,255));
			g.drawRect(x, y, 1, len);
			g.fillRect(x, y, 1, len);
		}if(len == 7 || len == 8 || len == 9){
			g.setColor(new Color(128,193,255));
			g.drawRect(x, y, 2, len);
			g.fillRect(x, y, 2, len);
		}if(len == 10){
			g.setColor(new Color(102,181,255));
			g.drawRect(x, y, 3, len);
			g.fillRect(x, y, 3, len);
		}
		
	}
}
