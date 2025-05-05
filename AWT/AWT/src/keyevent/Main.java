package keyevent;
import java.awt.*;
import java.awt.event.*;

public class Main extends WindowAdapter implements KeyListener{
	
	Frame f;
	Label lb1,lb2;
	TextArea txt;
	Main()
	{
		f=new Frame();
		f.setLayout(null);
		f.setSize(500,300);
		f.setTitle("keyListener");
		f.setLocationRelativeTo(null);
		f.setVisible(true);
		
		init();
		add_component();
		register();
	}
	void init()
	{
		lb1=new Label("TextArea event handling");
		lb1.setBounds(150, 80, 200, 50);
		lb2=new Label();
		lb2.setBounds(150, 330, 200, 50);
		txt=new TextArea();
		txt.setBounds(120, 180, 250, 75);
	}
	void add_component()
	{
		f.add(lb1);
		f.add(txt);
		f.add(lb2);
		}
	void register()
	{
		f.addWindowListener(this);
		txt.addKeyListener(this);
	}
	public void keyPressed(KeyEvent e)
	{
		lb2.setText("key presseed= "+e.getKeyChar());
	}
	public void keyTyped(KeyEvent e)
	{
		lb2.setText("key Typed= "+e.getKeyChar());
	}
	public void keyReleased(KeyEvent e)
	{
		lb2.setText("key Released= "+e.getKeyChar());
	}
	public void windowClosing(WindowEvent e)
	{
		f.dispose();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();

	}

}
