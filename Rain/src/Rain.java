import java.awt.*;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Rain extends Canvas implements Runnable{
	
	public static final int width = 2000, height = 1000, dropCount = 10000;
	public boolean running = false;
	public Thread thread;
	public Drop[] d = new Drop[dropCount];
	
	public Rain(){
		for(int i = 0; i < dropCount; i++){
			d[i] = new Drop();
		}
	}
	
	public synchronized void start(){
		if(running){
			return;
		}
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	
	public void run(){
		while(running){
			update();
			render();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {}
		}
		stop();
	}
	
	private void update(){
		for(int i = 0; i < dropCount; i++){
			d[i].update();
		}
	}
	
	private void render(){
		BufferStrategy bs = getBufferStrategy();
		if(bs == null){
			createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		g.setColor(new Color(240,248,255));
		g.fillRect(0,0,width,height);
		
		for(int i = 0; i < dropCount; i++){
			d[i].draw(g);
		}
		
		g.dispose();
		bs.show();
	}
	
	public void stop(){
		if(!running){return;}
		running = false;
		try{
			thread.join();
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
	
	
	
	public static void main(String[] args) {
		Rain app = new Rain();
		JFrame frame = new JFrame("Rain");
		frame.add(app);
		frame.setVisible(true);
		frame.setSize(2000,1000);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.start();
	}
}
