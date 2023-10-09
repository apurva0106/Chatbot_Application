package com.mod.bot;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.*;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;

public class ChatFrame extends JFrame implements ActionListener{

    JButton button;
    JTextArea textArea; 
    JTextField textField;
	
	ChatFrame(){
        Border border = BorderFactory.createLineBorder(Color.gray,2); 
		JPanel textAreaPanel = new JPanel();
		BotDB.startConnection(); //static method call	
		textArea = new JTextArea(13,45); // 20,60 -10,40 
		textArea.setBorder(border);
		textArea.setBackground(new Color(255,250,250));  //255,250,255
		textArea.setFont(new Font("MV Boli",Font.PLAIN,20)); 
		textArea.setEditable(false);
		JScrollPane areaScroller = new JScrollPane(textArea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		textAreaPanel.add(areaScroller);
			
		textField = new JTextField(35);  //42,31
		textField.setText("Type here");
		textField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(textField.getText().equals("Type here")){
						textField.setText("");	
						textField.setForeground(Color.black);
			}
		 }
		});
		
		textField.addActionListener(this); 
		textField.setBorder(border);
		textField.setBackground(new Color(255,250,245));
		textField.setFont(new Font("MV Boli",Font.PLAIN,25)); //Monospaced changes all layout
		
		button = new JButton("Submit");
		button.setSize(100,100);  
		button.setFocusable(false);
		button.addActionListener(this);
		button.setBackground(Color.blue); //210,210,210
		button.setForeground(Color.white);
		button.setFont(new Font("MV Boli",Font.PLAIN,20));
		

		ImageIcon img=new ImageIcon("chatbots.png");
		this.setTitle("My ChatBot"); //sets title of the frame
		this.setIconImage(img.getImage()); //sets icon for the bot
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exit out of application (by default hide on close)
		this.setLayout(null);		
		this.setSize(850,590); // sets the x-dimension, and y-dimension of frame -added 800,500				
		this.setLocationRelativeTo(null);  // bye default frame in center		
		this.setResizable(false);
		ImageIcon image = new ImageIcon("chatbot logo.png"); //create an ImageIcon
		this.setIconImage(image.getImage()); //change the icon of frame
		this.setContentPane(textAreaPanel);
		this.add(textField);
		this.add(button);
		this.setVisible(true); 
	 // this.setExtendedState(JFrame.MAXIMIZED_BOTH);	
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==textField || e.getSource()==button) { 
		    String gText = textField.getText().toLowerCase();
			textArea.append("You -> "+gText+"\n");
			textField.setText("");
			 
			String getResponse= BotDB.queryDatabase(gText);
			textArea.append("Bot -> "+getResponse+"\n");  
						  				
		}
	}	
}	
	
	
	
	
	
	
	
	
	
	
	
	
	



	
	

	
