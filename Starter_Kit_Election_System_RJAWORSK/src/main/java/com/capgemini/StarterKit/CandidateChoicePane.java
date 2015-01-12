package com.capgemini.StarterKit;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JOptionPane;
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
    private  final static String textWindow = "Okręg wyborczy";
    
    //Arrays
    
    private String[] candidates = {"Adam Abacki", "Bronisław Babacki", "Cezary Cabacki", "Damian Dabacki"};
    
    // JComponents
    private JButton buttonConfirm;
	private ButtonGroup jRadioButtonsGroup = new ButtonGroup();
	
    //JPanels
    private JPanel paneJRadioButtons = new JPanel();
    private JPanel paneConfirmButton = new JPanel();
    
    private MainFrame mainFrame;
    
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    
    // Selected ones
    private static String selectedCandidate = "";
    
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    // Constructor
    
    public CandidateChoicePane(MainFrame mainFrame){
    	
    	this.mainFrame = mainFrame;
    	
    	createCandidateChoicePane();
    	
    };
        
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    // Creating Main Interface
    
    private void createCandidateChoicePane() {
        
    	this.setAlignmentX(Box.CENTER_ALIGNMENT);
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		this.add(Box.createVerticalGlue());
		
		this.add(setJRadioButtonsPane(paneJRadioButtons, getJRadioButtonsGroup(), candidates));
		this.add(setButtonPane(paneConfirmButton));
		
        this.add(Box.createVerticalGlue());
        
    }
    
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    // Add JComponents  & set functionality
    
    private JPanel setButtonPane(JPanel Pane){
    	
    	buttonConfirm = new JButton(textConfirmButton);
    	buttonConfirm.setAlignmentX(CENTER_ALIGNMENT);
    	buttonConfirm.setEnabled(false);
    	buttonConfirm.addActionListener(getButtonConfirmActionListener());
        Pane.add(buttonConfirm);
        Pane.add(Box.createVerticalGlue());
        
        return Pane;
    }
        
    private JPanel setJRadioButtonsPane(JPanel Pane, ActionListener actionListener, String[] Candidates){
    	
    	Pane.setAlignmentX(Box.CENTER_ALIGNMENT);
		Pane.setLayout(new BoxLayout(Pane, BoxLayout.Y_AXIS));
    	
    	for (int i = 0; i < Candidates.length; i++) {
    		
        	JRadioButton newJRadioButton = new JRadioButton(Candidates[i]);
        	newJRadioButton.setAlignmentX(LEFT_ALIGNMENT);
        	newJRadioButton.addActionListener(actionListener);
        	jRadioButtonsGroup.add(newJRadioButton);
        	Pane.add(newJRadioButton);
			Pane.add(Box.createVerticalGlue());
    	}
    	
    	Pane.add(Box.createVerticalGlue());
    	
    	return Pane;
    }

	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    // Set ActionListeners & Adapters
    
	 private ActionListener getJRadioButtonsGroup() {
			
	    	return new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					if(e.getSource() instanceof JRadioButton){
			            
						JRadioButton radioButton = (JRadioButton) e.getSource();
			            	if(radioButton.isSelected())
			            		{
			            			selectedCandidate = radioButton.getText();
			            			buttonConfirm.setEnabled(true);
			            		}
			            
			        }
			    }

			
		};
	}
	 
	 private ActionListener getButtonConfirmActionListener() {

			return new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					if(selectedCandidate.length() != 0)
					{
					
					JOptionPane.showMessageDialog(null, "Wybrałeś okręg wyborczy:  " + LoginPane.selectedPostalCode
													+ "\nWprowadziłeś PESEL:  " + LoginPane.userPesel
													+ "\n\nWybrałeś kandydata:  " + selectedCandidate + "\n\n",
													"Informacja", JOptionPane.INFORMATION_MESSAGE);
					
//					jRadioButtonsGroup.clearSelection();
//					buttonConfirm.setEnabled(false);
					mainFrame.closeWindow();
					}
				}
			};

	}
	 

    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    // Gets & Sets
    
    public static String getPaneName(){ return textWindow; }
    
    public static String getSelectedCandidate(){ return selectedCandidate; }

    
}
