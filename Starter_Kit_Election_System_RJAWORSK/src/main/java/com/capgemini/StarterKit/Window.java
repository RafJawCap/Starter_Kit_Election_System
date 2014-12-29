package com.capgemini.StarterKit;


import java.awt.Dimension;

import javax.swing.JFrame;
// import javax.swing.JPanel;


public class Window extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// private static final String nameFrameLW = "Login";
	private static final int widthFrameLW = 400;
	private static final int heightFrameLW = 300;
	
    public Window() {
    	
        //Create and set up the window.
        JFrame frame1 = new JFrame(LoginPane.getPaneName());
        JFrame frame2 = new JFrame(CandidateChoicePane.getPaneName());

        setWindowProperties();
        
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setMinimumSize(new Dimension(widthFrameLW,heightFrameLW));
        
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setMinimumSize(new Dimension(widthFrameLW,heightFrameLW));
        
        LoginPane LoginPane = new LoginPane();
        CandidateChoicePane CandidateChoicePane = new CandidateChoicePane();
        
        //Set up the content pane
        frame1.add(LoginPane);
        frame2.add(CandidateChoicePane);
        
        //Display the window.
        frame1.pack();
        frame1.setVisible(true);
        
        frame2.pack();
        frame2.setVisible(true);
        
        
        
    }
 
    private void setWindowProperties(){
    	
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setMinimumSize(new Dimension(widthFrameLW,heightFrameLW));
    	
    }
    
//    private void changePaneInFrame(JPanel newPane){
//    	
//    	this.getContentPane().removeAll();
//    	this.getContentPane().add(newPane);
//    	this.getContentPane().revalidate();
//    	
//    }
    

}
