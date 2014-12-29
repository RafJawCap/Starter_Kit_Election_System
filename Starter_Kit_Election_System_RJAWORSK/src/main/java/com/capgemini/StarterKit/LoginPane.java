package com.capgemini.StarterKit;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LoginPane extends JPanel {
	
	/**
	 * 
	 */
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	// Class Fields
	
	private static final long serialVersionUID = 1L;
	
	// Strings
    private static final String textlabelPESEL = "Pesel";
    private static final String textFieldDefaultPesel = "PESEL";
    private static final String textlabelZipCode = "Kod pocztowy";
    private static final String textLoginButton = "Login";
    private static final String textWindow = "Login";
    
    // Numbers
    private static final Dimension sizeComboBox = new Dimension(100,20);
    private static final Dimension sizeTextField = new Dimension(150,20);
    
    //Arrays
    private static String[] arrayComboBox = {"58-316","02-212","50-362"};
    
    // JComponents
    private static JLabel labelZipCode = new JLabel(textlabelZipCode);
    private static JLabel labelPESEL = new JLabel(textlabelPESEL);
    
    private static JComboBox<String> comboboxPostalCode;
    private static JTextField textFieldPesel;
    private static JButton buttonLogin;
    
    // JPanels
    private static JPanel paneZipCode = new JPanel();
    private static JPanel panePeselField = new JPanel();
    
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    
    
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    // Constructor
    
    public LoginPane(){
    	
    	setCombobox();
    	setTextField();
    	setButton();
    	
    	createLoginWindowPane();
    	
    };
  
    
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    // Creating Main Interface
    
	private void createLoginWindowPane() {
       
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        this.add(Box.createVerticalGlue());
        this.add(addComponentsToHorizontalPane(labelZipCode, comboboxPostalCode, paneZipCode));
        		comboboxPostalCode.setMaximumSize(sizeComboBox);
  
        this.add(Box.createVerticalGlue());
        this.add(addComponentsToHorizontalPane(labelPESEL, textFieldPesel, panePeselField));
        		textFieldPesel.setMaximumSize(sizeTextField);
        
        this.add(Box.createVerticalGlue());
        this.add(buttonLogin);
        this.add(Box.createVerticalGlue());

       
    }

	private JPanel addComponentsToHorizontalPane(JComponent comp1, JComponent comp2, JPanel HorizontalPane) {

		
		HorizontalPane.setLayout(new BoxLayout(HorizontalPane, BoxLayout.X_AXIS));
 
		HorizontalPane.setAlignmentX(Component.CENTER_ALIGNMENT);
		HorizontalPane.setAlignmentX(Component.CENTER_ALIGNMENT);
        
		HorizontalPane.add(comp1);
		HorizontalPane.add(Box.createHorizontalStrut(10));
		HorizontalPane.add(comp2);
        
        return HorizontalPane;
    }

    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    // Set functionality & content in each JComponent
	
	
	
	private void setCombobox(){
		
		comboboxPostalCode = new JComboBox<String>();
		addComponentsToComboBox();
		
	}
	
	
	private void setTextField(){
		
		textFieldPesel = new JTextField(textFieldDefaultPesel);
		
		
	}
	
	private void setButton(){
		
		buttonLogin = new JButton(textLoginButton);
		buttonLogin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		
	}

	
	private void addComponentsToComboBox(){
		
	  	for (int i = 0; i < arrayComboBox.length; i++) {
			comboboxPostalCode.addItem(arrayComboBox[i]);
	  	}
	}
	
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    // Gets & Sets
	

		public static String getPaneName() {
		
			return textWindow;
		}
}