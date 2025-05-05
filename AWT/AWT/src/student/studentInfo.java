package student;
import java.awt.*;
import java.awt.event.*;

public class studentInfo extends WindowAdapter implements ActionListener {
	Frame f;
	Label name,roll,sub1,sub2,sub3,sub4;
	TextField fname,froll,fsub1,fsub2,fsub3,fsub4;
	Button b1,b2;
	public studentInfo() {
		f=new Frame();
		f.setSize(500,500);
		f.setTitle("Studentinfo");
		f.setLayout(null);
		f.setLocationRelativeTo(null);
		init();
		add_component();
		register();
		f.setVisible(true);
		
	}
	
	public void init() {
		Font font=new Font("Arial",Font.BOLD,15);
		name=new Label(" Student Name:");
		roll=new Label("Roll No:");
		
		sub1=new Label("Sub1:");
		sub2=new Label("Sub2:");
		sub3=new Label("Sub3:");
		sub4=new Label("Sub4:");
		
		fname=new TextField();
		froll=new TextField();
		
		fsub1=new TextField();
		fsub2=new TextField();
		fsub3=new TextField();
		fsub4=new TextField();
		
		b1=new Button("Show Result");
		b2=new Button("Reset");
		
		name.setBounds(50,50,120,30);
		roll.setBounds(50,90,120,30);
		sub1.setBounds(50,130,120,30);
		sub2.setBounds(50,170,120,30);
		sub3.setBounds(50,210,120,30);
		sub4.setBounds(50,250,120,30);
		
		fname.setBounds(180,50,200,30);
		froll.setBounds(180,90,200,30);
		fsub1.setBounds(180,130,200,30);
		fsub2.setBounds(180,170,200,30);
		fsub3.setBounds(180,210,200,30);
		fsub4.setBounds(180,250,200,30);
		
		b1.setBounds(50, 360, 100, 40);
		b2.setBounds(180, 360,100 , 40);
		
		
		
	}
	public void add_component() {
		f.add(name);
		f.add(roll);
		f.add(sub1);
		f.add(sub2);
		f.add(sub3);
		f.add(sub4);
		f.add(fname);
		f.add(froll);
		f.add(fsub1);
		f.add(fsub2);
		f.add(fsub3);
		f.add(fsub4);
		f.add(b1);
		f.add(b2);
		
	}
	public void register() {
		f.addWindowListener(this);
		b1.addActionListener(this);
		b2.addActionListener(this);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		Object src=e.getSource();
		if(src==b1) {
			String name=fname.getText().trim();
			String roll=froll.getText().trim();
			String s1=fsub1.getText().trim();
			String s2=fsub2.getText().trim();
			String s3=fsub3.getText().trim();
			String s4=fsub4.getText().trim();
			
			if(!name.matches("[a-zA-Z]+")) {
		         showDialog("Invalid Name! Only letters and spaces allowed.");
		          return;
			}
			if(!roll.matches("\\d+")) {
	            showDialog("Invalid Roll Number! Only digits allowed.");
	            return;
			}
	        if (!s1.matches("\\d+") || !s2.matches("\\d+") || !s3.matches("\\d+")
	                || !s4.matches("\\d+") ) {
	            showDialog("Marks must be numeric only.");
	            return;
	        }
	        
	        int m1=Integer.parseInt(s1);
	        int m2=Integer.parseInt(s2);
	        int m3=Integer.parseInt(s3);
	        int m4=Integer.parseInt(s4);
	        
	        int total=m1+m2+m3+m4;
	        double avg=total/4.0;
	        
	        String res="";
	        
	        if(avg>=40.00) {
	        	res="pass";
	        }
	        else {
	        	res="fail";
	        }
	        
	        Frame resultFrame=new Frame();
	        resultFrame.setSize(450, 400);
	        resultFrame.setLayout(null);
	        resultFrame.setTitle("Student Result");
	        resultFrame.setBackground(Color.gray);
	        resultFrame.setLocationRelativeTo(null);
	        
	        Label res1=new Label("Student name:"+name);
	        res1.setFont(new Font("Arial",Font.BOLD,15));
	        res1.setBounds(50,50,350,30);
	        
	        Label res2 = new Label("Roll No: " + roll);
	        res2.setFont(new Font("Arial", Font.BOLD, 16));
	        res2.setBounds(50, 90, 350, 30);
	        
	        Label res3 = new Label("Total Marks: " + total);
	        res3.setFont(new Font("Arial", Font.BOLD, 16));
	        res3.setBounds(50, 130, 350, 30);

	        Label res4 = new Label("Average Marks: " + avg);
	        res4.setFont(new Font("Arial", Font.BOLD, 16));
	        res4.setBounds(50, 170, 350, 30);

	        Label res5 = new Label("Result: " + res);
	        res5.setFont(new Font("Arial", Font.BOLD, 16));
	        res5.setBounds(50, 210, 350, 30);
	        
	        resultFrame.add(res1);
	        resultFrame.add(res2);
	        resultFrame.add(res3);
	        resultFrame.add(res4);
	        resultFrame.add(res5);
	        
	        resultFrame.setVisible(true);
	        
	        resultFrame.addWindowListener(new WindowAdapter() {
	        	public void windowClosing(WindowEvent e) {
	        		resultFrame.dispose();
					
				}
			});
	        
			
			
		}
		
		else if(src==b2) {
			fname.setText("");
			froll.setText("");
			fsub1.setText("");
			fsub2.setText("");
			fsub3.setText("");
			fsub4.setText("");
			
			
		}
	}
	
	public void showDialog(String msg) {
		Dialog d=new Dialog(f,"Error",true);
		d.setSize(300,100);
		d.setLayout(new BorderLayout());
		
		Label l=new Label(msg,Label.CENTER);
		Button ok=new Button("OK");
		
		ok.addActionListener(e->d.dispose());
		
		d.add(l,BorderLayout.CENTER);
		d.add(ok,BorderLayout.SOUTH);
		d.setLocationRelativeTo(f);
		d.setVisible(true);
		
	}
	
	public void windowClosing(WindowEvent e) {
		f.dispose();
	}
	public static void main(String args[]) {
		new studentInfo();
	}

}