package com.capgemini.StarterKit;


import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;


public class MainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final int widthFrameLW = 400;
	private final int heightFrameLW = 300;
	private int locationFrameX;
	private int locationFrameY;
	
	
	LoginPane loginPane = new LoginPane();
	CandidateChoicePane candidateChoicePane = new CandidateChoicePane();
	
	
	public MainFrame() {
    	
    	setWindowProperties();
    	setWindowLocation();
    	
    	pack();
    	this.add(loginPane);
    	this.setTitle(loginPane.getPaneName());
    	this.setLocationByPlatform(true);
        
    }
 
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
    
//    private void changePaneInFrame(JPanel newPane){
//    	
//    	this.getContentPane().removeAll();
//    	this.getContentPane().add(newPane);
//    	this.getContentPane().revalidate();
//    	
//    }
    
// public Window() {
//    	
//        //Create and set up the window.
//        JFrame frame1 = new JFrame(LoginPane.getPaneName());
//        JFrame frame2 = new JFrame(CandidateChoicePane.getPaneName());
//
//        setWindowProperties();
//        
//        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame1.setMinimumSize(new Dimension(widthFrameLW,heightFrameLW));
//        
//        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame2.setMinimumSize(new Dimension(widthFrameLW,heightFrameLW));
//        
//        LoginPane LoginPane = new LoginPane();
//        CandidateChoicePane CandidateChoicePane = new CandidateChoicePane();
//        
//        //Set up the content pane
//        frame1.add(LoginPane);
//        frame2.add(CandidateChoicePane);
//        
//        //Display the window.
//        frame1.pack();
//        frame1.setVisible(true);
//        
//        frame2.pack();
//        frame2.setVisible(true);
    

}
