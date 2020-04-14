import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Screen extends Canvas implements Runnable, MouseListener, ActionListener, ChangeListener{

	public final int width = 600;
	public final int height = 600;

	private boolean running = false;
	private Thread thread;
	private JPanel p;
	Main m;
	JFrame frame;
	Graphics g;

	public static void main(String[] args){


		Screen s = new Screen();


		s.init();
		s.start();
	}

	private void init() {
		m = new Main(width,height);

		frame = new JFrame();
		frame.setResizable(false);
		frame.add(this);
		frame.pack();
		frame.setSize(width,height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		//frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		//frame.setUndecorated(true);
		frame.setVisible(true);

	}

	public synchronized void start(){

		running = true;
		thread = new Thread(this, "Display");
		thread.start();
	}

	public synchronized void stop(){
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		m.setup();
		while(running){
			m.update();

			render();

			try {
				thread.sleep(0);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	private void render() {
		BufferStrategy bs = getBufferStrategy();
		if(bs == null){
			createBufferStrategy(3);
			return;
		}

		g = bs.getDrawGraphics();

		g.setColor(Color.black);
		g.fillRect(0, 0, width, height);
		m.show(g);
		g.dispose();
		bs.show();
	}


	@Override
	public void stateChanged(ChangeEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}



}
