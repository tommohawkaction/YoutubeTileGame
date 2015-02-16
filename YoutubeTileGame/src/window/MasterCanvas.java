package window;

import files.Assets;
import game.Game;
import input.HomeKeyListener;
import input.HomeMouseListener;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import screen.ScreenHandler;

public class MasterCanvas extends Canvas implements Runnable{
	private static final long serialVersionUID = 1L;
	
	public static final int WIDTH = 800, HEIGHT = 600;
	private Dimension defaultSize = new Dimension(WIDTH, HEIGHT);
	
	
	//-------------------
	private boolean running = false;
	private Thread gameThread = new Thread(this);
	private static final int FPSCAP = 120;
	private static int fps;
	private static int ticks;
	private static double delta;
	
	public MasterCanvas() {
		setMinimumSize(defaultSize);
		setMaximumSize(defaultSize);
		setPreferredSize(defaultSize);
		
		// Keys and Mouse
		HomeMouseListener mouse = new HomeMouseListener();
		HomeKeyListener keys = new HomeKeyListener();
		addKeyListener(keys);
		addMouseListener(mouse);
		addMouseMotionListener(mouse);
		addMouseWheelListener(mouse);
		
		setFocusable(true);
		ScreenHandler.setScreen(new Game());
	}

	public void run() {
		long mainTimer = System.nanoTime();
		double nsPerTick = 1000000000D/FPSCAP;
		long fpsTimer = System.currentTimeMillis();
		
		double delta = 0;
		int ticks = 0;
		int frames = 0;
		
		while(running){
			long timer = System.nanoTime();
			delta += (timer-mainTimer)/nsPerTick;
			mainTimer = timer;
			
			while(delta > 1){
				ticks++;
				MasterCanvas.delta = delta;
				tick(delta);
				frames++;
				render(delta);
				delta -=1;
			}
			if(System.currentTimeMillis() - fpsTimer >= 1000){
				fpsTimer+= 1000;
				fps = frames;
				MasterCanvas.ticks = ticks;
				ticks = 0;
				frames = 0;
			}
		}
		
	}
	private void tick(double delta) {
		ScreenHandler.tick(delta);
	}

	private void render(double delta) {
		BufferStrategy bs = getBufferStrategy();
		if(bs == null){
			createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		g.setColor(new Color(158,172,255));
		g.fillRect(0, 0, WIDTH, HEIGHT);
		//-----DRAW-HERE------
		ScreenHandler.render(g);
		
		g.dispose();
		bs.show();
	}

	public synchronized void start(){
		if(!running){
			running = true;
			Assets.loadAll();
			gameThread.start();
		}
	}
	public synchronized void stop(){
		if(running){
			try {
				running = false;
				gameThread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static int getFps() {
		return fps;
	}

	public static int getTicks() {
		return ticks;
	}

	public static double getDelta() {
		return delta;
	}
	

}
