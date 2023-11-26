package com;

import javax.swing.*;
import java.awt.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Random;
import java.net.*;

public class auc extends JFrame{
	
	public JTextArea area1 = new JTextArea(30, 20);;
	public String[] operations;
	
	public auc(){
        JFrame contents = new JFrame();
        
        DocumentListener listener = new DocumentListener(){
			public void removeUpdate(DocumentEvent event) {
				operations = area1.getText().split("\n");
			}
				
			public void insertUpdate(DocumentEvent event) {
				operations = area1.getText().split("\n");
			}
				
			public void changedUpdate(DocumentEvent event) {
				operations = area1.getText().split("\n");
			}
		};
		
		area1.setFont(new Font("Dialog", Font.PLAIN, 14));
        area1.setTabSize(10);
        area1.setLineWrap(true);
        area1.setWrapStyleWord(true);
        area1.getDocument().addDocumentListener(listener);
        
        JButton start = new JButton("!Start!");
        start.addActionListener(e -> {
        	contents.getContentPane().removeAll();
        	contents.revalidate();
        	contents.repaint();
        	Start_Rouilet(contents, operations);
        });
        
        contents.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        contents.pack();
        contents.setSize(1280,720);
        contents.setLayout(new BorderLayout());
        JLabel background=new JLabel(new ImageIcon("Z:\\anime_back.jpg"));
        contents.add(background);
        background.setLayout(new FlowLayout());
        background.add(start);
        background.add(area1);
        contents.setVisible(true);
	    }
	
	
	public void Start_Rouilet(JFrame frame, String [] pretend) {
		Timer timer = new Timer();
		TimerTask show_result = new TimerTask() {
			public void run() {
				Random r = new Random();
				String win = pretend[r.nextInt(pretend.length)];
				String html = "<html><body width='%1s'><h1>Winner is</h1>"
		                + "<p>" + win + "<p>";
				JOptionPane.showMessageDialog(null, String.format(html, 100, 100));
			}
		};
		try {
			JButton back = new JButton("back");
	        back.addActionListener(e -> {
	        	frame.dispose();
	        	new auc();
	        });
			URL ImageUrl =new URL("https://pa1.narvii.com/5802/652d924e79721b9d8f0c73b685cce22701b0a064_hq.gif");
		    Icon imageIcon = new ImageIcon(ImageUrl);
		    JLabel label = new JLabel(imageIcon);
		    frame.getContentPane().add(label);
		    frame.getContentPane().add(back, BorderLayout.SOUTH);
		    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    frame.pack();
		    frame.setLocationRelativeTo(null);
		    frame.setVisible(true);
		 } catch (Exception e) {
			 System.out.println(e);
		 }
		timer.schedule(show_result,1000);
	}

	public static void main(String[] args) {
		new auc();
	}
}
	
