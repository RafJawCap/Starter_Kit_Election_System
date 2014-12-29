package com.capgemini.StarterKit;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.ParseException;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

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
    
    // Selected ones
    
    private static String selectedPostalCode;
    private static String userPesel;
    
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
		comboboxPostalCode.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				selectedPostalCode = (String) comboboxPostalCode.getSelectedItem();
				
				
			}
		});
		
	}
	
	
	private void setTextField(){
		
//		try {
//			
//			textFieldPesel = new JFormattedTextField(new MaskFormatter("###########"));
//		} 
//		
//		catch (ParseException e1) {
//			
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		
		textFieldPesel = new JTextField(textFieldDefaultPesel);
		textFieldPesel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				userPesel = (String) textFieldPesel.getText();
			
				
			}
		});
		
		textFieldPesel.addKeyListener(new KeyAdapter() {
		    
			@Override
			public void keyTyped(KeyEvent e) {
		      
				char c = e.getKeyChar();
					if (!((c >= '0') && (c <= '9') ||
							(c == KeyEvent.VK_BACK_SPACE) ||
							(c == KeyEvent.VK_DELETE))) {
						getToolkit().beep();
						e.consume();
		      }
		    }
		  });
	}
	
	private void setButton(){
		
		buttonLogin = new JButton(textLoginButton);
		//buttonLogin.setEnabled(false);
		buttonLogin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				JOptionPane.showMessageDialog(null, "Wybrałeś kod: " + selectedPostalCode
						+ "\nWybrałeś PESEL: " + userPesel);
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