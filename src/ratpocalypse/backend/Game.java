package ratpocalypse.backend;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import ratpocalypse.backend.states.StateManager;
import ratpocalypse.display.Display;
import ratpocalypse.display.gfx.Assets;

public class Game implements Runnable {
	
	private boolean running = false;
	private String title;
	private int width, height;
	
	private Display display;
	private BufferStrategy bs;
	private Graphics g;
	
	//States
	
	private String stateName;
	
	//Listeners
	private KeyboardManager keyManager;
	private MouseManager mouseManager;
	
	//Managers
	private EntityManager entityManager;
	private GameVariableManager gvmanager;
	private StateManager stateManager;
	
	//Handler
	private Handler handler;	
	
	private Thread thread;

	public Game(String title, int width, int height) {
		this.height=height;
		this.width=width;
		this.title=title;
	}
	
	private void init() {
		handler = new Handler(this);

		keyManager = new KeyboardManager();
		mouseManager = new MouseManager(handler);
		
		entityManager = new EntityManager(handler);
		gvmanager = new GameVariableManager();
		setStateMenager(new StateManager(handler));
		
		display = new Display(title, width, height);
		display.getFrame().addKeyListener(keyManager);
		display.getFrame().addMouseListener(mouseManager);
		display.getFrame().addMouseMotionListener(mouseManager);
		display.getCanvas().addMouseListener(mouseManager);
		display.getCanvas().addMouseMotionListener(mouseManager);
		Assets.init();
		
		StateManager.setState("menu");
	}
	
	private void tick() {
		
		if(StateManager.getState() != null)
			StateManager.getState().tick();
	}
	
	private void render() {
		bs = display.getCanvas().getBufferStrategy();
		if (bs==null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		
		g = bs.getDrawGraphics();
		g.clearRect(0, 0, width, height);
		
		if(StateManager.getState() != null)
			StateManager.getState().render(g);

		g.setColor(Color.yellow);
		g.drawString(
				GameVariableManager.yellowRoses+" żółtych róż", 
				0, 
				10);
		bs.show();
		g.dispose();
	}
	
	public void run() {
		
		init();
		
		int fps = 60;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		
		long timer = 0;
		long ticks = 0;
		
		while(running)
		{
			now = System.nanoTime();
			delta += (now - lastTime)/timePerTick;
			timer += (now - lastTime);
			lastTime = now;
			
			if (delta>=1) {
				tick();
				render();
				ticks++;
				delta--;
			}
			
			if (timer >= 1000000000) {
				System.out.println("Ticks and Frames: "+ticks);
				ticks=0;
				timer=0;
			}
			
		}
		
		stop();
	}
	
	public synchronized void start() {
		if (running) {
			return;
		}
		
		running = true;
		thread = new Thread(this);
		thread.start();

	}
	
	private synchronized void stop() {
		if (!running) {
			return;
		}
		
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public KeyboardManager getKeyManager() {
		return keyManager;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public MouseManager getMouseManager() {
		return mouseManager;
	}

	public void setMouseManager(MouseManager mouseManager) {
		this.mouseManager = mouseManager;
	}

	public void setKeyManager(KeyboardManager keyManager) {
		this.keyManager = keyManager;
	}

	public Display getDisplay() {
		return display;
	}

	public void setDisplay(Display display) {
		this.display = display;
	}

	public Graphics getG() {
		return g;
	}

	public void setG(Graphics g) {
		this.g = g;
	}

	public GameVariableManager getGvmanager() {
		return gvmanager;
	}

	public void setGvmanager(GameVariableManager gvmanager) {
		this.gvmanager = gvmanager;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public StateManager getStateMenager() {
		return stateManager;
	}

	public void setStateMenager(StateManager stateManager) {
		this.stateManager = stateManager;
	}

}
