package window;

import javax.swing.JFrame;

public class Window {

	public static final String TITLE = "Tile Game";
	
	private JFrame frame;
	private MasterCanvas masterCanvas = new MasterCanvas();
	
	public Window() {
		frame = new JFrame(TITLE);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(masterCanvas);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		masterCanvas.start();
		
	}
	
	public static void main(String[] args){
		new Window();
	}
}
