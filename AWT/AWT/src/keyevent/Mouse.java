package keyevent;

import java.awt.*;
import java.awt.event.*;
public class Mouse extends WindowAdapter implements MouseListener {
    Frame f;
    Label l1,l2;
    TextArea t1;
    public Mouse(){
        f=new Frame();
        f.setSize(500,500);
        f.setLayout(null);
        f.setTitle("MouseEvent");
        f.setLocationRelativeTo(null);
        init();
        add_component();
        register();
       
        f.setVisible(true);
 }
    public void init(){
        l1=new Label("MouseListener Event");
        l1.setBounds(150, 80, 200, 50);
        l2=new Label();
        l2.setBounds(150, 180, 200, 50);
        t1=new TextArea();
        t1.setBounds(120, 300, 250, 75);

    }
    public void add_component(){
        f.add(l1);
        f.add(l2);
        f.add(t1);

    }
    public void register(){
        f.addWindowListener(this);
        t1.addMouseListener(this);

    }
    public void windowClosing(WindowEvent e){
        f.dispose();
    }
    public void mouseClicked(MouseEvent e){
        l2.setText("Mouse clicked");
        t1.setBackground(Color.cyan);

    }
    public void mouseEntered(MouseEvent e){
        l2.setText("mouse entred");
        t1.setBackground(Color.orange);

    }
    public void mouseExited(MouseEvent e){
        l2.setText("mouse exited");
        t1.setBackground(Color.GRAY);

    }
    public void mousePressed(MouseEvent e){
        l2.setText("mouse pressed");
        t1.setBackground(Color.BLUE);


    }
    public void mouseReleased(MouseEvent e){
        l2.setText("mouse released");
        t1.setBackground(Color.GREEN);

    }
    
    public static void main(String[] args) {
        new Mouse();
    }
    
}