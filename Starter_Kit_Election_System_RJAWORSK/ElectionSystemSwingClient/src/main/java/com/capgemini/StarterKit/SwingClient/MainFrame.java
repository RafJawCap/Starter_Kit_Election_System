package com.capgemini.StarterKit.SwingClient;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class MainFrame extends JFrame {

	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	// Class Fields
	private static final long serialVersionUID = 1L;
	
	private final int widthFrameLW = 400;
	private final int heightFrameLW = 300;
	private int locationFrameX;
	private int locationFrameY;
	
	// JPanels
	LoginPane loginPane = new LoginPane(this);
	CandidateChoicePane candidateChoicePane = new CandidateChoicePane(this);
	
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    // Constructor
	
	public MainFrame() {
    	
    	setWindowProperties();
    	pack();
    	
    	setLocationRelativeTo(null);
    	setWindowLocation();
    	
    	this.getContentPane().add(loginPane);
    	this.setTitle(loginPane.getPaneName());
        
    }
 
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    // Class methods
	
    private void setWindowProperties(){
    	
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setMinimumSize(new Dimension(widthFrameLW,heightFrameLW));
    	this.setLocation(locationFrameX, locationFrameY);
    }
    
    private void setWindowLocation(){
    	
    	Toolkit kit = Toolkit.getDefaultToolkit();
    	Dimension screensize = kit.getScreenSize();
    	
    	int screenHeight = screensize.height;
    	int screenWidth = screensize.width;
    	
    	this.locationFrameX = screenWidth/2;
    	this.locationFrameY = screenHeight/2;
    	
    }
    
    
    public void changePaneInFrame(JPanel newPane) {
    	
    	getContentPane().removeAll();
    	getContentPane().add(newPane);
    	getContentPane().revalidate();
    	
    }
    
    public void closeWindow() {
    	
    	setVisible(false);
    	dispose();
    	
    }
    
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    // Gets & Sets
    
    public void changeTitleInFrame(String string) {
    	
    	this.setTitle(string);
    	
    }

}
