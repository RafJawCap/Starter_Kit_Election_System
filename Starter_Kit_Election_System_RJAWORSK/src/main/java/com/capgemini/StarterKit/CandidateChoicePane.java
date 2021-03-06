package com.capgemini.StarterKit;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;


public class CandidateChoicePane extends JPanel {
	/**
	 * 
	 */
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	// Class Fields
	
	private static final long serialVersionUID = 1L;
	
	// Strings
    private  final String textConfirmButton = "Zatwierdź";
    private  final String textWindow = "Okręg wyborczy";
    
    //Arrays
    
    private String[] Candidates = {"Adam Abacki", "Bronisław Babacki", "Cezary Cabacki"};
    
    // JComponents
    private JButton buttonConfirm;
    
    //JPanels
    private JPanel paneJRadioButtons = new JPanel();
    private JPanel paneConfirmButton = new JPanel();
    
    
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    // Constructor
    
    public CandidateChoicePane(){
    	
    	createCandidateChoicePane();
    	
    };
        
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    // Creating Main Interface
    
    private void createCandidateChoicePane() {
        
    	this.setAlignmentX(Box.CENTER_ALIGNMENT);
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		this.add(Box.createVerticalGlue());
		
		this.add(addJRadioButtons(paneJRadioButtons, Candidates));
		this.add(addButtonPane(paneConfirmButton));
		
        this.add(Box.createVerticalGlue());
        
    }
    
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    // Add JComponents
    
    private JPanel addButtonPane(JPanel Pane){
    	
    	buttonConfirm = new JButton(textConfirmButton);
    	buttonConfirm.setAlignmentX(CENTER_ALIGNMENT);
        Pane.add(buttonConfirm);
        Pane.add(Box.createVerticalGlue());
        
        return Pane;
    }
        
    private JPanel addJRadioButtons(JPanel Pane, String[] Candidates){
    	
    	// Pane.setAlignmentX(Box.CENTER_ALIGNMENT);
		Pane.setLayout(new BoxLayout(Pane, BoxLayout.Y_AXIS));
    	
    	ButtonGroup JRadioButtonsGroup = new ButtonGroup();
    	
    	for (int i = 0; i < Candidates.length; i++) {
        	
        	JRadioButton newJRadioButton = new JRadioButton(Candidates[i]);
        	newJRadioButton.setAlignmentX(CENTER_ALIGNMENT);
        	JRadioButtonsGroup.add(newJRadioButton);
        	Pane.add(newJRadioButton);
			Pane.add(Box.createVerticalGlue());

    	}
    	
    	Pane.add(Box.createVerticalGlue());
    	
    	return Pane;
    }
    
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    // Set JComponents functionality
    
    
//    private static void setJRadioButtonsPane(){
//    	
//    	
//    }
//
//    private static void setButtonPane(){
//    	
//    	
//    	
//    }

    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    
    // Gets & Sets
    
    public String getPaneName(){ return textWindow; }
    

    
}
