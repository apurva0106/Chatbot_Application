package com.mod.bot;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;
import java.sql.*;

public class BotFrame extends JFrame implements ActionListener{
	JLabel label;
	JButton button1;
	
	BotFrame(){
		label=new JLabel();
		ImageIcon image=new ImageIcon("chatbots.png");
		Border border=BorderFactory.createLineBorder(Color.black,2);
		
		label.setIcon(image);
		label.setText("Hey,ask me anything :)");
		label.setVerticalTextPosition(JLabel.TOP);// set text CENTER,TOP,RIGHT
		label.setHorizontalTextPosition(JLabel.CENTER);
		label.setVerticalAlignment(JLabel.CENTER);
	    label.setHorizontalAlignment(JLabel.CENTER);
	    label.setBackground(Color.white);
	    label.setOpaque(true); //display background color.
		label.setForeground(new Color(0,0,0));//set font color
		label.setFont(new Font("MV Boli",Font.BOLD,25));
		label.setBorder(border);//sets border for label
	    label.setBounds(0, 0,520,300);      // set x,y and dimensions 500
	    
	    button1=new JButton();
		button1.setBounds(190,350,100,50); //180,350,100,50
		button1.setText("Start");
		button1.setFocusable(false);
		button1.setFont(new Font("MV Boli",Font.BOLD,23));
		
		button1.addActionListener(this);
		
		ImageIcon img=new ImageIcon("chatbots.png");
	    this.setSize(520,520);  //set size of frame  500,500
	    this.setTitle("MyChatbot");
	    this.setIconImage(img.getImage());
	    this.setLayout(null);
	    this.setLocationRelativeTo(null);
	    this.setResizable(false);//prevent from resizing
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//exit out of app
	    this.getContentPane().setBackground(new Color(106,201,207)); //51,195,255
	    this.add(label);
	    this.add(button1);
	    this.setVisible(true); //frame visible
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.dispose();
		new ChatFrame();
	}
}
